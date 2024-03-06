package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdmissionDto {
    private String admissionId;
    private String admitDate;
    private String admitReson;
    private String status;
    private String Gurdient_name;
}
