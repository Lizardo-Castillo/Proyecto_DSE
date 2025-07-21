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

# 📋 Informe de Pruebas API - Sistema de Citas Médicas

Este informe documenta las pruebas realizadas al endpoint de programación de citas médicas (`/citas`) utilizando el método `POST`. Las pruebas se llevaron a cabo en un entorno de pruebas API (como Postman o similar).

---

## ⚙️ Configuración del Entorno

- **URL Base:** `https://c86702cb-c8bb-4b35-9248-cb...` *(valor dinámico)*
- **Entorno:** `LocalDev - Mock Proyecto_DSE`
---

## 🧪 Caso de Prueba: Programar Cita

### 🔹 Request

- **Método:** `POST`  
- **Endpoint:** `/citas`  
- **Headers:**
  - `Authorization`: *No especificado*
  - *8 headers adicionales no detallados*
- **Body + Response (JSON):**

```json
{
  "paciente": "Juan Pérez",
  "especialidad": "Pediatría",
  "fecha": "2025-07-22"
}

{
  "centroAsignado": "Centro Médico Sur",
  "mensaje": "Su cita ha sido registrada correctamente"
}
```

📊 Resultados de las Pruebas

<img width="577" height="267" alt="Image" src="https://github.com/user-attachments/assets/b85cd1c5-faae-434a-8b13-a03a22b81007" />

<img width="787" height="162" alt="Image" src="https://github.com/user-attachments/assets/6d504828-8005-41e8-8a11-da6e83acc8f7" />
