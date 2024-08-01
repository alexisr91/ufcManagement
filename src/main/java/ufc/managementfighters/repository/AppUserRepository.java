package ufc.managementfighters.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufc.managementfighters.model.AppUser;



public interface AppUserRepository extends JpaRepository <AppUser, Integer> {
    
    public AppUser findByEmail(String email);
    public AppUser findByFirstName(String firstName);
}
