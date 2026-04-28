# Comparación y Análisis de Trade-offs

## 1. Tabla Comparativa Detallada

| Criterio | Peso | Microservicios | Monolito Modular por Capas + API Pura |
|----------|------|----------------|----------------------------------------|
| **COSTOS Y ECONOMÍA** | | | |
| Costo inicial de desarrollo | 10% | 2/5 - Más complejidad de arranque | 5/5 - Arranque más directo |
| Costo de operación mensual | 15% | 2/5 - Más infraestructura y observabilidad | 5/5 - VPS/PaaS simple y predecible |
| Costo de mantenimiento | 10% | 2/5 - Mayor carga DevOps | 4/5 - Menos piezas distribuidas |
| Recursos humanos necesarios | 10% | 2/5 - Requiere más especialización | 5/5 - Equipo pequeño puede abordarlo |
| **RENDIMIENTO Y TÉCNICA** | | | |
| Velocidad de implementación | 15% | 2/5 - Overhead de distribución | 5/5 - Entrega más rápida |
| Latencia entre componentes | 15% | 3/5 - Llamadas red entre servicios | 5/5 - Llamadas internas locales |
| Seguridad y control de acceso | 10% | 4/5 - Posible, pero más distribuido | 5/5 - Control centralizado en la API |
| Trazabilidad y debugging | 10% | 2/5 - Logs y fallos distribuidos | 5/5 - Trazabilidad centralizada |
| **ESCALABILIDAD Y FUTURO** | | | |
| Escalado independiente por módulo | 10% | 5/5 - Fuerte ventaja | 3/5 - Escalado principalmente vertical |
| Evolución futura | 5% | 4/5 - Ya distribuido | 5/5 - Modularidad facilita migración |
| Complejidad operativa | 5% | 2/5 - Alta complejidad | 5/5 - Complejidad contenida |
| **PUNTAJE TOTAL** | **100%** | **Menor adecuación al contexto** | **Mayor adecuación al contexto** |

### Síntesis del Resultado

La comparación muestra una diferencia clara a favor del **Monolito Modular por Capas + API Pura** en los criterios más importantes para este proyecto: costo, velocidad de implementación, trazabilidad, mantenibilidad y simplicidad operativa.

Microservicios solo gana de forma relevante en escalabilidad independiente por dominio, pero ese beneficio no compensa la complejidad adicional para un equipo pequeño y un plazo académico corto.

En consecuencia, la arquitectura elegida es la que ofrece la mejor relación entre viabilidad técnica y esfuerzo de ejecución en el contexto actual.

---

## 2. Análisis de Trade-offs Principales

### Trade-off 1: Escalabilidad independiente vs simplicidad operativa

#### Microservicios
- ✅ **GANA:** Escalado independiente por dominio.
- ❌ **PIERDE:** Mayor costo de coordinación, despliegue y monitoreo.

#### Monolito Modular por Capas + API Pura
- ✅ **GANA:** Menor complejidad operativa y entrega más rápida.
- ❌ **PIERDE:** Escalado independiente por módulo no es nativo.

**Decisión:** Para un equipo pequeño y 4 meses de trabajo, la simplicidad operativa pesa más. **Favorece Alternativa 2.**

---

### Trade-off 2: Independencia tecnológica vs gobierno técnico centralizado

#### Microservicios
- ✅ **GANA:** Cada servicio puede evolucionar con mayor independencia.
- ❌ **PIERDE:** Gobernanza técnica más difícil.

#### Monolito Modular por Capas + API Pura
- ✅ **GANA:** Gobierno técnico centralizado, trazabilidad y consistencia.
- ❌ **PIERDE:** Menos autonomía por componente.

**Decisión:** La necesidad de trazabilidad, pruebas y consistencia documental favorece el modelo monolítico modular. **Favorece Alternativa 2.**

---

### Trade-off 3: Escala extrema vs costo predecible

#### Microservicios
- ✅ **GANA:** Mejor para crecimiento masivo y equipos grandes.
- ❌ **PIERDE:** Más servicios, más costos ocultos.

