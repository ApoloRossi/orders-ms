package br.com.sempreva.pedidos.dto;

import br.com.sempreva.pedidos.model.Trip;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {

    private Long id;

    private Double orderValue;

    private Long userId;

    private List<Trip> trips;

}
