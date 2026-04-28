# Backlog Técnico Backend — Alcance 80% hasta Fase 5

**Proyecto:** agrointeligente-backend  
**Package Base:** com.agrointeligente.backend  
**groupId:** com.agrointeligente  
**artifactId:** agrointeligente-backend  
**Stack:** Java 17, Spring Boot 3.x, PostgreSQL, JPA/Hibernate, JWT, MapStruct, Lombok, Flyway  

**Objetivo:** Implementar todas las Fases 0-5 y sumar RF-53 para superar el 80% de cobertura funcional backend, dejando fuera reportes avanzados y sincronización offline.

**Requisitos funcionales cubiertos:** RF-01 a RF-38, RF-45 a RF-50 y RF-53

---

## FASE 0 — Trazabilidad y Corte Funcional

### O-0.1: Matriz RF → Entidad → Endpoint

**Descripción**  
Construir una matriz que alinee cada RF con su entidad JPA, endpoint(s), servicio y tabla de BD. Esto ccierra el scope operativo del backend.

| RF | Módulo | Requisito | Entidad | Endpoint | Servicio | Tabla | Fase |
|-----|--------|-----------|---------|----------|----------|-------|------|
| RF-01 | Auth | Autenticación de usuarios | User | POST /api/v1/auth/login | AuthService | users | 2 |
| RF-02 | Auth | Cierre seguro de sesión | - | POST /api/v1/auth/logout | AuthService | - | 2 |
| RF-03 | Auth | Recuperación de contraseña | PasswordReset | POST /api/v1/auth/forgot-password | AuthService | password_resets | 2 |
| RF-04 | Auth | Cambio de contraseña | User | PUT /api/v1/auth/change-password | AuthService | users | 2 |
| RF-05 | Auth | Bloqueo por intentos fallidos | LoginAttempt | - | AuthService | login_attempts | 2 |
| RF-06 | Auth | Roles y permisos | Role, Permission | - | AuthService | roles, permissions | 1 |
| RF-07 | Auth | Vigencia de sesión | Token | - | AuthService | tokens | 2 |
| RF-08 | Perfil | Creación y completitud de perfil | UserProfile | POST/PUT /api/v1/users/profile | UserProfileService | user_profiles | 2 |
| RF-09 | Perfil | Visualización integral del perfil | UserProfile | GET /api/v1/users/profile | UserProfileService | user_profiles | 2 |
| RF-10 | Perfil | Edición de perfil (excepto correo) | UserProfile | PUT /api/v1/users/profile | UserProfileService | user_profiles | 2 |
| RF-11 | Perfil | Carga de foto de perfil | UserProfile | POST /api/v1/users/profile/photo | UserProfileService | user_profiles | 2 |
| RF-12 | Perfil | Registro de ubicación geográfica | UserLocation | POST/PUT /api/v1/users/location | UserLocationService | user_locations | 2 |
| RF-13 | Perfil | Configuración de idioma | UserProfile | PUT /api/v1/users/profile/language | UserProfileService | user_profiles | 2 |
| RF-14 | Perfil | Preferencias de notificación | NotificationPreference | PUT /api/v1/users/notification-prefs | NotificationService | notification_preferences | 2 |
| RF-15 | Cultivos | Registro de cultivo | Crop | POST /api/v1/crops | CropService | crops | 3 |
| RF-16 | Cultivos | Listado de cultivos activos | Crop | GET /api/v1/crops (con paginación) | CropService | crops | 3 |
| RF-17 | Cultivos | Detalle de cultivo | Crop | GET /api/v1/crops/{id} | CropService | crops | 3 |
| RF-18 | Cultivos | Edición de cultivo no finalizado | Crop | PUT /api/v1/crops/{id} | CropService | crops | 3 |
| RF-19 | Cultivos | Actualización de estado de cultivo | CropStatusHistory | PUT /api/v1/crops/{id}/status | CropService | crop_status_history | 3 |
| RF-20 | Cultivos | Eliminación de cultivo con confirmación | Crop | DELETE /api/v1/crops/{id} | CropService | crops | 3 |
| RF-21 | Cultivos | Adjuntar fotos a cultivo | CropPhoto | POST /api/v1/crops/{id}/photos | CropService | crop_photos | 3 |
| RF-22 | Cultivos | Registrar observaciones de cultivo | CropObservation | POST /api/v1/crops/{id}/observations | CropService | crop_observations | 3 |
| RF-23 | Cultivos | Búsqueda y filtros de cultivos | Crop | GET /api/v1/crops?filter=... | CropService | crops | 3 |
| RF-24 | Insumos | Registrar aplicación de insumo | InputApplication | POST /api/v1/crops/{id}/inputs | InputApplicationService | input_applications | 4 |
| RF-25 | Insumos | Historial de insumos aplicados | InputApplication | GET /api/v1/crops/{id}/inputs | InputApplicationService | input_applications | 4 |
| RF-26 | Insumos | Edición de registro de insumo en ventana limitada | InputApplication | PUT /api/v1/crops/{id}/inputs/{inputId} | InputApplicationService | input_applications | 4 |
| RF-27 | Insumos | Eliminación de registro de insumo | InputApplication | DELETE /api/v1/crops/{id}/inputs/{inputId} | InputApplicationService | input_applications | 4 |
| RF-28 | Insumos | Cálculo de costo total de insumos | InputApplication | GET /api/v1/crops/{id}/input-costs | InputApplicationService | input_applications | 4 |
| RF-29 | Insumos | Alertas por insumo de alto impacto ambiental | Alert | - | AlertService | alerts | 4 |
| RF-30 | Insumos | Catálogo de insumos | Input | GET /api/v1/inputs/catalog | InputService | inputs | 4 |
| RF-31 | Insumos | Recomendaciones de insumos | Recommendation | - | RecommendationService | recommendations | 5 |
| RF-32 | Recomendaciones | Recomendaciones de fertilización | Recommendation | - | RecommendationService | recommendations | 5 |
| RF-33 | Recomendaciones | Recomendaciones fitosanitarias | Recommendation | - | RecommendationService | recommendations | 5 |
| RF-34 | Recomendaciones | Recomendaciones activas por prioridad | Recommendation | GET /api/v1/recommendations?status=active | RecommendationService | recommendations | 5 |
| RF-35 | Recomendaciones | Detalle y justificación de recomendación | Recommendation | GET /api/v1/recommendations/{id} | RecommendationService | recommendations | 5 |
| RF-36 | Recomendaciones | Marcar recomendación como atendida | Recommendation | PATCH /api/v1/recommendations/{id}/mark-attended | RecommendationService | recommendations | 5 |
| RF-37 | Recomendaciones | Descartar recomendación con historial | Recommendation | PATCH /api/v1/recommendations/{id}/discard | RecommendationService | recommendations | 5 |
| RF-38 | Recomendaciones | Historial de recomendaciones | Recommendation | GET /api/v1/recommendations/history | RecommendationService | recommendations | 5 |
| RF-45 | Usuarios | Creación de cuentas de usuario | User | POST /api/v1/admin/users | AdminUserService | users | 2 |
| RF-46 | Usuarios | Listado de usuarios registrados | User | GET /api/v1/admin/users | AdminUserService | users | 2 |
| RF-47 | Usuarios | Edición de información de usuarios | User | PUT /api/v1/admin/users/{id} | AdminUserService | users | 2 |
| RF-48 | Usuarios | Desactivación de cuentas | User | PATCH /api/v1/admin/users/{id}/deactivate | AdminUserService | users | 2 |
| RF-49 | Usuarios | Reactivación de cuentas | User | PATCH /api/v1/admin/users/{id}/reactivate | AdminUserService | users | 2 |
| RF-50 | Usuarios | Actividad reciente de usuarios | AuditLog | GET /api/v1/admin/users/{id}/activity | AuditService | audit_logs | 2 |

