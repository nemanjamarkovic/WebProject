package projektniZadatak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projektniZadatak.entity.WatchedMovie;

import java.util.List;

public interface WatchedMovieRepository extends JpaRepository<WatchedMovie,Long> {
    List<WatchedMovie>findByMovie_Id(Long Movie_id);
    WatchedMovie findAllByMovie_idAndViewer_id(Long Movie_id, Long Viewer_id);
}
