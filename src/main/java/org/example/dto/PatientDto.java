package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDto {
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
