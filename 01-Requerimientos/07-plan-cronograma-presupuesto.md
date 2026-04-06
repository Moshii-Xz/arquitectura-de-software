# Plan, Cronograma y Presupuesto de Desarrollo

## 1. Metodología de Desarrollo

### Metodología Seleccionada: **RUP**

#### Justificación
- ✅ **Iteraciones cortas (2 semanas):** Permiten adaptación rápida a cambios
- ✅ **Feedback temprano:** Validación continua con stakeholders (asociaciones agrícolas)
- ✅ **Equipo pequeño:** RUP es ideal para equipos de 5 personas
- ✅ **Transparencia:** Reuniones diarias de seguimiento mejoran coordinación
- ✅ **Entregas incrementales:** MVP listo en mes 2, luego mejoras continuas

#### Configuración RUP
- **Duración de Iteracion:** 2 semanas
- **Total de iteraciones:** 8 (4 meses)
- **Reunion diaria de seguimiento:** Todos los días, 15 minutos, 9:00 AM
- **Planificacion de Iteracion:** Primer día de cada Iteracion, 2 horas
- **Revision de Iteracion:** Último día de Iteracion, 1 hora
- **Iteracion Lecciones aprendidas:** Último día de Iteracion, 30 minutos

---

## 2. Cronograma Detallado (4 Meses)

### MES 1: FUNDAMENTOS Y MVP INICIAL

#### Iteracion 1 (Semanas 1-2): Setup y Autenticación
**Objetivo:** Infraestructura base y módulo de autenticación funcional

