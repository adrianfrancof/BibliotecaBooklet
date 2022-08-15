package com.edutecno.services;

import com.edutecno.model.Libro;
import com.edutecno.vo.LibroVO;

//interfaz del servicio, desde el controlador se accedera a la interfaz y esta ejecutara la implementacion 
public interface LibroService {
	
	public LibroVO findAll();
	public LibroVO findById(Integer idLibro);
	public LibroVO changeAvailability(Integer idLibro);
	public LibroVO add(Libro libro);
	public LibroVO update(Libro libro);
	public LibroVO delete(Libro libro);
	public LibroVO findByTituloOrAutor(String textoBuscado);
	
}
