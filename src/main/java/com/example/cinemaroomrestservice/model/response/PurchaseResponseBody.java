package com.example.cinemaroomrestservice.model.response;

import com.example.cinemaroomrestservice.model.entity.Seat;
import lombok.Data;

import java.util.UUID;

@Data
public class PurchaseResponseBody {
    private final UUID token;
    private final Seat ticket;

    public PurchaseResponseBody(Seat ticket) {
        this.ticket = ticket;
        this.token = ticket.getToken();
    }
}