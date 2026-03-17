package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import init.dtos.ProductosDto;
import init.service.ProductoService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ProductosController {
	
	@Autowired
	ProductoService serv;
	
	@GetMapping("tienda/productos")
	public ResponseEntity<List<ProductosDto>> getProductos() {
		if(serv.listarProductos() == null ) {
			return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
		}
		return ResponseEntity.ok(serv.listarProductos());
	}
	
	
	@GetMapping("tienda/{codigoProducto}")
	public ResponseEntity<ProductosDto> getCursos(@PathVariable int codigoProducto) {
		if(serv.buscarPorCodigo(codigoProducto) == null) {
			return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
		}
		return ResponseEntity.ok(serv.buscarPorCodigo(codigoProducto));
	}
	
	@PostMapping("tienda")
	public ResponseEntity<ProductosDto> altaProducto(@RequestBody ProductosDto producto) {
		if(serv.altaProducto(producto)==null) {
			return ResponseEntity.status(HttpStatusCode.valueOf(409)).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PostMapping("actualizar")
	public ResponseEntity<ProductosDto> actualizarStock(@RequestParam int codigo, int unidades) {
		
		
		
		if(serv.actualizarStock(codigo, unidades) == null) {
			return ResponseEntity.status(HttpStatusCode.valueOf(409)).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	}

