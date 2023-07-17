package Entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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
