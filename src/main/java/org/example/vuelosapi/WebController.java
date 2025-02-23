package org.example.vuelosapi;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para gestionar la interfaz web de la aplicación.
 * Permite visualizar, agregar, editar y actualizar vuelos en una interfaz HTML.
 */
@Controller
@RequestMapping("/web")
public class WebController {

    @Autowired
    VuelosRepository vuelosRepository;

    /**
     * Muestra la página principal con la lista de vuelos.
     *
     * @param session La sesión HTTP actual.
     * @param model   Modelo para pasar atributos a la vista.
     * @return La vista "index" con la lista de vuelos.
     */
    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        var vuelos = vuelosRepository.findAll();
        model.addAttribute("titulo", "LISTADO DE VUELOS");
        model.addAttribute("vuelos", vuelos);
        return "index";
    }

    /**
     * Muestra la información de un vuelo específico.
     *
     * @param model Modelo para pasar atributos a la vista.
     * @param _id   ID del vuelo a buscar.
     * @return La vista "single" con la información del vuelo o "404" si no se encuentra.
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
     *
     * @param model Modelo para pasar un objeto vacío de vuelo.
     * @return La vista "new" con el formulario de creación.
     */
    @GetMapping("/new")
    public String mostrarFormularioNuevoVuelo(Model model) {
        model.addAttribute("vuelo", new Vuelos());
        return "new";
    }

    /**
     * Guarda un nuevo vuelo en la base de datos.
     *
     * @param vuelo Objeto de tipo Vuelos con la información ingresada en el formulario.
     * @return Redirección a la página principal después de guardar el vuelo.
     */
    @PostMapping("/new")
    public String crearHotel(@ModelAttribute Vuelos vuelo) {
        vuelosRepository.save(vuelo);
        return "redirect:/web/";
    }

    /**
     * Muestra el formulario de edición de un vuelo existente.
     *
     * @param _id   ID del vuelo a editar.
     * @param model Modelo para pasar los datos del vuelo a la vista.
     * @return La vista "edit" con el formulario de edición.
     * @throws IllegalArgumentException si el ID del vuelo no es válido.
     */
    @GetMapping("{_id}/edit")
    public String mostrarFormularioEdicion(@PathVariable String _id, Model model) {
        Vuelos vuelos = vuelosRepository.findById(_id)
                .orElseThrow(() -> new IllegalArgumentException("ID de vuelo no válido: " + _id));
        model.addAttribute("vuelos", vuelos);
        return "edit";
    }

    /**
     * Actualiza la información de un vuelo existente.
     *
     * @param _id    ID del vuelo a actualizar.
     * @param vuelos Objeto con los nuevos datos del vuelo.
     * @return Redirección a la página principal después de la actualización.
     * @throws IllegalArgumentException si el ID del vuelo no es válido.
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
