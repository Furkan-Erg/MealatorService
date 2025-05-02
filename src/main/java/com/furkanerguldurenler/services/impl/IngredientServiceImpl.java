package com.furkanerguldurenler.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkanerguldurenler.dto.IngredientDto;
import com.furkanerguldurenler.entities.Ingredient;
import com.furkanerguldurenler.repository.IngredientRepository;
import com.furkanerguldurenler.services.IIngredientService;

@Service
public class IngredientServiceImpl implements IIngredientService {
	@Autowired
	private IngredientRepository ingredientRepository;

	@Override
	public List<IngredientDto> getAllIngredients() {
		List<Ingredient> allIngredients = ingredientRepository.findAll();
		List<IngredientDto> allIngredientsDto = new ArrayList<>();
		for (Ingredient ingredient : allIngredients) {
			IngredientDto tempIngredientDto = new IngredientDto();
			BeanUtils.copyProperties(ingredient, tempIngredientDto);
			allIngredientsDto.add(tempIngredientDto);
		}
		return allIngredientsDto;
	}

	@Override
	public void addIngredient(IngredientDto ingredient) {
		Ingredient tempIngredient = new Ingredient();
		tempIngredient.setName(ingredient.getName());
		ingredientRepository.save(tempIngredient);
	}

}
