package Kursach.KnifeShop.service;

import Kursach.KnifeShop.exceptions.KnifesNotFoundException;
import Kursach.KnifeShop.exceptions.ReviewNotFoundException;
import Kursach.KnifeShop.model.KnifeModel;
import Kursach.KnifeShop.model.ReviewModel;
import Kursach.KnifeShop.repository.KnifeRepository;
import Kursach.KnifeShop.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;

    private final KnifeRepository knifeRepository;

    private void findAndUpdateKnifeRating(Long id) {
        Optional<KnifeModel> optionalKnifeModel = knifeRepository.findById(id);
        if (optionalKnifeModel.isEmpty()) {
            throw new KnifesNotFoundException(id);
        }

        KnifeModel knifeModel = optionalKnifeModel.get();
        List<ReviewModel> reviews = reviewRepository.findByKnifeModelId(id);
        if (reviews.isEmpty()) {
            throw new ReviewNotFoundException((ReviewModel) reviews);
        }

        double averageRating = reviews.stream()
                .collect(Collectors.averagingDouble(ReviewModel::getRating));
        knifeModel.setRating(averageRating);
        knifeRepository.save(knifeModel);
    }


    @Override
    @Transactional
    public void addReview(ReviewModel reviewModel, Long id) {
        reviewRepository.save(reviewModel);
        findAndUpdateKnifeRating(id);
    }

    @Override
    public Optional<ReviewModel> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public void deleteReviewById(Long id, Long knife_id) {
        reviewRepository.deleteById(id);
        findAndUpdateKnifeRating(knife_id);
    }
}
