package uz.com.demorender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.com.demorender.model.location.LocationCity;

public interface LocationCityRepository extends JpaRepository<LocationCity,Integer> {
}
