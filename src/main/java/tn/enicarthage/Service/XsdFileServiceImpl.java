package tn.enicarthage.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.enicarthage.Model.Document;
import tn.enicarthage.Model.DétailDoc;
import tn.enicarthage.Model.XsdFile;
import tn.enicarthage.Repository.DocumentRepository;
import tn.enicarthage.Repository.DétailDocRepository;
import tn.enicarthage.Repository.XsdFileRepository;

@Service
public class XsdFileServiceImpl implements XsdFileService {
    
	@Autowired
	private XsdFileRepository XsdRepo;
	
	@Autowired
	private DocumentRepository docRepo;
	
	@Autowired
	private DétailDocRepository detailDocRepo;
	
	@Override
	public XsdFile saveXsdFile(MultipartFile file) throws IOException {
		XsdFile xsdFile=new XsdFile();
		xsdFile.setNomFichierXsd(file.getOriginalFilename());
		xsdFile.setXsdType(file.getContentType());
		xsdFile.setXsdContent(file.getBytes());
		
		return XsdRepo.save(xsdFile);
		
	}
	@Override
	public XsdFile findXsdFileByNom(Long idDoc) {
		Document docExist=docRepo.findById(idDoc).orElse(null);
		String nom=docExist.getCode()+".xsd";
		return XsdRepo.findXsdByNomFichierXsd(nom);
	}
	@Override
	public DétailDoc addXsdToDetailDoc(Long idDoc) {
		Document docExist=docRepo.findById(idDoc).orElse(null);
		DétailDoc detailDoc=docExist.getDetailDoc();
		String nom=docExist.getCode()+".xsd";
		XsdFile xsdfile=XsdRepo.findXsdByNomFichierXsd(nom);
		detailDoc.setXsdFile(xsdfile);
		
		return detailDocRepo.save(detailDoc);
	}

}
