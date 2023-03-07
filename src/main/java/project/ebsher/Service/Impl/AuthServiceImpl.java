package project.ebsher.Service.Impl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import project.ebsher.Entity.User;
import project.ebsher.Entity.dto.LogIn.LogInResponseDTO;
import project.ebsher.Entity.dto.LogIn.LoginRequestDTO;
import project.ebsher.Entity.dto.LogIn.RefreshTokenRequestDTO;
import project.ebsher.Service.AuthService;
import project.ebsher.Service.UserService;
import project.ebsher.Util.Helper.JwtUtil;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    @Autowired
    public AuthServiceImpl(UserDetailsService userDetailsService, JwtUtil jwtUtil, UserService userService, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public LogInResponseDTO login(LoginRequestDTO loginRequest) {

        // data type from security dependency
        Authentication result = null;

        try {
            // Authentication manager is an interface that comes with spring security authentication package
            result = authenticationManager.authenticate(
                    // also comes with spring security
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(result.getName());
        final String accessToken = jwtUtil.generateToken(userDetails);
        final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());
        User user = userService.findAllByEmail(loginRequest.getEmail());
        return new LogInResponseDTO(accessToken, refreshToken, user.getUsername(), user.getId());
    }

    @Override
    public LogInResponseDTO refreshToken(RefreshTokenRequestDTO refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            // TODO (check the expiration of the accessToken when request sent, if the is recent according to
            //  issue Date, then accept the renewal)
            var isAccessTokenExpired = jwtUtil.isTokenExpired(refreshTokenRequest.getAccessToken());
            if (isAccessTokenExpired)
                System.out.println("ACCESS TOKEN IS EXPIRED"); // TODO Renew is this case
            else
                System.out.println("ACCESS TOKEN IS NOT EXPIRED");
            final String accessToken = jwtUtil.doGenerateToken(jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
            String userName = jwtUtil.getUsernameFromToken(refreshTokenRequest.getAccessToken());
            User user = userService.findAllByEmail(userName);
            var loginResponse = new LogInResponseDTO(accessToken, refreshTokenRequest.getRefreshToken(), userName, user.getId());
            // TODO (OPTIONAL) When to renew the refresh token?
            return loginResponse;
        }
        return new LogInResponseDTO();
    }
}
