# PROYECTO EXPERIENCIA FINAL DE DISEÑO (CAPSTONE DESIGN)

## CURSO ARQUITECTURA DE SOFTWARE
## PROGRAMA DE INGENIERÍA DE SISTEMAS
## UNIMAGDALENA

---

# Título del Proyecto

**Plataforma Digital de Agricultura Inteligente para Pequeños Productores del Magdalena**

---

# Documento de Comparación y Selección de Arquitectura

Este documento consolida la comparación entre dos alternativas viables para la plataforma y justifica la arquitectura seleccionada, de acuerdo con el contexto rural, las restricciones del proyecto y el alcance actual del curso: **monolito modular por capas expuesto como API pura**, consumido por uno o varios clientes frontales independientes. La primera experiencia de uso será un frontend web responsivo; la arquitectura queda lista para otros clientes sin acoplar la presentación al backend.

La redacción y decisiones de este entregable están alineadas con [Entregable-1.1.md](Entregable-1.1.md), especialmente con: alcance web inicial, stack tecnológico (React + Spring Boot + PostgreSQL), catálogo de requerimientos funcionales RF-01 a RF-62 y requerimientos no funcionales RNF-01 a RNF-28.

---

## 1. Alternativas Propuestas

### Alternativa 1: Arquitectura de Microservicios

- **Estilo arquitectónico:** microservicios orientados a dominio.
- **Estructura general:** frontend web (React) + API Gateway + microservicios Spring Boot por dominio (usuarios, cultivos, recomendaciones, alertas, reportes) + PostgreSQL por servicio o esquema segregado + mensajería para eventos.
- **Ventaja principal:** alta escalabilidad y despliegue independiente por módulo.
- **Desventaja principal:** mayor complejidad operativa y de coordinación para un equipo pequeño.

### Alternativa 2: Arquitectura por Capas 

- **Estilo arquitectónico:** cliente-servidor por capas (presentación, aplicación, dominio, persistencia).
- **Estructura general:** clientes frontales independientes (web principal y otros futuros) + backend único en Spring Boot organizado por módulos + PostgreSQL + seguridad centralizada.
- **Ventaja principal:** menor complejidad técnica y mayor velocidad de implementación.
- **Desventaja principal:** escalabilidad menos granular en etapas de crecimiento alto.

---

## 2. Tabla Comparativa

Escala utilizada: 1 = muy desfavorable, 5 = muy favorable. La ponderación refleja el peso relativo de cada criterio para este proyecto.

| Criterio | Ponderación | Alternativa 1 (Microservicios) | Puntaje Alt. 1 | Alternativa 2 (Capas) | Puntaje Alt. 2 |
|---|---:|---:|---:|---:|---:|
| Costo relativo | 4 | 2 | 8 | 4 | 16 |
| Tiempo de implementación | 4 | 2 | 8 | 5 | 20 |
| Escalabilidad | 3 | 5 | 15 | 3 | 9 |
| Seguridad | 4 | 4 | 16 | 4 | 16 |
| Complejidad técnica | 5 | 2 | 10 | 5 | 25 |
| **Total ponderado** | **20** |  | **57 / 100** |  | **86 / 100** |

Los criterios y ponderaciones se definieron considerando los atributos de calidad y restricciones priorizadas en [Entregable-1.1.md](Entregable-1.1.md): rendimiento web, seguridad, mantenibilidad, costo operativo y viabilidad para equipo pequeño en tiempo académico limitado.

---

## 3. Decisión Justificada

La alternativa seleccionada es la **Alternativa 2: Arquitectura por Capas con Spring Boot**. Aunque la arquitectura de microservicios ofrece mejor escalabilidad y autonomía por dominio, la alternativa seleccionada responde mejor al alcance actual porque prioriza simplicidad, velocidad de implementación y control técnico, sin acoplar la presentación al backend.

Los criterios más determinantes fueron:

- **Complejidad técnica**, porque el equipo es pequeño y el plazo es limitado.
- **Tiempo de implementación**, para lograr un prototipo web funcional y evaluable dentro del curso.
- **Costo y operación**, para evitar sobrecostos en infraestructura distribuida y observabilidad avanzada.
- **Mantenibilidad**, porque una base única en Spring Boot facilita pruebas, integración y trazabilidad.
- **Desacoplamiento de clientes**, porque la misma API puede ser consumida por varios frontends independientes sin duplicar lógica de negocio.

Esta selección permite cubrir de forma más directa los bloques funcionales definidos en [Entregable-1.1.md](Entregable-1.1.md):

- Autenticación y acceso.
- Usuarios y perfil.
- Cultivos.
- Insumos.
- Clima, alertas y recomendaciones.
- Reportes y notificaciones.

---

## 4. Análisis de Trade-offs

### Qué se gana y qué se sacrifica con cada alternativa

- **Microservicios ganan** en escalabilidad horizontal, aislamiento de fallos y despliegues independientes por servicio, pero **sacrifican** simplicidad de desarrollo inicial y demandan mayor madurez DevOps.
- **Arquitectura por capas gana** en velocidad de construcción, facilidad de pruebas integradas y gobierno técnico centralizado, pero **sacrifica** flexibilidad de escalado fino por módulo.

### Restricciones que influyeron más en la decisión

Las restricciones con mayor peso fueron el **equipo de desarrollo limitado**, el **tiempo del semestre**, el **presupuesto acotado** y la necesidad de una **entrega técnica estable**. Estas condiciones favorecen una solución por capas sobre una arquitectura distribuida con mayor complejidad operativa.

En términos de trazabilidad, la arquitectura por capas responde mejor a las restricciones y RNF del entregable 1.1: disponibilidad mínima, tiempos de respuesta, seguridad por roles, trazabilidad de acciones, compatibilidad web responsiva y despliegue de bajo costo.

### Equilibrio entre costo, tiempo y calidad

La decisión equilibra costo, tiempo y atributos de calidad. Se prioriza construir una solución API robusta con Spring Boot y PostgreSQL, manteniendo abiertos varios clientes frontales independientes y la evolución futura a microservicios cuando el volumen de usuarios o la complejidad del dominio lo justifique.

---
    