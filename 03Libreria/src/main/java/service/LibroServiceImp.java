package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import model.libro;

@Service
public class LibroServiceImp implements LibroService{

	static List<libro> todosLibros=new ArrayList<libro>();
		

		public boolean nuevoLibro(libro Libro) {
			
			for(libro lib : todosLibros) {
			if(lib.getIsbn().equals(Libro.getIsbn())) {
				
				return false;
				
			}
			
		}
			todosLibros.add(Libro);
			return true;
			
		
		}

		public libro buscarPorIsbn(String isbn) {
			
			return todosLibros.stream()
					.filter(l->l.getIsbn().equals(isbn))
					.findFirst()
					.orElse(null);
			
			
		}

		public boolean eliminarLibro(String isbn) {
			
			if(buscarPorIsbn(isbn) == null) {
				return false;
			}
			
			/*ibro lib=buscarPorIsbn(isbn);
			libros.remove(lib);*/
			todosLibros.removeIf(l->l.getIsbn().equals(isbn));
			return true;
			
			
		}
	
	
}
