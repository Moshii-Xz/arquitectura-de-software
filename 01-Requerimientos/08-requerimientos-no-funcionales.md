# Requerimientos No Funcionales (RNF)

## 1. Proposito y alcance

Este documento consolida los requerimientos no funcionales del sistema en una estructura estandar por categoria de calidad, con criterio de verificacion.

## 2. Estructura de especificacion

Cada RNF se documenta con:
- ID
- Categoria
- Requerimiento
- Criterio de verificacion

---

## 3. Catalogo de RNF

### 3.1 Rendimiento y eficiencia

| ID | Categoria | Requerimiento | Criterio de verificacion |
|----|-----------|---------------|--------------------------|
| RNF-01 | Rendimiento | El sistema debe responder a las solicitudes en menos de 3 segundos en condiciones de red 3G para la mayoria de las transacciones. | Pruebas de rendimiento con red 3G simulada y percentil objetivo acordado. |
| RNF-02 | Rendimiento | El sistema debe cargar la pantalla principal en menos de 5 segundos en dispositivos de gama baja. | Pruebas en dispositivos objetivo de gama baja con medicion de tiempo de carga. |
| RNF-03 | Rendimiento | El sistema debe procesar y publicar alertas climaticas en menos de 60 segundos desde la recepcion de datos. | Prueba extremo a extremo desde ingesta de datos hasta publicacion de alerta. |
| RNF-04 | Rendimiento | El sistema debe generar reportes en menos de 10 segundos para periodos de hasta 6 meses. | Pruebas de generacion de reportes con datos de hasta 6 meses. |
| RNF-05 | Rendimiento | El sistema debe exportar reportes en PDF en menos de 15 segundos en condiciones de red WiFi. | Pruebas de exportacion en red WiFi bajo condiciones controladas. |
| RNF-06 | Rendimiento | El sistema debe sincronizar datos generados en modo offline en menos de 60 segundos tras recuperar la conexion. | Pruebas de sincronizacion al restaurar conectividad. |
| RNF-07 | Eficiencia | El sistema debe limitar el consumo de bateria a un maximo del 8% por hora en uso activo. | Medicion de consumo energetico en sesiones de uso activo estandarizadas. |
| RNF-08 | Eficiencia | El sistema debe optimizar el consumo de datos moviles a un maximo de 20 MB diarios por usuario. | Monitoreo del trafico movil diario por usuario en escenarios representativos. |

### 3.2 Disponibilidad, continuidad y recuperacion

| ID | Categoria | Requerimiento | Criterio de verificacion |
|----|-----------|---------------|--------------------------|
| RNF-09 | Disponibilidad | El sistema debe garantizar una disponibilidad minima del 95% mensual. | Monitoreo mensual de uptime y reporte de disponibilidad. |
| RNF-10 | Continuidad operativa | El sistema debe continuar operando sus funciones principales ante la caida del servicio climatico externo. | Pruebas de resiliencia desconectando el servicio externo y validando funciones principales. |
| RNF-11 | Mantenimiento | El sistema debe limitar el tiempo de inactividad por mantenimiento a un maximo de 4 horas mensuales. | Registro mensual de ventanas de mantenimiento y tiempo acumulado. |
| RNF-12 | Recuperacion | El sistema debe recuperarse de fallos no planificados en menos de 30 minutos sin perdida de datos recientes. | Simulacros de falla y medicion de RTO/RPO definidos. |
| RNF-13 | Integridad | El sistema debe garantizar la integridad de los datos generados en modo offline durante la sincronizacion. | Pruebas de consistencia antes/despues de sincronizacion offline. |
| RNF-14 | Respaldo | El sistema debe realizar copias de seguridad automaticas cada 24 horas. | Verificacion automatizada de ejecucion diaria de backups. |
| RNF-15 | Observabilidad | El sistema debe contar con monitoreo que detecte y notifique caidas del servicio en pocos minutos. | Pruebas de alerta y tiempos de deteccion/notificacion definidos por SLA interno. |

### 3.3 Seguridad y control de acceso

