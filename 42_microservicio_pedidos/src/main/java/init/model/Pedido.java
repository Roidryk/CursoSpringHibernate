package init.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="pedidos")
public class Pedido {
	@Id
	private int idPedido;
	private int codigoProducto;
	private int unidades;
	private LocalDateTime fechaPedido;
	
}
