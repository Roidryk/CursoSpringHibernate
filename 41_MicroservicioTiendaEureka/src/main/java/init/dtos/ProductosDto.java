package init.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductosDto {
	private int codigoProducto;
	private String produto;
	private double precioUnitario;
	private int stock; 
}
