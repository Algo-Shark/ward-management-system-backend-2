package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String doctorId;
    private String name;
    private String nic;
    private String dob;
    private String specialization;
    private String status;
    private String gender;

    public Doctor(String doctorId, String name, String nic, String dob, String specialization, String status, String gender) {
        this.doctorId = doctorId;
        this.name = name;
        this.nic = nic;
        this.dob = dob;
        this.specialization = specialization;
        this.status = status;
        this.gender = gender;
    }

}
