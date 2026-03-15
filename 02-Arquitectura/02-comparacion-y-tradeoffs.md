# Comparación y Análisis de Trade-offs

## 1. Tabla Comparativa Detallada

| Criterio | Peso | PWA + Serverless (Alt 1) | App Nativa + Monolito (Alt 2) |
|----------|------|--------------------------|-------------------------------|
| **COSTOS Y ECONOMÍA** | | | |
| Costo inicial desarrollo | 10% | 4/5 - Similar complejidad | 4/5 - Similar complejidad |
| Costo operación mensual (año 1) | 15% | 5/5 - ~$0-10/mes | 5/5 - ~$10/mes |
| Costo operación mensual (año 3, 1000 usuarios) | 10% | 4/5 - ~$20-40/mes | 5/5 - ~$15-20/mes |
| Recursos humanos necesarios | 10% | 4/5 - Requiere conocimiento cloud | 5/5 - Stack tradicional más accesible |
| **RENDIMIENTO Y TÉCNICA** | | | |
| Velocidad en dispositivos gama baja | 20% | 3/5 - Buena pero con limitaciones | 5/5 - Excelente, código nativo/compilado |
| Funcionalidad offline | 20% | 5/5 - Service Workers robustos | 5/5 - SQLite con control total |
| Tiempo de carga inicial | 10% | 3/5 - Depende de red + caché | 5/5 - Rápido, todo local |
| Consumo de recursos (RAM/CPU) | 10% | 3/5 - Navegador consume recursos | 5/5 - Optimizado |
| **EXPERIENCIA DE USUARIO** | | | |
| Facilidad de instalación | 15% | 3/5 - "Instalar desde navegador" poco familiar | 5/5 - Play Store conocido |
| Usabilidad para baja alfabetización | 15% | 4/5 - Buena con diseño cuidadoso | 5/5 - UX nativa más intuitiva |
| Actualizaciones | 10% | 5/5 - Automáticas, transparentes | 3/5 - Usuario debe actualizar |
| **ESCALABILIDAD Y FUTURO** | | | |
| Escalabilidad técnica | 15% | 5/5 - Escala automáticamente | 3/5 - Requiere reconfiguración manual |
| Facilidad de añadir funciones | 10% | 4/5 - Modular pero distribuido | 4/5 - Modular y centralizado |
| Multiplataforma (iOS futuro) | 10% | 5/5 - Ya funciona en iOS | 4/5 - Con Flutter/RN, requiere build separado |
| **MANTENIMIENTO** | | | |
| Complejidad de mantenimiento | 10% | 3/5 - Arquitectura distribuida es compleja | 5/5 - Todo en un lugar |
| Facilidad de debugging | 10% | 3/5 - Logs distribuidos | 5/5 - Logs centralizados |
| Tiempo de despliegue | 5% | 5/5 - CI/CD sencillo | 4/5 - Requiere aprobación Play Store |
| **SEGURIDAD Y CUMPLIMIENTO** | | | |
| Seguridad de datos | 15% | 5/5 - Infraestructura cloud certificada | 4/5 - Depende de configuración propia |
| Cumplimiento normativo | 10% | 5/5 - Cloud providers cumplen estándares | 4/5 - Responsabilidad propia |
| **PUNTAJE TOTAL** | **100%** | **Calculando...** | **Calculando...** |

### Cálculo de Puntaje Ponderado

