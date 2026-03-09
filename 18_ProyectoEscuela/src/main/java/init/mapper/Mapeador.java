package init.mapper;

import org.springframework.stereotype.Component;

import init.dtos.AlumnoDTO;
import init.dtos.CursoDTO;
import init.model.Alumno;
import init.model.Curso;

@Component
public class Mapeador {

	public AlumnoDTO AlumnoEntityToDto(Alumno alumno ) {
		
		return new AlumnoDTO(alumno.getDni(),alumno.getNombre(),alumno.getEmail(),alumno.getEdad());
	}
	
	public Alumno alumnoDtoToEntity(AlumnoDTO dto) {
		
		return new Alumno(dto.getNombre(),dto.getDni(),dto.getEmail(),dto.getEdad());
		
		
	}
	
	public CursoDTO cursoEntityToDto(Curso curso) {
		
		return new CursoDTO(curso.getDenominacion(),curso.getCodCurso(),curso.getDuracion(),curso.getHorario());
	}
	
	public Curso cursoDtoToEntity(CursoDTO dto) {
		
		
				return new Curso(dto.getCodCurso(),dto.getNombreCurso(),dto.getDuracion(),dto.getHorario());
	}
	
}
