package Rastek_fix.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Rastek_fix.demo.DTO.AuthReq;
import Rastek_fix.demo.DTO.TokenResponse;
import Rastek_fix.demo.DTO.WebResponse;
import Rastek_fix.demo.Service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public WebResponse<TokenResponse> authAndLogin(@RequestBody AuthReq request){
        TokenResponse tokenResponse = authService.auth(request);
        return WebResponse.<TokenResponse>builder().data(tokenResponse).message("Success").build();
    }
}
