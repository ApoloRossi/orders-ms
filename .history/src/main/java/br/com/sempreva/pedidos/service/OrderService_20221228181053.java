package br.com.sempreva.pedidos.service;

import br.com.sempreva.pedidos.dto.OrderDto;
import br.com.sempreva.pedidos.model.Order;
import br.com.sempreva.pedidos.repository.OrderRepository;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<OrderDto> getOrders(Pageable pagination) {
        return repository
                .findAll(pagination)
                .map(p -> modelMapper.map(p, OrderDto.class));
    }

    public OrderDto getOrderById(Long id) {
        Order user = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(user, OrderDto.class);

    }

    public OrderDto createOrder(OrderDto newUser) {

        Order order = modelMapper.map(newUser, Order.class);

        repository.save(order);

        return modelMapper.map(order, OrderDto.class);

    }

    public OrderDto updateOrder(Long id, OrderDto newUser) {

        Order user = modelMapper.map(newUser, Order.class);
        user.setId(id);

        user = repository.save(user);

        return modelMapper.map(user, OrderDto.class);

    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }


}
