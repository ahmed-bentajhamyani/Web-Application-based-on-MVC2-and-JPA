package ma.fstt.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import ma.fstt.model.User;

public class UserOperations {
	private static final String PERSISTENCE_UNIT_NAME = "unit";
	private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
			.createEntityManager();
	private static EntityTransaction transactionObj = entityMgrObj.getTransaction();

	@SuppressWarnings("unchecked")
	public boolean validate(String username, String password) {
		Query queryObj = entityMgrObj.createQuery(
				"Select u.username, u.password from User u WHERE u.username = :username and u.password = :password")
				.setParameter("username", username).setParameter("password", password);
		List<User> users = queryObj.getResultList();
		if (users != null && users.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public User findUserByUsername(String username) {
		Query queryObj = entityMgrObj.createQuery(
				"Select u FROM User u WHERE u.username = :username")
				.setParameter("username", username);
		User user = (User) queryObj.getResultList().get(0);
		entityMgrObj.refresh(user);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

	public String signUpUser(User user) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		entityMgrObj.persist(user);
		transactionObj.commit();
		return "true";
	}

	public String updateUser(User user) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		User newUser = entityMgrObj.find(User.class, user.getUserId());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setCart(user.getCart());
		transactionObj.commit();
		return "true";
	}

	public String deleteUser(User user) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		if (!entityMgrObj.contains(user)) {
			user = entityMgrObj.merge(user);
		}
		entityMgrObj.remove(user);
		transactionObj.commit();
		return "true";
	}
}
