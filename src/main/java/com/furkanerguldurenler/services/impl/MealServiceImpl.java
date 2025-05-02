package com.furkanerguldurenler.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkanerguldurenler.dto.MealDto;
import com.furkanerguldurenler.entities.Meal;
import com.furkanerguldurenler.repository.MealRepository;
import com.furkanerguldurenler.services.IMealService;

@Service
public class MealServiceImpl implements IMealService {
	@Autowired
	private MealRepository mealRepository;

	@Override
	public MealDto saveMeal(MealDto request) {
		Meal meal = new Meal();
		MealDto response = new MealDto();

		BeanUtils.copyProperties(request, meal);
		Meal dbMeal = mealRepository.save(meal);
		BeanUtils.copyProperties(dbMeal, response);
		return response;
	}

	@Override
	public List<MealDto> getMealList() {
		List<MealDto> mealListDto = new ArrayList<>();
		List<Meal> mealList = mealRepository.findAll();
		for (Meal meal : mealList) {
			MealDto mealDto = new MealDto();
			BeanUtils.copyProperties(meal, mealDto);
			mealListDto.add(mealDto);
		}
		return mealListDto;
	}

	@Override
	public MealDto getMealById(Integer id) {
		Optional<Meal> optional = mealRepository.findById(id);
		if (optional.isPresent()) {
			MealDto mealDto = new MealDto();
			BeanUtils.copyProperties(optional.get(), mealDto);
			return mealDto;
		}
		return null;
	}

	@Override
	public void deleteMealById(Integer id) {
		mealRepository.deleteById(id);
	}
}
