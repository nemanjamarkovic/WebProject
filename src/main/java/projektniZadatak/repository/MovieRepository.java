package projektniZadatak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projektniZadatak.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long> {

}
