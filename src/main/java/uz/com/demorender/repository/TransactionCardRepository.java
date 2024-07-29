package uz.com.demorender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.com.demorender.model.TransactionCard;

public interface TransactionCardRepository extends JpaRepository<TransactionCard,Integer> {
}
