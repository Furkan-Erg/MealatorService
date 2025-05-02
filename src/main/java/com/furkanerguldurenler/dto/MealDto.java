package com.furkanerguldurenler.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealDto {

	private Integer id;
	private String name;
	private String description;
}
