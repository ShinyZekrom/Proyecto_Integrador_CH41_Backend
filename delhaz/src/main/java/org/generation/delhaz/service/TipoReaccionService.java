package org.generation.delhaz.service;

import java.util.List;
import java.util.Optional;

import org.generation.delhaz.model.TipoReaccion;
import org.generation.delhaz.repository.TipoReaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoReaccionService {
	public final TipoReaccionRepository tipoReaccionRepository;
	
    @Autowired
    public TipoReaccionService(TipoReaccionRepository tipoReaccionRepository) {
    	this.tipoReaccionRepository = tipoReaccionRepository;
    }//constructor

    public List<TipoReaccion> getAllReactionstype() {
        return tipoReaccionRepository.findAll();
    }//getAllReactiontypes

    public TipoReaccion getReactiontype(Long id) {
		   return tipoReaccionRepository.findById(id).orElseThrow(
				   ()-> new IllegalArgumentException("El usuario con el id ["+ 
		   id +"] no existe"));
    }//getReacciontype

    public TipoReaccion deleteReactiontype(Long id) {
    	TipoReaccion tmpReactionType = null;
		if (tipoReaccionRepository.existsById(id)) {
			tmpReactionType=tipoReaccionRepository.findById(id).get();
			tipoReaccionRepository.deleteById(id);
		}//if
		return tmpReactionType;
    }//deleteReactionType
    
    public TipoReaccion addReactiontype(TipoReaccion tipoReaccion) {
    	Optional<TipoReaccion> tmpReactionType = 
    			tipoReaccionRepository.findByNombre(tipoReaccion.getNombre());
    	if(tmpReactionType.isPresent()) {
    		return tipoReaccionRepository.save(tipoReaccion);
    	} else {
    		System.out.println("El producto con el nombre [" + 
    				tipoReaccion.getNombre() + "] ya existe");
    		return null;
    	}//else
    }//addReactiontype

    public TipoReaccion updateReactiontype(Long id, String nombre, String icono) {
        TipoReaccion tmpReactionType =null;
		if(tipoReaccionRepository.existsById(id)) {
			TipoReaccion tipoReaccion = tipoReaccionRepository.findById(id).get();
			if (nombre!=null) tipoReaccion.setNombre(nombre);
			if (icono!=null) tipoReaccion.setIcono(icono);
			tipoReaccionRepository.save(tipoReaccion);
			tmpReactionType= tipoReaccion;
		}//if
        	return tmpReactionType;
    }//updateReactionType

}//class TipoReaccionService