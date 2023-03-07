package Africa.Semicolon.GistMeBlog.controllers;

import Africa.Semicolon.GistMeBlog.dtos.requests.RegisterRequest;
import Africa.Semicolon.GistMeBlog.services.UserService;
import Africa.Semicolon.GistMeBlog.services.UserServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService = new UserServiceImpl();

    public Object register(RegisterRequest request){
       try {
           return userService.register(request);
       }catch (IllegalArgumentException ex){
           return ex.getMessage();
       }
    }

    public Object findUserById(int id){
        return userService.findUser(id);
    }
}
