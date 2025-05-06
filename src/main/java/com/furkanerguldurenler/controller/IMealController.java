package com.furkanerguldurenler.controller;

import java.util.List;

import com.furkanerguldurenler.dto.AddMealRequestDto;
import com.furkanerguldurenler.dto.MealDto;
import com.furkanerguldurenler.entities.RootEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface IMealController {

    public RootEntity<String> saveMeal(AddMealRequestDto meal);

    public RootEntity<List<MealDto>> getMealList();

    public RootEntity<MealDto> getMealById(Integer id);

    public RootEntity<String> deleteMealById(Integer id);

    public RootEntity<String> toggleFavoriteMeal(UserDetails userDetails, Integer id);

    public RootEntity<List<MealDto>> getFavoriteList(UserDetails userDetails);
}
