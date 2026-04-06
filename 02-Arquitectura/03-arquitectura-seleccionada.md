# Arquitectura Seleccionada

## 1. Decisión Arquitectónica

### Arquitectura Elegida
**Aplicación Móvil Híbrida (Flutter) + Backend Monolítico Modular (Node.js/Express) + Base de Datos Relacional (PostgreSQL)**

### Estilo Arquitectónico Principal
**Cliente-Servidor en Capas (Layered Architecture) con patrón MVC en backend y Clean Architecture en frontend**

---

## 2. Justificación de la Selección

### Alternativa Descartada
PWA (Progressive Web App) con Backend Serverless fue descartada debido a:
❌ Rendimiento insuficiente en dispositivos Android de gama baja (restricción RT-02)  
❌ Complejidad de instalación para usuarios con baja alfabetización digital (restricción RS-02)  
❌ Arquitectura distribuida demasiado compleja para equipo pequeño en tiempo limitado (RE-02, RE-03)  
❌ Costo operación impredecible (pay-per-use) vs presupuesto fijo limitado (RE-01)

### Por qué la Arquitectura Elegida Responde Mejor

#### ✅ Restricciones Económicas
- **Costo fijo predecible:** VPS $10/mes + DB gratuita (Railway/Render tier gratuito o DigitalOcean)
- **Sin sorpresas de facturación:** Costo no crece abruptamente con uso
- **Sostenible a largo plazo:** ~$10-15/mes soporta fácilmente 1000+ usuarios
- **Total estimado año 1:** ~$120-180/año (muy por debajo de $50/mes límite)

#### ✅ Restricciones Técnicas
- **RT-01 (Conectividad intermitente):** SQLite local + sincronización robusta cuando hay conexión
- **RT-02 (Dispositivos gama baja):** Flutter compila a código nativo ARM, rendimiento superior
- **RT-03 (Bajo costo infraestructura):** Infraestructura minimalista suficiente
- **RT-04 (Soporte técnico limitado):** Monolito es más fácil de monitorear y mantener

#### ✅ Atributos de Calidad Prioritarios
- **Disponibilidad offline (EC-01):** SQLite da control total, sincronización via queue
- **Rendimiento gama baja (EC-02):** Código compilado, < 3 seg carga inicial
- **Usabilidad (EC-03):** UX nativa, instalación familiar (Play Store)
- **Recomendaciones confiables (EC-05):** Motor de reglas centralizado, fácil de auditar
- **Sincronización confiable (EC-06):** Lógica de sincronización en un solo lugar
- **Seguridad (EC-07):** HTTPS, JWT, control total sobre flujo de datos

---

## 3. Arquitectura Detallada

### 3.1. Vista de Alto Nivel

