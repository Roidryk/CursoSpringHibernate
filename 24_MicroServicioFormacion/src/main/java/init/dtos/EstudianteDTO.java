package init.dtos;

import init.model.Alumno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstudianteDTO {
	
	private String nombre;
	private String curso;
	private String email;
	private int nota;

}
