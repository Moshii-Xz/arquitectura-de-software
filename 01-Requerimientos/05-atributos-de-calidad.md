# Atributos de Calidad del Sistema

## 1. Disponibilidad (Availability)

### Definición
Capacidad del sistema para estar operativo y accesible cuando se requiera, incluso bajo condiciones de conectividad limitada.

### Escenarios de Disponibilidad

#### ESC-DISP-01: Funcionamiento Offline
- **Fuente de estímulo:** Pérdida de conexión a internet
- **Estímulo:** Usuario intenta acceder a información de cultivo sin conectividad
- **Artefacto:** Aplicación móvil y datos locales
- **Entorno:** Operación normal en zona rural sin cobertura
- **Respuesta:** El sistema permite consultar información almacenada localmente y registrar actividades que se sincronizarán después
- **Medida de respuesta:** 
  - 100% de funcionalidades críticas disponibles offline
  - Tiempo de respuesta < 2 segundos para operaciones locales
  - 0% pérdida de datos registrados offline tras sincronización

#### ESC-DISP-02: Recuperación ante Fallo del Servidor
- **Fuente de estímulo:** Fallo en el servidor backend
- **Estímulo:** Servidor principal deja de responder
- **Artefacto:** Servicio backend
- **Entorno:** Operación normal, 100 usuarios concurrentes
- **Respuesta:** Sistema detecta fallo, app móvil entra en modo offline automáticamente, se activa alerta para administradores
- **Medida de respuesta:**
  - Detección de fallo en < 30 segundos
  - Recuperación automática del servicio en < 5 minutos
  - Uptime objetivo: 99% (permite ~7 horas downtime/mes)

#### ESC-DISP-03: Operación Durante Sincronización
- **Fuente de estímulo:** Usuario
- **Estímulo:** Usuario interactúa con app mientras ocurre sincronización de datos
- **Artefacto:** App móvil
- **Entorno:** Sincronización en background con conexión 3G
- **Respuesta:** Sistema permite uso normal de la app sin bloqueos
- **Medida de respuesta:**
  - 0 bloqueos de UI durante sincronización
  - Operaciones de usuario no afectadas por sync en background

---

## 2. Rendimiento (Performance)

### Definición
Capacidad del sistema para responder a las solicitudes del usuario en tiempos aceptables y usando recursos eficientemente.

### Escenarios de Rendimiento

#### ESC-PERF-01: Tiempo de Carga Inicial
- **Fuente de estímulo:** Usuario
- **Estímulo:** Usuario abre la aplicación móvil
- **Artefacto:** Aplicación móvil
- **Entorno:** Dispositivo Android gama baja (2GB RAM, procesador quad-core 1.5GHz), conexión 3G
- **Respuesta:** Pantalla principal carga y muestra información del cultivo
- **Medida de respuesta:**
  - Tiempo de splash screen: < 2 segundos
  - Tiempo hasta pantalla principal interactiva: < 3 segundos
  - Datos del cultivo visibles: < 4 segundos

#### ESC-PERF-02: Consulta de Recomendaciones
- **Fuente de estímulo:** Sistema automático o solicitud de usuario
- **Estímulo:** Generación de recomendación de riego basada en clima y fase de cultivo
- **Artefacto:** Servicio de recomendaciones (backend)
- **Entorno:** Operación normal, 50 solicitudes concurrentes
- **Respuesta:** Recomendación calculada y entregada al usuario
- **Medida de respuesta:**
  - Tiempo de procesamiento: < 1.5 segundos (percentil 95)
  - Latencia de red no incluida
  - Carga CPU servidor: < 70%

#### ESC-PERF-03: Sincronización de Datos
- **Fuente de estímulo:** Usuario recupera conexión a internet
- **Estímulo:** Sincronización automática de 10 actividades registradas offline
- **Artefacto:** Módulo de sincronización
- **Entorno:** Conexión 3G (velocidad ~1 Mbps)
- **Respuesta:** Actividades sincronizadas con el servidor
- **Medida de respuesta:**
  - Tiempo total de sincronización: < 10 segundos
  - Datos transferidos: < 500 KB
  - Indicador de progreso visible al usuario

