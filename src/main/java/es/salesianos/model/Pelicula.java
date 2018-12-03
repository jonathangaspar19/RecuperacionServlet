package es.salesianos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pelicula {
	private Integer codPelicula;
	
	

	
	public Integer getCodPelicula() {
		return codPelicula;
	}

	public void setCodPelicula(Integer codPelicula) {
		this.codPelicula = codPelicula;
	}


	private String nombrePelicula;


	public String getNombrePelicula() {
		return nombrePelicula;
	}

	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}


	private List<Pelicula> peliculas = new ArrayList<Pelicula>();
	
	
	
	


}
