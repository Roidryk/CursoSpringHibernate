package init.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="libros")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int isbn;
	private String titulo;
	private String autor;
	private int paginas;
	private double precio;
	
	
	@ManyToOne()
	@JoinColumn(name = "idTema", referencedColumnName="idTema")
	private Tema temaRelacionado;
	public Libro(String titulo, String autor, double precio) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}
	public Libro() {
		super();
	}
	public Libro(int isbn, String titulo, String autor, int paginas, double precio) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
		this.precio = precio;
	}
	
	
	
	
	
	
}
