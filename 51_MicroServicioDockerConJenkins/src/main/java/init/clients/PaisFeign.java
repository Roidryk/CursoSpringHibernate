package init.clients;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import init.dtos.PaisDTO;
import init.model.Pais;
@FeignClient(name="paisFeign", url= "${remote.url}")
public interface PaisFeign {
	
		
	@GetMapping()
	List<PaisDTO> continentes();


}
