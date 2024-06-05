package com.shubham.service;

import com.shubham.exception.RecipeException;
import com.shubham.model.Recipe;
import com.shubham.model.User;

import java.util.List;

public interface RecipeService {
	
	public Recipe createRecipe(Recipe recipe, User user);
	
	public Recipe findRecipeById(Long id) throws RecipeException;
	
	public void deleteRecipe(Long id) throws RecipeException;
	
	public Recipe updateRecipe(Recipe recipe,Long id) throws RecipeException;
	
	public List<Recipe> findAllRecipe();
	
	public Recipe likeRecipe(Long recipeId,User user) throws RecipeException;

}
