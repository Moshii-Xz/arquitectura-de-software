# Alternativas Arquitectónicas

## Introducción

En esta sección se presentan y analizan **dos alternativas arquitectónicas viables** para la Plataforma Digital de Agricultura Inteligente. Cada alternativa considera los requisitos funcionales, atributos de calidad críticos y restricciones del proyecto.

Las alternativas se evalúan considerando:
- Restricciones técnicas (conectividad intermitente, dispositivos gama baja)
- Restricciones económicas (bajo costo, equipo pequeño, 4 meses de desarrollo)
- Atributos de calidad prioritarios (disponibilidad offline, usabilidad, rendimiento)
- Escalabilidad futura
- Mantenibilidad y sostenibilidad

---

## ALTERNATIVA 1: Arquitectura Basada en PWA (Progressive Web App) con Backend Serverless

### 1.1. Descripción General

Sistema web progresivo accesible desde navegador móvil, que funciona offline mediante Service Workers, con backend serverless (Functions as a Service) en la nube.

### 1.2. Estilo Arquitectónico Principal
**Cliente-Servidor con Arquitectura de Microservicios Serverless**

### 1.3. Componentes Principales

#### Frontend (PWA)
- **Tecnología:** React/Vue.js + PWA APIs
- **Características:**
  - Instalable desde navegador (no requiere App Store)
  - Service Workers para caché offline
  - Manifesto web para comportamiento app-like
  - IndexedDB para almacenamiento local
  - Notificaciones push via web APIs

#### Backend (Serverless)
- **Tecnología:** AWS Lambda / Google Cloud Functions / Azure Functions
- **Servicios:**
  - API Gateway (endpoints REST)
  - Functions para lógica de negocio
  - Cloud Storage para imágenes
  - Notification Service (FCM para notificaciones push)

#### Base de Datos
- **Principal:** Firestore o DynamoDB (NoSQL serverless)
- **Caché:** Redis (opcional, para optimización)

#### Integración Externa
- APIs climáticas (OpenWeatherMap, IDEAM)
- Servicio de notificaciones push (Firebase Cloud Messaging)

### 1.4. Diagrama de Arquitectura (Conceptual)

```
┌─────────────────────────────────────────────────┐
│           Usuario (Navegador Móvil)             │
│  ┌───────────────────────────────────────────┐  │
│  │    PWA (React/Vue + Service Workers)      │  │
│  │  - UI/UX Layer                            │  │
│  │  - IndexedDB (datos offline)              │  │
│  │  - Service Worker (caché, sync)           │  │
│  └──────────────────┬────────────────────────┘  │
└────────────────────┼──────────────────────────┘
                     │ HTTPS/REST
                     ▼
┌──────────────────────────────────────────────────┐
│            API Gateway (Cloud)                    │
└──────────────────┬────────────────────────────────┘
                   │
      ┌────────────┼────────────┐
      ▼            ▼            ▼
   ┌──────┐   ┌──────┐     ┌──────┐
   │Lambda│   │Lambda│     │Lambda│
   │Cultivo│  │Alertas│   │Syncr│
   └───┬──┘   └───┬──┘     └───┬──┘
       │          │            │
       └──────────┼────────────┘
                  ▼
         ┌─────────────────┐
         │   Firestore /   │
         │    DynamoDB     │
         └─────────────────┘
                  
       ┌──────────┐
       │  Cloud   │
       │ Storage  │
       └──────────┘
```

### 1.5. Ventajas Principales

#### ✅ Ventajas Técnicas
- **Sin instalación desde tienda:** Reduce fricción para usuarios rurales
- **Multiplataforma:** Funciona en Android, iOS, y desktop desde navegador
- **Actualizaciones instantáneas:** Sin necesidad de actualizar app
- **Offline-first:** Service Workers proveen caché robusto
- **Escalabilidad automática:** Backend serverless escala según demanda

