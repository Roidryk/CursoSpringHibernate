package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Alumnos;
import service.AlumnoService;

@Controller
public class AlumnosController {
	@Autowired
	AlumnoService alumnoService;

	@GetMapping("consulta")
	public String consulta(Model model) {
		model.addAttribute("cursos", alumnoService.cursos());
		return "consulta";

	}

	@PostMapping("alta")
	public String addItem(Model model, @RequestParam("nombre") String nombre, @RequestParam("email") String email,
			@RequestParam("nota") int nota, @RequestParam("curso") String curso) {

		Alumnos alumno = new Alumnos(nombre, curso, email, nota);

		if (alumnoService.nuevoAlumno(alumno)) {
			model.addAttribute("mensaje", "Alumno añadido correctamente");

		} else {
			model.addAttribute("mensaje", "Alumno no añadido correctamente");
		}
		return "mensaje";
	}

	@GetMapping("alumnos")
	public String verAlumnos(Model model, @RequestParam("curso") String curso) {

		model.addAttribute("alumnos", alumnoService.buscarPorCurso(curso));
		return "consulta";

	}

	@GetMapping("nuevo")
	public String nuevo(Model model) {

		model.addAttribute("cursos", alumnoService.cursos());
		return "nuevo";

	}


	@GetMapping({ "/", "goMenu" })
	public String menu() {
		return "menu";

	}

}
