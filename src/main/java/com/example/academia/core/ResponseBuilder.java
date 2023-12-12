package com.example.academia.core;

import org.springframework.http.HttpStatus;

public class ResponseBuilder {
    public static ResponseDto createResponse(Object obj) {
        if (obj == null) 
            return createNullResponse();
        else
            return createSingleResponse(obj);
    }

    public static ResponseDto createDeleteResponse(boolean successfull) {
        return createDeleteSuccessfullResponse();
    }

    public static ResponseDto createNullResponse() {
        return ResponseDto.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .count(0)
                .message("Item not found")
                .build();
    }

    public static ResponseDto createSingleResponse(Object obj) {
        return ResponseDto.builder()
                .status(HttpStatus.OK.value())
                .count(1)
                .data(obj)
                .message("Successfull")
                .build();
    }

    public static ResponseDto createDeleteSuccessfullResponse() {
        return ResponseDto.builder()
                .status(HttpStatus.OK.value())
                .count(0)
                .message("Deleted successfully")
                .build();
    }

    public static ResponseDto createListResponse(int count, Object obj) {
        return ResponseDto.builder()
                .status(HttpStatus.OK.value())
                .count(count)
                .data(obj)
                .message("Successfull")
                .build();
    }

    public static ResponseDto createExceptionResponse(HttpStatus status, String message) {
        return ResponseDto.builder()
                .status(status.value())
                .count(0)
                .data(null)
                .message(message)
                .build();
    }
}
