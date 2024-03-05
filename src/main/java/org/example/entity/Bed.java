package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Bed {
    @Id
    private Long id;
    private String bed_id;
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wardId")
    private Ward ward;

}
