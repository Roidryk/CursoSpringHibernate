package init.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import init.model.Cliente;
import init.model.Libro;
import init.repository.LibrosRepository;
import init.service.ClienteService;
import init.service.LibroService;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClienteController {

    private final LibrosRepository librosRepository;

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	LibroService librosService;

    ClienteController(LibrosRepository librosRepository) {
        this.librosRepository = librosRepository;
    }
	
	@PostMapping("alta")
	public String registrar (Model model,@ModelAttribute Cliente cliente) {
		
		if(clienteService.guardar(cliente)) {
			model.addAttribute("mensaje", "Cliente repetido!");
			return "mensaje";
		}
					
		return "login";
		
		
	}
	
	@GetMapping("login")
	public String autenticar(HttpSession sesion, Model model,
			
			
			
			@RequestParam("usuario") String usuario,
			@RequestParam("password") String password) {
		
		Cliente cliente = clienteService.verificar(usuario, password);
		//Pasar todos los temas model.addAttribute("temas". libroService.temas());
		
		if(cliente != null) {
			model.addAttribute("temas", librosService.temas());
			return "libros";
	  
		}else {
			model.addAttribute("mensaje", "Cliente no existe");
			return "mensaje";
		}
			
		
	}
	
	
	@GetMapping("libros")
	public String verLibros(Model model, @RequestParam("temas") int idTema){
		model.addAttribute("IdTema",idTema);
		model.addAttribute("temas", librosService.temas());
		model.addAttribute("libros",librosService.librosTema(idTema));
		return "libros";
	}
	
	@GetMapping("añadir")
	public String carrito(HttpSession sesion, Model mode, @RequestParam("isbn") int isbn) {
		
Libro libro = librosService.buscarLibroPorIsbn(isbn);

List<Libro> librosAñadidos = (List<Libro>)sesion.getAttribute("carrito");
if(carrito != null) {
	
	librosService.añadido(isbn);
	sesion.getAttribute(libro.getTitulo());
	sesion.getAttribute(libro.getAutor());
	sesion.getAttribute(libro.getPrecio());
	
}else {
	
	List<Libro> librosAñadidos = 
	
	librosService.añadido(isbn);
	sesion.getAttribute(libro.getTitulo());
	sesion.getAttribute(libro.getAutor());
	sesion.getAttribute(libro.getPrecio());
	
}

		return "libro";
	}
		
	@GetMapping("eliminar")
	public String eliminar(HttpSession sesion,Model model) {
		
		Libro
		
		
		
		if(carrito = null) {
			
			
		}
		
		
		return null;
		
		
		
	}
		
	
}


