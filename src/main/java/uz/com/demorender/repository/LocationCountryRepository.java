package uz.com.demorender.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.com.demorender.model.location.LocationCountry;

public interface LocationCountryRepository extends JpaRepository<LocationCountry,Integer> {

}
