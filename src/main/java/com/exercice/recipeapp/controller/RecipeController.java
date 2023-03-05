package com.exercice.recipeapp.controller;

import com.exercice.recipeapp.model.Recipe;
import com.exercice.recipeapp.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/recipeApp")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping(value = "/recipeList")
    public List<Recipe> recipeList() {
        return recipeRepository.findAll();
    }

    @PostMapping(value = "/saveRecipe")
    public Recipe saveRecipe(@RequestBody Recipe recipe) {
        recipe.setCreationDate(new Date());
        return recipeRepository.save(recipe);
    }

    @PutMapping(value = "/updateRecipe/{id}")
    public Recipe updateRecipe(@PathVariable("id") Long id, @RequestBody Recipe recipe) {
        recipe.setId(id);
        return recipeRepository.save(recipe);
    }

    @GetMapping(value = "/findRecipe/{id}")
    public ResponseEntity<?> findRecipe(@PathVariable("id") long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            return ResponseEntity.ok().body(recipe);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Recipe with id: %s not found.", id));
    }

    @DeleteMapping(value = "/deleteRecipe/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable("id") long id) {
        try {
            recipeRepository.deleteById(id);
            return ResponseEntity.ok().body("Recipe deleted successfully!");
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Recipe not found for deletion!");
        }
    }
}
