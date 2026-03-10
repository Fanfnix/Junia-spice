package com.jad.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductType {
    private Integer id;
    private String label;
    
    public ProductType(final Integer id, final String label) {
        this.id = id;
        this.label = label;
    }
}