package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TrattePercorse {

	@Id
	@GeneratedValue
	private Long codiceTratta;

	private Long codiceStorico;
	private int tempoEffettivo;

	@ManyToOne
	@JoinColumn(name = "codice_mezzo")
	private Mezzo mezzo;

	@ManyToOne
	@JoinColumn(name = "codice_tratta")
	private Tratta tratta;

	public TrattePercorse(Long codiceStorico, int tempoEffettivo, Mezzo mezzo, Tratta tratta) {
		this.codiceStorico = codiceStorico;
		this.tempoEffettivo = tempoEffettivo;
		this.mezzo = mezzo;
		this.tratta = tratta;
	}

}
