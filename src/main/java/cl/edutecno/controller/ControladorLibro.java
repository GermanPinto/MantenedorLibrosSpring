package cl.edutecno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.edutecno.model.Libro;
import cl.edutecno.service.ILibroService;

@Controller
public class ControladorLibro {
	@Autowired
	private ILibroService servicio;

	@GetMapping("/")
	public String inicio(ModelMap model) {
		model.put("libros", servicio.getLibros());
		return "muestraLibros";
	}

	@RequestMapping(value = "/addLibro", method = RequestMethod.POST)
	public String agregaLibro(ModelMap model, @ModelAttribute("libro") Libro libro) {
		servicio.addLibro(libro);
		model.put("libros", servicio.getLibros());
		return "muestraLibros";
	}
	
	@RequestMapping(value="/deleteLibro", method=RequestMethod.GET)
	public String deleteContact(ModelMap model, @RequestParam("id") int id) {
		servicio.deleteLibro(id);
		model.put("libros", servicio.getLibros());
		return "muestraLibros";
	}

}
