package org.example.controller;
import org.example.entity.CustomResponse;
import org.example.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admission")
@CrossOrigin
public class AdmissionController {

    @Autowired
    AdmissionService admissionService;

    @GetMapping("/get")
    public ResponseEntity<CustomResponse<String>> getLastId(){
        String s = admissionService.generateAdmissionId();
        CustomResponse<String> customResponse = new CustomResponse<>(s, "Success");
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }
}
