package Kursach.KnifeShop.exceptions;

import Kursach.KnifeShop.model.ReviewModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ReviewNotFoundException extends RuntimeException {
    private final ReviewModel reviewModel;
}