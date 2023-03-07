package Africa.Semicolon.GistMeBlog.services;

import Africa.Semicolon.GistMeBlog.data.models.Article;
import Africa.Semicolon.GistMeBlog.dtos.requests.CreateArticleRequest;

public interface ArticleService {
    Article createNewArticle(CreateArticleRequest createArticleRequest);
    Article findArticle(int id);
    long count();
}
