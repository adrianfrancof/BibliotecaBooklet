package com.edutecno.model;

public class LibroAgregarForm {
	
	//atributos
	private Integer idLibro;
	private String titulo;
	private Integer anio;
	private String autor;
	private String imprenta;
	private boolean disponible;
	//constructor
	public LibroAgregarForm() {
	
	}
	//constructor con parametros
	public LibroAgregarForm(Integer idLibro, String titulo, Integer anio, String autor, String imprenta,
			boolean disponible) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.anio = anio;
		this.autor = autor;
		this.imprenta = imprenta;
		this.disponible = disponible;
	}
	//constructor para convertir un Libro a un LibroAgregarForm
	public LibroAgregarForm(Libro libro) {
		super();
		this.idLibro = libro.getIdLibro();
		this.titulo = libro.getTitulo();
		this.anio = libro.getAnio();
		this.autor = libro.getAutor();
		this.imprenta = libro.getImprenta();
		this.disponible = null != libro.getDisponible() ? (libro.getDisponible() == 1?true:false):true;
	}
	//getters y setters
	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getImprenta() {
		return imprenta;
	}

	public void setImprenta(String imprenta) {
		this.imprenta = imprenta;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}
