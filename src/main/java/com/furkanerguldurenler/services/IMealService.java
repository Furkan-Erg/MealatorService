package com.furkanerguldurenler.services;

import java.util.List;

import com.furkanerguldurenler.dto.AddMealRequestDto;
import com.furkanerguldurenler.dto.MealDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface IMealService {
    public void saveMeal(AddMealRequestDto meal);

    public List<MealDto> getMealList();

    public MealDto getMealById(Integer id);

    public void deleteMealById(Integer id);

    public void toggleFavoriteMeal(UserDetails userDetails, Integer id);

    public List<MealDto> getFavoriteList(UserDetails userDetails);

}