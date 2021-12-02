package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.RolesDAO;
import web.model.Role;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RolesDAO rolesDAO;

    @Autowired
    public RoleServiceImpl(RolesDAO rolesDAO) {
        this.rolesDAO = rolesDAO;
    }

    @Override
    public List<Role> getAllRoles() {
        return rolesDAO.getAllRoles();
    }

    @Override
    public void update(Role role) {
        rolesDAO.update(role);
    }

    @Override
    public void remove(Role role) {
        rolesDAO.remove(role);
    }

    @Override
    public Role add(Role role) {
        rolesDAO.add(role);
        return role;
    }

    @Override
    public Role findRoleById(long id) {
        return rolesDAO.findRoleById(id);
    }
}
