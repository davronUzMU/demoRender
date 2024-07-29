package uz.com.demorender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.com.demorender.model.location.LocationHouse;

public interface LocationHouseRepository extends JpaRepository<LocationHouse,Integer> {
}
