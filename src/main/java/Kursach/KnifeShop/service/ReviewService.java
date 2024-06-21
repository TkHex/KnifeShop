package Kursach.KnifeShop.service;

import Kursach.KnifeShop.model.ReviewModel;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    void addReview(ReviewModel reviewModel, Long id);

    Optional<ReviewModel> getReviewById(Long id);

    void deleteReviewById(Long id, Long knife_id);
}
