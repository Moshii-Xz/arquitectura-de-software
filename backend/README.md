# Agro Inteligente Backend

Backend monolítico modular en Spring Boot para la plataforma de agricultura inteligente.

## Requisitos

- Java 21
- Maven 3.9+
- PostgreSQL

## Ejecución

```bash
mvn spring-boot:run
```

## Perfiles

- `dev`: PostgreSQL local con Flyway y validación del esquema.
- `embedded`: PostgreSQL embebido para validación rápida en Windows.

## Módulos principales

- `auth`: registro, login y JWT.
- `usuarios`: gestión de usuarios y perfil.
- `cultivos`: CRUD de cultivos.
- `insumos`: catálogo y aplicaciones de insumos.
- `recomendaciones`: CRUD y estado de recomendaciones.
- `reportes`: generación y CRUD de reportes.
- `clima`: integración REST con API externa o simulación.
- `notificaciones`: almacenamiento y lectura de alertas.

## Documentación funcional

Ver [API-trazabilidad.md](API-trazabilidad.md) para el mapeo de endpoints, casos de uso y requerimientos funcionales.