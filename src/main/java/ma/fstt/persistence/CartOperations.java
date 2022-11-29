package ma.fstt.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import ma.fstt.model.Cart;
import ma.fstt.model.Product;

public class CartOperations {
	private static final String PERSISTENCE_UNIT_NAME = "unit";
	private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
			.createEntityManager();
	private static EntityTransaction transactionObj = entityMgrObj.getTransaction();

	public Cart findCart(Long id) {
		Cart cart = entityMgrObj.find(Cart.class, id);
		entityMgrObj.refresh(cart);
		if (cart != null) {
			return cart;
		} else {
			return null;
		}
	}

	public String persistCart(Cart cart) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		entityMgrObj.persist(cart);
		transactionObj.commit();
		return "true";
	}

	public String updateItemsPrice(Cart cart, float itemsPrice) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		Cart newCart = findCart(cart.getCartId());
		newCart.setItemsPrice(itemsPrice);
		transactionObj.commit();
		return "true";
	}
}
