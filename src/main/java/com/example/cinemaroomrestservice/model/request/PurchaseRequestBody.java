package com.example.cinemaroomrestservice.model.request;

import lombok.Data;

@Data
public class PurchaseRequestBody {
    private Integer row;
    private Integer column;
}
