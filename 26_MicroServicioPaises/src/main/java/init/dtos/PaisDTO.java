package init.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PaisDTO {

	private String nombre;
	private String continente;
	private long habitantes;
	private String capital;
	private String bandera;
	
}