#### ✅ Ventajas Económicas
- **Bajo costo inicial:** No hay servidores dedicados
- **Pago por uso:** Solo se paga por ejecuciones reales (ideal para inicio)
- **Sin costos de App Store:** No hay pagos a Google/Apple
- **Infraestructura gestionada:** Menos tiempo de DevOps

#### ✅ Ventajas de Desarrollo
- **Stack único:** JavaScript en frontend y backend (Node.js)
- **Ecosistema maduro:** Librerías y herramientas abundantes
- **Iteración rápida:** Despliegues frecuentes sin aprobación de tiendas

### 1.6. Desventajas Principales

#### ❌ Desventajas Técnicas
- **Limitaciones de PWA:** No todo tiene acceso nativo (ej: acceso a sensores avanzados)
- **Soporte variables en navegadores:** Safari tiene soporte limitado de PWA
- **Rendimiento:** Puede ser inferior a app nativa en dispositivos muy básicos
- **Dependencia de navegador:** Experiencia puede variar

#### ❌ Desventajas Económicas
- **Costo crece con uso:** A diferencia de servidor fijo, cost puede ser impredecible
- **Vendor lock-in:** Fuerte dependencia del proveedor cloud (AWS, Google)

#### ❌ Desventajas de Usabilidad
- **Descubrimiento:** Usuarios rurales pueden no saber cómo "instalar" una PWA
- **Percepción:** Puede no sentirse como "app real" para algunos usuarios

### 1.7. Evaluación Detallada vs Restricciones

| Restricción | Cumplimiento | Observaciones |
|-------------|--------------|---------------|
| **RT-01: Conectividad intermitente** | ✅ Alto | Service Workers permiten offline robusto |
| **RT-02: Dispositivos gama baja** | ⚠️ Medio | Funciona pero puede ser menos fluido que nativo |
| **RT-03: Bajo costo** | ✅ Alto | Serverless es muy económico a baja escala |
| **RT-04: Soporte técnico limitado** | ✅ Alto | Auto-actualizable, menos mantenimiento |
| **RE-01: Presupuesto operación** | ✅ Muy alto | Tier gratuito generoso, luego pay-per-use |
| **RE-02: Equipo de 5 personas** | ✅ Alto | Stack unificado (JavaScript) |
| **RE-03: 4 meses desarrollo** | ✅ Alto | Frameworks maduros aceleran desarrollo |
| **RS-02: Baja alfabetización** | ⚠️ Medio | Instalación desde navegador puede confundir |

### 1.8. Evaluación vs Atributos de Calidad Críticos

| Atributo | Evaluación | Justificación |
|----------|------------|---------------|
| **Disponibilidad offline** | ✅ Excelente | Service Workers diseñados para esto |
| **Rendimiento gama baja** | ⚠️ Bueno | Puede tener lag en JavaScript pesado |
| **Usabilidad** | ✅ Bueno | UI moderna con frameworks especializados |
| **Seguridad** | ✅ Muy bueno | HTTPS obligatorio, autenticación cloud |
| **Escalabilidad** | ✅ Excelente | Serverless escala automáticamente |

---

## ALTERNATIVA 2: Aplicación Móvil Nativa/Híbrida con Backend Monolítico Ligero

### 2.1. Descripción General

Aplicación móvil nativa (Android) o híbrida (Flutter/React Native), con backend centralizado tradicional (monolito modular) desplegado en infraestructura de bajo costo.

### 2.2. Estilo Arquitectónico Principal
**Cliente-Servidor con Arquitectura en Capas (Monolito Modular)**

### 2.3. Componentes Principales

#### Frontend (Aplicación Móvil)
- **Tecnología:** Flutter o React Native (multiplataforma) o Kotlin (solo Android)
- **Características:**
  - Instalación desde Google Play Store
  - Base de datos local (SQLite/Realm)
  - Acceso completo a APIs nativas del dispositivo
  - Notificaciones push nativas
  - UI altamente optimizada

