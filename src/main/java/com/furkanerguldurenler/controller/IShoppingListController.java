package com.furkanerguldurenler.controller;

import com.furkanerguldurenler.dto.AddIngredientsRequestDto;
import com.furkanerguldurenler.dto.ShoppingListDto;
import com.furkanerguldurenler.entities.RootEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface IShoppingListController {

    public RootEntity<String> addIngredients(UserDetails userDetails, AddIngredientsRequestDto addIngredientsRequestDto);

    public RootEntity<String> removeIngredientById(UserDetails userDetails, Integer ingredientId);

    public RootEntity<ShoppingListDto> getShoppingList(UserDetails userDetails);
}
