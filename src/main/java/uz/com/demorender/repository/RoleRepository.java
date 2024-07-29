package uz.com.demorender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.com.demorender.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {

}
