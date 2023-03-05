package com.exercice.recipeapp.controller;

import com.exercice.recipeapp.model.Recipe;
import com.exercice.recipeapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/recipeApp")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping(value = "/recipeList")
    public ResponseEntity<List<Recipe>> recipeList() {
        return ResponseEntity.ok().body(recipeService.recipList());
    }

    @PostMapping(value = "/saveRecipe")
    public ResponseEntity<?> saveRecipe(@RequestBody Recipe recipe) {
        recipe = recipeService.saveRecipe(recipe);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/findRecipe/{id}")
                .buildAndExpand(recipe.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/updateRecipe/{id}")
    public ResponseEntity<?> updateRecipe(@PathVariable("id") Long id, @RequestBody Recipe recipe) {
        try {
            recipeService.updateRecipe(id, recipe);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping(value = "/findRecipe/{id}")
    public ResponseEntity<?> findRecipe(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok().body(recipeService.findRecipe(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/deleteRecipe/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable("id") Long id) {
        try {
            recipeService.deleteRecipe(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
