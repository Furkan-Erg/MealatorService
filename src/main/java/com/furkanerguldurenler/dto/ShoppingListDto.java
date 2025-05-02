package com.furkanerguldurenler.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingListDto {

	private Integer id;

	private String name;

	private List<IngredientDto> ingredientList;
}
