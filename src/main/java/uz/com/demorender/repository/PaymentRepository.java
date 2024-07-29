package uz.com.demorender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.com.demorender.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