**Entregable:** Documento Excel o Markdown trazable.

**Criterio de aceptación:**
- [x] Todos los RF 01-38 y 45-50 tienen mapeo completo.
- [x] Endpoints claramente identificados con verbo HTTP y versionado `/api/v1/`.
- [x] Tablas de BD y entidades JPA asociadas.

**Estimación:** ~4 horas de análisis y documentación.

---

### O-0.2: Diagrama de Dependencias entre Fases

**Descripción**  
Mapear dependencias entre fases para validar el orden de implementación.

```
Fase 0 (Trazabilidad)
   ↓ (siempre primero)
Fase 1 (Base transversal: JWT, ErrorHandler, ApiResponse, Validación, Flyway, etc.)
   ↓
Fase 2 (Auth y Usuarios: requiere Fase 1 completada para SecurityConfig, JWT)
   ↓
Fase 3 (Cultivos: requiere Fase 2 completada para @PreAuthorize, Usuario autenticado)
   ↓
Fase 4 (Insumos: requiere Fase 3 completada para FK a Cultivo)
   ↓
Fase 5 (Recomendaciones: requiere Fase 3 y 4 completadas para generar recomendaciones basadas en Cultivos e Insumos)
```

**Entregable:** Documento visual de dependencias.

**Criterio de aceptación:**
- [x] Orden de fases validado.
- [x] No hay ciclos de dependencia.

**Estimación:** ~2 horas de validación.

---

## FASE 1 — Scaffolding Base y Infraestructura Transversal

### P1-1.1: Crear estructura pom.xml y dependencias

**Descripción**  
Configurar pom.xml con todas las dependencias necesarias: Spring Boot 3.x, Security, Data JPA, JWT, MapStruct, Lombok, Validation, OpenAPI, Flyway.

**Archivos a crear:**
- `pom.xml`

**Dependencias clave:**
```xml
<!-- Spring Boot -->
<spring-boot.version>3.2.x</spring-boot.version>

<!-- Spring Security + JWT -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt-api</artifactId>
  <version>0.12.x</version>
</dependency>
<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt-impl</artifactId>
  <version>0.12.x</version>
  <scope>runtime</scope>
</dependency>
<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt-jackson</artifactId>
  <version>0.12.x</version>
  <scope>runtime</scope>
</dependency>

<!-- Spring Data JPA + PostgreSQL -->
<spring-boot-starter-data-jpa/>
<postgresql driver/>

<!-- MapStruct -->
<mapstruct.version>1.5.x</mapstruct.version>

<!-- Lombok -->
<lombok.version>1.18.x</lombok.version>

<!-- Validation -->
<spring-boot-starter-validation/>

<!-- OpenAPI/Springdoc -->
<springdoc-openapi-starter-webmvc-ui/>

<!-- Flyway -->
<spring-boot-flyway/>
```

**Entregable:** pom.xml completo y funcional.

**Criterio de aceptación:**
- [x] pom.xml compila sin errores.
- [x] Todas las dependencias necesarias están presentes.
- [x] Lombok, MapStruct y Flyway configurados.

**Estimación:** ~2 horas.

---

### P1-1.2: Crear clase principal @SpringBootApplication

**Descripción**  
Crear clase de entrada de la aplicación con configuración base de Spring Boot.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/AgrointeligentBackendApplication.java`

**Contenido:**
```java
@SpringBootApplication
public class AgrointeligentBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(AgrointeligentBackendApplication.class, args);
    }
}
```

**Entregable:** Clase funcional.

**Criterio de aceptación:**
- [x] Aplicación arranca sin errores.

**Estimación:** ~30 minutos.

---

### P1-1.3: Configuración application.yml (dev y prod)

**Descripción**  
Crear perfiles de configuración para dev (H2 local opcional) y prod (PostgreSQL con env vars).

**Archivos a crear:**
- `src/main/resources/application.yml` (común)
- `src/main/resources/application-dev.yml`
- `src/main/resources/application-prod.yml`

**Contenido base:**
```yaml
# application.yml
spring:
  application:
    name: agrointeligente-backend
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: false
  jackson:
    serialization:
      indent-output: true
  security:
    jwt:
      secret: ${JWT_SECRET:change-me-in-production}
      expiration: ${JWT_EXPIRATION:86400000}  # 24 horas

server:
  port: 8080
  servlet:
    context-path: /

logging:
  level:
    root: INFO
    com.agrointeligente: DEBUG
```

**Entregable:** Archivos de configuración.

**Criterio de aceptación:**
- [x] Aplicación reconoce perfiles.
- [x] Variables de entorno se leen correctamente.

**Estimación:** ~1 hora.

---

### P1-1.4: Crear ApiResponse<T> y ErrorResponse

**Descripción**  
Definir clases de respuesta uniforme para toda la API.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/shared/dto/ApiResponse.java`
- `src/main/java/com/agrointeligente/backend/shared/dto/ErrorResponse.java`

**Contenido base:**
```java
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private LocalDateTime timestamp;
}

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
```

**Entregable:** DTO uniforme.

**Criterio de aceptación:**
- [x] Todos los Controllers retornan ResponseEntity<ApiResponse<T>>.
- [x] Todos los errores usan ErrorResponse.

**Estimación:** ~1 hora.

---

### P1-1.5: GlobalExceptionHandler @RestControllerAdvice

