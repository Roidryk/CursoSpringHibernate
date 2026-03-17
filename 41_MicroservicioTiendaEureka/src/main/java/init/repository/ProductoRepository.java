package init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import init.model.Productos;
@Repository
public interface ProductoRepository extends JpaRepository<Productos, Integer>{
	
	List<Productos> findAll();
	Productos findByCodigoProducto(int codigo);
	boolean existsByCodigoProducto(int codigo);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE productos SET stock = stock - ?1 where codigoProducto = ?2 AND stock >= ?1", nativeQuery = true)
	int actulizarStock(int unidades,int codigo);


}
