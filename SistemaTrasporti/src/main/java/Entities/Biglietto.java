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
	Long id;
	@Enumerated(EnumType.STRING)
	TipoBiglietto tipoBiglietto;
	Boolean vidimato;
	@ManyToOne
	DistributoreAutomatico distributore;
	@ManyToOne
	@JoinColumn(name = "rivenditore_id")
	RivenditoreAutorizzato rivenditore;
	
	@ManyToOne
	   @JoinColumn(name = "utente_id")
	   private Utente utente;

	public Biglietto(String codiceUnivoco, LocalDate dataEmissione, Double prezzo, TipoBiglietto tipoBiglietto,
			Boolean vidimato, DistributoreAutomatico distributore, RivenditoreAutorizzato rivenditore, Utente utente) {
		super(codiceUnivoco, dataEmissione, prezzo);
		this.tipoBiglietto = tipoBiglietto;
		this.vidimato = vidimato;
		this.distributore = distributore;
		this.rivenditore = rivenditore;
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "Biglietto [tipoBiglietto=" + tipoBiglietto + ", vidimato=" + vidimato + ", distributore=" + distributore
				+ ", rivenditore=" + rivenditore + ", id=" + id + ", codiceUnivoco=" + codiceUnivoco
				+ ", dataEmissione=" + dataEmissione + ", prezzo=" + prezzo + "]";
	}

}