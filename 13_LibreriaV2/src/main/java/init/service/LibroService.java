package init.service;

import java.util.List;

import init.model.Libro;
import init.model.idTema;

public interface LibroService {
    List<idTema> temas();
	
	List<Libro> librosTema(int idTema);
	
	Libro buscarLibroPorIsbn(int isbn);
	
	
	
	List<Libro> añadido(int isbn);
	List<Libro> eliminarLibro(int isbn);
}