#### Alternativa 1: PWA + Serverless
- Costos y Economía: (4×0.10 + 5×0.15 + 4×0.10 + 4×0.10) = (0.4 + 0.75 + 0.4 + 0.4) = **1.95** (45%)
- Rendimiento y Técnica: (3×0.20 + 5×0.20 + 3×0.10 + 3×0.10) = (0.6 + 1.0 + 0.3 + 0.3) = **2.2** (50%)
- Experiencia Usuario: (3×0.15 + 4×0.15 + 5×0.10) = (0.45 + 0.6 + 0.5) = **1.55** (40%)
- Escalabilidad y Futuro: (5×0.15 + 4×0.10 + 5×0.10) = (0.75 + 0.4 + 0.5) = **1.65** (35%)
- Mantenimiento: (3×0.10 + 3×0.10 + 5×0.05) = (0.3 + 0.3 + 0.25) = **0.85** (25%)
- Seguridad: (5×0.15 + 5×0.10) = (0.75 + 0.5) = **1.25** (25%)
- **TOTAL: 9.45 / 11 = 85.9%**

#### Alternativa 2: App Nativa + Monolito
- Costos y Economía: (4×0.10 + 5×0.15 + 5×0.10 + 5×0.10) = (0.4 + 0.75 + 0.5 + 0.5) = **2.15** (45%)
- Rendimiento y Técnica: (5×0.20 + 5×0.20 + 5×0.10 + 5×0.10) = (1.0 + 1.0 + 0.5 + 0.5) = **3.0** (50%)
- Experiencia Usuario: (5×0.15 + 5×0.15 + 3×0.10) = (0.75 + 0.75 + 0.3) = **1.8** (40%)
- Escalabilidad y Futuro: (3×0.15 + 4×0.10 + 4×0.10) = (0.45 + 0.4 + 0.4) = **1.25** (35%)
- Mantenimiento: (5×0.10 + 5×0.10 + 4×0.05) = (0.5 + 0.5 + 0.2) = **1.2** (25%)
- Seguridad: (4×0.15 + 4×0.10) = (0.6 + 0.4) = **1.0** (25%)
- **TOTAL: 10.4 / 11 = 94.5%**

---

## 2. Análisis de Trade-offs Principales

### Trade-off 1: Rendimiento vs Escalabilidad Automática

#### PWA + Serverless
- ✅ **GANA:** Escalabilidad automática, sin configuración manual
- ❌ **PIERDE:** Rendimiento en dispositivos gama baja (JavaScript en navegador)

#### App Nativa + Monolito
- ✅ **GANA:** Rendimiento superior en gama baja (código nativo/compilado)
- ❌ **PIERDE:** Escalabilidad manual, requiere reconfiguración a mayor escala

**Decisión:** Dado el contexto de **dispositivos gama baja como restricción crítica** (RT-02) y escenarios críticos de rendimiento (EC-02), el rendimiento es más importante que escalabilidad automática en esta fase. **Favorece Alternativa 2.**

---

### Trade-off 2: Costo Operación Inicial vs Costo a Escala

#### PWA + Serverless
- ✅ **GANA:** Costo inicial casi nulo (tier gratuito)
- ❌ **PIERDE:** Costo crece con uso, potencialmente impredecible

#### App Nativa + Monolito
- ⚠️ **Neutro:** Costo fijo desde día 1 (~$10/mes), pero predecible hasta 1000+ usuarios

**Decisión:** Con presupuesto limitado pero estable (RE-01: < $50/mes), un **costo fijo predecible es preferible** a sorpresas. Además, el tier serverless puede tener limitaciones inesperadas. **Favorece Alternativa 2.**

---

### Trade-off 3: Facilidad de Actualización vs Facilidad de Instalación/UX

#### PWA + Serverless
- ✅ **GANA:** Actualizaciones automáticas, sin aprobación de tiendas
- ❌ **PIERDE:** Instalación desde navegador puede confundir a usuarios rurales

#### App Nativa + Monolito
- ✅ **GANA:** Instalación desde Play Store es familiar y confiable
- ❌ **PIERDE:** Actualizaciones requieren acción del usuario

**Decisión:** Dado el escenario crítico de **usabilidad para baja alfabetización digital** (EC-03), la **facilidad de instalación y familiaridad pesan más**. Los usuarios rurales están acostumbrados a Play Store. **Favorece Alternativa 2.**

---

### Trade-off 4: Simplicidad Arquitectónica vs Escalabilidad Futura

