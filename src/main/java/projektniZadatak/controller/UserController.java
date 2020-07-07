package projektniZadatak.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projektniZadatak.entity.User;
import projektniZadatak.entity.dto.LoginDTO;
import projektniZadatak.entity.dto.RegistrationDTO;
import projektniZadatak.entity.dto.UserDTO;
import projektniZadatak.service.UserService;

@Controller

@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping(value = "/register")
    public String reg(){

        return "registration.html";
    }

    @PostMapping(value = "/registration",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> registration(@RequestBody RegistrationDTO registrationDTO)throws Exception{
        User user = new User(registrationDTO.getName(),registrationDTO.getLastname(),registrationDTO.getEmail(),registrationDTO.getPassword());
        System.out.println("2222222");
        User newUser = userService.save(user);

        UserDTO newUserDTO = new UserDTO(newUser.getId(),newUser.getName(),newUser.getLastname(),newUser.getEmail(),newUser.getPassword());
        return new ResponseEntity<>(newUserDTO, HttpStatus.OK);
    }

    @PostMapping(value ="/login")
    public ResponseEntity<User> login(@RequestBody LoginDTO loginDTO){
        User user = null;
        try {
            user = this.userService.findByMail(loginDTO.getEmail());
        }catch(Exception e){
            System.out.println("nema korisnika pod tim imenom");
        }

        if(user.getPassword().equals(loginDTO.getPassword()))
            return new ResponseEntity<User>(user,HttpStatus.OK);
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


    @PostMapping(value = "/profile")
    public void profile(@RequestBody Long id){
        System.out.println(id);
    }








}
