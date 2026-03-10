package com.jad.dto;

public record MachineToolDTO(int id,
                             String label,
                             String installationDuration,
                             String cleaningDuration,
                             int minQuantity,
                             int maxQuantity) {
}
