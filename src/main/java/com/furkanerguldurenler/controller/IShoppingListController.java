package com.furkanerguldurenler.controller;

import com.furkanerguldurenler.dto.AddIngredientsRequestDto;
import com.furkanerguldurenler.entities.RootEntity;

public interface IShoppingListController {

    public RootEntity<String> addIngredients(AddIngredientsRequestDto addIngredientsRequestDto);

    public RootEntity<String> removeIngredientById(Long userId, Integer ingredientId);
}
