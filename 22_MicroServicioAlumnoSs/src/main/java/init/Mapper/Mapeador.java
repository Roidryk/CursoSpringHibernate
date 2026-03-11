package init.Mapper;

import org.springframework.stereotype.Component;

import init.dtos.AlumnoDTO;
import init.model.Alumno;

@Component
public class Mapeador {
	
	public AlumnoDTO alumnoEntityToDto(Alumno alumno) {
		return new AlumnoDTO(alumno.getNombre(),alumno.getCurso(),alumno.getEmail(),alumno.getNota());
	}
	
	public Alumno alumnoDtoToEntity(AlumnoDTO dto) {
		return new Alumno(dto.getNombre(),dto.getCurso(),dto.getEmail(),dto.getNota());
	}

}
