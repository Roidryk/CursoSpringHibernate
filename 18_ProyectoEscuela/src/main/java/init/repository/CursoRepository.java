package init.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import init.model.Curso;
import jakarta.transaction.Transactional;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
	
	//Metodos se van a utilizar findAll() y save() que servira para matricular
	// alumnos en el curso
	@Transactional
	@Modifying
	@Query(value="insert into matriculas values (?,?)",nativeQuery = true)
    void matricular (int codCurso, String dni);

}
