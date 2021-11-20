package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void add(User user);
    User getUserById(long id);
    void update(long id, User user);
    void d(long id);
}
