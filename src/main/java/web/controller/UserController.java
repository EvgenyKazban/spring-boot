package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping()
	public String getAllUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "index";
	}

	@GetMapping("/{id}")
	public String findId(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "view";
	}

	@GetMapping("/new")
	public String newUser(Model model) {
		model.addAttribute("user",new User());
		return "new";
	}

	@PostMapping()
	public String addUser(@ModelAttribute("user") User user) {
		userService.add(user);
		return "redirect:/";
	}

	@GetMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id") long id) {
		model.addAttribute("user", userService.getUserById(id));
		return "edit";
	}

	@PostMapping("{id}")
	public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
		userService.update(id,user);
		return "redirect:/";
	}

	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id) {
		userService.delete(id);
		return "redirect:/";
	}
	
}