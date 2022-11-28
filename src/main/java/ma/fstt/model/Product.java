package ma.fstt.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private long productId;

	@Column(length = 25, nullable = true, name = "product_name")
	private String productName;

	@Column(length = 255, nullable = true, name = "image")
	private String image;

	@Column(length = 255, nullable = true, name = "description")
	private String description;

	@Column(nullable = true, name = "price")
	private float price;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@Column(nullable = true, name = "quantity")
	private Integer quantity;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Collection<CartDetail> cartDetails;

	public Product(long productId, String productName, String image, String description, float price, Category category,
			Integer quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.image = image;
		this.description = description;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
	}

	public Product(String productName, String image, String description, float price, Category category,
			Integer quantity) {
		super();
		this.productName = productName;
		this.image = image;
		this.description = description;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
	}

	public Product() {
		super();
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Collection<CartDetail> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(Collection<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
