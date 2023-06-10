package tn.yassine.msarticle.services;

import tn.yassine.msarticle.entities.Article;

import java.util.List;
import java.util.Map;

public interface IArticleService {
    List<Article> retrieveAllArticle();
    Article createArticle(Article a);
    Article updateArticle(Map<Object,Object> fields, Long id);
    Article retreveByIdArticle (Long id);
    void removeArticle(Long id);



}
