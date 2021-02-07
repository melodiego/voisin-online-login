package br.com.voisinonline.login.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final String message;
    private final Collection<String> details;
}