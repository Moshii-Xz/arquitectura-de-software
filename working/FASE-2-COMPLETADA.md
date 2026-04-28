# Fase 2: Autenticación, Usuarios y Perfil - COMPLETADA

## Fecha de Finalización
28 de abril de 2026

## Resumen
Se implementó completamente el módulo de autenticación y gestión de usuarios con JWT, incluyendo:
- Autenticación con email y contraseña
- Registro de nuevos usuarios
- Recuperación de contraseña
- Cambio de contraseña
- Gestión de perfiles de usuario
- Administración de usuarios por backoffice
- Rastreo de intentos de login fallidos
- Sistema de bloqueo por intentos fallidos

## Archivos Creados

### Migraciones Flyway
- `V2__create_roles_and_permissions.sql` - Tabla de roles y permisos
- `V3__create_users_table.sql` - Tablas User, LoginAttempt, PasswordReset, Token
- `V4__create_user_profile_and_location.sql` - Tablas UserProfile, UserLocation, NotificationPreference

### Entidades JPA (8 archivos)
- `Role.java` - Entidad de roles con relacion muchos-a-muchos con Permission
- `Permission.java` - Entidad de permisos
- `User.java` - Entidad principal de usuario con referencias a Role
- `LoginAttempt.java` - Registro de intentos de login
- `PasswordReset.java` - Solicitud de reset de contraseña
- `UserProfile.java` - Perfil extendido del usuario
- `UserLocation.java` - Ubicacion geografica del usuario
- `NotificationPreference.java` - Preferencias de notificacion

### DTOs (8 archivos)
- `LoginRequest.java` - DTO para login
- `LoginResponse.java` - DTO de respuesta de login con token
- `RegisterRequest.java` - DTO para registro de nuevo usuario
- `UserDto.java` - DTO de usuario
- `ChangePasswordRequest.java` - DTO para cambio de contraseña
- `UserProfileDto.java` - DTO de perfil de usuario
- `UserLocationDto.java` - DTO de ubicacion de usuario
- `NotificationPreferenceDto.java` - DTO de preferencias de notificacion

### Repositorios JPA (7 archivos)
- `UserRepository.java` - Consultas de usuario por email/username
- `RoleRepository.java` - Consultas de rol por nombre
- `LoginAttemptRepository.java` - Rastreo de intentos de login
- `PasswordResetRepository.java` - Gestion de tokens de reset
- `UserProfileRepository.java` - Acceso a perfiles de usuario
- `UserLocationRepository.java` - Acceso a ubicaciones
- `NotificationPreferenceRepository.java` - Acceso a preferencias

### Mappers MapStruct (4 archivos)
- `UserMapper.java` - Conversion User ↔ UserDto
- `UserProfileMapper.java` - Conversion UserProfile ↔ UserProfileDto
- `UserLocationMapper.java` - Conversion UserLocation ↔ UserLocationDto con soporte BigDecimal
- `NotificationPreferenceMapper.java` - Conversion NotificationPreference ↔ NotificationPreferenceDto

### Servicios (5 archivos)
- `AuthService.java` - Interfaz de servicio de autenticacion
- `AuthServiceImpl.java` - Implementacion de autenticacion con JWT, validacion de contraseña, bloqueo por intentos fallidos
- `UserProfileService.java` - Interfaz de servicio de perfil de usuario
- `UserProfileServiceImpl.java` - Implementacion de gestion de perfiles y ubicaciones
- `AdminUserService.java` - Interfaz para administracion de usuarios
- `AdminUserServiceImpl.java` - Implementacion de administracion: activacion, desactivacion, cambio de rol

### Controladores REST (3 archivos)
- `AuthController.java` - Endpoints: /login, /register, /refresh-token, /logout, /forgot-password, /reset-password, /change-password
- `UserProfileController.java` - Endpoints para gestion de perfil y ubicacion del usuario
- `AdminUserController.java` - Endpoints para backoffice: listado, busqueda, activacion, desactivacion, cambio de rol

### Utilidades de JWT
- `JwtProvider.java` - Generacion, validacion y extraccion de claims de tokens JWT
- `SecurityConfig.java` - Configuracion de BCryptPasswordEncoder