#### PWA + Serverless
- ❌ **PIERDE:** Arquitectura distribuida (functions, API Gateway, servicios cloud) es compleja
- ✅ **GANA:** Escala a millones de usuarios sin cambios estructurales

#### App Nativa + Monolito
- ✅ **GANA:** Arquitectura simple, un repositorio, fácil de entender
- ❌ **PIERDE:** A partir de 5000-10000 usuarios, puede requerir refactorización

**Decisión:** Con un **equipo de 5 personas y 4 meses de desarrollo** (RE-02, RE-03), la **simplicidad inicial es crítica**. El proyecto tiene horizonte de 1-2 años con crecimiento gradual, no se espera escala masiva inmediata. **Favorece Alternativa 2.**

---

### Trade-off 5: Multiplataforma Inmediato vs Optimización para Android

#### PWA + Serverless
- ✅ **GANA:** Funciona en iOS, Android, desktop desde día 1
- ❌ **PIERDE:** Experiencia puede no ser óptima en ninguna plataforma

#### App Nativa + Monolito (con Flutter/React Native)
- ✅ **GANA:** Con híbrido (Flutter), código compartido 90%, deploy iOS si se necesita
- ❌ **PIERDE:** Requiere builds y pruebas separadas por plataforma

**Decisión:** Los beneficiarios directos usan **principalmente Android** (RS-01, contexto del problema). iOS puede ser fase 2. Si se usa Flutter, igualmente será multiplataforma. **Empate con ligero favor a Alternativa 2.**

---

## 3. Influencia de Restricciones en la Decisión

### Restricciones Críticas que Favorecen Alternativa 2

| Restricción | Cómo influye | Impacto |
|-------------|--------------|---------|
| **RT-02: Dispositivos gama baja** | App nativa/compilada es significativamente más rápida | 🔴 Muy Alto |
| **RS-02: Baja alfabetización digital** | Instalación Play Store es familiar; PWA puede confundir | 🔴 Alto |
| **RE-03: 4 meses de desarrollo** | Monolito es más simple de desarrollar y debuggear | 🟡 Medio |
| **RE-02: Equipo de 5 personas** | Arquitectura simple facilita coordinación | 🟡 Medio |
| **RT-03: Bajo costo infraestructura** | VPS barato suficiente; serverless puede sorprender | 🟡 Medio |

### Restricciones que Favorecen Alternativa 1

| Restricción | Cómo influye | Impacto |
|-------------|--------------|---------|
| **RT-01: Conectividad intermitente** | Ambas lo manejan bien, pero PWA diseñado para esto | 🟢 Bajo (empate) |
| **Escalabilidad futura (implícita)** | Serverless escala sin intervención | 🟢 Bajo (no crítico ahora) |

---

## 4. Equilibrio Costo-Tiempo-Calidad

### Alternativa 1: PWA + Serverless
- **Costo:** ⭐⭐⭐⭐⭐ Excelente a corto plazo
- **Tiempo:** ⭐⭐⭐⭐ Bueno (stack JavaScript unificado)
- **Calidad (Atributos críticos):** ⭐⭐⭐ Aceptable (falla en rendimiento y usabilidad)

### Alternativa 2: App Nativa + Monolito
- **Costo:** ⭐⭐⭐⭐⭐ Excelente (costo fijo bajo)
- **Tiempo:** ⭐⭐⭐⭐½ Muy bueno (Flutter acelera mucho)
- **Calidad (Atributos críticos):** ⭐⭐⭐⭐⭐ Excelente (cumple EC-01, EC-02, EC-03)

**Conclusión:** Alternativa 2 ofrece **mejor equilibrio** considerando que los atributos de calidad críticos (rendimiento, usabilidad) son no-negociables.

---

## 5. Riesgos Comparativos

