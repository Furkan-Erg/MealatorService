package com.furkanerguldurenler.controller;

import java.util.List;

import com.furkanerguldurenler.dto.MealDto;
import com.furkanerguldurenler.entities.RootEntity;

public interface IMealController {

    public RootEntity<MealDto> saveMeal(MealDto meal);

    public RootEntity<List<MealDto>> getMealList();

    public RootEntity<MealDto> getMealById(Integer id);

    public RootEntity<String> deleteMealById(Integer id);
}
