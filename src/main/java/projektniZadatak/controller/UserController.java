package projektniZadatak.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import projektniZadatak.entity.User;
import projektniZadatak.entity.Viewer;
import projektniZadatak.entity.dto.LoginDTO;
import projektniZadatak.entity.dto.RegistrationDTO;
import projektniZadatak.entity.dto.UserDTO;
import projektniZadatak.entity.dto.ViewerDTO;
import projektniZadatak.service.UserService;
import projektniZadatak.service.ViewerService;

@RestController

@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    public UserService userService;
    @Autowired
    private ViewerService viewerService;


/*    @GetMapping(value = "/register")
    public String reg(){

        return "registration.html";
    }*/

    @PostMapping(value = "/registration",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ViewerDTO> registration(@RequestBody RegistrationDTO registrationDTO)throws Exception{

        Viewer viewer = new Viewer(registrationDTO.getName(),registrationDTO.getLastname(),registrationDTO.getEmail(),registrationDTO.getPassword(), User.Role.VIEWER);
        System.out.println("2222222");
        viewerService.save(viewer);
        System.out.println(viewer);

        ViewerDTO viewerDTO = new ViewerDTO(viewer.getId(), viewer.getName(),viewer.getLastname(),viewer.getEmail(),viewer.getRole());
        return new ResponseEntity<>(viewerDTO, HttpStatus.OK);
    }

    @PostMapping(value ="/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginDTO loginDTO){
        System.out.println("121212");

        User user = null;
        try {
            user = this.userService.findByMail(loginDTO.getEmail());
        }catch(Exception e){
            System.out.println("nema korisnika pod tim imenom");
        }
        UserDTO userDTO = new UserDTO(user.getId(),user.getName(),user.getLastname(), user.getEmail(),user.getPassword(),user.getRole());

        if(user.getPassword().equals(loginDTO.getPassword()))
            return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);


    }



   /* @GetMapping("/profile/{id}")
    public String user(@PathVariable(name = "id") Long id, Model model) {
        User user = this.userService.findOne(id);
        System.out.println(user.getEmail()+user.getId());


        System.out.println(id);

        model.addAttribute("user", user);
        return "user.html";
    }
*/


    @GetMapping(value = "/profile/{id}")
    public ResponseEntity<UserDTO> profile(@PathVariable(name = "id") Long id)throws Exception{
            User user = this.userService.findOne(id);
            System.out.println(id);
            UserDTO userDTO = new UserDTO(user.getName(),user.getLastname(),user.getEmail(),user.getPassword());

           // UserDTO userDTO = new UserDTO("nemamnaj","markovic","markovic","markl");
            return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);


        }








}
