package init.service;

import java.util.List;

import init.model.Libro;
import init.model.idTema;

public interface LibroService {
    List<idTema> temas();
	
	List<Libro> librosTema(int idTema);
}
