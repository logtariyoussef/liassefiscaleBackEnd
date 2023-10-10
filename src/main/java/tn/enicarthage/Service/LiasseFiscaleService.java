package tn.enicarthage.Service;

import java.util.List;

import tn.enicarthage.Model.Document;
import tn.enicarthage.Model.LiasseFiscale;

public interface LiasseFiscaleService {

	//create liasse
	public LiasseFiscale saveLiasse(LiasseFiscale liasse);
	
	//get all liasse
	public List<LiasseFiscale>getAllLiasse();
	
	//get liasse by id
	public LiasseFiscale getLiasse(Long id);
	
	//add liasse to docs
	public List<Document> addLiasseToDocs(Long idLiasse,List<Long> idDocs);
	//update Liasse fiscale
	public LiasseFiscale updateLiasse(Long idLiasse,LiasseFiscale liasse);
}
