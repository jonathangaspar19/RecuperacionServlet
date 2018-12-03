package es.salesianos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Actor {
	private Actor codActor;
	


	public Actor getCodActor() {
		return codActor;
	}

	public void setCodActor(Actor codActor) {
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


	private List<Pelicula> mascotas = new ArrayList<Pelicula>();
	
	public void setMascotas(List<Pelicula> mascotas) {
		this.mascotas=mascotas;
	}
	
	public List<Pelicula> getMascotas() {
		return mascotas;
	}
	
	
	public void addToListPet(Pelicula pet) {
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
