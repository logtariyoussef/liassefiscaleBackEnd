package tn.enicarthage.Service;

import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import tn.enicarthage.Model.Document;
import tn.enicarthage.Model.DétailDoc;
import tn.enicarthage.Repository.DocumentRepository;
import tn.enicarthage.Repository.DétailDocRepository;

@Service
public class DétailDocServiceImpl implements DétailDocService {

	@Autowired
	private DétailDocRepository detailDocRepo;
	@Autowired
	private DocumentRepository docRepo;
	
	@Override
	public DétailDoc saveDocFile(MultipartFile file) throws IOException {
		DétailDoc fichierDoc=new DétailDoc ();
		fichierDoc.setNomFichier(file.getOriginalFilename());
		fichierDoc.setTypeFichier(file.getContentType());
		fichierDoc.setContentDoc(file.getBytes());
		
		return detailDocRepo.save(fichierDoc);
	}

	@Override
	public DétailDoc getDocFile(Long id) {
		
		return detailDocRepo.findById(id).orElse(null);
	}

	@Override
	 @Transactional
	public Boolean validateXml(Long id) {
		Document docExist= docRepo.findById(id).orElse(null);
		byte[] xmlContent=docExist.getDetailDoc().getContentDoc();
		byte[] xsdContent=docExist.getDetailDoc().getXsdFile().getXsdContent();
		
		
		try {
            // Créez une instance de la fabrique de schéma
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Créez le schéma XSD à partir du tableau de bytes xsdContent
            Schema schema = factory.newSchema(new StreamSource(new ByteArrayInputStream(xsdContent)));

            // Créez un validateur XML
            Validator validator = schema.newValidator();

            // Validez le document XML à partir du tableau de bytes xmlContent
            validator.validate(new StreamSource(new ByteArrayInputStream(xmlContent)));

            return true ; // "Le fichier XML est valide par rapport au schéma XSD."
        } catch (Exception e) {
            e.printStackTrace();
            return false; // "Le fichier XML n'est pas valide par rapport au schéma XSD : " + e.getMessage()
        }
		
		
		
		
	}

	/*@Override
	public DétailDoc addXsd(Long idDoc,String nomXsdFile) {
		Document docExist=docRepo.findById(idDoc).orElse(null);
		
	}*/

	

}
