package com.example.cinemaroomrestservice.model.response;

import lombok.Data;

@Data
public class StatsResponseBody {
    private final Integer currentIncome;
    private final Integer numberOfAvailableSeats;
    private final Integer numberOfPurchasedTickets;
}