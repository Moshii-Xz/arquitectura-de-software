# Plataforma Digital de Agricultura Inteligente para Pequeños Productores del Magdalena

**Asignatura:** Arquitectura de Software - 4 créditos  
**Docente:** Carlos Nelson Henrique Miranda  
**Facultad:** Facultad de Ingeniería — Santa Marta, 2026-1

**Presentado por:**
- 2021114055 — Juan Mosquera
- 2021214058 — Mauricio Saballeth

---

## 1. Identificación del Proyecto

| Campo | Detalle |
|---|---|
| **Título del Proyecto** | Plataforma Digital de Agricultura Inteligente para Pequeños Productores del Magdalena |
| **Duración** | 12 semanas |
| **Modalidad** | Trabajo en equipo — 4 integrantes |

---

## 2. Descripción del Problema de Ingeniería

En el departamento del Magdalena, los pequeños productores agrícolas enfrentan desafíos críticos en la optimización de sus recursos. Los pequeños productores del departamento del Magdalena enfrentan dificultades para gestionar eficientemente el riego y la aplicación de insumos, debido a la falta de herramientas digitales adaptadas a su contexto.

Asimismo, la aplicación de fertilizantes con abono e insecticidas para el control de pestes se realiza de manera empírica, sin una base de datos histórica o climática que valide el momento óptimo de aplicación. Esto incrementa los costos de producción y el impacto ambiental por el posible sobreuso de químicos. El problema radica en la falta de una herramienta digital que permita al productor monitorear estas variables bajo condiciones de conectividad intermitente y dispositivos, integrando recomendaciones que respeten el criterio humano del agricultor.

Los pequeños productores del Magdalena dependen de decisiones empíricas debido a la variabilidad climática y falta de herramientas digitales. Esto genera:

- Consumo ineficiente de agua y altos costos de insumos.
- Riesgo elevado de pérdida de cosechas.
- Impacto ambiental negativo por sobreuso de fertilizantes.

---

## 3. Proceso de Diseño de Ingeniería

### 3a. Condiciones de Desarrollo

A continuación se justifica la selección de tecnologías y herramientas que guiarán el desarrollo del proyecto:

| Componente | Tecnología | Justificación |
|---|---|---|
| **Proceso de Desarrollo** | RUP | Enfoque iterativo e incremental, permite gestionar riesgos críticos como la conectividad intermitente, el uso en dispositivos de gama baja y el tiempo limitado del proyecto. |
| **Base de Datos** | PostgreSQL | Robustez para el manejo de datos históricos climáticos y de cultivos; opción de bajo costo y alta fiabilidad. |
| **Lenguaje de Programación** | Java | Robustez, amplia adopción en entornos empresariales y compatibilidad con tecnologías clave del proyecto. |
| **Framework Backend** | Spring Boot | Facilita la creación de servicios escalables y seguros para el procesamiento de alertas y recomendaciones. |
| **Framework Frontend** | React JS | Permite desarrollar una interfaz progresiva y ligera. |

---

### 3b(i). Contexto del Problema

El sistema operará en el departamento del Magdalena, Colombia, en zonas rurales con conectividad intermitente y usuarios con bajo nivel de alfabetización digital. Se trata de un entorno con dispositivos móviles de gama baja, presupuesto operativo reducido y necesidad de funcionamiento autónomo en campo. La solución debe adaptarse a estas condiciones para ser técnicamente viable y socialmente adoptada por los productores.

---

### 3b(ii). Identificación de Stakeholders

- Productores agrícolas
- Operarios de campo
- Asociaciones agrícolas del Magdalena
- Compradores y comercializadores
- Entidades regulatorias (ICA, MinAgricultura)
- Proveedores de datos climáticos (IDEAM)
- Consumidores finales
- Equipo de desarrollo

---

### 3b(iv). Especificación de Requerimientos (ISO/IEC/IEEE 29148:2018)

#### Requerimientos Funcionales (RF)

