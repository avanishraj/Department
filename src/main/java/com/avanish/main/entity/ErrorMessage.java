package com.avanish.main.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.net.http.HttpRequest;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    public HttpStatus status;
    public String message;
}
