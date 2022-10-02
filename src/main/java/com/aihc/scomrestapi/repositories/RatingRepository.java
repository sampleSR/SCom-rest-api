package com.aihc.scomrestapi.repositories;

import com.aihc.scomrestapi.db.entities.Rating;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
  List<Rating> findAllByCustomer_Id(final Integer id);
}
