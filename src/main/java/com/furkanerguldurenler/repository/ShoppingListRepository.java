package com.furkanerguldurenler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furkanerguldurenler.entities.ShoppingList;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Integer>{

}
