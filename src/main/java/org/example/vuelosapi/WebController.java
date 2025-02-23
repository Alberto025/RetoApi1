package org.example.vuelosapi;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para gestionar las vistas web relacionadas con los vuelos.
 */
@Controller
@RequestMapping("/web")
public class WebController {

    @Autowired
    VuelosRepository vuelosRepository;

    /**
     * Muestra el listado de todos los vuelos disponibles.
     * @param session Sesión HTTP actual.
     * @param model Modelo para pasar datos a la vista.
     * @return Nombre de la vista "index".
     */
    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        var vuelos = vuelosRepository.findAll();
        model.addAttribute("titulo", "LISTADO DE VUELOS");
        model.addAttribute("vuelos", vuelos);
        return "index";
    }

    /**
     * Muestra los detalles de un vuelo específico.
     * @param model Modelo para pasar datos a la vista.
     * @param _id Identificador del vuelo.
     * @return Nombre de la vista "single" si el vuelo existe, o "404" si no.
     */
    @GetMapping("/{_id}")
    public String single(Model model, @PathVariable String _id) {
        var vuelos = vuelosRepository.findById(_id);
        if (vuelos.isEmpty()) return "404";
        else {
            model.addAttribute("vuelos", vuelos.get());
            return "single";
        }
    }

    /**
     * Muestra el formulario para crear un nuevo vuelo.
     * @param model Modelo para pasar datos a la vista.
     * @return Nombre de la vista "new".
     */
    @GetMapping("/new")
    public String mostrarFormularioNuevoVuelo(Model model) {
        model.addAttribute("vuelo", new Vuelos());
        return "new";
    }

    /**
     * Procesa el formulario de creación de un nuevo vuelo.
     * @param vuelo Objeto de tipo Vuelos con los datos ingresados.
     * @return Redirección a la vista de listado de vuelos.
     */
    @PostMapping("/new")
    public String crearVuelo(@ModelAttribute Vuelos vuelo) {
        vuelosRepository.save(vuelo);
        return "redirect:/web/";
    }

    /**
     * Muestra el formulario de edición para un vuelo existente.
     * @param _id Identificador del vuelo.
     * @param model Modelo para pasar datos a la vista.
     * @return Nombre de la vista "edit".
     */
    @GetMapping("{_id}/edit")
    public String mostrarFormularioEdicion(@PathVariable String _id, Model model) {
        Vuelos vuelos = vuelosRepository.findById(_id)
                .orElseThrow(() -> new IllegalArgumentException("ID de vuelo no válido: " + _id));
        model.addAttribute("vuelos", vuelos);
        return "edit";
    }

    /**
     * Procesa la actualización de los datos de un vuelo existente.
     * @param _id Identificador del vuelo a actualizar.
     * @param vuelos Objeto con los nuevos datos del vuelo.
     * @return Redirección a la vista de listado de vuelos.
     */
    @PutMapping("{_id}/edit")
    public String actualizarVuelo(@PathVariable String _id, @ModelAttribute Vuelos vuelos) {
        Vuelos vueloExistente = vuelosRepository.findById(_id)
                .orElseThrow(() -> new IllegalArgumentException("ID de vuelo no válido: " + _id));

        // Actualizar campos del vuelo
        vueloExistente.setAeropuerto(vuelos.getAeropuerto());
        vueloExistente.setDisponibilidadaeropuerto(vuelos.getDisponibilidadaeropuerto());
        vueloExistente.setCompañia(vuelos.getCompañia());
        vueloExistente.setNumvuelo(vuelos.getNumvuelo());
        vueloExistente.setDestino(vuelos.getDestino());
        vueloExistente.setSalida(vuelos.getSalida());
        vueloExistente.setLlegada(vuelos.getLlegada());
        vueloExistente.setPrecio(vuelos.getPrecio());

        vuelosRepository.save(vueloExistente);

        return "redirect:/web/";
    }
}
