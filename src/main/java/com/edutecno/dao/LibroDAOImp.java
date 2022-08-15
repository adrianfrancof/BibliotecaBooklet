package com.edutecno.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.edutecno.model.Libro;
import com.edutecno.model.LibroMapper;

//Clase que implementa la interfaz LibroDAO
//etiqueta para declarar que es un repositorio perteneciente al objeto Libro
@Repository 
public class LibroDAOImp implements LibroDAO {
	
	private JdbcTemplate jdbcTemplate;//instancia para utilizar la api JdbcTemplate
	private DataSource dataSource;//instancia para establecer el DataSource o datos de la base de datos

	//constructor de clase
	public LibroDAOImp(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);//se inicializa jdbcTemplate para ejecutar las query
	}
	//metodo para consultar todos los registros existentes de libros
	@Override
	public List<Libro> findAll() {
		return jdbcTemplate.query("SELECT * FROM LIBRO",new LibroMapper());
	}
	//metodo para buscar un libro por id
	@Override
	public Libro findById(Integer idLibro) {
		return jdbcTemplate.queryForObject("SELECT * FROM LIBRO WHERE ID_LIBRO=?", new LibroMapper(), idLibro);
	}
	//metodo para agregar un libro
	@Override
	public int add(Libro libro) {
		return jdbcTemplate.update("INSERT INTO LIBRO VALUES (LIBRO_SEC.NEXTVAL,?,?,?,?,?)",
				libro.getTitulo(),//primer signo ?
				libro.getAnio(),//segundo ?
				libro.getAutor(),//tercer..
				libro.getImprenta(),
				libro.getDisponible()
				);
	}
	//metodo para actualizar un libro
	@Override
	public int update(Libro libro) {
		return jdbcTemplate.update("UPDATE LIBRO SET TITULO=?,ANIO=?,AUTOR=?,IMPRENTA=?,DISPONIBLE=? WHERE ID_LIBRO=?",
				libro.getTitulo(),
				libro.getAnio(),
				libro.getAutor(),
				libro.getImprenta(),
				libro.getDisponible(),
				libro.getIdLibro());
	}
	//metodo para eliminar un libro
	@Override
	public int delete(Libro libro) {
		return jdbcTemplate.update("DELETE FROM LIBRO WHERE ID_LIBRO=?", libro.getIdLibro());
	}
	//metodo para buscar libro por titulo o autor
	@Override
	public List<Libro> findByTituloOrAutor(String textoBuscado) {
	
		textoBuscado = "%"+textoBuscado+"%";
		//SELECT * FROM LIBRO WHERE UPPER (TITULO) LIKE UPPER ('%titu%') OR UPPER (AUTOR) LIKE UPPER ('%titu%')
		return jdbcTemplate.query("SELECT * FROM LIBRO WHERE UPPER (TITULO) LIKE UPPER (?) OR UPPER (AUTOR) LIKE UPPER (?)", 
				new LibroMapper(), 
				textoBuscado,textoBuscado);
	}
}