#### Monolito Modular por Capas + API Pura
- ✅ **GANA:** Costos operativos más estables y bajos.
- ❌ **PIERDE:** Requiere revisión si el sistema crece mucho.

**Decisión:** El proyecto no necesita escala masiva inmediata; sí necesita presupuesto controlado. **Favorece Alternativa 2.**

---

## 3. Influencia de Restricciones en la Decisión

### Restricciones críticas que favorecen Alternativa 2

| Restricción | Cómo influye | Impacto |
|-------------|--------------|---------|
| **RE-03: 4 meses de desarrollo** | Menos complejidad y menos coordinación | 🔴 Muy alto |
| **RE-02: Equipo pequeño** | Facilita trabajo coordinado | 🔴 Alto |
| **RE-01: Presupuesto limitado** | Menos infraestructura distribuida | 🔴 Alto |
| **RNF de trazabilidad** | API pura centraliza logs y validaciones | 🟡 Medio |
| **RNF de mantenibilidad** | Capas bien definidas simplifican mantenimiento | 🟡 Medio |

### Restricciones que favorecen microservicios

| Restricción | Cómo influye | Impacto |
|-------------|--------------|---------|
| **Escalabilidad futura muy alta** | Permite crecimiento independiente por servicio | 🟢 Bajo (no crítico ahora) |
| **Equipos grandes distribuidos** | Facilita ownership por servicio | 🟢 Bajo (no es el caso) |

---

## 4. Equilibrio Costo-Tiempo-Calidad

### Microservicios
- **Costo:** Bajo al inicio no, medio/alto.
- **Tiempo:** Más lento.
- **Calidad operativa temprana:** Menor por complejidad.

### Monolito Modular por Capas + API Pura
- **Costo:** Bajo y predecible.
- **Tiempo:** Mejor para entregar dentro del curso.
- **Calidad operativa temprana:** Mayor por menor complejidad.

**Conclusión:** La arquitectura elegida ofrece el mejor equilibrio para esta fase académica.

---

## 5. Riesgos Comparativos

| Riesgo | Microservicios | Monolito Modular por Capas + API Pura |
|--------|----------------|----------------------------------------|
| **Complejidad técnica excede capacidad del equipo** | 🔴 Alto | 🟢 Bajo |
| **Costo operativo se dispara** | 🔴 Alto | 🟢 Bajo |
| **Debugging y trazabilidad** | 🔴 Difícil | 🟢 Sencillo |
| **Escalado futuro insuficiente** | 🟢 Bajo | 🟡 Medio |
| **Cambios por dominio mal aislados** | 🟢 Bajo | 🟡 Medio |

---

## 6. Decisión Justificada

### ✅ ALTERNATIVA SELECCIONADA: **Monolito Modular por Capas + API REST/GraphQL + PostgreSQL + Clientes Frontales Independientes**

### Justificación Detallada

#### Criterios Determinantes

1. **Consistencia con el alcance actual del proyecto**
   - El producto se implementará como backend API pura consumida por uno o varios clientes frontales independientes.
   - Se elimina el acoplamiento entre presentación y backend.

2. **Robustez del backend empresarial**
   - Spring Boot ofrece una base sólida para API REST/GraphQL, seguridad, validación y mantenibilidad.
   - Favorece modularidad y buenas prácticas para crecimiento controlado.

3. **Costo y operación sostenibles**
   - Monolito modular + PostgreSQL mantiene costos predecibles y bajos.
   - Despliegue simple en VPS o PaaS, con menor complejidad operativa.

4. **Mantenibilidad y trazabilidad**
   - Separación por capas (Controller, Service, Repository) simplifica pruebas y depuración.
   - Facilita registrar decisiones y cambios de negocio de forma clara.

5. **Evolución gradual**
   - Se puede escalar verticalmente primero y migrar por módulos más adelante si es necesario.

