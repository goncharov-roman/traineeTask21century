package com.century.traineetask.service;

import com.century.traineetask.dao.GoodRepository;
import com.century.traineetask.model.Good;
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
public class GoodServiceTest {

    @Mock
    private GoodRepository goodRepository;

    private GoodService goodServiceUnderTest;

    @Before
    public void setUp() {
        this.goodServiceUnderTest = new GoodService(goodRepository);
    }

    @Test
    public void getAllGoods() throws Exception {
        List<Good> goods = Arrays.asList(new Good("Good", 1000.0));
        Mockito.when(goodRepository.findAll()).thenReturn(goods);
        assertEquals(goods, goodServiceUnderTest.getAllGoods());
    }

    @Test
    public void getGoodById() throws Exception {
        Good good = new Good("Good", 1000.0);
        Mockito.when(goodRepository.findById(1L)).thenReturn(Optional.of(good));
        assertEquals(good, goodServiceUnderTest.getGoodById(1L));
    }

    @Test
    public void createGood() throws Exception {
        Good good = new Good("Good", 1000.0);
        try {
            goodServiceUnderTest.createGood(good);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void updateGood() throws Exception {
        Good good = new Good("Good", 1000.0);
        try {
            goodServiceUnderTest.updateGood(1L, good);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void deleteGood() throws Exception {
        try {
            goodServiceUnderTest.deleteGood(1L);
        } catch (Exception e) {
            fail();
        }
    }
}
