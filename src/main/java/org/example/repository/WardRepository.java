package org.example.repository;

import org.example.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardRepository extends JpaRepository<Ward,Long> {

    Ward findBywardId(String wardId);
}
