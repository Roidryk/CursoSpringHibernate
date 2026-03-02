package model;

public class libro {
	private String propiedades;
	private String isbn;
	private String titulo;
	private String autor;
	private String precio;
	public libro(String propiedades, String isbn, String titulo, String autor, String precio) {
		super();
		this.propiedades = propiedades;
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}
	
	
	
	public libro(String isbn) {
		super();
		this.isbn = isbn;
	}



	public libro() {
		
	}



	public String getPropiedades() {
		return propiedades;
	}
	public void setPropiedades(String propiedades) {
		this.propiedades = propiedades;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	

}
