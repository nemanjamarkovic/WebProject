package projektniZadatak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projektniZadatak.entity.Hall;

public interface HallRepository extends JpaRepository<Hall, Long> {
}
