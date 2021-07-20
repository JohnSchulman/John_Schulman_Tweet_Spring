package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/follow")
public class FollowController {
	@Autowired
	private UserService userService;

	@PostMapping("/follows")
	@ResponseStatus(HttpStatus.CREATED)
	public void addFollow(@RequestBody User user) {
		userService.addFollow(user);
	}

	@GetMapping("/follows")
	public List<User> getFollows() {
		return userService.getFollows();
	}

	@GetMapping("/followers")
	public List<User> getFollowers() {
		return userService.getFollowers();
	}
}
