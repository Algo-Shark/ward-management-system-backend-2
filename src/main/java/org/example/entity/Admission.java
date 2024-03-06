package org.example.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String admissionId;
    private String admitDate;
    private String admitReson;
    private String status;
    private String Gurdient_name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;
}
