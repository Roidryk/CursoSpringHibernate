package init.mapper;

import org.springframework.stereotype.Component;

import init.dtos.ItemDTO;
import init.model.Item;

@Component
public class mapeador {

	public ItemDTO itemEntityToDto(Item item) {
		
		return new ItemDTO(item.getUrl(),item.getTematica(),item.getDescripcion());
		
	}
	
	public Item itemDtoToEntity(ItemDTO dto) {
		
		return new Item(dto.getUrl(),dto.getTematica(),dto.getDescripcion());
	}
	
}
