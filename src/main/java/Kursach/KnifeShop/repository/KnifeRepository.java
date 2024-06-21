package Kursach.KnifeShop.repository;

import Kursach.KnifeShop.model.KnifeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KnifeRepository extends JpaRepository<KnifeModel, Long> {
    List<KnifeModel> findByType(String type);
    List<KnifeModel> findByModel(String model);
}
