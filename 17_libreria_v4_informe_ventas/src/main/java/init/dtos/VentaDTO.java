package init.dtos;

import java.time.LocalDateTime;

import init.model.Cliente;
import init.model.Libro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VentaDTO {

	
	private ClienteDto cliente;
	private LibroDto libro;
	private LocalDateTime fecha;
	
}
