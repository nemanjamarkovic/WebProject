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




}
