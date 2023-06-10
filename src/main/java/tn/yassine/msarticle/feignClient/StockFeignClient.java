package tn.yassine.msarticle.feignClient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tn.yassine.commons.dto.ArticleDto;
import tn.yassine.commons.dto.StockDto;
import tn.yassine.msarticle.entities.Article;

@Service
@RequiredArgsConstructor

public class StockFeignClient {
    private RestTemplate restTemplate;


    public StockDto getStock(long id){
        restTemplate = new RestTemplate();
        StockDto stockDto = restTemplate.getForObject("http://localhost:8090/msStock/stock/getstck/"+id, StockDto.class);
        return stockDto;
    }

    public ArticleDto setArticleDto(Article article){
        ArticleDto articleDto = new ArticleDto();
        articleDto.setNom(article.getNom());
        articleDto.setQte(article.getQte());

        articleDto.setStockDto(getStock(article.getStockId()));
        return articleDto;
    }
}
