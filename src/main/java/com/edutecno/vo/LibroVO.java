package com.edutecno.vo;

import java.util.List;

import com.edutecno.model.Libro;

//objeto para transferir o transportar datos a la visual, 
//llevara el resultado, mensaje de respuesta, codigo de respuesta
public class LibroVO {
	
	//atributos
	private List<Libro> listaLibros;//almacenar el resultado de la consulta
	private String mensaje;//almacenar mensaje de respuesta del servicio
	private String codigo;//almacenar codigo de respuesta del servicio
	
	//constructor vacio
	public LibroVO() {
	
	}
	//constructor con parametros
	public LibroVO(List<Libro> listaLibros, String mensaje, String codigo) {
		super();
		this.listaLibros = listaLibros;
		this.mensaje = mensaje;
		this.codigo = codigo;
	}
	//getters y setters
	public List<Libro> getListaLibros() {
		return listaLibros;
	}
	public void setListaLibros(List<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	//metodo toString()
	@Override
	public String toString() {
		return "LibroVO [listaLibros=" + listaLibros + ", mensaje=" + mensaje + ", codigo=" + codigo + "]";
	}
}
