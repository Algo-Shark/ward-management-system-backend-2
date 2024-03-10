package org.example.service;

import org.example.dto.DoctorDto;

public interface DoctorService {
    public DoctorDto addDoctor(DoctorDto doctor);
    public String generateDoctorId();
}
