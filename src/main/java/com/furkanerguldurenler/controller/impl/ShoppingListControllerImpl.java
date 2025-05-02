package com.furkanerguldurenler.controller.impl;

import com.furkanerguldurenler.entities.RootEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furkanerguldurenler.controller.IShoppingListController;
import com.furkanerguldurenler.dto.AddIngredientsRequestDto;
import com.furkanerguldurenler.services.IShoppingListService;

@RestController
@RequestMapping("/rest/api/shoppinglist")
public class ShoppingListControllerImpl extends RestBaseController implements IShoppingListController {

    @Autowired
    private IShoppingListService shoppingListService;

    @PostMapping("/addingredients")
    @Override
    public RootEntity<String> addIngredients(@RequestBody AddIngredientsRequestDto addIngredientsRequestDto) {
        shoppingListService.addIngredients(addIngredientsRequestDto);
        return success();
    }

    @DeleteMapping("/users/{userId}/shoppinglist/ingredients/{ingredientId}")
    @Override
    public RootEntity<String> removeIngredientById(@PathVariable Integer userId, @PathVariable Integer ingredientId) {
        shoppingListService.removeIngredientById(userId, ingredientId);
        return success();
    }

}
