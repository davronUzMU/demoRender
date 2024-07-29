package uz.com.demorender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.com.demorender.model.location.LocationStreet;

public interface LocationStreetRepository extends JpaRepository<LocationStreet,Integer> {

}
