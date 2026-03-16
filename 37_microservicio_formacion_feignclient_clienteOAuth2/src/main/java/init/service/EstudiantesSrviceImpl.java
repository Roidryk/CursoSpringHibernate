package init.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import feign.FeignException;
import init.clients.AlumnosFeign;
import init.clients.OAuth2Feign;
import init.dtos.TokenDto;
import init.dtos.EstudianteDto;
import init.mappers.Mapeador;
import init.model.Alumno;
@Service
public class EstudiantesSrviceImpl implements EstudiantesService,InitializingBean {
	
	@Autowired
	RestClient restClient;
	@Autowired
	Mapeador mapeador;
	
	@Autowired
	OAuth2Feign oauth2feign;
	
	@Autowired
	AlumnosFeign alumnosFeign;

	@Value("${remote.user}")
	private String user;
	@Value("${remote.password}")
	private String pass;
	@Value("${oauth2.url}")
	private String urlOauth2;
	@Value("${oauth2.clientId}")
	private String clientId;
	@Value("${oauth2.grantType}")
	private String grantType;
	
	private TokenDto tokenRecibido;
	@Override
	public List<EstudianteDto> estudiantesRangoCalificaciones(double min, double max) {
		return alumnosFeign.alumnos("Bearer "+tokenRecibido.getAccess_token()).stream()
				.map(a->mapeador.alumnoToEstudiante(a))//Stream<EstudianteDto>
				.filter(e->e.getCalificacion()>=min&&e.getCalificacion()<=max)
				.toList();
	}

	@Override
	public boolean altaEstudiante(EstudianteDto estudiante) {	
		try {
			alumnosFeign.nuevoAlumno(mapeador.estudianteToAlumno(estudiante),"Bearer "+tokenRecibido.getAccess_token());
			return true;
		}catch(FeignException ex) {
			if(ex.status()==409) {
				return false;
			}
			throw ex;
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		cargarToken();
		
	}
	private void cargarToken() {
		
		MultiValueMap<String, String> params=new LinkedMultiValueMap<>();
		params.add("testclient", clientId);
		params.add("user1", user);
		params.add("password", pass);
		params.add("grant_type", grantType);
		
		tokenRecibido= oauth2feign.autenticar(params);
		
		
		
	}

}
