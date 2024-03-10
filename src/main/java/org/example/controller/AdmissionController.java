package org.example.controller;
import org.example.dto.AdmissionDto;
import org.example.dto.AdmissionRequest;
import org.example.dto.responseDto.CustomResponse;
import org.example.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admission")
@CrossOrigin
public class AdmissionController {

    @Autowired
    AdmissionService admissionService;

    @PostMapping("/add")
    public ResponseEntity<CustomResponse<String>> setAdmission(@RequestBody AdmissionRequest admissionRequest){
        AdmissionDto admissionDto = admissionService.setAdmission(admissionRequest);
        if(admissionDto!=null){
            CustomResponse customResponse = new CustomResponse(admissionDto.getAdmissionId(),"Successfull");
            return new ResponseEntity<>(customResponse,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<CustomResponse<String>> getLastId(){
        String s = admissionService.generateAdmissionId();
        CustomResponse<String> customResponse = new CustomResponse<>(s, "Success");
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }
}
