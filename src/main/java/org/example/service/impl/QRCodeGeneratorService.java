package org.example.service.impl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.example.dto.PatientDto;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class QRCodeGeneratorService {
    private final Gson gson;

    public QRCodeGeneratorService() {
        this.gson = new GsonBuilder().create();
    }
    public byte[] generateQRCodeImage(PatientDto patientDetails) throws WriterException, IOException {
        String details = convertPatientDetailsToString(patientDetails); // Convert patient details object to string
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        BitMatrix bitMatrix = qrCodeWriter.encode(details, BarcodeFormat.QR_CODE, 200, 200, hints);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private String convertPatientDetailsToString(PatientDto patientDetails) {
        return gson.toJson(patientDetails);
    }
}
