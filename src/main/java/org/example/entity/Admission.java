package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String admissionId;
    private String admitDate;
    private String admitReason; // Corrected typo: admitReson -> admitReason
    private String status;
    private String guardianName; // Corrected typo: Gurdient_name -> guardianName

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;
    @ManyToOne(fetch = FetchType.LAZY)
    private Ward ward;
    @ManyToOne(fetch = FetchType.LAZY)
    private Bed bed;


    public Admission(String admissionId, String admitDate, String admitReason, String status, String guardianName) {
        this.admissionId = admissionId;
        this.admitDate = admitDate;
        this.admitReason = admitReason;
        this.status = status;
        this.guardianName = guardianName;
    }
}