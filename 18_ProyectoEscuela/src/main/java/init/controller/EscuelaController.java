package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;
import init.dtos.AlumnoDTO;
import init.model.Alumno;
import init.service.EscuelaService;
import jakarta.servlet.http.HttpSession;

@Controller
public class EscuelaController {
	
	@Autowired
	EscuelaService escuelaService;
	
	
	@GetMapping("/")
	public String init (Model model) {
		
		model.addAttribute("curso", escuelaService.cursos());
		
				return "matricula";
		
		

}
	@GetMapping("matricula")
	public String verMatriculas(Model model, @RequestParam int codCurso) {
		
		model.addAttribute("matricula", escuelaService.obtenerMatriculas(codCurso));
		model.addAttribute("cursos", escuelaService.cursos());
		return "matricula";
		
	}
	
}
