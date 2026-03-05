package init.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="libros")
public class Libro {
	@Id
	private int isbn;
	private String titulo;
	private String autor;
	private int paginas;
	private double precio;
	private int idTema;
	public Libro(String titulo, String autor, double precio) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}
	public Libro() {
		super();
	}
	
	
	
}