```
┌─────────────────────────────────────────────────────────┐
│                    USUARIO FINAL                         │
│              (Pequeño Productor Agrícola)                │
└───────────────────────┬──────────────────────────────────┘
                        │
                        ▼
┌─────────────────────────────────────────────────────────┐
│           APLICACIÓN MÓVIL (Flutter/Dart)                │
│  ┌────────────────────────────────────────────────────┐ │
│  │         PRESENTATION LAYER (UI/UX)                 │ │
│  │  - Pantallas (Home, Cultivos, Alertas, Perfil)    │ │
│  │  - Widgets reutilizables                           │ │
│  └────────────────┬────────────────────────────────────┘ │
│  ┌────────────────┴────────────────────────────────────┐ │
│  │          BUSINESS LOGIC LAYER (BLoC/Provider)      │ │
│  │  - Gestión de estado                               │ │
│  │  - Validaciones locales                            │ │
│  │  - Lógica de sincronización                        │ │
│  └────────────────┬────────────────────────────────────┘ │
│  ┌────────────────┴────────────────────────────────────┐ │
│  │            DATA LAYER                               │ │
│  │  - Repositorios (abstracción de datos)             │ │
│  │  - Local Data Source (SQLite)                      │ │
│  │  - Remote Data Source (API REST)                   │ │
│  │  - Sincronización queue                            │ │
│  └────────────────┬────────────────────────────────────┘ │
└───────────────────┼──────────────────────────────────────┘
                    │
                    │ HTTPS/REST + JSON
                    │ JWT Authentication
                    ▼
┌─────────────────────────────────────────────────────────┐
│              BACKEND (Node.js/Express)                   │
│  ┌────────────────────────────────────────────────────┐ │
│  │              API LAYER (Routes)                    │ │
│  │  - /api/auth (login, register)                     │ │
│  │  - /api/cultivos (CRUD cultivos)                   │ │
│  │  - /api/actividades (registro actividades)         │ │
│  │  - /api/recomendaciones (obtener/generar)          │ │
│  │  - /api/alertas (obtener alertas)                  │ │
│  │  - /api/clima (proxy a API externa)                │ │
│  └────────────────┬────────────────────────────────────┘ │
│  ┌────────────────┴────────────────────────────────────┐ │
│  │           BUSINESS LOGIC LAYER (Services)          │ │
│  │  - AuthService (autenticación, autorización)       │ │
│  │  - CultivoService (lógica cultivos)                │ │
│  │  - RecomendacionService (motor de recomendaciones) │ │
│  │  - AlertaService (evaluación y envío alertas)      │ │
│  │  - ClimaService (integración APIs externas)        │ │
│  │  - SincronizacionService (manejo conflictos)       │ │
│  └────────────────┬────────────────────────────────────┘ │
│  ┌────────────────┴────────────────────────────────────┐ │
│  │           DATA ACCESS LAYER (Repositories)         │ │
│  │  - UserRepository                                   │ │
│  │  - CultivoRepository                                │ │
│  │  - ActividadRepository                              │ │
│  │  - RecomendacionRepository                          │ │
│  │  - (ORM: Sequelize o TypeORM)                      │ │
│  └────────────────┬────────────────────────────────────┘ │
│  ┌────────────────┴────────────────────────────────────┐ │
│  │           TAREAS PROGRAMADAS (Cron Jobs)           │ │
│  │  - Actualización clima cada 6 horas                │ │
│  │  - Evaluación de alertas cada 1 hora               │ │
│  │  - Generación recomendaciones diarias              │ │
│  └─────────────────────────────────────────────────────┘ │
└───────────────────┼──────────────────────────────────────┘
                    │
                    ▼
┌─────────────────────────────────────────────────────────┐
│           BASE DE DATOS (PostgreSQL)                     │
│  - Tablas: users, cultivos, actividades,                │
│    recomendaciones, alertas, clima_data                 │
└─────────────────────────────────────────────────────────┘
                    
┌─────────────────────────────────────────────────────────┐
│               SERVICIOS EXTERNOS                         │
│  - API Clima (OpenWeatherMap / IDEAM)                   │
│  - Firebase Cloud Messaging (notificaciones push)       │
└─────────────────────────────────────────────────────────┘
```

---

## 4. Tecnologías Específicas Seleccionadas

### 4.1. Frontend (Aplicación Móvil)

#### Framework: **Flutter 3.x**
**Justificación:**
- ✅ Compila a código nativo ARM (rendimiento excelente)
- ✅ Hot reload acelera desarrollo
- ✅ Widget catalog rico y customizable
- ✅ Excelente documentación y comunidad
- ✅ Multiplataforma preparado (iOS futuro sin reescribir)
- ✅ Paquetes maduros para offline (sqflite, hive)

**Alternativas consideradas:**
- React Native: Rechazado (rendimiento inferior, bridge JavaScript)
- Kotlin Nativo: Rechazado (no multiplataforma, equipo no conoce Kotlin)

#### Gestión de Estado: **BLoC (Business Logic Component) o Provider**
**Justificación:**
- Patrón reactivo, separa lógica de UI
- Estado predecible y testeable
- Recomendado por comunidad Flutter

