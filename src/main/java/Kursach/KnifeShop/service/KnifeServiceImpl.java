package Kursach.KnifeShop.service;

import Kursach.KnifeShop.model.KnifeModel;
import Kursach.KnifeShop.repository.KnifeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class KnifeServiceImpl implements KnifeService {

    private final KnifeRepository knifeRepository;

    @Override
    public List<KnifeModel> getKnifeByModel(String model) {
        List<KnifeModel> knifes = knifeRepository.findByModel(model);
        return knifes;
    }

    @Override
    public List<KnifeModel> getKnifeByType(String type) {
        List<KnifeModel> knifes = knifeRepository.findByType(type);
        return knifes;
    }

    @Override
    public Optional<KnifeModel> getKnifeById(Long id) {
        return knifeRepository.findById(id);
    }

    @Override
    public void addKnife(KnifeModel knifeModel) {
        knifeRepository.save(knifeModel);
    }

    @Override
    public void deleteKnifeById(Long id) {
        knifeRepository.deleteById(id);
    }

    @Override
    public List<KnifeModel> getAllKnifes() {
        return knifeRepository.findAll();
    }
}
