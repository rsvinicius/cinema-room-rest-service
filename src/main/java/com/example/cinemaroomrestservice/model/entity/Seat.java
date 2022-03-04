package com.example.cinemaroomrestservice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Seat {
    @JsonIgnore
    private boolean isSeatAvailable = true;

    @JsonIgnore
    private UUID token;

    @JsonIgnore
    public static Map<UUID, Seat> boughtSeats = new HashMap<>();

    private int row;
    private int column;
    private int price;

    public Seat(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @JsonIgnore
    public boolean isSeatAvailable() {
        return isSeatAvailable;
    }

    public void setSeatAvailable(boolean seatAvailable) {
        isSeatAvailable = seatAvailable;
    }

    @JsonIgnore
    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}