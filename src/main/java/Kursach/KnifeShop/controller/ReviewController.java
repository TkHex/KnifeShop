package Kursach.KnifeShop.controller;

import Kursach.KnifeShop.model.FirmsModel;
import Kursach.KnifeShop.model.ReviewModel;
import Kursach.KnifeShop.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/{id}")
    public ResponseEntity<Void> addReview(@RequestBody ReviewModel reviewModel, @PathVariable Long id){
        reviewService.addReview(reviewModel, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/{knife_id}")
    public ResponseEntity<Void> deleteKnifeById(@PathVariable Long id, @PathVariable Long knife_id) {
        reviewService.deleteReviewById(id, knife_id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewModel> getReviewById(@PathVariable Long id){
        return reviewService.getReviewById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
