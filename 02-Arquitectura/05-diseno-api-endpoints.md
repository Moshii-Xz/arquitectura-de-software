# Diseno de Endpoints API y Contrato JSON

## 1. Proposito

Este documento define la estructura estandar de los endpoints del backend, el flujo entre controllers y services, y el formato JSON de respuestas para toda la plataforma.

## 2. Principios de diseno

- La capa de presentacion expone la API y no contiene logica de negocio.
- La capa de servicio concentra reglas del dominio, validaciones de negocio y orquestacion.
- La capa de persistencia solo accede a datos y no construye respuestas HTTP.
- Las respuestas deben ser predecibles, uniformes y faciles de consumir por el frontend.
- Los endpoints deben ser RESTful, con recursos en plural y verbos implicitos en el metodo HTTP.

## 3. Flujo estandar entre capas

### 3.1. Secuencia general

1. El cliente consume un endpoint HTTP.
2. El controller valida estructura basica y transforma el request a DTO.
3. El controller invoca al service correspondiente.
4. El service aplica reglas de negocio y usa repositories si necesita datos.
5. El service retorna un resultado de dominio o DTO de salida.
6. El controller transforma el resultado a JSON y responde con el codigo HTTP adecuado.

### 3.2. Responsabilidad por capa

#### Controllers
- Reciben la peticion HTTP.
- Validan campos de entrada a nivel estructural.
- Mapean request/response DTOs.
- Definen codigos HTTP.
- No contienen reglas de negocio.

#### Services
- Ejecutan reglas de negocio.
- Coordinan multiples repositorios si hace falta.
- Manejan transacciones y decisiones del dominio.
- Lanzan errores funcionales o de negocio.

#### Repositories
- Consultan y persisten entidades.
- No conocen detalles del contrato HTTP.
- No construyen respuestas JSON.

## 4. Estructura base de la API

### 4.1. Prefijo comun

Todos los endpoints se publican bajo:

```text
/api/v1
```

### 4.2. Convencion de nombres

- Recursos en plural: `cultivos`, `usuarios`, `insumos`, `recomendaciones`, `reportes`, `notificaciones`.
- Verbos solo en el metodo HTTP, no en la URL.
- Subrecursos para relaciones directas: por ejemplo `cultivos/{id}/insumos`.
- Respuesta uniforme para exito y error.

## 5. Contrato JSON estandar

### 5.1. Respuesta exitosa

```json
{
  "success": true,
  "message": "Operacion realizada correctamente",
  "data": {},
  "meta": {
    "timestamp": "2026-04-28T10:15:30Z",
    "path": "/api/v1/cultivos/123"
  }
}
```

### 5.2. Respuesta con lista

```json
{
  "success": true,
  "message": "Listado consultado correctamente",
  "data": [
    {}
  ],
  "meta": {
    "page": 0,
    "size": 10,
    "totalElements": 1,
    "totalPages": 1,
    "timestamp": "2026-04-28T10:15:30Z",
    "path": "/api/v1/cultivos"
  }
}
```

### 5.3. Respuesta de error

```json
{
  "success": false,
  "message": "No fue posible completar la operacion",
  "errors": [
    {
      "code": "VALIDATION_ERROR",
      "field": "fechaSiembra",
      "detail": "La fecha de siembra no puede ser futura"
    }
  ],
  "meta": {
    "timestamp": "2026-04-28T10:15:30Z",
    "path": "/api/v1/cultivos"
  }
}
```

### 5.4. Campos estandar

- `success`: indica si la operacion fue exitosa.
- `message`: mensaje breve para usuario o consumidor.
- `data`: objeto o lista con el contenido principal.
- `errors`: lista de errores de negocio o validacion.
- `meta`: datos auxiliares de trazabilidad.

## 6. Codigos HTTP

- `200 OK`: consulta o actualizacion exitosa.
- `201 Created`: recurso creado.
- `204 No Content`: eliminacion exitosa sin cuerpo.
- `400 Bad Request`: solicitud invalida.
- `401 Unauthorized`: no autenticado.
- `403 Forbidden`: autenticado pero sin permisos.
- `404 Not Found`: recurso no encontrado.
- `409 Conflict`: conflicto de negocio o datos.
- `422 Unprocessable Entity`: validacion de negocio fallida.
- `500 Internal Server Error`: error no controlado.

## 7. DTOs y modelos de transferencia

### 7.1. Regla general

Los controllers no exponen entidades JPA directamente. Deben usar:
- `Request DTO` para entrada.
- `Response DTO` para salida.
- `Mapper` para transformar entre DTOs y entidades.

### 7.2. Ejemplo de campos frecuentes

- Identificadores: `id`, `cultivoId`, `usuarioId`.
- Trazabilidad: `createdAt`, `updatedAt`, `createdBy`.
- Estado: `estado`, `activo`, `leido`.
- Paginacion: `page`, `size`, `sort`.

## 8. Estructura por controladores

### 8.1. AuthController

Base path:

```text
/api/v1/auth
```

Endpoints sugeridos:

