# Registro de Decisiones Arquitectónicas (ADR)

## Introducción

Este documento registra las decisiones arquitectónicas clave tomadas durante el diseño del sistema. Cada decisión está documentada siguiendo el formato ADR (Architecture Decision Record) para mantener trazabilidad y facilitar futuras revisiones.

---

## ADR-001: Selección de Metodología de Desarrollo

### Estado
**Aceptada** - 10 de Marzo 2026

### Contexto
El proyecto debe completarse en 4 meses con un equipo de 5 personas. Necesitamos una metodología que permita adaptabilidad, entregas incrementales y validación temprana con stakeholders.

### Decisión
Adoptar **RUP** con iteraciones de 2 semanas.

### Justificación
- **Iteraciones cortas:** Permiten adaptación rápida a cambios de requisitos
- **Feedback continuo:** Revision de iteraciones cada 2 semanas con stakeholders
- **Transparencia:** Reuniones diarias de seguimiento mejoran coordinación en equipo pequeño
- **Experiencia del equipo:** Equipo tiene experiencia previa con RUP
- **Entregas incrementales:** MVP en 2 meses, luego mejoras continuas
- **Gestión de riesgos:** Identificación temprana de problemas

### Alternativas Consideradas
1. **Waterfall (Cascada)**
   - ❌ Rechazada: Poco flexible, difícil adaptarse a cambios
   - ❌ Feedback tardío (solo al final)
   - ❌ Alto riesgo de no cumplir expectativas

2. **Kanban**
   - ⚠️ Considerada: Útil para flujo continuo
   - ❌ Rechazada: Menos estructura que RUP, no hay iteraciones definidas
   - ❌ Equipo prefiere time-boxes claros

### Consecuencias

#### Positivas
- ✅ Entregables claros cada 2 semanas
- ✅ Riesgos identificados tempranamente
- ✅ Equipo motivado por ciclos cortos de feedback
- ✅ Posibilidad de pivotar si algo no funciona

#### Negativas
- ⚠️ Overhead de ceremonias (planning, review, retro) - ~4h cada 2 semanas
- ⚠️ Requiere disciplina para mantener iteraciones consistentes
- ⚠️ Product Owner (profesor/stakeholders) debe estar disponible

### Notas
- Reuniones diarias de seguimiento a las 9:00 AM (15 minutos)
- Revision de Iteracion abierta a stakeholders externos
- Lecciones aprendidas de iteracion enfocadas en mejora continua

---

## ADR-002: Selección de Estilo Arquitectónico

### Estado
**Aceptada** - 10 de Marzo 2026

### Contexto
Necesitamos definir el estilo arquitectónico que mejor responda a:
- Restricción de conectividad intermitente (RT-01)
- Dispositivos de gama baja (RT-02)
- Equipo pequeño con tiempo limitado (RE-02, RE-03)
- Bajo costo de operación (RE-01)

### Decisión
Adoptar **Arquitectura Cliente-Servidor en Capas (Layered Architecture)** con **Monolito Modular** en backend.

### Justificación
- **Simplicidad:** Equipo de 5 personas puede entender y mantener fácilmente
- **Tiempo de desarrollo:** 4 meses es limitado, monolito acelera desarrollo
- **Costo predecible:** VPS de $10/mes soporta hasta 1000+ usuarios
- **Debugging centralizado:** Logs en un solo lugar
- **Escalabilidad suficiente:** Soporta crecimiento inicial sin complejidad prematura
- **Experiencia del equipo:** Todos conocen arquitecturas en capas

### Arquitectura Específica
```
┌──────────────────┐
│   Presentation   │ (Flutter App)
└────────┬─────────┘
         │ REST/JSON
┌────────┴─────────┐
│   API Layer      │ (Express Routes)
├──────────────────┤
│  Business Logic  │ (Services)
├──────────────────┤
│  Data Access     │ (Repositories + ORM)
├──────────────────┤
│    Database      │ (PostgreSQL)
└──────────────────┘
```

### Alternativas Consideradas

1. **Microservicios con Backend Serverless**
   - ❌ Rechazada: Demasiado compleja para equipo pequeño
   - ❌ Costo impredecible (pay-per-use)
   - ❌ Debugging distribuido difícil
   - ❌ Overhead de comunicación entre servicios
   - ❌ Learning curve alta (AWS Lambda, API Gateway, etc.)

2. **Arquitectura Monolítica sin Modularización**
   - ⚠️ Considerada: Más simple aún
   - ❌ Rechazada: Dificulta mantenimiento y escalabilidad futura
   - ❌ No permite eventual migración a microservicios si es necesario

