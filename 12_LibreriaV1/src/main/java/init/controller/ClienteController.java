package init.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import init.model.Cliente;
import init.service.ClienteService;
import init.service.LibroService;

@Controller
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	LibroService librosService;
	
	@PostMapping("alta")
	public String registrar (Model model,@ModelAttribute Cliente cliente) {
		
		if(clienteService.guardar(cliente)) {
			model.addAttribute("mensaje", "Cliente repetido!");
			return "mensaje";
		}
					
		return "login";
		
		
	}
	
	@GetMapping("login")
	public String autenticar(httpModel model,
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
	public String verLibros(Model model, @RequestParam("temas") int temas){
		
		model.addAttribute("temas", librosService.temas());
		model.addAttribute("libros",librosService.librosTema(temas));
		return "libros";
	}
	
		
		
	
}


