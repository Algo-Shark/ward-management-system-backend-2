package org.example.controller;
import org.example.service.PatientService;
import org.example.service.impl.QRCodeGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.google.zxing.WriterException;
import java.io.IOException;

@RestController
@RequestMapping("/api/qrcode")
public class QRCodeController {
    @Autowired
    PatientService patientService;
    @Autowired
    private QRCodeGeneratorService qrCodeGeneratorService;
    @PostMapping(value = "/generate/{PatinentId}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateQRCode(@PathVariable String PatinentId) throws IOException, WriterException {
        byte[] bytes = qrCodeGeneratorService.generateQRCodeImage(PatinentId);
        if(bytes!=null){
            return bytes;
        }else {
            return null;
        }
    }



}
