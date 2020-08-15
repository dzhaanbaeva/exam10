package com.exam10.service;

import com.exam10.DTO.PlaceDTO;
import com.exam10.repository.PlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}
