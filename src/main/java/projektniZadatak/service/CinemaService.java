package projektniZadatak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektniZadatak.entity.Cinema;
import projektniZadatak.repository.CinemaRepository;

import java.util.List;

@Service
public class CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    public Cinema save(Cinema cinema){
        return this.cinemaRepository.save(cinema);
    }

    public Cinema find(Long id){
        return this.cinemaRepository.getOne(id);
    }

    public List<Cinema> findAll(){
        List<Cinema> cinemas = this.cinemaRepository.findAll();
        return cinemas;
    }

    public void remove(Cinema cinema){
        this.cinemaRepository.delete(cinema);
    }


}