## Endpoints Implementados

### Autenticacion (/api/v1/auth)
```
POST   /login                 - Autenticacion con email y contraseña
POST   /register              - Registro de nuevo usuario
POST   /refresh-token         - Renovacion de token JWT
POST   /logout                - Cierre de sesion
POST   /forgot-password       - Solicitud de reset de contraseña
POST   /reset-password        - Cambio de contraseña con token
POST   /change-password       - Cambio de contraseña autenticado
```

### Perfil de Usuario (/api/v1/users/profile)
```
GET    /{userId}              - Obtener perfil de usuario
PUT    /{userId}              - Actualizar perfil de usuario
DELETE /{userId}              - Eliminar perfil de usuario
GET    /{userId}/location     - Obtener ultima ubicacion
POST   /{userId}/location     - Crear nueva ubicacion
PUT    /location/{locationId} - Actualizar ubicacion
```

### Admin de Usuarios (/api/v1/admin/users)
```
GET                           - Listar todos los usuarios (paginado)
GET    /by-role?roleName=     - Listar usuarios por rol
GET    /{userId}              - Obtener detalles de usuario
PUT    /{userId}/activate     - Activar usuario
PUT    /{userId}/deactivate   - Desactivar usuario
PUT    /{userId}/role         - Cambiar rol de usuario
DELETE /{userId}              - Eliminar usuario
```

## Configuraciones Agregadas

### application.yml
```yaml
app:
  jwt:
    secret: ${JWT_SECRET:9a8f7c...}
    expiration: ${JWT_EXPIRATION:86400000}       # 24 horas
    refresh-expiration: ${JWT_REFRESH_EXPIRATION:604800000} # 7 dias
  max-login-attempts: 5
  lock-timeout-minutes: 15
```

## Caracteristicas Implementadas

### Seguridad
- [x] Hashing de contrasenas con BCrypt
- [x] Generacion de JWT para tokens stateless
- [x] Validacion de tokens con JJWT
- [x] Rastreo de intentos de login fallidos
- [x] Bloqueo de cuenta despues de N intentos
- [x] Tokens de reset de contraseña con expiracion
- [x] Validacion de email unico
- [x] Validacion de username unico

### Funcionalidades
- [x] Login/Logout
- [x] Registro de nuevo usuario
- [x] Cambio/Reset de contraseña
- [x] Gestion de perfiles de usuario
- [x] Gestion de ubicaciones geograficas
- [x] Preferencias de notificacion
- [x] Administracion de usuarios (backoffice)
- [x] Control de estado de cuenta (ACTIVE/INACTIVE)
- [x] Asignacion de roles

## Requisitos Funcionales Cubiertos

✓ RF-01: Login/Logout
✓ RF-02: Registro de usuario
✓ RF-03: Cambio de contraseña
✓ RF-04: Recuperacion de contraseña
✓ RF-05: Gestion de perfil
✓ RF-06: Registro de ubicacion
✓ RF-07 a RF-14: Gestion de usuarios (backoffice)

## Proximos Pasos

- Fase 3: Modulo de Cultivos (18 horas)
  - Crear, leer, actualizar, eliminar cultivos
  - Historial de estado de cultivos
  - Fotos de cultivos
  - Observaciones
  - Busqueda y filtrado

- Fase 4: Modulo de Insumos (18 horas)
  - Catalogo de insumos
  - Aplicacion de insumos
  - Calculo de costos
  - Alertas para insumos de alto impacto

- Fase 5: Modulo de Recomendaciones (18 horas)
  - Motor de recomendaciones
  - Generacion basada en condiciones
  - Historial de recomendaciones

## Testing

Los tests unitarios estan deferred para ser implementados despues de validacion en ambiente local.
Se recomienda usar JUnit 5 y Mockito para testing de servicios y controladores.

## Compilacion

El scaffold compila correctamente con:
- Java 17
- Spring Boot 3.3.5
- Maven 3.9+

Todos los archivos fueron generados siguiendo:
- Spring Boot best practices
- REST API conventions
- Clean Architecture principles
- SOLID principles
