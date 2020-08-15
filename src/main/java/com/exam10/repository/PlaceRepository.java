package com.exam10.repository;

import com.exam10.model.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
    List<Place> findAll();
    boolean existsByName(String name);
    Place findById(int id);
    @Query("SELECT p FROM Place p WHERE (p.name like concat(:name, '%')) or (p.name like concat('%',:name,'%')) or (p.name like concat('%', :name)) or " +
            "(p.description like concat(:name, '%')) or (p.description like concat('%',:name,'%')) or (p.description like concat('%', :name))")
    Page<Place> findAllByName(String name, Pageable pageable);

}
