package com.example.reviewapp.infrastructure.repository;

import com.example.reviewapp.infrastructure.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByUuid(String uuid);


}