#### ESC-PERF-04: Consulta API Climática
- **Fuente de estímulo:** Tarea programada del sistema
- **Estímulo:** Actualización de datos climáticos cada 6 horas
- **Artefacto:** Servicio de integración con API climática
- **Entorno:** Operación normal, 200 usuarios activos
- **Respuesta:** Datos climáticos actualizados para todas las ubicaciones activas
- **Medida de respuesta:**
  - Tiempo de actualización por ubicación: < 3 segundos
  - Batch de actualizaciones: procesadas en paralelo
  - Timeout de API externa: 10 segundos máximo

---

## 3. Usabilidad (Usability)

### Definición
Facilidad de uso y comprensión del sistema para usuarios con bajo nivel de alfabetización digital.

### Escenarios de Usabilidad

#### ESC-USA-01: Primer Uso del Sistema
- **Fuente de estímulo:** Usuario nuevo (pequeño productor rural)
- **Estímulo:** Usuario descarga e instala la aplicación por primera vez
- **Artefacto:** Aplicación móvil completa
- **Entorno:** Usuario con limitada experiencia digital
- **Respuesta:** Usuario completa registro y registra su primer cultivo
- **Medida de respuesta:**
  - Tutorial interactivo disponible
  - Tiempo para completar primer registro: < 10 minutos
  - 80% de usuarios completan registro sin ayuda externa
  - Máximo 5 pasos en flujo de registro

#### ESC-USA-02: Comprensión de Recomendaciones
- **Fuente de estímulo:** Sistema
- **Estímulo:** Usuario recibe recomendación de riego
- **Artefacto:** Interfaz de notificación y detalle de recomendación
- **Entorno:** Operación normal
- **Respuesta:** Usuario comprende la recomendación y sabe qué acción tomar
- **Medida de respuesta:**
  - Lenguaje claro sin tecnicismos (nivel de lectura: básico)
  - Iconografía universal e intuitiva
  - Instrucciones paso a paso
  - 90% de usuarios comprenden recomendación en < 30 segundos (test con usuarios)

#### ESC-USA-03: Recuperación de Errores
- **Fuente de estímulo:** Usuario
- **Estímulo:** Usuario comete error al ingresar datos (ej: fecha incorrecta)
- **Artefacto:** Formularios de la aplicación
- **Entorno:** Registro de actividad
- **Respuesta:** Sistema muestra mensaje de error claro y permite corrección fácil
- **Medida de respuesta:**
  - Mensajes de error en lenguaje simple (no códigos técnicos)
  - Indicación clara del campo con error
  - Sugerencia de cómo corregir
  - Datos ya ingresados no se pierden

#### ESC-USA-04: Accesibilidad Visual
- **Fuente de estímulo:** Usuario con dificultad visual
- **Estímulo:** Usuario intenta leer información en pantalla
- **Artefacto:** Interfaz de usuario
- **Entorno:** Uso exterior bajo luz solar, usuario de 50+ años
- **Respuesta:** Información es legible y comprensible
- **Medida de respuesta:**
  - Tamaño de fuente mínimo: 16dp (escalable)
  - Contraste texto-fondo: mínimo 4.5:1 (WCAG AA)
  - Iconos con etiquetas textuales
  - Modo de alto contraste disponible

---

## 4. Seguridad (Security)

### Definición
Protección de datos personales y productivos contra accesos no autorizados o uso indebido.

### Escenarios de Seguridad

#### ESC-SEG-01: Intento de Acceso No Autorizado
- **Fuente de estímulo:** Atacante externo
- **Estímulo:** Intentos repetidos de inicio de sesión con credenciales incorrectas
- **Artefacto:** Módulo de autenticación
- **Entorno:** Operación online
- **Respuesta:** Sistema bloquea cuenta temporalmente y notifica al usuario
- **Medida de respuesta:**
  - Bloqueo tras 3 intentos fallidos
  - Duración de bloqueo: 15 minutos
  - Notificación por email/SMS al propietario de la cuenta
  - Log de intentos para auditoría

