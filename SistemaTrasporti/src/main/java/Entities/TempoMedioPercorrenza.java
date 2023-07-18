package Entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TempoMedioPercorrenza {

	@Id
	@GeneratedValue
	private Long id;
	
	private LocalDate inizioPeriodoServizio;
	private LocalDate finePeriodoServizio;
	private double tempoMedioPercorrenza;
	private int numeroCorse;
	private double tempoEffettivoPercorrenza;
	
	@ManyToMany(mappedBy = "tempiMediPercorrenza")
	   private List<Tratta> tratte;
	
	public TempoMedioPercorrenza(LocalDate inizioPeriodoServizio, LocalDate finePeriodoServizio,
			double tempoMedioPercorrenza, int numeroCorse, double tempoEffettivoPercorrenza) {
		super();
		this.inizioPeriodoServizio = inizioPeriodoServizio;
		this.finePeriodoServizio = finePeriodoServizio;
		this.tempoMedioPercorrenza = tempoMedioPercorrenza;
		this.numeroCorse = numeroCorse;
		this.tempoEffettivoPercorrenza = tempoEffettivoPercorrenza;
	}
	
	
	
}
