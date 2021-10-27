package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Order;

import java.util.List;

public interface OrderService
{
    Order placeOrder(String balloonColor,String balloonSize, String clientName, String address);
    List<Order> listOrders();
}
