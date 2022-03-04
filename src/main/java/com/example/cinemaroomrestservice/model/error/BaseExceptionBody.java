package com.example.cinemaroomrestservice.model.error;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseExceptionBody {
    private final LocalDateTime timestamp = LocalDateTime.now();
    final Integer status;
    final String error;
    final String path;
}