#### ESC-SEG-02: Transmisión de Datos Sensibles
- **Fuente de estímulo:** Usuario o sistema
- **Estímulo:** Envío de datos personales o de cultivo al servidor
- **Artefacto:** Capa de comunicación
- **Entorno:** Conexión a red pública o compartida
- **Respuesta:** Datos transmitidos de forma cifrada
- **Medida de respuesta:**
  - 100% de comunicaciones via HTTPS/TLS 1.2+
  - Certificado SSL válido en servidor
  - Pin de certificado en app móvil (certificate pinning)
  - 0 transmisiones de contraseñas en texto plano

#### ESC-SEG-03: Almacenamiento Local de Datos
- **Fuente de estímulo:** Posible pérdida o robo de dispositivo
- **Estímulo:** Tercero obtiene acceso físico al dispositivo del usuario
- **Artefacto:** Base de datos local de la app
- **Entorno:** Dispositivo desbloqueado o comprometido
- **Respuesta:** Datos sensibles no accesibles directamente
- **Medida de respuesta:**
  - Datos críticos cifrados en reposo (AES-256)
  - Contraseñas almacenadas con hash (bcrypt)
  - Token de sesión con expiración (24 horas)
  - Opción de borrado remoto de datos (futuro)

#### ESC-SEG-04: Inyección de Datos Maliciosos
- **Fuente de estímulo:** Usuario malicioso
- **Estímulo:** Intento de inyección SQL o script en formularios
- **Artefacto:** API backend y base de datos
- **Entorno:** Operación normal
- **Respuesta:** Sistema rechaza entrada maliciosa sin comprometer integridad
- **Medida de respuesta:**
  - 100% de consultas parametrizadas (prepared statements)
  - Validación y sanitización de todas las entradas
  - 0 ejecuciones de código inyectado
  - Logs de intentos de inyección

---

## 5. Escalabilidad (Scalability)

### Definición
Capacidad del sistema para crecer en usuarios y datos sin degradación significativa de rendimiento.

### Escenarios de Escalabilidad

#### ESC-ESC-01: Incremento de Usuarios
- **Fuente de estímulo:** Crecimiento orgánico
- **Estímulo:** Número de usuarios activos pasa de 100 a 1000
- **Artefacto:** Sistema completo (backend, BD, app)
- **Entorno:** Operación normal
- **Respuesta:** Sistema soporta la carga sin modificaciones estructurales
- **Medida de respuesta:**
  - Tiempo de respuesta aumenta < 20%
  - Arquitectura soporta escalamiento horizontal (añadir más instancias)
  - Costo de infraestructura crece linealmente (no exponencialmente)
  - Sin necesidad de rediseño hasta 5000 usuarios

#### ESC-ESC-02: Crecimiento de Datos Históricos
- **Fuente de estímulo:** Operación continua
- **Estímulo:** Base de datos de actividades y recomendaciones crece a 100,000 registros
- **Artefacto:** Base de datos y consultas
- **Entorno:** Múltiples usuarios consultando historial simultáneamente
- **Respuesta:** Consultas siguen siendo rápidas
- **Medida de respuesta:**
  - Tiempo de consulta: < 2 segundos (percentil 95)
  - Índices optimizados en campos clave
  - Estrategia de archivado para datos antiguos (>2 años)

#### ESC-ESC-03: Múltiples Cultivos por Usuario
- **Fuente de estímulo:** Asociaciones agrícolas
- **Estímulo:** Usuario gestiona 50 cultivos simultáneos
- **Artefacto:** App móvil y backend
- **Entorno:** Operación normal
- **Respuesta:** Sistema maneja múltiples cultivos eficientemente
- **Medida de respuesta:**
  - Carga de lista de cultivos: < 3 segundos
  - Paginación/lazy loading implementado
  - Filtros y búsqueda rápida disponibles

