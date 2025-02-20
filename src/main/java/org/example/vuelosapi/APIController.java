package org.example.vuelosapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que maneja las operaciones CRUD sobre la colección de vuelos.
 */
@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private VuelosRepository vuelosRepository;

    /**
     * Obtiene todos los vuelos almacenados en la base de datos.
     *
     * @return Lista de todos los vuelos.
     */
    @GetMapping("/vuelos")
    public List<Vuelos> all() {
        return vuelosRepository.findAll();
    }

    /**
     * Busca un vuelo por su ID.
     *
     * @param _id Identificador del vuelo a buscar.
     * @return Lista de vuelos que coinciden con el ID proporcionado.
     */
    @GetMapping("/_id/{_id}")
    public List<Vuelos> findById(@PathVariable String _id) {
        if (vuelosRepository.findVuelosBy_id(_id).isEmpty()) {
            return null;
        }
        return vuelosRepository.findVuelosBy_id(_id);
    }

    /**
     * Crea un nuevo vuelo en la base de datos.
     *
     * @param vuelo Objeto vuelo a ser almacenado.
     * @return El vuelo creado.
     */
    @PostMapping("/vuelos")
    public Vuelos create(@RequestBody Vuelos vuelo) {
        vuelosRepository.save(vuelo);
        return vuelo;
    }

    /**
     * Obtiene la lista de vuelos según la disponibilidad del aeropuerto.
     *
     * @param disponibilidad Disponibilidad del aeropuerto (ejemplo: "Disponible" o "No disponible").
     * @return Lista de vuelos con la disponibilidad especificada.
     */
    @GetMapping("/aeropuertos/{disponibilidad}")
    public List<Vuelos> findByDisponibilidad(@PathVariable String disponibilidad) {
        if (vuelosRepository.findVuelosByDisponibilidadaeropuerto(disponibilidad).equals("No disponible")) {
            return null;
        }
        return vuelosRepository.findVuelosByDisponibilidadaeropuerto(disponibilidad);
    }

    /**
     * Actualiza la información de un vuelo existente sin modificar su ID.
     *
     * @param id               Identificador del vuelo a actualizar.
     * @param vueloActualizado Datos actualizados del vuelo.
     * @return El vuelo actualizado.
     * @throws RuntimeException Si el vuelo con el ID especificado no se encuentra.
     */
    @PutMapping("/_id/{id}")
    public Vuelos actualizarVuelo(@PathVariable String id, @RequestBody Vuelos vueloActualizado) {
        return vuelosRepository.findById(id).map(vuelo -> {
            vuelo.setAeropuerto(vueloActualizado.getAeropuerto());
            vuelo.setDisponibilidadaeropuerto(vueloActualizado.getDisponibilidadaeropuerto());
            vuelo.setCompañia(vueloActualizado.getCompañia());
            vuelo.setNumvuelo(vueloActualizado.getNumvuelo());
            vuelo.setDestino(vueloActualizado.getDestino());
            vuelo.setSalida(vueloActualizado.getSalida());
            vuelo.setLlegada(vueloActualizado.getLlegada());
            vuelo.setPrecio(vueloActualizado.getPrecio());
            return vuelosRepository.save(vuelo);
        }).orElseThrow(() -> new RuntimeException("Vuelo con ID " + id + " no encontrado"));
    }
}
