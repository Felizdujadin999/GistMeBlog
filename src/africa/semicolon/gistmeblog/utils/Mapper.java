package Africa.Semicolon.GistMeBlog.utils;

import Africa.Semicolon.GistMeBlog.data.models.Article;
import Africa.Semicolon.GistMeBlog.data.models.User;
import Africa.Semicolon.GistMeBlog.dtos.requests.CreateArticleRequest;
import Africa.Semicolon.GistMeBlog.dtos.requests.RegisterRequest;
import Africa.Semicolon.GistMeBlog.dtos.responses.FindUserResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {
    public static User map(RegisterRequest registerRequest){
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setUserName(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        return user;
    }

    public static void map(RegisterRequest registerRequest, User user){
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setUserName(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
    }

    public static void map(User foundUser, FindUserResponse response){
        response.setFullName(foundUser.getFirstName()+ " " + foundUser.getLastName());
        response.setUserId(foundUser.getId());
        response.setUsername(foundUser.getUserName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd/MM/yyyy, hh:mm a");
        response.setDateRegistered(formatter.format(foundUser.getDateRegistered()));
    }

    public static void map(CreateArticleRequest createArticleRequest, Article article) {
        article.setBody(createArticleRequest.getBody());
        article.setTitle(createArticleRequest.getTitle());
        article.setAuthorId(createArticleRequest.getAuthorId());
    }
}
