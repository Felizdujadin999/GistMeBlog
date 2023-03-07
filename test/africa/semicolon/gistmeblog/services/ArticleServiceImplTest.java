package Africa.Semicolon.GistMeBlog.services;

import Africa.Semicolon.GistMeBlog.data.models.Article;
import Africa.Semicolon.GistMeBlog.dtos.requests.CreateArticleRequest;
import Africa.Semicolon.GistMeBlog.dtos.requests.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArticleServiceImplTest {
    ArticleService articleService;
    UserService userService;
    Article savedArticle;
    CreateArticleRequest createArticleRequest;
    @BeforeEach
 public void setUp(){
        articleService = new ArticleServiceImpl();
        CreateArticleRequest createArticleRequest = new CreateArticleRequest();
        createArticleRequest.setBody("My Body");
        createArticleRequest.setTitle("My Title");
        createArticleRequest.setAuthorId(1);
        userService = new UserServiceImpl();
    }

    @Test public void saveNewArticle_NoOfArticleIsOneTest(){
        articleService = new ArticleServiceImpl();
        RegisterRequest request = new RegisterRequest();
        userService.register(request);
        savedArticle = articleService.createNewArticle(createArticleRequest);
        assertEquals(1, articleService.count());
    }

    @Test void shouldThrowException_ifAuthorIdIsInvalid(){
        CreateArticleRequest createArticleRequest = new CreateArticleRequest();
        createArticleRequest.setBody("Body");
        createArticleRequest.setTitle("Title");
        createArticleRequest.setAuthorId(1);
        try {
            articleService.createNewArticle(createArticleRequest);
        }catch (IllegalArgumentException ex){
            assertEquals("Author with id 1 does not exist", ex.getMessage());
        }
    }
}