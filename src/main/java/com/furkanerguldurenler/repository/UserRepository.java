package com.furkanerguldurenler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furkanerguldurenler.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
