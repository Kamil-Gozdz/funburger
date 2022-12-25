package pl.funburger.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.funburger.model.enums.CategoryEnum;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeDto {

    private Long id;

    private String name;

    private Map<String, Integer> ingredients = new LinkedHashMap<>();

    private String description;

    private CategoryEnum category;

    private Double avgScore;
}
