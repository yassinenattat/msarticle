package tn.yassine.msarticle.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.yassine.msarticle.entities.Article;
import tn.yassine.msarticle.services.IArticleService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class IArticleController {
private final IArticleService articleService;


@PatchMapping("/updateArticle/{id}")
public Article updateArticle(@RequestBody Map<Object,Object> fields,@PathVariable Long id){
    return articleService.updateArticle(fields,id);

}
    @PostMapping("/create-article")
    public Article createArticle(@RequestBody Article a) {
        Article article = articleService.createArticle(a);
        return a;
    }
    @GetMapping("/retrieve-all-article")
    public List<Article> retrieveAllArticle() {
        List<Article> listAr = articleService.retrieveAllArticle();
        return listAr;
    }


}
