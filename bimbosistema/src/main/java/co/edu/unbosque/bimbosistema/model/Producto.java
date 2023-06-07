package co.edu.unbosque.bimbosistema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nombre;
	private String vendedor;
	private Double precio;
	private String sucursal;

	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(Integer id, String nombre, String vendedor, Double precio, String sucursal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.vendedor = vendedor;
		this.precio = precio;
		this.sucursal= sucursal;
	}

	
	
	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

}
