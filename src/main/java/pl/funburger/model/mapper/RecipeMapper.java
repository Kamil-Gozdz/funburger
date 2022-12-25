package pl.funburger.model.mapper;

import org.springframework.stereotype.Component;
import pl.funburger.model.dto.RecipeDto;
import pl.funburger.model.entity.Recipe;

@Component
public class RecipeMapper {

    public RecipeDto toDto(Recipe recipe) {
        return RecipeDto.builder()
                .id(recipe.getId())
                .name(recipe.getName())
                .ingredients(recipe.getIngredients())
                .description(recipe.getDescription())
                .category(recipe.getCategory())
                .avgScore(recipe.getAvgScore())
                .build();

    }

    public Recipe toNewEntity(RecipeDto recipeDto){
        return Recipe.builder()
                .name(recipeDto.getName())
                .ingredients(recipeDto.getIngredients())
                .description(recipeDto.getDescription())
                .category(recipeDto.getCategory())
                .avgScore(recipeDto.getAvgScore())
                .build();
    }
}
