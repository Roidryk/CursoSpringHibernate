package init.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import init.model.idTema;

public interface TemasRepository extends JpaRepository<idTema, Integer>{

}