| Riesgo | PWA + Serverless | App Nativa + Monolito |
|--------|------------------|------------------------|
| **Rendimiento insuficiente** | 🔴 Alto | 🟢 Bajo |
| **Usuarios no saben instalar** | 🔴 Alto | 🟢 Bajo |
| **Costo se sale de presupuesto** | 🟡 Medio (impredecible) | 🟢 Bajo (fijo) |
| **No escala a 10,000 usuarios** | 🟢 Bajo | 🟡 Medio (requiere refactor) |
| **Complejidad técnica excede capacidad equipo** | 🟡 Medio (cloud learning curve) | 🟢 Bajo |
| **Dependencia de vendor (AWS, Google)** | 🔴 Alto (vendor lock-in) | 🟢 Bajo (portable) |
| **Fragmentación de versiones (actualizaciones)** | 🟢 Bajo (auto-actualiza) | 🟡 Medio |

---

## 6. Decisión Justificada

### ✅ ALTERNATIVA SELECCIONADA: **Aplicación Móvil Híbrida (Flutter) + Backend Monolítico (Node.js/Express) + PostgreSQL**

### Justificación Detallada

#### Criterios Determinantes

1. **Rendimiento en Dispositivos Gama Baja (Peso: 20%)**
   - Escenario crítico EC-02 exige < 3 seg carga inicial en dispositivos básicos
   - Flutter compila a código nativo ARM, rendimiento superior a PWA
   - **Decisivo:** Esta es una restricción no negociable (RT-02)

2. **Usabilidad para Usuarios con Baja Alfabetización Digital (Peso: 15%)**
   - Escenario crítico EC-03: 80% de usuarios deben completar flujo sin ayuda
   - Instalación desde Play Store es familiar; PWA no lo es
   - UX nativa es más intuitiva que experiencia web
   - **Decisivo:** Restricción social crítica (RS-02)

3. **Costo Predecible y Bajo (Peso: 15%)**
   - VPS de $10/mes cubre hasta 1000+ usuarios cómodamente
   - Sin riesgo de factura inesperada (como puede pasar con serverless)
   - **Importante:** Restricción económica RE-01 (< $50/mes)

4. **Simplicidad para Equipo Pequeño en Tiempo Limitado (Peso: 15%)**
   - Monolito modular es más fácil de desarrollar, debuggear y mantener
   - Equipo de 5 personas puede coordinarse mejor con arquitectura centralizada
   - 4 meses de desarrollo: no hay margen para complejidad excesiva
   - **Importante:** Restricciones RE-02 y RE-03

5. **Funcionalidad Offline Robusta (Peso: 20%)**
   - Escenario crítico EC-01: 100% operaciones críticas disponibles offline
   - Ambas alternativas lo manejan bien, pero SQLite da control total
   - **Empate técnico, pero ligera ventaja a nativo**

#### Lo que se GANA con esta decisión:
- ✅ Rendimiento excelente en dispositivos objetivo
- ✅ Experiencia de usuario familiar y confiable
- ✅ Arquitectura simple y mantenible
- ✅ Costo operación fijo y bajo
- ✅ Menor curva de aprendizaje para equipo
- ✅ Desarrollo rápido con Flutter (código compartido, hot reload)
- ✅ Debugging y logs centralizados
- ✅ Comunidad y ecosistema maduros

#### Lo que se SACRIFICA con esta decisión:
- ❌ Escalabilidad automática (deberá hacerse manual después de ~5000 usuarios)
- ❌ Actualizaciones automáticas (usuarios deben actualizar desde Play Store)
- ❌ Cero costo inicial (desde día 1 se pagan ~$10/mes)
- ❌ Multiplataforma inmediato (iOS requiere build separado, aunque con Flutter es sencillo)

#### ¿Por qué los sacrificios son aceptables?

1. **Escalabilidad:** El crecimiento esperado es gradual. Si se llega a 5000+ usuarios, es señal de éxito y habrá recursos para refactorizar.

