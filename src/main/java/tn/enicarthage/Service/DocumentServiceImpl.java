package tn.enicarthage.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.Model.Catégorie;
import tn.enicarthage.Model.Document;
import tn.enicarthage.Model.DétailDoc;
import tn.enicarthage.Model.LiasseFiscale;
import tn.enicarthage.Repository.CatégorieRepository;
import tn.enicarthage.Repository.DocumentRepository;
import tn.enicarthage.Repository.DétailDocRepository;
import tn.enicarthage.Repository.LiasseFiscaleRepository;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository docRepo;
	
	@Autowired
	private CatégorieRepository catRepo;
	@Autowired
	private LiasseFiscaleRepository liasseRepo;

	@Autowired
	private DétailDocRepository detailRepo;
	
	@Override
	public Document createDoc(Document document) {
		
		return docRepo.save(document);
	}

	//get list of docs
	@Override
	public List<Document> getAllDocs() {
		return docRepo.findAll();
	}
	//add categorie to doc

	@Override
	public Document addDocToCat(Long idDoc, Long idCat) {
		
		Catégorie cat=catRepo.findById(idCat).orElse(null);
		Document doc=docRepo.findById( idDoc).orElse(null);
		doc.setCategorie(cat);
		
		return docRepo.save(doc);
		
	}

	//add doc liasse to doc
	@Override
	public String addDocToLiasse(Long idDoc, Long idLiasse) {
		Document doc=docRepo.findById( idDoc).orElse(null);
		LiasseFiscale liasse=liasseRepo.findById(idLiasse).orElse(null);
		doc.setLiasseFiscale(liasse);
		docRepo.save(doc);
		return ("added successfuly!");
	}

	

	//add file to docs
	@Override
	public Document addDetailToDoc(Long idDoc, Long idDetailDoc) {
		Document doc=docRepo.findById(idDoc).orElse(null);
		DétailDoc detailDoc=detailRepo.findById(idDetailDoc).orElse(null);
		doc.setDetailDoc(detailDoc);
		return docRepo.save(doc);
		
	}

	@Override
	public List<Document> getDocsByIdLiasse(Long idLiasse) {
		
		return docRepo.findByLiasseFiscaleId(idLiasse);
	}

	@Override
	public Document getDoc(Long idDoc) {
		
		return docRepo.findById(idDoc).orElse(null);
	}
	

	
}
