package repository;

import entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JPARepository recoge 2 valores :
//          1 - Es la 'Entity' a la que hace referencia.
//          2 - ID de la 'Entity'
@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {
}
