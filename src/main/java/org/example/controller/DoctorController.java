package org.example.controller;
import org.example.dto.DoctorDto;
import org.example.entity.CustomResponse;
import org.example.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor/")
@CrossOrigin
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity<CustomResponse<String>> addDoctor(@RequestBody DoctorDto doctorDto){
        DoctorDto doctorDto1 = doctorService.addDoctor(doctorDto);
        if(doctorDto1!=null){
            CustomResponse<String> success = new CustomResponse<>(doctorDto.getDoctorId(), "Success");
            return new ResponseEntity<>(success, HttpStatus.OK);
        }else {
            CustomResponse<String> unsuccess = new CustomResponse<>("null","unduccess");
            return new ResponseEntity<>(unsuccess,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<CustomResponse<String>> getLastId(){
        String doctorId = doctorService.generateDoctorId();
        if(doctorId!=null){
            CustomResponse<String> customResponse = new CustomResponse(doctorId,"success");
            return new ResponseEntity<>(customResponse,HttpStatus.OK);
        }else {
            CustomResponse<String> customResponse = new CustomResponse<>("null","unsuccess");
            return new ResponseEntity<>(customResponse,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<CustomResponse<String>> getDoctorCount(){
        int doctorCount = doctorService.availabelDoctorCount("AVAILABLE");
        if(doctorCount>=0){
            CustomResponse<String> customResponse = new CustomResponse<>(doctorCount+"","success");
            return new ResponseEntity<>(customResponse,HttpStatus.OK);
        }else {
            CustomResponse<String> customResponse = new CustomResponse<>("-1","unsuccess");
            return new ResponseEntity<>(customResponse,HttpStatus.BAD_REQUEST);
        }
    }
}
