package init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dtos.ItemDTO;
import init.mapper.mapeador;
import init.model.Item;
import init.repository.ItemsRepository;

@Service
public class ItemServiceImp implements ItemService{

	@Autowired
	ItemsRepository itemsRepository;
	
	@Autowired
	mapeador Mapeador;
	
	@Override
	public List<ItemDTO> buscarPorTematica(String tematica) {
		return itemsRepository.findByTematica(tematica).stream().map(i->Mapeador.itemDtoToEntity(i)).toList();
	}
	@Override
	public boolean nuevoItem(Item item) {
		if(itemsRepository.findFirstByUrl(item.getUrl())==null) {
			itemsRepository.save(item);
			return true;
		}
		return false;
	}
	@Override
	public boolean guardar(ItemDTO item) {
		
		if(itemsRepository.findFirstByUrl(item.getUrl())==null) {
			
			itemsRepository.save(item);
			return true;
		}
		
		
		return false;
	}
	@Override
	public ItemDTO eliminarItem(String url) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
