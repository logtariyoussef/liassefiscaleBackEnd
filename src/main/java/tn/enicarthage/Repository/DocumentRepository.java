package tn.enicarthage.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.enicarthage.Model.Document;
import tn.enicarthage.Model.LiasseFiscale;

public interface DocumentRepository extends JpaRepository<Document,Long> {
 
	List<Document>findByCategorieId(Long id);
	List<Document>findByLiasseFiscaleId(Long idLiasse);
}
