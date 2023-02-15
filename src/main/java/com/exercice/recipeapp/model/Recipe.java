package com.exercice.recipeapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Recipe {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date creationDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private User author;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Ingredient> ingredients;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Category category;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String methodOfPreparation;

    public Recipe(long id, Date creationDate, String title) {
        this.id = id;
        this.creationDate = creationDate;
        this.title = title;
    }
}
