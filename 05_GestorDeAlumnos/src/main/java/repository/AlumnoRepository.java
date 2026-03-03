package repository;

import java.util.List;

import model.Alumnos;


public interface AlumnoRepository {

	List<Alumnos> findByCurso(String curso);	
	void añadir (Alumnos alumno);
	Alumnos findByNombreAndCurso(String nombre, String cruso);
	List<String> findAllCursos();
	void removeById(int idAlumno);
	
}
