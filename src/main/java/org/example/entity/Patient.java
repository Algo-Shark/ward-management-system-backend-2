package org.example.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String patientId;
    private String name;
    private String nic;
    private String nationality;
    private String gender;
    private String telephone;
    private String religion;
    private String address;
    private String dob;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Admission> admissions = new ArrayList<>();

}
