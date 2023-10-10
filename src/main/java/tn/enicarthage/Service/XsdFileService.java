package tn.enicarthage.Service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import tn.enicarthage.Model.DétailDoc;
import tn.enicarthage.Model.XsdFile;

public interface XsdFileService {
	public XsdFile saveXsdFile(MultipartFile file) throws IOException;
	
	public XsdFile findXsdFileByNom(Long idDoc);
	
	public DétailDoc addXsdToDetailDoc(Long idDoc);
}
