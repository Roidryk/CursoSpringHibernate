package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="alumnos")
public class Alumnos {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
    private	int idAlumno;
    private String nombre;
    private String curso;
    private String email;
    private double nota;
	public Alumnos(int idAlumno, String nombre, String curso, String email, double nota) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.curso = curso;
		this.email = email;
		this.nota = nota;
	}
	
	public Alumnos() {
		super();
	}
	

	public Alumnos(String nombre, String email, double nota) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.nota = nota;
	}

	public Alumnos(String nombre, String curso, String email, double nota) {
		super();
		this.nombre = nombre;
		this.curso = curso;
		this.email = email;
		this.nota = nota;
	}

	public Alumnos(String curso) {
		super();
		this.curso = curso;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
    
    

}
