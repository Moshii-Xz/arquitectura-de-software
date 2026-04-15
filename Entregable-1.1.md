# ASIGNATURA: Arquitectura de Software - 4 créditos

**DOCENTE:** Carlos Nelson Henrique Miranda

## Plataforma Digital de Agricultura Inteligente para Pequeños Productores del Magdalena

**PRESENTADO POR:**
- 2019214057 - Miguel Olaya Cadena
- 2015114002 - Luis Mateus
- 2021114055 - Juan Mosquera
- 2021214058 - Mauricio Saballeth

**FACULTAD DE INGENIERIA**

**SANTA MARTA**

2026-1

## 1. IDENTIFICACIÓN DEL PROYECTO

| Campo | Descripción |
|-------|-------------|
| Título del Proyecto | Plataforma Digital de Agricultura Inteligente para Pequeños Productores del Magdalena |
| Duración | 20 semanas |
| Modalidad | Trabajo en equipo — 4 Integrantes |

## 2. DESCRIPCIÓN DEL PROBLEMA DE INGENIERÍA

En el departamento del Magdalena, los pequeños productores agrícolas enfrentan desafíos críticos en la optimización de sus recursos. Los pequeños productores del departamento del Magdalena enfrentan dificultades para gestionar eficientemente el riego y la aplicación de insumos, debido a la falta de herramientas digitales adaptadas a su contexto.

Asimismo, la aplicación de fertilizantes con abono e insecticidas para el control de pestes se realiza de manera empírica, sin una base de datos histórica o climática que valide el momento óptimo de aplicación. Esto incrementa los costos de producción y el impacto ambiental por el posible sobreuso de químicos. El problema radica en la falta de una herramienta digital que permita al productor monitorear estas variables bajo condiciones de conectividad intermitente y dispositivos, integrando recomendaciones que respeten el criterio humano del agricultor.

Los pequeños productores del Magdalena dependen de decisiones empíricas debido a la variabilidad climática y falta de herramientas digitales. Esto genera:

- Consumo ineficiente de agua y altos costos de insumos.
- Riesgo elevado de pérdida de cosechas.
- Impacto ambiental negativo por sobreuso de fertilizantes.

## 3. PROCESO DE DISEÑO DE INGENIERÍA

### 3a. Condiciones de Desarrollo

A continuación se justifica la selección de tecnologías y herramientas que guiarán el desarrollo del proyecto:

| Proceso/Herramienta | Justificación |
|---------------------|----------------|
| Base de Datos | PostgreSQL. Ofrece robustez para el manejo de datos históricos climáticos y de cultivos, siendo una opción de bajo costo y alta fiabilidad. |
| Lenguaje de Programación | Java. Se selecciona Java por su madurez, soporte empresarial y compatibilidad con Spring Boot. |
| Framework Backend | Spring Boot. Facilita la creación de servicios web escalables, seguros y mantenibles para el procesamiento de alertas, cultivos y recomendaciones. |
| Framework Frontend | React JS. Permite desarrollar una interfaz web responsiva, ligera y fácil de evolucionar. |

### 3b(i). Contexto del Problema

El sistema operará en el departamento del Magdalena, Colombia, en zonas rurales con conectividad intermitente y usuarios con bajo nivel de alfabetización digital. Para esta fase del curso el alcance se concentra en una aplicación web responsiva, accesible desde navegador y preparada para evolucionar luego hacia una solución móvil. La solución debe adaptarse a estas condiciones para ser técnicamente viable, de bajo costo y socialmente adoptada por los productores.

### 3b(ii). Identificación de stakeholders

- Productores agrícolas
- Operarios de campo
- Asociaciones agrícolas del Magdalena
- Compradores y comercializadores
- Entidades regulatorias (ICA, MinAgricultura)
- Proveedores de datos climáticos (IDEAM)
- Consumidores finales
- Equipo de desarrollo

### 3b(iii). Diagramas de casos de uso

**Caso uso nivel 0:**

*(Espacio para diagrama)*

**GESTIONAR CULTIVOS:**

*(Espacio para diagrama)*

**GESTIONAR USUARIOS:**

