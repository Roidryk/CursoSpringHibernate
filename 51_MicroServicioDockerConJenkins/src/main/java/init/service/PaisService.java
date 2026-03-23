package init.service;

import java.util.List;

import init.dtos.PaisDTO;
import init.model.Pais;

public interface PaisService {
	
	List<String> todosContinentes();
	List<Pais> paisesPorContinente(String continente); 

}
