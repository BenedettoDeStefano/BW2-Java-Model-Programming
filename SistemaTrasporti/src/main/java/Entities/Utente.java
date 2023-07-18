package Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToOne
	private Tessera tessera;
	
	@OneToMany(mappedBy = "utente")
	   private List<Biglietto> biglietti;
	
	
	
	public Utente(String _nome, String _cognome, Tessera _tessera , List<Biglietto> biglietti) {
		this.Nome = _nome;
		this.Cognome = _cognome;
		this.Tessera = _tessera;
		this.biglietti = biglietti;
	}
	

}