*(Espacio para diagrama)*

**GESTIONAR INSUMOS AGRICOLAS:**

*(Espacio para diagrama)*

### 3b(iv). Especificación de requerimientos (ISO/IEC/IEEE 29148:2018)

#### REQUERIMIENTOS FUNCIONALES (RF)

Los requerimientos funcionales se ajustan al alcance actual de aplicación web. La evolución a app móvil y sincronización offline quedará como fase posterior.

**Autenticación y acceso**

- **RF-01:** El sistema debe permitir autenticación de usuarios mediante correo o usuario y contraseña.
- **RF-02:** El sistema debe permitir cerrar sesión de forma segura desde cualquier pantalla.
- **RF-03:** El sistema debe permitir recuperar la contraseña mediante un código de verificación enviado al correo registrado.
- **RF-04:** El sistema debe permitir cambiar la contraseña ingresando la contraseña actual y confirmando la nueva.
- **RF-05:** El sistema debe bloquear temporalmente una cuenta después de múltiples intentos fallidos de inicio de sesión.
- **RF-06:** El sistema debe gestionar roles y permisos para restringir el acceso a funcionalidades.
- **RF-07:** El sistema debe mantener la sesión activa por un tiempo limitado y solicitar reautenticación al expirar.
- **RF-08:** El sistema debe registrar la actividad de acceso y cierre de sesión de los usuarios.

**Usuarios y perfil**

- **RF-09:** El sistema debe permitir crear y completar el perfil con información personal y productiva.
- **RF-10:** El sistema debe mostrar toda la información del perfil en una sola pantalla.
- **RF-11:** El sistema debe permitir editar la información del perfil, excepto el correo electrónico.
- **RF-12:** El sistema debe permitir cargar una foto de perfil en formatos permitidos.
- **RF-13:** El sistema debe permitir registrar la ubicación geográfica mediante coordenadas o mapa.
- **RF-14:** El sistema debe permitir configurar el idioma de la interfaz.
- **RF-15:** El sistema debe permitir configurar las preferencias de notificación.
- **RF-16:** El sistema debe permitir crear cuentas de usuario con datos básicos y rol asignado.
- **RF-17:** El sistema debe mostrar la lista de usuarios registrados.
- **RF-18:** El sistema debe permitir editar la información de los usuarios.
- **RF-19:** El sistema debe permitir desactivar cuentas sin eliminar datos.
- **RF-20:** El sistema debe permitir reactivar cuentas desactivadas.
- **RF-21:** El sistema debe mostrar la actividad reciente de los usuarios.

**Cultivos**

- **RF-22:** El sistema debe permitir registrar un cultivo con sus datos principales.
- **RF-23:** El sistema debe mostrar la lista de cultivos activos ordenados por fecha.
- **RF-24:** El sistema debe mostrar el detalle completo de un cultivo.
- **RF-25:** El sistema debe permitir editar un cultivo mientras no esté finalizado.
- **RF-26:** El sistema debe permitir actualizar el estado de un cultivo registrando la fecha del cambio.
- **RF-27:** El sistema debe permitir eliminar un cultivo solicitando confirmación y conservando el historial.
- **RF-28:** El sistema debe permitir adjuntar múltiples fotografías a un cultivo.
- **RF-29:** El sistema debe permitir registrar observaciones asociadas a un cultivo.
- **RF-30:** El sistema debe permitir buscar y filtrar cultivos por diferentes criterios.

**Insumos**

- **RF-31:** El sistema debe permitir registrar la aplicación de un insumo a un cultivo.
- **RF-32:** El sistema debe mostrar el historial de insumos aplicados a un cultivo.
- **RF-33:** El sistema debe permitir editar un registro de insumo dentro de un tiempo limitado.
- **RF-34:** El sistema debe permitir eliminar un registro de insumo con confirmación.
- **RF-35:** El sistema debe calcular el costo total de insumos por cultivo.
- **RF-36:** El sistema debe generar alertas cuando se registre un insumo de alto impacto ambiental.
- **RF-37:** El sistema debe gestionar un catálogo de insumos disponible para consulta.

