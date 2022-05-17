package com.example.moviecatalogue.resources;

import com.example.moviecatalogue.model.CatalogItem;
import com.example.moviecatalogue.model.Movie;
import com.example.moviecatalogue.model.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {
    @Autowired
    private RestTemplate restTemplate;
//    @Autowired
//    private WebClient.Builder webClientBuilder;
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
    {
        var ratings=restTemplate.getForObject("http://ratings-data-services/ratingsdata/users/"+userId, UserRatings.class);
        return ratings.getRatings().stream().map(rating -> {
            var movie=restTemplate.getForObject("http://movie-info-service/movieinfo/"+rating.getMovieId(), Movie.class);
//            var movie=webClientBuilder.build()
//                    .get()
//                    .uri("http://localhost:8082/movieinfo/"+rating.getMovieId())
//                    .retrieve()
//                    .bodyToMono(Movie.class)
//                    .block();
            return new CatalogItem(movie.getTitle(), movie.getMovieId(), movie.getOverview(), rating.getRating());
        }).collect(Collectors.toList());
    }
}
