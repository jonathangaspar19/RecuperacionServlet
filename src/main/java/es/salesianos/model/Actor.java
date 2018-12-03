package es.salesianos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Actor {
	private Integer codActor;
	public Integer getCodActor() {
		return codActor;
	}

	public void setCodActor(Integer codActor) {
		this.codActor = codActor;
	}


	private String name;
	private String surname;
	
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}


	private List<Peliculas> mascotas = new ArrayList<Peliculas>();
	
	public void setMascotas(List<Peliculas> mascotas) {
		this.mascotas=mascotas;
	}
	
	public List<Peliculas> getMascotas() {
		return mascotas;
	}
	
	
	public void addToListPet(Peliculas pet) {
		mascotas.add(pet);
	}

	public void setName(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}
	
	

	
	@Override
	public String toString() {
		return "User [codOwner="+codActor+ "name=" + name + ", surname=" + surname + "]";
	}
	

}
