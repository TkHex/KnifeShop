package Kursach.KnifeShop.repository;

import Kursach.KnifeShop.model.CartModel;
import Kursach.KnifeShop.model.FirmsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartModel, Long> {
    List<CartModel> findByUserId(Long userId);
}
