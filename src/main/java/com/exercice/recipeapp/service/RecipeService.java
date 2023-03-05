package com.exercice.recipeapp.service;

import com.exercice.recipeapp.model.Recipe;
import com.exercice.recipeapp.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> recipList() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> findRecipe(long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            return recipe;
        }
        throw  new RuntimeException(String.format("Recipe with id %s not found!", id));
    }

    public Recipe saveRecipe(Recipe recipe) {
        recipe.setId(null);
        recipe.setCreationDate(new Date());
        return recipeRepository.save(recipe);
    }

    public void updateRecipe(Long id, Recipe recipe) {
        if (recipeRepository.findById(id).isEmpty()) {
            throw  new RuntimeException(String.format("Recipe with id %s not found!", id));
        }
        recipe.setId(id);
        recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id) {
        if (recipeRepository.findById(id).isEmpty()) {
            throw  new RuntimeException(String.format("Recipe with id %s not found!", id));
        }
        recipeRepository.deleteById(id);
    }
}
