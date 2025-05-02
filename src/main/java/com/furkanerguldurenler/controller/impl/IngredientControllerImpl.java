package com.furkanerguldurenler.controller.impl;

import java.util.List;

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
public class IngredientControllerImpl implements IIngredientController {

	@Autowired
	private IIngredientService ingredientService;

	@PostMapping(path = "/add")
	@Override
	public void addIngredient(@RequestBody IngredientDto ingredient) {
		ingredientService.addIngredient(ingredient);

	}

	@GetMapping(path = "/list")
	@Override
	public List<IngredientDto> getAllIngredients() {
		return ingredientService.getAllIngredients();

	}

}
