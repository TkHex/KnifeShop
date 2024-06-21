package Kursach.KnifeShop.repository;

import Kursach.KnifeShop.model.CartModel;
import Kursach.KnifeShop.model.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel, Long> {
    List<ReviewModel> findByKnifeModelId(Long knife_id);
    List<ReviewModel> findByUserId(Long userId);
}
