package com.example.restapis.classes;

import com.google.gson.annotations.SerializedName;

/**
 * pet status
 */
public enum PetStatus {

    @SerializedName("available")
    available("available"),
    @SerializedName("pending")
    pending("pending"),
    @SerializedName("sold")
    sold("sold");

    private String value;

    PetStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}