package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;



    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "admin/list";
    }

    @GetMapping("/{id}")
    public String findId(@PathVariable("id")Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/showId";
      }

    @GetMapping("/create")
    public String newUser(@ModelAttribute("user") User user, Model model) {
        List<Role> listRoles = roleService.getAllRoles();
        model.addAttribute("listRoles",listRoles);
        return "admin/create";
    }

    @PostMapping("/create")
    public String addUser(@RequestParam("idRoles") List<Long> idRoles,
                          User user) {
       Set<Role> roleList = new HashSet<>();
       for(Long id:idRoles) {
           roleList.add(roleService.findRoleById(id));
       }
       user.setRoles(roleList);
       userService.add(user);
       return "redirect:/admin/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model,
                       @PathVariable("id")long id) {
        model.addAttribute("user",userService.getUserById(id));
        return "admin/edit";
    }

    @PostMapping ("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user.getId(), user);
        return "redirect:/admin/users";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }

}
