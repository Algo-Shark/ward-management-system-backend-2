package org.example.controller;
import org.example.dto.PatientDto;
import org.example.entity.CustomResponse;
import org.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {
    @Autowired
    PatientService patientService;
    @PostMapping("/add")
    public  ResponseEntity<CustomResponse<String>> addPatient(@RequestBody PatientDto patientDto){
        PatientDto patientDto1 = patientService.addPatient(patientDto);
        if(patientDto!=null){
            CustomResponse<String> customResponse = new CustomResponse<>(patientDto1.getPatientId(), "Success");
            return new ResponseEntity<>(customResponse,HttpStatus.OK);
        }else {
            CustomResponse<String> customResponse = new CustomResponse<>("Alredy registerd","Unsuccessful");
            return new ResponseEntity<>(customResponse, HttpStatus.BAD_REQUEST);
        }
    }
}
