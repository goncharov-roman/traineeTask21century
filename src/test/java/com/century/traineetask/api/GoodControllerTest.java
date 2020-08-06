package com.century.traineetask.api;

import com.century.traineetask.model.Good;
import com.century.traineetask.service.GoodService;
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
public class GoodControllerTest {

    private MockMvc mockMvc;
    @InjectMocks
    GoodController goodController;
    @Mock
    GoodService goodService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(goodController).build();
    }

    @Test
    public void getAllGoods() throws Exception {
        List<Good> goods = Arrays.asList(new Good("Good 1", 100.500));
        Mockito.when(goodService.getAllGoods()).thenReturn(goods);
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/good"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getGoodById() throws Exception {
        Good good = new Good("Good 1", 100.500);
        Mockito.when(goodService.getGoodById(1L)).thenReturn(good);
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/good/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Good 1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", Matchers.is(100.500)));
        Mockito.verify(goodService).getGoodById(1L);
    }

    @Test
    public void createGood() throws Exception {
        String jsonString = "{\n" +
                "\"name\":\"Good 1\",\n" +
                "\"price\":\"100.500\"\n" +
                "}";
        mockMvc
                .perform(MockMvcRequestBuilders.post("/api/v1/good")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateGood() throws Exception {
        String jsonString = "{\n" +
                "\"name\":\"Good 1\",\n" +
                "\"price\":\"100.500\"\n" +
                "}";
        Good good = new Good("Good 1", 100.500);
        Mockito.when(goodService.getGoodById(1L)).thenReturn(good);
        mockMvc
                .perform(MockMvcRequestBuilders.put("/api/v1/good/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deleteGood() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.delete("/api/v1/good/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
