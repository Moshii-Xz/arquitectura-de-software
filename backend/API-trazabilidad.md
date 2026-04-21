# Trazabilidad de API

## Autenticación

- `POST /api/auth/registro` -> Caso de uso: Crear cuenta de usuario. Cumple RF-001.
- `POST /api/auth/login` -> Caso de uso: Inicio de sesión. Cumple RF-002.

## Usuarios y perfil

- `GET /api/usuarios` -> Caso de uso: Listar usuarios. Cumple RF-026 del módulo administrativo.
- `GET /api/usuarios/{id}` -> Caso de uso: Consultar usuario.
- `PUT /api/usuarios/{id}` -> Caso de uso: Editar datos de usuario. Cumple RF-003.
- `DELETE /api/usuarios/{id}` -> Caso de uso: Desactivar cuenta.
- `PUT /api/usuarios/{id}/reactivar` -> Caso de uso: Reactivar cuenta.
- `GET /api/usuarios/{id}/perfil` -> Caso de uso: Consultar perfil. Cumple RF-003.
- `PUT /api/usuarios/{id}/perfil` -> Caso de uso: Actualizar perfil. Cumple RF-003.
- `PUT /api/usuarios/{id}/password` -> Caso de uso: Cambiar contraseña. Cumple RF-003 y ESC-SEG-01.

## Cultivos

- `GET /api/cultivos` -> Caso de uso: Listar cultivos. Cumple RF-004 y RF-007.
- `GET /api/cultivos/{id}` -> Caso de uso: Consultar detalle del cultivo. Cumple RF-005.
- `POST /api/cultivos` -> Caso de uso: Registrar cultivo. Cumple RF-004.
- `PUT /api/cultivos/{id}` -> Caso de uso: Editar cultivo. Cumple RF-006.
- `DELETE /api/cultivos/{id}` -> Caso de uso: Archivar/cerrar cultivo. Cumple RF-007.

## Insumos

- `GET /api/insumos` -> Caso de uso: Listar catálogo de insumos. Cumple RF-012 y RF-024 de catálogo administrativo.
- `GET /api/insumos/{id}` -> Caso de uso: Consultar detalle de insumo.
- `POST /api/insumos` -> Caso de uso: Registrar insumo.
- `PUT /api/insumos/{id}` -> Caso de uso: Actualizar insumo.
- `DELETE /api/insumos/{id}` -> Caso de uso: Eliminar lógicamente insumo.
- `GET /api/insumos/cultivos/{cultivoId}/aplicaciones` -> Caso de uso: Historial de aplicaciones.
- `POST /api/insumos/cultivos/{cultivoId}/aplicaciones` -> Caso de uso: Registrar aplicación de insumo. Cumple RF-015.
- `PUT /api/insumos/aplicaciones/{aplicacionId}` -> Caso de uso: Editar aplicación de insumo.
- `DELETE /api/insumos/aplicaciones/{aplicacionId}` -> Caso de uso: Eliminar aplicación de insumo.

## Recomendaciones

- `GET /api/recomendaciones` -> Caso de uso: Consultar recomendaciones activas. Cumple RF-011 a RF-014.
- `GET /api/recomendaciones/{id}` -> Caso de uso: Ver detalle de recomendación.
- `POST /api/recomendaciones` -> Caso de uso: Generar recomendación.
- `PUT /api/recomendaciones/{id}` -> Caso de uso: Actualizar recomendación.
- `DELETE /api/recomendaciones/{id}` -> Caso de uso: Eliminar recomendación.
- `GET /api/recomendaciones/activas` -> Caso de uso: Consultar recomendaciones activas.
- `GET /api/recomendaciones/historial` -> Caso de uso: Consultar historial de recomendaciones.
- `PUT /api/recomendaciones/{id}/atender` -> Caso de uso: Marcar como atendida.
- `PUT /api/recomendaciones/{id}/descartar` -> Caso de uso: Descartar recomendación.

## Reportes

- `GET /api/reportes` -> Caso de uso: Listar reportes.
- `GET /api/reportes/{id}` -> Caso de uso: Consultar detalle de reporte.
- `POST /api/reportes` -> Caso de uso: Generar reporte. Cumple RF-030 y RF-031.
- `DELETE /api/reportes/{id}` -> Caso de uso: Eliminar lógicamente reporte.

## Clima

- `GET /api/clima` -> Caso de uso: Visualizar condiciones climáticas. Cumple RF-008, RF-009 y RF-010.
- `GET /api/clima/cultivos/{cultivoId}` -> Caso de uso: Obtener clima asociado a un cultivo. Cumple RF-008.

## Notificaciones

- `GET /api/notificaciones` -> Caso de uso: Centro de notificaciones. Cumple RF-020.
- `GET /api/notificaciones?usuarioId=...` -> Caso de uso: Filtrar por usuario.
- `POST /api/notificaciones` -> Caso de uso: Registrar notificación.
- `PUT /api/notificaciones/{id}/leida` -> Caso de uso: Marcar notificación como leída.
- `DELETE /api/notificaciones/{id}` -> Caso de uso: Eliminación lógica.

## Ejemplos

### Registro

```json
POST /api/auth/registro
{
  "documento": "123456789",
  "nombres": "Ana",
  "apellidos": "Pérez",
  "telefono": "3001234567",
  "municipio": "Ciénaga",
  "vereda": "Cordobita",
  "email": "ana@example.com",
  "password": "Password123"
}
```

### Crear cultivo

```json
POST /api/cultivos
{
  "usuarioId": "b1c5d7e9-1111-2222-3333-444455556666",
  "tipoCultivo": "Café",
  "nombreLote": "Lote Norte",
  "areaHectareas": 2.5,
  "variedad": "Castillo",
  "fechaSiembra": "2026-04-21",
  "municipio": "Ciénaga",
  "vereda": "Cordobita",
  "estado": "ACTIVO"
}
```

### Crear insumo

```json
POST /api/insumos
{
  "nombre": "Fertilizante NPK",
  "tipo": "FERTILIZANTE",
  "unidad": "kg",
  "impactoAmbiental": false,
  "costoReferencia": 25000,
  "descripcion": "Fertilizante compuesto de uso general"
}
```

### Respuesta de clima

```json
{
  "temperatura": 31.5,
  "humedad": 78.0,
  "precipitacion": 2.4,
  "viento": 12.0,
  "resumen": "Datos simulados: Integración externa no disponible",
  "pronostico": ["Hoy con lluvias leves", "Mañana parcialmente nublado", "Siguiente día estable"],
  "actualizacion": "2026-04-21T09:00:00"
}
```