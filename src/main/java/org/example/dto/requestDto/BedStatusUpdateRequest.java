package org.example.dto.requestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.BedStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BedStatusUpdateRequest {
    private String bedId;
    private BedStatus newStatus;


}
