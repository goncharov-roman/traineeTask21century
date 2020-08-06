package com.century.traineetask.service;

import com.century.traineetask.dao.OrderRepository;
import com.century.traineetask.model.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    OrderService orderServiceUnderTest;

    @Before
    public void setUp() {
        orderServiceUnderTest = new OrderService(orderRepository);
    }

    @Test
    public void getAllOrders() throws Exception {
        List<Order> orders = Arrays.asList(new Order("Client 1", "05-08-2020", "Address 1"));
        Mockito.when(orderRepository.findAll()).thenReturn(orders);
        assertEquals(orders, orderServiceUnderTest.getAllOrders());
    }

    @Test
    public void getOrderById() throws Exception {
        Order order = new Order("Client", "Date", "Address");
        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        assertEquals(order, orderServiceUnderTest.getOrderById(1L));
    }

    @Test
    public void createOrder() throws Exception {
        Order order = new Order("Client", "Date", "Address");
        try {
            orderServiceUnderTest.createOrder(order);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void updateOrder() throws Exception {
        Order order = new Order("Client", "Date", "Address");
        try {
            orderServiceUnderTest.updateOrder(1L, order);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void deleteOrder() throws Exception {
        try {
            orderServiceUnderTest.deleteOrder(1L);
        } catch (Exception e) {
            fail();
        }
    }
}
