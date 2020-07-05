package projektniZadatak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import projektniZadatak.entity.Cinema;
import projektniZadatak.service.CinemaService;

@Controller
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/cinema")
    public String cinema(){
        return "cinema.html";
    }

    @RequestMapping( value = "/add-cinema", method = RequestMethod.GET )
    public String saveCinema(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "address", required = false)String address,
                           @RequestParam(value = "phoneNumber", required = false)String phoneNumber,
                           @RequestParam(value = "email", required = false)String email) {


        //System.out.println(name+lastname);
        Cinema cinema = new Cinema(name,address,phoneNumber,email);
        this.cinemaService.save(cinema);

        return "redirect:/user";
    }


}
