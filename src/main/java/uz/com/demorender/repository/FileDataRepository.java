package uz.com.demorender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.com.demorender.model.FileData;

public interface FileDataRepository extends JpaRepository<FileData,Integer> {
}
