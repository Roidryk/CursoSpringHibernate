package init.service;

import java.util.List;

import init.dto.LibroDTO;

public interface VentasService {

public void nuevaVenta(int idCliente, List<LibroDTO> libros);
}
