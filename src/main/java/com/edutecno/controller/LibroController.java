package com.edutecno.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edutecno.model.Libro;
import com.edutecno.model.LibroAgregarForm;
import com.edutecno.services.LibroService;
import com.edutecno.vo.LibroVO;

@Controller
public class LibroController {

	// declaracion de una instancia para ejecutar logger de informacion
	private final static Logger logger = LoggerFactory.getLogger(LibroController.class);

	@Autowired
	LibroService svc;

	// home //metodo para dirigir a una pagina de home y desplegar los Libros,
	// retorna un visua object
	@GetMapping("/home")
	public String home(ModelMap model) {

		model.addAttribute("VO", svc.findAll());

		return "home";
	}

	// editarForm get
	@GetMapping("/editarForm")
	public ModelAndView editarForm(Model model, @RequestParam Integer idLibro, RedirectAttributes ra) {
		LibroVO respuestaServicio = new LibroVO();

		respuestaServicio = svc.findById(idLibro);
		model.addAttribute("mensaje", respuestaServicio.getMensaje());
		model.addAttribute("VO", new LibroAgregarForm(respuestaServicio.getListaLibros().get(0)));
		return new ModelAndView("editar");
	}

	// editar post
	@PostMapping("/editar")
	public ModelAndView editar(@ModelAttribute LibroAgregarForm libro, RedirectAttributes ra) {
		LibroVO respuestaServicio = svc.update(new Libro(libro));
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/editarForm");
		}
	}

	// agregarForm get
	@GetMapping("/agregarForm")
	public String agregarForm(Model model) {
		return "agregar";
	}

	// agregar post
	@PostMapping("/agregar")
	public ModelAndView agregarSubmit(@ModelAttribute LibroAgregarForm libro, RedirectAttributes ra) {

		System.out.println(libro);
		LibroVO respuestaServicio = svc.add(new Libro(libro));
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/agregarForm");
		}
	}

	// eliminar
	@GetMapping("/eliminar")
	public ModelAndView eliminar(Model model, @RequestParam Integer idLibro, RedirectAttributes ra) {
		LibroVO respuestaServicio = new LibroVO();
		respuestaServicio.setMensaje("No se pudo eliminar el libro, intente nuevamente.");

		Libro eliminado = new Libro();
		eliminado.setIdLibro(idLibro);
		respuestaServicio = svc.delete(eliminado);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		return new ModelAndView("redirect:/home");
	}
	//cambiar disponibilidad
	@GetMapping("/cambiarDisponibilidad")
	public ModelAndView cambiarDisponibilidad(Model model, @RequestParam Integer idLibro,  RedirectAttributes ra) {
		LibroVO respuestaServicio = svc.changeAvailability(idLibro);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		return new ModelAndView("redirect:/home");
	}
	//buscar
	@PostMapping("/buscar")
	public String agregarSubmit(Model model, @RequestParam String textoBuscado) {
		
		LibroVO respuestaServicio = svc.findByTituloOrAutor(textoBuscado);
		model.addAttribute("mensaje", respuestaServicio.getMensaje());
		model.addAttribute("VO", respuestaServicio);
		return "home";
	}
}