3. **Backend as a Service (BaaS) - Firebase/Supabase**
   - ⚠️ Considerada: Muy rápido de implementar
   - ❌ Rechazada: Vendor lock-in severo
   - ❌ Menos control sobre lógica compleja (motor de recomendaciones)
   - ❌ Costo puede crecer inesperadamente

### Consecuencias

#### Positivas
- ✅ Desarrollo rápido (un solo repo backend)
- ✅ Despliegue simple (un servidor, una BD)
- ✅ Costo fijo y predecible
- ✅ Debugging sencillo (stack traces completos)
- ✅ Transacciones ACID simples

#### Negativas
- ⚠️ Escalabilidad limitada (vertical scaling hasta cierto punto)
- ⚠️ No se puede escalar servicios independientemente
- ⚠️ Un bug puede afectar toda la aplicación
- ⚠️ Eventual refactoring necesario si crece mucho (>5000 usuarios)

### Plan de Mitigación de Negativos
- **Modularización desde día 1:** Separación clara de módulos por dominio
- **Separación de responsabilidades:** Capas bien definidas
- **Monitoreo:** Logs y métricas desde el inicio
- **Testing:** Cobertura >70% para facilitar futuros refactorings

---

## ADR-003: Selección de Base de Datos

### Estado
**Aceptada** - 10 de Marzo 2026

### Contexto
Necesitamos almacenar datos estructurados: usuarios, cultivos, actividades, recomendaciones. Los datos tienen relaciones claras (1:N, N:M) y requieren integridad transaccional.

### Decisión
Utilizar **PostgreSQL 14+** como base de datos relacional principal.

### Justificación
- **Datos relacionales:** Usuarios → Cultivos → Actividades (relaciones claras)
- **Integridad referencial:** Foreign keys, constraints
- **ACID compliant:** Transacciones confiables
- **Open source:** Sin costos de licencia
- **Maduro y estable:** Comunidad grande, documentación excelente
- **Flexibilidad:** Soporte de JSON para datos semi-estructurados
- **Escalabilidad:** Maneja millones de registros eficientemente
- **Equipo familiarizado:** Todos conocen SQL

### Alternativas Consideradas

1. **MongoDB (NoSQL Document Store)**
   - ⚠️ Considerada: Flexible, esquema dinámico
   - ❌ Rechazada: Datos son altamente relacionales
   - ❌ JOINs complejos no son el fuerte de MongoDB
   - ❌ Transacciones ACID más complejas
   - ❌ Menos apropiado para este caso de uso

2. **MySQL**
   - ✅ Muy similar a PostgreSQL
   - ⚠️ Rechazada (por poco): PostgreSQL tiene mejores features (JSON, extensiones)
   - ⚠️ PostgreSQL tiene mejor manejo de concurrencia
   - ⚠️ Decisión marginal, cualquiera funcionaría bien

3. **SQLite (solo en servidor)**
   - ❌ Rechazada: No soporta concurrencia adecuadamente
   - ❌ No es apropiado para servidor web con múltiples usuarios
   - ✅ Nota: SÍ se usa en app móvil para almacenamiento local

### Esquema de Base de Datos
Ver [05-base-de-datos.puml](../03-Diagramas/05-base-de-datos.puml) para diagrama completo.

**Tablas principales:**
- `users` (usuarios/productores)
- `cultivos` (cultivos registrados)
- `actividades` (registro de actividades)
- `recomendaciones` (recomendaciones generadas)
- `alertas` (alertas enviadas)
- `clima_data` (caché de datos climáticos)
- `tipos_cultivo_config` (configuración de tipos de cultivo)

### Consecuencias

#### Positivas
- ✅ Queries complejas con JOINs eficientes
- ✅ Integridad de datos garantizada
- ✅ Transacciones confiables
- ✅ Herramientas de administración maduras (pgAdmin, etc.)
- ✅ Backups y replicación bien soportados
- ✅ Extensiones (PostGIS si se necesitan geo-queries avanzadas)

#### Negativas
- ⚠️ Esquema menos flexible (migraciones necesarias para cambios)
- ⚠️ Escalabilidad horizontal más compleja que NoSQL
- ⚠️ Requiere más planificación inicial del esquema

---

## ADR-004: Estrategia de Manejo de Conectividad Intermitente

### Estado
**Aceptada** - 10 de Marzo 2026

