package com.furkanerguldurenler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furkanerguldurenler.entities.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {

}
