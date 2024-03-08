package org.example.service.impl;
import lombok.RequiredArgsConstructor;
import org.example.dto.PatientDto;
import org.example.entity.Patient;
import org.example.repository.PatientRepository;
import org.example.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    final PatientRepository patientRepository;
    ModelMapper modelMapper;
    @Bean
    public void setUp(){
        this.modelMapper = new ModelMapper();
    }
    @Override
    public PatientDto addPatient(PatientDto patientDto) {
        Patient patient = new Patient(patientDto.getPatientId(),patientDto.getName(),
                patientDto.getNic(),patientDto.getNationality(),patientDto.getGender()
                ,patientDto.getTelephone(),patientDto.getTelephone(),patientDto.getReligion(),patientDto.getDob());
        if(patient!=null){
            Patient patient1 = patientRepository.save(patient);
            PatientDto patientDto1 = modelMapper.map(patient1,PatientDto.class);
            return patientDto1;
        }
        return null;
    }

    public String generatePatientId(){
        Long id = patientRepository.findMaxId();
        if(id!=null){
            ++id;
            return "PT"+id;
        }else {
            return "PT"+1;
        }
    }

    @Override
    public List<Patient> getPatients() {
        List<Patient> list =new ArrayList<>();

        Iterable<Patient> iterableList = patientRepository.findAll();
        Iterator<Patient> iteratorList = iterableList.iterator();

        while(iteratorList.hasNext()){
            Patient entity = iteratorList.next();
            Patient patient = modelMapper.map(entity,Patient.class);
            list.add(patient);
        }
        return list;
    }
}
