package com.example.cinemaroomrestservice;

import com.example.cinemaroomrestservice.service.MovieTheaterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaRoomRestServiceApplication {
    public static void main(String[] args) {
        MovieTheaterService.createCinemaRoom();
        SpringApplication.run(CinemaRoomRestServiceApplication.class, args);
    }
}
