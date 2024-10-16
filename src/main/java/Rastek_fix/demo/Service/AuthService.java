package Rastek_fix.demo.Service;

import Rastek_fix.demo.Config.JwtService;
import Rastek_fix.demo.DTO.AuthReq;
import Rastek_fix.demo.DTO.TokenResponse;
import Rastek_fix.demo.Entity.UserEntity;
import Rastek_fix.demo.Repository.UserRepository;
import Rastek_fix.demo.Security.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {


    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    public TokenResponse auth(AuthReq request){
        validationService.validate(request);
        String token = "";

        UserEntity user_auth = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password wrong"));

        if (user_auth.is_deleted()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Is Deleted from our World");
        }

        if(BCrypt.checkpw(request.getPassword(), user_auth.getPassword())){
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            if (authentication.isAuthenticated()) {
                token = jwtService.generateToken(request.getUsername());
            }
            return TokenResponse.builder()
                    .token(token)
                    .username(user_auth.getUsername())
                    .email(user_auth.getEmail())
                    .build();
        }else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password wrong");
        }
    }

}

