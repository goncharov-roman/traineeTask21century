package com.century.traineetask.service;

import com.century.traineetask.dao.GoodRepository;
import com.century.traineetask.model.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {

    private GoodRepository goodRepository;

    @Autowired
    public GoodService(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }

    public List<Good> getAllGoods() {
        return (List<Good>) goodRepository.findAll();
    }

    public void createGood(Good good) {
        goodRepository.save(good);
    }

    public Good getGoodById(Long goodId) {
        return goodRepository.findById(goodId).orElse(null);
    }

    public void deleteGood(Long goodId) {
        Good good = this.getGoodById(goodId);
        if (good == null) return;
        goodRepository.delete(good);
    }

    public void updateGood(Long goodId, Good good) {
        Good oldGood = this.getGoodById(goodId);
        if (oldGood == null) return;

        oldGood.setName(good.getName());
        oldGood.setPrice(good.getPrice());

        goodRepository.save(oldGood);
    }
}
