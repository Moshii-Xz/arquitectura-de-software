# Requisitos Funcionales del Sistema

## 1. Módulo de Gestión de Usuarios

### RF-001: Registro de Usuario
- **Prioridad:** Alta
- **Descripción:** El sistema debe permitir el registro de nuevos productores agrícolas
- **Entradas:** Nombre, documento, teléfono, ubicación (municipio/vereda), email (opcional)
- **Salidas:** Cuenta de usuario creada, confirmación
- **Criterios de aceptación:**
  - Validación de campos obligatorios
  - Documento único por productor
  - Aceptación de términos y política de privacidad
  - Confirmación por SMS o correo

### RF-002: Inicio de Sesión
- **Prioridad:** Alta
- **Descripción:** El sistema debe autenticar usuarios registrados
- **Entradas:** Documento/teléfono y contraseña
- **Salidas:** Acceso al sistema o mensaje de error
- **Criterios de aceptación:**
  - Autenticación segura
  - Bloqueo temporal tras 3 intentos fallidos
  - Opción de recuperación de contraseña
  - Sesión persistente (recordar usuario)

### RF-003: Gestión de Perfil
- **Prioridad:** Media
- **Descripción:** El usuario debe poder actualizar su información personal
- **Entradas:** Datos personales, preferencias
- **Salidas:** Perfil actualizado
- **Criterios de aceptación:**
  - Modificación de datos no críticos
  - Cambio de contraseña con confirmación
  - Actualización de preferencias de notificaciones

---

## 2. Módulo de Gestión de Cultivos

### RF-004: Registrar Cultivo
- **Prioridad:** Alta
- **Descripción:** El productor debe poder registrar un nuevo cultivo
- **Entradas:** 
  - Tipo de cultivo (banano, café, yuca, cacao, etc.)
  - Área (hectáreas)
  - Fecha de siembra
  - Ubicación (coordenadas opcionales)
  - Variedad (opcional)
- **Salidas:** Cultivo registrado con ID único
- **Criterios de aceptación:**
  - Soporte para cultivos principales del Magdalena
  - Validación de fechas (no futuras para siembra)
  - Asociación automática con el usuario

### RF-005: Consultar Estado de Cultivo
- **Prioridad:** Alta
- **Descripción:** El sistema debe mostrar información actual del cultivo
- **Salidas:** 
  - Edad del cultivo
  - Fase fenológica estimada
  - Historial de actividades
  - Próximas acciones recomendadas
- **Criterios de aceptación:**
  - Vista clara y visual
  - Actualización en tiempo real cuando hay conexión
  - Acceso offline a última versión sincronizada

### RF-006: Actualizar Información de Cultivo
- **Prioridad:** Media
- **Descripción:** Modificar datos del cultivo (ej: área real, fecha cosecha)
- **Entradas:** Datos modificados del cultivo
- **Salidas:** Cultivo actualizado
- **Criterios de aceptación:**
  - Historial de cambios
  - Validación de datos

### RF-007: Archivar/Cerrar Cultivo
- **Prioridad:** Media
- **Descripción:** Marcar cultivo como finalizado tras cosecha
- **Entradas:** Fecha fin, rendimiento obtenido (opcional)
- **Salidas:** Cultivo archivado
- **Criterios de aceptación:**
  - Cultivos archivados no aparecen en vista principal
  - Posibilidad de consultar historial

---

## 3. Módulo de Monitoreo de Condiciones Climáticas

### RF-008: Integrar Datos Climáticos Actuales
- **Prioridad:** Alta
- **Descripción:** El sistema debe obtener datos meteorológicos de la ubicación del cultivo
- **Fuentes:** APIs públicas (IDEAM, OpenWeatherMap, etc.)
- **Salidas:**
  - Temperatura actual
  - Precipitación reciente
  - Humedad relativa
  - Pronóstico 3-7 días
