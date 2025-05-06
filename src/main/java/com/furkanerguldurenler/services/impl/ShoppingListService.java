package com.furkanerguldurenler.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.furkanerguldurenler.dto.IngredientDto;
import com.furkanerguldurenler.dto.ShoppingListDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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
    public void addIngredients(UserDetails userDetails, AddIngredientsRequestDto addIngredientsRequestDto) {
        String username = userDetails.getUsername();
        List<Integer> ingredientIds = addIngredientsRequestDto.getIngredientIds();

        User user = userRepository.findByUsername(username).orElseThrow();

        ShoppingList shoppingList = user.getShoppingList();

        List<Ingredient> ingredients = ingredientRepository.findAllById(ingredientIds);

        shoppingList.getIngredient().addAll(ingredients);

        shoppingListRepository.save(shoppingList);
    }

    @Override
    public void removeIngredientById(UserDetails userDetails, Integer ingredientId) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        ShoppingList shoppingList = user.getShoppingList();
        Ingredient ingredient = ingredientRepository.findById(ingredientId).orElseThrow();
        shoppingList.getIngredient().remove(ingredient);
        shoppingListRepository.save(shoppingList);
    }

    @Override
    public ShoppingListDto getShoppingList(UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        ShoppingList shoppingList = user.getShoppingList();
        List<Ingredient> ingredientList = shoppingList.getIngredient();
        List<IngredientDto> ingredientDtoList = new ArrayList<>();
        for (Ingredient ingredient : ingredientList) {
            IngredientDto ingredientDto = new IngredientDto();
            BeanUtils.copyProperties(ingredient, ingredientDto);
            ingredientDtoList.add(ingredientDto);
        }
        ShoppingListDto shoppingListDto = new ShoppingListDto();
        BeanUtils.copyProperties(shoppingList, shoppingListDto);
        shoppingListDto.setIngredientList(ingredientDtoList);
        return shoppingListDto;
    }

}
