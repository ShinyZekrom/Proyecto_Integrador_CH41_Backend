package org.generation.delhaz.service;

import org.generation.delhaz.model.Reaccion;
import org.generation.delhaz.model.ReaccionRequest;
import org.generation.delhaz.repository.ReaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReaccionService {	
    private final List<ReaccionRequest> lista = new ArrayList<>();
    private final List<Reacccion> reacciones = new ArrayList<>();
    @Autowired
    public ReaccionService() {
    	reacciones.add(new Reaccion("Me encanta"));
        reacciones.add(new Reaccion("Me inspira"));
        reacciones.add(new Reaccion("Me divierte"));
        reacciones.add(new Reaccion("Me interesa"));
        reacciones.add(new Reaccion("Me entristece"));
    }//constructor
    
	public List<ReaccionRequest> getAllReacciones() {		
		return listaReacciones;
	}//

	public ReaccionRequest getReaccionRequest(int id) {
		for(ReaccionRequest reaccion : listaReacciones) {
			if(reaccion.getId()==id) {
				return reaccion;
			}//if
		}//foreach
		return null;
	}//getReaccion

	public Reaccion deleteReaccion(int id) {
		ReaccionRequest reaccionToRemove = null;
		for(ReaccionRequest reaccion : listaReacciones) {
			if (reaccion.getId() == id) {
				reaccionToRemove = reaccion;
				break;
			}
		}//if
		if (reaccionToRemove != null) {
			listaReacciones.remove(reaccionToRemove);
		}
		return reaccionToRemove;
	}//deleteReaccion

	public Reaccion addReaccion(ReaccionRequest reaccionRequest) {
		for(ReaccionRequest reaccion : listaReacciones) {
			if (reaccion.getUsuarioId().equals(reaccionRequest.getUsuarioId())) {
				return null;
			}
		}//if ! existe
		listaReacciones.add(reaccionRequest);
		return reaccioneRequest;
		
	}//addReaccion

<<<<<<< HEAD
	
}//classReaccionService
=======
    public Reaccion addReaction(Reaccion reaccion) {
    	Reaccion tmpReaction=null;
		boolean existe=false;
		if(! existe) {
			listaReacciones.add(reaccion);
			tmpReaction=reaccion;
		}// if ! existe
		return tmpReaction;
    }//addReactiontype

    public Reaccion updateReaction(int id, int tipoReaccionId) {
        Reaccion tmpReaccion = null;
        return tmpReaccion;
    }//updateReaction
>>>>>>> d732f6ecc410adce5acedfa14a1623be0102be85





	