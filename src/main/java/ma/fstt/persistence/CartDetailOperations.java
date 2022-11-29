package ma.fstt.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import ma.fstt.model.Cart;
import ma.fstt.model.CartDetail;

public class CartDetailOperations {
	private static final String PERSISTENCE_UNIT_NAME = "unit";
	private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
			.createEntityManager();
	private static EntityTransaction transactionObj = entityMgrObj.getTransaction();

	@SuppressWarnings("unchecked")
	public List<CartDetail> getProductOfCart(Cart cart) {
		Query queryObj = entityMgrObj.createQuery("SELECT cd FROM CartDetail cd WHERE cd.cart = :cart")
				.setParameter("cart", cart);
		List<CartDetail> cartDetails = queryObj.getResultList();
		if (cartDetails != null && cartDetails.size() > 0) {
			for(CartDetail cd: cartDetails)
				entityMgrObj.refresh(cd);
			return cartDetails;
		} else {
			return null;
		}
	}

	public String addToCart(CartDetail cartDetail) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		if (!entityMgrObj.contains(cartDetail)) {
			cartDetail = entityMgrObj.merge(cartDetail);
		}
		entityMgrObj.persist(cartDetail);
		transactionObj.commit();
		return "true";
	}

	public String addQuantity(CartDetail cartDetail) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		CartDetail newCartDetail = entityMgrObj.find(CartDetail.class, cartDetail.getCartDetailId());
		newCartDetail.setProductQuantity(cartDetail.getProductQuantity() + 1);
		transactionObj.commit();
		return "true";
	}

	public String deleteFromCart(CartDetail cartDetail) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		if (!entityMgrObj.contains(cartDetail)) {
			cartDetail = entityMgrObj.merge(cartDetail);
		}
		entityMgrObj.remove(cartDetail);
		transactionObj.commit();
		return "true";
	}
	
	public String subtractQuantity(CartDetail cartDetail) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		CartDetail newCartDetail = entityMgrObj.find(CartDetail.class, cartDetail.getCartDetailId());
		newCartDetail.setProductQuantity(cartDetail.getProductQuantity() - 1);
		transactionObj.commit();
		return "true";
	}
	
	public String deleteCartDetail(CartDetail cartDetail) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		if (!entityMgrObj.contains(cartDetail)) {
			cartDetail = entityMgrObj.merge(cartDetail);
		}
		entityMgrObj.remove(cartDetail);
		transactionObj.commit();
		return "true";
	}
}
