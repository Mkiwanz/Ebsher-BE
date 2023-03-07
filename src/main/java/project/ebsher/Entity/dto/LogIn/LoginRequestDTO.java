package project.ebsher.Entity.dto.LogIn;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestDTO {

    private String email;
    private String password ;
}
