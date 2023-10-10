package tn.enicarthage.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.Model.LiasseFiscale;
import tn.enicarthage.Model.Tracabilité;
import tn.enicarthage.Model.User;
import tn.enicarthage.Repository.LiasseFiscaleRepository;
import tn.enicarthage.Repository.TracabiliteRepository;
import tn.enicarthage.Repository.UserRepository;

@Service
public class TracabiliteServiceImpl implements TracabiliteService {

	@Autowired
	private TracabiliteRepository tracabiliteRepo;
	@Autowired
	private LiasseFiscaleRepository liasseRepo;
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public Tracabilité saveTracabilite(Tracabilité trac) {
		
		return tracabiliteRepo.save(trac);
	}
	@Override
	public Tracabilité addUserAndLiasseToTrac(String matricule, Long idTrac, Long idLiasse) {
		Tracabilité trac=tracabiliteRepo.findById(idTrac).orElse(null);
		LiasseFiscale liasse=liasseRepo.findById(idLiasse).orElse(null);
		
		User userExist=userRepo.findById(matricule).orElse(null);
		trac.setLiassefiscale(liasse);
		trac.setUser(userExist);
		return tracabiliteRepo.save(trac);
	}
	@Override
	public Tracabilité updateTracabilite(Long id, Tracabilité trac) {
		Tracabilité existTrac=tracabiliteRepo.findById(id).orElse(null);
		//existTrac.setLiassefiscale(trac.getLiassefiscale());
		existTrac.setNatureDepot(trac.getNatureDepot());
		existTrac.setDateDepot(trac.getDateDepot());
		//existTrac.setUser(trac.getUser());
		//existTrac.setLiassefiscale(trac.getLiassefiscale());
		return tracabiliteRepo.save(existTrac);
	}
	@Override
	public Tracabilité getTracabiliteById(Long id) {
		
		return tracabiliteRepo.findById(id).orElse(null);
	}
	@Override
	public List<Tracabilité> getListByUserMat(String matricule) {
		
		return tracabiliteRepo.findByUserMatriculeFiscale(matricule);
	}

}
