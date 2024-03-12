package org.example.controller;
import org.example.dto.WardDto;
import org.example.dto.responseDto.CustomResponse;
import org.example.dto.responseDto.WardResponse;
import org.example.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/ward")
@CrossOrigin
public class WardController {
    @Autowired
    WardService wardService;
    @PostMapping("/add")
    public ResponseEntity<WardResponse<String>> addWard(@RequestBody WardDto wardDto){
        WardDto wardDto1 = wardService.addWard(wardDto);
        if(wardDto1!=null){
            WardResponse<String> wardResponse = new WardResponse<>(wardDto1.getWardId(), wardDto1.getBedList());
            System.out.println(wardDto1.getBedList().size());
            return new ResponseEntity<>(wardResponse, HttpStatus.OK);
        }else {
            WardResponse<String> wardResponse = new WardResponse<>("Alredy registerd");
            return new ResponseEntity<>(wardResponse, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get")
    public ResponseEntity<CustomResponse<String>> getLastId(){
        String s = wardService.generateWardId();
        CustomResponse<String> customResponse = new CustomResponse<>(s, "Success");
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }



}
