package tn.esprit.consomitounsi.security;

import javax.validation.constraints.*;

public class SignUpRequest {
	@NotBlank(message = "First name must not be empty")
	@Size(min = 4, max = 40, message = "Last name must contain more than 4 characters")
	private String firstName;
	@NotBlank(message = "First name must not be empty")
	@Size(min = 4, max = 40, message = "First name must contain more than 4 characters")
	private String lastName;



	@NotBlank
	@Size(min = 3, max = 15, message = "Username must contain more than 3 characters")
	private String username;

	@NotBlank
	@Size(max = 40)
	@Email
	private String email;

	@NotBlank
	@Size(min = 6, max = 20)
	private String password;

	@NotBlank
	private String role;

	private Long phone;

	private String addresse;

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
}