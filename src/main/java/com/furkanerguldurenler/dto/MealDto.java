package com.furkanerguldurenler.dto;

import com.furkanerguldurenler.entities.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealDto {

    private Integer id;
    private String name;
    private String description;
    private List<IngredientDto> ingredientList;
}
