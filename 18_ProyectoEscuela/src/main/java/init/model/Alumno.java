package init.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="alumnos")
public class Alumno {
	
	
    @Id
	private String dni;
	private String nombre;
	private String email;
	private int edad;
	
	private List<Curso> cursos;

	public Alumno(String dni, String nombre, String email, int edad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
	}
	
	
	
}
