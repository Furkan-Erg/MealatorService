package com.furkanerguldurenler.controller.impl;

import java.util.List;

import com.furkanerguldurenler.entities.RootEntity;
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
public class MealControllerImpl extends RestBaseController implements IMealController {

    @Autowired
    private IMealService mealService;

    @PostMapping(path = "/add")
    @Override
    public RootEntity<MealDto> saveMeal(@RequestBody MealDto meal) {
        return ok(mealService.saveMeal(meal));
    }

    @GetMapping(path = "/list")
    @Override
    public RootEntity<List<MealDto>> getMealList() {
        return ok(mealService.getMealList());
    }

    @GetMapping(path = "/{id}")
    @Override
    public RootEntity<MealDto> getMealById(@PathVariable Integer id) {
        return ok(mealService.getMealById(id));
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public RootEntity<String> deleteMealById(@PathVariable Integer id) {
        mealService.deleteMealById(id);
        return success();
    }

}
