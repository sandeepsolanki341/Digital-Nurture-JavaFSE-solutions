package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

// Doc 2, Hands-on 2: Query Methods on the stock table.
@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // All FB rows within a date range (used for September 2019).
    List<Stock> findByCodeAndDateBetween(String code, Date start, Date end);

    // Google rows where open price > threshold.
    List<Stock> findByCodeAndOpenGreaterThan(String code, double price);

    // Top 3 dates by highest volume.
    List<Stock> findTop3ByOrderByVolumeDesc();

    // Three dates when a stock (NFLX) was lowest by open price.
    List<Stock> findTop3ByCodeOrderByOpenAsc(String code);
}
