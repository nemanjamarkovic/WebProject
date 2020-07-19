package projektniZadatak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektniZadatak.entity.Hall;
import projektniZadatak.repository.HallRepository;

@Service
public class HallService {
    @Autowired
    private HallRepository hallRepository;

    public Hall find(Long id){
        return this.hallRepository.getOne(id);
    }

    public void save(Hall hall){
        this.hallRepository.save(hall);
    }

    public void remove(Long id){
        this.hallRepository.deleteById(id);
    }
}
