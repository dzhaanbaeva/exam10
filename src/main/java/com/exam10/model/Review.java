package com.exam10.model;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "reviews")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;
    LocalDateTime data;
    private double rating;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "users_id")
    private User users;

    @ManyToOne(targetEntity = Place.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "places_id")
    private Place places;
}