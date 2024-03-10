package org.example.repository;

import org.example.entity.Bed;
import org.example.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {


    @Query("SELECT MAX(d.id) FROM Doctor d")
    Long findMaxID();


    int countByStatus(String status);
}
