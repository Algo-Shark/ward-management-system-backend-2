package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.DoctorAvailability;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorDto {
    private String doctorId;
    private String name;
    private String nic;
    private String dob;
    private String specialization;
    private DoctorAvailability status;
    private String gender;
}
