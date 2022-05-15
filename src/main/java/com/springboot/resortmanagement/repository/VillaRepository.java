package com.springboot.resortmanagement.repository;

import com.springboot.resortmanagement.entity.Villa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VillaRepository extends JpaRepository<Villa, Integer> {

    @Query(value="select * from villa where resort_resort_id=:resortId", nativeQuery=true)
    List<Villa> findVillas(@Param("resortId") int theId);
    // no code required
}
