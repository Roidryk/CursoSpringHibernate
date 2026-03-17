package init.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Productos {
	private int codigoProducto;
	private String produto;
	private double precioUnitario;
	private int stock;
	public Productos(int codigoProducto, int stock) {
		
		
		super();
		this.codigoProducto = codigoProducto;
		this.stock = stock;
	} 
	
	
	
}

