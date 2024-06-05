package com.shubham.controller;

import com.shubham.exception.RecipeException;
import com.shubham.exception.UserException;
import com.shubham.model.Recipe;
import com.shubham.model.User;
import com.shubham.response.ApiResponse;
import com.shubham.service.RecipeService;
import com.shubham.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
	
	 @Autowired
	    private RecipeService recipeService;
	 @Autowired
	 private UserService userService;

	    @PostMapping
	    public ResponseEntity<Recipe> createRecipe(
	    		@RequestBody Recipe recipe, @RequestHeader("Authorization") String jwt) throws UserException {
	        // Assuming you have a way to fetch the user by userId from your service
	        User user = userService.findUserProfileByJwt(jwt);
	        Recipe newRecipe = recipeService.createRecipe(recipe, user);
	        return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") Long id) throws RecipeException {
	       
	            Recipe recipe = recipeService.findRecipeById(id);
	            return new ResponseEntity<>(recipe, HttpStatus.OK);
	         
	    }
	    @GetMapping
	    public ResponseEntity<List<Recipe>> getAllRecipe() throws RecipeException {
	       
	            List<Recipe> recipe = recipeService.findAllRecipe();
	            return new ResponseEntity<>(recipe, HttpStatus.OK);
	         
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<ApiResponse> deleteRecipe(@PathVariable("id") Long id) throws RecipeException {
	        
	            recipeService.deleteRecipe(id);
	            ApiResponse res=new ApiResponse("recipe deleted",true);
	            return new ResponseEntity<>(res, HttpStatus.OK);
	        
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") Long id, @RequestBody Recipe recipe) throws RecipeException {
	        
	            Recipe updatedRecipe = recipeService.updateRecipe(recipe,id);
	            return new ResponseEntity<>(updatedRecipe, HttpStatus.OK);
	        
	    }
	    
	    @PutMapping("/{id}/like")
	    public ResponseEntity<Recipe> likeRecipe(
	    		@RequestHeader("Authorization") String jwt, 
	    		@PathVariable("id") Long id 
	    		) throws RecipeException, UserException {
	    	User user = userService.findUserProfileByJwt(jwt);
	            Recipe updatedRecipe = recipeService.likeRecipe(id, user);
	            return new ResponseEntity<>(updatedRecipe, HttpStatus.OK);
	        
	    }

}
