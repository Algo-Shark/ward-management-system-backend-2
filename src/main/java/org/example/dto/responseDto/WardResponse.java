package org.example.dto.responseDto;

import lombok.*;
import org.example.dto.BedDto;
import org.example.entity.Bed;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WardResponse<T> {
    private String wardId;
    private List<BedDto> bedList;

    public WardResponse(String wardId) {
        this.wardId = wardId;
    }

    public WardResponse(List<BedDto> bedList) {
        this.bedList = bedList;
    }
}
