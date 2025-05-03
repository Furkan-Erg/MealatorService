package com.furkanerguldurenler.services;

import com.furkanerguldurenler.dto.AddIngredientsRequestDto;

public interface IShoppingListService {

    public void addIngredients(AddIngredientsRequestDto addIngredientsRequestDto);

    public void removeIngredientById(Long userId, Integer ingredientId);
}
