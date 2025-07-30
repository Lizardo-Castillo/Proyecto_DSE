
## 🏥 Proyecto BPMN y Servicios Web - Programación de Citas Médicas

### 👥 Equipo de Trabajo

- Lizardo Manuel Castillo Llaza
- Karla Veronica Cornejo Pari
- Jose Alejandro Machaca Muniz

### 🏢 Cliente

- **Organización Ficticia:** EsSalud

---

### 🎯 Propósito del Proyecto

Modelar, automatizar y exponer como servicios web el proceso de **programación de citas médicas** para EsSalud, integrando BPMN (BonitaSoft Studio), arquitectura DDD y servicios REST documentados con Swagger/OpenAPI.

---

### 🌐 Visión General

- **Aplicación BPM:** Página de aplicación y menú para gestión de procesos de citas, asegurados, médicos y pacientes.
- **Automatización:** Diagramas BPMN en BonitaSoft Studio para la gestión de flujos de negocio.
- **Backend:** Servicios RESTful con Spring Boot y PostgreSQL, siguiendo DDD y arquitectura en capas.

---

### 🧱 Visión General de Arquitectura (DDD)

- **Modelo de Dominio:** Entidades como Cita, Asegurado, Médico, Paciente, Especialidad.
- **Capas:** Presentación (REST), Aplicación (Servicios), Dominio (Modelos), Infraestructura (Persistencia y externos).
- **Repositorio Backend:** [GitHub Proyecto DSE (Backend)](https://github.com/Lizardo-Castillo/Proyecto_DSE.git)
- **Repositorio BPMN:** [GitHub EsSalud_Bonita (BonitaSoft)](https://github.com/KarlaCornejo/EsSalud_Bonita.git)

---

### � Procesos de Negocio

#### 1. Consulta de Seguro
- **Descripción:** Permite validar si un paciente está asegurado antes de programar una cita.
- **Diagrama BPMN:**  
  <p align="center">
    <img src="./docs/bonita_consulta_seguro.jpeg" alt="Diagrama BPMN Consulta Seguro" width="700"/>
  </p>

#### 2. Programar Cita
- **Descripción:** Gestiona la reserva de citas médicas, validando disponibilidad y notificando al paciente.
- **Diagrama BPMN:**  
  <p align="center">
    <img src="./docs/bonita_programar_cita.jpeg" alt="Diagrama BPMN Programar Cita" width="700"/>
  </p>

---

### 🚀 Principales Servicios REST (Swagger/OpenAPI)

#### Módulo: Citas <Gestión de citas médicas>
- **Operaciones:**
  - `GET /api/citas`  
    - Listar todas las citas.
    - Parámetros: Ninguno.
  - `POST /api/citas`  
    - Registrar una nueva cita.
    - Parámetros (body JSON):
      - `apellidoMaterno` (string)
      - `apellidoPaterno` (string)
      - `correo` (string)
      - `dni` (string)
      - `especialidad` (string)
      - `fecha` (string)
      - `nombre` (string)
      - `telefono` (string)

#### Módulo: Asegurados <Gestión de asegurados>
- Registrar y consultar asegurados.

#### Módulo: Médicos <Gestión de médicos>
- Registrar y consultar médicos.

#### Módulo: Pacientes <Gestión de pacientes>
- Registrar y consultar pacientes.

#### Módulo: Notificaciones <Envío de notificaciones>
- Notificar al paciente sobre la cita.

---

### 🗂️ Modelos: Entidades y Agregados Clave

- **Cita:** { id, dni, nombre, apellidos, especialidad, fecha, correo, teléfono }
- **Asegurado:** { dni, credencial }
- **Médico:** { id, nombre, correo, especialidad, numeroColegiatura }
- **Paciente:** { id, dni, nombres, apellidos, correo, teléfono }
- **Especialidad:** { código, nombre }

---

### 🔗 URL Repositorio

- [Repositorio GitHub Proyecto DSE (Backend)](https://github.com/Lizardo-Castillo/Proyecto_DSE.git)
- [Repositorio GitHub EsSalud_Bonita (BPMN)](https://github.com/KarlaCornejo/EsSalud_Bonita.git)

---

### 🗺️ Diagrama de Composición de Servicios

- Los procesos BPMN orquestan los servicios REST de asegurados, citas, médicos y notificaciones, permitiendo la integración y automatización de la gestión de citas médicas.

### 🧱 Vista General de Arquitectura y Módulos

La estructura del proyecto está organizada según los principios de **Arquitectura Limpia**, **DDD** y el patrón **MVC**, usando las convenciones de Spring Boot y JPA.

```bash
src/
└── main/
    ├── java/
    │   └── com/
    │       └── backend/
    │           └── backend/
    │               ├── BackendApplication.java
    │               ├── controller/             # Controladores REST por módulo funcional
    │               │   ├── CitaController.java
    │               │   ├── AseguradoController.java
    │               │   ├── MedicoController.java
    │               │   ├── PacienteController.java
    │               ├── service/                # Lógica de aplicación (coordinación de casos de uso)
    │               │   ├── CitaService.java
    │               │   ├── AseguradoService.java
    │               │   ├── MedicoService.java
    │               │   ├── PacienteService.java
    │               │   ├── NotificacionService.java
    │               ├── domain/                 # Modelo de Dominio
    │               │   ├── model/              # Entidades y lógica de dominio
    │               │   │   ├── Cita.java
    │               │   │   ├── Especialidad.java
    │               │   │   ├── Asegurado.java
    │               │   │   ├── Medico.java
    │               │   │   ├── Paciente.java
    │               │   ├── repository/         # Interfaces JPA
    │               │   │   ├── CitaRepository.java
    │               │   │   ├── AseguradoRepository.java
    │               │   │   ├── MedicoRepository.java
    │               │   │   ├── PacienteRepository.java
    │               ├── infrastructure/
    │               │   ├── external/           # Conexión a servicios externos
    │               └── dto/                    # Objetos para Request y Response
    │                   ├── CitaRequest.java
    │                   ├── CitaResponse.java
    │                   ├── AseguradoRequest.java
    │                   ├── AseguradoResponse.java
    │                   ├── MedicoRequest.java
    │                   ├── MedicoResponse.java
    │                   ├── PacienteRequest.java
    │                   ├── PacienteResponse.java
    └── resources/
        ├── application.properties
        ├── static/
        ├── templates/
```

---


### 🧠 Modelo de Dominio y Procesos

- `Cita.java`: Representa una cita médica con atributos como `dni`, `fecha`, `especialidad`, `centroAsignado`, etc.
- `Asegurado.java`: Entidad para la gestión de asegurados.
- `Medico.java`: Entidad para la gestión de médicos.
- `Paciente.java`: Entidad para la gestión de pacientes.
- `Especialidad.java`: Catálogo de especialidades médicas.
- Repositorios JPA para cada entidad.


#### 📋 Modelado de Procesos BPMN
Se diseñaron diagramas de procesos en **BonitaSoft Studio** para automatizar el flujo de programación de citas, notificaciones y gestión de pacientes.

##### Diagramas BPMN implementados

<p align="center">
  <b>Consulta de Seguro</b><br>
  <img src="./docs/bonita_consulta_seguro.jpeg" alt="Diagrama BPMN Consulta Seguro" width="700"/>
</p>

<p align="center">
  <b>Programar Cita</b><br>
  <img src="./docs/bonita_programar_cita.jpeg" alt="Diagrama BPMN Programar Cita" width="700"/>
</p>

Los objetos de dominio encapsulan la lógica central y permiten separar responsabilidades entre capas de presentación, aplicación e infraestructura.

---


### 📝 Código Fuente y Control de Versiones

Todos los cambios están versionados y documentados con mensajes de commit claros en este repositorio. Se han utilizado ramas como:

- `main`: Rama estable y desplegable.
- `develop`: Rama de desarrollo principal.
- `feature/programar-cita`: Funcionalidad específica del proceso de agendamiento.
- `feature/notificaciones`: Gestión de envío de correos electrónicos al paciente.
- `feature/asegurado`, `feature/medico`, `feature/paciente`: Nuevos módulos implementados para la gestión de asegurados, médicos y pacientes.



### 📮 Pruebas y Documentación de la API

- **Swagger/OpenAPI**: Documentación interactiva disponible para todos los endpoints REST.
- **Postman**: Colección de pruebas automatizadas para los endpoints principales (`citas`, `asegurados`, `medicos`, `pacientes`).
  - 📁 Las colecciones y entornos se encuentran en la carpeta [`postman/`](./postman/):
    - `postman(Hospital).json`
    - `postman(Enviroment).json`

#### 🚀 Ejemplo de solicitud para programar cita

```json
POST /api/citas
Content-Type: application/json
{
  "dni": "12345678",
  "fecha": "2025-07-22",
  "especialidad": "Pediatría",
  "fechaDeseada": "2025-07-30"
}
```

#### ✅ Tests incluidos (Postman)

```javascript
pm.test("Código de estado 200", function () {
    pm.response.to.have.status(200);
});
pm.test("Respuesta contiene campos esperados", function () {
    const json = pm.response.json();
    pm.expect(json).to.have.property("centroAsignado");
    pm.expect(json).to.have.property("mensaje");
});
```

💡 Puedes importar la colección en Postman usando el botón **"Import"** y cargando el archivo `.json`. Luego, presiona **"Send"** para probar el endpoint directamente desde la interfaz.

---

### 📄 Notas 

- Se diseñaron y modelaron procesos BPMN en BonitaSoft Studio para la automatización de flujos.
- El backend expone endpoints REST documentados con Swagger/OpenAPI.
- Se implementaron módulos para la gestión de asegurados, médicos, pacientes y notificaciones.
- Pruebas automatizadas y ejemplos de uso disponibles en Postman.

