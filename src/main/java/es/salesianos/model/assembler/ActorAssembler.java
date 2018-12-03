package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;

public class ActorAssembler {

	public static Actor assembleOwnerFrom(HttpServletRequest req) {
		Actor owner = new Actor();
		String codOwner=req.getParameter("codOwner");
		if(null != codOwner) {
			owner.setCodActor(Integer.parseInt(codOwner));
		}
		String name = req.getParameter("name");
		String lastname = req.getParameter("surname");
		owner.setName(name);
		owner.setSurname(lastname);
		return owner;
	}
}