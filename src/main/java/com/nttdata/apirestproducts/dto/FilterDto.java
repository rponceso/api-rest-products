package com.nttdata.apirestproducts.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilterDto {

    private String producto;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
