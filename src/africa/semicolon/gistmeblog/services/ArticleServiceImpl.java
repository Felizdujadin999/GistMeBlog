package Africa.Semicolon.GistMeBlog.services;

import Africa.Semicolon.GistMeBlog.data.models.Article;
import Africa.Semicolon.GistMeBlog.data.repositories.ArticleRepository;
import Africa.Semicolon.GistMeBlog.data.repositories.ArticleRepositoryImpl;
import Africa.Semicolon.GistMeBlog.dtos.requests.CreateArticleRequest;
import Africa.Semicolon.GistMeBlog.utils.Mapper;

public class ArticleServiceImpl implements ArticleService{
    ArticleRepository articleRepository = new ArticleRepositoryImpl();
    UserService userService = new UserServiceImpl();
    @Override
    public Article createNewArticle(CreateArticleRequest createArticleRequest) {
        try {
            var foundUser = userService.findUser(createArticleRequest.getAuthorId());
        }catch (NullPointerException ex){
            throw new IllegalArgumentException(String.format("Author with id %s does not exist", createArticleRequest.getAuthorId()));
        }
        Article article = new Article();
        Mapper.map(createArticleRequest, article);
        return articleRepository.save(article);
 }

    @Override
    public Article findArticle(int id) {
        return articleRepository.findById(id);
    }

    @Override
    public long count() {
        return articleRepository.count();
    }
}
