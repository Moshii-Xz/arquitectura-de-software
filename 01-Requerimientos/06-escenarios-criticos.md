# Escenarios de Calidad Críticos

## Introducción

Este documento identifica y detalla los **escenarios de calidad críticos** del sistema, es decir, aquellos que son esenciales para el éxito del proyecto y que tienen mayor impacto en las decisiones arquitectónicas.

Los escenarios se han seleccionado basándose en:
- **Impacto en el usuario final**
- **Consecuencias de fallo**
- **Restricciones del contexto** (conectividad, recursos, alfabetización)
- **Diferenciación competitiva**

---

## Categorización de Criticidad

| Nivel | Descripción | Consecuencia de Fallo |
|-------|-------------|-----------------------|
| **CRÍTICO** | Esencial para funcionalidad básica del sistema | Sistema inutilizable o riesgo alto para usuarios |
| **ALTO** | Importantísimo para experiencia de usuario | Degradación severa de experiencia, pérdida de confianza |
| **MEDIO** | Importante pero no bloqueante | Inconveniente, pero workarounds posibles |

---

## ESCENARIOS CRÍTICOS

### 🔴 EC-01: Funcionamiento Sin Conexión a Internet
**Categoría:** Disponibilidad  
**Nivel de Criticidad:** CRÍTICO  
**Prioridad en Arquitectura:** 1

#### Descripción Detallada
El sistema debe permitir que los productores agrícolas consulten información de sus cultivos, vean recomendaciones previas y registren actividades incluso cuando no hay conexión a internet, sincronizando automáticamente cuando la conexión se recupere.

#### Escenario Completo
| Elemento | Detalle |
|----------|---------|
| **Fuente de Estímulo** | Pérdida de conectividad a internet (común en zonas rurales) |
| **Estímulo** | Usuario intenta consultar estado de cultivo o registrar actividad |
| **Artefacto** | Aplicación móvil completa |
| **Entorno** | Usuario en campo sin cobertura de datos móviles |
| **Respuesta** | Sistema detecta ausencia de conexión, muestra indicador de modo offline, permite todas las operaciones locales (consulta de datos en caché, registro de actividades), y almacena operaciones en cola para sincronización posterior |
| **Medida de Respuesta** | - **100%** de operaciones críticas disponibles offline<br>- **< 2 seg** tiempo de respuesta para operaciones locales<br>- **0%** pérdida de datos tras sincronización<br>- **Detección automática** de modo sin intervención del usuario |

#### Implicaciones Arquitectónicas
- ✅ Base de datos local embebida (SQLite, Realm, etc.)
- ✅ Estrategia de caché para datos críticos
- ✅ Cola de sincronización para operaciones pendientes
- ✅ Resolución de conflictos de sincronización
- ✅ Arquitectura mobile-first con backend como complemento

#### Escenarios de Prueba
1. Usuario abre app sin conexión → debe ver datos locales
2. Usuario registra 10 actividades offline → al recuperar conexión, todas se sincronizan correctamente
3. Usuario recibe notificación programada → debe funcionar incluso sin internet (notificación local)

#### Riesgos
- Conflictos de sincronización si múltiples dispositivos modifican mismo cultivo
- Limitación de espacio en dispositivos gama baja
- Complejidad en gestión de estado offline/online

---

### 🔴 EC-02: Respuesta Rápida en Dispositivos de Gama Baja
**Categoría:** Rendimiento  
**Nivel de Criticidad:** CRÍTICO  
**Prioridad en Arquitectura:** 2

#### Descripción Detallada
La aplicación móvil debe cargar rápidamente y operar con fluidez en smartphones Android de gama baja (procesadores de gama de entrada, 2GB RAM o menos), asegurando que productores con recursos limitados puedan usar el sistema sin frustración.

#### Escenario Completo
| Elemento | Detalle |
|----------|---------|
| **Fuente de Estímulo** | Usuario con dispositivo Android gama baja |
| **Estímulo** | Apertura de la aplicación desde cero (cold start) |
| **Artefacto** | Aplicación móvil |
| **Entorno** | Samsung Galaxy A03 (2021) con Android 11, 2GB RAM, procesador Helio P35 |
| **Respuesta** | App se inicia, muestra splash screen, carga datos locales y presenta pantalla principal interactiva |
| **Medida de Respuesta** | - **< 3 seg** hasta pantalla principal interactiva<br>- **< 150 MB** de uso de RAM en operación normal<br>- **< 30 MB** tamaño del APK instalado<br>- **60 FPS** en navegación (mínimo 30 FPS constante) |

