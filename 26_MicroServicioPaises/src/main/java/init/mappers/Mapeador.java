package init.mappers;

import org.springframework.stereotype.Component;

import init.dtos.PaisDTO;
import init.model.Pais;

@Component
public class Mapeador {

	public PaisDTO paisToDto(Pais pais) {
		return new PaisDTO(pais.getNombre(),pais.getContinente(),pais.getHabitantes(),pais.getCapital(),pais.getBandera());
		
		
	}
	
	public Pais dtoToPais(PaisDTO dto) {
		
		return new Pais(dto.getNombre(),dto.getContinente(),dto.getHabitantes(),dto.getCapital(),dto.getBandera());
	}
	
}
