package tn.enicarthage.Service;

import java.util.List;

import tn.enicarthage.Model.Catégorie;

public interface CatégorieService {

	//get list of category
	public List<Catégorie> getAllCat();
	
	//get category by id
	public Catégorie getCat(Long id);
	
	//Save categorie
	public Catégorie saveCat(Catégorie cat);
}