#### Implicaciones Arquitectónicas
- ✅ Optimización agresiva de recursos (imágenes comprimidas, lazy loading)
- ✅ Arquitectura ligera (evitar frameworks pesados)
- ✅ Minimización de dependencias de terceros
- ✅ Procesamiento local eficiente (algoritmos optimizados)
- ✅ Gestión de memoria proactiva

#### Escenarios de Prueba
1. Benchmark en dispositivo objetivo (Galaxy A03 o similar)
2. Monitoreo de consumo de RAM durante uso prolongado (30 min)
3. Verificación de fluidez de navegación (frame rate)
4. Prueba de carga inicial con diferentes condiciones de red

#### Riesgos
- Trade-off entre funcionalidad y ligereza
- Necesidad de probar en múltiples dispositivos
- Potencial limitación de características avanzadas

---

### 🔴 EC-03: Usabilidad para Usuario con Baja Alfabetización Digital
**Categoría:** Usabilidad  
**Nivel de Criticidad:** CRÍTICO  
**Prioridad en Arquitectura:** 3

#### Descripción Detallada
Productores rurales con limitada experiencia en tecnología deben poder usar el sistema de forma autónoma desde el primer uso, completando tareas esenciales (registrar cultivo, ver recomendaciones) sin necesitar asistencia técnica.

#### Escenario Completo
| Elemento | Detalle |
|----------|---------|
| **Fuente de Estímulo** | Usuario nuevo: productor de 45 años, educación básica, primera app agrícola |
| **Estímulo** | Descarga e instalación de la app por recomendación de asociación agrícola |
| **Artefacto** | Aplicación móvil completa, especialmente onboarding y flujos principales |
| **Entorno** | Usuario solo en su finca, sin soporte técnico presencial |
| **Respuesta** | Usuario completa registro de cuenta, registra su primer cultivo de plátano (0.5 ha), y visualiza su primera recomendación de riego |
| **Medida de Respuesta** | **80%** de usuarios objetivo completan flujo sin ayuda externa (test con 20 usuarios)<br>- **< 10 min** para completar primer registro<br>- **Máximo 5 pasos** en cada flujo crítico<br>- **0 términos técnicos** sin explicación<br>- **Tasa de error < 15%** en formularios |

#### Implicaciones Arquitectónicas
- ✅ Diseño UI/UX minimalista y guiado
- ✅ Tutorial interactivo obligatorio en primer uso
- ✅ Etiquetas claramente visibles en todos los iconos
- ✅ Validación progresiva de formularios (evitar errores antes de submit)
- ✅ Mensajes en lenguaje natural (no códigos técnicos)
- ✅ Navegación lineal y predecible

#### Escenarios de Prueba
1. Test de usuario con 10 productores reales (observación y métricas)
2. Prueba de lenguaje: validar con usuarios que mensajes son comprensibles
3. Análisis de abandono en flujos (dónde se atascan los usuarios)
4. Prueba de recuperación de errores

#### Riesgos
- Subestimar complejidad de diseño simple
- Diferencias culturales y regionales en comprensión
- Necesidad de iteración continua basada en feedback real

---

### 🟠 EC-04: Alertas Climáticas Oportunas y Relevantes
**Categoría:** Confiabilidad + Rendimiento  
**Nivel de Criticidad:** ALTO  
**Prioridad en Arquitectura:** 4

#### Descripción Detallada
El sistema debe detectar eventos climáticos adversos (lluvias intensas, sequías, calor extremo) y notificar a los productores con suficiente anticipación para que tomen acciones preventivas, evitando pérdidas de cultivos.

