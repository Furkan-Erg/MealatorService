package com.furkanerguldurenler.services;

import java.util.List;

import com.furkanerguldurenler.dto.IngredientDto;

public interface IIngredientService {

	public List<IngredientDto> getAllIngredients();

	public void addIngredient(IngredientDto ingredient);
}
