package Entities;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


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
	private Long id;
	
	private String zonaPartenza;
	private String capolinea;
	
	@ManyToMany
	@JoinTable(name = "tratta_tempo",joinColumns = @JoinColumn(name = "tratta_id"),
	inverseJoinColumns = @JoinColumn(name = "tempo_id"))
	private List<TempoMedioPercorrenza> tempiMediPercorrenza;
	
	public Tratta(String zonaPartenza, String capolinea) {
		super();
		this.zonaPartenza = zonaPartenza;
		this.capolinea = capolinea;
	}
	
	
	
}
