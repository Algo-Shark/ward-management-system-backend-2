package org.example.service.impl;
import lombok.RequiredArgsConstructor;
import org.example.dto.AdmissionDto;
import org.example.dto.AdmissionRequest;
import org.example.entity.Admission;
import org.example.entity.Bed;
import org.example.entity.Patient;
import org.example.entity.Ward;
import org.example.repository.AdmissionRepository;
import org.example.repository.BedRepository;
import org.example.repository.PatientRepository;
import org.example.repository.WardRepository;
import org.example.service.AdmissionService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdmissionServiceImpl implements AdmissionService {
    final AdmissionRepository admissionRepository;
    final PatientRepository patientRepository;
    final BedRepository bedRepository;
    final WardRepository wardRepository;

    ModelMapper modelMapper;
    @Bean
    public void mapadmission(){
        this.modelMapper = new ModelMapper();
    }
    public AdmissionDto setAdmission(AdmissionRequest admissionRequest){
        AdmissionDto admissionDto = admissionRequest.getAdmissionDto();
        Admission admission = new Admission(admissionDto.getAdmissionId(),admissionDto.getAdmitDate(),admissionDto.getAdmitReson(),admissionDto.getStatus(),admissionDto.getGurdient_name());
        Patient patient =  patientRepository.findByPatientId(admissionRequest.getPatinetId());
        Ward ward = wardRepository.findBywardId(admissionRequest.getWardId());
        Bed bed = bedRepository.findByBedId(admissionRequest.getBedId());
        if(admission!=null){

            admission.setWard(ward);
            admission.setBed(bed);
            admission.setPatient(patient);
            Admission save = admissionRepository.save(admission);
            patient.getAdmissionsList().add(save);
            ward.getAdmissionList().add(save);
            bed.getAdmissionList().add(save);

            AdmissionDto mapped = modelMapper.map(save, AdmissionDto.class);
            return mapped;
        }else {
            return null;
        }
    }

    public String generateAdmissionId(){
        Long id =  admissionRepository.findMaxId();
        if(id!=null){
            ++id;
            return "AD"+id;
        }else {
            return "AD"+1;
        }
    }
}
