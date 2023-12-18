package Group3.ShopAcc.Service;

import Group3.ShopAcc.Dto.ChangePasswordRequest;

import java.security.Principal;

public interface UserService {
    void changePassword(ChangePasswordRequest request, Principal connectedUser);
}
