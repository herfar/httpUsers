package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {
	private UserService us;

	@Autowired
	public PeopleController (UserService us){
		this.us = us;
	}

	@GetMapping()
	public String getUsers(Model model){
		model.addAttribute("people", us.informationOfPeoples());
		return "info";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", us.getUserById(id));
		return "show";
	}


	@GetMapping("/new")
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		return "new";
	}

	@PostMapping()
	public String create(@ModelAttribute("user") @Valid User user,
						 BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "new";
		us.addUser(user);
		return "redirect:/info";
	}

	@GetMapping("/{id}/edit")
	public String updateUser(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", us.getUserById(id));
		return "edit";
	}
	@PatchMapping("/{id}")
	public String update (@ModelAttribute("user") User user,
						  BindingResult bindingResult,
						  @PathVariable("id") int id) {
		if(bindingResult.hasErrors())
			return "edit";
		us.updateUser(id, user);
		return "redirect:/info";
	}
	@DeleteMapping("/{id}")
	public String delete (@PathVariable("id") int id) {
		us.removeUser(id);
		return "redirect:/info";
	}
}
















//	@GetMapping(value = "/")
//	public String printWelcome(ModelMap model) {
//		List<String> messages = new ArrayList<>();
//		messages.add("Hello!");
//		messages.add("I'm Spring MVC application");
//		messages.add("5.2.0 version by sep'19 ");
//		model.addAttribute("messages", messages);
//		return "index";
//	}