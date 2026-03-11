package init.service;

import java.util.List;

import init.dtos.ItemDTO;
import init.model.Item;

public interface ItemService {
	
	List<ItemDTO> buscarPorTematica(String tematica);
	boolean nuevoItem(Item item);
	boolean guardar(ItemDTO item);
	ItemDTO eliminarItem(String url);

}
