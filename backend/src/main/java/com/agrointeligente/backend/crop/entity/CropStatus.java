package com.agrointeligente.backend.crop.entity;

public enum CropStatus {
    PLANTADO("Plantado"),
    DESARROLLO("En desarrollo"),
    COSECHA("En cosecha"),
    FINALIZADO("Finalizado");
    
    private final String displayName;
    
    CropStatus(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