### Contexto
**Restricción crítica (RT-01):** Los usuarios operan en zonas rurales con conectividad intermitente o nula. El sistema debe funcionar offline.

**Escenario crítico (EC-01):** 100% de operaciones críticas deben estar disponibles sin conexión.

### Decisión
Implementar patrón **Offline-First con Sincronización Eventual (Eventual Consistency)**.

### Arquitectura de Sincronización

```
┌─────────────────────┐
│   App Móvil         │
│  ┌───────────────┐  │
│  │ SQLite Local  │  │
│  │ (Source of    │  │
│  │  Truth local) │  │
│  └───────┬───────┘  │
│          │          │
│  ┌───────┴───────┐  │
│  │ Sync Queue    │  │
│  │ (Pending ops) │  │
│  └───────┬───────┘  │
└──────────┼──────────┘
           │
           │ Detecta conexión
           │
┌──────────┼──────────┐
│  ┌───────▼───────┐  │
│  │ Sync Service  │  │
│  │ (Bidireccional│  │
│  └───────┬───────┘  │
│          │          │
│  ┌───────▼───────┐  │
│  │ Backend API   │  │
│  └───────┬───────┘  │
│  ┌───────▼───────┐  │
│  │ PostgreSQL    │  │
│  └───────────────┘  │
└─────────────────────┘
```

### Principios de Diseño

1. **Local-First:** Todas las operaciones se guardan primero en SQLite local
2. **Queue de Sincronización:** Operaciones pendientes se almacenan con timestamp y orden
3. **Sincronización Automática:** Cuando se detecta conexión, sync en background
4. **Sincronización Manual:** Usuario puede forzar sync también
5. **Resolución de Conflictos:** Last-Write-Wins (LWW) basado en timestamps

### Flujo de Sincronización

#### Operación Offline (Escritura)
1. Usuario registra actividad
2. App guarda en SQLite con flag `sincronizado = false`
3. Se añade a queue de sincronización
4. UI muestra badge "X pendientes"

#### Sincronización (Cuando hay conexión)
1. App detecta conexión disponible
2. SyncService lee todas las operaciones pendientes
3. Para cada operación:
   - Envía POST/PUT al backend
   - Si éxito: marca como `sincronizado = true` en SQLite
   - Si fallo: deja para próxima sincronización, log error
4. Descarga datos nuevos desde servidor (recomendaciones, alertas)
5. Actualiza SQLite local
6. Notifica usuario: "Sincronización completada"

#### Resolución de Conflictos
- **Estrategia:** Last-Write-Wins (LWW)
- **Implementación:** Timestamps en todos los registros (`updated_at`)
- **Regla:** Si hay conflicto, la escritura más reciente gana
- **Casos edge:** Muy raros (usuario no suele modificar mismo registro desde múltiples dispositivos)

### Justificación
- **Continuidad de servicio:** Usuario no se bloquea por falta de conexión
- **Experiencia de usuario:** Operación inmediata, sync transparente
- **Integridad:** Datos no se pierden, sincronización garantizada
- **Simplicidad:** LWW es simple de implementar y suficiente para este caso

### Alternativas Consideradas

1. **Always-Online (Sin funcionalidad offline)**
   - ❌ Rechazada: Inaceptable dado RT-01 y EC-01
   - ❌ Sistema inutilizable en zonas rurales

2. **Sincronización con CRDT (Conflict-free Replicated Data Types)**
   - ⚠️ Considerada: Resolución automática de conflictos más sofisticada
   - ❌ Rechazada: Complejidad muy alta para el beneficio
   - ❌ Overhead en tiempo de desarrollo
   - ❌ Casos de conflicto son raros en este dominio

3. **Sincronización Solo Manual**
   - ⚠️ Considerada: Usuario controla cuándo sincronizar
   - ❌ Rechazada: UX inferior, usuario puede olvidar sincronizar
   - ✅ Se mantiene como opción adicional (botón de sync manual)

### Consecuencias

#### Positivas
- ✅ Sistema completamente funcional offline
- ✅ Usuario no percibe latencia de red
- ✅ Datos protegidos contra pérdida (todo local primero)
- ✅ Sincronización transparente y automática

#### Negativas
- ⚠️ Complejidad de implementación (queue, detección de conexión, retry logic)
- ⚠️ Posibles conflictos (mitigado con LWW)
- ⚠️ Datos locales pueden quedar desincronizados si usuario nunca conecta
- ⚠️ Tamaño de BD local puede crecer (mitigación: archivado de datos antiguos)

