package projektniZadatak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektniZadatak.entity.Cinema;
import projektniZadatak.repository.CinemaRepository;

@Service
public class CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    public Cinema save(Cinema cinema){
        return this.cinemaRepository.save(cinema);
    }


}
