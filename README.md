API REST desarrollada con Java Spring Boot y MySQL para la gestión de asignaturas de Formación Profesional. Permite administrar la jerarquía completa de:
1.  Asignaturas (Materias)
2.  Resultados de Aprendizaje (RAs)
3.  Criterios de Evaluación

---

1. Estructura del Proyecto

El proyecto sigue una arquitectura (Modelo-Vista-Controlador) con separación estricta de responsabilidades:

```text
com.campuscamara.gestionasignaturas
├── controller          # Capa de Control (Expone endpoints REST)
│   ├── MateriaController.java
│   ├── RaController.java
│   └── CeController.java
│
├── service             # Capa de Negocio (Lógica y validaciones)
│   ├── MateriaService.java
│   ├── RaService.java
│   └── CeServive.java
│
├── repository          # Capa de Datos (Interfaces JPA/Hibernate)
│   ├── MateriaRepository.java
│   ├── RaRepository.java
│   └── CeRepository.java
│
└── model               # Entidades (Tablas de BBDD)
    ├── Materia.java
    ├── Ra.java
    └── Ce.java

2. Endpoints Disponibles
La API corre por defecto en el puerto 8081 (ver application.properties). 
Base URL: http://localhost:8081/api

Materias (Asignaturas)
GET	/api/materias	Listar todas las asignaturas.
POST	/api/materias	Crear una nueva asignatura.
PUT	/api/materias/{id}	Modificar una asignatura existente.
DELETE	/api/materias/{id}	Eliminar una asignatura.

Resultados de Aprendizaje (RAs)
GET	/api/ras	Listar todos los RAs.
GET	/api/ras/materia/{id}	Ver RAs de una asignatura específica.
POST	/api/ras	Crear un RA (vinculado a una Materia).
DELETE	/api/ras/{id}	Eliminar un RA.

Criterios de Evaluación
GET	/api/criterios	Listar todos los criterios.
GET	/api/criterios/ra/{id}	Ver Criterios de un RA específico.
POST	/api/criterios	Crear un Criterio (vinculado a un RA).
DELETE	/api/criterios/{id}	Eliminar un criterio.

3. Ejemplos de Pruebas
Para probar la API con Postman utiliza estos cuerpos JSON en las peticiones POST o PUT.

-Crear Materia
POST http://localhost:8081/api/materias


{
  "codigo": "BBDD",
  "nombre": "Base de Datos"
}

-Crear RA (Vinculado a Materia)
Nota: Debes indicar el ID de la materia padre. POST http://localhost:8081/api/ras

JSON
{
  "descripcion": "RA1. Reconoce la estructura de datos...",
  "materia": {
    "id": 1
  }
}

-Crear Criterio (Vinculado a RA)
Nota: Debes indicar el ID del RA padre. POST http://localhost:8081/api/criterios

JSON
{
  "descripcion": "a) Identifica los tipos de datos.",
  "ra": {
    "id": 1
  }
}


Configuración
Java Version: 21
Base de Datos: MySQL
Puerto: 8081 (Configurable en application.properties)
