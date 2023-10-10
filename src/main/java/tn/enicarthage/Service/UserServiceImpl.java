package tn.enicarthage.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.Model.User;
import tn.enicarthage.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> getAllUser() {
		
		return userRepo.findAll() ;
	}

	@Override
	public User getUserByMatri(String matricule) {
		
		return userRepo.findById(matricule).orElse(null);
	}
 
	
}
