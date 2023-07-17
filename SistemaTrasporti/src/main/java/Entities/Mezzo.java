package Entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import Enum.StatoMezzo;
import Enum.TipoMezzo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Mezzo {
	
	@Id
	@GeneratedValue
	Long id;
	
	@Enumerated(EnumType.STRING)
	TipoMezzo tipo;
	
	@Enumerated(EnumType.STRING)
	StatoMezzo stato;
	
	int capienza;
	
	@ManyToOne
	@JoinColumn(name = "tratta_id")
	Tratta tratta;

	public Mezzo(TipoMezzo tipo, StatoMezzo stato, int capienza, Tratta tratta) {
		this.tipo = tipo;
		this.stato = stato;
		this.capienza = capienza;
		this.tratta = tratta;
	}
	
	
}
