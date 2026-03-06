package init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.dto.ClienteDTO;
import init.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
@Query("select c from CLientes where c.usuario = ?1 and c.password =?1")	
	ClienteDTO findFirstByUsuarioAndContraseña(String usuario, String contraseña);

boolean existByUsuario(String url);

List<String> findAllTemas();
List<ClienteDTO> findByTemas(String tema);


	
}