#### Escenario Completo
| Elemento | Detalle |
|----------|---------|
| **Fuente de Estímulo** | API climática externa (actualización de pronóstico) |
| **Estímulo** | Pronóstico indica 80% probabilidad de lluvia intensa (>50mm) en 24 horas |
| **Artefacto** | Módulo de integración climática + Motor de alertas + Sistema de notificaciones |
| **Entorno** | 200 usuarios activos con cultivos en diferentes municipios del Magdalena |
| **Respuesta** | Sistema detecta evento, identifica cultivos afectados (por ubicación y tipo), genera alerta personalizada, y envía notificación push a usuarios relevantes con recomendación de acción (ej: "Cubrir plántulas", "Revisar drenajes") |
| **Medida de Respuesta** | - **< 1 hora** desde actualización de pronóstico hasta notificación enviada<br>- **< 6 horas** de anticipación mínima al evento<br>- **95%** tasa de entrega exitosa de notificaciones<br>- **< 10%** tasa de falsos positivos<br>- **100%** de alertas críticas entregadas |

#### Implicaciones Arquitectónicas
- ✅ Integración robusta con API climática (fallback a múltiples fuentes)
- ✅ Motor de reglas para evaluación de eventos (qué es crítico)
- ✅ Servicio de notificaciones push confiable
- ✅ Geolocalización de cultivos (coordenadas o municipio)
- ✅ Tareas programadas (cron jobs) para chequeo periódico
- ✅ Logs de alertas enviadas (auditoría)

#### Escenarios de Prueba
1. Simulación de evento climático extremo → verificar que alertas se envían
2. Prueba de latencia desde API hasta notificación push
3. Validación de relevancia (usuarios correctos reciben alertas correctas)
4. Manejo de falla de API climática (usa caché o fuente alternativa)

#### Riesgos
- Dependencia de APIs externas (disponibilidad y precisión)
- Costo de notificaciones push a gran escala
- Balance entre alertas útiles y fatiga de notificaciones

---

### 🟠 EC-05: Recomendaciones Agrícolas Confiables y Seguras
**Categoría:** Confiabilidad + Seguridad  
**Nivel de Criticidad:** ALTO  
**Prioridad en Arquitectura:** 5

#### Descripción Detallada
Las recomendaciones de riego, fertilización y manejo fitosanitario generadas por el sistema deben ser técnicamente correctas, basadas en evidencia agronómica, y no poner en riesgo la salud del productor, el cultivo ni el ambiente.

#### Escenario Completo
| Elemento | Detalle |
|----------|---------|
| **Fuente de Estímulo** | Sistema (ejecución periódica del motor de recomendaciones) |
| **Estímulo** | Usuario con cultivo de banano en fase de fructificación, con 7 días sin lluvia, temperatura promedio 30°C |
| **Artefacto** | Motor de recomendaciones (lógica de negocio) |
| **Entorno** | Base de conocimiento validada por ingenieros agrónomos, datos climáticos precisos |
| **Respuesta** | Sistema genera recomendación: "Regar mañana temprano (6-8am), 25 litros por planta. Evitar riego en horas de sol fuerte. Próximo riego en 3 días si no llueve." |
| **Medida de Respuesta** | - **95%** de recomendaciones validadas como correctas por panel de expertos (muestra de 100)<br>- **0%** de recomendaciones con potencial daño al cultivo<br>- **100%** de recomendaciones con explicación/justificación<br>- **Trazabilidad completa** de la lógica aplicada |

#### Implicaciones Arquitectónicas
- ✅ Motor de reglas basado en conocimiento experto (posiblemente sistema experto simple)
- ✅ Validación de recomendaciones antes de producción (testing con agrónomos)
- ✅ Logs detallados de cómo se generó cada recomendación (auditoría)
- ✅ Versionado de reglas de negocio (posibilidad de rollback)
- ✅ Disclaimer claro: sistema es apoyo, no sustituto del criterio humano
- ✅ Posibilidad de feedback del usuario ("¿Fue útil esta recomendación?")

#### Escenarios de Prueba
1. Validación con 3 ingenieros agrónomos de 100 recomendaciones generadas
2. Prueba de casos extremos (datos atípicos) → sistema debe comportarse conservadoramente
3. Verificación de trazabilidad: dado un registro de recomendación, reconstruir el razonamiento
4. Prueba de regresión al actualizar reglas de negocio

