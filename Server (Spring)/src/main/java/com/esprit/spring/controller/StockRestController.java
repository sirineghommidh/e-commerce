package com.esprit.spring.controller;

import com.esprit.spring.entites.Stock;
import com.esprit.spring.services.IStock;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockRestController {
    @Autowired
    IStock stockService;
    //http://localhost:8081/springMVC/servlet/stock/retrieve_all_stocks
    @GetMapping("/retrieve_all_stocks")
    @ResponseBody
    public List<Stock> getStocks() {
        List<Stock> stocks = stockService.retrieveAllStocks();
        System.out.println(stocks);
        return stocks;
    }
    // http://localhost:8081/springMVC/servlet/stock/add_stock    
    @PostMapping("/add_stock")
    @ResponseBody
    public Stock addStock(@RequestBody Stock c) {
        Stock stock = stockService.addStock(c);
        return stock;
    }
    //http://localhost:8081/springMVC/servlet/stock/retrieve_stock/1
    @GetMapping("/retrieve_stock/{stock_id}")
    @ResponseBody
    public Stock retrieveStock(@PathVariable("stock_id") Long stockId) {
        return stockService.retrieveStock(stockId);
    }




    // http://localhost:8081/springMVC/servlet/stock/remove-stock/1
    @DeleteMapping("/remove-stock/{stock-id}")
    @ResponseBody
    public void removeStock(@PathVariable("stock-id") Long stockId) {
        stockService.deleteStock(stockId);
    }

    // http://localhost:8081/springMVC/servlet/stock/modify_stock
    @PutMapping("/modify_stock")
    @ResponseBody
    public Stock modifyStock(@RequestBody Stock stock) {
        return stockService.updateStock(stock);
    }

    // http://localhost:8081/springMVC/servlet/stock/find-LibelleOfProducts
    @GetMapping("/find-LibelleOfProducts")
    @ResponseBody
    public List<String>  findLibelleOfProduts(){
        return stockService.libelleOfProductsHaveStockInf();
    }
    @GetMapping("/find-stock-withAnyKeyWord/{str}")
    @ResponseBody
    public List<Stock> findStockWithAnyKeyword(@PathVariable("str") String str){

        return stockService.findWithAnyKeyword(str);
    }
}
