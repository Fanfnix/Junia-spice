package com.jad.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeLine {
    private Integer idProduct;
    private Integer idComponent;
    private Float percentage;
    
    public RecipeLine(final Integer idProduct, final Integer idComponent, final Float percentage) {
        this.idProduct = idProduct;
        this.idComponent = idComponent;
        this.percentage = percentage;
    }
}