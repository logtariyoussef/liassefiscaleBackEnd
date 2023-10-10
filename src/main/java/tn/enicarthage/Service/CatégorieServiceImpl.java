package tn.enicarthage.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.enicarthage.Model.Catégorie;
import tn.enicarthage.Repository.CatégorieRepository;

@Service
@AllArgsConstructor
public class CatégorieServiceImpl implements CatégorieService {
	
	@Autowired
	private CatégorieRepository catRepository;

	@Override
	public List<Catégorie> getAllCat() {
		
		return catRepository.findAll();
	}

	@Override
	public Catégorie getCat(Long id) {
		
		return catRepository.findById(id).orElse(null);
	}

	@Override
	public Catégorie saveCat(Catégorie cat) {
		
		return catRepository.save(cat);
	}
  
}
