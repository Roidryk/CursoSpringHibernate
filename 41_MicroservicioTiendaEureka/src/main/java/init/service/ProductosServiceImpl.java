package init.service;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import init.dtos.ProductosDto;
import init.mappers.Mapeador;
import init.model.Productos;
import init.repository.ProductoRepository;
@Service
@Transactional
public class ProductosServiceImpl implements ProductoService {
	
	@Autowired
	RestClient restClient;
	@Autowired
	private ProductoRepository repo;

	@Autowired
	private Mapeador mapper;

	
	@Value("${remote.url}")
	private String urlBase;
	@Value("${remote.user}")
	private String user;
	@Value("${remote.password}")
	private String pass;

	
	    
	   
	    @Override
	    public List<ProductosDto> listarProductos() {
	        //List<Productos> productos = repo.findAll();
	        
	        return repo.findAll().stream()
	                .map(mapper::entityProductoToDto)
	                .toList();
	    }

	    
	    @Override
	    public ProductosDto buscarPorCodigo(int codigo) {
	        repo.findByCodigoProducto(codigo);

	        if ( repo.findByCodigoProducto(codigo) == null) {
	            return null;
	        }

	        return mapper.entityProductoToDto(repo.findByCodigoProducto(codigo));
	    }

	    
	    @Override
	    public ProductosDto altaProducto(ProductosDto dto) {

	        if (repo.existsByCodigoProducto(dto.getCodigoProducto())) {
	            return null;
	        }

	        Productos prod = mapper.dtoProductoToEntity(dto);
	        Productos guardado = repo.save(prod);

	        return mapper.entityProductoToDto(guardado);
	    }

	   
	    public ProductosDto actualizarStock(int codigo, int unidades) {

	        int filas = repo.actulizarStock(unidades, codigo);

	        if (filas == 0) {
	            //throw new RuntimeException("No hay stock suficiente o el producto no existe");
	        	
	        	return null;
	        }

	        Productos actualizado = repo.findByCodigoProducto(codigo);

	        return mapper.entityProductoToDto(actualizado);
	    }
	    

	private String getBase64() {
		String texto=user+":"+pass;
		return Base64.getEncoder().encodeToString(texto.getBytes());
	}
}
