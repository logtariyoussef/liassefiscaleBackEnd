package tn.enicarthage.Service;

import java.io.IOException;


import org.springframework.web.multipart.MultipartFile;

import tn.enicarthage.Model.DétailDoc;

public interface DétailDocService {
  
	public DétailDoc saveDocFile(MultipartFile file) throws IOException;
	
	//get file by id
	public DétailDoc getDocFile(Long id);
	
	//validate xml avec xsd
	public Boolean validateXml(Long id);
	
	//add xsd file to detail doc
	//public DétailDoc addXsd(Long idDoc,String nomXsdFile);
	
	
}
