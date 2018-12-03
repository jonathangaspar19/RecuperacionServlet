package es.salesianos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Director {
	private Integer codDirector;
	public Integer getCodDirector() {
		return codDirector;
	}

	public void setCodDirector(Integer codDirector) {
		this.codDirector = codDirector;
	}


	private String name;
	private String surname;
	
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}


	private List<Pelicula> peliculas = new ArrayList<Pelicula>();
	
	public void setMascotas(List<Pelicula> peliculas) {
		this.peliculas=peliculas;
	}
	
	public List<Pelicula> getMascotas() {
		return peliculas;
	}
	
	
	public void addToListPelicula(Pelicula pelicula) {
		peliculas.add(pelicula);
	}

	public void setName(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}
	
	

	
	
	

}
