package repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Item;

@Repository
public class ItemsRepositoryImpl implements ItemsRepository {
	
	@PersistenceContext
	EntityManager eManager;

	@Transactional
	public void save(Item item) {
    
		eManager.persist(item);
		
		
		
	}

	public List<Item> findByTematica(String tematica) {
		//pendiente...
		String jpql = "select i from Item i where i.tematica = ?1";
		TypedQuery<Item> query = eManager.createQuery(jpql, Item.class);
		query.setParameter(1, tematica);		
		return query.getResultList();
	}

	public Item findByUrl(String url) {
		 
		String jpql = "select i from Item i where i.url=?1";
		TypedQuery<Item> query = eManager.createQuery(jpql, Item.class);

		query.setParameter(1, url);
	
		List<Item> resultado = query.getResultList();
		
		return resultado.size()>0?resultado.get(0):null;
// if en una sola linea, amyor que cero obtengo el primer puesto cno get(0) y : si no devulve null
		
		
		
		
	}

}
