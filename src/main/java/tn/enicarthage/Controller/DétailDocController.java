package tn.enicarthage.Controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;

import tn.enicarthage.Model.Document;
import tn.enicarthage.Model.DétailDoc;
import tn.enicarthage.Model.XsdFile;
import tn.enicarthage.Repository.DocumentRepository;
import tn.enicarthage.Repository.DétailDocRepository;
import tn.enicarthage.Service.DétailDocService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class DétailDocController {
	
    @Autowired
	private DétailDocService docService;
  
   
    @Autowired
    private DétailDocRepository detailRepo;
    
    @PostMapping("/uploadFile")
    public ResponseEntity<DétailDoc> saveDocFile(@RequestParam("file") MultipartFile file) throws IOException{
    	return new ResponseEntity<DétailDoc>(docService.saveDocFile(file),HttpStatus.OK);
    }
    
    @GetMapping("/getFile/{id}")
    public ResponseEntity<DétailDoc>getFileDoc(@PathVariable Long id){
    	return new ResponseEntity<DétailDoc>(docService.getDocFile(id),HttpStatus.OK);
    }
    
    //better method to download
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        Optional<DétailDoc> fileDataOptional = detailRepo.findById(id);
        if (fileDataOptional.isPresent()) {
        	DétailDoc fileData = fileDataOptional.get();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(fileData.getTypeFichier()));
            headers.setContentDispositionFormData("attachement", fileData.getNomFichier());
           return new ResponseEntity<byte[]>(fileData.getContentDoc(), headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    //validate xml file
    @PostMapping("/validate-xml")
    public String validateXML(@RequestParam("xmlFile") MultipartFile xmlFile, @RequestParam("xsdFile") MultipartFile xsdFile) throws IOException {
        try {
            // Créez une usine de schéma XML et compilez le schéma XSD
            SchemaFactory schemaFactory = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new StreamSource(xsdFile.getInputStream()));

            // Créez un validateur
            Validator validator = schema.newValidator();

            // Validez le fichier XML par rapport au schéma
            validator.validate(new StreamSource(xmlFile.getInputStream()));

            return "Le fichier XML est valide par rapport au schéma XSD.";
        } catch (Exception e) {
            return "Le fichier XML n'est pas valide par rapport au schéma XSD : " + e.getMessage();
        }
    }

    
    //validate xml methode2
    
    @PostMapping("/validate-xml/{idDoc}")
    public ResponseEntity<Boolean> validateXmlWithXsd(@PathVariable Long idDoc) {
        return  new ResponseEntity<Boolean>(docService.validateXml(idDoc),HttpStatus.OK);
    }
   
			
			   
}
            
			
    

    
   
   