**Clima, alertas y recomendaciones**

- **RF-38:** El sistema debe integrar datos desde un servicio climático externo.
- **RF-39:** El sistema debe generar alertas cuando la temperatura supere umbrales definidos.
- **RF-40:** El sistema debe generar alertas por niveles de lluvia extremos.
- **RF-41:** El sistema debe generar alertas por condiciones de sequía.
- **RF-42:** El sistema debe mostrar el historial de alertas climáticas.
- **RF-43:** El sistema debe permitir marcar alertas como leídas.
- **RF-44:** El sistema debe permitir configurar umbrales de alerta.
- **RF-45:** El sistema debe mostrar un mapa o panel de condiciones climáticas.
- **RF-46:** El sistema debe generar recomendaciones de riego basadas en condiciones climáticas.
- **RF-47:** El sistema debe generar recomendaciones de fertilización según el ciclo del cultivo.
- **RF-48:** El sistema debe generar recomendaciones fitosanitarias.
- **RF-49:** El sistema debe mostrar las recomendaciones activas ordenadas por prioridad.
- **RF-50:** El sistema debe mostrar el detalle y justificación de cada recomendación.
- **RF-51:** El sistema debe permitir marcar recomendaciones como atendidas.
- **RF-52:** El sistema debe permitir descartar recomendaciones manteniendo el historial.
- **RF-53:** El sistema debe mostrar el historial de recomendaciones.

**Reportes y notificaciones**

- **RF-54:** El sistema debe generar reportes del estado de los cultivos.
- **RF-55:** El sistema debe generar reportes de consumo de insumos.
- **RF-56:** El sistema debe generar reportes de alertas recibidas.
- **RF-57:** El sistema debe permitir exportar reportes en formato PDF.
- **RF-58:** El sistema debe permitir filtrar reportes por período de tiempo.
- **RF-59:** El sistema debe generar reportes comparativos entre cultivos.
- **RF-60:** El sistema debe enviar notificaciones internas de alertas climáticas.
- **RF-61:** El sistema debe enviar notificaciones internas de nuevas recomendaciones.
- **RF-62:** El sistema debe mostrar un contador de notificaciones no leídas.

#### REQUERIMIENTOS NO FUNCIONALES (RNF)

Los requerimientos no funcionales se enfocan en desempeño web, seguridad, continuidad operativa y compatibilidad con navegadores modernos.

- **RNF-01:** El sistema debe responder a las solicitudes frecuentes en menos de 3 segundos en condiciones de red 3G o equivalente.
- **RNF-02:** El sistema debe cargar la pantalla principal en menos de 5 segundos en dispositivos de gama baja o media.
- **RNF-03:** El sistema debe procesar y publicar alertas climáticas en menos de 60 segundos desde la recepción de datos.
- **RNF-04:** El sistema debe generar reportes en menos de 10 segundos para períodos de hasta 6 meses.
- **RNF-05:** El sistema debe exportar reportes en PDF en menos de 15 segundos en condiciones de red estable.
- **RNF-06:** El sistema debe garantizar una disponibilidad mínima del 95% mensual.
- **RNF-07:** El sistema debe continuar operando sus funciones principales ante la caída del servicio climático externo.
- **RNF-08:** El sistema debe recuperarse de fallos no planificados en menos de 30 minutos sin pérdida de datos recientes.
- **RNF-09:** El sistema debe realizar copias de seguridad automáticas cada 24 horas.
- **RNF-10:** El sistema debe contar con monitoreo que detecte y notifique caídas del servicio en pocos minutos.
- **RNF-11:** El sistema debe cifrar todas las comunicaciones mediante HTTPS con protocolos seguros.
- **RNF-12:** El sistema debe cifrar los datos sensibles almacenados en la base de datos.
- **RNF-13:** El sistema debe almacenar contraseñas utilizando algoritmos de hash seguros.
- **RNF-14:** El sistema debe controlar el acceso a funcionalidades según los permisos asignados.
- **RNF-15:** El sistema debe impedir el acceso a datos de otros usuarios.
- **RNF-16:** El sistema debe cumplir con las normativas de protección de datos personales aplicables.
- **RNF-17:** El sistema debe solicitar el consentimiento del usuario para el uso de sus datos.
- **RNF-18:** El sistema debe garantizar la confidencialidad de los datos productivos.
- **RNF-19:** El sistema debe indicar que las recomendaciones son de apoyo y no sustituyen criterio profesional.
- **RNF-20:** El sistema debe garantizar trazabilidad de recomendaciones y acciones del usuario.
- **RNF-21:** El sistema debe ofrecer compatibilidad con los navegadores modernos más utilizados.
- **RNF-22:** El sistema debe presentar un diseño responsivo adaptable a escritorio, tableta y navegador móvil.
- **RNF-23:** El sistema debe funcionar sin requerir instalación adicional de software.
- **RNF-24:** El sistema debe operar correctamente en equipos de gama baja con recursos limitados.
- **RNF-25:** El sistema debe permitir la migración de la base de datos sin pérdida de información.
- **RNF-26:** El sistema debe mantener un código modular y mantenible para facilitar futuras evoluciones, incluida la versión móvil.
- **RNF-27:** El sistema debe registrar eventos y errores relevantes para soporte y auditoría.
- **RNF-28:** El sistema debe promover recomendaciones ambientalmente responsables.

