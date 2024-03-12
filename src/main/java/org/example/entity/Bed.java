package org.example.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.BedStatus;

import java.lang.reflect.Type;
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
    @Enumerated(EnumType.STRING)
    private BedStatus status;
    @ManyToOne(fetch = FetchType.LAZY)
    private Ward ward;

    @OneToMany(mappedBy = "bed", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Admission> admissionList = new ArrayList<>();

    public Bed(String bedId, BedStatus status) {
        this.bedId = bedId;
        this.status = status;
    }
}
