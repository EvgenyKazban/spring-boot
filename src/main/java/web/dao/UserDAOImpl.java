package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
        user.setState(User.STATE_ACTIVE);
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
        user.setRole(updatedUser.getRole());
        user.setAge(updatedUser.getAge());
    }

    @Override
    public void d(long id) {
        User user = getUserById(id);
        user.setState(User.STATE_DELETED);

        //sessionFactory.getCurrentSession().remove(user);
        //sessionFactory.getCurrentSession().delete(user);
        //User user = getUserById(id);
        /*EntityManager entityManager = sessionFactory.getCurrentSession().getEntityManagerFactory().createEntityManager();

        entityManager.createNativeQuery("delete from User where id = :id")
                .setParameter("id", id)
                .executeUpdate();
        entityManager.flush();
        entityManager.clear();*/
        /*
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
            entityManager.flush();
            entityManager.clear();/*
            sessionFactory.getCurrentSession().delete(user);
            sessionFactory.getCurrentSession().flush();
            sessionFactory.getCurrentSession().clear();*/
        /*} else {
            throw new IllegalArgumentException("Wrong user id");
        }*/
    }

    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User where state != 2", User.class).getResultList();
    }
}
