package com.exercice.recipeapp.controller;

import com.exercice.recipeapp.model.Recipe;
import com.exercice.recipeapp.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
}
