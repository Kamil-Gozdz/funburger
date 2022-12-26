package pl.funburger.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.funburger.model.enums.CategoryEnum;

import java.util.Map;

@Entity
@Table(name = "recipes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "ingred_amount",
            joinColumns = {@JoinColumn(name = "recipe_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "ingredient")
    @Column(name = "amount")
    private Map<String, Integer> ingredients;

    private String description;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    private Double avgScore;
}