#### Base de Datos Local: **SQLite (via sqflite package)**
**Justificación:**
- Ligero, embebido, sin servidor
- SQL estándar, relacional (familiar para equipo)
- Sincronización transparente con PostgreSQL

#### Notificaciones: **Firebase Cloud Messaging (FCM)**
**Justificación:**
- Tier gratuito generoso (millones de mensajes/mes)
- Integración sencilla con Flutter
- Soporta notificaciones incluso con app cerrada

---

### 4.2. Backend

#### Runtime: **Node.js 18 LTS**
**Justificación:**
- Ecosistema npm gigante
- JavaScript: mismo lenguaje que frontend (aunque Flutter es Dart, el JSON/REST es universal)
- Rápido para desarrollo de APIs REST
- Async/await para operaciones I/O (APIs externas, BD)

**Alternativa considerada:**
- Python (Django/Flask): Rechazado (Node.js tiene mejor ecosistema para real-time, más rápido startup)

#### Framework: **Express.js 4.x**
**Justificación:**
- Minimalista, flexible, ligero
- Middleware ecosystem rico
- Fácil de aprender y mantener
- No tiene overhead de frameworks pesados (como NestJS)

#### ORM: **Sequelize** o **TypeORM** (si se usa TypeScript)
**Justificación:**
- Abstracción de BD, previene SQL injection
- Migraciones de esquema
- Relaciones y queries complejas simplificadas

#### Autenticación: **JWT (JSON Web Tokens)**
**Justificación:**
- Stateless, no requiere sesiones en servidor
- Compatible con arquitectura REST
- Expiración configurable (24h)
- Librería madura: jsonwebtoken

#### Hashing de Contraseñas: **bcrypt**
**Justificación:**
- Estándar de industria
- Salting automático
- Resistente a ataques de fuerza bruta

---

### 4.3. Base de Datos

#### DBMS: **PostgreSQL 14+**
**Justificación:**
- ✅ Open source, sin costos de licencia
- ✅ Robusto, confiable (ACID compliant)
- ✅ Relacional: ideal para datos estructurados (usuarios, cultivos, actividades)
- ✅ Soporta JSON (flexibilidad para datos semi-estructurados)
- ✅ Escalabilidad vertical y horizontal
- ✅ Excelente con geo-datos (extensión PostGIS si se necesita)

**Alternativas consideradas:**
- MySQL: Equivalente, PostgreSQL elegido por features avanzados (JSON, extensiones)
- MongoDB (NoSQL): Rechazado (datos altamente relacionales, transacciones importantes)
- SQLite en servidor: Rechazado (no soporta concurrencia adecuadamente)

---

### 4.4. Infraestructura de Despliegue

#### Opción Recomendada: **Railway.app** (PaaS)
**Justificación:**
- ✅ Tier gratuito: $5 crédito/mes (suficiente para MVP)
- ✅ PostgreSQL incluido
- ✅ Deploy automático desde GitHub (CI/CD)
- ✅ HTTPS automático
- ✅ Sin configuración de servidores
- ✅ Logs centralizados
- ✅ Escalado vertical sencillo

**Plan de costos:**
- Mes 1-3 (MVP): Tier gratuito ($0)
- Mes 4+: Plan Starter ~$5-10/mes

**Alternativa (si Railway no es viable):**
- **Render.com:** Similar a Railway, tier gratuito (con limitaciones de sleep)
- **DigitalOcean Droplet:** VPS $6/mes (requiere más configuración manual)
- **Fly.io:** Otra buena opción PaaS

---

### 4.5. APIs Externas

#### API Climática: **OpenWeatherMap**
**Justificación:**
- Tier gratuito: 1000 llamadas/día (suficiente para 200+ usuarios con actualizaciones cada 6h)
- Datos: temperatura, precipitación, humedad, pronóstico 5 días
- Cobertura global, incluye Colombia
- API REST simple

**Fallback:** Integración con API de IDEAM (instituto colombiano) si está disponible

