package ma.fstt.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import ma.fstt.model.Product;

public class ProductOperations {
	private static final String PERSISTENCE_UNIT_NAME = "unit";
	private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
			.createEntityManager();
	private static EntityTransaction transactionObj = entityMgrObj.getTransaction();

	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		Query queryObj = entityMgrObj.createQuery("SELECT p FROM Product p");
		List<Product> products = queryObj.getResultList();
		if (products != null && products.size() > 0) {
			return products;
		} else {
			return null;
		}
	}

	public Product findProduct(Long id) {
		Product product = entityMgrObj.find(Product.class, id);
		entityMgrObj.refresh(product);
		if (product != null) {
			return product;
		} else {
			return null;
		}
	}

	public String persistProduct(Product product) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		if (!entityMgrObj.contains(product)) {
			product = entityMgrObj.merge(product);
		}
		entityMgrObj.persist(product);
		transactionObj.commit();
		return "true";
	}

	public String updateProduct(Product product) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		Product newProduct = entityMgrObj.find(Product.class, product.getProductId());
		newProduct.setProductName(product.getProductName());
		newProduct.setDescription(product.getDescription());
		newProduct.setImage(product.getImage());
		newProduct.setPrice(product.getPrice());
		newProduct.setQuantity(product.getQuantity());
		newProduct.setCategory(product.getCategory());
		transactionObj.commit();
		return "true";
	}

	public String deleteProduct(Product product) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		if (!entityMgrObj.contains(product)) {
			product = entityMgrObj.merge(product);
		}
		entityMgrObj.remove(product);
		transactionObj.commit();
		return "true";
	}
}
