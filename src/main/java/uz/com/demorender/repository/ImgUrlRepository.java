package uz.com.demorender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.com.demorender.model.ImgUrl;


public interface ImgUrlRepository extends JpaRepository<ImgUrl, Integer> {

//    Optional<ImgUrl> findByName(String filename);
//    Optional<ImgUrl> findByFileOriginalName(String filename);
}
