package Kursach.KnifeShop.controller;

import Kursach.KnifeShop.model.ReviewModel;
import Kursach.KnifeShop.service.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReviewGetControllerTest {

    @Mock
    private ReviewService reviewService;

    @InjectMocks
    private ReviewController reviewController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetReviewById() {
        Long reviewId = 1L;
        ReviewModel reviewModel = new ReviewModel();
        when(reviewService.getReviewById(reviewId)).thenReturn(Optional.of(reviewModel));

        ResponseEntity<ReviewModel> response = reviewController.getReviewById(reviewId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(reviewModel, response.getBody());
    }
}