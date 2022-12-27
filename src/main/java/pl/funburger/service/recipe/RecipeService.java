package pl.funburger.service.recipe;

import pl.funburger.model.dto.RecipeDto;
import pl.funburger.model.enums.CategoryEnum;

import java.util.List;

public interface RecipeService {

    RecipeDto createRecipe(RecipeDto recipeDto);

    void deleteRecipe(RecipeDto recipeDto);

    List<RecipeDto> getRecipesListByCategory(CategoryEnum category);

}
