package es.salesianos.service;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Actor;
import es.salesianos.model.assembler.ActorAssembler;
import es.salesianos.repository.Repository;
import es.salesianos.utils.DateConverter;

public class ActorService {
	
	
	private Repository repository = new Repository();
	private DateConverter converter = new DateConverter();
	private static final Logger LOGGER = LogManager.getLogger(ActorService.class);
	
	
	public Actor assembleOwnerFromRequest(HttpServletRequest req) {
		return ActorAssembler.assembleOwnerFrom(req);
	}
	
	//pasar los datos
	public void addActor(Actor actor) {
		repository.insert(actor);
	}

	public void insertOrUpdate(Actor ownerFormulario) {
		Actor userInDatabase = repository.search(ownerFormulario);
		if(null == userInDatabase){
			repository.insert(ownerFormulario);
		}else{
			repository.update(ownerFormulario);
		}
	}
	
	public void deleteOwner(Integer codOwner) {
		repository.delete(codOwner);
	}
	
	public Actor search(Integer codOwner) {
		return repository.searchByCodOwner(codOwner);
		
	}

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
	public List<Actor> listAllActores() {
		LOGGER.info("ESTAS EN EL ListService");
		return repository.searchAll();
	}
	
	
	

}
