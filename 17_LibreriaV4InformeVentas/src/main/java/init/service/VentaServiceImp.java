package init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import init.dto.LibroDTO;
import init.model.Cliente;
import init.repository.ClienteRepository;
import init.repository.VentasRepository;

public class VentaServiceImp implements VentasService{
 
	@Autowired
	VentasRepository ventaRepository;
	@Autowired
	ClienteRepository clienteRepository;
	
	
	@Override
	public void nuevaVenta(int idCliente, List<LibroDTO> libros) {
		
		Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
		if (cliente != null) {
			
			
			
		}
		
	}

	
	
}
