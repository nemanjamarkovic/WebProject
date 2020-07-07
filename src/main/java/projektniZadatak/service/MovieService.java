package projektniZadatak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektniZadatak.entity.Movie;
import projektniZadatak.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
   public List<Movie> findAll(){
       List<Movie>movies = this.movieRepository.findAll();
       return movies;
   }

}
