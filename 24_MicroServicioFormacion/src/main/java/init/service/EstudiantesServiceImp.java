package init.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClient;

import init.dtos.EstudianteDTO;
import init.mapper.Mapeador;
import init.model.Alumno;

public class EstudiantesServiceImp implements EstudiantesService {
	
	@Autowired
	RestClient restClient;
	
	@Autowired
	Mapeador mapeador;
	
	
	private String urlBase="http//localhost:8005/escuela/";

	@Override
	public List<EstudianteDTO> estudiantesRangoNota(double min, double max) {
					
		return Arrays.stream(restClient.get().uri(urlBase+"alumnos").retrieve().body(Alumno[].class)).map(a->mapeador.alumnoToEstudiante(a)).toList();
	}

	@Override
	public boolean altaEstudiante(EstudianteDTO estudiante) {
		// TODO Auto-generated method stub
		return false;
	}

}