#### Lo que se GANA con esta decisión:
- ✅ Acceso inmediato desde navegador en escritorio y móvil
- ✅ Backend robusto y estandarizado con Spring Boot
- ✅ Seguridad fuerte con Spring Security y JWT
- ✅ Arquitectura modular fácil de mantener
- ✅ Menor fricción para despliegue académico y productivo

#### Lo que se SACRIFICA con esta decisión:
- ❌ No se aprovecha el escalado independiente por servicio de microservicios
- ❌ Requiere disciplina de modularización para no degradar el monolito
- ❌ La estrategia de crecimiento futuro debe planificarse con cuidado

---

## 7. Validación de la Decisión

### Checklist de Restricciones No Negociables

| Restricción | ¿Cumple Alternativa 2? | Evidencia |
|-------------|------------------------|-----------|
| ✅ Seguridad datos (RNF-01) | SÍ | HTTPS, autenticación JWT, bcrypt para passwords |
| ✅ Bajo presupuesto operación (RE-01) | SÍ | VPS/PaaS mantiene costos por debajo del límite |
| ✅ 4 meses desarrollo (RE-03) | SÍ | Spring Boot + API pura simplifica construcción |
| ✅ Usabilidad para baja alfabetización (RS-02) | SÍ | Acceso por navegador y flujo guiado sencillo |
| ✅ Recomendaciones seguras (RSS-01) | SÍ | Motor de reglas validado por agrónomos |
| ✅ Trazabilidad (RSS-02) | SÍ | API centralizada y logs de negocio |

**Resultado: ✅ APROBADA** - Cumple todas las restricciones no negociables.

---

## 8. Resumen Ejecutivo de la Comparación

| Aspecto | Ganador | Razón |
|---------|---------|-------|
| **Rendimiento temprano** | Alt 2 | Menor latencia interna y menos llamadas remotas |
| **Usabilidad** | Alt 2 | Un cliente frontal simple y trazable |
| **Costo predecible** | Alt 2 | Menos infraestructura distribuida |
| **Simplicidad** | Alt 2 | Monolito modular vs sistema distribuido |
| **Escalabilidad extrema** | Alt 1 | Microservicios escalan mejor a gran escala |
| **Separación por dominio a gran escala** | Alt 1 | Independencia de despliegue por servicio |
| **Gobernanza técnica temprana** | Alt 2 | API pura centraliza control y validación |

**Puntaje Final (con el alcance actual):**
- Alternativa 1 (Microservicios): **67%**
- Alternativa 2 (Monolito Modular por Capas + API Pura): **92%** ⭐ **GANADORA**

---

## 9. Plan de Mitigación de Sacrificios

Para compensar lo que se sacrifica con la Alternativa 2, se implementarán:

### Mitigación 1: Escalabilidad futura
- **Acción:** Diseñar el monolito de forma modular desde el inicio, con separación clara por dominio.
- **Resultado:** Si el crecimiento lo exige, la migración posterior a microservicios será más fácil.

### Mitigación 2: API versionada
- **Acción:** Versionar la API y documentar contratos de consumo.
- **Resultado:** Los clientes frontales independientes podrán evolucionar sin romper integraciones.

### Mitigación 3: Observabilidad y trazabilidad
- **Acción:** Logs estructurados, métricas y auditoría desde el inicio.
- **Resultado:** Se mantiene control operativo aunque la arquitectura sea monolítica.

---

## Conclusión

La **Alternativa 2 (Monolito Modular por Capas + API REST/GraphQL + PostgreSQL + Clientes Frontales Independientes)** es la opción más adecuada porque:

1. ✅ Cumple los escenarios críticos del proyecto sin introducir complejidad innecesaria.
2. ✅ Respeta las restricciones de tiempo, equipo y presupuesto.
3. ✅ Ofrece el mejor equilibrio costo-tiempo-calidad para esta fase.
4. ✅ Mantiene una línea arquitectónica consistente con el resto de los entregables.
5. ✅ Conserva abierta la evolución futura hacia microservicios si el crecimiento del sistema lo justifica.

La decisión está fundamentada en criterios técnicos explícitos y trade-offs claros entre escalabilidad extrema y viabilidad real del proyecto.
