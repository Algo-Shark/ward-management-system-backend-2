package org.example.service;

import org.example.dto.AdmissionDto;
import org.example.dto.AdmissionRequest;

public interface AdmissionService {

    public String generateAdmissionId();
    public AdmissionDto setAdmission(AdmissionRequest admissionRequest);
}