**Autenticación y Sesión**
- **RF-01:** El sistema debe permitir la autenticación de usuarios mediante usuario y contraseña antes de acceder a cualquier funcionalidad.
- **RF-02:** El sistema debe permitir cerrar la sesión de forma segura desde cualquier pantalla.
- **RF-03:** El sistema debe permitir recuperar la contraseña mediante un código de verificación enviado al correo registrado.
- **RF-04:** El sistema debe permitir cambiar la contraseña ingresando la contraseña actual y confirmando la nueva.
- **RF-05:** El sistema debe bloquear temporalmente una cuenta después de múltiples intentos fallidos de inicio de sesión.
- **RF-06:** El sistema debe gestionar roles y permisos para restringir el acceso a funcionalidades.
- **RF-07:** El sistema debe mantener la sesión activa por un tiempo limitado y solicitar reautenticación al expirar.

**Perfil de Usuario**
- **RF-08:** El sistema debe permitir crear y completar el perfil con información personal y productiva.
- **RF-09:** El sistema debe mostrar toda la información del perfil en una sola pantalla.
- **RF-10:** El sistema debe permitir editar la información del perfil, excepto el correo electrónico.
- **RF-11:** El sistema debe permitir cargar una foto de perfil en formatos permitidos.
- **RF-12:** El sistema debe permitir registrar la ubicación geográfica mediante coordenadas o mapa.
- **RF-13:** El sistema debe permitir configurar el idioma de la interfaz.
- **RF-14:** El sistema debe permitir configurar las preferencias de notificación.

**Gestión de Cultivos**
- **RF-15:** El sistema debe permitir registrar un cultivo con sus datos principales.
- **RF-16:** El sistema debe mostrar la lista de cultivos activos ordenados por fecha.
- **RF-17:** El sistema debe mostrar el detalle completo de un cultivo.
- **RF-18:** El sistema debe permitir editar un cultivo mientras no esté finalizado.
- **RF-19:** El sistema debe permitir actualizar el estado de un cultivo registrando la fecha del cambio.
- **RF-20:** El sistema debe permitir eliminar un cultivo solicitando confirmación y conservando el historial.
- **RF-21:** El sistema debe permitir adjuntar múltiples fotografías a un cultivo.
- **RF-22:** El sistema debe permitir registrar observaciones asociadas a un cultivo.
- **RF-23:** El sistema debe permitir buscar y filtrar cultivos por diferentes criterios.

**Gestión de Insumos**
- **RF-24:** El sistema debe permitir registrar la aplicación de un insumo a un cultivo.
- **RF-25:** El sistema debe mostrar el historial de insumos aplicados a un cultivo.
- **RF-26:** El sistema debe permitir editar un registro de insumo dentro de un tiempo limitado.
- **RF-27:** El sistema debe permitir eliminar un registro de insumo con confirmación.
- **RF-28:** El sistema debe calcular el costo total de insumos por cultivo.
- **RF-29:** El sistema debe generar alertas cuando se registre un insumo de alto impacto ambiental.
- **RF-30:** El sistema debe gestionar un catálogo de insumos disponible para consulta.
- **RF-31:** El sistema debe generar recomendaciones de insumos según condiciones del cultivo.

**Alertas Climáticas**
- **RF-32:** El sistema debe integrar datos desde un servicio climático externo.
- **RF-33:** El sistema debe generar alertas cuando la temperatura supere umbrales definidos.
- **RF-34:** El sistema debe generar alertas por niveles de lluvia extremos.
- **RF-35:** El sistema debe generar alertas por condiciones de sequía.
- **RF-36:** El sistema debe mostrar el historial de alertas climáticas.
- **RF-37:** El sistema debe permitir marcar alertas como leídas.
- **RF-38:** El sistema debe permitir configurar umbrales de alerta.
- **RF-39:** El sistema debe mostrar un mapa de condiciones climáticas.