### Métricas de Validación
Ver escenario crítico [EC-06](../01-Requerimientos/06-escenarios-criticos.md#-ec-06-sincronización-confiable-de-datos-offline) para criterios de aceptación:
- 100% de datos sincronizados correctamente
- 0% pérdida de datos
- 0% duplicaciones
- < 30 seg para sincronización típica (20 registros)

---

## ADR-005: Selección de Framework Frontend (Móvil)

### Estado
**Aceptada** - 10 de Marzo 2026

### Contexto
Necesitamos framework para desarrollar aplicación móvil que:
- Tenga excelente rendimiento en dispositivos gama baja (RT-02, EC-02)
- Soporte funcionalidad offline robusta
- Permita desarrollo rápido (4 meses)
- Idealmente sea multiplataforma (iOS futuro)

### Decisión
Utilizar **Flutter 3.x** (framework de Google, lenguaje Dart).

### Justificación
- **Rendimiento:** Compila a código nativo ARM (no hay bridge JavaScript como React Native)
- **UX nativa:** Widgets propios que se ven nativos en cada plataforma
- **Hot Reload:** Acelera desarrollo dramáticamente (cambios en < 1 segundo)
- **Multiplataforma:** iOS, Android, Web desde mismo código base (~90% compartido)
- **Ecosistema maduro:** Packages para SQLite (sqflite), HTTP, notificaciones, etc.
- **Documentación excelente:** flutter.dev tiene tutoriales, guías, ejemplos
- **Comunidad activa:** Stack Overflow, GitHub, Discord
- **Experiencia del equipo:** 2 miembros tienen experiencia con Flutter

### Alternativas Consideradas

1. **React Native**
   - ⚠️ Considerada: También multiplataforma, ecosistema grande
   - ❌ Rechazada: Rendimiento inferior (bridge JavaScript-Nativo)
   - ❌ En dispositivos gama baja, el bridge genera lag notable
   - ❌ Configuración inicial más compleja

2. **Kotlin Nativo (Android puro)**
   - ✅ Ventaja: Rendimiento máximo
   - ❌ Rechazada: Solo Android, no hay iOS
   - ❌ Dos codebases si se quiere iOS después
   - ❌ Equipo no tiene experiencia con Kotlin

3. **PWA (Progressive Web App)**
   - ⚠️ Considerada: Multiplataforma inmediato, actualización automática
   - ❌ Rechazada: Rendimiento inferior en gama baja (JavaScript en navegador)
   - ❌ Instalación desde navegador confunde a usuarios rurales (RS-02)
   - ❌ Acceso limitado a features nativas

### Stack Técnico Flutter

- **Lenguaje:** Dart 3.0+
- **Gestión de Estado:** BLoC (Business Logic Component) o Provider
- **Base de Datos Local:** sqflite (SQLite)
- **HTTP Client:** http package
- **Almacenamiento Clave-Valor:** shared_preferences
- **Notificaciones:** firebase_messaging
- **Routing:** go_router o Navigator 2.0

### Consecuencias

#### Positivas
- ✅ Rendimiento excelente (código compilado a nativo)
- ✅ Hot reload acelera desarrollo (iteraciones rápidas)
- ✅ Una sola codebase para Android + iOS
- ✅ Widgets personalizables (Material Design + Cupertino)
- ✅ Offline-first fácil de implementar (sqflite)
- ✅ Excelente para MVP rápido

#### Negativas
- ⚠️ Tamaño del APK puede ser mayor (~20-30 MB, pero aceptable)
- ⚠️ Algunos packages nativos requieren configuración de Kotlin/Swift
- ⚠️ Dart es menos popular que JavaScript (pero fácil de aprender)

### Métricas de Validación
- Tiempo de carga inicial: < 3 seg en Samsung Galaxy A03
- Consumo de RAM: < 150 MB
- Tamaño APK: < 30 MB
- Frame rate: 30 FPS mínimo constante

---

## ADR-006: Selección de Stack Backend

### Estado
**Aceptada** - 10 de Marzo 2026

### Contexto
Necesitamos tecnología backend que:
- Sea apropiada para APIs REST
- Permita desarrollo rápido
- Tenga buena performance
- Equipo tenga experiencia

### Decisión
Utilizar **Node.js 18 LTS + Express.js 4.x**.

### Justificación
- **Ecosistema npm:** Miles de librerías disponibles
- **APIs REST simples:** Express es minimalista y flexible
- **Async/await:** Manejo natural de operaciones I/O (BD, APIs externas)
- **Rendimiento:** V8 engine es rápido
- **JSON nativo:** JavaScript maneja JSON perfectamente
- **Experiencia del equipo:** Todos conocen JavaScript
- **Comunidad gigante:** Recursos, tutoriales, Stack Overflow

### Stack Específico

- **Runtime:** Node.js 18 LTS
- **Framework:** Express.js 4.x
- **ORM:** Sequelize (para PostgreSQL)
- **Autenticación:** jsonwebtoken (JWT)
- **Validación:** express-validator
- **Password Hashing:** bcrypt
- **Cron Jobs:** node-cron
- **HTTP Client:** axios (para APIs externas)
- **Logging:** winston
- **Testing:** Jest + Supertest

### Alternativas Consideradas

1. **Python (Django / Flask)**
   - ⚠️ Considerada: Excelente para APIs, buen ecosistema
   - ❌ Rechazada: Equipo tiene más experiencia con JavaScript
   - ❌ Async en Python menos natural que Node.js
   - ❌ Startup time ligeramente más lento

2. **Java (Spring Boot)**
   - ⚠️ Considerada: Enterprise-grade, robusto
   - ❌ Rechazada: Demasiado "pesado" para MVP
   - ❌ Tiempo de desarrollo más lento
   - ❌ Overhead de configuración

3. **Go (Golang)**
   - ⚠️ Considerada: Rendimiento excelente, compilado
   - ❌ Rechazada: Learning curve alta para equipo
   - ❌ Ecosistema más pequeño que Node.js
   - ❌ No hay ventaja significativa para este proyecto

### Consecuencias

#### Positivas
- ✅ Desarrollo rápido (Express es minimalista)
- ✅ Fácil integración con PostgreSQL (Sequelize)
- ✅ Fácil consumir APIs externas (axios)
- ✅ Testing simple (Jest)
- ✅ Deployment sencillo (Railway, Render, etc.)

#### Negativas
- ⚠️ JavaScript es single-threaded (mitigado con event loop)
- ⚠️ Errors en runtime (no tipado estático) - mitigable con TypeScript si es necesario
- ⚠️ Require disciplina en estructura de proyecto

### Estructura de Directorios
```
backend/
├── src/
│   ├── modules/        # Módulos por dominio
│   ├── middlewares/    # Auth, validation, error handling
│   ├── config/         # DB, env, etc.
│   ├── utils/          # Helpers
│   ├── jobs/           # Cron jobs
│   └── app.js          # Entry point
├── tests/
├── package.json
└── .env
```

---

## ADR-007: Estrategia de Autenticación y Autorización

### Estado
**Aceptada** - 10 de Marzo 2026

### Contexto
Necesitamos proteger datos personales y productivos (RN-01, RN-02, EC-07). Usuarios deben autenticarse de forma segura pero usable.

### Decisión
Implementar autenticación con **JWT (JSON Web Tokens)** con expiración de 24 horas.

### Flujo de Autenticación

1. **Registro:**
   - Usuario envía: `{documento, nombre, telefono, password}`
   - Backend valida, hashea password con bcrypt
   - Guarda en BD
   - Retorna JWT + datos de usuario

2. **Login:**
   - Usuario envía: `{documento, password}`
   - Backend valida credenciales
   - Retorna JWT + datos de usuario

3. **Requests Autenticados:**
   - App incluye JWT en header: `Authorization: Bearer <token>`
   - Middleware de backend valida JWT
   - Extrae `user_id` del payload
   - Permite o rechaza request

4. **Expiración:**
   - JWT expira en 24 horas
   - App detecta 401 Unauthorized
   - Redirige a login

### Formato del JWT Payload
```json
{
  "user_id": "uuid-del-usuario",
  "documento": "1234567890",
  "iat": 1234567890,  // Issued at
  "exp": 1234654290   // Expiration (24h después)
}
```

### Justificación
- **Stateless:** No requiere sesiones en servidor (escalable)
- **Estándar de industria:** Ampliamente usado y probado
- **Compatible con REST:** Header HTTP estándar
- **Seguro:** Firmado con secret (HMAC SHA256)
- **Portable:** Funciona en móvil, web, etc.

### Seguridad Implementada
- ✅ Passwords hasheados con bcrypt (cost factor 10)
- ✅ JWT firmado con secret fuerte (variable de entorno)
- ✅ Todos los requests vía HTTPS
- ✅ Rate limiting (prevención de brute force): 5 intentos / 15 min
- ✅ Validación y sanitización de inputs (express-validator)

### Alternativas Consideradas

1. **OAuth 2.0 (Login con Google/Facebook)**
   - ⚠️ Considerada: Conveniente para usuarios
   - ❌ Rechazada: Usuarios rurales no necesariamente tienen cuenta Google
   - ❌ Añade dependencia externa
   - ❌ Complejidad adicional

2. **Session-based (Cookies)**
   - ⚠️ Considerada: Tradicional, bien conocida
   - ❌ Rechazada: Stateful (requiere almacenar sesiones en servidor)
   - ❌ Menos escalable
   - ❌ CORS más complejo con cookies

3. **API Keys**
   - ❌ Rechazada: No tienen expiración automática
   - ❌ Menos seguro (si se filtra, válido indefinidamente)

### Consecuencias

#### Positivas
- ✅ Escalable (stateless)
- ✅ Simple de implementar
- ✅ Bien soportado por libraries
- ✅ Fácil de debuggear (jwt.io para decodificar)

#### Negativas
- ⚠️ No se puede "revocar" un JWT emitido (debe expirar)
  - Mitigación: Expiración corta (24h)
  - Futuro: Blacklist de tokens si es necesario

---

## ADR-008: Corrección de Plataforma y Stack Backend

### Estado
**Aceptada** - 21 de Abril 2026

### Contexto
Durante la consolidación documental se identificó una inconsistencia entre la arquitectura registrada y el alcance real del proyecto.

La documentación previa señalaba:
- Frontend móvil con Flutter
- Backend Node.js/Express

Sin embargo, la decisión vigente del equipo es:
- Aplicación **web** (no móvil nativa)
- Backend **Spring Boot**

### Decisión
Se adopta oficialmente el stack:

**Aplicación Web Responsiva + Backend Monolítico Modular (Spring Boot) + PostgreSQL**

Esta decisión **reemplaza** las decisiones tecnológicas previas de:
- ADR-005 (Frontend Flutter)
- ADR-006 (Backend Node.js/Express)

### Justificación
- Alineación total con el alcance funcional actual del producto.
- Mayor consistencia con prácticas empresariales del backend y mantenibilidad.
- Mejor coherencia entre documentos de arquitectura, despliegue y diseño del sistema.

### Consecuencias

#### Positivas
- ✅ Documentación coherente en todos los entregables de arquitectura
- ✅ Menor ambigüedad técnica para implementación del CRUD y demás módulos
- ✅ Base sólida para seguridad, validación y escalabilidad incremental

#### Negativas
- ⚠️ Requiere actualizar referencias históricas en documentos comparativos
- ⚠️ Implica retirar trazas de decisiones previas que ya no aplican

---

## Resumen de ADRs

| ID | Decisión | Estado | Impacto |
|----|----------|--------|---------|
| ADR-001 | Metodología: RUP (iteraciones 2 semanas) | Aceptada | Alto |
| ADR-002 | Arquitectura: Cliente-Servidor en Capas (Monolito Modular) | Aceptada | Crítico |
| ADR-003 | Base de Datos: PostgreSQL | Aceptada | Alto |
| ADR-004 | Conectividad: Offline-First + Eventual Consistency | Aceptada | Crítico |
| ADR-005 | Frontend: Flutter 3.x | Supersedida por ADR-008 | Alto |
| ADR-006 | Backend: Node.js + Express.js | Supersedida por ADR-008 | Alto |
| ADR-007 | Autenticación: JWT con expiración 24h | Aceptada | Medio |
| ADR-008 | Corrección a Web + Spring Boot + PostgreSQL | Aceptada | Crítico |

---

## Plantilla para Futuras ADRs

```markdown
## ADR-XXX: [Título de la Decisión]

### Estado
[Propuesta | Aceptada | Rechazada | Supersedida por ADR-YYY]

### Contexto
[Describir el problema, restricciones, requisitos que motivan la decisión]

### Decisión
[Describir la decisión tomada claramente]

### Justificación
[Por qué se tomó esta decisión, qué factores fueron determinantes]

### Alternativas Consideradas
1. **[Alternativa 1]**
   - Ventajas
   - Desventajas
   - Por qué fue rechazada

### Consecuencias
#### Positivas
- Lista de beneficios

#### Negativas
- Lista de trade-offs o costos

### Métricas de Validación (si aplica)
[Cómo se medirá el éxito de esta decisión]
```

---

**Mantenido por:** Líder Técnico / Arquitecto  
**Última Actualización:** Marzo 2026



