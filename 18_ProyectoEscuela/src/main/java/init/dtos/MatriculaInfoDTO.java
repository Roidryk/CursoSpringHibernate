package init.dtos;

import java.util.List;

import init.model.Alumno;
import init.model.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MatriculaInfoDTO {
	
	//Juntar los datos del alumno y curso en un dto para acceder a ellos 
	
	private AlumnoDTO alumno;
	private CursoDTO curso;

}