#### Riesgos
- Simplificación excesiva de conocimiento agronómico complejo
- Variabilidad de condiciones reales no capturadas por el modelo
- Responsabilidad legal si recomendación causa daño (mitigado con disclaimers)

---

### 🟠 EC-06: Sincronización Confiable de Datos Offline
**Categoría:** Confiabilidad + Disponibilidad  
**Nivel de Criticidad:** ALTO  
**Prioridad en Arquitectura:** 6

#### Descripción Detallada
Cuando un productor recupera conexión a internet después de trabajar offline (registrando actividades, consultando datos), el sistema debe sincronizar todos los cambios locales con el servidor sin pérdida ni duplicación de datos, incluso si hubo modificaciones en ambos lados.

#### Escenario Completo
| Elemento | Detalle |
|----------|---------|
| **Fuente de Estímulo** | Usuario recupera conexión después de 48 horas offline |
| **Estímulo** | App detecta conexión disponible y activa sincronización automática |
| **Artefacto** | Módulo de sincronización (app móvil + backend) |
| **Entorno** | Usuario registró offline: 15 actividades (riego, fertilización), 2 observaciones con fotos. Mientras tanto, servidor envió 3 nuevas recomendaciones. |
| **Respuesta** | Sistema sincroniza en background: sube actividades locales al servidor, descarga recomendaciones nuevas, verifica integridad con checksums, notifica al usuario "Sincronización completada: 15 actividades enviadas, 3 recomendaciones recibidas" |
| **Medida de Respuesta** | - **100%** de datos locales sincronizados correctamente<br>- **0%** pérdida de datos<br>- **0%** duplicaciones<br>- **< 30 seg** para sincronización típica (20 registros)<br>- **Verificación de integridad** (checksums)<br>- **Resolución automática de conflictos** (última escritura gana o similar) |

#### Implicaciones Arquitectónicas
- ✅ Estrategia de sincronización definida (optimistic sync, eventual consistency)
- ✅ Versionado de registros (timestamps, UUIDs)
- ✅ Cola persistente de operaciones pendientes
- ✅ Checksums o hashes para verificación de integridad
- ✅ Estrategia de resolución de conflictos documentada
- ✅ Sincronización en background (no bloquea UI)
- ✅ Mecanismo de reintentos ante fallas parciales

#### Escenarios de Prueba
1. Usuario trabaja 24h offline con 20 operaciones → sincroniza → verificar integridad total
2. Conflicto simulado (misma actividad modificada offline y en otro dispositivo) → verificar resolución
3. Sincronización interrumpida a la mitad → reintentar → verificar que no haya duplicados
4. Prueba de stress: sincronizar 100 actividades con fotos (varios MB de datos)

#### Riesgos
- Conflictos complejos difíciles de resolver automáticamente
- Limitaciones de ancho de banda para sincronizar fotos
- Complejidad de implementación y testing de todos los casos edge

---

### 🟠 EC-07: Protección de Datos Personales y Agrícolas
**Categoría:** Seguridad  
**Nivel de Criticidad:** ALTO  
**Prioridad en Arquitectura:** 7

#### Descripción Detallada
Los datos personales del productor (identidad, ubicación) y datos productivos (tipo de cultivo, rendimientos, actividades) deben estar protegidos contra acceso no autorizado, cumpliendo con la legislación colombiana de protección de datos (Ley 1581 de 2012).

#### Escenario Completo
| Elemento | Detalle |
|----------|---------|
| **Fuente de Estímulo** | Atacante externo o interno con intenciones maliciosas |
| **Estímulo** | Intento de acceder a datos de un productor sin autorización (ej: fuerza bruta, acceso directo a BD, intercepción de red) |
| **Artefacto** | Sistema completo (app, API backend, base de datos) |
| **Entorno** | Operación normal en producción |
| **Respuesta** | Sistema bloquea acceso no autorizado, cifra datos sensibles en tránsito y reposo, loggea intentos de acceso sospechosos, notifica a administradores en caso de actividad anómala |
| **Medida de Respuesta** | - **100%** comunicaciones via HTTPS/TLS 1.2+<br>- **Cifrado AES-256** de datos sensibles en reposo<br>- **Bloqueo tras 3 intentos** fallidos de login<br>- **Tokens de sesión** con expiración (24h)<br>- **0 datos personales** expuestos en logs o errores<br>- **Auditoría completa** de accesos a datos críticos |

