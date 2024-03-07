package org.example.service;

import org.example.dto.BedDto;
import org.example.entity.Bed;

public interface BedService {
    Bed addBed(BedDto bedDto, String wardId);
    String generateBedId();
}
