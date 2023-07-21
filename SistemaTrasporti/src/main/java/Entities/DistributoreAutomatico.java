package Entities;

import java.util.UUID;

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
public class DistributoreAutomatico {
	
	@Id
	@GeneratedValue
	private Long id;
	private String posizione;
	private Boolean attivo;
	
public DistributoreAutomatico(String posizione, Boolean attivo) {
	super();
	this.posizione = posizione;
	this.attivo = attivo;
}

@Override
public String toString() {
	return "DistributoreAutomatico [id=" + id + ", posizione=" + posizione + ", attivo=" + attivo + "]";
}
   


  
}