---

## 6. Mantenibilidad (Maintainability)

### Definición
Facilidad para modificar, corregir errores y actualizar el sistema.

### Escenarios de Mantenibilidad

#### ESC-MANT-01: Corrección de Bug
- **Fuente de estímulo:** Desarrollador
- **Estímulo:** Se identifica bug en cálculo de recomendaciones
- **Artefacto:** Módulo de recomendaciones
- **Entorno:** Desarrollo
- **Respuesta:** Bug identificado, corregido y desplegado
- **Medida de respuesta:**
  - Tiempo de localización del bug: < 2 horas
  - Código modular y bien documentado
  - Cobertura de pruebas unitarias: > 70% en lógica crítica
  - Despliegue de fix: < 1 día

#### ESC-MANT-02: Añadir Nuevo Tipo de Cultivo
- **Fuente de estímulo:** Administrador del sistema
- **Estímulo:** Necesidad de soportar un nuevo cultivo (ej: aguacate)
- **Artefacto:** Módulo de gestión de cultivos y recomendaciones
- **Entorno:** Producción
- **Respuesta:** Nuevo cultivo añadido con sus parámetros y reglas
- **Medida de respuesta:**
  - Configuración vía panel de admin (no requiere código)
  - Tiempo de configuración: < 1 hora
  - Sin necesidad de redespliegue de app móvil
  - Actualización inmediata para todos los usuarios

#### ESC-MANT-03: Actualización de Dependencias
- **Fuente de estímulo:** Desarrollador
- **Estímulo:** Actualización de librería de terceros por parche de seguridad
- **Artefacto:** Dependencias del proyecto
- **Entorno:** Desarrollo
- **Respuesta:** Actualización aplicada sin romper funcionalidad
- **Medida de respuesta:**
  - Gestión de dependencias clara (package.json, requirements.txt)
  - Suite de pruebas automatizadas ejecutada antes de actualizar
  - Tiempo de actualización y validación: < 4 horas

---

## 7. Confiabilidad (Reliability)

### Definición
Capacidad del sistema para funcionar correctamente bajo condiciones especificadas durante un período de tiempo.

### Escenarios de Confiabilidad

#### ESC-CONF-01: Precisión de Recomendaciones
- **Fuente de estímulo:** Sistema automático
- **Estímulo:** Generación de recomendación de riego para cultivo de banano en fase de floración
- **Artefacto:** Motor de recomendaciones
- **Entorno:** Datos climáticos precisos disponibles
- **Respuesta:** Recomendación generada es técnicamente correcta
- **Medida de respuesta:**
  - 95% de recomendaciones validadas como correctas por expertos agrónomos
  - 0% de recomendaciones que causen daño evidente al cultivo
  - Trazabilidad de la lógica aplicada

#### ESC-CONF-02: Integridad de Datos en Sincronización
- **Fuente de estímulo:** Sistema
- **Estímulo:** Usuario registra 20 actividades offline y luego sincroniza
- **Artefacto:** Módulo de sincronización
- **Entorno:** Conexión recuperada después de 48 horas offline
- **Respuesta:** Todas las actividades sincronizadas correctamente sin pérdida ni duplicación
- **Medida de respuesta:**
  - 100% de datos sincronizados correctamente
  - 0% de pérdida de datos
  - 0% de duplicaciones
  - Verificación por checksum o similar

#### ESC-CONF-03: Consistencia de Estado
- **Fuente de estímulo:** Múltiples usuarios
- **Estímulo:** Usuario modifica cultivo desde dos dispositivos casi simultáneamente
- **Artefacto:** Backend y base de datos
- **Entorno:** Operación normal con conexión
- **Respuesta:** Estado final del cultivo es consistente
- **Medida de respuesta:**
  - Estrategia de resolución de conflictos definida (ej: última escritura gana)
  - Timestamps de modificación almacenados
  - Opción de ver historial de cambios

---

## 8. Interoperabilidad (Interoperability)

