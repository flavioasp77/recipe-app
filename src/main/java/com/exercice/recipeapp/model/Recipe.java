package com.exercice.recipeapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name="title", length = 100, nullable = false)
    private String title;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name="description", length = 250, nullable = false)
    private String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private User author;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Ingredient> ingredients;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private Category category;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name="methodOfPreparation", length = 3000, nullable = false)
    private String methodOfPreparation;

    public Recipe(long id, Date creationDate, String title) {
        this.id = id;
        this.creationDate = creationDate;
        this.title = title;
    }
}
