package com.century.traineetask.api;

import com.century.traineetask.model.Good;
import com.century.traineetask.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/good")
public class GoodController {

    private GoodService goodService;

    @Autowired
    public GoodController(GoodService orderService) {
        this.goodService = orderService;
    }

    @GetMapping
    public List<Good> getAllOrders() {
        return goodService.getAllGoods();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Good> getGoodById(@PathVariable("id") Long goodId) {
        Good good = goodService.getGoodById(goodId);

        return ResponseEntity.ok().body(good);
    }

    @PostMapping
    public void createGood(@RequestBody Good good) {
        goodService.createGood(good);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteGood(@PathVariable("id") Long goodId) {
        goodService.deleteGood(goodId);
    }

    @PutMapping(path = "/{id}")
    public void updateGood(@PathVariable("id") Long goodId, @RequestBody Good good) {
        goodService.updateGood(goodId, good);
    }
}

