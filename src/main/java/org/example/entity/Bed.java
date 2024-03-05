package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private String bed_id;
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wardId")
    private Ward ward;


}
