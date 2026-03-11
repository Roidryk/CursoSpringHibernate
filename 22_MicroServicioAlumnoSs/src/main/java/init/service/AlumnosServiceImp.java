package init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import init.Mapper.Mapeador;
import init.dtos.AlumnoDTO;
import init.model.Alumno;
import init.repository.AlumnosRepository;

public class AlumnosServiceImp implements AlumnosService {
	
	@Autowired
	AlumnosRepository repo;
	
	
	@Autowired
	Mapeador mapeador;


	@Override
	public boolean guardar(AlumnoDTO alumno) {
		
		if(repo.findFirstByNombreAndCurso(alumno.getNombre(), alumno.getCurso())==null) {
			repo.save(mapeador.alumnoDtoToEntity(alumno));
			return true;
	}
		
		return false;
	}


	@Override
	public List<AlumnoDTO> alumnosCurso(String curso) {
		// TODO Auto-generated method stub
		return repo.findByCurso(curso).stream().map(a->mapeador.alumnoEntityToDto(a)).toList();
	}


	@Override
	public List<AlumnoDTO> cursos() {
		// TODO Auto-generated method stub
		return  repo.findAll().stream().map(a->mapeador.alumnoEntityToDto(a)).toList();
	}


	@Override
	public AlumnoDTO eliminar(String email) {
	
		Alumno alumno = repo.findFirstByEmail(email);
		
		if(alumno!=null) {
			
			repo.deleteByEmail(email);
		}
		
		return mapeador.alumnoEntityToDto(alumno);
		
		
	}


	@Override
	public List<AlumnoDTO> alumnos() {
		
		return repo.findAll().stream().map(a->mapeador.alumnoEntityToDto(a)).toList();
	}

	

}
