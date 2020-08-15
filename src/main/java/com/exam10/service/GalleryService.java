package com.exam10.service;

import com.exam10.DTO.PlaceDTO;
import com.exam10.model.Gallery;
import com.exam10.model.Place;
import com.exam10.repository.GalleryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GalleryService {
    private GalleryRepository galleryRepository;

    public String addImages(Place place, String image) {
        if (galleryRepository.existsByImage(image)) {
            return "/errors/error-already-have";
        } else {
            var gallery = Gallery.builder()
                    .image(image)
                    .place(Place.builder().id(place.getId()).build())
                    .build();
            galleryRepository.save(gallery);

        }

        return "pagePlace";
    }

}