#### Backend (Monolito Modular)
- **Tecnología:** Node.js (Express) / Python (Django/Flask) / Java (Spring Boot)
- **Estructura:**
  - API REST
  - Lógica de negocio modular por dominio
    - Módulo de Usuarios
    - Módulo de Cultivos
    - Módulo de Recomendaciones
    - Módulo de Alertas Climáticas
  - Tareas programadas (cron jobs)
  - Caché en memoria (opcional)

#### Base de Datos
- **Principal:** PostgreSQL / MySQL (relacional)
- **Opcional:** Redis para caché

#### Infraestructura
- **Opción 1:** VPS económico (DigitalOcean, Vultr, Linode) - $5-10/mes
- **Opción 2:** PaaS gratuito/barato (Railway, Render, Fly.io)
- **Opción 3:** Servidor local + dominio (futuro)

#### Integración Externa
- APIs climáticas (OpenWeatherMap, IDEAM)
- Firebase Cloud Messaging (notificaciones push)

### 2.4. Diagrama de Arquitectura (Conceptual)

```
┌─────────────────────────────────────────┐
│   Usuario (Dispositivo Android)         │
│  ┌────────────────────────────────────┐ │
│  │  Aplicación Móvil (Flutter/RN)     │ │
│  │  ┌──────────────────────────────┐  │ │
│  │  │ Presentation Layer           │  │ │
│  │  └──────────────┬────────────────┘  │ │
│  │  ┌──────────────┴────────────────┐  │ │
│  │  │ Business Logic (Local)        │  │ │
│  │  └──────────────┬────────────────┘  │ │
│  │  ┌──────────────┴────────────────┐  │ │
│  │  │ SQLite (Datos Offline)        │  │ │
│  │  └───────────────────────────────┘  │ │
│  └──────────────┬───────────────────────┘ │
└─────────────────┼─────────────────────────┘
                  │ HTTPS/REST
                  ▼
┌────────────────────────────────────────────┐
│    Backend Monolítico (VPS/PaaS)           │
│  ┌──────────────────────────────────────┐  │
│  │         API Layer (REST)             │  │
│  └──────────────┬───────────────────────┘  │
│  ┌──────────────┴───────────────────────┐  │
│  │     Business Logic Layer             │  │
│  │  ┌─────────┐  ┌─────────┐ ┌───────┐ │  │
│  │  │Usuarios │  │Cultivos │ │Alertas│ │  │
│  │  └─────────┘  └─────────┘ └───────┘ │  │
│  └──────────────┬───────────────────────┘  │
│  ┌──────────────┴───────────────────────┐  │
│  │      Data Access Layer               │  │
│  └──────────────┬───────────────────────┘  │
└─────────────────┼──────────────────────────┘
                  │
                  ▼
         ┌─────────────────┐
         │   PostgreSQL    │
         │   (Relacional)  │
         └─────────────────┘
```

### 2.5. Ventajas Principales

#### ✅ Ventajas Técnicas
- **Rendimiento superior:** App nativa/híbrida es más rápida en gama baja
- **Acceso completo al hardware:** Sensores, GPS, cámara sin limitaciones
- **Offline robusto:** Control total sobre almacenamiento local (SQLite)
- **UX consistente:** Comportamiento predecible en todos los dispositivos
- **Integración profunda:** Notificaciones, widgets, shortcuts nativas

#### ✅ Ventajas Económicas (Monolito)
- **Costo fijo predecible:** VPS de $5-10/mes cubre necesidades iniciales
- **Simple de desplegar:** Un solo servidor, una base de datos
- **Sin sorpresas de facturación:** No hay pay-per-use

#### ✅ Ventajas de Desarrollo
- **Código compartido multiplataforma:** Flutter/React Native reutiliza 90%+ código
- **Stack familiar:** Tecnologías bien documentadas y con comunidad
- **Debugging más fácil:** Toda la lógica en un solo lugar
- **Despliegue simple:** Un repositorio, un build, un deploy

### 2.6. Desventajas Principales

#### ❌ Desventajas Técnicas
- **Proceso de instalación:** Requiere descargar desde Play Store (mayor fricción)
- **Actualizaciones manuales:** Usuarios deben actualizar app
- **Plataforma única inicial:** Si se hace nativa Android, no hay iOS de inmediato
- **Escalabilidad limitada:** Monolito requiere vertical scaling eventualmente

