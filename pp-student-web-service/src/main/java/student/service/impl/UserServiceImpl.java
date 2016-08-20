package student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.entity.user.User;
import student.repository.UserRepository;
import student.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findUserByEmail(String email){
		return userRepository.findUserByEmail(email);
	}

}
