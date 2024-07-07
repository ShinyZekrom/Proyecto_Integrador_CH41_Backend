package org.generation.delhaz.service;

import org.generation.delhaz.model.Reaccion;
import org.generation.delhaz.model.ReaccionRequest;
import org.generation.delhaz.repository.ReaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaccionService {	
    public final ReaccionRepository reaccionRepository ;
    
    @Autowired
    public ReaccionService(ReaccionRepository reaccionRepository) {
    	this.reaccionRepository = reaccionRepository;
    }//constructor

	public List<Reaccion> getAllReacciones() {
		return reaccionRepository.findAll();
	}//getAllReacciones

	public Reaccion getReaccion(Long id) {
		return reaccionRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("La reaccion con el id [" + id + "] no existe")
			 );
	}//getReaccion

	public ReaccionRequest deleteReaccion(Long id) {
		Optional<ReaccionRequest> reaccionOptional = Optional.empty();
		
		if (reaccionOptional.isPresent()) {
			ReaccionRequest tmpReaccion = reaccionOptional.get();
			reaccionRepository.deleteById(id);
			return tmpReaccion;
		} else {
			return null;
		}
	}//deleteReaccion

	public ReaccionRequest addReaccion(ReaccionRequest reaccionRequest) {
		return reaccionRequest;
	}//addReaccion

	public Reaccion updateReaccion(Long id, String reaccion) {
       return null;		
	}//updateReaccion
	
}//classReaccionService

  






	