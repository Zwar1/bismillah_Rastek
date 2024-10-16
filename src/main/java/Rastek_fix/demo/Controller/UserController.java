package Rastek_fix.demo.Controller;

import Rastek_fix.demo.DTO.CreateUserReq;
import Rastek_fix.demo.DTO.UserRes;
import Rastek_fix.demo.DTO.WebResponse;
import Rastek_fix.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public WebResponse<UserRes> Create(@RequestBody CreateUserReq request){
        UserRes registerUserResponse = userService.Create_User(request);
        return WebResponse.<UserRes>builder().data(registerUserResponse).message("Success").build();
    }

    // @DeleteMapping("/delete")
    // public WebResponse<UserRes> Delete(@RequestBody CreateUserReq request){
    //     UserRes registerUserResponse = userService.Delete_User(request);
    //     return WebResponse.<UserRes>builder().data(registerUserResponse).message("Success").build();
    // }
}
