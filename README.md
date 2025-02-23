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
  

## Endpoints de la sección "Web"

### 1️⃣ Obtener listado de vuelos
**Método:** `GET`  
- **Endpoint:** `/web/`  
- **Descripción:** Devuelve un listado con todos los vuelos disponibles en la base de datos. 

  ![image](https://github.com/user-attachments/assets/3df6d8a6-7185-4cf5-b4d2-6951ea23258e)


### 2️⃣ Obtener nuevo vuelo (Formulario)
**Método:** `GET`  
- **Endpoint:** `/web/new`  
- **Descripción:** Muestra el formulario para crear un nuevo vuelo.

  ![image](https://github.com/user-attachments/assets/0f082189-f1b0-4f9e-ada1-cee36d60be38)


### 3️⃣ Crear nuevo vuelo (Enviar datos)
**Método:** `POST`  
- **Endpoint:** `/web/new`  
- **Descripción:** Envía los datos del nuevo vuelo para ser almacenados en la base de datos.

  ![image](https://github.com/user-attachments/assets/45bbe13f-ebfe-4b63-8444-d687358b961a)


### 4️⃣ Obtener detalles de un vuelo específico
**Método:** `GET`  
- **Endpoint:** `/web/{_id}`  
- **Descripción:** Obtiene la información detallada de un vuelo según su ID.
- **Parámetro:** `{_id}` → ID único del vuelo.

  ![image](https://github.com/user-attachments/assets/fd659e96-4c11-4874-94e7-5c651322a711)


### 5️⃣ Editar un vuelo (Formulario)
**Método:** `GET`  
- **Endpoint:** `/web/{_id}/edit`  
- **Descripción:** Muestra el formulario para editar los datos de un vuelo específico.
- **Parámetro:** `{_id}` → ID único del vuelo.

  ![image](https://github.com/user-attachments/assets/3b1a2781-9a09-4eb1-b8bf-dac907b6003a)
  

### 6️⃣ Editar un vuelo (Actualizar datos)
**Método:** `PUT`  
- **Endpoint:** `/web/{_id}/edit`  
- **Descripción:** Envía los datos modificados de un vuelo para actualizarlo en la base de datos.
- **Parámetro:** `{_id}` → ID único del vuelo.

  ![image](https://github.com/user-attachments/assets/e8ddba29-d159-491e-8b98-7bdacc0809a0)














---

### 🛠 Tecnologías Utilizadas
- Java con Spring Boot
- MongoDB como base de datos
- Maven para la gestión de dependencias

### 📌 Autor
Desarrollado por [Alberto López Cabello]

