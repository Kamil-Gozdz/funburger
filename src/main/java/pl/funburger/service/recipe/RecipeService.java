package pl.funburger.service.recipe;

import pl.funburger.model.dto.RecipeDto;

public interface RecipeService {

    RecipeDto createRecipe(RecipeDto recipeDto);

    void deleteRecipe(RecipeDto recipeDto);
}
