package org.example.service;

import org.example.dto.PatientDto;
import org.example.entity.Patient;

import java.util.List;

public interface PatientService {
    public PatientDto addPatient(PatientDto barrowerDto);
    public String generatePatientId();

    public PatientDto getPatientDetailsById(String patientId);

    List<Patient> getPatients();

}
