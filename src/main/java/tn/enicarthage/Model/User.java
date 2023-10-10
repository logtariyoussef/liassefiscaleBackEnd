package tn.enicarthage.Model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
property  = "matriculeFiscale",scope = User.class)
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
  private String matriculeFiscale;

  private String nom;
	
  private String prénom;
	
  private String email;
	
  private String raisonSocial;
	
  private String Adresse;
  
  private String motdePasse;
	
	@OneToMany(mappedBy = "user")
	private List<Tracabilité>tracabilites;
  
  
}
