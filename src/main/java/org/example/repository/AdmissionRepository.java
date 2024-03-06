package org.example.repository;

import org.example.entity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, Long> {

    @Query("SELECT MAX(a.id) FROM Admission a")
    Long findMaxId();
}
