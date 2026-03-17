package init.mappers;

import org.springframework.stereotype.Component;

import init.dtos.ProductosDto;
import init.model.Productos;

@Component
public class Mapeador {
	
	public ProductosDto entityProductoToDto(Productos prod) {
		return new ProductosDto(prod.getCodigoProducto(),prod.getProduto(),prod.getPrecioUnitario(),prod.getStock());
	}
	
	public Productos dtoProductoToEntity(ProductosDto dto) {
		return new Productos(dto.getCodigoProducto(),dto.getProduto(),dto.getPrecioUnitario(),dto.getStock());
	}

	
}


