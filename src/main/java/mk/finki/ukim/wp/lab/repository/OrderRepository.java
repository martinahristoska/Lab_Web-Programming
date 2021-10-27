package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    public Order saveOrder(String balloonColor,String balloonSize, String clientName, String address)
    {
        Order order = new Order(balloonColor, balloonSize, clientName, address);
        DataHolder.orders.add(order);
        return order;
    }
    public List<Order> findAllOrders()
    {
        return DataHolder.orders;
    }
}
