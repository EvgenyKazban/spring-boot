package web.initializers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.UserDAO;
import web.model.User;

import javax.annotation.PostConstruct;

@Component
public class DbInitializer {

    private UserDAO userDAO;

    @Autowired
    public DbInitializer(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @PostConstruct
    public void init() {
        User user1 = new User("Ivan Ivanov","Admin", (byte) 30);
        User user2 = new User("Oksana","Root", (byte) 50);
        userDAO.add(user1);
        userDAO.add(user2);
    }
}
