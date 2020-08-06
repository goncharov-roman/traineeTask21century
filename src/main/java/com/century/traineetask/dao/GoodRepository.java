package com.century.traineetask.dao;

import com.century.traineetask.model.Good;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodRepository extends CrudRepository<Good, Long> {
}
