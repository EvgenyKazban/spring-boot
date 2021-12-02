package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;


@Controller
public class UserController {


	private final UserService userService;

	@Autowired
	public UserController(RoleService roleService, UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String pageMain() {
		return "user/mainPage";
	}

	@GetMapping(value = "/user")
	public String getUserPage(@AuthenticationPrincipal User user, Model model) {
		model.addAttribute("user", user);
		return "user/userShowId";
	}




}
