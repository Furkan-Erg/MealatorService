package com.furkanerguldurenler.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddIngredientsRequestDto {
	    private Integer userId;
	    private List<Integer> ingredientIds;
	
}
