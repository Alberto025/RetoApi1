# API de Gestión de Vuelos
He basado mi tarea en una base de datos de vuelos en json, utilizando MongoDB.
Esta API permite la gestión de vuelos, incluyendo la obtención de información sobre vuelos, búsqueda por diferentes criterios, creación y actualización de vuelos.

## Endpoints Disponibles

### 1️⃣ Obtener todos los vuelos
**Método:** `GET`
- **Endpoint:** `/api/vuelos`
- **Descripción:** Devuelve una lista con todos los vuelos almacenados en la base de datos.

  ![image](https://github.com/user-attachments/assets/fede01cf-9a6f-4b87-b5f3-067708cf53c8)


### 2️⃣ Obtener un vuelo por su ID
**Método:** `GET`
- **Endpoint:** `/api/_id/{_id}`
- **Descripción:** Busca un vuelo específico según su identificador único.
- **Parámetro:** `{_id}` → ID del vuelo.
  
 ![image](https://github.com/user-attachments/assets/6b1c59c5-2c04-4276-a59d-3747f45d7d85)


### 3️⃣ Crear un nuevo vuelo
**Método:** `POST`
- **Endpoint:** `/api/vuelos`
- **Descripción:** Permite registrar un nuevo vuelo en la base de datos.
- **Cuerpo de la petición:** Debe enviarse un JSON con la información del vuelo.

### 4️⃣ Buscar vuelos por disponibilidad
**Método:** `GET`
- **Endpoint:** `/api/aeropuertos/{disponibilidad}`
- **Descripción:** Filtra los vuelos según su disponibilidad (`Disponible` o `No disponible`).
- **Parámetro:** `{disponibilidad}` → Estado de disponibilidad del aeropuerto.

### 5️⃣ Actualizar un vuelo por ID
**Método:** `PUT`
- **Endpoint:** `/api/_id/{id}`
- **Descripción:** Permite actualizar los datos de un vuelo existente.
- **Parámetro:** `{id}` → ID del vuelo a modificar.
- **Cuerpo de la petición:** Debe enviarse un JSON con los nuevos valores del vuelo.

---

### 🛠 Tecnologías Utilizadas
- Java con Spring Boot
- MongoDB como base de datos
- Maven para la gestión de dependencias

### 🚀 Cómo Ejecutar la API
1. Clonar el repositorio.
2. Configurar la conexión con MongoDB en `application.properties`.
3. Ejecutar la aplicación con `mvn spring-boot:run`.

### 📌 Autor
Desarrollado por [Tu Nombre]

