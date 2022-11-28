package ma.fstt.test;

import java.util.List;

import ma.fstt.model.Category;
import ma.fstt.model.Product;
import ma.fstt.persistence.CategoryOperations;
import ma.fstt.persistence.ProductOperations;

public class ProductTest {
	
	public static void main(String[] args) {
		ProductOperations productOperations = new ProductOperations();
		CategoryOperations categoryOperations = new CategoryOperations();
		Category category = categoryOperations.findCategory(1l);
		Product product = new Product("Tajine", "", "green shirt", 120, category, 10);
		
		productOperations.persistProduct(product);
	}
}