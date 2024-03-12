package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Bed;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WardDto {
    private String wardId;
    private int capacity;
    private String wardType;
    private List<BedDto> bedList;
}