### 3b(v). Plan, cronograma y presupuesto de desarrollo

#### Roles del Equipo

- **Arquitecto de Software / Líder Técnico (Juan Mosquera):** Responsable de decisiones arquitectónicas y coherencia del sistema.
- **Analista de Requisitos (Juan Mosquera):** Encargado de la especificación de requerimientos y validación con el contexto del problema.
- **Desarrollador Backend (Mauricio Saballeth):** Implementación de lógica de negocio, servicios web y persistencia de datos con Spring Boot.
- **Desarrollador Frontend Web (Miguel Olaya):** Desarrollo de la aplicación web responsiva optimizada para usuarios finales.
- **Responsable de Calidad y Validación (Luis Mateus Ramirez):** Pruebas, validación de atributos de calidad y cumplimiento de restricciones.

#### Mecanismos de Comunicación

- Reuniones semanales (Teams meetings)
- Uso de herramientas como:
  - Microsoft Teams (comunicación rápida)
  - Trello / Jira (gestión de tareas)
  - GitHub (control de versiones)

#### Coordinación

- Uso de backlog priorizado
- Asignación de tareas por sprint
- Seguimiento de avances semanal

#### Plan con costos y tiempo

**Duración:** 4 meses

| Fase | RUP | Integrantes | Cantidad | Salario Mensual | Disponibilidad | Inicio | Elaboración | Construcción | Despliegue | Total |
|------|-----|-------------|----------|----------------|----------------|--------|--------------|--------------|------------|-------|
| Analista de requisitos | - | - | 1 | $6.000.000,00 | 50% | 2 | 3 | 5 | 2 | - |
| Arq. de Software | - | - | 1 | $5.000.000,00 | 50% | 2 | 3 | 5 | 1 | - |
| Desarrollador Backend | - | - | 1 | $4.500.000,00 | 100% | 2 | 3 | 3 | 0 | - |
| Desarrollador Frontend | - | - | 1 | $5.000.000,00 | 100% | 0 | 3 | 5 | 1 | - |
| Tester | - | - | 1 | $2.000.000,00 | 100% | 2 | 2 | 5 | 2 | - |

| Concepto | Monto |
|----------|-------|
| **Total** | **$55.500.000,00** |
| Imprevisto 10% | $5.550.000,00 |
| **Subtotal** | **$61.050.000,00** |
| Precio (12%) | **$68.376.000,00** |

*1 iteración = 10 días*

### 3b(vi). Atributos de calidad para evaluar la solución

