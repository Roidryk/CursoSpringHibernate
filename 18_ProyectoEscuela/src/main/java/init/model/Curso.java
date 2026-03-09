package init.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="alumnos")
public class Curso {

	@Id
	private int codCurso;
	private String denominacion;	
	private int duracion;
	private String horario;
	
	@ManyToMany()
	@JoinTable(name = "matriculas",
	joinColumns = @JoinColumn(name="IdCurso",
	referencedColumnName = "codCurso"),
	inverseJoinColumns = @JoinColumn(name="IdAlumno",
	referencedColumnName ="dni"))
	private List<Alumno> alumnos;

	public Curso(int codCurso, String denominacion, int duracion, String horario) {
		super();
		this.codCurso = codCurso;
		this.denominacion = denominacion;
		this.duracion = duracion;
		this.horario = horario;
	}
	
	
	
	
}
