package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void add(User user);
    User getUserById(long id);
    void update(long id, User user);
    void delete(long id);
}
