package org.example.vuelosapi;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Representa un vuelo dentro del sistema de gestión de vuelos.
 * Esta clase está mapeada a la colección "vuelos" en MongoDB.
 */
@Document(collection = "vuelos")
@Data
public class Vuelos {

    /**
     * Identificador único del vuelo en la base de datos.
     */
    @Id
    private String _id;

    /**
     * Nombre del aeropuerto de origen del vuelo.
     */
    private String aeropuerto;

    /**
     * Estado de disponibilidad del aeropuerto (Ejemplo: "Disponible", "No disponible").
     */
    private String disponibilidadaeropuerto;

    /**
     * Nombre de la compañía aérea operadora del vuelo.
     */
    private String compañia;

    /**
     * Número de vuelo asignado por la aerolínea.
     */
    private String numvuelo;

    /**
     * Destino del vuelo.
     */
    private String destino;

    /**
     * Hora de salida del vuelo.
     */
    private String salida;

    /**
     * Hora estimada de llegada del vuelo a su destino.
     */
    private String llegada;

    /**
     * Precio del billete para el vuelo.
     */
    private Double precio;
}
