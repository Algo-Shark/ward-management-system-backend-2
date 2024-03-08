package org.example.repository;
import org.example.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    @Query("SELECT MAX(p.id) FROM Patient p")
    Long findMaxId();

    Patient findByPatientId(String patinetId);

}
