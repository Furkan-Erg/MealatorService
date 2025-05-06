package com.furkanerguldurenler.services;

import com.furkanerguldurenler.dto.AddIngredientsRequestDto;
import com.furkanerguldurenler.dto.ShoppingListDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface IShoppingListService {

    public void addIngredients(UserDetails userDetails, AddIngredientsRequestDto addIngredientsRequestDto);

    public void removeIngredientById(UserDetails userDetails, Integer ingredientId);

    public ShoppingListDto getShoppingList(UserDetails userDetails);

}
