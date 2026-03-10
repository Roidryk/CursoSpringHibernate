package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import init.dtos.ItemDTO;
import init.repository.ItemsRepository;
import init.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	ItemsRepository itemRepository;
	
	@Autowired
	ItemService itemService;

	@Autowired
	ItemService itemsService;
	@GetMapping(value="items/{tematica}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ItemDTO> buscarPorTematica(@PathVariable String tematica){
		return itemService.buscarPorTematica(tematica);
	}
	@PostMapping(value="items",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void alta(@RequestBody ItemDTO item) {
		itemService.nuevoItem(item);
	}
	@DeleteMapping(value="items",produces=MediaType.APPLICATION_JSON_VALUE)
	public ItemDTO eliminarPorUrl(@RequestParam String url) {
		return itemsService.eliminarItem(url);
	}

		
	

}
