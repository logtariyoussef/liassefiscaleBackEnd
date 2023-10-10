package tn.enicarthage.Service;

import java.util.List;

import tn.enicarthage.Model.Tracabilité;

public interface TracabiliteService {
   public Tracabilité saveTracabilite(Tracabilité trac);
   
   public Tracabilité addUserAndLiasseToTrac(String matricule,Long idTrac,Long idLiasse);
   
   public Tracabilité updateTracabilite(Long id,Tracabilité trac);
   
   public Tracabilité getTracabiliteById(Long id);
   
   public List<Tracabilité>getListByUserMat(String matricule);
}
