package org.example.repository;
import jakarta.transaction.Transactional;
import org.example.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {


    @Query(value = "SELECT MAX(d.id) FROM Doctor d",nativeQuery = true)
    Long findMaxID();


    @Query(value = "SELECT COUNT(*) FROM doctor WHERE status = ?1", nativeQuery = true)
    int countDoctorsByStatus(String status);

    Doctor findBydoctorId(String doctorId);
}