#### ❌ Desventajas Económicas
- **Costo fijo siempre:** Aunque no haya usuarios, se paga servidor
- **Mantenimiento de infraestructura:** Alguien debe gestionar el servidor
- **Posible costo de redesarrollo:** Si crece mucho, habrá que refactorizar

#### ❌ Desventajas de Desarrollo
- **Aprobación de tienda:** Cada actualización pasa por revisión de Google (1-3 días)
- **Fragmentación de versiones:** Algunos usuarios con versiones antiguas
- **Posible complejidad futura:** Monolito puede volverse difícil de mantener

### 2.7. Evaluación Detallada vs Restricciones

| Restricción | Cumplimiento | Observaciones |
|-------------|--------------|---------------|
| **RT-01: Conectividad intermitente** | ✅ Muy alto | SQLite local da control total offline |
| **RT-02: Dispositivos gama baja** | ✅ Muy alto | Rendimiento nativo superior |
| **RT-03: Bajo costo** | ✅ Alto | VPS barato suficiente para 1000+ usuarios |
| **RT-04: Soporte técnico limitado** | ⚠️ Medio | Requiere monitoreo básico de servidor |
| **RE-01: Presupuesto operación** | ✅ Alto | ~$10/mes cubre infraestructura completa |
| **RE-02: Equipo de 5 personas** | ✅ Alto | Stack simple y unificado |
| **RE-03: 4 meses desarrollo** | ✅ Muy alto | Frameworks como Flutter aceleran mucho |
| **RS-02: Baja alfabetización** | ✅ Alto | Instalación desde Play Store es familiar |

### 2.8. Evaluación vs Atributos de Calidad Críticos

| Atributo | Evaluación | Justificación |
|----------|------------|---------------|
| **Disponibilidad offline** | ✅ Excelente | SQLite da control completo |
| **Rendimiento gama baja** | ✅ Excelente | Código compilado (Flutter) o nativo |
| **Usabilidad** | ✅ Muy bueno | UX nativa, instalación conocida |
| **Seguridad** | ✅ Bueno | HTTPS, control total sobre código |
| **Escalabilidad** | ⚠️ Bueno | Escala hasta ~5000 usuarios, luego necesita refactor |

---

## Análisis Comparativo Inicial

### Tabla Comparativa Rápida

| Criterio | PWA + Serverless (Alt 1) | App Nativa/Híbrida + Monolito (Alt 2) |
|----------|--------------------------|----------------------------------------|
| **Rendimiento en gama baja** | Bueno | Excelente |
| **Disponibilidad offline** | Excelente | Excelente |
| **Costo operación (100 usuarios)** | ~$0-5/mes | ~$5-10/mes |
| **Costo operación (1000 usuarios)** | ~$10-30/mes | ~$10-15/mes |
| **Tiempo de desarrollo** | 3-4 meses | 3-4 meses |
| **Facilidad de actualización** | Excelente | Buena |
| **Escalabilidad** | Excelente | Buena |
| **Complejidad técnica** | Media-Alta | Media |
| **Curva de aprendizaje** | Media | Baja-Media |
| **Usabilidad para usuarios rurales** | Buena | Muy buena |
| **Mantenibilidad a largo plazo** | Muy buena | Buena |

---

## Recomendación Preliminar

Ambas alternativas son **viables** y cumplen con los requisitos críticos del proyecto. La decisión final dependerá de:

1. **Prioridad de rendimiento en dispositivos gama baja** → Favorece Alternativa 2
2. **Importancia de escalabilidad futura** → Favorece Alternativa 1
3. **Experiencia del equipo** → Favorece la tecnología que conozcan mejor
4. **Preferencia de usuarios** (si hay feedback previo) → Puede inclinar balanza

En el siguiente documento se realizará la **comparación detallada con trade-offs** y se justificará la decisión final.
