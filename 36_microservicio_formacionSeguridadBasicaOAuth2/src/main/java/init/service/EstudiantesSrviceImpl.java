package init.service;

import java.util.Arrays;
import java.util.Base64;
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

import init.dtos.TokenDTO;
import init.dtos.EstudianteDto;
import init.mappers.Mapeador;
import init.model.Alumno;
@Service
public class EstudiantesSrviceImpl implements EstudiantesService, InitializingBean {
	
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
	
	@Value("${oauth2.ur}")
	private String urlOauth2;
	
	@Value("${oauth2.clientId}")
	private String clientId;
	
	@Value("${oauth2.grantType}")
	private String grantType;
	
	
	
	private TokenDTO tokenRecibido;
	

	@Override
	public List<EstudianteDto> estudiantesRangoCalificaciones(double min, double max) {
		return Arrays.stream(restClient.get()
				.uri(urlBase+"alumnos")
				.header("Authorization", "Bearer "+tokenRecibido)

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
			.header("Authorization", "Bearer "+tokenRecibido.getAccessToken())

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
	
	
	private String getBase64() {
		
		String texto = user+":"+pass;
		return Base64.getEncoder().encodeToString(texto.getBytes());
		
		
	}

	//Se ejecuta tras la cracion del service una vez que las propiedades han sido establecidas
	
	@Override
	public void afterPropertiesSet() throws Exception {
		cargarToken();
		
	}
	
	
	private void cargarToken() {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		
		params.add("client_id", clientId);	
		params.add("username", user);
		params.add("password", pass);
		params.add("grant_type", grantType);
		
					try {
						tokenRecibido=restClient.post()
						.uri(urlOauth2)
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.body(params)
						.retrieve()
						.body(TokenDTO.class);
						
						System.out.println("Token recibido: "+tokenRecibido.getAccessToken());

					}catch(HttpClientErrorException ex) {
						throw ex;
					}

		
		
		
		
	}

}
