package init.service;

import java.util.List;

import init.dtos.AlumnoDTO;
import init.dtos.CursoDTO;
import init.dtos.MatriculaInfoDTO;

public interface EscuelaService {

	List< CursoDTO> cursos ();
	List<MatriculaInfoDTO> obtenerMatriculas(int codCurso);
	boolean matricular(int codCurso, String dni);
	
}
