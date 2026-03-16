package init.service;

import java.util.List;

import init.dtos.EstudianteDTO;

public interface EstudiantesService {
	
	List<EstudianteDTO> estudiantesRangoNota(double min, double max);
	
	boolean altaEstudiante(EstudianteDTO estudiante);

}
