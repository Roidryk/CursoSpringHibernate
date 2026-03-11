package init.model;

public class Ficha {
	
	private String nombre;
    private String email;
    private int edad;
    
    
	public Ficha(String nombre, String emial, int edad) {
		super();
		this.nombre = nombre;
		this.email = emial;
		this.edad = edad;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String emial) {
		this.email = emial;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
    
    
    

}
