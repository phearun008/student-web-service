package student.service;

import student.entity.user.User;

public interface UserService {
	public User findUserByEmail(String email);
}
