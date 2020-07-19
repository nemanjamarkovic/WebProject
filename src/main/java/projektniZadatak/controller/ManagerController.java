package projektniZadatak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projektniZadatak.entity.Cinema;
import projektniZadatak.entity.Hall;
import projektniZadatak.entity.Viewer;
import projektniZadatak.entity.dto.CinemaDTO;
import projektniZadatak.entity.dto.HallDTO;
import projektniZadatak.service.CinemaService;
import projektniZadatak.service.HallService;
import projektniZadatak.service.ViewerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/manager")

public class ManagerController {
    @Autowired
    private ViewerService viewerService;
    @Autowired
    private HallService hallService;


    @GetMapping(value = "/{userId}")
    public ResponseEntity<CinemaDTO> findManager(@PathVariable(name = "userId")Long userId){
        System.out.println("MANAGER"+userId);
        Viewer viewer = viewerService.find(userId);
        Cinema cinema = viewer.getCinema();
        System.out.println(cinema);
        CinemaDTO cinemaDTO = new CinemaDTO(cinema.getId(),cinema.getName(),cinema.getAddress(),cinema.getPhoneNumber(),cinema.getEmail());
        return new ResponseEntity<CinemaDTO>(cinemaDTO, HttpStatus.OK);
    }
    @GetMapping(value = "/allhalls/{userId}")
    public ResponseEntity<List<HallDTO>> findAllHalls(@PathVariable(name="userId")Long userId){
        Viewer viewer = viewerService.find(userId);
        List<Hall> halls= new ArrayList<Hall>();
        try{
            halls = viewer.getCinema().getHalls();
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        List<HallDTO>hallsDTO = new ArrayList<HallDTO>();
        for(Hall hall:halls){
            HallDTO hallDTO = new HallDTO(hall.getId(),hall.getCapacity(),hall.getLabel());
            hallsDTO.add(hallDTO);
        }
        System.out.println(halls);
        return new ResponseEntity<List<HallDTO>>(hallsDTO,HttpStatus.OK);
    }

    @PostMapping(value ="/changehall")
    public ResponseEntity changeHall(@RequestBody HallDTO hallDTO){
        Hall hall = hallService.find(hallDTO.getId());
        if(hallDTO.getLabel() != "")
            hall.setLabel(hallDTO.getLabel());
        if(hallDTO.getCapacity()!=0)
            hall.setCapacity(hallDTO.getCapacity());
        hallService.save(hall);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "removehall/{hallId}")
    public ResponseEntity removeHall(@PathVariable (name ="hallId")Long hallId){
        hallService.remove(hallId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

}