**Descripción**  
Implementar manejador centralizado de excepciones para toda la aplicación.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/shared/exception/GlobalExceptionHandler.java`
- `src/main/java/com/agrointeligente/backend/shared/exception/ResourceNotFoundException.java`
- `src/main/java/com/agrointeligente/backend/shared/exception/BusinessException.java`

**Excepciones manejadas:**
- ResourceNotFoundException (404)
- BusinessException (400)
- MethodArgumentNotValidException (400, validación)
- AccessDeniedException (403)
- AuthenticationException (401)
- Exception genérica (500)

**Entregable:** Handler completo.

**Criterio de aceptación:**
- [x] Todas las excepciones se capturan y retornan ErrorResponse uniforme.
- [x] Códigos HTTP correctos.

**Estimación:** ~2 horas.

---

### P1-1.6: Configuración JWT y SecurityConfig

**Descripción**  
Implementar proveedor JWT, filtro de autenticación y configuración de seguridad.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/shared/security/JwtProvider.java`
- `src/main/java/com/agrointeligente/backend/shared/security/JwtAuthenticationFilter.java`
- `src/main/java/com/agrointeligente/backend/shared/security/SecurityConfig.java`

**Rutas públicas permitidas:**
- POST /api/v1/auth/login
- POST /api/v1/auth/register
- POST /api/v1/auth/forgot-password

**Todas las demás:** requieren JWT válido.

**Entregable:** Seguridad funcional.

**Criterio de aceptación:**
- [x] Token JWT generado y validado correctamente.
- [x] Endpoints públicos accesibles sin token.
- [x] Endpoints protegidos rechazan requests sin token.
- [x] @PreAuthorize funciona con roles.

**Estimación:** ~3 horas.

---

### P1-1.7: OpenAPI/Springdoc Config

**Descripción**  
Configurar documentación automática de API con OpenAPI 3.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/shared/config/OpenApiConfig.java`

**Contenido:**
- Título, descripción, versión de la API
- Información de contacto
- Definición de SecurityScheme para JWT
- Tags por módulo

**Entregable:** Documentación disponible en `/v3/api-docs` y Swagger UI en `/swagger-ui.html`.

**Criterio de aceptación:**
- [x] Swagger UI accesible.
- [x] Todos los endpoints documentados.

**Estimación:** ~1 hora.

---

### P1-1.8: Flyway V1__Init.sql

**Descripción**  
Crear primera migración de BD con tablas base: users, roles, permissions, tokens.

**Archivos a crear:**
- `src/main/resources/db/migration/V1__init.sql`

**Tablas:**
```sql
CREATE TABLE roles (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL UNIQUE,
  description TEXT
);

