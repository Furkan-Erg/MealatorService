package com.furkanerguldurenler.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.furkanerguldurenler.dto.AddMealRequestDto;
import com.furkanerguldurenler.dto.IngredientDto;
import com.furkanerguldurenler.entities.FavoriteList;
import com.furkanerguldurenler.entities.Ingredient;
import com.furkanerguldurenler.entities.User;
import com.furkanerguldurenler.repository.FavoriteRepository;
import com.furkanerguldurenler.repository.IngredientRepository;
import com.furkanerguldurenler.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.furkanerguldurenler.dto.MealDto;
import com.furkanerguldurenler.entities.Meal;
import com.furkanerguldurenler.repository.MealRepository;
import com.furkanerguldurenler.services.IMealService;

@Service
public class MealServiceImpl implements IMealService {
    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveMeal(AddMealRequestDto request) {
        Meal meal = new Meal();
        BeanUtils.copyProperties(request, meal);
        List<Ingredient> ingredients = ingredientRepository.findAllById(request.getIngredientIds());
        meal.setIngredient(ingredients);
        mealRepository.save(meal);
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
            List<Ingredient> ingredientList = optional.get().getIngredient();
            List<IngredientDto> ingredientDtoList = new ArrayList<>();
            for (Ingredient ingredient : ingredientList) {
                IngredientDto ingredientDto = new IngredientDto();
                BeanUtils.copyProperties(ingredient, ingredientDto);
                ingredientDtoList.add(ingredientDto);
            }
            mealDto.setIngredientList(ingredientDtoList);
            return mealDto;
        }
        return null;
    }

    @Override
    public void deleteMealById(Integer id) {
        mealRepository.deleteById(id);
    }

    @Override
    public void toggleFavoriteMeal(UserDetails userDetails, Integer id) {
        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        FavoriteList favoriteList = user.getFavoriteList();
        List<Meal> mealList = favoriteList.getMeal();

        Meal meal = mealRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meal not found"));

        if (mealList.contains(meal)) {
            mealList.remove(meal);
        } else {
            mealList.add(meal);
        }

        favoriteRepository.save(favoriteList);
    }

    @Override
    public List<MealDto> getFavoriteList(UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow();

        return user.getFavoriteList().getMeal().stream()
                .map(meal -> {
                    MealDto dto = new MealDto();
                    BeanUtils.copyProperties(meal, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }


}
