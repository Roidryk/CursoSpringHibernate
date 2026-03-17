package init.service.interfaces;

import java.util.List;

import init.dtos.PedidosDto;

public interface PedidoService {
	List<PedidosDto> pedidos();
	
	boolean nuevoProducto(PedidosDto pedido);}
