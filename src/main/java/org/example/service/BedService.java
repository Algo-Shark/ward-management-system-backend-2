package org.example.service;

import org.example.dto.BedDto;
import org.example.entity.Bed;
import org.example.enums.BedStatus;

public interface BedService {
    Bed addBed(BedDto bedDto, String wardId);
    String generateBedId();
    public boolean updateBedStatus(String bedId, BedStatus bedStatus);
}
