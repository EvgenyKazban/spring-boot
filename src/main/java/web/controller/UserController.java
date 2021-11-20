package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDAO;
import web.model.User;

@Controller
public class UserController {

	private final UserDAO userDAO;

	@Autowired
	public UserController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@GetMapping()
	public String getAllUsers(Model model) {
		model.addAttribute("users", userDAO.getAllUsers());
		return "index";
	}

	@GetMapping("/{id}")
	public String findId(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userDAO.getUserById(id));
		return "view";
	}

	@GetMapping("/new")
	public String newUser(Model model) {
		model.addAttribute("user",new User());
		return "new";
	}

	@PostMapping()
	public String addUser(@ModelAttribute("user") User user) {
		userDAO.add(user);
		return "redirect:/";
	}

	@GetMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id") long id) {
		model.addAttribute("user", userDAO.getUserById(id));
		return "edit";
	}

	@PostMapping("{id}")
	public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
		userDAO.update(id,user);
		return "redirect:/";
	}

	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id) {
		userDAO.d(id);
		return "redirect:/";
	}
	
}