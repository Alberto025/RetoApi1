package org.example.vuelosapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Repositorio para la gestión de la colección "vuelos" en MongoDB.
 * Proporciona métodos para realizar consultas personalizadas sobre los vuelos.
 */
public interface VuelosRepository extends MongoRepository<Vuelos, String> {

    /**
     * Obtiene todos los vuelos almacenados en la base de datos.
     *
     * @return Lista de todos los vuelos.
     */
    List<Vuelos> findAll();

    /**
     * Busca vuelos por su número de vuelo.
     *
     * @param numvuelo Número de vuelo a buscar.
     * @return Lista de vuelos con el número de vuelo especificado.
     */
    List<Vuelos> findVuelosByNumvuelo(String numvuelo);

    /**
     * Busca vuelos por su identificador único.
     *
     * @param _id Identificador único del vuelo.
     * @return Lista de vuelos con el ID especificado.
     */
    List<Vuelos> findVuelosBy_id(String _id);

    /**
     * Busca vuelos según la disponibilidad del aeropuerto.
     *
     * @param disponibilidaderopuerto Estado de disponibilidad (Ejemplo: "Disponible", "No disponible").
     * @return Lista de vuelos que coincidan con la disponibilidad especificada.
     */
    List<Vuelos> findVuelosByDisponibilidadaeropuerto(String disponibilidaderopuerto);

    /**
     * Busca vuelos cuyo precio sea menor al especificado.
     *
     * @param precio Precio máximo de los vuelos a buscar.
     * @return Lista de vuelos con un precio menor al especificado.
     */
    List<Vuelos> findVuelosByPrecioLessThan(double precio);

    /**
     * Busca vuelos con un precio exacto utilizando una consulta personalizada en MongoDB.
     *
     * @param precio Precio exacto a buscar.
     * @return Lista de vuelos con el precio especificado.
     */
    @Query("{'precio':?0}")
    List<Vuelos> vueloDePrecio(Integer precio);
}
