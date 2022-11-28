package ma.fstt.test;

import ma.fstt.model.Cart;
import ma.fstt.model.CartDetail;
import ma.fstt.model.Product;
import ma.fstt.persistence.CartDetailOperations;
import ma.fstt.persistence.CartOperations;
import ma.fstt.persistence.ProductOperations;

public class CartDetailTest {
	public static void main(String[] args) {
		CartDetailOperations cartDetailOperations = new CartDetailOperations();
		
		ProductOperations productOperations = new ProductOperations();
		Product product = productOperations.findProduct(2l);
		
		CartOperations cartOperations = new CartOperations();
		Cart cart = cartOperations.findCart(1l);
		
		CartDetail cartDetail = new CartDetail(1, cart, product);
		cartDetailOperations.addToCart(cartDetail);
	}
}
