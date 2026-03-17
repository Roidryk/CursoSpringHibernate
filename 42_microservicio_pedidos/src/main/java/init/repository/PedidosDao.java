package init.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.model.Pedido;

public interface PedidosDao extends JpaRepository<Pedido, Integer> {
	
	/*no es necesario. Se puede utilizar el save
	@Query("update Producto p set p.stock=p.stock-?2 where p.codigoProducto=?1")
	public void updateStock(int codigoProd, int unidades);
	*/
	
}
