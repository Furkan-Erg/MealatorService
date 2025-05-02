package com.furkanerguldurenler.controller;

import com.furkanerguldurenler.dto.AddIngredientsRequestDto;

public interface IShoppingListController {

	public void addIngredients(AddIngredientsRequestDto addIngredientsRequestDto);
	
	public void removeIngredientById(Integer userId,Integer ingredientId);
}
