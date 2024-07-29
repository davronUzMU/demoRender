package uz.com.demorender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.com.demorender.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    boolean existsByParentIdAndName(Integer parentId, String name);
}
