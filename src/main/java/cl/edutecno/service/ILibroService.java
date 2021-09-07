package cl.edutecno.service;

import java.util.List;

import cl.edutecno.model.Libro;

public interface ILibroService {
	
	List<Libro> getLibros();
	void addLibro(Libro libro);
	void deleteLibro(int id);
	

}
