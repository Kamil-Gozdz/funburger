package pl.funburger.service.recipe;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.funburger.model.dto.RecipeDto;
import pl.funburger.model.mapper.RecipeMapper;
import pl.funburger.repository.RecipeRepository;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    private final RecipeMapper recipeMapper;


    @Override
    @Transactional
    public RecipeDto createRecipe(RecipeDto recipeDto) {
        return recipeMapper.toDto(recipeRepository.save(recipeMapper.toNewEntity(recipeDto)));
    }

    @Override
    @Transactional
    public void deleteRecipe(RecipeDto recipeDto) {
        recipeRepository.delete(recipeMapper.toNewEntity(recipeDto));
    }
}
