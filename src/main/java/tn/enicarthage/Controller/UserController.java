package tn.enicarthage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.Model.User;
import tn.enicarthage.Service.UserService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class UserController {
    @Autowired
	private UserService userService;
	
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>>getAllUsers(){
    	return new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);
    }
    
    @GetMapping("/getUserByMatricule/{matricule}")
    public ResponseEntity<User>getUserByMat(@PathVariable String matricule){
    	return new ResponseEntity<User>(userService.getUserByMatri(matricule),HttpStatus.OK);
    }
}