| ID | Categoria | Requerimiento | Criterio de verificacion |
|----|-----------|---------------|--------------------------|
| RNF-16 | Seguridad de transporte | El sistema debe cifrar todas las comunicaciones mediante HTTPS con protocolos seguros. | Validacion de configuracion TLS y escaneo de seguridad de endpoints. |
| RNF-17 | Seguridad de datos | El sistema debe cifrar los datos almacenados en la base de datos. | Verificacion de cifrado en reposo y configuracion de almacenamiento. |
| RNF-18 | Credenciales | El sistema debe almacenar contrasenas utilizando algoritmos de hash seguros. | Revision de implementacion y pruebas de cumplimiento de algoritmo seguro. |
| RNF-19 | Autorizacion | El sistema debe controlar el acceso a funcionalidades segun los permisos asignados. | Pruebas de control de acceso por rol y permiso. |
| RNF-20 | Aislamiento de datos | El sistema debe impedir el acceso a datos de otros usuarios. | Pruebas de seguridad horizontal entre cuentas. |
| RNF-21 | Sesiones | El sistema debe gestionar tokens de sesion seguros con expiracion definida. | Pruebas de expiracion y manejo seguro de tokens. |
| RNF-22 | Seguridad aplicativa | El sistema debe prevenir ataques de inyeccion SQL mediante mecanismos seguros. | Pruebas de seguridad y revision de consultas parametrizadas. |
| RNF-23 | Seguridad aplicativa | El sistema debe prevenir ataques XSS mediante validacion y sanitizacion de entradas. | Pruebas de inyeccion XSS en entradas y salida codificada. |
| RNF-24 | Auditoria | El sistema debe registrar acciones criticas en un sistema de auditoria. | Verificacion de trazas de eventos criticos en logs de auditoria. |
| RNF-25 | Politicas de credenciales | El sistema debe aplicar politicas de contrasenas seguras. | Validacion de reglas de complejidad, longitud y rotacion segun politica. |

### 3.4 Usabilidad y accesibilidad

| ID | Categoria | Requerimiento | Criterio de verificacion |
|----|-----------|---------------|--------------------------|
| RNF-26 | Usabilidad | El sistema debe permitir registrar un cultivo en un maximo de 4 pasos. | Pruebas de flujo UX contabilizando pasos desde inicio a confirmacion. |
| RNF-27 | Usabilidad | El sistema debe utilizar lenguaje claro y comprensible para los usuarios. | Revision de contenido UX y pruebas con usuarios objetivo. |
| RNF-28 | Usabilidad | El sistema debe incluir iconos representativos en las funciones principales. | Evaluacion heuristica de interfaz y consistencia iconografica. |
| RNF-29 | Accesibilidad | El sistema debe cumplir estandares de contraste visual accesible. | Validacion con herramientas de contraste segun estandar adoptado. |
| RNF-30 | Accesibilidad | El sistema debe garantizar tamanos adecuados en elementos tactiles. | Verificacion de dimensiones minimas en controles interactivos. |
| RNF-31 | Usabilidad | El sistema debe mostrar mensajes de error claros y comprensibles. | Pruebas de flujos de error con evaluacion de claridad del mensaje. |
| RNF-32 | Usabilidad y seguridad | El sistema debe solicitar confirmacion antes de ejecutar acciones destructivas. | Pruebas de acciones criticas verificando confirmacion previa. |
| RNF-33 | Usabilidad | El sistema debe alcanzar un nivel alto de satisfaccion en pruebas de usabilidad. | Evaluacion de satisfaccion mediante instrumento definido (ej. SUS). |
| RNF-34 | Accesibilidad | El sistema debe ser accesible para usuarios con dificultades visuales como daltonismo. | Validacion de interfaz con simuladores/filtros de daltonismo y ajustes visuales. |

### 3.5 Escalabilidad y capacidad

| ID | Categoria | Requerimiento | Criterio de verificacion |
|----|-----------|---------------|--------------------------|
| RNF-35 | Escalabilidad | El sistema debe soportar al menos 200 usuarios concurrentes sin degradacion del rendimiento. | Pruebas de carga con 200 usuarios concurrentes. |
| RNF-36 | Escalabilidad | El sistema debe escalar hasta 2.000 usuarios concurrentes sin cambios en la logica de negocio. | Pruebas de carga/escalado horizontal manteniendo logica funcional. |
| RNF-37 | Escalabilidad de datos | El sistema debe permitir el crecimiento del almacenamiento de datos de forma horizontal. | Verificacion de estrategia de particionamiento/escalado de almacenamiento. |
| RNF-38 | Escalabilidad modular | El sistema debe permitir la escalabilidad independiente de sus modulos funcionales. | Revision arquitectonica y pruebas de escalado por modulo. |
| RNF-39 | Integraciones | El sistema debe soportar multiples solicitudes simultaneas a servicios externos. | Pruebas de concurrencia en integraciones externas. |

### 3.6 Mantenibilidad y calidad interna

