package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;
import es.salesianos.model.Peliculas;
import es.salesianos.model.assembler.PetAssembler;
import es.salesianos.repository.Repository;
import es.salesianos.utils.DateConverter;

public class PetService {

	private Repository repository = new Repository();
	private DateConverter converter = new DateConverter();
	
	
	public Peliculas assemblePetFromRequest(HttpServletRequest req) {
		return PetAssembler.assemblePetFrom(req);
	}
	
	public void addPet(Peliculas pet) {
		repository.insertPet(pet);
		
	}
}
