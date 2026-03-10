package com.jad.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Integer id;
    private String label;
    private String createdBy;
    private Integer idTypeProduct;
    private Integer isAtomic;
    public Product(final Integer id, final String label, final String createdBy, final Integer idTypeProduct,
                   final Integer isAtomic) {
        this.id = id;
        this.label = label;
        this.createdBy = createdBy;
        this.idTypeProduct = idTypeProduct;
        this.isAtomic = isAtomic;
    }
}