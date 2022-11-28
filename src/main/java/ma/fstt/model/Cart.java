package ma.fstt.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carts")
public class Cart implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private long cartId;

	@Column(nullable = true, name = "items_price")
	private float itemsPrice;

	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
	private Collection<CartDetail> cartDetail;

	public Cart(long cartId, float itemsPrice) {
		super();
		this.cartId = cartId;
		this.itemsPrice = itemsPrice;
	}

	public Cart(float itemsPrice) {
		super();
		this.itemsPrice = itemsPrice;
	}

	public Cart() {
		super();
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public float getItemsPrice() {
		return itemsPrice;
	}

	public void setItemsPrice(float itemsPrice) {
		this.itemsPrice = itemsPrice;
	}

	public Collection<CartDetail> getCartDetail() {
		return cartDetail;
	}

	public void setCartDetail(Collection<CartDetail> cartDetail) {
		this.cartDetail = cartDetail;
	}
}
