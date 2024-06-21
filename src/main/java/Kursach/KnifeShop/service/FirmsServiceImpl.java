package Kursach.KnifeShop.service;

import Kursach.KnifeShop.model.FirmsModel;
import Kursach.KnifeShop.repository.FirmsRepository;
import Kursach.KnifeShop.repository.KnifeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FirmsServiceImpl implements FirmsService {

    private final FirmsRepository firmsRepository;

    @Override
    public void addFirm(FirmsModel firmsModel) {
        firmsRepository.save(firmsModel);
    }

    @Override
    public Optional<FirmsModel> getFirmById(Long id) {
        return firmsRepository.findById(id);
    }

    @Override
    public void deleteFirmById(Long id) {
        firmsRepository.deleteById(id);
    }
}
