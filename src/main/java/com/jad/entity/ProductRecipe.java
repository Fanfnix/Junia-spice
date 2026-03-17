package com.jad.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;


@ToString
public class ProductRecipe extends AbstractEntity {
    private final List<RecipeLine> recipeLines;
    @Getter
    @Setter
    private Integer idProduct;
    @Getter
    @Setter
    private Integer idOperationType;

    public ProductRecipe(final Integer idProduct, final Integer idOperationType, final List<RecipeLine> recipeLines) {
        this.idProduct = idProduct;
        this.idOperationType = idOperationType;
        this.recipeLines = recipeLines;
    }

    public List<RecipeLine> getRecipeLines() {
        return Collections.unmodifiableList(this.recipeLines);
    }
}