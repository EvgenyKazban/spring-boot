package web.initializers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.service.UserService;
import web.model.User;

import javax.annotation.PostConstruct;

@Component
public class DbInitializer {

    private UserService userService;

    @Autowired
    public DbInitializer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        User user1 = new User("Ivan Ivanov","Admin", (byte) 30);
        User user2 = new User("Oksana","Root", (byte) 50);
        userService.add(user1);
        userService.add(user2);
    }
}
