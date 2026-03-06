package init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.model.Libro;

public interface LibrosRepository extends JpaRepository<Libro, Integer> {

	List<Libro> findByIdTema(int idTema);
	
	
	
	//lista de libros por el nombre de la tematica
	@Query("select l from libro l where l.temaRelacionado.tema = ?1")
	List <Libro> findByNombreTema(String tema);
	
}
