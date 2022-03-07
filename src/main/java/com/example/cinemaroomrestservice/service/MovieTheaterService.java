package com.example.cinemaroomrestservice.service;


import com.example.cinemaroomrestservice.constants.CustomExceptionMessageError;
import com.example.cinemaroomrestservice.exception.NotFoundException;
import com.example.cinemaroomrestservice.exception.SeatNotAvailableException;
import com.example.cinemaroomrestservice.exception.WrongPasswordException;
import com.example.cinemaroomrestservice.exception.WrongTokenException;
import com.example.cinemaroomrestservice.model.entity.CinemaRoom;
import com.example.cinemaroomrestservice.model.entity.Seat;
import com.example.cinemaroomrestservice.model.request.PurchaseRequestBody;
import com.example.cinemaroomrestservice.model.request.ReturnRequestBody;
import com.example.cinemaroomrestservice.model.response.PurchaseResponseBody;
import com.example.cinemaroomrestservice.model.response.ReturnResponseBody;
import com.example.cinemaroomrestservice.model.response.StatsResponseBody;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class MovieTheaterService {

    public static final int CHEAP_PRICE = 8;
    public static final int EXPENSIVE_PRICE = 10;
    public static final int ROW_BOUNDARY_PRICE = 4;
    public static final int ROW_COLUMN_START_INDEX = 1;
    public static final int TOTAL_ROWS = 9;
    public static final int TOTAL_COLUMNS = 9;
    public static final String PASSWORD = "super_secret";
    private static CinemaRoom cinemaRoom;
    private final Map<UUID, Seat> boughtSeats = new HashMap<>();

    public CinemaRoom getMovieTheater() {
        return cinemaRoom;
    }

    public PurchaseResponseBody buyTicket(PurchaseRequestBody purchaseRequestBody) {
        Seat seat;
        try {
            seat = cinemaRoom.getSeat(purchaseRequestBody.getRow(), purchaseRequestBody.getColumn());
            if (seat.isSeatAvailable()) {
                UUID token = UUID.randomUUID();
                seat.setSeatAvailable(false);
                seat.setToken(token);
                boughtSeats.put(token, seat);
            } else {
                throw new SeatNotAvailableException(CustomExceptionMessageError.ALREADY_PURCHASED);
            }
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            throw new NotFoundException(CustomExceptionMessageError.OUT_OF_BOUNDS);
        }
        return new PurchaseResponseBody(seat);
    }

    public ReturnResponseBody returnTicket(ReturnRequestBody returnRequestBody) {
        try {
            UUID token = UUID.fromString(returnRequestBody.getToken());
            return new ReturnResponseBody(vacateSeat(token));
        } catch (IllegalArgumentException | NullPointerException | WrongTokenException e) {
            throw new WrongTokenException(CustomExceptionMessageError.WRONG_TOKEN);
        }
    }

    public StatsResponseBody generateStats(String password) {
        if (!PASSWORD.equals(password)) {
            throw new WrongPasswordException(CustomExceptionMessageError.WRONG_PASSWORD);
        }

        int totalSeats = TOTAL_ROWS * TOTAL_COLUMNS;
        int currentIncome = 0;
        int numberOfAvailableSeats;
        int numberOfPurchasedTickets = 0;

        for (Seat seat : boughtSeats.values()) {
            currentIncome += seat.getPrice();
            numberOfPurchasedTickets++;
        }

        numberOfAvailableSeats = totalSeats - numberOfPurchasedTickets;

        return new StatsResponseBody(currentIncome, numberOfAvailableSeats, numberOfPurchasedTickets);
    }

    public static void createCinemaRoom() {
        int price;

        Table<Integer, Integer, Seat> availableSeatsTable = HashBasedTable.create();

        for (int row = ROW_COLUMN_START_INDEX; row <= TOTAL_ROWS; row++) {
            for (int column = ROW_COLUMN_START_INDEX; column <= TOTAL_COLUMNS; column++) {
                price = (row <= ROW_BOUNDARY_PRICE) ? EXPENSIVE_PRICE : CHEAP_PRICE;
                availableSeatsTable.put(row, column, new Seat(row, column, price));
            }
        }
        cinemaRoom = new CinemaRoom(TOTAL_ROWS, TOTAL_COLUMNS, availableSeatsTable);
    }

    private Seat vacateSeat(UUID token) throws NullPointerException, WrongTokenException {
        if (isTokenValid(token)) {
            Seat seat = boughtSeats.remove(token);
            seat.setSeatAvailable(true);
            return seat;
        } else {
            throw new WrongTokenException();
        }
    }

    private boolean isTokenValid(UUID token) throws NullPointerException {
        return boughtSeats.containsKey(token);
    }
}