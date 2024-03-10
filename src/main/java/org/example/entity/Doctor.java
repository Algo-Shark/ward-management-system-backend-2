package org.example.entity;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.DoctorAvailability;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Type;

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
    @Enumerated(EnumType.STRING)
    private DoctorAvailability status;
    private String gender;

    public Doctor(String doctorId, String name, String nic, String dob, String specialization, DoctorAvailability status, String gender) {
        this.doctorId = doctorId;
        this.name = name;
        this.nic = nic;
        this.dob = dob;
        this.specialization = specialization;
        this.status = status;
        this.gender = gender;
    }

}
