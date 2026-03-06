package init.dto;

import init.model.Tema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LibroDTO {
	private int isbn;
	private String titulo;
	private String autor;
	private int paginas;
	private double precio;
	private Tema temaRelacionado;
	//no incluimos un TemaDto porque no necesitamos idTema en esta aplicacion
	private String nombreTema;
	public LibroDTO(int isbn, String titulo, String autor, int paginas, double precio, Tema temaRelacionado) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
		this.precio = precio;
		this.temaRelacionado = temaRelacionado;
	}
	
	
	
}
