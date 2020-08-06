package com.century.traineetask.service;

import com.century.traineetask.dao.OrderRepository;
import com.century.traineetask.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public void deleteOrder(Long orderId) {
        Order order = this.getOrderById(orderId);
        if (order == null) return;
        orderRepository.delete(order);
    }

    public void updateOrder(Long orderId, Order order) {
        Order oldOrder = this.getOrderById(orderId);
        if (oldOrder == null) return;

        oldOrder.setAddress(order.getAddress());
        oldOrder.setClient(order.getClient());
        oldOrder.setDate(order.getDate());

        orderRepository.save(oldOrder);
    }
}
