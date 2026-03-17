package init.service.implementations;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import init.dtos.PedidosDto;
import init.mappers.Mapeador;
import init.model.Pedido;
import init.repository.PedidosDao;
import init.service.interfaces.PedidoService;
@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	RestClient restClient;
	@Value("${remote.url}")
	private String urlBase;
	@Value("${remote.user}")
	private String user;
	@Value("${remote.password}")
	private String pass;
	
	@Autowired
	PedidosDao pedidosDao;
	@Autowired
	Mapeador mapeador;
	@Override
	public List<PedidosDto> pedidos() {
		return Arrays.stream(restClient.get()
				.uri(urlBase+"prductos")
				.header("Authorization", "Basic" + getBase64())
				.retrieve()
				.body(Pedido[].class))
				.map(p->mapeador.pedidoEntityToDto(p)).toList();
				
	}
	@Override
	public boolean nuevoProducto(PedidosDto pedido) {
		
		try {
			
			restClient.post()
			.uri(urlBase+"productos/{codigo}")
			.header("Authorization","Basic"+ getBase64())
			.contentType(MediaType.APPLICATION_JSON)
			.body(mapeador.pedidoDtoToEntity(pedido))
			.retrieve()
			.toBodilessEntity();
		return true;
			
			
		} catch (HttpClientErrorException ex) {
			
		
			if(ex.getStatusCode()==HttpStatus.CONFLICT) {
				return false;
			}
			throw ex;
		
		}
	}

	
	/*
	 * public boolean nuevoProducto(ProductoDto producto) {
		Optional<Producto> prodOp=productosDao.findById(producto.getCodigoProducto());
		if(prodOp.isEmpty()) {
			productosDao.save(mapeador.productoDtoToEntity(producto));
			return true;
		}
		return false;
	}
	 */

	
	private String getBase64() {
		String texto=user+":"+pass;
		return Base64.getEncoder().encodeToString(texto.getBytes());
	}
	
	

}
