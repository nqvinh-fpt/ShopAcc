package Group3.ShopAcc.Service;

import Group3.ShopAcc.Dto.ChangePasswordRequest;
import Group3.ShopAcc.Entity.Account;
import Group3.ShopAcc.Repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    @Override
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {
        var account = (Account)((UsernamePasswordAuthenticationToken)connectedUser).getPrincipal();
        //if password is correct
        if(!passwordEncoder.matches(request.getCurrentPassword(),account.getPassword())){
            throw new IllegalStateException("Incorrect Password");
        }
        //if confirm password is correct
        if(!request.getNewPassword().equals(request.getConfirmPassword())){
            throw new IllegalStateException("Incorrect Confirm Password");
        }
        //update the password
        account.setPassword(passwordEncoder.encode(request.getNewPassword()));
        //save new password
        accountRepository.save(account);
    }
}
