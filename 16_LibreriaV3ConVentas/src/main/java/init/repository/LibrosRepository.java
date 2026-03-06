package init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.dto.LibroDTO;
import init.model.Libro;

public interface LibrosRepository extends JpaRepository<Libro, Integer> {

	List<LibroDTO> findByIdCliente(int idCliente);
	
	
	
	//lista de libros por el nombre de la tematica
	@Query("select l from Libro l where l.temaRelacionado.tema = ?1")
	List <LibroDTO> findByNombreTema(String tema);
	
}
