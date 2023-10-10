package tn.enicarthage.Model;

import java.io.Serializable;

import org.springframework.http.MediaType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
property  = "id",scope = DétailDoc.class)
public class DétailDoc implements Serializable {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nomFichier;
	
	@Column(nullable = false)
	private String typeFichier;
	
	@Lob
	@Column(nullable = false)
	private byte[] contentDoc;
	
	@OneToOne(mappedBy = "detailDoc")
	//@JsonBackReference
	@JsonIgnore
	private Document document;
	
	@ManyToOne
	//@JsonBackReference
	private XsdFile xsdFile;
	
	/*public DétailDoc(String nomF,byte[] data) {
		nomFichier=nomF;
		contentDoc=data;
	}*/
}
