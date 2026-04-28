# Swagger/OpenAPI - Documentacion Interactiva Agregada

## Fecha de Implementacion
28 de abril de 2026

## Integracion Completada

Se agregó documentación interactiva con Swagger/OpenAPI a todos los endpoints de la API.

## Instalacion y Configuracion

### Dependencias (ya en pom.xml)
- `springdoc-openapi-starter-webmvc-ui:2.6.0` - Proporciona Swagger UI
- Anotaciones OpenAPI para documentacion automática

### Archivos Modificados
1. **OpenApiConfig.java** (nueva)
   - Configura titulo, version y contacto de la API
   - Define esquema de seguridad Bearer JWT
   - Proporciona informacion general de la API

2. **AuthController.java** (actualizado)
   - `@Tag` - Agrupa endpoints bajo "Autenticacion"
   - `@Operation` - Documenta cada endpoint con descripcion
   - `@ApiResponses` - Define codigos de respuesta posibles

3. **UserProfileController.java** (actualizado)
   - `@Tag` - Agrupa endpoints bajo "Perfil de Usuario"
   - `@Operation` - Documenta operaciones de perfil

4. **AdminUserController.java** (actualizado)
   - `@Tag` - Agrupa endpoints bajo "Administracion de Usuarios"
   - `@SecurityRequirement` - Marca endpoints que requieren autenticacion

5. **application.yml** (actualizado)
   ```yaml
   springdoc:
     api-docs:
       path: /v3/api-docs
     swagger-ui:
       path: /swagger-ui.html
       enabled: true
   ```

## URLs de Acceso

Cuando el servidor esté corriendo en `localhost:8080`:

1. **Swagger UI (Interfaz Interactiva)**
   - URL: `http://localhost:8080/swagger-ui.html`
   - Permite probar endpoints directamente
   - Visualización interactiva de la API
   - Autorización JWT integrada

2. **OpenAPI JSON Spec**
   - URL: `http://localhost:8080/v3/api-docs`
   - Especificacion completa en formato JSON
   - Compatible con herramientas externas (Insomnia, Postman, etc.)

## Anotaciones Utilizadas

### @Tag
Agrupa endpoints logicamente en Swagger UI
```java
@Tag(name = "Autenticacion", description = "Endpoints para autenticacion...")
```

### @Operation
Documenta operacion individual
```java
@Operation(summary = "Autenticacion de usuario", description = "Realiza login...")
```

### @ApiResponses / @ApiResponse
Define posibles respuestas HTTP
```java
@ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Exito"),
    @ApiResponse(responseCode = "400", description = "Error")
})
```

### @SecurityRequirement
Marca que endpoint requiere autenticacion
```java
@SecurityRequirement(name = "bearerAuth")
```

## Esquema de Seguridad

Se configuro autenticacion Bearer JWT en OpenAPI:
- Tipo: HTTP Bearer
- Formato: JWT
- Se puede usar directamente en Swagger UI para probar endpoints

## Caracteristicas Swagger

✓ Documentacion automática de endpoints
✓ Probador interactivo de APIs
✓ Esquemas de request/response
✓ Validaciones y restricciones
✓ Seguridad Bearer JWT integrada
✓ Exportacion a formato OpenAPI 3.0
✓ Compatible con Postman, Insomnia, etc.

## Proximo Paso

Cuando quieras iniciar el servidor localmente:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

Luego accede a: `http://localhost:8080/swagger-ui.html`

## Endpoints Documentados

### Autenticacion (/api/v1/auth)
- POST /login
- POST /register
- POST /refresh-token
- POST /logout
- POST /forgot-password
- POST /reset-password
- POST /change-password

### Perfil de Usuario (/api/v1/users/profile)
- GET /{userId}
- PUT /{userId}
- DELETE /{userId}
- GET /{userId}/location
- POST /{userId}/location
- PUT /location/{locationId}

### Administracion (/api/v1/admin/users)
- GET / (listado con paginacion)
- GET /by-role (por rol)
- GET /{userId}
- PUT /{userId}/activate
- PUT /{userId}/deactivate
- PUT /{userId}/role
- DELETE /{userId}

## Validacion Local

La compilacion local fue exitosa (Fase 2):
- 43 archivos Java compilados
- 0 errores de compilacion
- Listo para arriba en ambiente local

Proximos pasos:
1. Inicio del servidor con Maven o IDE
2. Acceso a Swagger UI para validar endpoints
3. Fase 3: Modulo de Cultivos
