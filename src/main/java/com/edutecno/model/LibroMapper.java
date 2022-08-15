package com.edutecno.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//Clase para mapear la clase Libro, mediante la interfaz RowMapper<Object>
public class LibroMapper implements RowMapper<Libro> {
	
	//metodo para asignar los valores consultados a la base de datos mediante jdbcTemplate
	@Override
	public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
		
//		CREATE TABLE LIBRO (
//				id_libro INTEGER PRIMARY KEY,
//				titulo VARCHAR2(250),
//				anio INTEGER,
//				autor VARCHAR2(250),
//				imprenta VARCHAR2(30),
//				disponible INTEGER
//				);
		
//		pstm = conn.prepareStatement();
//		rs = pstm.executeQuery();
//		
//		while (rs.next()) {
//			Libro libro = new Libro();
//			libro.setIdLibro(rs.getInt("id_titulo"));
//		}
		
		//instancia de objeto temporal tipo Libro, para setearle valores y retornarlo
		Libro libro = new Libro();
		//mediante el ResultSet se setean los valores a libro utilizando los setters del objeto y getters de ResultSet
		libro.setIdLibro(rs.getInt("id_libro"));
		libro.setTitulo(rs.getString("titulo"));
		libro.setAnio(rs.getInt("anio"));
		libro.setAutor(rs.getString("autor"));
		libro.setImprenta(rs.getString("imprenta"));
		libro.setDisponible(rs.getInt("disponible"));
		
		return libro; //se retorna el libro con los valores seteados
	}
}
