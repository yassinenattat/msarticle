package tn.yassine.msarticle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.yassine.msarticle.entities.Article;

public interface ArticleRepositories extends JpaRepository<Article, Long> {
}
