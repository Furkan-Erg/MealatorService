package com.furkanerguldurenler.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furkanerguldurenler.controller.IMealController;
import com.furkanerguldurenler.dto.MealDto;
import com.furkanerguldurenler.services.IMealService;

@RestController
@RequestMapping("/rest/api/meal")
public class MealControllerImpl implements IMealController {

	@Autowired
	private IMealService mealService;

	@PostMapping(path = "/add")
	@Override
	public MealDto saveMeal(@RequestBody MealDto meal) {
		return mealService.saveMeal(meal);
	}

	@GetMapping(path = "/list")
	@Override
	public List<MealDto> getMealList() {
		return mealService.getMealList();
	}

	@GetMapping(path = "/{id}")
	@Override
	public MealDto getMealById(@PathVariable Integer id) {
		return mealService.getMealById(id);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteMealById(@PathVariable Integer id) {
		mealService.deleteMealById(id);
	}

}
