package init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dtos.CursoDTO;
import init.dtos.MatriculaInfoDTO;
import init.mapper.Mapeador;
import init.repository.AlumnoRepository;
import init.repository.CursoRepository;

@Service
public class EscuelaServiceImp implements EscuelaService {
	@Autowired
	AlumnoRepository alumnoRepository;

	@Autowired
	CursoRepository cursoRepository;

	@Autowired
	Mapeador mapeador;

	@Override
	public List<CursoDTO> cursos() {

		return cursoRepository.findAll().stream().map(c -> mapeador.cursoEntityToDto(c)).toList();

	}

	@Override
	public List<MatriculaInfoDTO> obtenerMatriculas(int codCurso) {

		CursoDTO curso = cursoRepository.findById(codCurso).map(c->mapeador.cursoEntityToDto(c)).orElse(null);
		
		
		if(curso == null) {
			
			return List.of();
			
		}
		return alumnoRepository.findByCodigoCurso(codCurso).stream().map(a->new MatriculaInfoDTO(mapeador.AlumnoEntityToDto(a),curso)).toList();
		
	}

	@Override
	public boolean matricular(int codCurso, String dni) {
//Matricular un alumno en un curso es sal 
		//el optional no puede ser null
		
		
		if()

			return false;
	}

}