2. **Actualizaciones:** Los usuarios rurales ya están acostumbrados a actualizar apps de Play Store. Además, se puede implementar "update checker" en la app.

3. **Costo fijo:** $10/mes es insignificante comparado con el valor entregado. Además, ese costo puede cubrirse con donaciones o apoyo institucional.

4. **iOS no inmediato:** El 95%+ de usuarios objetivo usan Android. iOS puede ser fase 2 cuando haya demanda comprobada.

---

## 7. Validación de la Decisión

### Checklist de Restricciones No Negociables

| Restricción | ¿Cumple Alternativa 2? | Evidencia |
|-------------|------------------------|-----------|
| ✅ Seguridad datos (RN-01) | SÍ | HTTPS, autenticación JWT, bcrypt para passwords |
| ✅ Funcionamiento offline (RT-01) | SÍ | SQLite local con sincronización robusta |
| ✅ Bajo presupuesto operación (RE-01) | SÍ | ~$10/mes está muy por debajo de $50/mes límite |
| ✅ 4 meses desarrollo (RE-03) | SÍ | Flutter acelera desarrollo; monolito simplifica |
| ✅ Usabilidad para baja alfabetización (RS-02) | SÍ | UX nativa optimizada, instalación familiar |
| ✅ Recomendaciones seguras (RSS-01) | SÍ | Motor de reglas validado por agrónomos |

**Resultado: ✅ APROBADA** - Cumple todas las restricciones no negociables.

---

## 8. Resumen Ejecutivo de la Comparación

| Aspecto | Ganador | Razón |
|---------|---------|-------|
| **Rendimiento** | Alt 2 | Código nativo/compilado vs JavaScript |
| **Usabilidad** | Alt 2 | Play Store familiar vs instalación web |
| **Costo predecible** | Alt 2 | Fijo vs pay-per-use |
| **Simplicidad** | Alt 2 | Monolito vs arquitectura distribuida |
| **Escalabilidad extrema** | Alt 1 | Serverless vs manual scaling |
| **Actualización continua** | Alt 1 | Auto vs manual |
| **Multiplataforma day-1** | Alt 1 | Web universal vs app stores |

**Puntaje Final:**
- Alternativa 1 (PWA + Serverless): **85.9%**
- Alternativa 2 (App Nativa + Monolito): **94.5%** ⭐ **GANADORA**

---

## 9. Plan de Mitigación de Sacrificios

Para compensar lo que se sacrifica con la Alternativa 2, se implementarán:

### Mitigación 1: Escalabilidad Futura
- **Acción:** Diseñar monolito **modular** desde el inicio (separación clara de módulos)
- **Resultado:** Si se necesita, migración futura a microservicios será más fácil
- **Costo:** Bajo (solo buenas prácticas de diseño)

### Mitigación 2: Facilitar Actualizaciones
- **Acción:** Implementar "update checker" en la app que notifica de nuevas versiones
- **Resultado:** Usuarios actualización proactivamente
- **Costo:** Bajo (feature simple en la app)

### Mitigación 3: Preparar para iOS
- **Acción:** Usar Flutter desde el inicio (no Kotlin nativo Android)
- **Resultado:** Deploy a iOS será solo compilar y probar, 90%+ código reutilizable
- **Costo:** Ninguno (decisión de stack)

---

## Conclusión

La **Alternativa 2 (App Híbrida Flutter + Monolito Node.js)** es la opción más adecuada porque:

1. ✅ Cumple **todos** los escenarios críticos (EC-01 a EC-07)
2. ✅ Respeta **todas** las restricciones no negociables
3. ✅ Ofrece el **mejor equilibrio costo-tiempo-calidad**
4. ✅ Es **viable para el equipo** (5 personas, 4 meses)
5. ✅ Prioriza correctamente: **rendimiento y usabilidad sobre escalabilidad prematura**

La decisión está fundamentada en datos, criterios técnicos explícitos y análisis de trade-offs, no en preferencias subjetivas.
