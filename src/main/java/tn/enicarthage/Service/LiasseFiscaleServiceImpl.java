package tn.enicarthage.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.Model.Document;
import tn.enicarthage.Model.LiasseFiscale;
import tn.enicarthage.Repository.DocumentRepository;
import tn.enicarthage.Repository.LiasseFiscaleRepository;

@Service
public class LiasseFiscaleServiceImpl implements LiasseFiscaleService {
  
	@Autowired
	private LiasseFiscaleRepository liasseFiscaleRepo;
	
	@Autowired
	private DocumentRepository docRepo;

	@Override
	public LiasseFiscale saveLiasse(LiasseFiscale liasse) {
		
		return liasseFiscaleRepo.save(liasse);
	}

	@Override
	public List<LiasseFiscale> getAllLiasse() {
		
		return liasseFiscaleRepo.findAll();
	}

	@Override
	public LiasseFiscale getLiasse(Long id) {
		
		return liasseFiscaleRepo.findById(id).orElse(null);
	}

	@Override
	public List<Document> addLiasseToDocs(Long idLiasse, List<Long> idDocs) {
		List<Document>documents=docRepo.findAllById(idDocs);
		LiasseFiscale liasse=liasseFiscaleRepo.findById(idLiasse).orElse(null);
		for(Document doc:documents) {
			doc.setLiasseFiscale(liasse);
			docRepo.save(doc);
			
			
			
		}
		return documents;
		
	}

	@Override
	public LiasseFiscale updateLiasse(Long idLiasse, LiasseFiscale liasse) {
	  LiasseFiscale liasseExist=liasseFiscaleRepo.findById(idLiasse).orElse(null);
	  liasseExist.setExercice(liasse.getExercice());
	  liasseExist.setNature(liasse.getNature());
	  liasseExist.setTypeDepot(liasse.getTypeDepot());
		return liasseFiscaleRepo.save(liasseExist);
	}
}
