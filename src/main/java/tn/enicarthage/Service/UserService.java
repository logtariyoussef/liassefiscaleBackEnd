package tn.enicarthage.Service;

import java.util.List;

import tn.enicarthage.Model.User;

public interface UserService {
  
	public List<User>getAllUser();
	
	public User getUserByMatri(String matricule);
}