#### Implicaciones Arquitectónicas
- ✅ Autenticación robusta (JWT, OAuth 2.0, o similar)
- ✅ Autorización granular (usuarios solo ven sus propios datos)
- ✅ Cifrado de datos en tránsito (HTTPS) y en reposo (BD cifrada)
- ✅ Hashing de contraseñas (bcrypt, scrypt)
- ✅ Sanitización de inputs (prevenir SQL injection, XSS)
- ✅ Logs de auditoría (quién accedió a qué y cuándo)
- ✅ Política de privacidad y consentimiento explícito
- ✅ Opción de eliminar datos (derecho al olvido)

#### Escenarios de Prueba
1. Penetration testing básico (intentar SQL injection, fuerza bruta)
2. Verificar que usuario A no puede ver datos de usuario B
3. Capturar tráfico de red → verificar que está cifrado (HTTPS)
4. Inspeccionar logs → verificar que no contienen contraseñas o datos sensibles
5. Prueba de cumplimiento: solicitar eliminación de datos → verificar que se borran correctamente

#### Riesgos
- Cumplimiento normativo complejo (interpretación de Ley 1581)
- Costo de implementación de seguridad robusta
- Trade-off entre seguridad y usabilidad (contraseñas fuertes vs facilidad de acceso)

---

## Resumen de Prioridades

| ID | Escenario Crítico | Criticidad | Impacto Arquitectónico | Complejidad |
|----|------------------|------------|----------------------|-------------|
| EC-01 | Funcionamiento offline | CRÍTICO | Muy Alto | Alta |
| EC-02 | Rendimiento en gama baja | CRÍTICO | Alto | Media |
| EC-03 | Usabilidad para baja alfabetización | CRÍTICO | Alto | Alta |
| EC-04 | Alertas climáticas oportunas | ALTO | Alto | Media |
| EC-05 | Recomendaciones confiables | ALTO | Muy Alto | Alta |
| EC-06 | Sincronización confiable | ALTO | Muy Alto | Alta |
| EC-07 | Protección de datos | ALTO | Medio | Media |

---

## Relación con Restricciones

| Escenario Crítico | Restricciones Relacionadas |
|------------------|---------------------------|
| EC-01 (Offline) | RT-01 (Conectividad intermitente) |
| EC-02 (Rendimiento) | RT-02 (Dispositivos gama baja), RT-03 (Bajo costo infraestructura) |
| EC-03 (Usabilidad) | RS-01 (Lenguaje claro), RS-02 (Baja alfabetización digital) |
| EC-04 (Alertas) | RT-01 (Conectividad), RE-01 (Bajo costo) |
| EC-05 (Recomendaciones) | RSS-01 (Seguridad salud), RE-01 (Ética) |
| EC-06 (Sincronización) | RT-01 (Conectividad), RE-03 (4 meses desarrollo) |
| EC-07 (Seguridad) | RN-01 (Protección datos), RN-02 (Confidencialidad) |

---

## Decisiones Arquitectónicas Derivadas

### De EC-01, EC-02, EC-06 (Offline, Rendimiento, Sincronización):
→ **Arquitectura Mobile-First con backend como complemento**  
→ **Base de datos local embebida (SQLite o similar)**  
→ **Estrategia de sincronización eventual (Eventual Consistency)**

### De EC-03 (Usabilidad):
→ **Diseño UI/UX como prioridad desde Iteracion 1**  
→ **Testing con usuarios reales como validación obligatoria**

### De EC-04 (Alertas):
→ **Integración con múltiples APIs climáticas (redundancia)**  
→ **Sistema de notificaciones push confiable (Firebase Cloud Messaging o similar)**

### De EC-05 (Recomendaciones):
→ **Motor de reglas validado por expertos agrónomos**  
→ **Sistema de trazabilidad y logging de decisiones**

### De EC-07 (Seguridad):
→ **Autenticación y autorización desde diseño inicial**  
→ **HTTPS obligatorio en todas las comunicaciones**


