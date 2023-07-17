package Entities;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class DocumentoViaggio {
	@Id
	@GeneratedValue
	Long id;
	String codiceUnivoco;
	LocalDate dataEmissione;
	Double prezzo;

	public DocumentoViaggio(String codiceUnivoco, LocalDate dataEmissione, Double prezzo) {
		super();
		this.codiceUnivoco = codiceUnivoco;
		this.dataEmissione = dataEmissione;
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "DocumentoViaggio [id=" + id + ", codiceUnivoco=" + codiceUnivoco + ", dataEmissione=" + dataEmissione
				+ ", prezzo=" + prezzo + "]";
	}
}