- **Criterios de aceptación:**
  - Actualización cada 6-12 horas cuando hay conexión
  - Cacheo local de últimos datos
  - Manejo de errores si API no disponible

### RF-009: Visualizar Condiciones Climáticas
- **Prioridad:** Alta
- **Descripción:** Mostrar información climática de forma comprensible
- **Salidas:** 
  - Íconos y gráficos simples
  - Resumen textual (ej: "Día soleado, 32°C")
  - Tendencia (aumentando/disminuyendo)
- **Criterios de aceptación:**
  - Visualización clara sin tecnicismos
  - Accesible desde panel principal

### RF-010: Alertas Climáticas
- **Prioridad:** Alta
- **Descripción:** Notificar eventos climáticos relevantes
- **Triggers:** 
  - Lluvias intensas próximas
  - Sequía prolongada
  - Heladas (si aplica)
  - Vientos fuertes
- **Salidas:** Notificación push/SMS
- **Criterios de aceptación:**
  - Alertas oportunas (con anticipación)
  - Lenguaje claro y accionable
  - No saturar de notificaciones

---

## 4. Módulo de Recomendaciones

### RF-011: Generar Recomendaciones de Riego
- **Prioridad:** Alta
- **Descripción:** Sugerir cuándo y cuánto regar según clima y fase del cultivo
- **Entradas:** 
  - Tipo de cultivo
  - Fase fenológica
  - Precipitación reciente
  - Pronóstico
- **Salidas:** 
  - Recomendación clara (ej: "Regar mañana temprano, 20 litros por planta")
  - Justificación simple
- **Criterios de aceptación:**
  - Validadas por expertos agrónomos
  - Consideran disponibilidad hídrica
  - Priorizan eficiencia

### RF-012: Generar Recomendaciones de Fertilización
- **Prioridad:** Alta
- **Descripción:** Sugerir momentos y cantidades de fertilización
- **Entradas:**
  - Tipo de cultivo y fase
  - Historial de fertilización
  - Análisis de suelo (opcional)
- **Salidas:** Recomendación de tipo y cantidad de fertilizante
- **Criterios de aceptación:**
  - Evitar sobre-fertilización
  - Considerar costos
  - Alineadas con buenas prácticas agrícolas

### RF-013: Recomendaciones Fitosanitarias
- **Prioridad:** Media
- **Descripción:** Alertar sobre riesgos de plagas/enfermedades según condiciones
- **Entradas:**
  - Cultivo y fase
  - Condiciones climáticas (humedad, temperatura)
  - Reportes de plagas en la zona (si disponible)
- **Salidas:** 
  - Alert de riesgo (alto/medio/bajo)
  - Medidas preventivas sugeridas
  - Momento de aplicación de tratamientos
- **Criterios de aceptación:**
  - Información sobre manejo integrado de plagas
  - Preferencia por métodos ecológicos cuando posible
  - Advertencias de seguridad en uso de químicos

### RF-014: Historial de Recomendaciones
- **Prioridad:** Media
- **Descripción:** Registro de todas las recomendaciones recibidas
- **Salidas:** Lista cronológica con fecha, tipo y descripción
- **Criterios de aceptación:**
  - Posibilidad de marcar como "aplicada" o "no aplicada"
  - Filtros por tipo y fecha

---

## 5. Módulo de Registro de Actividades

### RF-015: Registrar Actividad Realizada
- **Prioridad:** Media
- **Descripción:** El productor puede registrar acciones ejecutadas
- **Entradas:**
  - Tipo de actividad (riego, fertilización, fumigación, poda, etc.)
  - Fecha y hora
  - Detalles (cantidad, producto usado, observaciones)
  - Foto (opcional)
- **Salidas:** Actividad guardada en historial del cultivo
- **Criterios de aceptación:**
  - Formulario simple
  - Actividades predefinidas + opción "otra"
  - Funciona offline, sincroniza después

