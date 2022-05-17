package com.example.ratingsdataservices.models;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResources {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId)
    {
        return new Rating(movieId,10);
    }
    @RequestMapping("users/{userId}")
    public UserRatings getUserRatings(@PathVariable("userId") String userId)
    {
        List<Rating> ratings= Arrays.asList(new Rating("100",4)
                                            ,new Rating("500",3));
        UserRatings userRatings=new UserRatings();
        userRatings.setRatings(ratings);
        return userRatings;
    }
}
