package projektniZadatak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektniZadatak.entity.Projection;
import projektniZadatak.repository.ProjectionRepository;

import java.util.List;

@Service
public class ProjectionService {
    @Autowired
    private ProjectionRepository projectionRepository;

    public List<Projection> findAllByMovieId(Long id){
        List<Projection> projections = this.projectionRepository.findAllByMovie_Id(id);
        return projections;
    }

    public Projection findById(Long id){
        Projection projection = this.projectionRepository.findFirstById(id);

        return projection;
    }

    public Projection save(Projection projection){
        return projectionRepository.save(projection);
    }
}
