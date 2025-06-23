package com.bedu.inventario;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "El nombre no puede estar vacío")
	private String nombre;

	@NotBlank(message = "La descripción no puede estar vacía")
	private String descripcion;

	@Min(value = 1, message = "El precio debe ser mayor o igual a 1")
	private double precio;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marca marca;

	protected Producto() {}

	public Producto(String nombre, String descripcion, double precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Producto(String nombre, String descripcion, double precio, Categoria categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
	}

	public Producto(String nombre, String descripcion, double precio, Categoria categoria, Marca marca) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
		this.marca = marca;
	}

	public Long getId() { return id; }
	public String getNombre() { return nombre; }
	public String getDescripcion() { return descripcion; }
	public double getPrecio() { return precio; }
	public Categoria getCategoria() { return categoria; }
	public Marca getMarca() { return marca; }

	@Override
	public String toString() {
		return String.format(
				"Producto[id=%d, nombre='%s', precio=%.2f, categoria='%s', marca='%s']",
				id,
				nombre,
				precio,
				categoria != null ? categoria.getNombre() : "Sin categoría",
				marca != null ? marca.getNombre() : "Sin marca"
		);
	}
}