### RF-016: Consultar Historial de Actividades
- **Prioridad:** Media
- **Descripción:** Ver todas las actividades realizadas en un cultivo
- **Salidas:** Lista cronológica o línea de tiempo
- **Criterios de aceptación:**
  - Filtros por tipo de actividad
  - Búsqueda por fecha
  - Exportar como PDF o CSV (opcional)

### RF-017: Recordatorios de Actividades
- **Prioridad:** Baja
- **Descripción:** Programar recordatorios de tareas futuras
- **Entradas:** Actividad, fecha/hora programada
- **Salidas:** Notificación en el momento indicado
- **Criterios de aceptación:**
  - Funciona incluso si no hay conexión (notificación local)
  - Opción de posponer

---

## 6. Módulo de Alertas y Notificaciones

### RF-018: Sistema de Notificaciones Push
- **Prioridad:** Alta
- **Descripción:** Enviar notificaciones al dispositivo del usuario
- **Tipos:**
  - Alertas climáticas urgentes
  - Recordatorios programados
  - Recomendaciones oportunas
  - Actualizaciones del sistema
- **Criterios de aceptación:**
  - Usuario puede configurar preferencias
  - No enviar notific aciones entre 10pm-6am (configurable)
  - Priorización de alertas críticas

### RF-019: Notificaciones SMS (Opcional/Futuro)
- **Prioridad:** Baja
- **Descripción:** Enviar alertas críticas por SMS si no hay datos
- **Criterios de aceptación:**
  - Solo para alertas de máxima prioridad
  - Bajo costo por mensaje

### RF-020: Centro de Notificaciones
- **Prioridad:** Media
- **Descripción:** Vista dentro de la app con todas las notificaciones recibidas
- **Salidas:** Lista de notificaciones (leídas/no leídas)
- **Criterios de aceptación:**
  - Ordenadas por fecha descendente
  - Marcar como leída
  - Filtrar por tipo

---

## 7. Módulo de Información y Ayuda

### RF-021: Biblioteca de Contenidos Educativos
- **Prioridad:** Media
- **Descripción:** Sección con guías y buenas prácticas agrícolas
- **Contenidos:**
  - Guías por tipo de cultivo
  - Videos cortos educativos
  - FAQs comunes
  - Calendario agrícola del Magdalena
- **Criterios de aceptación:**
  - Contenido descargable para acceso offline
  - Lenguaje simple
  - Formatos livianos (texto + imágenes comprimidas)

### RF-022: Asistente/Chatbot Básico
- **Prioridad:** Baja
- **Descripción:** Chatbot para responder preguntas frecuentes
- **Criterios de aceptación:**
  - Respuestas predefinidas
  - Escalamiento a soporte humano si no resuelve

### RF-023: Reportar Problema
- **Prioridad:** Media
- **Descripción:** Canal para que usuarios reporten errores o sugerencias
- **Entradas:** Descripción del problema, capturas de pantalla
- **Salidas:** Ticket generado
- **Criterios de aceptación:**
  - Formulario simple
  - Confirmación de recepción

---

## 8. Módulo de Administración (Backoffice)

### RF-024: Panel de Administración
- **Prioridad:** Media
- **Descripción:** Interfaz web para personal técnico y administradores
- **Funcionalidades:**
  - Ver usuarios registrados
  - Estadísticas de uso
  - Gestión de contenidos educativos
  - Configuración de parámetros del sistema
- **Criterios de aceptación:**
  - Acceso restringido (autenticación de admin)
  - Logs de auditoría

### RF-025: Gestión de Cultivos Soportados
- **Prioridad:** Media
- **Descripción:** Configurar parámetros de cada tipo de cultivo
- **Entradas:** 
  - Nombre del cultivo
  - Fases fenológicas y duración
  - Requerimientos hídricos
  - Parámetros para recomendaciones
- **Criterios de aceptación:**
  - CRUD completo
  - Validación por expertos antes de publicar

