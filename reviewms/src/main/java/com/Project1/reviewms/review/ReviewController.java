package com.Project1.reviewms.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId,@RequestBody Review review){
        Boolean isReviewSaved = reviewService.addReview(companyId,review);
        if(isReviewSaved) return new ResponseEntity<>("Review added successfully",HttpStatus.CREATED);
        return new ResponseEntity<>("Review Not Sav ed",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(reviewId),HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId,@RequestBody Review review){
        Boolean isReviewUpdated=reviewService.updateReview(reviewId,review);
        if(isReviewUpdated)
        return new ResponseEntity<>("Review updated successfully",HttpStatus.OK);
        return new ResponseEntity<>("Review Not Updated",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId){
        Boolean isReviewDeleted=reviewService.deleteReview(reviewId);
        if(isReviewDeleted)
            return new ResponseEntity<>("Review Deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>("Review Not Deleted",HttpStatus.NOT_FOUND);

    }

}
