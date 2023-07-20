package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import Enum.StatoMezzo;
import Enum.TipoMezzo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Mezzo {

	@Id
	@GeneratedValue
	private int id;
	@Enumerated(EnumType.STRING)
	private TipoMezzo tipo;
	@Enumerated(EnumType.STRING)
	private StatoMezzo stato;

	private int capienza;

	@ManyToOne
	@JoinColumn(name = "tratta_id")
	private Tratta tratta;

	@OneToMany(mappedBy = "mezzo")
	private List<TrattePercorse> trattePercorse;

	@ManyToOne
	@JoinColumn(name = "officina_id")
	private Officina officina;

	public Mezzo(TipoMezzo tipo, StatoMezzo stato, int capienza, Tratta tratta) {
		this.tipo = tipo;
		this.stato = stato;
		this.capienza = capienza;
		this.tratta = tratta;
		this.trattePercorse = new ArrayList<>();
	}

	public Mezzo(TipoMezzo tipo, StatoMezzo stato, int capienza, Tratta tratta, Officina officina) {
		this.tipo = tipo;
		this.stato = stato;
		this.capienza = capienza;
		this.tratta = tratta;
		this.officina = officina;
		this.trattePercorse = new ArrayList<>();
	}

	public List<TrattePercorse> getTrattePercorse() {
		return trattePercorse;
	}

	public void addTrattePercorse(TrattePercorse trattePercorse) {
		this.trattePercorse.add(trattePercorse);
	}
}