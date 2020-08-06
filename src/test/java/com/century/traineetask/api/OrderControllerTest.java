package com.century.traineetask.api;

import com.century.traineetask.model.Order;
import com.century.traineetask.service.OrderService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class OrderControllerTest {

    private MockMvc mockMvc;
    @InjectMocks
    OrderController orderController;
    @Mock
    OrderService orderService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    public void getAllOrders() throws Exception {
        List<Order> orders = Arrays.asList(new Order("Client 1", "05-08-2020", "Address 1"));
        Mockito.when(orderService.getAllOrders()).thenReturn(orders);
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/order"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getOrderById() throws Exception {
        Order order = new Order("Client", "Date", "Address");
        Mockito.when(orderService.getOrderById(1L)).thenReturn(order);
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/order/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.client", Matchers.is("Client")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.date", Matchers.is("Date")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address", Matchers.is("Address")));
        Mockito.verify(orderService).getOrderById(1L);
    }

    @Test
    public void createOrder() throws Exception {
        String jsonString = "{\n" +
                "\"client\":\"Client 1\",\n" +
                "\"date\":\"Date 1\",\n" +
                "\"address\":\"Address 1\"\n" +
                "}";
        mockMvc
                .perform(MockMvcRequestBuilders.post("/api/v1/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateOrder() throws Exception {
        String jsonString = "{\n" +
                "\"client\":\"Client 1\",\n" +
                "\"date\":\"Date 1\",\n" +
                "\"address\":\"Address 1\"\n" +
                "}";
        Order order = new Order("Client", "Date", "Address");
        Mockito.when(orderService.getOrderById(1L)).thenReturn(order);
        mockMvc
                .perform(MockMvcRequestBuilders.put("/api/v1/order/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deleteOrder() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.delete("/api/v1/order/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
