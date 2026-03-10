package com.jad.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRecipe {
    public ProductRecipe(final Integer idProduct, final Integer idOperationType) {
        this.idProduct = idProduct;
        this.idOperationType = idOperationType;
    }

    private Integer idProduct;
    private Integer idOperationType;
}