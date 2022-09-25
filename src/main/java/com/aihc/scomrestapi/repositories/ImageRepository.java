package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.db.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {}
