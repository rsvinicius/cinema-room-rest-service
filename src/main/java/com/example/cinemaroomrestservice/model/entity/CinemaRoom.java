package com.example.cinemaroomrestservice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Table;

import java.util.Collection;

public class CinemaRoom {
    private int totalRows;
    private int totalColumns;
    private Collection<Seat> availableSeats;
    @JsonIgnore
    private Table<Integer, Integer, Seat> seatTable;

    public CinemaRoom(int totalRows, int totalColumns, Table<Integer, Integer, Seat> seatTable) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.seatTable = seatTable;
        this.availableSeats = seatTable.values();
    }

    public Seat getSeat(Integer row, Integer column) {
        return seatTable.get(row, column);
    }

    public void setAvailableSeats(Table<Integer, Integer, Seat> seatTable) {
        this.seatTable = seatTable;
        this.availableSeats = seatTable.values();
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public Collection<Seat> getAvailableSeats() {
        return availableSeats;
    }
}