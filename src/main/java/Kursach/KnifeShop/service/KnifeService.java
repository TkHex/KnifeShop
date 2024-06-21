package Kursach.KnifeShop.service;

import Kursach.KnifeShop.model.KnifeModel;

import java.util.List;
import java.util.Optional;

public interface KnifeService {

    List<KnifeModel> getKnifeByModel(String model);

    List<KnifeModel> getKnifeByType(String type);

    Optional<KnifeModel> getKnifeById(Long id);

    void addKnife(KnifeModel knifeModel);

    void deleteKnifeById(Long id);

    List<KnifeModel> getAllKnifes();
}
