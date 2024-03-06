package org.example.service.impl;
import lombok.RequiredArgsConstructor;
import org.example.repository.AdmissionRepository;
import org.example.service.AdmissionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdmissionServiceImpl implements AdmissionService {
    final AdmissionRepository admissionRepository;

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
