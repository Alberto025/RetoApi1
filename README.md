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

  ![image](https://github.com/user-attachments/assets/006cb420-b914-4287-a0a2-280937255e13)


### 4️⃣ Buscar vuelos por disponibilidad
**Método:** `GET`
- **Endpoint:** `/api/aeropuertos/{disponibilidad}`
- **Descripción:** Filtra los vuelos según su disponibilidad (`Disponible` o `No disponible`).
- **Parámetro:** `{disponibilidad}` → Estado de disponibilidad del aeropuerto.

  ![image](https://github.com/user-attachments/assets/7ad69217-1eee-47c9-828a-f308381071a3)
  

### 5️⃣ Actualizar un vuelo por ID
**Método:** `PUT`
- **Endpoint:** `/api/_id/{id}`
- **Descripción:** Permite actualizar los datos de un vuelo existente.
- **Parámetro:** `{id}` → ID del vuelo a modificar.
- **Cuerpo de la petición:** Debe enviarse un JSON con los nuevos valores del vuelo.

  ![image](https://github.com/user-attachments/assets/704a4a61-80e9-446d-978a-86ca06dbf78e)


---

### 🛠 Tecnologías Utilizadas
- Java con Spring Boot
- MongoDB como base de datos
- Maven para la gestión de dependencias

### 📌 Autor
Desarrollado por [Alberto López Cabello]

