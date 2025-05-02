package com.furkanerguldurenler.controller.impl;

import java.util.List;

import com.furkanerguldurenler.entities.RootEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furkanerguldurenler.controller.IIngredientController;
import com.furkanerguldurenler.dto.IngredientDto;
import com.furkanerguldurenler.services.IIngredientService;

@RestController
@RequestMapping("/rest/api/ingredient")
public class IngredientControllerImpl extends RestBaseController implements IIngredientController {

    @Autowired
    private IIngredientService ingredientService;

    @PostMapping(path = "/add")
    @Override
    public RootEntity<String> addIngredient(@RequestBody IngredientDto ingredient) {
        ingredientService.addIngredient(ingredient);
        return success();
    }

    @GetMapping(path = "/list")
    @Override
    public RootEntity<List<IngredientDto>> getAllIngredients() {
        return ok(ingredientService.getAllIngredients());

    }

}
