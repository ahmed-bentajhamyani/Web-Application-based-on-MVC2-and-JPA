package ma.fstt.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;

	@Column(length = 55, nullable = true, name = "email")
	private String email;

	@Column(length = 15, nullable = true, name = "username")
	private String username;

	@Column(length = 15, nullable = true, name = "password")
	private String password;

	@OneToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

	public User(long userId, String email, String username, String password, boolean loggedIn, Cart cart) {
		super();
		this.userId = userId;
		this.email = email;
		this.username = username;
		this.password = password;
		this.cart = cart;
	}

	public User(String email, String username, String password, boolean loggedIn, Cart cart) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.cart = cart;
	}

	public User() {
		super();
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
