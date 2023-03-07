package project.ebsher.Service.Impl;

import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.ebsher.Repository.UserRepo;


@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public MyUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s)
            throws UsernameNotFoundException, DataAccessException {
        var user = userRepo.findByEmail(s).get();
        return new MyUserDetails(user);
    }
}
