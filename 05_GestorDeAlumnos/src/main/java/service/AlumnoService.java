package service;

import java.util.List;

import model.Alumnos;

public interface AlumnoService {

	List<Alumnos> buscarPorCurso(String curso);
	boolean nuevoAlumno(Alumnos alumno);
	List<String>cursos();
	
}
