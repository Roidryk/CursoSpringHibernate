package init.service;

import java.util.List;


import init.model.Cliente;

public interface ClienteService  {
	
	boolean guardar (Cliente cliente);
Cliente verificar (String usuario, String contraseña);
	List<String> temas(); 
	List<Cliente> clienteTemas(String curso);
}