**Recomendaciones**
- **RF-40:** El sistema debe generar recomendaciones de riego basadas en condiciones climáticas.
- **RF-41:** El sistema debe generar recomendaciones de fertilización según el ciclo del cultivo.
- **RF-42:** El sistema debe generar recomendaciones fitosanitarias.
- **RF-43:** El sistema debe mostrar las recomendaciones activas ordenadas por prioridad.
- **RF-44:** El sistema debe mostrar el detalle y justificación de cada recomendación.
- **RF-45:** El sistema debe permitir marcar recomendaciones como atendidas.
- **RF-46:** El sistema debe permitir descartar recomendaciones manteniendo el historial.
- **RF-47:** El sistema debe mostrar el historial de recomendaciones.

**Reportes**
- **RF-48:** El sistema debe generar reportes del estado de los cultivos.
- **RF-49:** El sistema debe generar reportes de consumo de insumos.
- **RF-50:** El sistema debe generar reportes de alertas recibidas.
- **RF-51:** El sistema debe permitir exportar reportes en formato PDF.
- **RF-52:** El sistema debe permitir filtrar reportes por período de tiempo.
- **RF-53:** El sistema debe generar reportes comparativos entre cultivos.

**Gestión de Usuarios**
- **RF-54:** El sistema debe permitir crear cuentas de usuario con datos básicos y rol asignado.
- **RF-55:** El sistema debe mostrar la lista de usuarios registrados.
- **RF-56:** El sistema debe permitir editar la información de los usuarios.
- **RF-57:** El sistema debe permitir desactivar cuentas sin eliminar datos.
- **RF-58:** El sistema debe permitir reactivar cuentas desactivadas.
- **RF-59:** El sistema debe mostrar la actividad reciente de los usuarios.

**Notificaciones**
- **RF-60:** El sistema debe enviar notificaciones internas de alertas climáticas.
- **RF-61:** El sistema debe enviar notificaciones internas de nuevas recomendaciones.
- **RF-62:** El sistema debe mostrar un contador de notificaciones no leídas.
- **RF-63:** El sistema debe sincronizar notificaciones generadas en modo offline.
- **RF-64:** El sistema debe mostrar el historial de notificaciones.
- **RF-65:** El sistema debe permitir eliminar notificaciones.

---

#### Requerimientos No Funcionales (RNF)

**Rendimiento**
- **RNF-01:** El sistema debe responder a las solicitudes en menos de 3 segundos en condiciones de red 3G para la mayoría de las transacciones.
- **RNF-02:** El sistema debe cargar la pantalla principal en menos de 5 segundos en dispositivos de gama baja.
- **RNF-03:** El sistema debe procesar y publicar alertas climáticas en menos de 60 segundos desde la recepción de datos.
- **RNF-04:** El sistema debe generar reportes en menos de 10 segundos para períodos de hasta 6 meses.
- **RNF-05:** El sistema debe exportar reportes en PDF en menos de 15 segundos en condiciones de red WiFi.
- **RNF-06:** El sistema debe sincronizar datos generados en modo offline en menos de 60 segundos tras recuperar la conexión.
- **RNF-07:** El sistema debe limitar el consumo de batería a un máximo del 8% por hora en uso activo.
- **RNF-08:** El sistema debe optimizar el consumo de datos móviles a un máximo de 20 MB diarios por usuario.

**Disponibilidad y Confiabilidad**
- **RNF-09:** El sistema debe garantizar una disponibilidad mínima del 95% mensual.
- **RNF-10:** El sistema debe continuar operando sus funciones principales ante la caída del servicio climático externo.
- **RNF-11:** El sistema debe limitar el tiempo de inactividad por mantenimiento a un máximo de 4 horas mensuales.
- **RNF-12:** El sistema debe recuperarse de fallos no planificados en menos de 30 minutos sin pérdida de datos recientes.
- **RNF-13:** El sistema debe garantizar la integridad de los datos generados en modo offline durante la sincronización.
- **RNF-14:** El sistema debe realizar copias de seguridad automáticas cada 24 horas.
- **RNF-15:** El sistema debe contar con monitoreo que detecte y notifique caídas del servicio en pocos minutos.

