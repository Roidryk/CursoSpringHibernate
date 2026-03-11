package init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import init.model.Alumno;

public interface AlumnosRepository extends JpaRepository<Alumno, Integer>{
	
	Alumno findFirstByNombreAndCurso(String nombre, String curso);
@Transactional
@Modifying
	void deleteByEmail(String email);
	List<Alumno> findByCurso(String curso);
	Alumno findFirstByEmail(String email);
	boolean existsByNombreAndCurso(String nombre, String curso);
	@Query("select distinct(a.curso) from Alumno a")
	List<String> findAllCursos();
	
	List<String> findAllAlumnos();
	
	
}
