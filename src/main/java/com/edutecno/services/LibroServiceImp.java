package com.edutecno.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.dao.LibroDAO;
import com.edutecno.model.Libro;
import com.edutecno.vo.LibroVO;

//clase servicio que emplementa la interfaz LibroService y trabajara con los data access object
@Service
public class LibroServiceImp implements LibroService {
	
	//declaracion de una instancia para ejecutar logger de informacion
	private final static Logger logger = LoggerFactory.getLogger(LibroServiceImp.class);
	
	//inyectar las dependencias
	@Autowired //LibroDAO dao = new LibroDAOImp
	private LibroDAO dao;//instancia para acceder al data access object y consultar o modificar la base de datos
	private LibroVO respuesta;//instancia de visual object para dar la respuesta, mensaje y codigo
	
	@Override
	public LibroVO findAll() {
		respuesta = new LibroVO(new ArrayList<Libro>(),"Ha ocurrido un error","102");
		try {
			respuesta.setListaLibros(new ArrayList<>(dao.findAll()));//se obtienen los Libros y se setean
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s",respuesta.getListaLibros().size()));
			respuesta.setCodigo("0");//seteo del codigo
		} catch (Exception e) {
			logger.error("Error en LibroServiceImp findAll()");
			System.err.println(e);
		}
		return respuesta;//retorno
	}

	@Override
	public LibroVO findById(Integer idLibro) {
		respuesta = new LibroVO(new ArrayList<Libro>(),"Ha ocurrido un error","103");
		try {
			respuesta.getListaLibros().add(dao.findById(idLibro));//se busca el libro y se setea en la respuesta
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s",respuesta.getListaLibros().size()));
			respuesta.setCodigo("0");
			
		} catch (Exception e) {
			logger.error("error en LibroServiceImp findById()");
			System.err.println(e);
		}
		return respuesta;//retorno
	}

	@Override
	public LibroVO changeAvailability(Integer idLibro) {
		respuesta = new LibroVO(new ArrayList<Libro>(),"Ha ocurrido un error","104");
		try {
			Libro libroEncontrado = dao.findById(idLibro);
			if (libroEncontrado != null) {				//if getDisponible() == 1 es 0 or 1
				libroEncontrado.setDisponible(libroEncontrado.getDisponible() == 1? 0 : 1);
				dao.update(libroEncontrado);
			}
			respuesta.setMensaje(String.format("Se ha cambiado la disponibilidad"));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.error("error en LibroServiceImp changeAvailability()");
			System.err.println(e);
		}
		return respuesta;
	}

	@Override
	public LibroVO add(Libro libro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "105" );
		try {
			if (libro != null) {
				int registro = dao.add(libro);//invocacion al metodo de añadir del LibroServiceImp
				respuesta.setMensaje(registro == 1 ? String.format("Se ha añadido %d libro", registro) : "No se ha añadido ningún libro");
				//respuesta.setMensaje(String.format("Se ha añadido %d libro(s)", registro));
				respuesta.setCodigo("0");
			}
		} catch (Exception e) {
			logger.error("error en LibroServiceImp add()");
			System.err.print(e);
		}
		return respuesta;
	}

	@Override
	public LibroVO update(Libro libro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "106" );
		try {
			int registrosActualizados = dao.update(libro);//invicacion del metodo update de LibroServiceImp
			respuesta.setMensaje(String.format("Se ha/n actualizado correctamente %d Libro/s", registrosActualizados));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.error("error en LibroServiceImp update()");
		}
		return respuesta;
	}

	@Override
	public LibroVO delete(Libro libro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "107" );
        try {
            int registrosActualizados = dao.delete(libro);
            respuesta.setMensaje(String.format("Se ha eliminado correctamente el libro", registrosActualizados));
            respuesta.setCodigo("0");
        } catch (Exception e) {
        	logger.error("error en LibroServiceImp delete()");
            System.err.print(e);
        }
        return respuesta;
	}

	@Override
	public LibroVO findByTituloOrAutor(String textoBuscado) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "108" );
        try {
            respuesta.setListaLibros(new ArrayList<>(dao.findByTituloOrAutor(textoBuscado)));
            respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuesta.getListaLibros().size()));
            respuesta.setCodigo("0");
        } catch (Exception e) {
        	logger.error("error en LibroServiceImp findByTituloOrAutor()");
            System.err.print(e);
        }
        return respuesta;
	}
}
