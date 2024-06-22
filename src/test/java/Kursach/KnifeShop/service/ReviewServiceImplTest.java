package Kursach.KnifeShop.service;

import Kursach.KnifeShop.model.KnifeModel;
import Kursach.KnifeShop.model.ReviewModel;
import Kursach.KnifeShop.model.User;
import Kursach.KnifeShop.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceImplTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    @Test
    public void testPostReview() {
        ReviewModel reviewModel = new ReviewModel();

        User user = new User();
        user.setId(1L);

        KnifeModel knifeModel = new KnifeModel();
        knifeModel.setId(1L);

        reviewModel.setId(1L);
        reviewModel.setKnifeModel(knifeModel);
        reviewModel.setUser(user);
        reviewModel.setRating(4);
        reviewModel.setReview("Best");

        reviewService.addReview(reviewModel, user.getId());

        Mockito.verify(reviewRepository, Mockito.times(1)).save(reviewModel);
    }
}
