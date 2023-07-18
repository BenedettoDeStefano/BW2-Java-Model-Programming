package Entities;

import java.sql.Date;

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
	
	private Date dataScadenza;
	@Id
	@GeneratedValue 
	private int numeroTessera;
	
	
	public Tessera(Date _dataScadenza, int _numeroTessera) {
		super();
		this.dataScadenza = _dataScadenza;
	}
	
	@OneToOne(mappedBy = "tessera")
	private Utente utente;
}
