package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class DistributoreAutomatico {
	@Id
	@GeneratedValue
   Long id;
   String posizione;
   Boolean attivo;
public DistributoreAutomatico(String posizione, Boolean attivo) {
	super();
	this.posizione = posizione;
	this.attivo = attivo;
}
   
  
}
