package be.bo.user.service;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import be.bo.user.User;

@ApplicationScoped
@Transactional
public class UserService {

	public static final String PERSISTENCEUNIT = "User_PersistenceUnit";

	@PersistenceContext(unitName = PERSISTENCEUNIT)
	private EntityManager entityManager;

	public UserService() {
	}

	public User retrieveUser(Long id) {
		User user = entityManager.find(User.class, id);
		if (user != null) {
			System.out.println("*** In UserService - Retrieve user: " + id + ":" + user.getName());
		} else {
			System.out.println("*** In UserService - Retrieve user: " + id + " not found");
		}
		return user;
	}

	public void deleteUser(Long id) {
		User tmp = retrieveUser(id);
		if (tmp != null) {
			entityManager.remove(tmp);
		}
	}

	public void updateUser(User user) {
		entityManager.merge(user);
	}

	public void createUser(User user) {
		System.out.println("*** In UserService - Create user: " + user.getId() + ":" + user.getName());
		entityManager.persist(user);
	}

	public Collection<User> getAllUser() {
		Query query = entityManager.createQuery("SELECT e FROM User e");
		return (Collection<User>) query.getResultList();
	}
}
