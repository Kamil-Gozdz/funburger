package pl.funburger.service.recipe;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.funburger.model.dto.RecipeDto;
import pl.funburger.model.enums.CategoryEnum;
import pl.funburger.model.mapper.RecipeMapper;
import pl.funburger.repository.RecipeRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<RecipeDto> getRecipesListByCategory(CategoryEnum category) {
        return recipeRepository.findAll().stream()
                .filter(r -> r.getCategory().equals(category))
                .map(recipeMapper::toDto)
                .collect(Collectors.toList());
    }
}
