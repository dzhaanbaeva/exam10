package com.exam10.repository;

import com.exam10.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
    List<Place> findAll();
    boolean existsByName(String name);
}
