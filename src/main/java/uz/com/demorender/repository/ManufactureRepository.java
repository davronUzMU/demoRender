package uz.com.demorender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.com.demorender.model.Manufacture;

public interface ManufactureRepository extends JpaRepository<Manufacture,Integer> {
    boolean existsByName(String name);
}
