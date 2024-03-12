package org.example.dto.requestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.DoctorAvailability;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorStatusUpdateRequest {
    private String doctorId;
    private DoctorAvailability newStatus;

    // Getters and setters
    public String  getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public DoctorAvailability getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(DoctorAvailability newStatus) {
        this.newStatus = newStatus;
    }

}
