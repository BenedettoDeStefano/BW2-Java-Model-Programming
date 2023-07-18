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
public class trattePercorse {

	@Id
	@GeneratedValue
	private Long codiceTratta;

	private Long codiceMezzo;
	private Long codiceStorico;
	private Long tempoEffettivo;

	@ManyToOne
	@JoinColumn(name = "codice_mezzo")
	private Mezzo mezzo;

	@ManyToOne
	@JoinColumn(name = "codice_tratta")
	private Tratta tratta;

	public trattePercorse(Long codiceMezzo, Long codiceStorico, Long tempoEffettivo) {
		super();
		this.codiceMezzo = codiceMezzo;
		this.codiceStorico = codiceStorico;
		this.tempoEffettivo = tempoEffettivo;
	}

}
