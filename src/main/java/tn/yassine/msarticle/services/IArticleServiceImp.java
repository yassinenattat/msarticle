package tn.yassine.msarticle.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;
import tn.yassine.msarticle.entities.Article;
import tn.yassine.msarticle.repositories.ArticleRepositories;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class IArticleServiceImp implements IArticleService{

    private final ArticleRepositories articleRepositories;

    @Override
    public List<Article> retrieveAllArticle() {
        return (List<Article>) articleRepositories.findAll();
    }

    @Override
    public Article createArticle( Article article){
        article.setCreatedAt(LocalDate.now());
        return articleRepositories.save(article);
    }
    public Article updateArticle(Map<Object,Object> fields,Long id){
        Optional<Article> a = articleRepositories.findById(id);
        Assert.isTrue(a.isPresent(), "There's no article for this ID");
        fields.forEach((key, value) ->{
            Field field = ReflectionUtils.findField(Article.class, (String)key);
            field.setAccessible(true);
            ReflectionUtils.setField(field,a.get(), value);
        } );
        return articleRepositories.save(a.get());
    }

    @Override
    public Article retreveByIdArticle(Long id) {
        return articleRepositories.findById(id).get();
    }

    @Override
    public void removeArticle(Long id) {
        articleRepositories.deleteById(id);

    }
}
