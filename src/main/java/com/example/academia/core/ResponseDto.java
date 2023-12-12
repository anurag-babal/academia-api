package com.example.academia.core;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto {
    private int status;
    private int count;
    private Object data;
    private String message;
}
