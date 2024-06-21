package Kursach.KnifeShop.service;

import Kursach.KnifeShop.model.FirmsModel;

import java.util.List;
import java.util.Optional;

public interface FirmsService {

    void addFirm(FirmsModel firmsModel);
    Optional<FirmsModel> getFirmById(Long id);

    void deleteFirmById(Long id);
}
