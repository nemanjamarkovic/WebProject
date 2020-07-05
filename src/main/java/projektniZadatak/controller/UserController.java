package projektniZadatak.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projektniZadatak.entity.User;
import projektniZadatak.entity.dto.RegistrationDTO;
import projektniZadatak.entity.dto.UserDTO;
import projektniZadatak.service.UserService;

import javax.print.attribute.standard.Media;

@RestController

@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping(value = "/registration",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> registration(@RequestBody RegistrationDTO registrationDTO)throws Exception{
        User user = new User(registrationDTO.getName(),registrationDTO.getLastname(),registrationDTO.getEmail(),registrationDTO.getPassword());
        User newUser = userService.save(user);

        UserDTO userDTO = new UserDTO(newUser.getId(),newUser.getName(),newUser.getLastname(),newUser.getEmail(),newUser.getPassword());
        return new ResponseEntity<>(userDTO, HttpStatus.OK);


    }




    @RequestMapping( value = "/save-user", method = RequestMethod.GET )
    public String saveUser(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "lastname", required = false)String lastname,
                           @RequestParam(value = "password", required = false)String password,
                            @RequestParam(value = "email", required = false)String email) {


        //System.out.println(name+lastname);
        User user = new User(name,lastname, email,password);
        this.userService.save(user);

        return "redirect:/";
    }

    @RequestMapping( value = "/login", method = RequestMethod.GET )
    public String login(@RequestParam(value = "email", required = false) String email,
                       @RequestParam(value = "password", required = false) String password) {
        try {
            //String pass = this.userService.findByMail(email);
            User user = this.userService.findByMail(email);
            String pass = user.getPassword();
            //System.out.println(password + "1" + pass);
            if (pass.equals(password))
                return "redirect:/user/"+user.getId().toString();
            else
                return "redirect:/";

        }catch (Exception e) {
            System.out.println("greska");
        }
        return "redirect:/";
    }

    @GetMapping("/user/{id}")
    public String user(@PathVariable(name = "id") Long id, Model model) {
        User user = this.userService.findOne(id);
        System.out.println(user.getEmail()+user.getId());


        System.out.println(id);

        model.addAttribute("user", user);
        return "user.html";
    }












}
