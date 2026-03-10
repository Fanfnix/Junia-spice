package com.jad.dto;

public record OperationTypeDTO(int id,
                               String label,
                               int minNbComponents,
                               int maxNbComponents,
                               int duration,
                               int lossOfQuantity,
                               ProductTypeDTO productTypeDTO) {
}
