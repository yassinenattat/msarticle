package tn.yassine.msarticle.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.yassine.commons.dto.ArticleDto;
import tn.yassine.commons.dto.StockDto;
import tn.yassine.msarticle.entities.Article;

@RequiredArgsConstructor
@Service
public class ArticleMapper {
    public ArticleDto ArtitcletoDto(Article article, StockDto stockDto){
        ArticleDto articleDto=new ArticleDto();
        articleDto.setNom(article.getNom());
        articleDto.setQte(article.getQte());
        articleDto.setStockDto(stockDto);
        return articleDto;
    }
    public Article ArticleDtotoArticle(ArticleDto articleDto){
        Article article=new Article();
        article.setNom(articleDto.getNom());
        article.setQte(articleDto.getQte());

        return article;
    }
}
