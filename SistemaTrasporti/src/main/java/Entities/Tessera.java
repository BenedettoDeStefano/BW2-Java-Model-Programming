package Entities;

import java.sql.Date;
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
@ToString
public class Tessera {
	
	private LocalDate dataScadenza;
	
	@Id
	@GeneratedValue 
	private int numeroTessera;
	
	
	public Tessera(LocalDate _dataScadenza) {
		this.dataScadenza = _dataScadenza;
	}
	
	@OneToOne(mappedBy = "tessera")
	private Utente utente;
}