#### Notificaciones Push: **Firebase Cloud Messaging (FCM)**
**Justificación:**
- Tier gratuito: ilimitado
- Integración nativa con Flutter
- Confiable y rápido

---

## 5. Decisiones Arquitectónicas Clave (ADR)

### ADR-001: Selección de Metodología de Desarrollo
**Decisión:** RUP con iteraciones de 2 semanas  
**Justificación:**
- Equipo pequeño (5 personas) se beneficia de iteraciones cortas
- Feedback temprano de usuarios (asociaciones agrícolas)
- Adaptación a cambios en requisitos
- Reuniones diarias de seguimiento para coordinación

**Alternativa rechazada:** Waterfall (poco flexible para proyecto de 4 meses)

---

### ADR-002: Selección de Estilo Arquitectónico
**Decisión:** Cliente-Servidor en Capas (Monolito Modular)  
**Justificación:** Ver sección "Comparación y Trade-offs"  
**Alternativa rechazada:** Microservicios Serverless (complejidad excesiva)

---

### ADR-003: Elección de Tipo de Base de Datos
**Decisión:** Relacional (PostgreSQL)  
**Justificación:**
- Datos altamente estructurados (usuarios → cultivos → actividades)
- Relaciones 1:N y N:M (user-cultivos, cultivo-actividades)
- Necesidad de transacciones (ACID) para integridad
- Queries complejas con JOINs
- Equipo familiar con SQL

**Alternativa rechazada:** NoSQL MongoDB (menos adecuado para datos relacionales)

---

### ADR-004: Estrategia de Manejo de Conectividad
**Decisión:** Offline-First con Sincronización Eventual  
**Justificación:**
- Restricción crítica RT-01 (conectividad intermitente)
- Escenario crítico EC-01 (funcionamiento offline)
- Patrón:
  1. Todas las operaciones se guardan primero localmente (SQLite)
  2. Cola de sincronización almacena operaciones pendientes
  3. Cuando hay conexión, sincronización automática en background
  4. Resolución de conflictos: "última escritura gana" (last-write-wins) con timestamps

**Implementación:**
```dart
// Pseudocódigo Flutter
class SyncService {
  Future<void> syncPendingOperations() async {
    if (await hasConnection()) {
      final pending = await localDB.getPendingOperations();
      for (operation in pending) {
        try {
          await api.post(operation.endpoint, operation.data);
          await localDB.markAsSynced(operation.id);
        } catch (e) {
          // Retry later
        }
      }
    }
  }
}
```

---

### ADR-005: Patrón de Autenticación
**Decisión:** JWT (JSON Web Token) con expiración de 24 horas  
**Justificación:**
- Stateless: no requiere almacenar sesiones en servidor
- Ligero: solo validación de firma
- Portabilidad: funciona en móvil y web
- Estándar de industria

**Flujo:**
1. Usuario envía credenciales (documento + password)
2. Backend valida, retorna JWT
3. App almacena JWT en secure storage
4. Cada request incluye JWT en header `Authorization: Bearer <token>`
5. Backend valida JWT en cada request (middleware)

---

### ADR-006: Estructura de Módulos Backend
**Decisión:** Modularización por dominio (Domain-Driven Design ligero)  
**Estructura:**
```
backend/
├── src/
│   ├── modules/
│   │   ├── auth/
│   │   │   ├── auth.controller.js
│   │   │   ├── auth.service.js
│   │   │   ├── auth.routes.js
│   │   │   └── auth.model.js
│   │   ├── cultivos/
│   │   │   ├── cultivo.controller.js
│   │   │   ├── cultivo.service.js
│   │   │   ├── cultivo.routes.js
│   │   │   └── cultivo.model.js
│   │   ├── recomendaciones/
│   │   ├── alertas/
│   │   └── clima/
│   ├── middlewares/
│   │   ├── auth.middleware.js
│   │   ├── error.middleware.js
│   │   └── validation.middleware.js
│   ├── utils/
│   └── config/
└── app.js
```

