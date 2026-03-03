package repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import model.Alumnos;


@Repository
public class AlumnosRepositoryImp implements AlumnoRepository {
	
	@PersistenceContext
	EntityManager eManager;

	

	@Transactional
	public void añadir(Alumnos alumno) {
		
		eManager.persist(alumno);
		
	}

	@Override
	public List<Alumnos> findByCurso(String curso) {
	
		String jpql = "select i from Alumnos i where i.curso = ?1";
		TypedQuery<Alumnos> query = eManager.createQuery(jpql, Alumnos.class);
		query.setParameter(1, curso);
		
		
		return query.getResultList();
	}

	@Override
	public Alumnos findByNombreAndCurso(String nombre, String curso) {
		
		String jpql = "select i from Alumnos i where i.curso = ?1 and i.nombre= ?2";
		TypedQuery<Alumnos> query = eManager.createQuery(jpql, Alumnos.class);
		
		query.setParameter(1, curso);
		query.setParameter(2, nombre);
		
		List<Alumnos> resultado = query.getResultList();
		
		
		return resultado.size()>0?resultado.get(0):null;
	}

	@Override
	public List<String> findAllCursos() {
		// al ser String donde se pone Alumno se cambia por String
		String jpql = "select distinct(a.curso) from Alumnos a";
		TypedQuery<String> query = eManager.createQuery(jpql, String.class);

		return query.getResultList();

		
	}

	@Override
	public void removeById(int idAlumno) {
		String jpql = "delete from Alumno a where a.idAlumno = ?1";
		Query query = eManager.createQuery(jpql);
		query.setParameter(1, idAlumno);
		query.executeUpdate();
		
	}

}
