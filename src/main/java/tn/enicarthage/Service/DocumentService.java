package tn.enicarthage.Service;

import java.util.List;

import tn.enicarthage.Model.Document;
import tn.enicarthage.Model.LiasseFiscale;


public interface DocumentService {

	public Document createDoc(Document document);
	
	
	public List<Document>getAllDocs();
	
	//add doc to a categorie
	
	public Document addDocToCat(Long idDoc,Long idCat);
	
	//add doc to liasse
	public String addDocToLiasse(Long idDoc,Long idLiasse);
	
	//add detail doc to doc
	public Document addDetailToDoc(Long idDoc,Long idDetailDoc);
	
	//get list document by id liasse
	
	public List<Document>getDocsByIdLiasse(Long idLiasse);
	
	//get doc by id
	public Document getDoc(Long idDoc);
	
	
	

}