- **Usabilidad:** Interfaz intuitiva para usuarios con bajo nivel tecnológico.
- **Disponibilidad y Conectividad:** Funcionamiento web estable con tolerancia a conectividad intermitente y degradación controlada.
- **Rendimiento:** Respuesta a acciones del usuario en menos de 3 segundos.
- **Seguridad:** Control de acceso por roles e integridad de datos almacenados.
- **Compatibilidad y Portabilidad:** Soporte para navegadores modernos en escritorio y dispositivo móvil mediante diseño responsivo.
- **Resiliencia y Escalabilidad:** Recuperación ante fallos y soporte para múltiples fincas.
- **Mantenibilidad:** Actualizaciones sin afectar la operación.
- **Eficiencia:** Minimizar el consumo de recursos del navegador y del servidor.

### 3b(vii). Análisis de restricciones

| Restricción | Tipo | Decisión Arquitectónica Asociada | Evidencia en Implementación | Resultado |
|-------------|------|----------------------------------|----------------------------|-----------|
| RT-01: Conectividad intermitente | Técnica | Aplicación web con caché de lectura, manejo de errores claros y reintento de operaciones | La interfaz mantiene funciones clave y alerta al usuario cuando la red es inestable | Cumple |
| RT-02: Uso en equipos de gama baja | Técnica | Frontend web ligero, componentes simples y consumo moderado de recursos | Pruebas en navegadores de equipos básicos | Cumple |
| RT-03: Infraestructura de bajo costo | Técnica/Económica | Backend en Spring Boot desplegado en infraestructura económica y base de datos PostgreSQL | Costos estimados documentados y despliegue simplificado | Cumple |
| RT-04: Sin soporte técnico en campo | Técnica | Sistema autogestionable, manejo de errores claro y despliegue sencillo | Mensajes de error comprensibles, logs básicos y recuperación operativa | Cumple |
| RE-01: Presupuesto limitado | Económica | Arquitectura optimizada en costos, uso de tecnologías conocidas | Documento de costos y arquitectura web | Cumple |
| RE-02: Equipo de 5 integrantes | Económica | Arquitectura simple por capas con responsabilidades claras | Organización del código y distribución de responsabilidades | Cumple |
| RE-03: Tiempo máximo (4 meses) | Temporal | Desarrollo incremental (MVP), priorización de funcionalidades críticas | Cronograma ágil, backlog priorizado | Cumple |
| RA-01: Uso eficiente de recursos | Ambiental | Motor de recomendaciones optimizado para riego y fertilización | Lógica implementada en recomendaciones del sistema | Cumple |
| RA-02: Minimizar impacto ambiental | Ambiental | Validación de recomendaciones para evitar sobreuso de insumos | Reglas de negocio implementadas | Cumple |
| RS-01: Lenguaje claro | Social | Interfaz con lenguaje simple, iconografía y mensajes comprensibles | Mockups y pruebas de usabilidad | Cumple |
| RS-02: Baja alfabetización digital | Social | Flujos simples, navegación guiada, ayuda contextual | Pruebas de usuario, prototipo funcional | Cumple |
| RS-03: Adaptación al contexto del Magdalena | Social | Inclusión de cultivos locales y calendario agrícola regional | Base de datos con cultivos del Magdalena | Cumple |
| RN-01: Ley 1581 de 2012 | Legal | Consentimiento de datos, cifrado y gestión de privacidad | Formularios de consentimiento, políticas de datos | Cumple |
| RN-02: Confidencialidad de datos | Legal | Control de acceso y anonimización de datos | Implementación de roles y protección de datos | Cumple |
| RN-03: Seguridad de la información | Legal | Uso de HTTPS, hash de contraseñas (bcrypt), backups | Configuración de seguridad y pruebas | Cumple |
| RSS-01: Seguridad en recomendaciones | Salud/Seguridad | Validación de recomendaciones agrícolas | Reglas verificadas por criterios agronómicos | Cumple |
| RSS-02: Trazabilidad | Salud/Seguridad | Registro de acciones y decisiones del usuario | Logs de actividad y almacenamiento histórico | Cumple |
| RET-01: Apoyo a la decisión | Ética | Diseño del sistema como asistente, no automatización total | Mensajes que indican recomendación, no imposición | Cumple |
| RET-02: Uso responsable de datos | Ética | Restricción de uso de datos solo para el sistema | Políticas de uso implementadas | Cumple |