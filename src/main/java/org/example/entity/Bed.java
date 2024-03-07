package org.example.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@NamedQuery(
        name = "Bed.findMaxId",
        query = "SELECT MAX(b.id) FROM Bed b"
)
public class Bed {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String bedId;
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    private Ward ward;

    @OneToMany(mappedBy = "bed", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Admission> admissionList = new ArrayList<>();

    public Bed(String bedId, String status) {
        this.bedId = bedId;
        this.status = status;
    }
}
