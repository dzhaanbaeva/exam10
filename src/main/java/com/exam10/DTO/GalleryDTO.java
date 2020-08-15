package com.exam10.DTO;

import com.exam10.model.Gallery;
import com.exam10.model.Review;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@ToString
public class GalleryDTO {
    private Integer id;
    private String image;
    private PlaceDTO place;


    public static GalleryDTO from(Gallery gallery){
        return builder()
                .id(gallery.getId())
               .image(gallery.getImage())
                .place(PlaceDTO.from(gallery.getPlace()))
                .build();
    }
}