| ID | Categoria | Requerimiento | Criterio de verificacion |
|----|-----------|---------------|--------------------------|
| RNF-40 | Mantenibilidad | El sistema debe contar con documentacion tecnica actualizada. | Revision periodica de completitud y fecha de actualizacion documental. |
| RNF-41 | Calidad de software | El sistema debe tener una cobertura minima de pruebas unitarias. | Medicion automatizada de cobertura con umbral acordado por el equipo. |
| RNF-42 | Evolutividad | El sistema debe permitir la incorporacion rapida de nuevos modulos funcionales. | Evaluacion de tiempo/esfuerzo de integracion de un modulo piloto. |
| RNF-43 | Arquitectura | El sistema debe implementar una arquitectura con separacion de capas. | Revision de arquitectura y dependencias por capa. |
| RNF-44 | Gestion de configuracion | El sistema debe gestionar el codigo fuente mediante control de versiones. | Verificacion del repositorio, ramas y politicas de integracion. |
| RNF-45 | Observabilidad | El sistema debe registrar errores con informacion detallada para diagnostico. | Revision de logs con contexto tecnico suficiente para depuracion. |
| RNF-46 | Configuracion | El sistema debe manejar configuraciones de forma externa al codigo fuente. | Verificacion de uso de variables/archivos de configuracion externos. |

### 3.7 Compatibilidad y portabilidad

| ID | Categoria | Requerimiento | Criterio de verificacion |
|----|-----------|---------------|--------------------------|
| RNF-47 | Compatibilidad | El sistema debe ser compatible con navegadores modernos en dispositivos moviles. | Pruebas de compatibilidad en matriz de navegadores objetivo. |
| RNF-48 | Compatibilidad | El sistema debe contar con diseno responsivo adaptable a diferentes tamanos de pantalla. | Pruebas de interfaz en varios breakpoints y resoluciones. |
| RNF-49 | Portabilidad | El sistema debe funcionar sin requerir instalacion adicional de software. | Validacion de ejecucion en navegador sin componentes extra. |
| RNF-50 | Compatibilidad de dispositivo | El sistema debe operar correctamente en dispositivos de gama baja. | Pruebas funcionales y de rendimiento en equipos de gama baja. |
| RNF-51 | Interoperabilidad | El sistema debe generar archivos PDF compatibles con visores estandar. | Apertura y validacion de PDF en visores comunes. |
| RNF-52 | Portabilidad de datos | El sistema debe permitir la migracion de la base de datos sin perdida de informacion. | Pruebas de migracion y conciliacion de datos origen/destino. |

### 3.8 Operacion offline y sincronizacion

| ID | Categoria | Requerimiento | Criterio de verificacion |
|----|-----------|---------------|--------------------------|
| RNF-53 | Offline-first | El sistema debe permitir registrar y editar cultivos en modo offline. | Pruebas funcionales sin conexion para registro y edicion de cultivos. |
| RNF-54 | Offline-first | El sistema debe permitir registrar insumos sin conexion a internet. | Pruebas funcionales offline para registro de insumos. |
| RNF-55 | Experiencia de conexion | El sistema debe mostrar el estado de conectividad en todo momento. | Validacion visual del indicador de conectividad en todas las vistas clave. |
| RNF-56 | Seguridad offline | El sistema debe proteger los datos almacenados localmente en modo offline. | Revision de mecanismos de proteccion local y pruebas de acceso no autorizado. |
| RNF-57 | Sincronizacion | El sistema debe resolver conflictos de sincronizacion de datos. | Pruebas de conflicto con reglas definidas y resultados consistentes. |
| RNF-58 | Offline-first | El sistema debe permitir la consulta de catalogos en modo offline. | Pruebas de consulta de catalogos sin conectividad. |

### 3.9 Cumplimiento normativo y etico

| ID | Categoria | Requerimiento | Criterio de verificacion |
|----|-----------|---------------|--------------------------|
| RNF-59 | Cumplimiento legal | El sistema debe cumplir con las normativas de proteccion de datos personales. | Revision legal y tecnica de cumplimiento normativo aplicable. |
| RNF-60 | Privacidad | El sistema debe solicitar el consentimiento del usuario para el uso de sus datos. | Verificacion de flujo de consentimiento explicito y registro de aceptacion. |
| RNF-61 | Confidencialidad | El sistema debe garantizar la confidencialidad de los datos productivos. | Pruebas y controles de acceso, cifrado y manejo seguro de datos. |
| RNF-62 | Transparencia | El sistema debe indicar que las recomendaciones son de apoyo y no sustituyen criterio profesional. | Validacion de mensajes de descargo en puntos de recomendacion. |
| RNF-63 | Equidad de acceso | El sistema debe garantizar igualdad de acceso independientemente de la conectividad. | Pruebas de funcionalidades minimas en escenarios online y offline. |
| RNF-64 | Trazabilidad | El sistema debe mantener trazabilidad de recomendaciones y acciones del usuario. | Verificacion de historial y auditoria de acciones y recomendaciones. |

---

## 4. Resumen

- **Total RNF:** 64
- **Cobertura:** Rendimiento, disponibilidad, seguridad, usabilidad, escalabilidad, mantenibilidad, compatibilidad, operacion offline y cumplimiento.
