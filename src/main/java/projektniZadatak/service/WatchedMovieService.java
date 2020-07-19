package projektniZadatak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektniZadatak.entity.WatchedMovie;
import projektniZadatak.repository.WatchedMovieRepository;

@Service
public class WatchedMovieService {
    @Autowired
    private WatchedMovieRepository watchedMovieRepository;

    public WatchedMovie findById(Long id){
        return this.watchedMovieRepository.getOne(id);
    }
    public WatchedMovie findByMovieIdAndViewerId(Long movie,Long viewer){
       return this.watchedMovieRepository.findAllByMovie_idAndViewer_id(movie,viewer);
    }

    public WatchedMovie save(WatchedMovie watchedMovie){
        return this.watchedMovieRepository.save(watchedMovie);
    }
}
