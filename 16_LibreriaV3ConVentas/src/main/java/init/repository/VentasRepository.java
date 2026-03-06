package init.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import init.model.Venta;
import java.util.List;
import java.time.LocalDateTime;


public interface VentasRepository extends JpaRepository<Venta, Integer> {
	
	//Devuelve la lista de ventas asociada a un rango de fechas
	
	List<Venta> findByBetween(LocalDateTime f1,LocalDateTime f2);

	
	//Devuelva la lista de ventas asociadas a un determinado cliente
	List<Venta> findByClienteId(int idCliente);
}
