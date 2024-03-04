package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Patient {
    @Id
    private Long id;
    private String patientId;
    private String NIC;
    private String name;
    private String nationality;
    private String gender;
    private String telephone;
    private String religion;
    private String address;
    private String dob;
}
