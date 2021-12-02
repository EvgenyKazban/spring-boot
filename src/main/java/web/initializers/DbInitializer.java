package web.initializers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.Role;
import web.service.RoleService;
import web.service.UserService;
import web.model.User;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DbInitializer {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public DbInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        Set<Role> rolesForAdmin = new HashSet<>();
        Set<Role> rolesForUser = new HashSet<>();

        rolesForAdmin.add(roleAdmin);
        rolesForAdmin.add(roleUser);

        rolesForUser.add(roleUser);

        roleService.add(roleAdmin);
        roleService.add(roleUser);

        User user1 = new User("Ivan Ivanov","admin@admin.ad", (byte) 30);
        user1.setRoles(rolesForAdmin);
        user1.setPassword("IIIIII");
        User user2 = new User("Oksana","root@root.ro", (byte) 50);
        user2.setRoles(rolesForUser);
        user2.setPassword("OOOOOO");
        userService.add(user1);
        userService.add(user2);
    }
}
