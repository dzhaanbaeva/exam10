package com.exam10.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "gallery")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String image;

    @ManyToOne(targetEntity = Place.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "place_id")
    private Place place;
}
