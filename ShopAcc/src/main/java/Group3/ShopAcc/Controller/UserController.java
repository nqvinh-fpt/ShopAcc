package Group3.ShopAcc.Controller;

import Group3.ShopAcc.Dto.ChangePasswordRequest;
import Group3.ShopAcc.Service.AccountServiceImpl;
import Group3.ShopAcc.Service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
    @PostMapping
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest, Principal connectedUser){
        userService.changePassword(changePasswordRequest, connectedUser);
        return ResponseEntity.ok().build();
    }
}
