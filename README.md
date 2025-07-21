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
// ➤ Body de la solicitud
{
  "paciente": "Juan Pérez",
  "especialidad": "Pediatría",
  "fecha": "2025-07-22"
}

// ➤ Respuesta esperada
{
  "centroAsignado": "Centro Médico Sur",
  "mensaje": "Su cita ha sido registrada correctamente"
}
