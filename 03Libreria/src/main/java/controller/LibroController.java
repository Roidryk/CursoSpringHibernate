package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.libro;
import service.LibroService;

@Controller
public class LibroController {

@Autowired
LibroService LibroSer;
@PostMapping("añadir")
public String añadir(Model model,
		@RequestParam("propiedades") String propiedades,
				@RequestParam("isbn") String isbn,
		@RequestParam("titulo") String titulo,
				@RequestParam ("autor") String autor,
				@RequestParam ("precio") String precio) {
	
	libro Libro = new libro (propiedades,isbn,titulo,autor,precio);
	
	if(LibroSer.nuevoLibro(Libro)) {
		model.addAttribute("mensaje" , "Libro añadido correctamente");
	}else {
		model.addAttribute("mensaje" , "Libro no añadido correctamente");
	}
	
	return "mensaje";
	
}

@GetMapping("eliminar")
public String eliminar(Model model, @RequestParam("isbn") String isbn) {
	
	if(LibroSer.eliminarLibro(isbn)) {
		model.addAttribute("mensaje","Libro eliminado");
	}else {
		model.addAttribute("mensaje", "isbn no existente");
	}
	
	/*libro Libro = new libro(isbn);
	
	if(!(Libro.equals(null))) {
		
		LibroSer.eliminarLibro(isbn);
		return isbn + "Ha sido eliminado ";
	}*/
	
	return "mensaje";
	
}

@GetMapping("buscarLibro")
public String buscarLibro(Model model, @RequestParam("isbn") String isbn) {
	
	model.addAttribute("Libro",LibroSer.buscarPorIsbn(isbn));
	
	 //libro Libro = new libro(isbn);
	
	libro Libro = LibroSer.buscarPorIsbn(isbn);
	
	//if(!(Libro.equals(null))) { 
		
		if(Libro != null) {
		
		model.addAttribute("libro",Libro);
		 
		
		
		return  "datos";
	}else {
		model.addAttribute("mensaje", "isbn no existe");
		return "mensaje";
	}
	
	//return " datos";
	
}



@GetMapping("goNuevo")
public String goNuevo() {
	return "goNuevo";
}

@GetMapping("goBuscar")
public String goBuscar() {
	return "goBuscar";
}

@GetMapping("goEliminar")
public String gOEliminar() {
	return "goBuscar";
}

	
}
