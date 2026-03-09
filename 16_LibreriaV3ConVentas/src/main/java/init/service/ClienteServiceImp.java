package init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dto.ClienteDTO;
import init.mapas.Mapeador;
import init.model.Cliente;
import init.repository.ClienteRepository;
@Service
public class ClienteServiceImp implements ClienteService{

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired 
	Mapeador mapeador;
	
	public boolean guardar(ClienteDTO cliente) {
	if (clienteRepository.findFirstByUsuarioAndContraseña(cliente.getUsuario(), cliente.getPassword())== null) {
		clienteRepository.save(cliente);
		return true;
	}
		return false;
	}



	@Override
	public ClienteDTO verificar(String usuario, String contraseña) {
		
		return mapeador.clienteEntityToDto(findFirstByUsuarioAndContraseña(usuario, contraseña));
	}



	@Override
	public List<String> temas() {
		
		return clienteRepository.findAllTemas();	
				
	}



	@Override
	public List<Cliente> clienteTemas(String temas) {
		
		return clienteRepository.findByTemas(temas);
	}



	@Override
	public boolean guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}


	
}
