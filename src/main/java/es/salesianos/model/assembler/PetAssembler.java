package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Peliculas;

public class PetAssembler {
	public static Peliculas assemblePetFrom(HttpServletRequest req) {
		Peliculas pet = new Peliculas();
		String codOwner=req.getParameter("codOwner");
		String name=req.getParameter("name");
		if(null != codOwner) {
			pet.setCodOwner(Integer.parseInt(codOwner));
		}
		pet.setName(name);
		return pet;
	}
}
