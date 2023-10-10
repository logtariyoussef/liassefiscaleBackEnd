package tn.enicarthage.Model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
property  = "id",scope = LiasseFiscale.class)
public class LiasseFiscale implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
	
  private Long exercice;
 
  private String nature;
 
  private String typeDepot;
  
  @OneToMany(mappedBy = "liasseFiscale",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}) 
  
  private List<Document>documents;
  
  @OneToMany(mappedBy = "liassefiscale",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
 @JsonIgnore
  private List<Tracabilité>traciblites;
  
  
  
  
}
