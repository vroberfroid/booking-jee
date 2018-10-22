package be.bo.user.service.api;

import java.util.Collection;

import be.bo.user.User;

public interface IUserService {

	public User retrieveUser(Long id);

	public void deleteUser(Long id);

	public void updateUser(User user);

	public void createUser(User user);

	public Collection<User> getAllUser();
}
