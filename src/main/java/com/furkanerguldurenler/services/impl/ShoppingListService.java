package com.furkanerguldurenler.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkanerguldurenler.dto.AddIngredientsRequestDto;
import com.furkanerguldurenler.entities.Ingredient;
import com.furkanerguldurenler.entities.ShoppingList;
import com.furkanerguldurenler.entities.User;
import com.furkanerguldurenler.repository.IngredientRepository;
import com.furkanerguldurenler.repository.ShoppingListRepository;
import com.furkanerguldurenler.repository.UserRepository;
import com.furkanerguldurenler.services.IShoppingListService;

@Service
public class ShoppingListService implements IShoppingListService {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public void addIngredients(AddIngredientsRequestDto addIngredientsRequestDto) {
        long userId = addIngredientsRequestDto.getUserId();
        List<Integer> ingredientIds = addIngredientsRequestDto.getIngredientIds();

        User user = userRepository.findById(userId).orElseThrow();

        ShoppingList shoppingList = user.getShoppingList();

        List<Ingredient> ingredients = ingredientRepository.findAllById(ingredientIds);

        shoppingList.getIngredient().addAll(ingredients);

        shoppingListRepository.save(shoppingList);
    }

    @Override
    public void removeIngredientById(Long userId, Integer ingredientId) {

        User user = userRepository.findById(userId).orElseThrow();
        ShoppingList shoppingList = user.getShoppingList();

        Ingredient ingredient = ingredientRepository.findById(ingredientId).orElseThrow();

        shoppingList.getIngredient().remove(ingredient);

        shoppingListRepository.save(shoppingList);
    }

}
