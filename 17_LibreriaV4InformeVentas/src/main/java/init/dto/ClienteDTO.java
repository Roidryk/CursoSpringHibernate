package init.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ClienteDTO {
private int idCliente;
	 private   String usuario;
	  private  String password;
	  private  String email;
	  private  String telefono;
	
}
