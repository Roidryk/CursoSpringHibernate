package init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.clients.PaisFeign;
import init.dtos.PaisDTO;
import init.mappers.Mapeador;
import init.model.Pais;
@Service
public class PaisServiceImp implements PaisService {

	@Autowired
	Mapeador mapeador;
	
	@Autowired
	PaisFeign feign;
	
	@Override
	public List<String> todosContinentes() {
		
		return feign.continentes().stream().map(p->p.getContinente()).distinct().toList();
	}

	@Override
	public List<Pais> paisesPorContinente(String continente) {
		
		
		return feign.continentes().stream().map(c->mapeador.dtoToPais(c)).filter(p->p.getContinente().equals(continente)).toList();
	}

}
