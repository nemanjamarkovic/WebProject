package projektniZadatak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektniZadatak.entity.Movie;
import projektniZadatak.entity.RatedMovie;
import projektniZadatak.entity.WatchedMovie;
import projektniZadatak.repository.MovieRepository;
import projektniZadatak.repository.RatedMovieRepository;
import projektniZadatak.repository.WatchedMovieRepository;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private WatchedMovieRepository watchedMovieRepository;

    @Autowired
    private RatedMovieRepository ratedMovieRepository;


    public List<WatchedMovie>findAllWatchedMovies(Long id){
        List<WatchedMovie> watchedMovies = this.watchedMovieRepository.findByMovie_Id(id);
        return watchedMovies;
    }

    public List<Movie> findAll(){
       List<Movie>movies = this.movieRepository.findAll();
       return movies;
   }

   public void saveRatedMovie(RatedMovie movie){
        this.ratedMovieRepository.save(movie);
   }

   public List<RatedMovie> findAllRatedMovies(){
        List<RatedMovie>movies = this.ratedMovieRepository.findAll();
        return movies;
    }

    public Movie findById(Long id){
        Movie movie = this.movieRepository.findFirstById(id);
        return movie;
    }




}
