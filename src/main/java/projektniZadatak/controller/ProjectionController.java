package projektniZadatak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projektniZadatak.entity.Movie;
import projektniZadatak.entity.Projection;
import projektniZadatak.entity.User;
import projektniZadatak.entity.Viewer;
import projektniZadatak.entity.dto.ProjectionDTO;
import projektniZadatak.service.MovieService;
import projektniZadatak.service.ProjectionService;
import projektniZadatak.service.UserService;
import projektniZadatak.service.ViewerService;


import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/projection")
public class ProjectionController {
    @Autowired
    private ProjectionService projectionService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ViewerService viewerService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<ProjectionDTO>> findProjection(@PathVariable(name = "id") Long id){

        List<Projection>projections = projectionService.findAllByMovieId(id);
        List<ProjectionDTO> projectionsDTO = new ArrayList<ProjectionDTO>();
        for(Projection projection:projections){
            Movie movie = movieService.findById(id);
            ProjectionDTO projectionDTO = new ProjectionDTO(movie.getTitle(),projection.getDay(),projection.getPrice(),projection.getFree(), projection.getId());

            System.out.println(projectionDTO);
            projectionsDTO.add(projectionDTO);
        }
        return new ResponseEntity<List<ProjectionDTO>>(projectionsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/reservation/{projectionId}&{userId}")
    public ResponseEntity<ProjectionDTO> ticketReservation(@PathVariable(name = "projectionId") Long projectionId, @PathVariable(name = "userId")Long userId){
        System.out.println(projectionId +" "+ userId);
        Projection projection = projectionService.findById(projectionId);
        projection.setFree(projection.getFree() - 1);

        List<Viewer> viewers =  projection.getViewers();
        for(Viewer viewer: viewers){
            if(viewer.getId() == userId){
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }
        System.out.println(viewers);
        Viewer viewer = viewerService.find(userId);
        viewers.add(viewer);
        projectionService.save(projection);
        System.out.println(viewers);
        ProjectionDTO projectionDTO = new ProjectionDTO("nebitno",projection.getDay(),projection.getPrice(),projection.getFree(),projection

                .getId());

        return new ResponseEntity<ProjectionDTO>(projectionDTO, HttpStatus.OK);
    }





}
