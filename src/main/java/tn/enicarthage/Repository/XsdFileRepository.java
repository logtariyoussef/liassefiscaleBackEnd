package tn.enicarthage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import tn.enicarthage.Model.XsdFile;

public interface XsdFileRepository extends JpaRepository<XsdFile,Long>  {
  
	public XsdFile findXsdByNomFichierXsd(String nomFichier);
}
