package ma.fstt.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_detail")
public class CartDetail implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "cartdetail_id")
	private long cartDetailId;

	@Column(nullable = true, name= "product_quantity")
	private int productQuantity;
	
	@ManyToOne
	@JoinColumn(name= "cart_id")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name= "product_id")
	private Product product;

	public CartDetail(long cartDetailId, int productQuantity, Cart cart, Product product) {
		super();
		this.cartDetailId = cartDetailId;
		this.productQuantity = productQuantity;
		this.cart = cart;
		this.product = product;
	}

	public CartDetail(int productQuantity, Cart cart, Product product) {
		super();
		this.productQuantity = productQuantity;
		this.cart = cart;
		this.product = product;
	}

	public CartDetail() {
		super();
	}

	public long getCartDetailId() {
		return cartDetailId;
	}

	public void setCartDetailId(long cartDetailId) {
		this.cartDetailId = cartDetailId;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
