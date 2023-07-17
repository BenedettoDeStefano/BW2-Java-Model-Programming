package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import Enum.StatoMezzo;
import Enum.TipoMezzo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Tratta")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Tratta {
	
	@Id
	@GeneratedValue
	Long id;
	
	String zonaPartenza;
	String capolinea;
	int tempoMediaPercorrenza;
	int numeroVoltePercorso;
	int tempoEffettivoPercorrenza;
	
	public Tratta(String zonaPartenza, String capolinea, int tempoMediaPercorrenza, int numeroVoltePercorso,
			int tempoEffettivoPercorrenza) {
		this.zonaPartenza = zonaPartenza;
		this.capolinea = capolinea;
		this.tempoMediaPercorrenza = tempoMediaPercorrenza;
		this.numeroVoltePercorso = numeroVoltePercorso;
		this.tempoEffettivoPercorrenza = tempoEffettivoPercorrenza;
	}
	
	
	
}
