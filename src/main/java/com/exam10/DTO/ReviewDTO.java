package com.exam10.DTO;

import com.exam10.model.Review;
import com.exam10.model.User;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@ToString
public class ReviewDTO {
    private int id;
    private String text;
    LocalDateTime data;
    private double rating;
    private UserDTO users;
    private PlaceDTO places;

    public static ReviewDTO from(Review review){
        return builder()
                .id(review.getId())
               .text(review.getText())
                .data(LocalDateTime.now())
                .rating(review.getRating())
                .users(UserDTO.from(review.getUsers()))
                .places(PlaceDTO.from(review.getPlaces()))
                .build();
    }
}
