package com.project.JobApplication.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewReposatory extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(Long companyId);
}
