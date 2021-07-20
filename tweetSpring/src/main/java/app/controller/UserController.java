package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@Valid @RequestBody User user){
		userService.add(user);
		System.out.println(user);
		return user;
	}

	@GetMapping
	public List<User> getAll(){
		List<User> validUsers = userService.getValidUsers();
		validUsers.forEach(System.out::println);
		return validUsers;
	}

	@GetMapping("/{id}")
	public User get(@PathVariable("id") int id){
		User user = userService.getUser(id);
		System.out.println(user);
		return user;
	}
}
