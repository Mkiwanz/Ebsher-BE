package project.ebsher.Entity.dto.LogIn;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogInResponseDTO {
    private String accessToken;
    private String refreshToken;
    private String userName;
    private long userId;
}
