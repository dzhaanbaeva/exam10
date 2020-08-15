package com.exam10.DTO;

import com.exam10.model.Place;
import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@ToString
public class PlaceDTO {
    private int id;
    private String name;
    private String photo;
    private String description;


    public static PlaceDTO from(Place place){
        return builder()
                .id(place.getId())
                .name(place.getName())
                .photo(place.getPhoto())
                .description(place.getDescription())
                .build();
    }


}
