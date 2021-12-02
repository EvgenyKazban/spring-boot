package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.State;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        user.setState(State.ACTIVE);
        sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    public User getUserById(long id) {
        return sessionFactory.getCurrentSession().find(User.class, id);
    }

    @Override
    public void update(long id, User updatedUser) {
        User user = getUserById(id);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setAge(updatedUser.getAge());
        user.setPassword(updatedUser.getPassword());
    }

    @Override
    public void delete(long id) {
        User user = getUserById(id);
        user.setState(State.DELETED);
    }

    @Override
    public User getUserByName(String name) {
        return sessionFactory.getCurrentSession().createQuery("from User where name = :name", User.class).setParameter("name", name).getSingleResult();
    }

    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User where state != " + State.DELETED.ordinal(), User.class).getResultList();
    }
}
