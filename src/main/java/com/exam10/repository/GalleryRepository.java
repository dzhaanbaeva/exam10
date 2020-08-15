package com.exam10.repository;

import com.exam10.model.Gallery;
import com.exam10.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalleryRepository extends JpaRepository<Gallery,Integer> {
    boolean existsByImage( String image);

}
