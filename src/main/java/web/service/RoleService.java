package web.service;

import web.model.Role;

import java.util.List;

public interface RoleService  {

    List<Role> getAllRoles();

    void update(Role role);

    void remove(Role role);

    Role add(Role role);

    Role findRoleById(long id);
}
