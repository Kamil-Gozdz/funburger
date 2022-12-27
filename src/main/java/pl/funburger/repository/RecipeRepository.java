package pl.funburger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.funburger.model.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {



}
