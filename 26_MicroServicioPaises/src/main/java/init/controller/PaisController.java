package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import init.dtos.PaisDTO;
import init.model.Pais;
import init.service.PaisService;
@CrossOrigin("*")
@RestController
public class PaisController {
	@Autowired
	PaisService serv;
	
	
	@GetMapping("paises/continentes")
	public ResponseEntity<List<String>> continentes(){
		return ResponseEntity.ok(serv.todosContinentes());
	}

	@GetMapping("paises")
	public ResponseEntity<List<Pais>> paisesPorContinentes(String continente){
		return ResponseEntity.ok(serv.paisesPorContinente(continente));
	}
	
}
