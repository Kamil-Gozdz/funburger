package pl.funburger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.funburger.model.dto.RecipeDto;
import pl.funburger.model.enums.CategoryEnum;
import pl.funburger.service.recipe.RecipeService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping("/add")
    public RecipeDto addRecipe(@RequestBody RecipeDto recipeDto) {
        return recipeService.createRecipe(recipeDto);
    }

    @DeleteMapping("/delete")
    public void deleteRecipe(@RequestBody RecipeDto recipeDto) {
        recipeService.deleteRecipe(recipeDto);
    }
    @GetMapping("/category/{category}")
    public List<RecipeDto> getRecipesByCategory(@PathVariable("category") CategoryEnum category){
        return recipeService.getRecipesListByCategory(category);
    }
}
