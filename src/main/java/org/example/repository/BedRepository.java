package org.example.repository;
import org.example.entity.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BedRepository extends JpaRepository<Bed,Long> {
    @Query("SELECT MAX(b.id) FROM Bed b")
    Long findMaxId();
    Bed findByBedId(String bedId);


}
