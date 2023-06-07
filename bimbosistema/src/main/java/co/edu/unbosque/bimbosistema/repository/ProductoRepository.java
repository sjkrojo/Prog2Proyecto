package co.edu.unbosque.bimbosistema.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.bimbosistema.model.Producto;



public interface ProductoRepository extends CrudRepository<Producto, Integer> {
	
	public Optional<Producto> findById(Integer id);
	
	public List<Producto> findAll();
	
}
