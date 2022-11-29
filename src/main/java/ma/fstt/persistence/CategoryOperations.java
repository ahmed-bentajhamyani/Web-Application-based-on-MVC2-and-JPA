package ma.fstt.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import ma.fstt.model.Category;

public class CategoryOperations {
	private static final String PERSISTENCE_UNIT_NAME = "unit";
	private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
			.createEntityManager();
	private static EntityTransaction transactionObj = entityMgrObj.getTransaction();

	@SuppressWarnings("unchecked")
	public List<Category> getAllCategories() {
		Query queryObj = entityMgrObj.createQuery("SELECT c FROM Category c");
		List<Category> categories = queryObj.getResultList();
		if (categories != null && categories.size() > 0) {
			return categories;
		} else {
			return null;
		}
	}

	public Category findCategory(Long id) {
		Category category = entityMgrObj.find(Category.class, id);
		entityMgrObj.refresh(category);
		if (category != null) {
			return category;
		} else {
			return null;
		}
	}

	public String persistCategory(Category category) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		entityMgrObj.persist(category);
		transactionObj.commit();
		return "true";
	}

	public String updateCategory(Category category) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		Category newCategory = entityMgrObj.find(Category.class, category.getCategoryId());
		newCategory.setCategoryName(category.getCategoryName());
		transactionObj.commit();
		return "true";
	}

	public String deleteCategory(Category category) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		if (!entityMgrObj.contains(category)) {
			category = entityMgrObj.merge(category);
		}
		entityMgrObj.remove(category);
		transactionObj.commit();
		return "true";
	}
}
