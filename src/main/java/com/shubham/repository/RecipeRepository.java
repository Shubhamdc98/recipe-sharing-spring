package com.shubham.repository;

import com.shubham.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

	List<Recipe> findAllByOrderByCreatedAtDesc();
}
