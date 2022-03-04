package com.example.cinemaroomrestservice.model.request;

import lombok.Data;

import java.util.UUID;

@Data
public class ReturnRequestBody {
    private String token;

    public void setToken(String token) {
        this.token = token;
    }
}
