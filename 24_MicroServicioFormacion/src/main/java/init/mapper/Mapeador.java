package init.mapper;

import org.springframework.stereotype.Component;

import init.dtos.EstudianteDTO;
import init.model.Alumno;

@Component
public class Mapeador {
	
	public Alumno  estudianteToAlumno(EstudianteDTO dto) {
		
		return new Alumno(dto.getNombre(),dto.getCurso(),dto.getEmail(),dto.getNota());
	}
	
	
	public EstudianteDTO alumnoToEstudiante(Alumno alumno) {
		
		return new EstudianteDTO(alumno.getNombre(),alumno.getCurso(),alumno.getEmail(),alumno.getNota());
	}

}
