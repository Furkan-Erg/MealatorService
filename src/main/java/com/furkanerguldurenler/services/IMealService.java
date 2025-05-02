package com.furkanerguldurenler.services;

import java.util.List;

import com.furkanerguldurenler.dto.MealDto;

public interface IMealService {
	public MealDto saveMeal(MealDto meal);
	public List<MealDto> getMealList();
	public MealDto getMealById(Integer id);
	public void deleteMealById(Integer id);

}