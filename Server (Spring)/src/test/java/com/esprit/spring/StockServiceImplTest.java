package com.esprit.spring;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.spring.entites.Stock;
import com.esprit.spring.services.IStock;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
@Autowired
IStock stockService;
@Test
public void testAddStock() {
List<Stock> stocks = stockService.retrieveAllStocks();
int expected=stocks.size();
Stock s = new Stock();
s.setLibelleStock("stock test");
s.setQteStock(10);
s.setQteMin(100);
Stock savedStock= stockService.addStock(s);
assertEquals(expected+1, stockService.retrieveAllStocks().size());
assertNotNull(savedStock.getLibelleStock());
//stockService.deleteStock(savedStock.getIdStock());
} 
}