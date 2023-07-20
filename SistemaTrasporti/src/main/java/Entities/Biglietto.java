package Entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import Enum.TipoBiglietto;
import Enum.TipoMezzo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Biglietto extends DocumentoViaggio {
	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	TipoBiglietto tipoBiglietto;
	private Boolean vidimato;
	@ManyToOne
	private DistributoreAutomatico distributore;
	@ManyToOne
	@JoinColumn(name = "rivenditore_id")
	private RivenditoreAutorizzato rivenditore;

	@ManyToOne
	@JoinColumn(name = "utente_id")
	private Utente utente;

	@ManyToOne
	@JoinColumn(name = "mezzo_id")
	private Mezzo mezzo;

	@Enumerated(EnumType.STRING)
	private TipoMezzo tipomezzo;

	public Biglietto(String codiceUnivoco, LocalDate dataEmissione, Double prezzo, TipoBiglietto tipoBiglietto,
			Boolean vidimato, DistributoreAutomatico distributore, RivenditoreAutorizzato rivenditore, Utente utente,
			Mezzo mezzo, TipoMezzo tipoMezzo) {
		super(codiceUnivoco, dataEmissione, prezzo);
		this.tipoBiglietto = tipoBiglietto;
		this.vidimato = vidimato;
		this.distributore = distributore;
		this.rivenditore = rivenditore;
		this.utente = utente;
		this.mezzo = mezzo;
		this.tipomezzo = tipoMezzo;
	}

	public Biglietto(String codiceUnivoco, LocalDate dataEmissione, Double prezzo, TipoBiglietto tipoBiglietto,
			DistributoreAutomatico distributore, TipoMezzo tipomezzo) {
		super(codiceUnivoco, dataEmissione, prezzo);
		this.tipoBiglietto = tipoBiglietto;
		this.distributore = distributore;
		this.tipomezzo = tipomezzo;
	}

	public Biglietto(String codiceUnivoco, LocalDate dataEmissione, Double prezzo, TipoBiglietto tipoBiglietto,
			RivenditoreAutorizzato rivenditore, TipoMezzo tipomezzo) {
		super(codiceUnivoco, dataEmissione, prezzo);
		this.tipoBiglietto = tipoBiglietto;
		this.rivenditore = rivenditore;
		this.tipomezzo = tipomezzo;
	}

	@Override
	public String toString() {
		return "Biglietto [tipoBiglietto=" + tipoBiglietto + ", vidimato=" + vidimato + ", distributore=" + distributore
				+ ", rivenditore=" + rivenditore + ", utente=" + utente + ", mezzo=" + mezzo + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}