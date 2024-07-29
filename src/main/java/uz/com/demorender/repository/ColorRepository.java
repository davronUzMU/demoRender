package uz.com.demorender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.com.demorender.model.Color;

public interface ColorRepository extends JpaRepository<Color,Integer> {

   // boolean existsByName(String color);
}
