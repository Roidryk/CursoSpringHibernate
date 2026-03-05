package init.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import init.model.Cliente;
import init.service.ClienteService;


public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping("alta")
	public String registrar (Model model,@ModelAttribute Cliente cliente) {
		
		if(clienteService.guardar(cliente)) {
			model.addAttribute("mensaje", "Cliente repetido!");
		}
					
		return "login";
		
		
	}
	
	@GetMapping("login")
	public String autenticar(Model model,
			@RequestParam("usuario") String usuario,
			@RequestParam("contraseña") String contraseña) {
		
		Cliente cliente = clienteService.verificar(usuario, contraseña);
		
		
		if(cliente != null) {
		
			return "libros";
	  
		}else {
			model.addAttribute("mensaje", "Cliente no existe");
			return "mensaje";
		}
			
		
		
	}
	
	@GetMapping({"/","goLogin"})
	public String inicio() {
		return "login";
	}
	@GetMapping("goRegistro")
	public String goRegistro() {
		return "registro";
		
		//return "registro/clientes";
	}
	
	@GetMapping("temas")
	public String libros(Model model, @RequestParam("temas") String temas){
		
		model.addAttribute("temas", clienteService.temas());
		model.addAttribute("clientes", clienteService.clienteTemas(temas));
		return "libros";
	}
	
		
		
	}
	


