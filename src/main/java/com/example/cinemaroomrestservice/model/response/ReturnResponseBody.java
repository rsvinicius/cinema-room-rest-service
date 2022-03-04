package com.example.cinemaroomrestservice.model.response;

import com.example.cinemaroomrestservice.model.entity.Seat;
import lombok.Data;

@Data
public class ReturnResponseBody {
    private final Seat returnedTicket;
}
