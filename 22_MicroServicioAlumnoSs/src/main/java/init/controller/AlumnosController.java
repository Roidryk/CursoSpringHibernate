package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import init.dtos.AlumnoDTO;
import init.service.AlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AlumnosController{
	@Autowired
	AlumnosService serv;
	
	
	@GetMapping(value="alumnos",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AlumnoDTO>> alumnos(){
		return new ResponseEntity<>(serv.alumnos(),HttpStatus.OK);
	}
	
	
	@GetMapping(value="alumnos/{curso}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AlumnoDTO>> buscarPorCurso(@PathVariable String curso){
		return new ResponseEntity<>(serv.alumnosCurso(curso),HttpStatus.OK);
	}
	
	@PostMapping(value="alumno",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> alta(@RequestBody AlumnoDTO alumno) {
		if(serv.guardar(alumno)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@DeleteMapping(value="alumnos",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AlumnoDTO> eliminarPorEmail(@RequestParam String email) {
		return ResponseEntity.ok(serv.eliminar(email));
	}

}
