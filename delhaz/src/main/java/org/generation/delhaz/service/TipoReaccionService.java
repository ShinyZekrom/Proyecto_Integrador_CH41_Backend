package org.generation.delhaz.service;

import java.util.ArrayList;

import org.generation.delhaz.model.TipoReaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoReaccionService {
    public final ArrayList<TipoReaccion> listaReacciones = new ArrayList<TipoReaccion>();

    @Autowired
    public TipoReaccionService() {
        listaReacciones.add(new TipoReaccion("Me encanta", "/path/to/love_icon.svg"));
        
        listaReacciones.add(new TipoReaccion("Me inspira", "/path/to/inspire_icon.svg"));
        listaReacciones.add(new TipoReaccion("Me divierte", "/path/to/laugh_icon.svg"));
        listaReacciones.add(new TipoReaccion("Me interesa", "/path/to/interest_icon.svg"));
        listaReacciones.add(new TipoReaccion("Me entristece", "/path/to/sad_icon.svg"));
    }//constructor

    public ArrayList<TipoReaccion> getAllReactionstype() {
        return listaReacciones;
    }//getAllReactiontypes

    public TipoReaccion getReactiontype(int id) {
		TipoReaccion tmpReaction=null;
		for (TipoReaccion tipoReaccion : listaReacciones) {
			if(tipoReaccion.getId()==id) {
				tmpReaction= tipoReaccion;
			}// if
		}// foreach
		return tmpReaction;
    }//getReacciontype

    public TipoReaccion deleteReactiontype(int id) {
    	TipoReaccion tmpReaction = null;
		for (TipoReaccion tipoReaccion : listaReacciones) {
			if(tipoReaccion.getId()==id) {
				tmpReaction= listaReacciones.remove(listaReacciones.indexOf(tipoReaccion));
				break;
			}//if
		}//for each
		return tmpReaction;
    }//deleteReaction
    
    public TipoReaccion addReactiontype(TipoReaccion tipoReaccion) {
    	TipoReaccion tmpReaction=null;
		boolean existe=false;
		for (TipoReaccion react : listaReacciones) {
			if(react.getNombre().equals(tipoReaccion.getNombre())) {
				existe = true;
				break;
			}// if
		}//foreach
		if(! existe) {
			listaReacciones.add(tipoReaccion);
			tmpReaction=tipoReaccion;
		}// if ! existe
		return tmpReaction;
    }//addReactiontype

    public TipoReaccion updateReactiontype(int id, String nombre, String icono) {
        TipoReaccion tmpReaction =null;
        for (TipoReaccion tipoReaccion : listaReacciones) {
        	if(tipoReaccion.getId() == id) {
				if (nombre != null)
					tipoReaccion.setNombre(nombre);
				if (icono != null)
					tipoReaccion.setIcono(icono);
				tmpReaction = tipoReaccion;
				break;
        	}
        }
        return tmpReaction;
    }//updateReaction

}//class TipoReaccionService