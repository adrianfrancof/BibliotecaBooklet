package com.edutecno.dao;

import java.util.List;

import com.edutecno.model.Libro;

public interface LibroDAO {
	
	public List<Libro> findAll();
	public Libro findById(Integer idLibro);
	public int add(Libro libro);
	public int update(Libro libro);
	public int delete(Libro libro);
	public List<Libro> findByTituloOrAutor(String textoBuscado);
}
