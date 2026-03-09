package init.service;

import java.time.LocalDateTime;
import java.util.List;

import init.dtos.LibroDto;
import init.model.Venta;

public interface VentasService {
	public void nuevaVenta(int idCliente,List<LibroDto> libros);
	
	public List<Venta> ventasPorFechas(LocalDateTime fechaInicio, LocalDateTime fechaFinal);
 	
	public void encontrarEntreFechas(LocalDateTime fechaInicio, LocalDateTime fechaFinal);
}
