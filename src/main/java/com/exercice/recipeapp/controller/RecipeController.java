package com.exercice.recipeapp.controller;

import com.exercice.recipeapp.model.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/recipeApp")
public class RecipeController {
    @GetMapping(value = "/recipeList")
    public List<Recipe> recipeList() {
        Recipe recipe1 = new Recipe(1L, new Date(), "Bolo de Fubá");
        Recipe recipe2 = new Recipe(2L, new Date(), "Bolo de Laranja");

        List<Recipe> recipes = new ArrayList<>();

        recipes.add(recipe1);
        recipes.add(recipe2);

        return recipes;
    }
}
