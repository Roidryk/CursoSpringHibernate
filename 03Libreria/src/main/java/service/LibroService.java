package service;

import model.libro;

public interface LibroService {

	boolean nuevoLibro(libro Libro);
	libro buscarPorIsbn(String isbn);
	boolean eliminarLibro(String isbn);
	
	
}