**Justificación:**
- Separación clara de responsabilidades
- Fácil de navegar para equipo
- Preparado para eventual migración a microservicios (si es necesario)

---

## 6. Modelo de Datos Conceptual

### Entidades Principales

#### 1. **User** (Usuario/Productor)
- id (UUID)
- documento (string, unique)
- nombre (string)
- telefono (string)
- email (string, nullable)
- password_hash (string)
- municipio (string)
- vereda (string, nullable)
- created_at, updated_at

#### 2. **Cultivo**
- id (UUID)
- user_id (FK → User)
- tipo_cultivo (enum: banano, cafe, yuca, cacao, platano, etc.)
- area_hectareas (decimal)
- fecha_siembra (date)
- latitud, longitud (decimal, nullable)
- estado (enum: activo, cosechado, archivado)
- created_at, updated_at

#### 3. **Actividad**
- id (UUID)
- cultivo_id (FK → Cultivo)
- tipo_actividad (enum: riego, fertilizacion, fumigacion, poda, cosecha, observacion)
- fecha_hora (timestamp)
- descripcion (text, nullable)
- cantidad (decimal, nullable)
- unidad (string, nullable) - ej: "litros", "kg"
- foto_url (string, nullable)
- sincronizado (boolean) - para manejo offline
- created_at

#### 4. **Recomendacion**
- id (UUID)
- cultivo_id (FK → Cultivo)
- tipo_recomendacion (enum: riego, fertilizacion, fitosanitaria, general)
- titulo (string)
- descripcion (text)
- prioridad (enum: baja, media, alta, urgente)
- fecha_generacion (timestamp)
- fecha_expiracion (timestamp, nullable)
- leida (boolean)
- aplicada (boolean)
- justificacion (text) - explicación del por qué
- created_at

#### 5. **Alerta**
- id (UUID)
- user_id (FK → User, nullable para alertas generales)
- cultivo_id (FK → Cultivo, nullable)
- tipo_alerta (enum: climatica, plaga, sistema)
- titulo (string)
- mensaje (text)
- prioridad (enum: baja, media, alta, critica)
- fecha_envio (timestamp)
- leida (boolean)
- created_at

#### 6. **ClimaData** (Datos climáticos cacheados)
- id (UUID)
- municipio (string)
- latitud, longitud (decimal)
- fecha_hora (timestamp)
- temperatura (decimal)
- humedad (decimal)
- precipitacion (decimal)
- descripcion (string) - ej: "nublado"
- fuente (string) - ej: "OpenWeatherMap"
- created_at

### Relaciones
- User **1:N** Cultivo
- Cultivo **1:N** Actividad
- Cultivo **1:N** Recomendacion
- User **1:N** Alerta

---

## 7. Flujos Críticos del Sistema

### Flujo 1: Registro y Primera Configuración
1. Usuario descarga app desde Play Store
2. Abre app → Tutorial interactivo (30 seg)
3. Registro: documento, nombre, teléfono, ubicación, crear contraseña
4. Confirmación (SMS opcional)
5. Registra primer cultivo: tipo, área, fecha siembra
6. Sistema muestra dashboard con cultivo y recomendación inicial

**Tiempo esperado:** < 10 minutos

---

### Flujo 2: Generación y Entrega de Recomendación de Riego
1. **[Backend - Cron Job cada 24h]** Tarea programada se ejecuta
2. Para cada cultivo activo:
   - Obtiene datos climáticos de las últimas 24h (de ClimaData)
   - Obtiene pronóstico próximas 24-48h
   - Obtiene fase fenológica (calculada desde fecha_siembra)
   - **Motor de Recomendaciones evalúa reglas:**
     ```javascript
     if (dias_sin_lluvia > 3 && temperatura_promedio > 28 && fase == "fructificacion") {
       generar_recomendacion_riego({
         cantidad: calcular_cantidad(area, tipo_cultivo),
         momento: "mañana temprano",
         justificacion: "Sin lluvia por 3 días..."
       });
     }
     ```
