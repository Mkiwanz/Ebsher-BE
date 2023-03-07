package project.ebsher.Service;


import project.ebsher.Entity.dto.LogIn.LogInResponseDTO;
import project.ebsher.Entity.dto.LogIn.LoginRequestDTO;
import project.ebsher.Entity.dto.LogIn.RefreshTokenRequestDTO;

public interface AuthService {

    LogInResponseDTO login(LoginRequestDTO loginRequest);
    LogInResponseDTO refreshToken(RefreshTokenRequestDTO refreshTokenRequest);
}
