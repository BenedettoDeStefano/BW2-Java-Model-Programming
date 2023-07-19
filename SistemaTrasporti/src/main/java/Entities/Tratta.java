package Entities;

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
@ToString
public class Tratta {

	@Id
	@GeneratedValue
	private Long id;

	private String zonaPartenza;
	private String capolinea;

	@OneToMany(mappedBy = "tratta")
	private List<TrattePercorse> trattePercorse;

	public Tratta(String zonaPartenza, String capolinea) {
		super();
		this.zonaPartenza = zonaPartenza;
		this.capolinea = capolinea;
	}

}
