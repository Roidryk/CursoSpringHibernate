package init.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import init.dto.LibroDTO;
import init.mapas.Mapeador;
import init.model.Libro;
import init.model.Tema;
import init.repository.LibrosRepository;
import init.repository.TemasRepository;

public class LibroServiceImp implements LibroService {

	@Autowired
	TemasRepository temasRepository;
	@Autowired
	LibrosRepository librosRepository;
	
	@Autowired
	Mapeador mapeador;
	
	
	public List<Tema> temas() {
		return temasRepository.findAll();
	}
	public List<LibroDTO> librosTema(int idTema) {
		if(idTema==0) {
			return librosRepository.findAll()	)
		}
		return librosRepository.findByIdTema(idTema);
	}
	@Override
	public Libro buscarLibroPorIsbn(int isbn) {
		
		 return librosRepository.findById(isbn).orElse(null);
		
		
	}
	
	@Override
	public List<Libro> añadido(int isbn) {
		
		
		
		List<Libro> librosAñadidos = new ArrayList();
		
		
		
		for(Libro lib : librosAñadidos) {
			
			if(lib.getIsbn()!= isbn) {
				
				librosAñadidos.add(lib);
				
			}
			
		}
		
		
		return  null;
	}
	@Override
	public List<Libro> eliminarLibro(int isbn) {
		
		List<Libro> librosAñadidos = new ArrayList();
		
for(Libro lib : librosAñadidos) {
			
	librosAñadidos.remove(isbn);
		
}
		return null;
	}
	
	
	
	}

