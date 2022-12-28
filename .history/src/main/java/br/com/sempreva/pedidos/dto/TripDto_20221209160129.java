package br.com.sempreva.pedidos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TripDto {

    private Long id;

    private String tripDescription;

    private Double tripValue;
}
