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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.Model.Document;
import tn.enicarthage.Model.LiasseFiscale;
import tn.enicarthage.Service.LiasseFiscaleService;

@RestController

@CrossOrigin("http://localhost:4200")
public class LiasseFiscaleController {
 
	@Autowired
	private LiasseFiscaleService liasseService;
	
	@PostMapping("/createLiasse")
	public ResponseEntity<LiasseFiscale>saveLiasse(@RequestBody LiasseFiscale liasse){
		return new ResponseEntity<LiasseFiscale>(liasseService.saveLiasse(liasse), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllLiasse")
	
	public ResponseEntity<List<LiasseFiscale>>getAllLiasse(){
		return new ResponseEntity<List<LiasseFiscale>>(liasseService.getAllLiasse(), HttpStatus.OK);
	}
	
	@GetMapping("/getLiasse/{id}")
	public ResponseEntity<LiasseFiscale>getLiasse(@PathVariable Long id){
		return new ResponseEntity<LiasseFiscale>(liasseService.getLiasse(id), HttpStatus.OK);
	}
	
	//add liasse to list of docs
	@PostMapping("/addLiasse/{id}")
	public ResponseEntity<List<Document>>addLiasseToDocs(@PathVariable Long id,@RequestBody List<Long>idDocs){
		return new ResponseEntity<List<Document>>(liasseService.addLiasseToDocs(id,idDocs),HttpStatus.OK);
	}
	
	//update liasse
	@PutMapping("/updateLiasse/{idLiasse}")
	public ResponseEntity<LiasseFiscale>updateLiasse(@PathVariable Long idLiasse,@RequestBody LiasseFiscale liasse){
		return new ResponseEntity<LiasseFiscale>(liasseService.updateLiasse(idLiasse, liasse), HttpStatus.OK);
	}
	
}