- `POST /login`
- `POST /logout`
- `POST /refresh-token`
- `POST /recover-password`
- `POST /reset-password`

Responsabilidad:
- Autenticar usuario.
- Emitir y renovar tokens.
- Gestionar recuperacion de contrasena.

### 8.2. UsuarioController

Base path:

```text
/api/v1/usuarios
```

Endpoints sugeridos:

- `GET /me`
- `PUT /me`
- `PUT /me/password`
- `POST /me/photo`
- `PATCH /me/preferences`
- `GET /{id}`
- `GET /`
- `POST /`
- `PUT /{id}`
- `PATCH /{id}/status`

Responsabilidad:
- Gestion de perfil y administracion de usuarios.

### 8.3. CultivoController

Base path:

```text
/api/v1/cultivos
```

Endpoints sugeridos:

- `GET /`
- `GET /{id}`
- `POST /`
- `PUT /{id}`
- `PATCH /{id}/estado`
- `DELETE /{id}`
- `POST /{id}/fotos`
- `POST /{id}/observaciones`
- `GET /{id}/historial`
- `GET /buscar`

Responsabilidad:
- CRUD de cultivos y consulta de detalle.

### 8.4. InsumoController

Base path:

```text
/api/v1/cultivos/{cultivoId}/insumos
```

Endpoints sugeridos:

- `GET /`
- `POST /`
- `PUT /{insumoAplicacionId}`
- `DELETE /{insumoAplicacionId}`
- `GET /historial`
- `GET /catalogo`

Responsabilidad:
- Registro y consulta de aplicaciones de insumos.

### 8.5. RecomendacionController

Base path:

```text
/api/v1/cultivos/{cultivoId}/recomendaciones
```

Endpoints sugeridos:

- `GET /`
- `GET /{id}`
- `POST /generar/insumos`
- `POST /generar/fertilizacion`
- `POST /generar/fitosanitarias`
- `PATCH /{id}/atender`
- `PATCH /{id}/descartar`
- `GET /historial`

Responsabilidad:
- Generar y administrar recomendaciones.

### 8.6. NotificacionController

Base path:

```text
/api/v1/notificaciones
```

Endpoints sugeridos:

- `GET /`
- `GET /no-leidas`
- `PATCH /{id}/leida`
- `DELETE /{id}`
- `GET /historial`
- `POST /sincronizar`

Responsabilidad:
- Consulta, marcacion, eliminacion y sincronizacion de notificaciones.

### 8.7. ReporteController

Base path:

```text
/api/v1/reportes
```

Endpoints sugeridos:

- `GET /cultivos`
- `GET /insumos`
- `GET /alertas`
- `GET /comparativos`
- `GET /{id}`
- `POST /{tipo}/exportar-pdf`

Responsabilidad:
- Generacion y exportacion de reportes.

## 9. Estructura interna de services

### 9.1. Regla de implementacion

Cada controller debe tener un service principal asociado, por ejemplo:
- `CultivoController` -> `CultivoService`
- `UsuarioController` -> `UsuarioService`
- `RecomendacionController` -> `RecomendacionService`
- `NotificacionController` -> `NotificacionService`
- `ReporteController` -> `ReporteService`
- `AuthController` -> `AuthService`

### 9.2. Responsabilidad de cada service

- `AuthService`: autenticar, emitir tokens, recuperar contrasena.
- `UsuarioService`: perfil, permisos, admin de cuentas.
- `CultivoService`: registro, edicion, cierre, busqueda y trazabilidad.
- `InsumoService`: registros de insumos, historial y calculos.
- `RecomendacionService`: generar, listar, atender y descartar recomendaciones.
- `NotificacionService`: notificaciones internas, leidas, sincronizacion.
- `ReporteService`: generar reportes, filtros y exportacion PDF.

## 10. Ejemplo de flujo completo

### 10.1. Crear cultivo

1. `POST /api/v1/cultivos`
2. `CultivoController` valida el JSON de entrada.
3. `CultivoController` mapea a `CultivoCreateRequest`.
4. `CultivoController` llama a `CultivoService crearCultivo(...)`.
5. `CultivoService` valida reglas de negocio.
6. `CultivoService` usa `CultivoRepository` para persistir.
7. `CultivoController` retorna `201 Created` con JSON estandar.

### 10.2. Respuesta esperada

```json
{
  "success": true,
  "message": "Cultivo creado correctamente",
  "data": {
    "id": "c4f9f1f8-77d0-4c4e-9b2a-1f9c5b7e2a10",
    "nombre": "Banano",
    "estado": "ACTIVO"
  },
  "meta": {
    "timestamp": "2026-04-28T10:15:30Z",
    "path": "/api/v1/cultivos"
  }
}
```

## 11. Regla de calidad para el backend

- Los controllers no deben contener reglas de negocio.
- Los services no deben construir respuestas HTTP.
- Los repositories no deben conocer la capa web.
- El JSON de salida debe mantenerse uniforme en toda la API.
- Los errores deben ser trazables, claros y consistentes.
