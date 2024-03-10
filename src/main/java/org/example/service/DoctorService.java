package org.example.service;

import org.example.dto.DoctorDto;
import org.example.enums.Status;

public interface DoctorService {
    public DoctorDto addDoctor(DoctorDto doctor);
    public String generateDoctorId();
    public int availabelDoctorCount(String status);
}
