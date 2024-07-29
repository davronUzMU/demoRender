package uz.com.demorender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.com.demorender.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
