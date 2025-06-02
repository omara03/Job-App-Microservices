package com.project.JobApplication.review.Impl;

import com.project.JobApplication.company.Company;
import com.project.JobApplication.company.CompanyService;
import com.project.JobApplication.company.Impl.CompanyServiceImpl;
import com.project.JobApplication.review.Review;
import com.project.JobApplication.review.ReviewReposatory;
import com.project.JobApplication.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewReposatory reviewReposatory;
    private final CompanyService companyService;
    public ReviewServiceImpl(ReviewReposatory reviewReposatory, CompanyService companyServiceImpl) {
        this.reviewReposatory = reviewReposatory;
        this.companyService = companyServiceImpl;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews =reviewReposatory.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public Boolean addReview(Long companyId, Review review) {
        Company company=companyService.getCompanyById(companyId);
        if (company!=null){
            review.setCompany(company);
            reviewReposatory.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewReposatory.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);


    }

    @Override
    public Boolean  updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if (companyService.getCompanyById(companyId)!=null && reviewReposatory.existsById(reviewId)){
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewReposatory.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteReview(Long companyId, Long reviewId) {
        if (companyService.getCompanyById(companyId)!=null && reviewReposatory.existsById(reviewId)){
            Review review=reviewReposatory.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompany(company,companyId);
            reviewReposatory.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
