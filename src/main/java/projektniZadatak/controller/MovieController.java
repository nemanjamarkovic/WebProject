package projektniZadatak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import projektniZadatak.entity.Movie;
import projektniZadatak.entity.dto.MovieDTO;
import projektniZadatak.service.MovieService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/movies")
    public String allMovies(){
        return "movies.html";
    }

    @GetMapping(value ="/all-movies")
    public ResponseEntity<List<MovieDTO>> getMovies(){
        List<Movie>movies = movieService.findAll();
        List<MovieDTO>moviesDTO = new ArrayList<>();
        for(Movie movie:movies){
            MovieDTO movieDTO = new MovieDTO(movie.getTitle(),movie.getDescription(),movie.getGenre(),movie.getDuration());
            moviesDTO.add(movieDTO);
        }
        System.out.println(moviesDTO);
        return new ResponseEntity<List<MovieDTO>>(moviesDTO, HttpStatus.OK);
    }

}