CREATE TABLE permissions (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE role_permissions (
  role_id INT NOT NULL,
  permission_id INT NOT NULL,
  PRIMARY KEY (role_id, permission_id),
  FOREIGN KEY (role_id) REFERENCES roles(id),
  FOREIGN KEY (permission_id) REFERENCES permissions(id)
);

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(100) NOT NULL UNIQUE,
  email VARCHAR(255) NOT NULL UNIQUE,
  password_hash TEXT NOT NULL,
  role_id INT NOT NULL,
  status VARCHAR(20) DEFAULT 'ACTIVE',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE tokens (
  id SERIAL PRIMARY KEY,
  user_id INT NOT NULL,
  token TEXT NOT NULL UNIQUE,
  expires_at TIMESTAMP NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE login_attempts (
  id SERIAL PRIMARY KEY,
  user_id INT,
  email VARCHAR(255),
  ip_address VARCHAR(45),
  success BOOLEAN DEFAULT FALSE,
  attempted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Inserts para roles iniciales
INSERT INTO roles (name, description) VALUES ('ROLE_ADMIN', 'Administrador del sistema');
INSERT INTO roles (name, description) VALUES ('ROLE_USER', 'Usuario estándar');
INSERT INTO roles (name, description) VALUES ('ROLE_FARMER', 'Agricultor');
```

**Entregable:** Migración funcional.

**Criterio de aceptación:**
- [x] Flyway ejecuta sin errores.
- [x] Tablas creadas correctamente.

**Estimación:** ~1 hora.

---

### P1-1.9: Configuración de Audit (AuditLog, entidad y tabla)

**Descripción**  
Crear tabla de auditoría y entidad para registrar cambios en el sistema.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/shared/entity/AuditLog.java`
- Migración Flyway V2 para tabla `audit_logs`

**Contenido base:**
```sql
CREATE TABLE audit_logs (
  id SERIAL PRIMARY KEY,
  user_id INT,
  action VARCHAR(100),
  entity_type VARCHAR(100),
  entity_id INT,
  old_values TEXT,
  new_values TEXT,
  timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id)
);
```

**Entregable:** Auditoría funcional.

**Criterio de aceptación:**
- [x] Cambios en entidades se registran automáticamente.

**Estimación:** ~1.5 horas.

---

### P1-1.10: Validación y Bean Validation setup

**Descripción**  
Configurar validadores personalizados y anotaciones Jakarta Bean Validation.

**Archivos a crear:**
- Validadores personalizados si es necesario (p. ej. @ValidEmail, @ValidPassword)
- Configuración global de validación

**Entregable:** Validación lista en DTOs.

**Criterio de aceptación:**
- [x] @NotBlank, @NotNull, @Size y validadores personalizados funcionan.
- [x] Respuesta 400 con detalles de validación cuando falla.

**Estimación:** ~1 hora.

---

**Resumen Fase 1:**
- **Entregables:** pom.xml, clase principal, configuración, ApiResponse, ErrorHandler, JWT, SecurityConfig, OpenAPI, Flyway V1-V2, auditoría, validación.
- **Cobertura:** 0 RF (base transversal).
- **Estimación total:** ~16 horas.
- **Resultado esperado:** Plataforma lista para construir módulos sin retrabajo.

---

## FASE 2 — Autenticación, Usuarios y Perfil

### P2-2.1: Entidad User con validación JPA

**Descripción**  
Crear entidad JPA User con todos los campos necesarios.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/auth/entity/User.java`

**Campos:**
- id, username, email, passwordHash, role, status, createdAt, updatedAt, loginAttempts, lastLoginAt

**Entregable:** Entidad completa.

**Criterio de aceptación:**
- [x] Entidad valida y con anotaciones JPA.
- [x] Relación con Role correctamente mapeada.

**Estimación:** ~1 hora.

---

### P2-2.2: Entidad Role y Permission

**Descripción**  
Crear entidades Role y Permission para gestión de permisos.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/auth/entity/Role.java`
- `src/main/java/com/agrointeligente/backend/auth/entity/Permission.java`

**Entregable:** Entidades con relaciones.

**Criterio de aceptación:**
- [x] Roles ROLE_ADMIN, ROLE_USER, ROLE_FARMER están en BD.
- [x] Permisos asociados a roles.

**Estimación:** ~1 hora.

---

### P2-2.3: DTOs Auth (LoginRequest, LoginResponse, RegisterRequest)

**Descripción**  
Crear DTOs para autenticación con validación Bean Validation.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/auth/dto/LoginRequest.java`
- `src/main/java/com/agrointeligente/backend/auth/dto/LoginResponse.java`
- `src/main/java/com/agrointeligente/backend/auth/dto/RegisterRequest.java`
- `src/main/java/com/agrointeligente/backend/auth/dto/UserResponse.java`

**Validación:**
- @NotBlank, @Email, @Size, @Pattern para contraseña

**Entregable:** DTOs validados.

**Criterio de aceptación:**
- [x] Login/Register DTOs tienen validación.
- [x] LoginResponse contiene token JWT.

**Estimación:** ~1 hora.

---

### P2-2.4: UserRepository y RoleRepository

**Descripción**  
Crear repositorios JPA para User y Role.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/auth/repository/UserRepository.java`
- `src/main/java/com/agrointeligente/backend/auth/repository/RoleRepository.java`

**Métodos personalizados:**
- `findByUsername(String username)`
- `findByEmail(String email)`
- `findByNameIgnoreCase(String name)` en Role

**Entregable:** Repositorios funcionales.

**Criterio de aceptación:**
- [x] Querys personalizadas retornan Optional<T>.

**Estimación:** ~1 hora.

---

### P2-2.5: AuthService (interfaz + implementación)

**Descripción**  
Implementar lógica de negocio de autenticación: login, register, logout, cambio/recuperación de contraseña, bloqueo por intentos fallidos, vigencia de sesión.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/auth/service/AuthService.java` (interfaz)
- `src/main/java/com/agrointeligente/backend/auth/service/AuthServiceImpl.java`

**Métodos principales:**
- `login(LoginRequest) → LoginResponse` (con bloqueo por intentos fallidos)
- `register(RegisterRequest) → UserResponse`
- `logout(String token) → void`
- `changePassword(Long userId, ChangePasswordRequest) → void`
- `forgotPassword(String email) → void`
- `resetPassword(String token, String newPassword) → void`
- `validateToken(String token) → boolean`
- `refreshToken(String token) → LoginResponse`

**Lógica especial:**
- Bloqueo temporal después de N intentos fallidos (p. ej. 5).
- Contraseña hasheada con BCrypt.
- Token JWT con expiración de 24 horas (configurable).
- Vigencia de sesión: validar token no expirado.

**Entregable:** Servicio completo.

**Criterio de aceptación:**
- [x] Login retorna token JWT válido.
- [x] Contraseñas hasheadas con BCrypt.
- [x] Bloqueo por intentos fallidos implementado.
- [x] Recuperación de contraseña funciona.

**Estimación:** ~4 horas.

---

### P2-2.6: AuthController

**Descripción**  
Exponer endpoints de autenticación.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/auth/controller/AuthController.java`

**Endpoints:**
- POST /api/v1/auth/login
- POST /api/v1/auth/register
- POST /api/v1/auth/logout
- POST /api/v1/auth/forgot-password
- POST /api/v1/auth/reset-password
- PUT /api/v1/auth/change-password
- POST /api/v1/auth/refresh-token

**Entregable:** Controller documentado con OpenAPI.

**Criterio de aceptación:**
- [x] Todos los endpoints retornan ResponseEntity<ApiResponse<T>>.
- [x] Validación de entrada con @Valid.
- [x] Documentación OpenAPI completa.

**Estimación:** ~2 horas.

---

### P2-2.7: Entidad UserProfile

**Descripción**  
Crear entidad para gestionar perfil completo del usuario.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/user/entity/UserProfile.java`
- Migración Flyway V3 para tabla `user_profiles`

**Campos:**
- id, userId, firstName, lastName, phoneNumber, municipality, farm, language, photoUrl, notificationPreferences, createdAt, updatedAt

**Tabla:**
```sql
CREATE TABLE user_profiles (
  id SERIAL PRIMARY KEY,
  user_id INT NOT NULL UNIQUE,
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  phone_number VARCHAR(20),
  municipality VARCHAR(100),
  farm_name VARCHAR(255),
  language VARCHAR(10) DEFAULT 'es',
  photo_url TEXT,
  notification_preferences JSONB,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
```

**Entregable:** Entidad y migración.

**Criterio de aceptación:**
- [x] Perfil se crea automáticamente al registrar usuario.

**Estimación:** ~1.5 horas.

---

### P2-2.8: Entidad UserLocation

**Descripción**  
Crear entidad para ubicación geográfica del usuario.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/user/entity/UserLocation.java`
- Migración Flyway V4 para tabla `user_locations`

**Campos:**
- id, userId, latitude, longitude, createdAt, updatedAt

**Entregable:** Entidad y migración.

**Criterio de aceptación:**
- [x] Ubicación se persiste correctamente.

**Estimación:** ~1 hora.

---

### P2-2.9: DTOs UserProfile (UserProfileRequest, UserProfileResponse)

**Descripción**  
Crear DTOs para operaciones sobre perfil.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/user/dto/UserProfileRequest.java`
- `src/main/java/com/agrointeligente/backend/user/dto/UserProfileResponse.java`
- `src/main/java/com/agrointeligente/backend/user/dto/UserLocationRequest.java`
- `src/main/java/com/agrointeligente/backend/user/dto/UserLocationResponse.java`

**Validación:**
- Campos requeridos con @NotBlank y @NotNull según corresponda.

**Entregable:** DTOs validados.

**Estimación:** ~1 hora.

---

### P2-2.10: MapStruct Mapper User ↔ UserResponse, UserProfile ↔ UserProfileResponse

**Descripción**  
Crear mappers para convertir entidades ↔ DTOs.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/auth/mapper/UserMapper.java`
- `src/main/java/com/agrointeligente/backend/user/mapper/UserProfileMapper.java`
- `src/main/java/com/agrointeligente/backend/user/mapper/UserLocationMapper.java`

**Entregable:** Mappers automáticos.

**Criterio de aceptación:**
- [x] Conversiones bidireccionales funcionan.

**Estimación:** ~1.5 horas.

---

### P2-2.11: UserProfileService e implementación

**Descripción**  
Implementar lógica de negocio para gestión de perfiles.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/user/service/UserProfileService.java` (interfaz)
- `src/main/java/com/agrointeligente/backend/user/service/UserProfileServiceImpl.java`

**Métodos principales:**
- `createOrUpdateProfile(Long userId, UserProfileRequest) → UserProfileResponse`
- `getProfile(Long userId) → UserProfileResponse`
- `uploadProfilePhoto(Long userId, MultipartFile) → UserProfileResponse`
- `updateNotificationPreferences(Long userId, NotificationPreferences) → void`
- `updateLanguage(Long userId, String language) → void`

**Entregable:** Servicio completo.

**Criterio de aceptación:**
- [x] CRUD de perfil funciona.
- [x] Foto se almacena (o URL registrada).
- [x] Preferencias de notificación persistidas.

**Estimación:** ~3 horas.

---

### P2-2.12: UserProfileController

**Descripción**  
Exponer endpoints de gestión de perfil.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/user/controller/UserProfileController.java`

**Endpoints:**
- GET /api/v1/users/profile
- PUT /api/v1/users/profile
- POST /api/v1/users/profile/photo
- GET /api/v1/users/location
- POST /api/v1/users/location
- PUT /api/v1/users/location
- PUT /api/v1/users/notification-prefs
- PUT /api/v1/users/language

**Entregable:** Controller documentado.

**Criterio de aceptación:**
- [x] Endpoints protegidos con @PreAuthorize.
- [x] Documentación OpenAPI completa.

**Estimación:** ~2 horas.

---

### P2-2.13: AdminUserService e implementación

**Descripción**  
Implementar lógica de administración de usuarios en backoffice.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/admin/service/AdminUserService.java` (interfaz)
- `src/main/java/com/agrointeligente/backend/admin/service/AdminUserServiceImpl.java`

**Métodos principales:**
- `createUser(CreateUserRequest) → UserResponse`
- `listUsers(Pageable) → Page<UserResponse>`
- `updateUser(Long userId, UpdateUserRequest) → UserResponse`
- `deactivateUser(Long userId) → void`
- `reactivateUser(Long userId) → void`

**Entregable:** Servicio completo.

**Criterio de aceptación:**
- [x] CRUD de usuarios en backoffice funciona.
- [x] Solo ROLE_ADMIN puede crear/editar usuarios.

**Estimación:** ~2 horas.

---

### P2-2.14: AdminUserController

**Descripción**  
Exponer endpoints de administración de usuarios.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/admin/controller/AdminUserController.java`

**Endpoints:**
- POST /api/v1/admin/users
- GET /api/v1/admin/users (con paginación)
- GET /api/v1/admin/users/{id}
- PUT /api/v1/admin/users/{id}
- PATCH /api/v1/admin/users/{id}/deactivate
- PATCH /api/v1/admin/users/{id}/reactivate
- GET /api/v1/admin/users/{id}/activity

**Protección:** @PreAuthorize("hasRole('ROLE_ADMIN')")

**Entregable:** Controller protegido y documentado.

**Estimación:** ~2 horas.

---

### P2-2.15: Test unitario y de integración para Auth y UserProfile

**Descripción**  
Crear tests para AuthService, UserProfileService y sus controllers.

**Archivos a crear:**
- `src/test/java/com/agrointeligente/backend/auth/service/AuthServiceImplTest.java`
- `src/test/java/com/agrointeligente/backend/auth/controller/AuthControllerTest.java`
- `src/test/java/com/agrointeligente/backend/user/service/UserProfileServiceImplTest.java`
- `src/test/java/com/agrointeligente/backend/user/controller/UserProfileControllerTest.java`

**Cobertura:**
- Login con credenciales válidas e inválidas
- Bloqueo por intentos fallidos
- Cambio de contraseña
- Creación y edición de perfil
- Upload de foto
- Endpoints protegidos rechazan sin token

**Entregable:** Tests con >80% cobertura.

**Criterio de aceptación:**
- [x] Tests pasan todos.
- [x] Cobertura de líneas >80%.

**Estimación:** ~4 horas.

---

**Resumen Fase 2:**
- **Entregables:** Entidades (User, Role, Permission, UserProfile, UserLocation), DTOs, Mappers, AuthService, UserProfileService, AdminUserService, Controllers, Tests.
- **Cobertura RF:** RF-01 a RF-14 (perfil), RF-45 a RF-50 (usuarios backoffice).
- **Estimación total:** ~28 horas.
- **Resultado esperado:** Sistema de autenticación y administración de usuarios completamente funcional.

---

## FASE 3 — Gestión de Cultivos

### P3-3.1: Entidad Crop con validación JPA

**Descripción**  
Crear entidad Crop con todos los campos necesarios.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/crop/entity/Crop.java`
- Migración Flyway V5 para tabla `crops`

**Campos:**
- id, userId, name, type, area, sowingDate, harvestingDate, status, createdAt, updatedAt, deletedAt (soft delete)

**Tabla:**
```sql
CREATE TABLE crops (
  id SERIAL PRIMARY KEY,
  user_id INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  type VARCHAR(100),
  area DECIMAL(10, 2),
  sowing_date DATE,
  harvesting_date DATE,
  status VARCHAR(20) DEFAULT 'ACTIVE',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  deleted_at TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE INDEX idx_crops_user_id ON crops(user_id);
CREATE INDEX idx_crops_status ON crops(status);
```

**Entregable:** Entidad y migración.

**Criterio de aceptación:**
- [x] Soft delete implementado.
- [x] Índices creados.

**Estimación:** ~1.5 horas.

---

### P3-3.2: Entidades CropPhoto y CropObservation

**Descripción**  
Crear entidades para fotos y observaciones asociadas a cultivos.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/crop/entity/CropPhoto.java`
- `src/main/java/com/agrointeligente/backend/crop/entity/CropObservation.java`
- Migraciones Flyway V6 y V7

**Tablas:**
```sql
CREATE TABLE crop_photos (
  id SERIAL PRIMARY KEY,
  crop_id INT NOT NULL,
  photo_url TEXT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (crop_id) REFERENCES crops(id) ON DELETE CASCADE
);

CREATE TABLE crop_observations (
  id SERIAL PRIMARY KEY,
  crop_id INT NOT NULL,
  description TEXT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (crop_id) REFERENCES crops(id) ON DELETE CASCADE
);
```

**Entregable:** Entidades y migraciones.

**Estimación:** ~1 hora.

---

### P3-3.3: Entidad CropStatusHistory

**Descripción**  
Crear tabla de historial para rastrear cambios de estado de cultivos.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/crop/entity/CropStatusHistory.java`
- Migración Flyway V8

**Tabla:**
```sql
CREATE TABLE crop_status_history (
  id SERIAL PRIMARY KEY,
  crop_id INT NOT NULL,
  status VARCHAR(20),
  changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  changed_by_user_id INT,
  FOREIGN KEY (crop_id) REFERENCES crops(id) ON DELETE CASCADE,
  FOREIGN KEY (changed_by_user_id) REFERENCES users(id)
);
```

**Entregable:** Entidad y migración.

**Estimación:** ~1 hora.

---

### P3-3.4: DTOs Crop (CropRequest, CropResponse, CropDetailResponse)

**Descripción**  
Crear DTOs para operaciones sobre cultivos.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/crop/dto/CropRequest.java`
- `src/main/java/com/agrointeligente/backend/crop/dto/CropResponse.java`
- `src/main/java/com/agrointeligente/backend/crop/dto/CropDetailResponse.java`
- `src/main/java/com/agrointeligente/backend/crop/dto/CropPhotoResponse.java`
- `src/main/java/com/agrointeligente/backend/crop/dto/CropObservationResponse.java`

**Validación:**
- @NotBlank para name, type
- @NotNull para area, sowingDate
- @DecimalMin/@DecimalMax para area

**Entregable:** DTOs validados.

**Estimación:** ~1 hora.

---

### P3-3.5: CropRepository

**Descripción**  
Crear repositorio JPA para Crop con queries personalizadas.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/crop/repository/CropRepository.java`

**Métodos personalizados:**
- `findByUserIdAndStatusAndDeletedAtIsNull(Long userId, String status, Pageable)`
- `findByUserIdAndDeletedAtIsNull(Long userId, Pageable)`
- `findByIdAndUserId(Long id, Long userId)` (validación de ownership)

**Entregable:** Repositorio funcional.

**Estimación:** ~1 hora.

---

### P3-3.6: CropService (interfaz + implementación)

**Descripción**  
Implementar lógica de negocio de cultivos.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/crop/service/CropService.java` (interfaz)
- `src/main/java/com/agrointeligente/backend/crop/service/CropServiceImpl.java`

**Métodos principales:**
- `createCrop(Long userId, CropRequest) → CropResponse`
- `getCropById(Long userId, Long cropId) → CropDetailResponse`
- `listActiveCrops(Long userId, Pageable) → Page<CropResponse>`
- `updateCrop(Long userId, Long cropId, CropRequest) → CropResponse` (solo si no finalizado)
- `deleteCrop(Long userId, Long cropId) → void` (soft delete)
- `updateCropStatus(Long userId, Long cropId, String newStatus) → void`
- `addPhoto(Long userId, Long cropId, MultipartFile) → CropPhotoResponse`
- `addObservation(Long userId, Long cropId, String description) → CropObservationResponse`
- `searchAndFilterCrops(Long userId, CropFilterCriteria, Pageable) → Page<CropResponse>`

**Lógica especial:**
- Validar que solo el propietario pueda editar/eliminar.
- No permitir editar cultivos con estado FINALIZED.
- Registrar historial al cambiar estado.

**Entregable:** Servicio completo.

**Criterio de aceptación:**
- [x] CRUD funciona correctamente.
- [x] Validación de ownership.
- [x] Historial de cambios registrado.

**Estimación:** ~4 horas.

---

### P3-3.7: CropController

**Descripción**  
Exponer endpoints de gestión de cultivos.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/crop/controller/CropController.java`

**Endpoints:**
- POST /api/v1/crops (crear)
- GET /api/v1/crops (listar activos con paginación)
- GET /api/v1/crops/{id} (detalle)
- PUT /api/v1/crops/{id} (editar)
- DELETE /api/v1/crops/{id} (eliminar)
- PATCH /api/v1/crops/{id}/status (cambiar estado)
- POST /api/v1/crops/{id}/photos (subir foto)
- GET /api/v1/crops/{id}/photos (listar fotos)
- POST /api/v1/crops/{id}/observations (registrar observación)
- GET /api/v1/crops/{id}/observations (listar observaciones)
- GET /api/v1/crops/search (búsqueda y filtros)

**Protección:** @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_FARMER')")

**Entregable:** Controller documentado.

**Criterio de aceptación:**
- [x] Todos los endpoints protegidos.
- [x] Documentación OpenAPI completa.

**Estimación:** ~2 horas.

---

### P3-3.8: Test unitario y de integración para Crop

**Descripción**  
Crear tests para CropService y CropController.

**Archivos a crear:**
- `src/test/java/com/agrointeligente/backend/crop/service/CropServiceImplTest.java`
- `src/test/java/com/agrointeligente/backend/crop/controller/CropControllerTest.java`

**Cobertura:**
- CRUD completo
- Validación de ownership
- Cambios de estado
- Búsqueda y filtros
- Fotos y observaciones

**Entregable:** Tests con >80% cobertura.

**Estimación:** ~3 horas.

---

**Resumen Fase 3:**
- **Entregables:** Entidades (Crop, CropPhoto, CropObservation, CropStatusHistory), DTOs, Repository, Service, Controller, Tests.
- **Cobertura RF:** RF-15 a RF-23.
- **Estimación total:** ~18 horas.
- **Resultado esperado:** Gestión de cultivos completamente funcional.

---

## FASE 4 — Gestión de Insumos

### P4-4.1: Entidad Input (Catálogo de insumos)

**Descripción**  
Crear entidad Input para el catálogo de insumos disponibles.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/input/entity/Input.java`
- Migración Flyway V9

**Campos:**
- id, name, type, description, environmentalImpact (BOOLEAN o nivel)

**Tabla:**
```sql
CREATE TABLE inputs (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  type VARCHAR(100),
  description TEXT,
  high_environmental_impact BOOLEAN DEFAULT FALSE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

**Entregable:** Entidad y migración.

**Estimación:** ~1 hora.

---

### P4-4.2: Entidad InputApplication

**Descripción**  
Crear entidad para registrar aplicaciones de insumos en cultivos.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/input/entity/InputApplication.java`
- Migración Flyway V10

**Campos:**
- id, cropId, inputId, quantity, cost, applicationDate, createdAt, updatedAt

**Tabla:**
```sql
CREATE TABLE input_applications (
  id SERIAL PRIMARY KEY,
  crop_id INT NOT NULL,
  input_id INT NOT NULL,
  quantity DECIMAL(10, 2) NOT NULL,
  cost DECIMAL(10, 2),
  application_date DATE NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (crop_id) REFERENCES crops(id),
  FOREIGN KEY (input_id) REFERENCES inputs(id)
);

CREATE INDEX idx_input_applications_crop_id ON input_applications(crop_id);
```

**Entregable:** Entidad y migración.

**Estimación:** ~1 hora.

---

### P4-4.3: Entidad Alert

**Descripción**  
Crear entidad para alertas generadas por aplicación de insumos de alto impacto ambiental.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/input/entity/Alert.java`
- Migración Flyway V11

**Tabla:**
```sql
CREATE TABLE alerts (
  id SERIAL PRIMARY KEY,
  crop_id INT NOT NULL,
  input_id INT NOT NULL,
  message TEXT,
  severity VARCHAR(20),
  generated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (crop_id) REFERENCES crops(id),
  FOREIGN KEY (input_id) REFERENCES inputs(id)
);
```

**Entregable:** Entidad y migración.

**Estimación:** ~1 hora.

---

### P4-4.4: DTOs Input y InputApplication

**Descripción**  
Crear DTOs para operaciones de insumos.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/input/dto/InputRequest.java`
- `src/main/java/com/agrointeligente/backend/input/dto/InputResponse.java`
- `src/main/java/com/agrointeligente/backend/input/dto/InputApplicationRequest.java`
- `src/main/java/com/agrointeligente/backend/input/dto/InputApplicationResponse.java`
- `src/main/java/com/agrointeligente/backend/input/dto/AlertResponse.java`

**Validación:**
- @NotBlank para name en Input
- @NotNull y @DecimalMin para quantity y cost

**Entregable:** DTOs validados.

**Estimación:** ~1 hora.

---

### P4-4.5: InputRepository e InputApplicationRepository

**Descripción**  
Crear repositorios JPA.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/input/repository/InputRepository.java`
- `src/main/java/com/agrointeligente/backend/input/repository/InputApplicationRepository.java`
- `src/main/java/com/agrointeligente/backend/input/repository/AlertRepository.java`

**Métodos personalizados:**
- `findByCropIdOrderByApplicationDateDesc(Long cropId, Pageable)`
- `sumCostByCropId(Long cropId)`
- `findByInputHighEnvironmentalImpactTrue()`

**Entregable:** Repositorios funcionales.

**Estimación:** ~1 hora.

---

### P4-4.6: InputService e implementación

**Descripción**  
Implementar lógica de negocio de insumos.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/input/service/InputService.java` (interfaz)
- `src/main/java/com/agrointeligente/backend/input/service/InputServiceImpl.java`

**Métodos principales:**
- `getInputCatalog(Pageable) → Page<InputResponse>`
- `getInputById(Long id) → InputResponse`
- `createInput(InputRequest) → InputResponse` (solo ROLE_ADMIN)

**Entregable:** Servicio completo.

**Estimación:** ~1.5 horas.

---

### P4-4.7: InputApplicationService e implementación

**Descripción**  
Implementar lógica de negocio para aplicación de insumos.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/input/service/InputApplicationService.java` (interfaz)
- `src/main/java/com/agrointeligente/backend/input/service/InputApplicationServiceImpl.java`

**Métodos principales:**
- `registerApplication(Long userId, Long cropId, InputApplicationRequest) → InputApplicationResponse`
- `getApplicationHistory(Long userId, Long cropId, Pageable) → Page<InputApplicationResponse>`
- `updateApplication(Long userId, Long cropId, Long applicationId, InputApplicationRequest) → InputApplicationResponse` (con ventana de tiempo limitada, p. ej. 48 horas)
- `deleteApplication(Long userId, Long cropId, Long applicationId) → void`
- `calculateTotalInputCost(Long cropId) → BigDecimal`
- `getAlerts(Long userId, Long cropId) → List<AlertResponse>`

**Lógica especial:**
- Verificar ownership de crop.
- Ventana de edición: si aplicación > N horas, rechazar edición.
- Generar alerta automáticamente si Input.highEnvironmentalImpact == true.

**Entregable:** Servicio completo.

**Criterio de aceptación:**
- [x] Aplicación registrada y persistida.
- [x] Ventana de edición limitada implementada.
- [x] Alertas generadas automáticamente.

**Estimación:** ~3 horas.

---

### P4-4.8: InputController e InputApplicationController

**Descripción**  
Exponer endpoints de gestión de insumos.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/input/controller/InputController.java`
- `src/main/java/com/agrointeligente/backend/input/controller/InputApplicationController.java`

**Endpoints:**
- GET /api/v1/inputs/catalog (listar catálogo)
- GET /api/v1/inputs/{id} (detalle)
- POST /api/v1/inputs (crear, solo ADMIN)
- POST /api/v1/crops/{cropId}/input-applications (registrar aplicación)
- GET /api/v1/crops/{cropId}/input-applications (historial)
- PUT /api/v1/crops/{cropId}/input-applications/{appId} (editar)
- DELETE /api/v1/crops/{cropId}/input-applications/{appId} (eliminar)
- GET /api/v1/crops/{cropId}/input-costs (costo total)
- GET /api/v1/crops/{cropId}/alerts (alertas)

**Protección:** Rutas de usuario requieren ROLE_USER o ROLE_FARMER; creación de insumo requiere ROLE_ADMIN.

**Entregable:** Controllers documentados.

**Estimación:** ~2 horas.

---

### P4-4.9: Test unitario y de integración para Input

**Descripción**  
Crear tests para InputService e InputApplicationService.

**Archivos a crear:**
- `src/test/java/com/agrointeligente/backend/input/service/InputServiceImplTest.java`
- `src/test/java/com/agrointeligente/backend/input/service/InputApplicationServiceImplTest.java`
- `src/test/java/com/agrointeligente/backend/input/controller/InputApplicationControllerTest.java`

**Cobertura:**
- Registro de aplicación
- Historial
- Ventana de edición
- Cálculo de costos
- Generación de alertas

**Entregable:** Tests con >80% cobertura.

**Estimación:** ~3 horas.

---

**Resumen Fase 4:**
- **Entregables:** Entidades (Input, InputApplication, Alert), DTOs, Repositories, Services, Controllers, Tests.
- **Cobertura RF:** RF-24 a RF-31 (excepto recomendaciones de insumo, que van en Fase 5).
- **Estimación total:** ~18 horas.
- **Resultado esperado:** Gestión de insumos completamente funcional.

---

## FASE 5 — Recomendaciones

### P5-5.1: Entidad Recommendation

**Descripción**  
Crear entidad Recommendation para almacenar recomendaciones generadas.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/recommendation/entity/Recommendation.java`
- Migración Flyway V12

**Campos:**
- id, cropId, type (FERTILIZATION, PHYTOSANITARY, INPUT, etc.), description, justification, priority, status (ACTIVE, ATTENDED, DISCARDED), createdAt, discardedAt, attendedAt

**Tabla:**
```sql
CREATE TABLE recommendations (
  id SERIAL PRIMARY KEY,
  crop_id INT NOT NULL,
  type VARCHAR(50),
  description TEXT NOT NULL,
  justification TEXT,
  priority VARCHAR(20),
  status VARCHAR(20) DEFAULT 'ACTIVE',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  attended_at TIMESTAMP,
  discarded_at TIMESTAMP,
  discard_reason TEXT,
  FOREIGN KEY (crop_id) REFERENCES crops(id) ON DELETE CASCADE
);

CREATE INDEX idx_recommendations_crop_id ON recommendations(crop_id);
CREATE INDEX idx_recommendations_status ON recommendations(status);
```

**Entregable:** Entidad y migración.

**Estimación:** ~1 hora.

---

### P5-5.2: DTOs Recommendation

**Descripción**  
Crear DTOs para recomendaciones.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/recommendation/dto/RecommendationRequest.java`
- `src/main/java/com/agrointeligente/backend/recommendation/dto/RecommendationResponse.java`
- `src/main/java/com/agrointeligente/backend/recommendation/dto/RecommendationDetailResponse.java`

**Campos:**
- type, description, justification, priority, status

**Validación:**
- @NotBlank para description
- @NotNull para type y priority

**Entregable:** DTOs validados.

**Estimación:** ~1 hora.

---

### P5-5.3: RecommendationRepository

**Descripción**  
Crear repositorio JPA.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/recommendation/repository/RecommendationRepository.java`

**Métodos personalizados:**
- `findByCropIdAndStatus(Long cropId, String status, Pageable)`
- `findByCropIdOrderByPriorityDescCreatedAtDesc(Long cropId, Pageable)`
- `findByCropIdAndStatusNotOrderByPriorityDescCreatedAtDesc(Long cropId, String status, Pageable)` (historial)

**Entregable:** Repositorio funcional.

**Estimación:** ~1 hora.

---

### P5-5.4: RecommendationEngine (lógica de generación)

**Descripción**  
Implementar el motor que genera recomendaciones basadas en condiciones del cultivo.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/recommendation/service/RecommendationEngine.java`

**Lógica de generación:**
- **Recomendaciones de fertilización:** basadas en fase del ciclo del cultivo (siembra, crecimiento, floración, cosecha).
- **Recomendaciones fitosanitarias:** basadas en condiciones de riesgo (clima, historial de plagas, insumos aplicados).
- **Recomendaciones de insumo:** basadas en observaciones y necesidades del cultivo.

**Ejemplo simplificado:**
```java
if (crop.getCyclePhase() == "GROWTH") {
    recommend("Fertilizar con NPK balanceado", "FERTILIZATION", "MEDIUM");
}
if (hasHighRainfall && currentMonth == "RAINY_SEASON") {
    recommend("Aplicar fungicida preventivo", "PHYTOSANITARY", "HIGH");
}
```

**Entregable:** Motor funcional.

**Estimación:** ~3 horas.

---

### P5-5.5: RecommendationService (interfaz + implementación)

**Descripción**  
Implementar lógica de negocio de recomendaciones.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/recommendation/service/RecommendationService.java` (interfaz)
- `src/main/java/com/agrointeligente/backend/recommendation/service/RecommendationServiceImpl.java`

**Métodos principales:**
- `generateRecommendations(Long cropId) → List<RecommendationResponse>`
- `getActiveRecommendations(Long userId, Long cropId, Pageable) → Page<RecommendationResponse>`
- `getRecommendationDetail(Long userId, Long cropId, Long recommendationId) → RecommendationDetailResponse`
- `markAsAttended(Long userId, Long cropId, Long recommendationId) → void`
- `discardRecommendation(Long userId, Long cropId, Long recommendationId, String reason) → void`
- `getRecommendationHistory(Long userId, Long cropId, Pageable) → Page<RecommendationResponse>`

**Lógica especial:**
- Validar ownership de crop.
- Al marcar como atendida, registrar fecha.
- Al descartar, preservar historial (soft delete).
- Generar recomendaciones automáticamente al crear/actualizar cultivo o registrar insumo.

**Entregable:** Servicio completo.

**Criterio de aceptación:**
- [x] Recomendaciones se generan automáticamente.
- [x] Estados (ACTIVE, ATTENDED, DISCARDED) se gestionan correctamente.
- [x] Historial se preserva.

**Estimación:** ~3 horas.

---

### P5-5.6: RecommendationController

**Descripción**  
Exponer endpoints de recomendaciones.

**Archivos a crear:**
- `src/main/java/com/agrointeligente/backend/recommendation/controller/RecommendationController.java`

**Endpoints:**
- GET /api/v1/crops/{cropId}/recommendations (activas, ordenadas por prioridad)
- GET /api/v1/crops/{cropId}/recommendations/{recommendationId} (detalle)
- PATCH /api/v1/crops/{cropId}/recommendations/{recommendationId}/mark-attended (marcar atendida)
- PATCH /api/v1/crops/{cropId}/recommendations/{recommendationId}/discard (descartar)
- GET /api/v1/crops/{cropId}/recommendations/history (historial)
- POST /api/v1/crops/{cropId}/recommendations/generate (generar manualmente, solo si es necesario)

**Protección:** @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_FARMER')")

**Entregable:** Controller documentado.

**Estimación:** ~2 horas.

---

### P5-5.7: Event-driven recommendation generation (opcional, simplificado)

**Descripción**  
Generar recomendaciones automáticamente al crear/actualizar cultivos o registrar insumos.

**Implementación:**
- En CropService, al crear o actualizar un cultivo, invocar RecommendationEngine.
- En InputApplicationService, al registrar una aplicación de insumo, invocar RecommendationEngine.

**Entregable:** Integración automática.

**Estimación:** ~2 horas.

---

### P5-5.8: Test unitario y de integración para Recommendation

**Descripción**  
Crear tests para RecommendationService y RecommendationController.

**Archivos a crear:**
- `src/test/java/com/agrointeligente/backend/recommendation/service/RecommendationServiceImplTest.java`
- `src/test/java/com/agrointeligente/backend/recommendation/engine/RecommendationEngineTest.java`
- `src/test/java/com/agrointeligente/backend/recommendation/controller/RecommendationControllerTest.java`

**Cobertura:**
- Generación de recomendaciones
- Estados (activas, atendidas, descartadas)
- Historial
- Endpoints protegidos

**Entregable:** Tests con >80% cobertura.

**Estimación:** ~3 horas.

---

**Resumen Fase 5:**
- **Entregables:** Entidad Recommendation, DTOs, Repository, RecommendationEngine, RecommendationService, Controller, Tests.
- **Cobertura RF:** RF-31 a RF-38 y RF-53.
- **Estimación total:** ~18 horas.
- **Resultado esperado:** Motor de recomendaciones funcional y consultable.

---

## RESUMEN GLOBAL DE COBERTURA

| Fase | Requisitos | Horas | Resultado |
|------|-----------|-------|-----------|
| 0 | Trazabilidad | 6 | Plan estructurado |
| 1 | Infraestructura | 16 | Plataforma base |
| 2 | Auth + Usuarios + Perfil | 28 | ~RF-01 a RF-14, RF-45 a RF-50 |
| 3 | Cultivos | 18 | ~RF-15 a RF-23 |
| 4 | Insumos | 18 | ~RF-24 a RF-30 |
| 5 | Recomendaciones | 18 | ~RF-31 a RF-38 y RF-53 |
| **TOTAL** | | **104 horas** | **~80.36% cobertura funcional** |

**Requisitos NO cubiertos en este backlog (Fase 6 - descartada):**
- RF-39 a RF-44: Reportes (estado, consumo, alertas, PDF, filtros temporales, comparativos)
- RF-51, RF-52, RF-54 a RF-56: Notificaciones internas (clima, recomendaciones, sincronización offline, historial, eliminación)
- Sincronización offline completa (depende del cliente)

**Cobertura final estimada:** 45 de 56 RF = 80.36% del total funcional backend.

---

## Próximos Pasos Después de Fase 5

1. **Testing e2e:** Validar flujos completos (auth → crear cultivo → registrar insumo → generar recomendación).
2. **Documentación API:** Generar especificación OpenAPI y guía de consumo para frontend.
3. **Optimización:** Índices de BD, caché, paginación avanzada.
4. **Fase 6 (Opcional):** Reportes y notificaciones avanzadas.
5. **Sincronización offline:** Integración con cliente móvil.

---

**Versión:** 1.0  
**Fecha:** 28 de Abril de 2026  
**Autor:** java-backend-architect agent  
**Estado:** Listo para confirmar y proceder con Fase 0.
