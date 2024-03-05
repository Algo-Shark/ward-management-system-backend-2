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
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String wardId;
    private int capacity;
    private String wardType;
    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Bed> bedList = new ArrayList<>();


    public String generateWardId(){
        if(id!=null){
            this.wardId="WD"+id;
            return wardId;
        }else {
            return "WD1";
        }
    }
}