### RF-026: Monitoreo de Sistema
- **Prioridad:** Alta
- **Descripción:** Visualizar salud del sistema (uptime, errores, APIs externas)
- **Salidas:** Dashboard con métricas clave
- **Criterios de aceptación:**
  - Alertas automáticas si servicio cae
  - Logs de errores

---

## 9. Requisitos de Sincronización y Offline

### RF-027: Modo Offline
- **Prioridad:** Alta
- **Descripción:** Funcionalidad básica sin conexión a internet
- **Capacidades offline:**
  - Ver información de cultivos
  - Registrar actividades (en cola)
  - Ver últimas recomendaciones recibidas
  - Ver notificaciones locales
- **Criterios de aceptación:**
  - Detección automática de estado de conexión
  - Indicador visual de modo offline
  - Datos críticos en caché local

### RF-028: Sincronización Automática
- **Prioridad:** Alta
- **Descripción:** Cuando se recupera conexión, sincronizar datos pendientes
- **Operaciones:**
  - Subir actividades registradas offline
  - Descargar alertas y recomendaciones nuevas
  - Actualizar datos climáticos
- **Criterios de aceptación:**
  - Sincronización en background
  - Resolución de conflictos (última escritura gana o validación)
  - Notificación al usuario de sincronización exitosa

### RF-029: Sincronización Manual
- **Prioridad:** Media
- **Descripción:** Botón para forzar sincronización cuando el usuario lo desee
- **Criterios de aceptación:**
  - Verificación previa de conexión
  - Progreso visible
  - Manejo de errores

---

## 10. Requisitos de Reportes (Opcional/Futuro)

### RF-030: Reporte de Cultivo
- **Prioridad:** Baja
- **Descripción:** Generar reporte PDF con resumen del cultivo
- **Contenidos:**
  - Información general
  - Línea de tiempo de actividades
  - Condiciones climáticas promedio
  - Recomendaciones recibidas
- **Criterios de aceptación:**
  - Formato imprimible
  - Generación rápida

### RF-031: Estadísticas Personales
- **Prioridad:** Baja
- **Descripción:** Visualizar datos agregados de todos los cultivos del usuario
- **Salidas:**
  - Número total de cultivos
  - Rendimientos promedio
  - Actividades más frecuentes
  - Ahorro estimado de agua/fertilizantes

---

## 11. Matriz de Priorización de Requisitos

| ID | Requisito | Prioridad | Complejidad | Valor para Usuario | MVP |
|----|-----------|-----------|-------------|-------------------|-----|
| RF-001 | Registro de usuario | Alta | Baja | Alto | ✓ |
| RF-002 | Inicio de sesión | Alta | Baja | Alto | ✓ |
| RF-004 | Registrar cultivo | Alta | Media | Muy Alto | ✓ |
| RF-005 | Consultar estado cultivo | Alta | Media | Muy Alto | ✓ |
| RF-008 | Integrar datos climáticos | Alta | Alta | Muy Alto | ✓ |
| RF-009 | Visualizar clima | Alta | Baja | Alto | ✓ |
| RF-010 | Alertas climáticas | Alta | Media | Muy Alto | ✓ |
| RF-011 | Recomendaciones riego | Alta | Alta | Muy Alto | ✓ |
| RF-012 | Recomendaciones fertilización | Alta | Alta | Muy Alto | ✓ |
| RF-015 | Registrar actividad | Media | Baja | Alto | ✓ |
| RF-027 | Modo offline | Alta | Alta | Muy Alto | ✓ |
| RF-028 | Sincronización automática | Alta | Alta | Alto | ✓ |
| RF-003 | Gestión de perfil | Media | Baja | Medio | ✗ |
| RF-013 | Recomendaciones fitosanitarias | Media | Alta | Alto | Fase 2 |
| RF-021 | Biblioteca educativa | Media | Media | Medio | Fase 2 |
| RF-024 | Panel administración | Media | Media | Bajo (Admin) | Fase 2 |

**Total requisitos:** 31  
**Requisitos MVP (60%):** 12 requisitos críticos
