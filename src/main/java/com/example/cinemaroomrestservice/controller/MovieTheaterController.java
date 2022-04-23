package com.example.cinemaroomrestservice.controller;

import com.example.cinemaroomrestservice.model.entity.CinemaRoom;
import com.example.cinemaroomrestservice.model.request.PurchaseRequestBody;
import com.example.cinemaroomrestservice.model.request.ReturnRequestBody;
import com.example.cinemaroomrestservice.model.response.PurchaseResponseBody;
import com.example.cinemaroomrestservice.model.response.ReturnResponseBody;
import com.example.cinemaroomrestservice.model.response.StatsResponseBody;
import com.example.cinemaroomrestservice.service.MovieTheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cinema-room")
public class MovieTheaterController {
    private final MovieTheaterService movieTheaterService;

    @Autowired
    public MovieTheaterController(MovieTheaterService movieTheaterService) {
        this.movieTheaterService = movieTheaterService;
    }

    @GetMapping("/seats")
    public CinemaRoom getSeats() {
        return movieTheaterService.getMovieTheater();
    }

    @PostMapping("/purchase")
    public PurchaseResponseBody postPurchase(@RequestBody PurchaseRequestBody purchaseRequestBody) {
        return movieTheaterService.buyTicket(purchaseRequestBody);
    }

    @PostMapping("/return")
    public ReturnResponseBody postReturn(@RequestBody ReturnRequestBody returnRequestBody) {
        return movieTheaterService.returnTicket(returnRequestBody);
    }

    @PostMapping("/stats")
    public StatsResponseBody postStats() {
        return movieTheaterService.generateStats();
    }
}