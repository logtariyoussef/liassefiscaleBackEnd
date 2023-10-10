package tn.enicarthage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.Model.Catégorie;
import tn.enicarthage.Service.CatégorieService;

@RestController

@CrossOrigin("http://localhost:4200/")
public class CatégorieController {
 
	@Autowired
	private CatégorieService catService;
	
	@GetMapping("/getAllCat")
	public ResponseEntity<List<Catégorie>> getAllCat(){
		return new ResponseEntity<List<Catégorie>>(catService.getAllCat(), HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Catégorie>getCat(@PathVariable Long id){
		return new ResponseEntity<Catégorie>(catService.getCat(id), HttpStatus.OK);
	}
	
	@PostMapping("/saveCat")
	public ResponseEntity<Catégorie>saveCat(@RequestBody Catégorie cat){
		return new ResponseEntity<Catégorie>(catService.saveCat(cat), HttpStatus.OK);
	}
}
