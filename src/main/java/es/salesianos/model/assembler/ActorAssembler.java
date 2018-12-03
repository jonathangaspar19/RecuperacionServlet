package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;
import es.salesianos.model.Pelicula;

public class ActorAssembler {

	public static Actor assembleActorFrom(HttpServletRequest req) {
		Actor actor = new Actor();
		String codActor=req.getParameter("codActor");
		if(null != codActor) {
			actor.setCodActor(Integer.parseInt(codActor));
		}
		String name = req.getParameter("nombrePelicula");
		String lastname = req.getParameter("surname");
		actor.setName(name);
		return actor;
	}
}