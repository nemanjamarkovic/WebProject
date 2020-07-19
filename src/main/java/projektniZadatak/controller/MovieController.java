package projektniZadatak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import projektniZadatak.entity.Movie;
import projektniZadatak.entity.RatedMovie;
import projektniZadatak.entity.WatchedMovie;
import projektniZadatak.entity.dto.MovieDTO;
import projektniZadatak.entity.dto.SearchDTO;
import projektniZadatak.service.MovieService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MovieController {
    @Autowired
    private MovieService movieService;


    @GetMapping(value ="/all-movies")
    public ResponseEntity<List<MovieDTO>> getMovies(){
        List<Movie>movies = movieService.findAll();
        List<MovieDTO>moviesDTO = new ArrayList<MovieDTO>();

        for(Movie movie:movies){
            List<WatchedMovie> watchedMovies = new ArrayList<WatchedMovie>();
            System.out.println(movie.getId());
            try {
                watchedMovies = this.movieService.findAllWatchedMovies(movie.getId());
            }catch(Exception e){
                System.out.println(e);
            }
            double average = 0;

            for(WatchedMovie wM:watchedMovies){
                    average += wM.getRating();
            }
            average = average / watchedMovies.size();
            RatedMovie ratedMovie = new RatedMovie(movie.getId(),movie.getTitle(),movie.getGenre(),movie.getDescription(),average,movie.getDuration(),movie.getDate());
            System.out.println(ratedMovie.toString());
            movieService.saveRatedMovie(ratedMovie);
            MovieDTO movieDTO = new MovieDTO(movie.getTitle(),movie.getDescription(),movie.getGenre(),movie.getDuration(),movie.getDate(),average,movie.getId());
            moviesDTO.add(movieDTO);
        }

        return new ResponseEntity<List<MovieDTO>>(moviesDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/search")
    private ResponseEntity<List<MovieDTO>> search(@RequestBody SearchDTO searchDTO){
        List<RatedMovie> movies = movieService.findAllRatedMovies();
        List<RatedMovie>toRemove = new ArrayList<RatedMovie>();
        //System.out.println(movies);
        for(RatedMovie movie : movies){
            if(!searchDTO.getTitle().isEmpty()) {
                    if (!(searchDTO.getTitle().equalsIgnoreCase(movie.getTitle())))
                    toRemove.add(movie);
            }
        }
        System.out.println(toRemove);
        movies.removeAll(toRemove);
        toRemove.clear();
        for(RatedMovie movie : movies){
            if(!searchDTO.getGenre().isEmpty()) {
                if (!(searchDTO.getGenre().equalsIgnoreCase(movie.getGenre())))
                    toRemove.add(movie);
            }
        }

        movies.removeAll(toRemove);
        toRemove.clear();

        for(RatedMovie movie : movies){
            if(searchDTO.getRating() > 0) {
                if (searchDTO.getRating() > movie.getRating())
                    toRemove.add(movie);
                    System.out.println("uneseni:"+searchDTO.getRating()+"pravi"+movie.getRating());
            }
        }

        movies.removeAll(toRemove);
        List<MovieDTO> moviesDTO = new ArrayList<MovieDTO>();

        for(RatedMovie movie : movies){

            MovieDTO movieDTO = new MovieDTO(movie.getTitle(), movie.getDescription(),movie.getGenre(),movie.getDuration(),movie.getDate(),movie.getRating(),movie.getId());
            moviesDTO.add(movieDTO);
        }
        if(moviesDTO.size() == 0){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        //SearchDTO newSearchDTO = new SearchDTO("nemanja","nemanja",2);
        return new ResponseEntity<List<MovieDTO>>(moviesDTO, HttpStatus.OK);

    }
}
