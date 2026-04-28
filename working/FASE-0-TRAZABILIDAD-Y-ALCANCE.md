# Fase 0 - Trazabilidad y Alcance Backend

**Proyecto:** Agro Inteligente Backend  
**Objetivo:** Definir el corte funcional que permita construir hasta Fase 5 con trazabilidad completa entre requisitos, dominios, endpoints y dependencias.

## 1. Base de análisis

Fuentes revisadas:
- [04-requerimientos-funcionales.md](../01-Requerimientos/04-requerimientos-funcionales.md)
- [03-arquitectura-seleccionada.md](../02-Arquitectura/03-arquitectura-seleccionada.md)
- [04-registro-decisiones-arquitectonicas.md](../02-Arquitectura/04-registro-decisiones-arquitectonicas.md)
- [07-diagrama-base-datos.puml](../03-Diagramas/07-diagrama-base-datos.puml)
- [08-diagrama-paquetes.puml](../03-Diagramas/08-diagrama-paquetes.puml)

## 2. Hallazgos de alcance

### 2.1 Cobertura real por Fases 1-5

Si se cuentan solo los RF completamente cubiertos por las Fases 1-5, el alcance queda así:
- RF-01 a RF-38: cubiertos por Auth, Perfil, Cultivos, Insumos y Recomendaciones.
- RF-45 a RF-50: cubiertos por Backoffice de Usuarios.
- Total cubierto: 44 de 56 RF.
- Cobertura estricta: 78.57%.

### 2.2 Implicación

Con un conteo estricto por número de RF, **Fases 1-5 no alcanzan solas el 80%**.
Para superar el umbral, hace falta incorporar al menos **1 RF adicional** de la Fase 6 o aceptar una cobertura ponderada por complejidad funcional.

### 2.3 Recomendación mínima para llegar al 80%

La opción más barata de incorporar es una de estas dos:
- RF-53: Contador de no leídas, porque reutiliza la entidad de notificaciones y no exige flujo complejo de UI.
- RF-39: Reporte de estado de cultivos, porque reutiliza datos ya disponibles en Cultivo y puede exponerse como consulta agregada.

Decisión tomada:
- Ejecutar Fases 1-5 y sumar **RF-53** como ajuste mínimo.
- Resultado de cobertura: **45 de 56 RF = 80.36%**.
- Motivo: es el complemento más pequeño para superar el umbral sin abrir un dominio pesado de reportes.

## 3. Matriz de trazabilidad por requisito

