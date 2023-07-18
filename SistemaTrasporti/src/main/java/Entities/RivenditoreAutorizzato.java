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
public class RivenditoreAutorizzato {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String indirizzo;
	
	public RivenditoreAutorizzato(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	
}
