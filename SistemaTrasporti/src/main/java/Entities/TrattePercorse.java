package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TrattePercorse {

	@Id
	@GeneratedValue
	private Long Id;

	private Long codiceStorico;
	private Long tempoEffettivo;

	@ManyToOne
	@JoinColumn(name = "codice_mezzo")
	private Mezzo mezzo;

	@ManyToOne
	@JoinColumn(name = "codice_tratta")
	private Tratta tratta;

	public TrattePercorse(Long codiceStorico, Long tempoEffettivo, Mezzo mezzo, Tratta tratta) {
		this.codiceStorico = codiceStorico;
		this.tempoEffettivo = tempoEffettivo;
		this.mezzo = mezzo;
		this.tratta = tratta;
	}

	@Override
	public String toString() {
		return "TrattePercorse [codiceStorico=" + codiceStorico + ", tempoEffettivo=" + tempoEffettivo + ", mezzo="
				+ mezzo + ", tratta=" + tratta + "]";
	}
}
