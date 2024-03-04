package org.example.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomResponse {
        private String userId;
        private String status;

    CustomResponse(String status){
            this.status =status;
    }
}
