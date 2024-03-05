package org.example.service.impl;
import lombok.RequiredArgsConstructor;
import org.example.dto.PatientDto;
import org.example.entity.Patient;
import org.example.repository.PatientRepository;
import org.example.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

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
        Patient patient = modelMapper.map(patientDto, Patient.class);
        if(patient!=null){
            Patient patient1 = patientRepository.save(patient);
            patientRepository.save(patient1);
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
}