**Seguridad**
- **RNF-16:** El sistema debe cifrar todas las comunicaciones mediante HTTPS con protocolos seguros.
- **RNF-17:** El sistema debe cifrar los datos almacenados en la base de datos.
- **RNF-18:** El sistema debe almacenar contraseñas utilizando algoritmos de hash seguros.
- **RNF-19:** El sistema debe controlar el acceso a funcionalidades según los permisos asignados.
- **RNF-20:** El sistema debe impedir el acceso a datos de otros usuarios.
- **RNF-21:** El sistema debe gestionar tokens de sesión seguros con expiración definida.
- **RNF-22:** El sistema debe prevenir ataques de inyección SQL mediante mecanismos seguros.
- **RNF-23:** El sistema debe prevenir ataques XSS mediante validación y sanitización de entradas.
- **RNF-24:** El sistema debe registrar acciones críticas en un sistema de auditoría.
- **RNF-25:** El sistema debe aplicar políticas de contraseñas seguras.

**Usabilidad**
- **RNF-26:** El sistema debe permitir registrar un cultivo en un máximo de 4 pasos.
- **RNF-27:** El sistema debe utilizar lenguaje claro y comprensible para los usuarios.
- **RNF-28:** El sistema debe incluir íconos representativos en las funciones principales.
- **RNF-29:** El sistema debe cumplir estándares de contraste visual accesible.
- **RNF-30:** El sistema debe garantizar tamaños adecuados en elementos táctiles.
- **RNF-31:** El sistema debe mostrar mensajes de error claros y comprensibles.
- **RNF-32:** El sistema debe solicitar confirmación antes de ejecutar acciones destructivas.
- **RNF-33:** El sistema debe alcanzar un nivel alto de satisfacción en pruebas de usabilidad.
- **RNF-34:** El sistema debe ser accesible para usuarios con dificultades visuales como daltonismo.

**Escalabilidad**
- **RNF-35:** El sistema debe soportar al menos 200 usuarios concurrentes sin degradación del rendimiento.
- **RNF-36:** El sistema debe escalar hasta 2.000 usuarios concurrentes sin cambios en la lógica de negocio.
- **RNF-37:** El sistema debe permitir el crecimiento del almacenamiento de datos de forma horizontal.
- **RNF-38:** El sistema debe permitir la escalabilidad independiente de sus módulos funcionales.
- **RNF-39:** El sistema debe soportar múltiples solicitudes simultáneas a servicios externos.

**Mantenibilidad**
- **RNF-40:** El sistema debe contar con documentación técnica actualizada.
- **RNF-41:** El sistema debe tener una cobertura mínima de pruebas unitarias.
- **RNF-42:** El sistema debe permitir la incorporación rápida de nuevos módulos funcionales.
- **RNF-43:** El sistema debe implementar una arquitectura con separación de capas.
- **RNF-44:** El sistema debe gestionar el código fuente mediante control de versiones.
- **RNF-45:** El sistema debe registrar errores con información detallada para diagnóstico.
- **RNF-46:** El sistema debe manejar configuraciones de forma externa al código fuente.

**Portabilidad y Compatibilidad**
- **RNF-47:** El sistema debe ser compatible con navegadores modernos en dispositivos móviles.
- **RNF-48:** El sistema debe contar con diseño responsivo adaptable a diferentes tamaños de pantalla.
- **RNF-49:** El sistema debe funcionar sin requerir instalación adicional de software.
- **RNF-50:** El sistema debe operar correctamente en dispositivos de gama baja.
- **RNF-51:** El sistema debe generar archivos PDF compatibles con visores estándar.
- **RNF-52:** El sistema debe permitir la migración de la base de datos sin pérdida de información.

