package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class RoleDAOImpl implements RolesDAO {

    @PersistenceContext()
    EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery(
                "from Role").getResultList();
    }

    @Override
    public void update(Role role) {//редактировать роль
        entityManager.merge(role);
    }

    @Override
    public void remove(Role role) {
        entityManager.remove(role);
    }

    @Override
    public void add(Role role) {//создать роль
        entityManager.persist(role);
    }

    @Override
    public Role findRoleById(long id) throws NoSuchElementException {
        return entityManager.find(Role.class, id);
    }
}
