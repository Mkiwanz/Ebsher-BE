package project.ebsher.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.ebsher.Entity.dto.LogIn.LogInResponseDTO;
import project.ebsher.Entity.dto.LogIn.LoginRequestDTO;
import project.ebsher.Entity.dto.LogIn.RefreshTokenRequestDTO;
import project.ebsher.Service.AuthService;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return new ResponseEntity<LogInResponseDTO>(
                loginResponse, HttpStatus.OK);
    }

    @PostMapping("/refreshToken")
    public LogInResponseDTO refreshToken(@RequestBody RefreshTokenRequestDTO refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }
}
