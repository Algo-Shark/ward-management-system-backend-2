package org.example.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String wardId;
    private int capacity;
    private String wardType;

    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Bed> bedList = new ArrayList<>();
    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Admission> admissionList = new ArrayList<>();

    public Ward(String wardId, int capacity, String wardType) {
        this.wardId = wardId;
        this.capacity = capacity;
        this.wardType = wardType;
    }
}
