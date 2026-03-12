package init.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import init.dtos.EstudianteDTO;
import init.service.EstudiantesService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class EstudiantesController {
	
	EstudiantesService serv;
	
	@GetMapping("estudiantes")
	public ResponseEntity <List<EstudianteDTO>> estudianteCalificacion(double min, double max){
		return null;
		
		
	}
	@ApiResponses({
		
		@ApiResponse(responseCode="201", description = "El estudiante se ha añadido correactamente"),
		@ApiResponse(responseCode="409", description = "No se ha creado el estudiante")
		
	})
	@GetMapping("estudiantes")
	public ResponseEntity<Void> altaEstudiante(EstudianteDTO estudiante){
		
		if(serv.altaEstudiante(estudiante)) {
			
			return ResponseEntity.ok().build();
			
		}
		
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}

}
