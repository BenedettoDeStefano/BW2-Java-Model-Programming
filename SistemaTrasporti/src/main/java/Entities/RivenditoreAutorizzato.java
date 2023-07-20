package Entities;

import javax.persistence.Column;

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
public class RivenditoreAutorizzato {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "nome_rivenditore")
	private String nome;
	
	private String indirizzo;
	
	public RivenditoreAutorizzato(String nome ,String indirizzo) {
		this.nome = nome;
		this.indirizzo = indirizzo;
	}
	
	
}
