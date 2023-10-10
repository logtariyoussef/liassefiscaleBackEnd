package tn.enicarthage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.Model.Tracabilité;
import tn.enicarthage.Service.TracabiliteService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class TracabiliteController {

	@Autowired
	private TracabiliteService tracabiliteService;
	
	@PostMapping("/createTrac")
	public ResponseEntity<Tracabilité>saveTracabilite(@RequestBody Tracabilité trac){
		return new ResponseEntity<Tracabilité>(tracabiliteService.saveTracabilite(trac),HttpStatus.OK);
	}
	
	@PostMapping("/addtrac/{mat}/{idtrac}/{idliasse}")
	public ResponseEntity<Tracabilité>addtrac(@PathVariable String mat,@PathVariable Long idtrac,@PathVariable Long idliasse){
		return new ResponseEntity<Tracabilité>(tracabiliteService.addUserAndLiasseToTrac(mat, idtrac, idliasse),HttpStatus.OK);
	}
	
	@PutMapping("/updateTrac/{id}")
	public ResponseEntity<Tracabilité>updateTrac(@PathVariable Long id,@RequestBody Tracabilité trace){
		return new ResponseEntity<Tracabilité>(tracabiliteService.updateTracabilite(id, trace),HttpStatus.OK);
	}
	
	@GetMapping("/getTracabilite/{id}")
	public ResponseEntity<Tracabilité>getTracabiliteById(@PathVariable Long id){
		return new ResponseEntity<Tracabilité>(tracabiliteService.getTracabiliteById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getTracByUserMat/{mat}")
	public ResponseEntity<List<Tracabilité>>getTracByUserMat(@PathVariable String mat){
		return new ResponseEntity<List<Tracabilité>>(tracabiliteService.getListByUserMat(mat),HttpStatus.OK);
	}
}
