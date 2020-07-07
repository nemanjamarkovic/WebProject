package projektniZadatak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projektniZadatak.entity.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
