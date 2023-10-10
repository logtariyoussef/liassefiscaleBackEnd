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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.Model.Document;
import tn.enicarthage.Model.LiasseFiscale;
import tn.enicarthage.Service.DocumentService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class DocumentController {

	@Autowired
	private DocumentService docService;
	
	@PostMapping("/createDoc")
	public ResponseEntity<Document>createDocument(@RequestBody Document doc){
		return new ResponseEntity<Document>(docService.createDoc(doc), HttpStatus.CREATED);
	}
	
	//add doc to categorie
	
	@PostMapping("/add/{idDoc}/{id}")
	public ResponseEntity<Document>addDocToCat(@PathVariable  Long idDoc,@PathVariable Long id){
		return new ResponseEntity<Document>(docService.addDocToCat(idDoc, id), HttpStatus.OK);
	}
	
	//add doc to liasse
	
	@PostMapping("/addDoc/{idDoc}/ToLiasse/{id}")//@PostMapping("/addDoc/{code}/ToLiasse/{id}")
	public ResponseEntity<String>addDocToLiasse(@PathVariable Long idDoc,@PathVariable Long id){
		return new ResponseEntity<String>(docService.addDocToLiasse(idDoc, id),HttpStatus.OK);
	}
	
	//add doc to detail doc
	@PostMapping("/Doc/{idDoc}/ToDetail/{id}")//@PostMapping("/Doc/{code}/ToDetail/{id}")
	public ResponseEntity<Document> addDocToDetail(@PathVariable Long idDoc,@PathVariable Long id){
		return new ResponseEntity<Document>(docService.addDetailToDoc(idDoc, id),HttpStatus.OK);
	}
	
	@GetMapping("/getAllDocs")
	public ResponseEntity<List<Document>> getAllDocs(){
		return new ResponseEntity<List<Document>>(docService.getAllDocs(), HttpStatus.OK);
	}
	
	
	//get list of docs by idliasse
	@GetMapping("/getListDocs/{idLiasse}")
	public ResponseEntity<List<Document>>getListDocsByIdLiasse(@PathVariable Long idLiasse){
		return new ResponseEntity<List<Document>>(docService.getDocsByIdLiasse(idLiasse),HttpStatus.OK);
	}
	
	//get doc by id
	@GetMapping("/getDocById/{id}")
	public ResponseEntity<Document>getDocById(@PathVariable Long id){
		return new ResponseEntity<Document>(docService.getDoc(id),HttpStatus.OK);
	}
	
	
}