3. Recomendación guardada en BD
4. Notificación push enviada al usuario (vía FCM)
5. **[App Móvil]** Usuario recibe notificación, abre app
6. Ve recomendación con título, descripción, justificación
7. Puede marcar como "aplicada" después de ejecutarla

---

### Flujo 3: Alerta Climática Urgente
1. **[Backend - Cron Job cada 1 hora]** Tarea programada chequea APIs climáticas
2. Para cada ubicación (municipio) con cultivos activos:
   - Obtiene pronóstico actualizado
   - **Motor de Alertas evalúa:**
     ```javascript
     if (probabilidad_lluvia > 80% && precipitacion_esperada > 50mm && horas_hasta_evento < 12) {
       generar_alerta({
         tipo: "climatica",
         prioridad: "critica",
         titulo: "Lluvia intensa próximas 12h",
         mensaje: "Se esperan >50mm. Proteja cultivos sensibles."
       });
     }
     ```
3. Alerta guardada en BD
4. Notificación push enviada inmediatamente (prioridad alta)
5. **[App Móvil]** Notificación aparece incluso si app está cerrada
6. Usuario toma acción preventiva

---

### Flujo 4: Trabajo Offline y Posterior Sincronización
**Escenario:** Usuario en finca sin conexión, registra 5 actividades de riego.

1. **[Sin conexión]** App detecta modo offline (indicador visible)
2. Usuario navega a "Registrar Actividad"
3. Completa formulario: tipo=riego, cantidad=20 litros, fecha=hoy
4. Presiona "Guardar" → Actividad guardada en SQLite local
5. Badge visible: "5 operaciones pendientes de sincronizar"
6. **[Recupera conexión]** App detecta conexión disponible
7. Notificación: "Sincronizando..."
8. **SyncService** ejecuta:
   ```dart
   for (actividad in pendientes) {
     try {
       await api.post('/api/actividades', actividad.toJson());
       await localDB.markAsSynced(actividad.id);
     } catch (e) {
       // Quedará para próxima sincronización
     }
   }
   ```
9. Notificación: "5 actividades sincronizadas"
10. Badge desaparece

---

## 8. Seguridad Implementada

### Nivel de Aplicación
- ✅ HTTPS obligatorio (TLS 1.2+)
- ✅ JWT con expiración (24h)
- ✅ Passwords hasheados con bcrypt (cost factor 10)
- ✅ Validación y sanitización de inputs (express-validator)
- ✅ Rate limiting en API (express-rate-limit) - protección contra brute force
- ✅ CORS configurado (solo app móvil puede acceder)
- ✅ Helmet.js para headers de seguridad HTTP

### Nivel de Base de Datos
- ✅ Prepared statements (ORM previene SQL injection)
- ✅ Principio de menor privilegio (usuario DB solo con permisos necesarios)
- ✅ Backups automáticos diarios (Railway/Render lo proveen)

### Nivel de Datos Sensibles
- ✅ Contraseñas jamás almacenadas en texto plano
- ✅ JWT firmado con secret (variable de entorno)
- ✅ Datos personales no expuestos en logs
- ✅ Cifrado en tránsito (HTTPS)

---

## 9. Estrategia de Testing

### Testing en Frontend (Flutter)
- **Unit Tests:** Lógica de negocio (BLoC, servicios)
- **Widget Tests:** Componentes individuales
- **Integration Tests:** Flujos completos (registro, login, sincronización)
- **Herramienta:** flutter_test (built-in)

### Testing en Backend (Node.js)
- **Unit Tests:** Servicios, utilidades
- **Integration Tests:** Endpoints de API
- **Herramientas:** Jest + Supertest
- **Coverage objetivo:** > 70% en lógica crítica (auth, recomendaciones, sincronización)

### Testing de Usuario
- **Usability Testing:** 10 productores reales prueban MVP
- **Métricas:** Tiempo para completar tareas, tasa de error, satisfacción (SUS)

---

