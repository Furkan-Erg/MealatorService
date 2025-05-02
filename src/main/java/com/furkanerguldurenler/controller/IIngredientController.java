package com.furkanerguldurenler.controller;

import java.util.List;

import com.furkanerguldurenler.dto.IngredientDto;

public interface IIngredientController {
	public void addIngredient(IngredientDto ingredient);
	public List<IngredientDto> getAllIngredients();
}
