package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.dto.DoctorDto;
import org.example.entity.Doctor;
import org.example.enums.DoctorAvailability;
import org.example.repository.DoctorRepository;
import org.example.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.management.modelmbean.ModelMBean;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    final DoctorRepository doctorRepository;
    ModelMapper modelMapper;
    @Bean
    private void mapDoctor(){
        modelMapper = new ModelMapper();
    }
    public DoctorDto addDoctor(DoctorDto doctorDto){
            if(doctorDto!=null){
                Doctor doctor = new Doctor(doctorDto.getDoctorId(), doctorDto.getName()
                ,doctorDto.getNic(),doctorDto.getDob(),doctorDto.getSpecialization(),
                        doctorDto.getStatus(),doctorDto.getGender());
                Doctor savedDoctor = doctorRepository.save(doctor);
                return modelMapper.map(savedDoctor,DoctorDto.class);
            }
            return null;
    }


    public String generateDoctorId(){
        Long maxID = doctorRepository.findMaxID();
        if(maxID!=null){
            ++maxID;
            return "DC"+maxID;
        }else {
            return "DC1";
        }
    }

    public int availabelDoctorCount(String status){
        int count = doctorRepository.countDoctorsByStatus(status);
        if(count>=0){
            return count;
        }
        return -1;
    }

    @Override
    public boolean updateDoctorStatus(String doctorId, DoctorAvailability doctorAvailability) {
        Doctor findsDoctor = doctorRepository.findBydoctorId(doctorId);
        if(findsDoctor!=null){
            findsDoctor.setStatus(doctorAvailability);
            doctorRepository.save(findsDoctor);
            return true;
        }else {
            return false;
        }
    }
}
