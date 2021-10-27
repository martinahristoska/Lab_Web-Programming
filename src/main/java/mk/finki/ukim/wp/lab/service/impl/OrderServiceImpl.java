package mk.finki.ukim.wp.lab.service.impl;

import mk.finki.ukim.wp.lab.model.Order;
import mk.finki.ukim.wp.lab.repository.BalloonRepository;
import mk.finki.ukim.wp.lab.repository.OrderRepository;
import mk.finki.ukim.wp.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(String balloonColor, String balloonSize ,String clientName, String address) {
        return orderRepository.saveOrder(balloonColor, balloonSize, clientName, address);
    }

    @Override
    public List<Order> listOrders() {
        return orderRepository.findAllOrders();
    }
}
