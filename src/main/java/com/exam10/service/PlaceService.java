package com.exam10.service;

import com.exam10.DTO.PlaceDTO;
import com.exam10.model.Place;
import com.exam10.model.User;
import com.exam10.repository.PlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlaceService {
    private PlaceRepository placeRepository;


    public List<PlaceDTO> findAll() {
        return placeRepository.findAll().stream()
                .map(PlaceDTO::from).collect(Collectors.toList());
    }

    public Page<PlaceDTO> findAllPlace(Pageable pageable){
        return placeRepository.findAll(pageable).map(PlaceDTO::from);
    }

    public String addPlace(String name, String description, String photo) {
        if (placeRepository.existsByName(name)) {
            return "/errors/error-already-have";
        } else {
            var place = Place.builder()
                    .name(name)
                    .description(description)
                    .photo(photo)
                    .build();
            placeRepository.save(place);

        }

        return "redirect:/";
    }

    public Page<PlaceDTO> getPlaceSearch(String text, Pageable pageable){
        return placeRepository.findAllByName(text, pageable)
                .map(PlaceDTO::from);
    }
}
