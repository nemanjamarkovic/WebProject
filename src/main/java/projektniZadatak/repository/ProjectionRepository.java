package projektniZadatak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projektniZadatak.entity.Projection;

import java.util.List;

public interface ProjectionRepository extends JpaRepository<Projection, Long> {
    public List<Projection> findAllByMovie_Id(Long Movie_id);
    public Projection findFirstById(Long id);
}
