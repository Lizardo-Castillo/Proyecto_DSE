## 🏥 Repositorio del Proyecto: **Programación de Citas Médicas - EsSalud**

### 📌 Propósito

Este proyecto tiene como objetivo modelar, implementar y documentar el proceso de negocio **"Programar una Cita Médica"** utilizando prácticas de **DDD (Domain-Driven Design)** y una arquitectura basada en capas, mediante el framework **Spring Boot** y una base de datos **PostgreSQL**. Se busca mejorar la modularidad, escalabilidad y mantenibilidad del sistema de agendamiento de citas médicas para la organización **EsSalud**.

---

### 🧱 Vista General de Arquitectura

La estructura del proyecto está organizada según los principios de **Arquitectura Limpia**, **DDD** y el patrón **MVC**, usando las convenciones de Spring Boot y JPA.

```bash
src/
└── main/
    ├── java/
    │   └── com/
    │       └── backend/
    │           └── backend/
    │               ├── AgendaApplication.java
    │               ├── config/                 # Configuraciones globales (CORS, Beans, etc.)
    │               ├── controller/             # Controladores REST por módulo funcional
    │               │   ├── CitaController.java
    │               ├── service/                # Lógica de aplicación (coordinación de casos de uso)
    │               │   ├── CitaService.java
    │               │   ├── impl/
    │               │       ├── CitaServiceImpl.java
    │               ├── domain/                 # Modelo de Dominio
    │               │   ├── model/              # Entidades y lógica de dominio
    │               │   │   ├── Cita.java
    │               │   │   ├── Especialidad.java
    │               │   ├── repository/         # Interfaces JPA
    │               │   │   ├── CitaRepository.java
    │               ├── infrastructure/
    │               │   ├── external/           # Conexión a servicios externos
    │               │   │   ├── NotificacionClient.java
    │               │   │   ├── ReferenciaClient.java
    │               └── dto/                    # Objetos para Request y Response
    │                   ├── CitaRequest.java
    │                   ├── CitaResponse.java
    └── resources/
        ├── application.properties
        ├── static/
        ├── templates/
```

---

### 🧠 Modelo de Dominio

* `Cita.java`: Representa una cita médica con atributos como `dni`, `fecha`, `especialidad` y `centroAsignado`.
* `Especialidad.java`: Contiene el catálogo de especialidades médicas.
* `CitaRepository.java`: Interfaz JPA para persistencia de citas.

Los objetos de dominio encapsulan la lógica central y permiten separar responsabilidades entre capas de presentación, aplicación e infraestructura.

---

### 📝 Código Fuente y Commits

Todos los cambios están versionados y documentados con mensajes de commit claros en este repositorio. Se han utilizado ramas como:

* `main`: Rama estable y desplegable.
* `develop`: Rama de desarrollo principal.
* `feature/programar-cita`: Funcionalidad específica del proceso de agendamiento.
* `feature/notificaciones`: Gestión de envío de correos electrónicos al paciente.


### 📮 Pruebas con Postman

Para probar el endpoint `POST /api/citas`, se ha creado una colección de Postman lista para importar. Incluye un ejemplo de solicitud y tests automatizados que verifican el comportamiento de la API.

📁 La colección se encuentra en la carpeta [`postman/`](./postman/) del repositorio:

```
postman/
└── postman(Hospital).json
```

#### 🚀 Ejemplo de solicitud

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

#### ✅ Tests incluidos

```javascript
pm.test("Código de estado 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Respuesta contiene los campos esperados", function () {
    const json = pm.response.json();
    pm.expect(json).to.have.property("asegurado");
    pm.expect(json).to.have.property("estado");
    pm.expect(json).to.have.property("centroAsignado");
    pm.expect(json).to.have.property("fechaConfirmada");
    pm.expect(json).to.have.property("mensaje");
});
```

💡 Puedes importar la colección en Postman usando el botón **"Import"** y cargando el archivo `.json`. Luego, presiona **"Send"** para probar el endpoint directamente desde la interfaz.

