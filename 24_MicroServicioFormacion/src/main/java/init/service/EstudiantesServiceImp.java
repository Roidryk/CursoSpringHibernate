package init.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import init.dtos.EstudianteDTO;
import init.mapper.Mapeador;
import init.model.Alumno;

public class EstudiantesServiceImp implements EstudiantesService {
	
	@Autowired
	RestClient restClient;
	
	@Autowired
	Mapeador mapeador;
	
	@Value("${remote.url}")
	private String urlBase;

	@Override
	public List<EstudianteDTO> estudiantesRangoNota(double min, double max) {
					
		return Arrays.stream(restClient.get().uri(urlBase+"alumnos").retrieve().body(Alumno[].class)).map(a->mapeador.alumnoToEstudiante(a)).toList();
	}

	@Override
	public boolean altaEstudiante(EstudianteDTO estudiante) {
		try {
			restClient.post()
		.uri(urlBase+"alumnos")
		.contentType(MediaType.APPLICATION_JSON)
		.body(mapeador.estudianteToAlumno(estudiante)) //Mapear el estudiante antes de enviarlo
		.retrieve()
		.toBodilessEntity();
		
		return true;
		} catch (HttpClientErrorException ex) {
		
			if(ex.getStatusCode()==HttpStatus.CONFLICT)
			
				return false;
			throw ex;	
		}
		
		
			
	
	}

}
