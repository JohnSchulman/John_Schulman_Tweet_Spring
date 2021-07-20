package app.service;

import app.exception.NotFoundException;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
	@Autowired
	private Random random;

	// pas besoin d'un @autowired car c'est un propriété
	private List<User> users = new ArrayList<>();

	// faut une constructeur même si il est vide
	public UserService() {

	}

	@PostConstruct
	public void init() {
		User user1 = new User("rael06@hotmail1.fr", "pass", "1", true);
		User user2 = new User("rael06@hotmail2.fr", "pass", "2", false);
		User user3 = new User("rael06@hotmail3.fr", "pass", "3", true);
		add(user1);
		add(user2);
		add(user3);
		user3.getFollows().add(user1);
		user3.getFollows().add(user2);
	}

	// Concerne ton mode Post
	public void add(User user) {
		user.setId(random.nextInt(Integer.MAX_VALUE));
		user.settCreate(LocalDateTime.now());
		users.add(user);
	}

	// tout les autres fonction ca concerne mode Get

	public List<User> getValidUsers() {
		return users.stream().filter(User::isActive).collect(Collectors.toList());
	}

	public User getUser(int id) {
		return users.stream().filter(u -> u.getId() == id).findFirst().orElseThrow(NotFoundException::new);
	}

	public User getAuthenticatedUser() {
		return users.get(0);
	}

	public void addFollow(User user) {
		User follow = users.stream().filter(u -> u.getId() == user.getId()).findFirst().orElseThrow(NotFoundException::new);
		getAuthenticatedUser().getFollows().add(follow);
	}

	public List<User> getFollows() {
		return getAuthenticatedUser().getFollows();
	}

	public List<User> getFollowers() {
		Set<User> followers = new HashSet<>();

		int authenticatedUserId = getAuthenticatedUser().getId();

		for (User user : users) {
			List<User> follows = user.getFollows();

			follows.stream().filter(f -> f.getId() == authenticatedUserId).forEach(f->followers.add(user));

//			for (User follow : follows) {
//				if (follow.getId() == authenticatedUserId) {
//					followers.add(user);
//				}
//			}
		}
		return new ArrayList<>(followers);
	}

	public List<User> getUsers() {
		return users;
	}
}
