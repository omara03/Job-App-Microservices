package com.Project1.reviewms.review.Impl;

import com.Project1.reviewms.review.Review;
import com.Project1.reviewms.review.ReviewReposatory;
import com.Project1.reviewms.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewReposatory reviewReposatory;
    public ReviewServiceImpl(ReviewReposatory reviewReposatory) {
        this.reviewReposatory = reviewReposatory;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews =reviewReposatory.findByCompanyId(companyId);
        return reviews;
    }



    @Override
    public Boolean addReview(Long companyId, Review review) {
        if (companyId!=null && review!=null) {
            review.setCompanyId(companyId);
            reviewReposatory.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long reviewId) {
        return reviewReposatory.findById(reviewId).orElse(null);
    }

    @Override
    public Boolean updateReview(Long reviewId, Review updatedReview) {
        Review review = reviewReposatory.findById(reviewId).orElse(null);
        if (review!=null){
            review.setCompanyId(updatedReview.getCompanyId());
            review.setTitle(updatedReview.getTitle());
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            reviewReposatory.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteReview(Long reviewId) {
        Review review = reviewReposatory.findById(reviewId).orElse(null);
        if (review!=null){
            reviewReposatory.delete(review);
            return true;
        }
        return false;
    }
}