**Modo Offline**
- **RNF-53:** El sistema debe permitir registrar y editar cultivos en modo offline.
- **RNF-54:** El sistema debe permitir registrar insumos sin conexión a internet.
- **RNF-55:** El sistema debe mostrar el estado de conectividad en todo momento.
- **RNF-56:** El sistema debe proteger los datos almacenados localmente en modo offline.
- **RNF-57:** El sistema debe resolver conflictos de sincronización de datos.
- **RNF-58:** El sistema debe permitir la consulta de catálogos en modo offline.

**Cumplimiento Legal y Ético**
- **RNF-59:** El sistema debe cumplir con las normativas de protección de datos personales.
- **RNF-60:** El sistema debe solicitar el consentimiento del usuario para el uso de sus datos.
- **RNF-61:** El sistema debe garantizar la confidencialidad de los datos productivos.
- **RNF-62:** El sistema debe indicar que las recomendaciones son de apoyo y no sustituyen criterio profesional.
- **RNF-63:** El sistema debe garantizar igualdad de acceso independientemente de la conectividad.
- **RNF-64:** El sistema debe mantener trazabilidad de recomendaciones y acciones del usuario.
- **RNF-65:** El sistema debe promover recomendaciones ambientalmente responsables.

---

### 3b(v). Plan, Cronograma y Presupuesto de Desarrollo

#### Roles del Equipo

| Rol | Integrante |
|---|---|
| Arquitecto de Software / Líder Técnico | Juan Mosquera |
| Analista de Requisitos | Juan Mosquera |
| Desarrollador Backend | Mauricio Saballeth |
| Desarrollador Frontend | Miguel Olaya |
| Responsable de Calidad y Validación | Luis Mateus Ramírez |

#### Mecanismos de Comunicación

- Reuniones semanales (Teams meetings)
- Microsoft Teams (comunicación rápida)
- Trello / Jira (gestión de tareas)
- GitHub (control de versiones)

#### Coordinación

- Uso de backlog priorizado
- Asignación de tareas por sprint
- Seguimiento de avances semanal

#### Plan con Costos y Tiempo

> Duración total: **4 meses** | 1 iteración = 10 días

| Integrante | Cantidad | Salario Mensual | Disponibilidad | Inicio | Elaboración | Construcción | Despliegue | Total |
|---|---|---|---|---|---|---|---|---|
| Analista de Requisitos | 1 | $6.000.000 | 50% | 2 | 3 | 5 | 2 | $12.000.000 |
| Arq. de Software | 1 | $5.000.000 | 50% | 2 | 3 | 5 | 1 | $9.166.667 |
| Desarrollador Backend | 1 | $4.500.000 | 100% | 2 | 3 | 3 | 0 | $12.000.000 |
| Desarrollador Frontend | 1 | $5.000.000 | 100% | 0 | 3 | 5 | 1 | $15.000.000 |
| Tester | 1 | $2.000.000 | 100% | 2 | 2 | 5 | 2 | $7.333.333 |

| Concepto | Valor |
|---|---|
| **Subtotal** | $55.500.000 |
| Imprevisto (10%) | $5.550.000 |
| Subtotal + Imprevisto | $61.050.000 |
| **Precio Final (12%)** | **$68.376.000** |

---

### 3b(vi). Atributos de Calidad

| Atributo | Descripción |
|---|---|
| **Usabilidad** | Interfaz intuitiva para usuarios con bajo nivel tecnológico. |
| **Disponibilidad y Conectividad** | Funcionamiento offline y sincronización automática obligatoria. |
| **Rendimiento** | Respuesta a acciones del usuario en menos de 3 segundos. |
| **Seguridad** | Control de acceso por roles e integridad de datos almacenados. |
| **Compatibilidad y Portabilidad** | Soporte para dispositivos de gama media/baja y multiplataforma (móvil/escritorio). |
| **Resiliencia y Escalabilidad** | Recuperación ante fallos y soporte para múltiples fincas. |
| **Mantenibilidad** | Actualizaciones sin afectar la operación. |
| **Eficiencia** | Minimizar el consumo de recursos del dispositivo móvil. |

