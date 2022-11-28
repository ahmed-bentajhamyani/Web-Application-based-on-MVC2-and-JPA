package ma.fstt.test;

import java.util.List;

import ma.fstt.model.Category;
import ma.fstt.model.Product;
import ma.fstt.persistence.CategoryOperations;

public class CategoryTest {
	public static void main(String[] args) {
		CategoryOperations categoryOperations = new CategoryOperations();
		List<Category> categoryList = categoryOperations.getAllCategories();
		
		for(Category p: categoryList)
			System.out.println(p.getCategoryName());
	}
}
