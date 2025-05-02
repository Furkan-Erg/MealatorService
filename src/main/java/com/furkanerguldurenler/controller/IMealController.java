package com.furkanerguldurenler.controller;

import java.util.List;

import com.furkanerguldurenler.dto.MealDto;

public interface IMealController {

	public MealDto saveMeal(MealDto meal);

	public List<MealDto> getMealList();

	public MealDto getMealById(Integer id);

	public void deleteMealById(Integer id);
}
