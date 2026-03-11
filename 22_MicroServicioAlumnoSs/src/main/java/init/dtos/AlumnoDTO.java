package init.dtos;

import init.model.Alumno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlumnoDTO {

	private int idAlumno;
	private String nombre;
	private String curso;
	private String email;
	private double nota;
	
	
	public AlumnoDTO(String nombre, String curso, String email, double nota) {
		super();
		this.nombre = nombre;
		this.curso = curso;
		this.email = email;
		this.nota = nota;
	}
	
	
	
}
