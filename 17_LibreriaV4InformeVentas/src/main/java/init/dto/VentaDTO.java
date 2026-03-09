package init.dto;

import java.time.LocalDateTime;

import init.model.Cliente;
import init.model.Libro;
import init.model.Tema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VentaDTO {

	private int idVentas;
	private Cliente cliente;
	private Libro libro;
	private LocalDateTime fecha;

	
	
}
