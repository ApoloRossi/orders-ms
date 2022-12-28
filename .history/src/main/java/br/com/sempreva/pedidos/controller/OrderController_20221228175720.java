package br.com.sempreva.pedidos.controller;


import br.com.sempreva.pedidos.dto.OrderDto;
import br.com.sempreva.pedidos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public Page<OrderDto> listar(@PageableDefault(size = 10) Pageable pagination) {
        return service.getOrders(pagination);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> detalhar(@PathVariable @javax.validation.constraints.NotNull Long id) {
        OrderDto dto = service.getOrderById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<OrderDto> cadastrar(@RequestBody @Valid OrderDto dto, UriComponentsBuilder uriBuilder) {
        OrderDto pagamento = service.createOrder(dto);
        URI endereco = uriBuilder.path("/user/{id}").buildAndExpand(pagamento.getId()).toUri();

        return ResponseEntity.created(endereco).body(pagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid OrderDto dto) {
        OrderDto atualizado = service.updateOrder(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDto> remover(@PathVariable @NotNull Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