---

### 3b(vii). Análisis de las Restricciones

| ID | Restricción | Tipo | Decisión Arquitectónica | Evidencia en Implementación | Resultado |
|---|---|---|---|---|---|
| RT-01 | Conectividad intermitente | Técnica | Modo offline con almacenamiento local (SQLite/Room) y sincronización diferida mediante colas | Funcionalidad operativa sin internet, sincronización al recuperar conexión | ✅ Cumple |
| RT-02 | Uso en móviles de gama baja | Técnica | Aplicación Android ligera (<20MB), optimización de recursos, UI simple | APK optimizada, pruebas en dispositivos de bajos recursos | ✅ Cumple |
| RT-03 | Infraestructura de bajo costo | Técnica/Económica | Uso de servicios serverless (Firebase / backend ligero) y planes gratuitos | Costos estimados < $200.000 COP/mes documentados | ✅ Cumple |
| RT-04 | Sin soporte técnico en campo | Técnica | Sistema autogestionable, manejo de errores claro, actualizaciones automáticas | Mensajes de error comprensibles, logs básicos, actualizaciones OTA | ✅ Cumple |
| RE-01 | Presupuesto limitado | Económica | Arquitectura optimizada en costos, uso de servicios gratuitos | Documento de costos y arquitectura cloud | ✅ Cumple |
| RE-02 | Equipo de 5 integrantes | Económica | Arquitectura simple (monolito modular o cliente-servidor), tecnologías conocidas | Organización del código y distribución de responsabilidades | ✅ Cumple |
| RE-03 | Tiempo máximo (4 meses) | Temporal | Desarrollo incremental (MVP), priorización de funcionalidades críticas | Cronograma ágil, backlog priorizado | ✅ Cumple |
| RA-01 | Uso eficiente de recursos | Ambiental | Motor de recomendaciones optimizado para riego y fertilización | Lógica implementada en recomendaciones del sistema | ✅ Cumple |
| RA-02 | Minimizar impacto ambiental | Ambiental | Validación de recomendaciones para evitar sobreuso de insumos | Reglas de negocio implementadas | ✅ Cumple |
| RS-01 | Lenguaje claro | Social | Interfaz con lenguaje simple, iconografía y mensajes comprensibles | Mockups y pruebas de usabilidad | ✅ Cumple |
| RS-02 | Baja alfabetización digital | Social | Flujos simples, navegación guiada, ayuda contextual | Pruebas de usuario, prototipo funcional | ✅ Cumple |
| RS-03 | Adaptación al contexto del Magdalena | Social | Inclusión de cultivos locales y calendario agrícola regional | Base de datos con cultivos del Magdalena | ✅ Cumple |
| RN-01 | Ley 1581 de 2012 | Legal | Consentimiento de datos, cifrado y gestión de privacidad | Formularios de consentimiento, políticas de datos | ✅ Cumple |
| RN-02 | Confidencialidad de datos | Legal | Control de acceso y anonimización de datos | Implementación de roles y protección de datos | ✅ Cumple |
| RN-03 | Seguridad de la información | Legal | Uso de HTTPS, hash de contraseñas (bcrypt), backups | Configuración de seguridad y pruebas | ✅ Cumple |
| RSS-01 | Seguridad en recomendaciones | Salud/Seguridad | Validación de recomendaciones agrícolas | Reglas verificadas por criterios agronómicos | ✅ Cumple |
| RSS-02 | Trazabilidad | Salud/Seguridad | Registro de acciones y decisiones del usuario | Logs de actividad y almacenamiento histórico | ✅ Cumple |
| REt-01 | Apoyo a la decisión | Ética | Diseño del sistema como asistente, no automatización total | Mensajes que indican recomendación, no imposición | ✅ Cumple |
| REt-02 | Uso responsable de datos | Ética | Restricción de uso de datos solo para el sistema | Políticas de uso implementadas | ✅ Cumple |