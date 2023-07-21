package Entities;

import java.time.LocalDate;

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
public class Officina {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private LocalDate dataInizioManutenzione;
	private LocalDate dataFineManutenzione;
	
	public Officina(LocalDate dataInizioManutenzione, LocalDate dataFineManutenzione) {
		super();
		this.dataInizioManutenzione = dataInizioManutenzione;
		this.dataFineManutenzione = dataFineManutenzione;
	}

	@Override
	public String toString() {
		return " \n Officina [id=" + id + ", dataInizioManutenzione=" + dataInizioManutenzione + ", dataFineManutenzione="
				+ dataFineManutenzione + "] \n";
	}
	
	
}
