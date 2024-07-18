package ufc.managementfighters.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ufc.managementfighters.model.AppUser;

@Service
public class AppUserService implements UserDetailsService {
    
    @Autowired
    private AppUserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{

        AppUser appUser= repo.findByEmail(email);

        // Check if you find the credentials
        if ( appUser != null){
            var springUser = User.withUsername(appUser.getEmail())
                        .password(appUser.getPassword())
                        .roles(appUser.getPassword())
                        .build();

            return springUser;
        }

        return null;
    }
}
