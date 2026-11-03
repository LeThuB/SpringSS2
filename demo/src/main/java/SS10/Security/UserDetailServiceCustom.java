package SS10.Security;

import SS10.Model.entity.User;
import SS10.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceCustom implements UserDetailsService {
@Autowired
    private UserRepository userRepository;
@Override
    public UserPrincipal loadUserByUsername(String username)
    throws UsernameNotFoundException{
    User user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Khong tim thay nguoi dung co username :"+ username));
    return new UserPrincipal(user);
}

}
