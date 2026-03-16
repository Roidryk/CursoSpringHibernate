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

import init.dtos.EstudianteDto;
import init.dtos.TokenDto;
import init.mappers.Mapeador;
import init.model.Alumno;
@Service
public class EstudiantesSrviceImpl implements EstudiantesService,InitializingBean {
	
	@Autowired
	RestClient restClient;
	@Autowired
	Mapeador mapeador;
	@Value("${remote.url}")
	private String urlBase;
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
		return Arrays.stream(restClient.get()
				.uri(urlBase+"alumnos")
				.header("Authorization", "Bearer "+tokenRecibido.getAccess_token())
				.retrieve()
				.body(Alumno[].class))  //Stream<Alumno>
				.map(a->mapeador.alumnoToEstudiante(a))//Stream<EstudianteDto>
				.filter(e->e.getCalificacion()>=min&&e.getCalificacion()<=max)
				.toList();
	}

	@Override
	public boolean altaEstudiante(EstudianteDto estudiante) {
		try {
			restClient.post()
			.uri(urlBase+"alumnos")
			.header("Authorization", "Bearer "+tokenRecibido.getAccess_token())
			.contentType(MediaType.APPLICATION_JSON)
			.body(mapeador.estudianteToAlumno(estudiante))
			.retrieve()
			.toBodilessEntity();
			return true;
		}catch(HttpClientErrorException ex) {
			if(ex.getStatusCode()==HttpStatus.CONFLICT) {
				return false;
			}
			throw ex;
		}
	}

	
	//Se ejecuta tras la creación del objeto EstudiatesService, una vez que las propiedades
	//han sido establecidas
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
		
		try {
			tokenRecibido=restClient.post()
			.uri(urlOauth2)
			.contentType(MediaType.APPLICATION_FORM_URLENCODED)
			.body(params)
			.retrieve()
			.body(TokenDto.class);
			System.out.println("Token recibido: "+tokenRecibido.getAccess_token());
		}catch(HttpClientErrorException ex) {
			throw ex;
		}
	}
}
