package org.example.service.impl;
import lombok.RequiredArgsConstructor;
import org.example.dto.BedDto;
import org.example.dto.WardDto;
import org.example.entity.Bed;
import org.example.entity.Ward;
import org.example.enums.BedStatus;
import org.example.repository.BedRepository;
import org.example.repository.WardRepository;
import org.example.service.BedService;
import org.example.service.WardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WardServiceImpl implements WardService {
    final WardRepository wardRepository;
    @Autowired
    BedService bedService;

    ModelMapper modelMapper;
    @Autowired
    BedRepository bedRepository;
    @Bean
    public void set(){
        this.modelMapper = new ModelMapper();
    }
    @Override
    public WardDto addWard(WardDto wardDto) {
        Ward ward = new Ward(wardDto.getWardId(), wardDto.getCapacity(), wardDto.getWardType());
        Ward savedWard = wardRepository.save(ward);// Save the ward
        List<BedDto> bedList = new ArrayList<>();
        int length = ward.getCapacity();
        for (int i = 0; i < length; i++) {
            Bed bed = new Bed(bedService.generateBedId(), BedStatus.VACANT);
            bedList.add(new BedDto(bed.getBedId(),bed.getStatus()));
            Bed savedBed = bedRepository.save(bed);
            savedBed.setWard(savedWard);
            savedWard.getBedList().add(bed);
        }
        wardRepository.save(savedWard);
        return new WardDto(ward.getWardId(), ward.getCapacity(), ward.getWardType(), bedList);
    }


    @Override
    public String generateWardId() {
        Long id = wardRepository.findMaxId();
        if(id!=null){
            ++id;
            return "WD"+id;
        }else {
            return "WD"+1;
        }
    }
}
