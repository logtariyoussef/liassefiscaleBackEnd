package tn.enicarthage.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.enicarthage.Model.DétailDoc;
import tn.enicarthage.Model.XsdFile;
import tn.enicarthage.Service.XsdFileService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class xsdController {
 
	@Autowired
	private XsdFileService xsdFileService;
	
	 @PostMapping("/uploadXsdFile")
	    public ResponseEntity<XsdFile> saveXsdFile(@RequestParam("file") MultipartFile file) throws IOException{
	    	return new ResponseEntity<XsdFile>(xsdFileService.saveXsdFile(file),HttpStatus.OK);
	    }
	 
	 @GetMapping("/getFichierByNom/{idDoc}")
	 public ResponseEntity<XsdFile>getFichier(@PathVariable Long idDoc){
		 return new ResponseEntity<XsdFile>(xsdFileService.findXsdFileByNom(idDoc),HttpStatus.OK);
	 }
	 
	 @PostMapping("/addXsdFileToDetialDoc/{idDoc}")
	 public ResponseEntity<DétailDoc>addXsdToDetailDoc(@PathVariable Long idDoc){
		 return new ResponseEntity<DétailDoc>(xsdFileService.addXsdToDetailDoc(idDoc),HttpStatus.OK);
	 }
}
