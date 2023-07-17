package Entities;

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

public class Utente {
	@Id
	@GeneratedValue
	private Long id;
	private String Nome;
	private String Cognome;
	private Tessera Tessera;
	
	public Utente(String _nome, String _cognome, Tessera _tessera) {
		this.Nome = _nome;
		this.Cognome = _cognome;
		this.Tessera = _tessera;
	}
	
	@OneToOne
	private Tessera tessera;

}