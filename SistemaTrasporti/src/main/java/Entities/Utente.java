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
	private int id;
	private String Nome;
	private String Cognome;
	
	@OneToOne
	private Tessera tessera;
	
	@OneToMany(mappedBy = "utente")
	   private List<Biglietto> biglietti;
	
	
	
	public Utente(String nome, String cognome, Tessera tessera) {
		this.Nome = nome;
		this.Cognome = cognome;
		this.tessera = tessera;
	}
	

}