## 10. Plan de Implementación (4 Meses)

### Mes 1: Fundamentos
**iteraciones 1-2**
- ✅ Setup de proyecto (repos, CI/CD)
- ✅ Diseño UI/UX (wireframes, mockups)
- ✅ Arquitectura de BD (schema, migraciones)
- ✅ Módulo de autenticación (backend + frontend)
- ✅ CRUD de cultivos (backend + frontend)
- **Entregable:** Usuario puede registrarse y crear un cultivo

### Mes 2: Núcleo del Sistema
**iteraciones 3-4**
- ✅ Registro de actividades (offline-first)
- ✅ Integración API climática (backend)
- ✅ Visualización de clima en app
- ✅ Motor básico de recomendaciones (riego)
- ✅ Sistema de notificaciones push
- **Entregable:** Usuario recibe su primera recomendación de riego

### Mes 3: Funcionalidades Complementarias
**iteraciones 5-6**
- ✅ Sincronización robusta (queue, reintentos)
- ✅ Historial de actividades
- ✅ Motor de alertas climáticas
- ✅ Recomendaciones de fertilización
- ✅ Mejoras de UX basadas en feedback
- **Entregable:** Sistema funcional con 60% de casos de uso

### Mes 4: Validación y Refinamiento
**iteraciones 7-8**
- ✅ Testing exhaustivo (unit, integration, E2E)
- ✅ Usability testing con 10 usuarios
- ✅ Corrección de bugs críticos
- ✅ Optimización de rendimiento
- ✅ Documentación (README, guías de usuario)
- ✅ Deploy a producción
- **Entregable:** Sistema validado y en Play Store

---

## 11. Monitoreo y Mantenimiento

### Herramientas de Monitoreo
- **Backend:** Logs en Railway/Render Dashboard
- **Uptime monitoring:** UptimeRobot (gratuito hasta 50 monitores)
- **Error tracking:** Sentry (tier gratuito) - captura errores no manejados
- **Analytics:** Firebase Analytics (gratuito) - uso de app, eventos

### Métricas Clave (KPIs)
- Uptime del backend (objetivo: > 99%)
- Tiempo de respuesta de API (objetivo: < 1.5s percentil 95)
- Tasa de sincronización exitosa (objetivo: > 95%)
- Tasa de retención de usuarios (7 días, 30 días)
- NPS (Net Promoter Score) de usuarios

---

## 12. Escalabilidad Futura

### Cuando se alcance ~2000 usuarios:
1. **Escalar verticalmente:** Upgrade de plan en Railway ($10 → $20/mes)
2. **Optimizar BD:** Añadir índices, queries optimizadas

### Cuando se alcance ~5000 usuarios:
1. **Evaluar migración a microservicios:**
   - Servicio de Recomendaciones (puede ser intensivo CPU)
   - Servicio de Alertas (cron jobs pesados)
   - Mantener API Gateway monolítica
2. **Caché distribuido:** Redis para reducir carga en BD
3. **CDN:** Para assets estáticos (imágenes, guías)

### Cuando se alcance 10,000+ usuarios:
1. **Kubernetes/Docker Swarm** para orquestación
2. **Load balancer** (Nginx)
3. **Base de datos replicada** (master-slave PostgreSQL)

**Nota:** Estos números son estimaciones. El monitoreo continuo determinará el momento exacto de cada escalamiento.

---

## Conclusión

La arquitectura seleccionada es:
- ✅ **Viable técnicamente** para resolver el problema
- ✅ **Asequible económicamente** (~ $10-15/mes)
- ✅ **Factible en tiempo** (4 meses con equipo de 5)
- ✅ **Sostenible a largo plazo** (mantenible, escalable hasta cierto punto)
- ✅ **Alineada con restricciones** críticas del proyecto
- ✅ **Prioriza atributos de calidad** correctos (rendimiento, usabilidad, disponibilidad)

La decisión está fundamentada en análisis riguroso, no en modas tecnológicas ni preferencias personales.



