package tn.yassine.msarticle.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.yassine.commons.dto.StockDto;

@FeignClient(value = "msstock")
public interface IStockDto {
    @GetMapping("stock/getstck/{id}")
    public StockDto retriveStockById(@PathVariable("id") long id);
}
