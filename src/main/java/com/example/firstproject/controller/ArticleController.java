package com.example.firstproject.controller;

import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.firstproject.dto.ArticleForm;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());
        //System.out.println(form.toString());

        // Step 1: convert DTO to entity
        Article article = form.toEntity();
        log.info(article.toString());
        //System.out.println(article.toString());

        // Step 2: save entity to DB with repository
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        //System.out.println(saved.toString());
        return "";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);

        // Step 1: retrieve data
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //Optional<Article> articleEntity = articleRepository.findById(id);

        // Step 2: register data to model
        model.addAttribute("article", articleEntity);

        // Step 3: return view page
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        // Step 1: retrieve 'ALL' data
        Iterable<Article> articleEntityList = articleRepository.findAll();

        // Step 2: register data to model
        model.addAttribute("articleList", articleEntityList);

        // Step 3: set up for view page
        return "articles/index";
    }
}
