package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import init.dtos.PedidosDto;
import init.service.interfaces.PedidoService;
@CrossOrigin("*")
@RestController
public class ProductosController {
	@Autowired
	PedidoService pedidosService;
	@GetMapping(value="pedidos", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PedidosDto>> productos(){
		return new ResponseEntity<>(pedidosService.pedidos(),HttpStatus.OK);
	}
	
	@PostMapping("pedidos")
	public ResponseEntity<Void> altaEstudiante(@RequestBody PedidosDto pedidos){
		if(pedidosService.nuevoProducto(pedidos)) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
}





