package init.mappers;

import org.springframework.stereotype.Component;

import init.dtos.PedidosDto;
import init.model.Pedido;

@Component
public class Mapeador {
	
	public PedidosDto pedidoEntityToDto(Pedido pedido) {
		return new PedidosDto(pedido.getIdPedido(),pedido.getCodigoProducto(),pedido.getUnidades(),pedido.getFechaPedido());
	}
	
	public Pedido pedidoDtoToEntity(PedidosDto dto) {
		return new Pedido(dto.getIdPedido(),dto.getCodigoProducto(),dto.getUnidades(),dto.getFechaPedido());
	}
}
