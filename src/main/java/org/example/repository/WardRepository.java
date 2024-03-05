package org.example.repository;

import org.example.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WardRepository extends JpaRepository<Ward,Long> {

    Ward findBywardId(String wardId);
    @Query("SELECT MAX(w.id) FROM Ward w")
    Long findMaxId();
}
