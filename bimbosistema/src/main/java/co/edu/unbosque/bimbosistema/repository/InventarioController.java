package co.edu.unbosque.bimbosistema.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.bimbosistema.model.Colaborador;
import co.edu.unbosque.bimbosistema.model.Producto;

@CrossOrigin // delimitar que ip se pueden conectar o que paises
@RestController // Servicios web ofrecidos desde el back
@RequestMapping("/bimboapi") // apuntar a localhost:8080/api

public class InventarioController {
	@Autowired // generar un objeto DAO para todas las conexiones
	private ColaboradorRepository codao;
	@Autowired
	private ProductoRepository prodao;

	@PostMapping(path = "/colaborador")
	public @ResponseBody ResponseEntity<String> add(@RequestParam String nombre, @RequestParam Integer edad,
			@RequestParam String email ) {
		Colaborador uc = new Colaborador();
		uc.setNombre(nombre);
		uc.setEdad(edad);
		uc.setEmail(email);
		codao.save(uc);
		return ResponseEntity.status(HttpStatus.CREATED).body("Created (CODE 201)\n");
	}

	@GetMapping("/colaborador")
	public ResponseEntity<Iterable<Colaborador>> getAll() {
		List<Colaborador> all = (List<Colaborador>) codao.findAll();
		if (all.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(all);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(all);
	}

	@GetMapping("/colaborador/get/{id}")
	public ResponseEntity<Colaborador> getOne(@PathVariable Integer id) {
		Optional<Colaborador> op = codao.findById(id);
		if (op.isPresent()) {
			return ResponseEntity.status(HttpStatus.FOUND).body(op.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

	}

	@DeleteMapping("/colaborador/eliminar/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		Optional<Colaborador> op = codao.findById(id);
		if (!op.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");

		}
		codao.deleteById(id);
		return ResponseEntity.status(HttpStatus.FOUND).body("Deleted");

	}

	@PutMapping("/colaborador/{id}")
	public ResponseEntity<String> update(@RequestParam String nombre, @RequestParam Integer edad,
			@RequestParam String email, @PathVariable Integer id) {
		Optional<co.edu.unbosque.bimbosistema.model.Colaborador> op = codao.findById(id);
		if (!op.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
		}
		return op.map(usr -> {
			usr.setNombre(nombre); // ""
			usr.setEdad(edad); // ""
			usr.setEmail(email); // ""
			codao.save(usr);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("DATA UPDATED");

		}).orElseGet(() -> {
			Colaborador nuevo = new Colaborador();
			nuevo.setId(id);
			nuevo.setNombre(nombre);
			nuevo.setEdad(edad);
			nuevo.setEmail(email);
			codao.save(nuevo);
			return ResponseEntity.status(HttpStatus.CREATED).body("DATA CREATED");
		});
	}

//////////////////////////////////////////////////////////////////////////////////////

	@PostMapping(path = "/producto")
	public @ResponseBody ResponseEntity<String> add(@RequestParam String nombre, @RequestParam Double precio,
			@RequestParam String vendedor, @RequestParam String sucursal) {
		Producto uc = new Producto();
		uc.setNombre(nombre);
		uc.setPrecio(precio);
		uc.setVendedor("");
		uc.setSucursal("");

		List<Colaborador> all = (List<Colaborador>) codao.findAll();
		for (int x = 0; x < all.size(); x++) {
			if (all.get(x).getNombre().equals(vendedor)) {
				uc.setVendedor(all.get(x).getEmail());
				break;
			}
		}
		
		if(sucursal.equals("Villavicencio") || sucursal.equals("Pasto") || sucursal.equals("Nariño") || sucursal.equals("Caracas")) {
			uc.setSucursal(sucursal);
		}
		
		if(uc.getVendedor().equals("") || uc.getSucursal().equals("")) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
		}else {
			prodao.save(uc);
			return ResponseEntity.status(HttpStatus.CREATED).body("Created (CODE 201)\n");
		}

	}

	@PutMapping("/producto/{id}")
	public ResponseEntity<String> update(@RequestParam String nombre, @RequestParam Double precio,
			@RequestParam String vendedor, @PathVariable Integer id) {
		Optional<Producto> op = prodao.findById(id);
		if (!op.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
		}
		return op.map(usr -> {
			usr.setNombre(nombre); // ""
			usr.setPrecio(precio); // ""
			List<Colaborador> all = (List<Colaborador>) codao.findAll();
			for (int x = 0; x < all.size(); x++) {
				if (all.get(x).getNombre().equals(vendedor)) {
					usr.setVendedor(all.get(x).getNombre());
					break;
				}
			}
			
			if(usr.getVendedor().equals("")) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
			}else {
				prodao.save(usr);
				return ResponseEntity.status(HttpStatus.CREATED).body("DATA CREATED");
			}
	

		}).orElseGet(() -> {
			Producto nuevo = new Producto();
			nuevo.setId(id);
			nuevo.setNombre(nombre);
			nuevo.setPrecio(precio);
			List<Colaborador> all = (List<Colaborador>) codao.findAll();
			for (int x = 0; x < all.size(); x++) {
				if (all.get(x).getNombre().equals(vendedor)) {
					nuevo.setVendedor(all.get(x).getNombre());
					break;
				}
			}
			
			if(nuevo.getVendedor().equals("")) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
			}else {
				prodao.save(nuevo);
				return ResponseEntity.status(HttpStatus.CREATED).body("DATA CREATED");
			}

		});
	}

	@GetMapping("/producto")
	public ResponseEntity<Iterable<Producto>> getAllProductos() {
		List<Producto> all = (List<Producto>) prodao.findAll();
		if (all.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(all);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(all);
	}
	
	@GetMapping("/producto/sucursal")
	public ResponseEntity<Iterable<Producto>> getAllProductosSucursal(@RequestParam String sucursal) {
		List<Producto> all = (List<Producto>) prodao.findAll();
		List<Producto> sucur = new ArrayList();
		for(int x = 0;x<all.size();x++) {
			if(all.get(x).getSucursal().equals(sucursal)) {
				sucur.add(all.get(x));
			}
		}
		if (all.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(sucur);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(sucur);
	}

	@GetMapping("/producto/get/{id}")
	public ResponseEntity<Producto> getOneProducto(@PathVariable Integer id) {
		Optional<Producto> op = prodao.findById(id);
		if (op.isPresent()) {
			return ResponseEntity.status(HttpStatus.FOUND).body(op.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

	}

	@DeleteMapping("/producto/eliminar/{id}")
	public ResponseEntity<String> deleteProducto(@PathVariable Integer id) {
		Optional<Producto> op = prodao.findById(id);
		if (!op.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");

		}
		codao.deleteById(id);
		return ResponseEntity.status(HttpStatus.FOUND).body("Deleted");

	}

}
