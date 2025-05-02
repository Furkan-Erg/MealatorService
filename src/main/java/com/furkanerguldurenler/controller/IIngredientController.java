package com.furkanerguldurenler.controller;

import java.util.List;

import com.furkanerguldurenler.dto.IngredientDto;
import com.furkanerguldurenler.entities.RootEntity;

public interface IIngredientController {
    public RootEntity<String> addIngredient(IngredientDto ingredient);

    public RootEntity<List<IngredientDto>> getAllIngredients();
}
