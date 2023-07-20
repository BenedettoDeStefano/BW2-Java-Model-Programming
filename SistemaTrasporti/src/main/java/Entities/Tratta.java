package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Tratta")
@Getter
@Setter
@NoArgsConstructor
public class Tratta {

	@Id
	@GeneratedValue
	private Long id;

	private String zonaPartenza;
	private String capolinea;

	@OneToMany(mappedBy = "tratta")
	private List<TrattePercorse> trattePercorse;

	public Tratta(String zonaPartenza, String capolinea) {
		this.zonaPartenza = zonaPartenza;
		this.capolinea = capolinea;
		this.trattePercorse = new ArrayList<>();
	}

	public void addTrattePercorse(TrattePercorse trattePercorse) {
		this.trattePercorse.add(trattePercorse);
	}

	@Override
	public String toString() {
		return "Tratta [zonaPartenza=" + zonaPartenza + ", capolinea=" + capolinea + " ]\n";
	}

	
}