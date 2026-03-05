package init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import init.model.Libro;
import init.model.idTema;
import init.repository.LibrosRepository;
import init.repository.TemasRepository;

public class LibroServiceImp {

	@Autowired
	TemasRepository temasRepository;
	@Autowired
	LibrosRepository librosRepository;
	public List<idTema> temas() {
		return temasRepository.findAll();
	}
	public List<Libro> librosTema(int idTema) {
		if(idTema==0) {
			return librosRepository.findAll();
		}
		return librosRepository.findByIdTema(idTema);
	}
}
