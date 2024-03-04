package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Patient {
    @Id
    private Long id;
    private String patientId;
    private String NIC;
    private String name;
    private String nationality;
    private String gender;
    private String telephone;
    private String religion;
    private String address;
    private String dob;

    public String generateUserId() {
        if (id != null) {
            this.patientId = "PT" + id; // Example prefix + auto-generated ID
            return patientId;
        } else {
            // Handle the case where the ID is not set yet
            // This might happen if the object is not persisted yet
            this.patientId = "PT1";
        }
        return null;
    }
}
