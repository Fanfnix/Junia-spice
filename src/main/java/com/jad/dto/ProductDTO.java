package com.jad.dto;

public record ProductDTO(int id,
                         String label,
                         String createdBy,
                         ProductTypeDTO productTypeDTO,
                         boolean isAtomic) {
}
