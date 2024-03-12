package org.example.controller;
import org.example.dto.BedDto;
import org.example.dto.requestDto.BedStatusUpdateRequest;
import org.example.entity.Bed;
import org.example.dto.responseDto.CustomResponse;
import org.example.service.BedService;
import org.example.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bed")
@CrossOrigin
public class BedController {
    @Autowired
    WardService wardService;

    @Autowired
    BedService bedService;
    @PostMapping("/add/{wid}")
    public ResponseEntity<CustomResponse<String>> addBed(@RequestBody BedDto bedDto, @PathVariable String wid){
        Bed bedDto1 =bedService.addBed(bedDto,wid);
        if(bedDto1!=null){
            CustomResponse<String> customResponse = new CustomResponse<>("BD"+bedDto1.getId(), "Success");
            return new ResponseEntity<>(customResponse, HttpStatus.OK);
        }else {
            CustomResponse<String> customResponse = new CustomResponse<>("The ward capacity is fulfill can't added new bed","Unsuccessful");
            return new ResponseEntity<>(customResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<CustomResponse<String>> getLastId(){
        String s = bedService.generateBedId();
        CustomResponse<String> customResponse = new CustomResponse<>(s, "Success");
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    @PutMapping("/status")
    public ResponseEntity<String> updateBedStatus(@RequestBody BedStatusUpdateRequest request){
        try{
            bedService.updateBedStatus(request.getBedId(),request.getNewStatus());
            return ResponseEntity.ok("Bed status updated successfully");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update bed status");
        }
    }
}
