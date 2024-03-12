package org.example.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Bed;
import org.example.enums.BedStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BedDto {
    private String bedId;
    private BedStatus status;
}
