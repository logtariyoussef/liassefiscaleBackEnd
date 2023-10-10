package tn.enicarthage.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enicarthage.Model.Tracabilité;

public interface TracabiliteRepository extends JpaRepository<Tracabilité,Long>{
  
	public List<Tracabilité>findByUserMatriculeFiscale(String matricule);
}
