package init.service;

import java.util.List;

import init.dtos.ProductosDto;

public interface ProductoService {
	
	List<ProductosDto> listarProductos();

    ProductosDto buscarPorCodigo(int codigo);

    ProductosDto altaProducto(ProductosDto producto);

    ProductosDto actualizarStock(int codigo, int unidades);

}
