package projektniZadatak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projektniZadatak.entity.Cinema;
import projektniZadatak.entity.User;
import projektniZadatak.entity.Viewer;
import projektniZadatak.entity.dto.CinemaDTO;
import projektniZadatak.entity.dto.ViewerDTO;
import projektniZadatak.service.CinemaService;
import projektniZadatak.service.ViewerService;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private ViewerService viewerService;
    @Autowired
    private CinemaService cinemaService;

    @GetMapping(value = "/allusers")
    public ResponseEntity<List<ViewerDTO>> getAllUsers(){
        System.out.println("ADMINADMINADMIN");
        List<Viewer>viewers = viewerService.findAll();
        List<ViewerDTO>viewersDTO = new ArrayList<ViewerDTO>();

        for(Viewer viewer : viewers){
             Long cinemaId = null;
             try{
                 cinemaId = viewer.getCinema().getId();
             }catch (Exception e){
                 System.out.println(e);
             }

            ViewerDTO viewerDTO = new ViewerDTO(viewer.getId(),viewer.getName(),viewer.getLastname(),viewer.getEmail(),viewer.getRole(),cinemaId);
            viewersDTO.add(viewerDTO);
        }


        return new ResponseEntity<List<ViewerDTO>>(viewersDTO,HttpStatus.OK);
    }

    @GetMapping(value = "/setmanager/{userId}&{cinemaId}")
    public ResponseEntity setManager(@PathVariable(name = "userId")Long userId,@PathVariable(name = "cinemaId")Long cinemaId){
        Viewer viewer = viewerService.find(userId);
        Cinema cinema = new Cinema();
        try {
            cinema = cinemaService.find(cinemaId);
            viewer.setRole(User.Role.MANAGER);
            viewer.setCinema(cinema);
            viewerService.save(viewer);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            System.out.println("ne postoji taj objekat");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }




    }

    @GetMapping(value = "/removemanager/{userId}")
    public ResponseEntity removeManager(@PathVariable(name = "userId")Long userId){
        Viewer viewer = viewerService.find(userId);
        Cinema cinema = viewer.getCinema();
        if(cinema.getManagers().size() == 1)
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        viewer.setCinema(null);
        viewer.setRole(User.Role.VIEWER);
        viewerService.save(viewer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }


    @GetMapping(value = "/allcinemas")
    public ResponseEntity<List<CinemaDTO>> showAllCinemas(){
        List<Cinema> cinemas = cinemaService.findAll();
        List<CinemaDTO>cinemasDTO = new ArrayList<CinemaDTO>();
        for(Cinema cinema:cinemas){
            CinemaDTO cinemaDTO = new CinemaDTO(cinema.getId(),cinema.getName(),cinema.getAddress(),cinema.getPhoneNumber(),cinema.getEmail());
            cinemasDTO.add(cinemaDTO);
        }
        return new ResponseEntity<List<CinemaDTO>>(cinemasDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/changecinema")
    public ResponseEntity changeCinema(@RequestBody CinemaDTO cinemaDTO){
        Cinema cinema = cinemaService.find(cinemaDTO.getId());
        if(cinemaDTO.getName() != "")
            cinema.setName(cinemaDTO.getName());
        if(cinemaDTO.getAddress() != "")
            cinema.setAddress(cinemaDTO.getAddress());
        if(cinemaDTO.getEmail() != "")
            cinema.setEmail(cinemaDTO.getEmail());
        if(cinemaDTO.getPhoneNumber() != "")
            cinema.setPhoneNumber(cinemaDTO.getPhoneNumber());
        cinemaService.save(cinema);
        return new ResponseEntity(HttpStatus.NO_CONTENT);


    }

    @GetMapping(value = "/removecinema/{cinemaId}")
    public ResponseEntity removeCinema(@PathVariable(name = "cinemaId")Long cinemaId){
        Cinema cinema = cinemaService.find(cinemaId);
        System.out.println(cinema);
        cinemaService.remove(cinema);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/add-cinema")
        public ResponseEntity addCinema(@RequestBody CinemaDTO cinemaDTO){
        Cinema cinema = new Cinema (cinemaDTO.getName(),cinemaDTO.getAddress(),cinemaDTO.getPhoneNumber(),cinemaDTO.getEmail());
        cinemaService.save(cinema);


        return new ResponseEntity(HttpStatus.NO_CONTENT);


    }

}
