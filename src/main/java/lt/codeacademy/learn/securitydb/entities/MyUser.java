package lt.codeacademy.learn.securitydb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class MyUser {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(nullable = false, unique = true)
	private String username;
	

	private String name;
	
	private String password;
	
	@Transient
	private String matchingPassword;
	
	private String role;

	public MyUser() {}

	public MyUser(Long id, String username, String name,
			String password, String matchingPassword, String role) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.role = role;
	}

	public MyUser(String username, String name,
			String password, String matchingPassword, String role) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	@Override
	public String toString() {
		return "MyUser [id=" + id + ", username=" + username + ", name=" + name + ", password=" + password
				+ ", matchingPassword=" + matchingPassword + ", role=" + role + "]";
	}

	
}
