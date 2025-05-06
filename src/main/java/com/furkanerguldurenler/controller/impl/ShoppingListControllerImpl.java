package com.furkanerguldurenler.controller.impl;

import com.furkanerguldurenler.dto.ShoppingListDto;
import com.furkanerguldurenler.entities.RootEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

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
    public RootEntity<String> addIngredients(@AuthenticationPrincipal UserDetails userDetails, @RequestBody AddIngredientsRequestDto addIngredientsRequestDto) {
        shoppingListService.addIngredients(userDetails, addIngredientsRequestDto);
        return success();
    }

    @DeleteMapping("/ingredients/delete/{ingredientId}")
    @Override
    public RootEntity<String> removeIngredientById(@AuthenticationPrincipal UserDetails userDetails, @PathVariable Integer ingredientId) {
        shoppingListService.removeIngredientById(userDetails, ingredientId);
        return success();
    }

    @GetMapping("/list")
    @Override
    public RootEntity<ShoppingListDto> getShoppingList(@AuthenticationPrincipal UserDetails userDetails) {
        return ok(shoppingListService.getShoppingList(userDetails));
    }

}
