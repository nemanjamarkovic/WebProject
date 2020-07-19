package projektniZadatak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projektniZadatak.entity.RatedMovie;

public interface RatedMovieRepository extends JpaRepository<RatedMovie,Long> {

}
