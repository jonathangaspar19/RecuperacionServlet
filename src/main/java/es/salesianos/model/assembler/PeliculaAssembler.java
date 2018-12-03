package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;
import es.salesianos.model.Pelicula;

public class PeliculaAssembler {

	public static Pelicula assemblePeliculaFrom(HttpServletRequest req) {
		Pelicula pelicula = new Pelicula();
		String codPelicula=req.getParameter("codPelicula");
		if(null != codPelicula) {
			pelicula.setCodPelicula(Integer.parseInt(codPelicula));
		}
		String name = req.getParameter("nombrePelicula");
		pelicula.setNombrePelicula(name);
		return pelicula;
	}
}