| Día | Actividades | Responsable | Entregable |
|-----|-------------|-------------|------------|
| 1-2 | Setup de repositorios (Git), CI/CD, entornos de desarrollo | Líder Técnico | Repos configurados |
| 3-4 | Diseño de arquitectura de BD, migraciones iniciales | Diseñador de Datos | Schema v1.0 |
| 5-7 | Implementación API de autenticación (backend) | Desarrollador Principal | Endpoints /auth/* |
| 8-10 | UI/UX inicial de app (wireframes, mockups) | Analista + Todo el equipo | Mockups aprobados |
| 8-10 | Implementación pantallas de login/registro (frontend) | Desarrollador Principal | Pantallas funcionales |
| 11-12 | Integración frontend-backend, testing | QA + Desarrollador | Tests pasando |
| 13-14 | Revision de Iteracion y Lecciones aprendidas | Todo el equipo | Demo autenticación |

**Entregable Iteracion 1:** Usuario puede registrarse e iniciar sesión

#### Iteracion 2 (Semanas 3-4): Gestión de Cultivos
**Objetivo:** CRUD completo de cultivos

| Día | Actividades | Responsable | Entregable |
|-----|-------------|-------------|------------|
| 1-2 | Diseño UI para gestión de cultivos | Analista | Mockups cultivos |
| 3-5 | API CRUD de cultivos (backend) | Desarrollador Principal | Endpoints /cultivos/* |
| 6-8 | Pantallas de cultivos (lista, detalle, crear) (frontend) | Desarrollador Principal | Pantallas funcionales |
| 9-10 | Setup de SQLite local, repositorio local | Desarrollador + Diseñador Datos | BD local configurada |
| 11-12 | Testing unitario e integración | QA | Tests > 70% cobertura |
| 13-14 | Revision de Iteracion y Lecciones aprendidas, refinamiento backlog | Todo el equipo | Demo CRUD cultivos |

**Entregable Iteracion 2:** Usuario puede crear, ver y actualizar cultivos

---

### MES 2: NÚCLEO DEL SISTEMA

#### Iteracion 3 (Semanas 5-6): Actividades y Clima
**Objetivo:** Registro de actividades y datos climáticos

| Día | Actividades | Responsable | Entregable |
|-----|-------------|-------------|------------|
| 1-2 | Integración con API climática (OpenWeatherMap) | Desarrollador Principal | Servicio clima funcionando |
| 3-4 | API de actividades (backend) | Desarrollador Principal | Endpoints /actividades/* |
| 5-7 | UI de registro de actividades (offline-first) | Desarrollador + Líder Técnico | Formulario actividades |
| 8-9 | Visualización de datos climáticos en app | Desarrollador Principal | Pantalla clima |
| 10-11 | Implementación de caché de datos climáticos | Diseñador de Datos | Tabla clima_data |
| 12-13 | Testing, optimización | QA + Desarrollador | Tests pasando |
| 14 | Revision de Iteracion y Lecciones aprendidas | Todo el equipo | Demo actividades + clima |

**Entregable Iteracion 3:** Usuario puede registrar actividades y ver clima actual

#### Iteracion 4 (Semanas 7-8): Recomendaciones y Notificaciones
**Objetivo:** Motor de recomendaciones básico y notificaciones push

| Día | Actividades | Responsable | Entregable |
|-----|-------------|-------------|------------|
| 1-3 | Diseño e implementación motor de recomendaciones (reglas) | Líder Técnico + Desarrollador | Motor de reglas v1 |
| 4-5 | Validación de reglas con expertos agrónomos (externo) | Analista | Reglas validadas |
| 6-7 | API de recomendaciones (backend) | Desarrollador Principal | Endpoints /recomendaciones/* |
| 8-9 | Setup Firebase Cloud Messaging (FCM) | Desarrollador | FCM configurado |
| 10-11 | UI de recomendaciones en app | Desarrollador | Pantalla recomendaciones |
| 12-13 | Cron job para generación diaria de recomendaciones | Desarrollador + Diseñador Datos | Tarea programada |
| 14 | Revision de Iteracion y Lecciones aprendidas, Demo a stakeholders | Todo el equipo | **MVP FUNCIONAL** |

**Entregable Iteracion 4:** Usuario recibe recomendación de riego y notificación push ✅ **MVP**

---

### MES 3: FUNCIONALIDADES COMPLEMENTARIAS

#### Iteracion 5 (Semanas 9-10): Sincronización Robusta
**Objetivo:** Sincronización bidireccional offline→online

| Día | Actividades | Responsable | Entregable |
|-----|-------------|-------------|------------|
| 1-3 | Implementación de queue de sincronización (frontend) | Líder Técnico + Desarrollador | SyncService robusto |
| 4-5 | Endpoint de sincronización masiva (backend) | Desarrollador Principal | POST /actividades/sync |
| 6-7 | Resolución de conflictos (timestamps, last-write-wins) | Diseñador de Datos + Líder | Estrategia implementada |
| 8-10 | Testing exhaustivo de sincronización (offline→online) | QA + Todo el equipo | Casos de prueba completos |
| 11-12 | Indicadores visuales de sincronización (badges, loaders) | Desarrollador | UI mejorada |
| 13-14 | Revision de Iteracion y Lecciones aprendidas | Todo el equipo | Demo sincronización |

**Entregable Iteracion 5:** Sincronización offline→online funciona sin pérdida de datos

#### Iteracion 6 (Semanas 11-12): Alertas y Fertilización
**Objetivo:** Alertas climáticas y recomendaciones de fertilización

| Día | Actividades | Responsable | Entregable |
|-----|-------------|-------------|------------|
| 1-2 | Motor de evaluación de alertas climáticas | Desarrollador + Líder Técnico | AlertaService |
| 3-4 | Cron job para chequeo de alertas (cada 1 hora) | Desarrollador | Tarea programada |
| 5-6 | API de alertas (backend) | Desarrollador Principal | Endpoints /alertas/* |
| 7-8 | UI de alertas en app, notificaciones criticas | Desarrollador | Pantalla alertas |
| 9-10 | Motor de recomendaciones de fertilización | Líder Técnico | Reglas fertilización |
| 11-12 | Testing, validación con expertos | QA + Analista | Validación |
| 13-14 | Revision de Iteracion y Lecciones aprendidas | Todo el equipo | Demo alertas |

**Entregable Iteracion 6:** Usuario recibe alertas climáticas críticas oportunamente

---

### MES 4: VALIDACIÓN Y REFINAMIENTO

#### Iteracion 7 (Semanas 13-14): Testing y Optimización
**Objetivo:** Testing exhaustivo y optimización de rendimiento

| Día | Actividades | Responsable | Entregable |
|-----|-------------|-------------|------------|
| 1-3 | Testing unitario y de integración (backend) | QA + Desarrollador | Cobertura > 70% |
| 4-5 | Testing de integración (frontend) | QA | Tests E2E |
| 6-7 | Performance testing en dispositivo gama baja | QA + Desarrollador | Benchmarks |
| 8-9 | Optimización de rendimiento (lazy loading, compresión) | Desarrollador + Líder | App optimizada |
| 10-11 | Corrección de bugs críticos y medios | Todo el equipo | Bugs cerrados |
| 12-13 | Preparación de entorno de producción (Railway) | Líder Técnico | Deploy staging |
| 14 | Revision de Iteracion y Lecciones aprendidas | Todo el equipo | Demo completa |

**Entregable Iteracion 7:** Sistema estable con bugs críticos resueltos

#### Iteracion 8 (Semanas 15-16): Validación y Deploy
**Objetivo:** Usability testing, validación final y lanzamiento

| Día | Actividades | Responsable | Entregable |
|-----|-------------|-------------|------------|
| 1-2 | Usability testing con 10 productores reales | Analista + QA | Resultados y feedback |
| 3-4 | Ajustes basados en feedback de usuarios | Desarrollador + Diseñador | Mejoras implementadas |
| 5-6 | Validación de atributos de calidad (EC-01 a EC-07) | QA + Líder Técnico | Reporte validación |
| 7-8 | Documentación final (README, guías usuario) | Analista + Todo el equipo | Docs completas |
| 9-10 | Build de producción, deploy a Railway | Líder Técnico + Desarrollador | Backend en producción |
| 11-12 | Build APK release, subida a Play Store (review) | Desarrollador | APK en Play Store |
| 13 | Video demostración (3-5 min) | Analista + Desarrollador | Video publicado |
| 14 | Presentación final al curso y stakeholders | Todo el equipo | **ENTREGA FINAL** ✅ |

**Entregable Iteracion 8:** Sistema en producción, validado y documentado

---

## 3. Diagrama de Gantt (Resumen)

```
Actividad                    | Mes 1 | Mes 2 | Mes 3 | Mes 4 |
-----------------------------|-------|-------|-------|-------|
Setup e Infraestructura      | ████  |       |       |       |
Autenticación                | ████  |       |       |       |
CRUD Cultivos                | ████  |       |       |       |
Registro Actividades         |       | ████  |       |       |
Integración Clima            |       | ████  |       |       |
Recomendaciones (Riego)      |       | ████  |       |       |
Notificaciones Push          |       | ████  |       |       |
Sincronización Robusta       |       |       | ████  |       |
Alertas Climáticas           |       |       | ████  |       |
Recomendaciones (Fertiliz.)  |       |       | ████  |       |
Testing Exhaustivo           |       |       |       | ████  |
Usability Testing            |       |       |       | ████  |
Deploy y Lanzamiento         |       |       |       | ████  |
```

---

## 4. Presupuesto de Desarrollo

### 4.1. Costos de Personal (Honorarios)

**Nota:** Este es un proyecto académico. Los valores son estimados asumiendo remuneración hipotética.

| Rol | Horas/Semana | Semanas | Total Horas | Tarifa/Hora | Costo Total |
|-----|--------------|---------|-------------|-------------|-------------|
| Líder Técnico / Arquitecto | 30 | 16 | 480 | $30 | $14,400 |
| Analista de Requisitos | 20 | 16 | 320 | $25 | $8,000 |
| Diseñador de Datos | 25 | 16 | 400 | $28 | $11,200 |
| Desarrollador Principal | 35 | 16 | 560 | $30 | $16,800 |
| Responsable de QA | 25 | 16 | 400 | $25 | $10,000 |
| **SUBTOTAL PERSONAL** | | | **2,160** | | **$60,400** |

**Nota:** Al ser proyecto académico, estos costos son **simulados**. En realidad, el "costo" es el esfuerzo académico de los estudiantes.

---

### 4.2. Costos de Infraestructura

#### Desarrollo (4 meses)

| Servicio | Plan | Costo Mensual | Meses | Costo Total |
|----------|------|---------------|-------|-------------|
| **Railway.app** (Backend + PostgreSQL) | Starter | $5-10 | 4 | $20-40 |
| **OpenWeatherMap API** | Free Tier | $0 | 4 | $0 |
| **Firebase (FCM)** | Free Tier | $0 | 4 | $0 |
| **GitHub** (Repos) | Free | $0 | 4 | $0 |
| **Dominio** (.com) | Estándar | $12/año | 1 | $12 |
| **SUBTOTAL INFRAESTRUCTURA (Dev)** | | | | **$32-52** |

#### Producción (Año 1 estimado)

| Servicio | Plan | Costo Mensual | Meses | Costo Total |
|----------|------|---------------|-------|-------------|
| **Railway.app** | Starter | $10 | 12 | $120 |
| **OpenWeatherMap API** | Free (hasta 1000 llamadas/día) | $0 | 12 | $0 |
| **Firebase (FCM)** | Free | $0 | 12 | $0 |
| **Dominio** | Estándar | $1/mes | 12 | $12 |
| **Monitoreo** (UptimeRobot) | Free | $0 | 12 | $0 |
| **Error Tracking** (Sentry) | Free Tier | $0 | 12 | $0 |
| **SUBTOTAL INFRAESTRUCTURA (Año 1)** | | | | **$132** |
| **PROMEDIO MENSUAL** | | | | **$11/mes** |

---

### 4.3. Costos de Herramientas y Licencias

| Herramienta | Licencia | Costo | Justificación |
|-------------|----------|-------|---------------|
| **Flutter SDK** | Open Source | $0 | Gratuito |
| **Android Studio** | Gratuito | $0 | IDE gratuito |
| **VS Code** | Gratuito | $0 | Editor gratuito |
| **Node.js** | Open Source | $0 | Gratuito |
| **PostgreSQL** | Open Source | $0 | Gratuito |
| **Figma** (Diseño UI) | Free Tier | $0 | Tier gratuito suficiente |
| **Postman** (Testing API) | Free | $0 | Tier gratuito |
| **PlantUML** | Open Source | $0 | Gratuito |
| **Google Play Console** | Una vez | $25 | Publicar APK |
| **SUBTOTAL HERRAMIENTAS** | | **$25** | |

---

### 4.4. Costos Adicionales

| Concepto | Costo | Justificación |
|----------|-------|---------------|
| Dispositivo Android gama baja para testing | $150 | Samsung Galaxy A03 o similar (una vez) |
| Consultoría Agrónoma (validación reglas) | $200 | 2 sesiones x $100 con ingeniero agrónomo |
| Usability Testing (incentivos usuarios) | $100 | $10 x 10 productores (tiempo + transporte) |
| Contingencia (10%) | $50 | Imprevistos |
| **SUBTOTAL ADICIONALES** | **$500** | |

---

### 4.5. Resumen de Presupuesto

| Categoría | Costo de Desarrollo (4 meses) | Costo Operación Anual |
|-----------|--------------------------------|-----------------------|
| **Personal** (simulado) | $60,400 | N/A |
| **Infraestructura** | $32-52 | $132 |
| **Herramientas** | $25 | $0 |
| **Adicionales** | $500 | N/A |
| **TOTAL** | **$60,957 - $60,977** | **$132/año** |

#### Presupuesto Real (Sin costos de personal simulados)
- **Desarrollo:** ~$557 - $577
- **Operación Año 1:** ~$132 (~$11/mes)

**Conclusión:** El proyecto es **altamente económico** y cumple con la restricción de presupuesto limitado (< $50/mes operación).

---

## 5. Riesgos y Mitigación

### Riesgos Principales

| Riesgo | Probabilidad | Impacto | Mitigación |
|--------|--------------|---------|------------|
| **Retraso en desarrollo** | Media | Alto | Priorización estricta de MVP, buffer de 1 semana en mes 4 |
| **Falta de expertos agrónomos** | Baja | Alto | Contactar universidad (Ingeniería Agronómica) desde Iteracion 1 |
| **API climática no disponible** | Baja | Alto | Planificar fallback a fuente alternativa (IDEAM) |
| **Dispositivos más lentos de lo esperado** | Media | Alto | Testing temprano (Iteracion 2), optimización continua |
| **Feedback negativo de usuarios** | Media | Medio | Usability testing en Iteracion 6 (no solo en Iteracion 8) |
| **Costo de infraestructura excede presupuesto** | Baja | Medio | Monitoreo semanal de costos, tier gratuito validado |
| **Equipo se enferma/ausencias** | Media | Medio | Documentación continua, pair programming |

---

## 6. Hitos Clave (Milestones)

| Hito | Fecha (estimada) | Entregable |
|------|------------------|------------|
| **M1: Infraestructura Base** | Fin Semana 2 | Repos, CI/CD, autenticación funcionando |
| **M2: CRUD Completo** | Fin Semana 4 | Usuario puede gestionar cultivos |
| **M3: MVP Funcional** | Fin Semana 8 | Usuario recibe recomendación y notificación ✅ |
| **M4: Sincronización Completa** | Fin Semana 10 | Modo offline robusto |
| **M5: Funcionalidades Completas** | Fin Semana 12 | Alertas, fertilización, historial |
| **M6: Sistema Validado** | Fin Semana 14 | Testing completo, bugs críticos resueltos |
| **M7: Lanzamiento** | Fin Semana 16 | **Sistema en producción** 🚀 |

---

## 7. Dependencias Críticas

### Dependencias Externas
1. **API de OpenWeatherMap:** Registro y obtención de API Key (1 día)
2. **Firebase Project:** Creación de proyecto y configuración FCM (1 día)
3. **Google Play Console:** Registro de cuenta desarrollador ($25, 1-2 días)
4. **Expertos Agrónomos:** Disponibilidad para validación de reglas (2 sesiones)

### Dependencias Internas
1. **Schema de BD finalizado** antes de Iteracion 2 (Día 14)
2. **Mockups aprobados** antes de implementación de UI (cada Iteracion)
3. **API endpoints listos** antes de integración frontend (coordinación diaria)

---

## 8. Criterios de Aceptación por Entregable

### Iteracion 2 (CRUD Cultivos)
- [ ] Usuario puede crear cultivo con tipo, área, fecha siembra
- [ ] Usuario ve lista de sus cultivos
- [ ] Usuario puede ver detalle de un cultivo
- [ ] Usuario puede actualizar información de cultivo
- [ ] Tests unitarios > 70% cobertura en módulo de cultivos

### Iteracion 4 (MVP)
- [ ] Usuario recibe recomendación de riego generada automáticamente
- [ ] Notificación push llega al dispositivo móvil
- [ ] Usuario puede ver detalle de recomendación con justificación
- [ ] Motor de recomendaciones validado por ingeniero agrónomo

### Iteracion 6 (Alertas)
- [ ] Usuario recibe alerta si se pronostica lluvia intensa (>50mm)
- [ ] Alerta llega con anticipación mínima de 6 horas
- [ ] Usuario puede ver historial de alertas recibidas

### Iteracion 8 (Entrega Final)
- [ ] Sistema cumple 6/7 escenarios críticos (EC-01 a EC-07)
- [ ] Usability testing: > 80% de usuarios completan tareas sin ayuda
- [ ] SUS Score > 70/100
- [ ] APK disponible en Google Play Store
- [ ] Video demostración publicado
- [ ] Documentación completa en repositorio

---

## 9. Recursos Necesarios

### Recursos Humanos
- 5 integrantes del equipo (tiempo completo en proyecto durante 4 meses)
- 1 ingeniero agrónomo (consultor externo, 2 sesiones de 2 horas)
- 10 pequeños productores (usability testing, 1 sesión de 1 hora c/u)

### Recursos Técnicos
- 5 laptops/PCs para desarrollo
- 2-3 dispositivos Android para testing (gama baja, media, alta)
- Conexión a internet estable

### Recursos de Software
- Licencias/cuentas: Todas gratuitas excepto Google Play Console ($25)

---

## 10. Estrategia de Comunicación

### Comunicación Interna (Equipo)
- **Reunion diaria de seguimiento:** Lunes a Viernes, 9:00 AM, 15 min (Presencial/Zoom)
- **Planificacion de Iteracion:** Primer lunes de cada Iteracion, 2 horas
- **Revision de Iteracion:** Último viernes de Iteracion, 1 hora
- **Lecciones aprendidas:** Último viernes, 30 min después de review
- **Canal de comunicación:** Slack/WhatsApp para comunicación asíncrona

### Comunicación Externa (Stakeholders)
- **Demo a profesor:** Al final de cada Iteracion (opcional semanal)
- **Demo a stakeholders (asociaciones agrícolas):** Fin de Iteracion 4 (MVP) y Iteracion 8 (Final)
- **Consulta con expertos agrónomos:** Iteracion 4 y Iteracion 6

---

## Aprobación del Plan

| Rol | Nombre | Firma | Fecha |
|-----|--------|-------|-------|
| Líder Técnico / Arquitecto | _________ | ______ | ______ |
| Analista de Requisitos | _________ | ______ | ______ |
| Diseñador de Datos | _________ | ______ | ______ |
| Desarrollador Principal | _________ | ______ | ______ |
| Responsable de QA | _________ | ______ | ______ |
| Profesor del Curso | _________ | ______ | ______ |

---

**Versión:** 1.0  
**Fecha de Creación:** Marzo 2026  
**Última Actualización:** Marzo 2026



