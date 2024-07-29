package uz.com.demorender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.com.demorender.model.location.LocationRegion;

public interface LocationRegionRepository extends JpaRepository<LocationRegion,Integer> {

    @Query(value = "select regionParentId from location-region ",
            nativeQuery = true)
    Iterable<Integer> findAllByParentId();
}
