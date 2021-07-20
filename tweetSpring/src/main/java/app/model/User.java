package app.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
	private int id;
	@Email(message = "Erreur : mauvais format d'email")
	private String username;
	@NotEmpty(message = "Erreur : le champs password ne peut pas être vide")
	private String password;
	private String pseudo;
	private boolean active;
	private LocalDateTime tCreate;
	private List<User> follows;

	public User() {

	}

	
	public User(String username, String password, String pseudo, boolean active) {
		this.username = username;
		this.password = password;
		this.pseudo = pseudo;
		this.active = active;
		this.follows = new ArrayList<>();
	}

	// Pour debugger. Pas nécessaire
	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				",username='" + username + '\'' +
				", password='" + password + '\'' +
				", pseudo='" + pseudo + '\'' +
				", active='" + active + '\'' +
				", tCreate=" + tCreate +
				'}';
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDateTime gettCreate() {
		return tCreate;
	}

	public void settCreate(LocalDateTime tCreate) {
		this.tCreate = tCreate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<User> getFollows() {
		return follows;
	}
}