### Definición
Capacidad del sistema para interactuar con otros sistemas o servicios.

### Escenarios de Interoperabilidad

#### ESC-INT-01: Integración con API Climática Externa
- **Fuente de estímulo:** Sistema automático
- **Estímulo:** Solicitud de datos climáticos a API externa (ej: OpenWeatherMap)
- **Artefacto:** Módulo de integración climática
- **Entorno:** Operación normal
- **Respuesta:** Datos obtenidos, procesados y almacenados
- **Medida de respuesta:**
  - Protocolo REST estándar (HTTP/JSON)
  - Manejo de cambios en API externa sin caída total
  - Logs de errores de integración
  - Fallback a múltiples fuentes si una falla

#### ESC-INT-02: Exportación de Datos
- **Fuente de estímulo:** Usuario o asociación agrícola
- **Estímulo:** Solicitud de exportar historial de actividades
- **Artefacto:** Módulo de reportes
- **Entorno:** Operación normal
- **Respuesta:** Datos exportados en formato estándar
- **Medida de respuesta:**
  - Formatos soportados: CSV, PDF
  - Datos estructurados según estándar abierto
  - Generación en < 10 segundos para 500 registros

---

## 9. Portabilidad (Portability)

### Definición
Facilidad para ejecutar el sistema en diferentes plataformas o entornos.

### Escenarios de Portabilidad

#### ESC-PORT-01: Soporte Multiplataforma Móvil
- **Fuente de estímulo:** Usuario con dispositivo iOS (futuro)
- **Estímulo:** Instalación de la app en iPhone
- **Artefacto:** Aplicación móvil
- **Entorno:** Dispositivos iOS 12+
- **Respuesta:** App funciona correctamente en iOS
- **Medida de respuesta:**
  - Arquitectura preparada para multi-plataforma (ej: Flutter, React Native)
  - 90% del código compartido entre Android e iOS
  - Funcionalidad equivalente en ambas plataformas

#### ESC-PORT-02: Cambio de Proveedor Cloud
- **Fuente de estímulo:** Administrador del sistema
- **Estímulo:** Migración de infraestructura de un proveedor cloud a otro
- **Artefacto:** Backend y base de datos
- **Entorno:** Migración planificada
- **Respuesta:** Sistema migrado con mínima interrupción
- **Medida de respuesta:**
  - Uso de tecnologías no propietarias (contenedores Docker)
  - Base de datos portable (PostgreSQL, MySQL)
  - Downtime durante migración: < 2 horas

---

## 10. Matriz de Priorización de Atributos de Calidad

| Atributo de Calidad | Prioridad | Criticidad | Dificultad Técnica | Costo de Implementación |
|-------------------|-----------|------------|-------------------|------------------------|
| Disponibilidad | Muy Alta | Crítica | Alta | Medio |
| Usabilidad | Muy Alta | Crítica | Media | Medio |
| Rendimiento | Alta | Alta | Media | Medio |
| Seguridad | Alta | Alta | Media | Bajo-Medio |
| Confiabilidad | Alta | Crítica | Alta | Medio |
| Escalabilidad | Media | Media | Media-Alta | Bajo (diseño) |
| Mantenibilidad | Media | Media | Baja-Media | Bajo |
| Interoperabilidad | Media | Media | Media | Bajo |
| Portabilidad | Baja | Baja | Media | Medio |

---

## 11. Atributos de Calidad vs Restricciones

| Restricción | Afecta a Atributo | Tensión/Sinergia |
|-----------|----------------|-----------------|
| Conectividad intermitente | Disponibilidad | Exige modo offline robusto |
| Dispositivos gama baja | Rendimiento | Requiere optimización agresiva |
| Bajo costo | Escalabilidad | Limita opciones de infraestructura |
| Baja alfabetización digital | Usabilidad | Prioriza simplicidad extrema |
| Equipo pequeño (5 personas) | Mantenibilidad | Exige código limpio y documentado |
| 4 meses de desarrollo | Todos | Requiere priorización estricta |
