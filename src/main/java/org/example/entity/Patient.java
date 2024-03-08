package org.example.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Lob
    private byte[] qrCodeData;

    public Patient(String patientId, String name, String nic, String nationality, String gender, String telephone, String religion, String address, String dob) {
        this.patientId = patientId;
        this.name = name;
        this.nic = nic;
        this.nationality = nationality;
        this.gender = gender;
        this.telephone = telephone;
        this.religion = religion;
        this.address = address;
        this.dob = dob;
    }
}
