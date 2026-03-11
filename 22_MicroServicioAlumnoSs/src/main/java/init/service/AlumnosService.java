package init.service;

import java.util.List;

import init.dtos.AlumnoDTO;
import init.model.Alumno;

public interface AlumnosService {

	boolean guardar(AlumnoDTO alumno);
	List<AlumnoDTO> alumnosCurso(String curso);
	List<AlumnoDTO> cursos();
	AlumnoDTO eliminar(String email);
	List<AlumnoDTO> alumnos();
	
}
