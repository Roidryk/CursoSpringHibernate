package init.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import init.dtos.CredentialDTO;
import init.model.Alumno;
@FeignClient(name="alumnosFeign",url = "${remote.url}")
public interface AlumnosFeign {
	@GetMapping("alumnos")
	List<Alumno> alumnos(@RequestHeader(name = "Authorization") String aut );
	@PostMapping("alumnos")
	void nuevoAlumno(@RequestBody Alumno alumno, @RequestHeader(name="Authorization") String auth);
	@GetMapping("login")
	String autenticar (@RequestBody CredentialDTO credential);
}
