package Entities;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tessera {
	
	private LocalDate dataScadenza;
	
	@Id
	@GeneratedValue 
	private int id;
	
	private Long numeroTessera;
	
	public Tessera(LocalDate _dataScadenza, Long numeroTessera) {
		this.dataScadenza = _dataScadenza;
		this.numeroTessera = numeroTessera;
	}
	
	@OneToOne(mappedBy = "tessera")
	private Utente utente;
}
