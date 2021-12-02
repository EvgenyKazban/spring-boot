package web.dao;


import web.model.Role;

import java.util.List;


public interface RolesDAO {

    List<Role> getAllRoles();

    void update(Role role);

    void remove(Role role);

    void add(Role role);

    Role findRoleById(long id);

}

