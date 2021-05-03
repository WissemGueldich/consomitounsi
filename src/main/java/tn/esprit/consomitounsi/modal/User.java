package tn.esprit.consomitounsi.modal;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.HashSet;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),@UniqueConstraint(columnNames = { "email" }) })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long id;

	@Column(name = "username")
	private String username;

	@NaturalId
	private String email;

	private String password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE })
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();


	@Column(name = "addresse_user")
	private String addresse;

	@Column(name = "salt_user")
	private String salt;

	@Column(name = "created_user")
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date created;

	@Column(name = "updated_user")
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date updated;
	
	@Column(name = "firstname_user")
	private String firstName;
	@Column(name = "lastname_user")
	private String lastName;
	@Column(name = "birthday_user")
	private String birthday;
	@Column(name = "postalcode_user")
	private int postalCode;
	@Column(name = "city_user")
	private String city;
	@Column(name = "phone_user")
	private long phone;
	
	private String location;
	
	public User() {
		super();
	}

	public User(String firstName,String lastName, String username, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public User(User user) {
		this.id = user.getId();
		this.phone = user.getPhone();
		this.email = user.getEmail();
		this.addresse = user.getAddresse();
		this.password = user.getPassword();
		this.salt = user.getSalt();
		this.created = user.getCreated();
		this.updated = user.getUpdated();
		this.roles = user.getRoles();
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<Participations> participations;

	public Set<Participations> getParticipations() {
		return participations;
	}

	public void setParticipations(Set<Participations> participations) {
		this.participations = participations;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}



	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
	private static final long serialVersionUID = 1L;

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
