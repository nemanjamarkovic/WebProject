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
import projektniZadatak.entity.Viewer;
import projektniZadatak.entity.WatchedMovie;
import projektniZadatak.entity.dto.MovieDTO;
import projektniZadatak.entity.dto.ProjectionDTO;
import projektniZadatak.service.MovieService;
import projektniZadatak.service.ProjectionService;
import projektniZadatak.service.ViewerService;
import projektniZadatak.service.WatchedMovieService;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/viewer")
public class ViewerController {
    @Autowired
    private ProjectionService projectionService;
    @Autowired
    private ViewerService viewerService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private WatchedMovieService watchedMovieService;


    @GetMapping(value = "/allreservations/{userId}")
    public ResponseEntity<List<ProjectionDTO>> findUserReservations(@PathVariable(name = "userId")Long id){
        Viewer viewer = viewerService.find(id);
        List<ProjectionDTO>ticketsDTO = new ArrayList<ProjectionDTO>();
        List<Projection> reservedTickets = viewer.getReservedTickets();


        for(Projection ticket: reservedTickets){
            ProjectionDTO ticketDTO = new ProjectionDTO(ticket.getMovie().getTitle(),ticket.getDay(),ticket.getPrice(),ticket.getFree(),ticket.getId());
            ticketsDTO.add(ticketDTO);
        }
        System.out.println(id);
        return new ResponseEntity<List<ProjectionDTO>>(ticketsDTO, HttpStatus.OK);
    }

    @GetMapping(value ="/removereservation/{userId}&{projectionId}")
    public ResponseEntity removeReservation(@PathVariable(name ="userId")Long userId, @PathVariable(name = "projectionId") Long projectionId){
        Projection projection = projectionService.findById(projectionId);
        Viewer viewer = viewerService.find(userId);
        projection.getViewers().remove(viewer);
        projection.setFree(projection.getFree() + 1);
        projectionService.save(projection);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/allwatchedmovies/{viewerId}")
    public ResponseEntity<List<MovieDTO>> findAllWatchedMovies(@PathVariable(name = "viewerId")Long id){
        Viewer viewer = viewerService.find(id);
        List<WatchedMovie>watchedMovies =viewer.getWatchedMovies();
        System.out.println(watchedMovies);
        List<MovieDTO> moviesDTO = new ArrayList<MovieDTO>();

        for(WatchedMovie watchedMovie : watchedMovies){
            Movie movie = watchedMovie.getMovie();
            MovieDTO movieDTO = new MovieDTO(movie.getTitle(),movie.getDescription(),movie.getGenre(),movie.getDuration(),movie.getDate(),watchedMovie.getRating(),movie.getId());
            moviesDTO.add(movieDTO);
        }
        return new ResponseEntity<List<MovieDTO>>(moviesDTO,HttpStatus.OK);

    }

    @GetMapping(value = "/changerating/{viewerId}&{movieId}&{rating}")
    public ResponseEntity changerating(@PathVariable(name ="viewerId")Long viewerId,@PathVariable(name ="movieId")Long movieId,@PathVariable(name ="rating")double rating){
        System.out.println(viewerId +""+movieId+""+rating);
        WatchedMovie watchedMovie = watchedMovieService.findByMovieIdAndViewerId(movieId,viewerId);
        watchedMovie.setRating(rating);
        watchedMovieService.save(watchedMovie);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/ratemovie/{viewerId}&{movieId}&{rating}")
    public ResponseEntity rateMovie(@PathVariable(name ="viewerId")Long viewerId,@PathVariable(name ="movieId")Long movieId,@PathVariable(name ="rating")double rating){
        System.out.println(viewerId +""+movieId+""+rating);
        WatchedMovie watchedMovie = watchedMovieService.findByMovieIdAndViewerId(movieId,viewerId);
        Movie movie = movieService.findById(movieId);
        Viewer viewer = viewerService.find(viewerId);
        watchedMovie.setRating(rating);
        watchedMovie.setMovie(movie);
        watchedMovie.setViewer(viewer);
        watchedMovieService.save(watchedMovie);


        return new ResponseEntity( HttpStatus.NO_CONTENT);
    }




}
