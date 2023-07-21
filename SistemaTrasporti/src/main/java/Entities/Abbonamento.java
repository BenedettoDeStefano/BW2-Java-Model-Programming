package Entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import Enum.TipoAbbonamento;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Abbonamento extends DocumentoViaggio {
	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	private TipoAbbonamento tipo;
	private LocalDate dataScadenza;
	private Boolean vidimato;
	@ManyToOne
	@JoinColumn(name = "tessera_id")
	private Tessera tessera;
	@ManyToOne
	@JoinColumn(name = "rivenditore_id")
	private RivenditoreAutorizzato rivenditore;

	public Abbonamento(String codiceUnivoco, LocalDate dataEmissione, Double prezzo, TipoAbbonamento tipo,
			LocalDate dataScadenza, Boolean vidimato, Tessera tessera, RivenditoreAutorizzato rivenditore) {
		super(codiceUnivoco, dataEmissione, prezzo);
		this.tipo = tipo;
		this.dataScadenza = dataScadenza;
		this.vidimato = vidimato;
		this.tessera = tessera;
		this.rivenditore = rivenditore;
	}

	@Override
	public String toString() {
		return "\n Abbonamento [id=" + id + ", tipo=" + tipo + ", dataScadenza=" + dataScadenza + ", vidimato="
				+ vidimato + ", tessera=" + tessera + "] \n";
	}

}