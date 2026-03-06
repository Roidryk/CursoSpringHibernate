package init.mapas;

import org.springframework.stereotype.Component;

import init.dto.ClienteDTO;
import init.dto.LibroDTO;
import init.dto.TemaDTO;
import init.model.Cliente;
import init.model.Libro;
import init.model.Tema;

@Component
public class Mapeador {
	
	public Cliente ClienteDtoToEntity(ClienteDTO dto) {
		
		return new Cliente(dto.getUsuario(),dto.getEmail(),dto.getPassword(),dto.getTelefono());
		
	}
	
	public ClienteDTO clienteEntityToDto(Cliente cliente) {
		
		return new ClienteDTO(cliente.getIdCliente(),cliente.getUsuario(),cliente.getEmail(),cliente.getUsuario(),cliente.getTelefono());
		
	}
	
	
	public Tema temaDtoToEntity(TemaDTO dto) {
		
		return new Tema(dto.getIdTema(),dto.getTema());
		
	}

public TemaDTO temaEntityToDto(Tema tema) {
	
	return new TemaDTO(tema.getIdTema(),tema.getTema());
	
}

//solo tiene sentido si se van a enviar objetos libro del exterior hacia la aplicacion
public Libro LibroDtoToEntity(LibroDTO dto) {
	
	
	 
	return new Libro(dto.getIsbn(),dto.getAutor(),dto.getTitulo(),dto.getPaginas(),dto.getPrecio(),dto.getTemaRelacionado(),dto.getTemaDto());
}


public LibroDTO libroEntityToDto(Libro libro) {
	
	return new LibroDTO(libro.getIsbn(),libro.getAutor(),libro.getTitulo(),libro.getPaginas(),libro.getPrecio(),libro.getTemaRelacionado());
}

	

}
