package com.furkanerguldurenler.repository;

import com.furkanerguldurenler.entities.FavoriteList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<FavoriteList, Long> {
}
