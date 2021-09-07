package cl.edutecno.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.edutecno.model.Libro;

@Service("libroService")
public class LibroServiceImpl implements ILibroService {
	
	private List<Libro> libros;
	
	public LibroServiceImpl() {
		libros= new ArrayList<Libro>(); 
	}

	@Override
	public List<Libro> getLibros() {
		return libros;
	}

	@Override
	public void addLibro(Libro libro) {
		int idMayor=0;
		if(libro!=null) {
			if(libros.size()==0) {
				libro.setId(libros.size()+1);
			}else {
				for(Libro libroTemp:libros) {
					if(libroTemp.getId()>idMayor) {
					idMayor=libroTemp.getId();
					}
				}
				libro.setId(idMayor+1);
			}
		}
		libros.add(libro);
	}

	@Override
	public void deleteLibro(int id) {
		for (Libro libroTemp : libros) {
			if(libroTemp.getId()==id) {
				libros.remove(libroTemp);
				break;
			}
		}
		
	}

}
