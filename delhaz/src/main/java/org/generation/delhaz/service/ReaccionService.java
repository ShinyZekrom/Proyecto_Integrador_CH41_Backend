package org.generation.delhaz.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.generation.delhaz.model.Reaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaccionService {
    public final ArrayList<Reaccion> listaReacciones = new ArrayList<Reaccion>();

    @Autowired
    public ReaccionService() {
        listaReacciones.add(new Reaccion(1, 1, 1,LocalDateTime.now()));
        listaReacciones.add(new Reaccion(2, 2, 1,LocalDateTime.now()));
        
    }

    public ArrayList<Reaccion> getAllReactions() {
        return listaReacciones;
    }//getAllReactions

    public Reaccion getReaction(int id) {
        Reaccion tmpReaccion = null;
        for (Reaccion reaccion : listaReacciones) {
            if (reaccion.getId() == id) {
                tmpReaccion = reaccion;
                break;
            }
        }
        return tmpReaccion;
    }//getReaction

    public Reaccion deleteReaction(int id) {
        Reaccion tmpReaccion = null;
        for (Reaccion reaccion : listaReacciones) {
            if (reaccion.getId() == id) {
                tmpReaccion = listaReacciones.remove(listaReacciones.indexOf(reaccion));
                break;
            }
        }
        return tmpReaccion;
    }//deleteReaction

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


}//class ReaccionService