package org.example.service.impl;
import lombok.RequiredArgsConstructor;
import org.example.dto.BedDto;
import org.example.entity.Bed;
import org.example.entity.Ward;
import org.example.repository.BedRepository;
import org.example.repository.WardRepository;
import org.example.service.BedService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class BedServiceImpl implements BedService {
    final WardRepository wardRepository;
    final BedRepository bedRepository;
    ModelMapper modelMapper;
    @Bean
    public void setbed(){
        this.modelMapper = new ModelMapper();
    }
    @Override
    public Bed addBed(BedDto bedDto, String wardId) {
        Ward ward = wardRepository.findBywardId(wardId);
        Bed bed = modelMapper.map(bedDto,Bed.class);
        if(ward!=null){
            bed.setWard(ward);
            ward.getBedList().add(bed);
            wardRepository.save(ward);
            Bed bed1 = bedRepository.save(bed);
            BedDto bedDto1 = modelMapper.map(bed1,BedDto.class);
            return bed1;
        }
        return null;
    }

    public String generateBedId(){
        Long id = bedRepository.findMaxId();
        if(id!=null){
            ++id;
            return "BD"+id;
        }else {
            return "BD"+1;
        }
    }
}
