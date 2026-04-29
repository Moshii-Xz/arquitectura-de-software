# Arquitectura Seleccionada

## 1. Decisión Arquitectónica

### Arquitectura Elegida
**Monolito Modular por Capas + API REST+ Base de Datos Relacional (PostgreSQL)**

### Estilo Arquitectónico Principal
**Cliente-Servidor en Capas (Layered Architecture) con API pura en la capa de presentación**

---

## 2. Justificación de la Selección

### Razones de la selección
- Se prioriza simplicidad de despliegue, mantenibilidad y trazabilidad para el equipo actual.
- Spring Boot permite una base robusta para una API REST, validaciones, seguridad y crecimiento modular.
- La capa de presentación queda desacoplada del backend, de modo que uno o varios clientes frontales independientes puedan consumir la misma API.
- PostgreSQL cubre bien el modelo relacional del dominio (usuarios, cultivos, insumos, recomendaciones y reportes).

### Restricciones y atributos de calidad cubiertos
- **Bajo costo operativo:** despliegue en VPS o PaaS de bajo costo.
- **Mantenibilidad:** separación por capas y módulos de negocio.
- **Seguridad:** Spring Security + JWT + cifrado de contraseñas.
- **Rendimiento:** API optimizable con índices, caché, paginación y respuestas livianas.
- **Escalabilidad:** monolito modular como base de evolución a microservicios si el crecimiento lo exige.

---

## 3. Arquitectura Detallada

### 3.1. Vista de Alto Nivel

```
┌─────────────────────────────────────────────────────────┐
│                    USUARIO FINAL                        │
│      (Productor, Operario, Administrador, Técnico)     │
└───────────────────────┬─────────────────────────────────┘
                        │ HTTPS
                        ▼
┌─────────────────────────────────────────────────────────┐
│          CLIENTES FRONTALES INDEPENDIENTES              │
│  - Web responsivo como cliente principal                │
│  - Posibles clientes futuros: móvil o desktop           │
│  - Consumo de API y manejo de sesión por token          │
└───────────────────────┬─────────────────────────────────┘
                        │ REST/JSON  
                        ▼
┌─────────────────────────────────────────────────────────┐
│              BACKEND API (Spring Boot)                  │
│  ┌────────────────────────────────────────────────────┐ │
│  │ API Layer                                          │ │
│  │ - /api/auth                                        │ │
│  │ - /api/cultivos                                    │ │
│  │ - /api/insumos                                     │ │
│  │ - /api/recomendaciones                             │ │
│  │ - /api/reportes                                    │ │
│  │ - /api/usuarios                                    │ │
│  │ - /graphql (opcional)                              │ │
│  └────────────────┬───────────────────────────────────┘ │
│  ┌────────────────┴───────────────────────────────────┐ │
│  │ Services (Business Layer)                          │ │
│  │ - Reglas de negocio, validaciones, auditoría       │ │
│  └────────────────┬───────────────────────────────────┘ │
│  ┌────────────────┴───────────────────────────────────┐ │
│  │ Repositories (Data Access Layer)                   │ │
│  │ - JPA/Hibernate                                    │ │
│  └────────────────┬───────────────────────────────────┘ │
└───────────────────┼─────────────────────────────────────┘
                    ▼
┌─────────────────────────────────────────────────────────┐
│                 BASE DE DATOS (PostgreSQL)             │
│  - users, cultivos, insumos, recomendaciones, reportes │
└─────────────────────────────────────────────────────────┘
```

---

## 4. Tecnologías Seleccionadas

### 4.1. Frontend Web
- HTML5, CSS3 y JavaScript/TypeScript.
- Cliente frontal independiente, con enfoque responsivo (desktop y móvil).
- Consumo de API REST/GraphQL con manejo de sesión por token.

### 4.2. Backend
- **Java 17+**
- **Spring Boot 3.x**
- **Spring Web** para API REST
- **Spring Security + JWT** para autenticación/autorización
- **Spring Data JPA (Hibernate)** para persistencia
- **Bean Validation** para validaciones de entrada

### 4.3. Base de Datos
- **PostgreSQL 14+**
- Diseño relacional con claves foráneas, índices y constraints

### 4.4. Infraestructura y despliegue
- Opción 1: VPS Linux (app Spring Boot + PostgreSQL)
- Opción 2: PaaS para API y base de datos administrada
- HTTPS obligatorio en todos los ambientes

---

## 5. Organización por Capas y Módulos

- **Capa API:** controladores REST por módulo.
- **Capa de Servicio:** reglas de negocio y orquestación.
- **Capa de Persistencia:** repositorios JPA y consultas optimizadas.
- **Módulos principales:** autenticación, cultivos, insumos, recomendaciones, reportes, usuarios.

---

## 6. Criterios de Implementación para el CRUD de Cultivos

- Endpoint base: `/api/cultivos`
- Operaciones mínimas: crear, listar, obtener por id, actualizar y eliminar.
- Seguridad: solo usuarios autenticados; control por rol cuando aplique.
- Validaciones: tipo cultivo, área, fechas, estado y consistencia de datos.
- Auditoría: fecha de creación, actualización y usuario responsable.
- Rendimiento: paginación, filtros y ordenamiento.

---

## 7. Decisión de Consistencia Documental

Esta versión reemplaza cualquier referencia previa a:
- Backend en Node.js/Express
- Aplicación móvil híbrida con Flutter

La línea oficial del proyecto queda definida como:
**Monolito modular por capas + API REST + PostgreSQL + clientes frontales independientes**.