| RF | Dominio | Alcance backend | Entidad principal | Endpoint principal | Fase |
|----|---------|-----------------|-------------------|-------------------|------|
| RF-01 | Auth | Completo | User | POST /api/v1/auth/login | 2 |
| RF-02 | Auth | Completo | Token | POST /api/v1/auth/logout | 2 |
| RF-03 | Auth | Completo | PasswordReset | POST /api/v1/auth/forgot-password | 2 |
| RF-04 | Auth | Completo | User | PUT /api/v1/auth/change-password | 2 |
| RF-05 | Auth | Completo | LoginAttempt | Seguridad del login | 2 |
| RF-06 | Auth | Completo | Role/Permission | Seguridad y autorización | 1-2 |
| RF-07 | Auth | Completo | Token | Validación de expiración | 2 |
| RF-08 | Perfil | Completo | UserProfile | PUT /api/v1/users/profile | 2 |
| RF-09 | Perfil | Completo | UserProfile | GET /api/v1/users/profile | 2 |
| RF-10 | Perfil | Completo | UserProfile | PUT /api/v1/users/profile | 2 |
| RF-11 | Perfil | Completo | UserProfile | POST /api/v1/users/profile/photo | 2 |
| RF-12 | Perfil | Completo | UserLocation | POST /api/v1/users/location | 2 |
| RF-13 | Perfil | Completo | UserProfile | PUT /api/v1/users/language | 2 |
| RF-14 | Perfil | Completo | NotificationPreference | PUT /api/v1/users/notification-prefs | 2 |
| RF-15 | Cultivos | Completo | Crop | POST /api/v1/crops | 3 |
| RF-16 | Cultivos | Completo | Crop | GET /api/v1/crops | 3 |
| RF-17 | Cultivos | Completo | Crop | GET /api/v1/crops/{id} | 3 |
| RF-18 | Cultivos | Completo | Crop | PUT /api/v1/crops/{id} | 3 |
| RF-19 | Cultivos | Completo | CropStatusHistory | PATCH /api/v1/crops/{id}/status | 3 |
| RF-20 | Cultivos | Completo | Crop | DELETE /api/v1/crops/{id} | 3 |
| RF-21 | Cultivos | Completo | CropPhoto | POST /api/v1/crops/{id}/photos | 3 |
| RF-22 | Cultivos | Completo | CropObservation | POST /api/v1/crops/{id}/observations | 3 |
| RF-23 | Cultivos | Completo | Crop | GET /api/v1/crops/search | 3 |
| RF-24 | Insumos | Completo | InputApplication | POST /api/v1/crops/{id}/input-applications | 4 |
| RF-25 | Insumos | Completo | InputApplication | GET /api/v1/crops/{id}/input-applications | 4 |
| RF-26 | Insumos | Completo | InputApplication | PUT /api/v1/crops/{id}/input-applications/{appId} | 4 |
| RF-27 | Insumos | Completo | InputApplication | DELETE /api/v1/crops/{id}/input-applications/{appId} | 4 |
| RF-28 | Insumos | Completo | InputApplication | GET /api/v1/crops/{id}/input-costs | 4 |
| RF-29 | Insumos | Completo | Alert | Disparo automático | 4 |
| RF-30 | Insumos | Completo | Input | GET /api/v1/inputs/catalog | 4 |
| RF-31 | Recomendaciones | Completo | Recommendation | Motor de recomendación | 5 |
| RF-32 | Recomendaciones | Completo | Recommendation | Motor de recomendación | 5 |
| RF-33 | Recomendaciones | Completo | Recommendation | Motor de recomendación | 5 |
| RF-34 | Recomendaciones | Completo | Recommendation | GET /api/v1/crops/{cropId}/recommendations | 5 |
| RF-35 | Recomendaciones | Completo | Recommendation | GET /api/v1/crops/{cropId}/recommendations/{id} | 5 |
| RF-36 | Recomendaciones | Completo | Recommendation | PATCH /api/v1/crops/{cropId}/recommendations/{id}/mark-attended | 5 |
| RF-37 | Recomendaciones | Completo | Recommendation | PATCH /api/v1/crops/{cropId}/recommendations/{id}/discard | 5 |
| RF-38 | Recomendaciones | Completo | Recommendation | GET /api/v1/crops/{cropId}/recommendations/history | 5 |
| RF-39 | Reportes | Parcial o recomendado como extensión | CropReportProjection | GET /api/v1/reports/crops/status | 6 o extensión Fase 5 |
| RF-40 | Reportes | Fuera de alcance de Fase 5 | - | - | 6 |
| RF-41 | Reportes | Fuera de alcance de Fase 5 | - | - | 6 |
| RF-42 | Reportes | Fuera de alcance de Fase 5 | - | - | 6 |
| RF-43 | Reportes | Fuera de alcance de Fase 5 | - | - | 6 |
| RF-44 | Reportes | Fuera de alcance de Fase 5 | - | - | 6 |
| RF-45 | Usuarios | Completo | User | POST /api/v1/admin/users | 2 |
| RF-46 | Usuarios | Completo | User | GET /api/v1/admin/users | 2 |
| RF-47 | Usuarios | Completo | User | PUT /api/v1/admin/users/{id} | 2 |
| RF-48 | Usuarios | Completo | User | PATCH /api/v1/admin/users/{id}/deactivate | 2 |
| RF-49 | Usuarios | Completo | User | PATCH /api/v1/admin/users/{id}/reactivate | 2 |
| RF-50 | Usuarios | Completo | AuditLog | GET /api/v1/admin/users/{id}/activity | 2 |
| RF-51 | Notificaciones | Fuera de alcance de Fase 5 | Notification | - | 6 |
| RF-52 | Notificaciones | Fuera de alcance de Fase 5 | Notification | - | 6 |
| RF-53 | Notificaciones | Incluido como ajuste mínimo para superar 80% | Notification | GET /api/v1/notifications/unread-count | 5+ |
| RF-54 | Notificaciones | Fuera de alcance de Fase 5 | SyncQueue | - | 6 |
| RF-55 | Notificaciones | Fuera de alcance de Fase 5 | Notification | - | 6 |
| RF-56 | Notificaciones | Fuera de alcance de Fase 5 | Notification | - | 6 |

## 4. Dependencias entre fases

### Fase 1
Base transversal obligatoria:
- Configuración de proyecto
- Seguridad JWT
- ApiResponse / ErrorResponse
- Excepciones globales
- OpenAPI
- Flyway base

### Fase 2
Depende de Fase 1 para:
- JWT
- @PreAuthorize
- manejo uniforme de errores
- validación de DTOs

### Fase 3
Depende de Fase 2 para:
- usuario autenticado
- ownership de cultivos
- roles de negocio

### Fase 4
Depende de Fase 3 para:
- asociación de insumos a cultivos
- cálculo de costos por cultivo
- alertas por aplicación de insumo

### Fase 5
Depende de Fase 3 y Fase 4 para:
- recomendaciones basadas en ciclo del cultivo
- recomendaciones basadas en condiciones y aplicaciones de insumos
- historial y estados de recomendaciones

### Ajuste mínimo adicional
RF-53 depende de Fase 5 por reutilización de la capa de notificaciones y del usuario autenticado.

## 5. Corte recomendado para arrancar desarrollo

### Opción A - Corte estricto por RF
- Mantener Fases 1-5 como están.
- Aceptar cobertura de 78.57%.
- No recomendado si el objetivo es cumplir el 80% de forma literal.

### Opción B - Corte recomendado
- Mantener Fases 1-5.
- Añadir un solo RF de apoyo: RF-53.
- Resultado: cobertura mínima supera el 80%.
- Recomendación confirmada: añadir RF-53 para mantener el cambio pequeño y directo.

## 6. Decisión pendiente para tu confirmación

Confirma una de estas dos rutas:
- **Ruta 1:** seguimos con Fases 1-5 tal como están y aceptamos cobertura estricta de 78.57%.
- **Ruta 2:** seguimos con Fases 1-5 + RF-53 para superar el 80%.

---

**Estado:** listo para validación antes de pasar a Fase 1.
