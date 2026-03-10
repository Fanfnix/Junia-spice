package com.jad.dto;

public record RecipeLineDTO(ProductRecipeDTO product,
                            ProductDTO component,
                            Double percentage) {
}
