package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Alumnos;
import repository.AlumnoRepository;

@Service
public class AlumnosServiceImp implements AlumnoService{

	
	@Autowired
	AlumnoRepository alumnoRepository;
	
	public List<Alumnos> buscarPorCurso(String curso) {
		
		return alumnoRepository.findByCurso(curso);
	}

	public boolean nuevoAlumno(Alumnos alumno) {
		
		if(alumnoRepository.findByNombreAndCurso(alumno.getNombre(), alumno.getCurso())==null) {
			
			alumnoRepository.añadir(alumno);
			
		}
		
		return false;
	}

	@Override
	public List<String> cursos() {

		
		
		return alumnoRepository.findAllCursos();
	}

	@Override
	public void elminar(int id) {
		alumnoRepository.removeById(id);
		
	}

}
