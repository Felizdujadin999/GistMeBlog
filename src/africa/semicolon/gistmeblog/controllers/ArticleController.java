package Africa.Semicolon.GistMeBlog.controllers;

import Africa.Semicolon.GistMeBlog.dtos.requests.CreateArticleRequest;
import Africa.Semicolon.GistMeBlog.services.ArticleService;
import Africa.Semicolon.GistMeBlog.services.ArticleServiceImpl;

public class ArticleController {
    private ArticleService articleService = new ArticleServiceImpl();

    public Object createPost(CreateArticleRequest request) {
        return articleService.createNewArticle(request);
    }
    public Object findPost(int id) {
        try {
            return articleService.findArticle(id);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
