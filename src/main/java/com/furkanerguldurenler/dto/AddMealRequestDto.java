package com.furkanerguldurenler.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddMealRequestDto {
    private String name;
    private String description;
    private List<Integer> ingredientIds;

}
