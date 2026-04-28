# Requisitos Funcionales del Sistema

Este documento mantiene la misma estructura de especificacion por modulos y fichas RF, alineada con el listado final definido en Entregable-3 (RF-01 a RF-56).

## 1. Modulo de Gestion de Acceso y Perfil

### RF-01: Autenticacion de usuarios
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir la autenticacion de usuarios mediante usuario y contrasena antes de acceder a cualquier funcionalidad.
- **Entradas:** Usuario y contrasena.
- **Salidas:** Acceso autorizado o rechazo de acceso.
- **Criterios de aceptacion:**
  - El acceso a funcionalidades requiere autenticacion previa.

### RF-02: Cierre seguro de sesion
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir cerrar la sesion de forma segura desde cualquier pantalla.
- **Entradas:** Solicitud de cierre de sesion.
- **Salidas:** Sesion cerrada y credenciales invalidadas.
- **Criterios de aceptacion:**
  - El usuario puede cerrar sesion en cualquier vista activa.

### RF-03: Recuperacion de contrasena por codigo
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir recuperar la contrasena mediante un codigo de verificacion enviado al correo registrado.
- **Entradas:** Correo registrado y codigo de verificacion.
- **Salidas:** Restablecimiento de contrasena.
- **Criterios de aceptacion:**
  - Solo se permite el cambio con codigo valido.

### RF-04: Cambio de contrasena
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir cambiar la contrasena ingresando la contrasena actual y confirmando la nueva.
- **Entradas:** Contrasena actual, nueva contrasena y confirmacion.
- **Salidas:** Contrasena actualizada.
- **Criterios de aceptacion:**
  - Se valida coincidencia de confirmacion y contrasena actual.

### RF-05: Bloqueo por intentos fallidos
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe bloquear temporalmente una cuenta despues de multiples intentos fallidos de inicio de sesion.
- **Entradas:** Intentos de autenticacion fallidos.
- **Salidas:** Cuenta bloqueada temporalmente.
- **Criterios de aceptacion:**
  - El bloqueo se activa automaticamente al superar el umbral configurado.

### RF-06: Roles y permisos
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe gestionar roles y permisos para restringir el acceso a funcionalidades.
- **Entradas:** Rol del usuario y reglas de autorizacion.
- **Salidas:** Acceso permitido o denegado por funcionalidad.
- **Criterios de aceptacion:**
  - Cada accion respeta permisos segun rol asignado.

### RF-07: Vigencia de sesion y reautenticacion
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe mantener la sesion activa por un tiempo limitado y solicitar reautenticacion al expirar.
- **Entradas:** Tiempo de actividad/inactividad de sesion.
- **Salidas:** Sesion renovada o reautenticacion requerida.
- **Criterios de aceptacion:**
  - La expiracion de sesion exige autenticacion nuevamente.

### RF-08: Creacion y completitud de perfil
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir crear y completar el perfil con informacion personal y productiva.
- **Entradas:** Datos de perfil personal y productivo.
- **Salidas:** Perfil creado o actualizado.
- **Criterios de aceptacion:**
  - El perfil puede registrarse de forma completa y persistente.

### RF-09: Visualizacion integral del perfil
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe mostrar toda la informacion del perfil en una sola pantalla.
- **Entradas:** Solicitud de consulta de perfil.
- **Salidas:** Vista consolidada del perfil.
- **Criterios de aceptacion:**
  - La informacion se presenta de forma unificada.

### RF-10: Edicion de perfil (excepto correo)
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir editar la informacion del perfil, excepto el correo electronico.
- **Entradas:** Datos editables del perfil.
- **Salidas:** Perfil actualizado sin modificar correo.
- **Criterios de aceptacion:**
  - El correo se mantiene no editable.

### RF-11: Carga de foto de perfil
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir cargar una foto de perfil en formatos permitidos.
- **Entradas:** Archivo de imagen valido.
- **Salidas:** Foto de perfil almacenada y asociada.
- **Criterios de aceptacion:**
  - Se aceptan solo formatos configurados como validos.

### RF-12: Registro de ubicacion geografica
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir registrar la ubicacion geografica mediante coordenadas o mapa.
- **Entradas:** Coordenadas o seleccion en mapa.
- **Salidas:** Ubicacion persistida en perfil.
- **Criterios de aceptacion:**
  - El sistema admite captura por ambas modalidades.

### RF-13: Configuracion de idioma
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir configurar el idioma de la interfaz.
- **Entradas:** Idioma seleccionado por el usuario.
- **Salidas:** Interfaz presentada en idioma configurado.
- **Criterios de aceptacion:**
  - El cambio de idioma se refleja en la interfaz.

### RF-14: Preferencias de notificacion
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir configurar las preferencias de notificacion.
- **Entradas:** Parametros de preferencia de notificaciones.
- **Salidas:** Preferencias guardadas por usuario.
- **Criterios de aceptacion:**
  - Las notificaciones respetan preferencias configuradas.

---

## 2. Modulo de Gestion de Cultivos

### RF-15: Registro de cultivo
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir registrar un cultivo con sus datos principales.
- **Entradas:** Datos principales del cultivo.
- **Salidas:** Cultivo creado.
- **Criterios de aceptacion:**
  - El cultivo queda asociado al usuario correspondiente.

### RF-16: Listado de cultivos activos
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe mostrar la lista de cultivos activos ordenados por fecha.
- **Entradas:** Solicitud de consulta de cultivos activos.
- **Salidas:** Listado ordenado por fecha.
- **Criterios de aceptacion:**
  - Solo se muestran cultivos activos y en orden temporal.

### RF-17: Detalle de cultivo
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe mostrar el detalle completo de un cultivo.
- **Entradas:** Identificador de cultivo.
- **Salidas:** Vista detallada del cultivo.
- **Criterios de aceptacion:**
  - Se presenta informacion completa del cultivo seleccionado.

### RF-18: Edicion de cultivo no finalizado
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir editar un cultivo mientras no este finalizado.
- **Entradas:** Datos a editar y estado del cultivo.
- **Salidas:** Cultivo actualizado o restriccion de edicion.
- **Criterios de aceptacion:**
  - No se permite editar cultivos finalizados.

### RF-19: Actualizacion de estado de cultivo
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir actualizar el estado de un cultivo registrando la fecha del cambio.
- **Entradas:** Nuevo estado y fecha de cambio.
- **Salidas:** Estado actualizado con trazabilidad temporal.
- **Criterios de aceptacion:**
  - Cada cambio de estado registra fecha asociada.

### RF-20: Eliminacion de cultivo con confirmacion
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir eliminar un cultivo solicitando confirmacion y conservando el historial.
- **Entradas:** Solicitud de eliminacion y confirmacion.
- **Salidas:** Cultivo eliminado logica o funcionalmente y historial conservado.
- **Criterios de aceptacion:**
  - La eliminacion requiere confirmacion explicita.

### RF-21: Adjuntar fotos a cultivo
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir adjuntar multiples fotografias a un cultivo.
- **Entradas:** Archivos de imagen y cultivo destino.
- **Salidas:** Fotografias asociadas al cultivo.
- **Criterios de aceptacion:**
  - Se permite adjuntar mas de una fotografia.

### RF-22: Registrar observaciones de cultivo
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir registrar observaciones asociadas a un cultivo.
- **Entradas:** Texto de observacion y cultivo objetivo.
- **Salidas:** Observacion almacenada.
- **Criterios de aceptacion:**
  - Las observaciones quedan vinculadas al cultivo.

### RF-23: Busqueda y filtros de cultivos
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir buscar y filtrar cultivos por diferentes criterios.
- **Entradas:** Criterios de busqueda y filtro.
- **Salidas:** Resultados filtrados.
- **Criterios de aceptacion:**
  - Los filtros aplican correctamente sobre el listado.

---

## 3. Modulo de Gestion de Insumos

### RF-24: Registrar aplicacion de insumo
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir registrar la aplicacion de un insumo a un cultivo.
- **Entradas:** Cultivo, insumo, cantidad y fecha.
- **Salidas:** Registro de aplicacion almacenado.
- **Criterios de aceptacion:**
  - Cada aplicacion queda asociada al cultivo y al insumo.

### RF-25: Historial de insumos aplicados
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe mostrar el historial de insumos aplicados a un cultivo.
- **Entradas:** Identificador de cultivo.
- **Salidas:** Historial de aplicaciones de insumo.
- **Criterios de aceptacion:**
  - La consulta retorna el historial completo del cultivo.

### RF-26: Edicion de registro de insumo en ventana limitada
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir editar un registro de insumo dentro de un tiempo limitado.
- **Entradas:** Registro de insumo y cambios solicitados.
- **Salidas:** Registro actualizado o bloqueo de edicion.
- **Criterios de aceptacion:**
  - Fuera de la ventana permitida no se autoriza la edicion.

### RF-27: Eliminacion de registro de insumo
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir eliminar un registro de insumo con confirmacion.
- **Entradas:** Solicitud de eliminacion y confirmacion.
- **Salidas:** Registro de insumo eliminado.
- **Criterios de aceptacion:**
  - Se exige confirmacion previa para eliminar.

### RF-28: Calculo de costo total de insumos
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe calcular el costo total de insumos por cultivo.
- **Entradas:** Registros de aplicacion y costos asociados.
- **Salidas:** Costo total consolidado por cultivo.
- **Criterios de aceptacion:**
  - El total corresponde a la suma de registros aplicables.

### RF-29: Alertas por insumo de alto impacto ambiental
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe generar alertas cuando se registre un insumo de alto impacto ambiental.
- **Entradas:** Registro de insumo con clasificacion ambiental.
- **Salidas:** Alerta generada.
- **Criterios de aceptacion:**
  - La alerta se dispara automaticamente al detectar alto impacto.

### RF-30: Catalogo de insumos
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe gestionar un catalogo de insumos disponible para consulta.
- **Entradas:** Datos del catalogo de insumos.
- **Salidas:** Catalogo actualizado y consultable.
- **Criterios de aceptacion:**
  - El catalogo permite consulta de insumos vigentes.

### RF-31: Recomendaciones de insumos
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe generar recomendaciones de insumos segun condiciones del cultivo.
- **Entradas:** Condiciones del cultivo y parametros agronomicos.
- **Salidas:** Recomendaciones de insumo.
- **Criterios de aceptacion:**
  - Las recomendaciones se basan en condiciones registradas.

---

## 4. Modulo de Recomendaciones

### RF-32: Recomendaciones de fertilizacion
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe generar recomendaciones de fertilizacion segun el ciclo del cultivo.
- **Entradas:** Ciclo del cultivo y variables relevantes.
- **Salidas:** Recomendaciones de fertilizacion.
- **Criterios de aceptacion:**
  - La recomendacion corresponde al ciclo vigente del cultivo.

### RF-33: Recomendaciones fitosanitarias
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe generar recomendaciones fitosanitarias.
- **Entradas:** Condiciones de riesgo fitosanitario.
- **Salidas:** Recomendaciones fitosanitarias emitidas.
- **Criterios de aceptacion:**
  - Se genera recomendacion cuando apliquen las condiciones.

### RF-34: Recomendaciones activas por prioridad
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe mostrar las recomendaciones activas ordenadas por prioridad.
- **Entradas:** Recomendaciones activas del usuario.
- **Salidas:** Listado ordenado por prioridad.
- **Criterios de aceptacion:**
  - El ordenamiento por prioridad es consistente.

### RF-35: Detalle y justificacion de recomendacion
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe mostrar el detalle y justificacion de cada recomendacion.
- **Entradas:** Identificador de recomendacion.
- **Salidas:** Vista detallada con justificacion.
- **Criterios de aceptacion:**
  - Toda recomendacion incluye su justificacion visible.

### RF-36: Marcar recomendacion como atendida
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir marcar recomendaciones como atendidas.
- **Entradas:** Accion de marcado sobre recomendacion.
- **Salidas:** Estado de recomendacion actualizado.
- **Criterios de aceptacion:**
  - El estado cambia a atendida y queda persistido.

### RF-37: Descartar recomendacion con historial
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir descartar recomendaciones manteniendo el historial.
- **Entradas:** Accion de descarte.
- **Salidas:** Recomendacion descartada y trazabilidad conservada.
- **Criterios de aceptacion:**
  - El descarte no elimina el registro historico.

### RF-38: Historial de recomendaciones
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe mostrar el historial de recomendaciones.
- **Entradas:** Solicitud de consulta historica.
- **Salidas:** Historial de recomendaciones.
- **Criterios de aceptacion:**
  - Se consultan recomendaciones activas y no activas.

---

## 5. Modulo de Reportes

### RF-39: Reporte de estado de cultivos
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe generar reportes del estado de los cultivos.
- **Entradas:** Datos de estado de cultivos y parametros de reporte.
- **Salidas:** Reporte generado.
- **Criterios de aceptacion:**
  - El reporte refleja informacion actualizada de estado.

### RF-40: Reporte de consumo de insumos
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe generar reportes de consumo de insumos.
- **Entradas:** Registros de consumo de insumos.
- **Salidas:** Reporte de consumo consolidado.
- **Criterios de aceptacion:**
  - El reporte consolida consumos por criterio seleccionado.

### RF-41: Reporte de alertas recibidas
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe generar reportes de alertas recibidas.
- **Entradas:** Historial de alertas.
- **Salidas:** Reporte de alertas.
- **Criterios de aceptacion:**
  - El reporte contiene alertas en el periodo consultado.

### RF-42: Exportacion de reportes en PDF
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir exportar reportes en formato PDF.
- **Entradas:** Reporte generado y accion de exportacion.
- **Salidas:** Archivo PDF descargable.
- **Criterios de aceptacion:**
  - El archivo se genera en formato PDF valido.

### RF-43: Filtro temporal de reportes
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir filtrar reportes por periodo de tiempo.
- **Entradas:** Rango de fechas u otro periodo.
- **Salidas:** Reportes filtrados temporalmente.
- **Criterios de aceptacion:**
  - Solo se muestran datos del periodo seleccionado.

### RF-44: Reportes comparativos entre cultivos
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe generar reportes comparativos entre cultivos.
- **Entradas:** Conjunto de cultivos a comparar.
- **Salidas:** Reporte comparativo.
- **Criterios de aceptacion:**
  - La comparacion presenta metricas homologas entre cultivos.

---

## 6. Modulo de Gestion de Usuarios (Backoffice)

### RF-45: Creacion de cuentas de usuario
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir crear cuentas de usuario con datos basicos y rol asignado.
- **Entradas:** Datos basicos del usuario y rol.
- **Salidas:** Cuenta de usuario creada.
- **Criterios de aceptacion:**
  - Cada cuenta se crea con rol asignado.

### RF-46: Listado de usuarios registrados
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe mostrar la lista de usuarios registrados.
- **Entradas:** Solicitud de consulta de usuarios.
- **Salidas:** Listado de usuarios.
- **Criterios de aceptacion:**
  - El listado muestra cuentas vigentes y su informacion base.

### RF-47: Edicion de informacion de usuarios
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir editar la informacion de los usuarios.
- **Entradas:** Datos de usuario a actualizar.
- **Salidas:** Usuario actualizado.
- **Criterios de aceptacion:**
  - Los cambios quedan persistidos y auditables.

### RF-48: Desactivacion de cuentas
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir desactivar cuentas sin eliminar datos.
- **Entradas:** Solicitud de desactivacion.
- **Salidas:** Cuenta desactivada.
- **Criterios de aceptacion:**
  - La desactivacion conserva integridad de datos historicos.

### RF-49: Reactivacion de cuentas
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir reactivar cuentas desactivadas.
- **Entradas:** Solicitud de reactivacion.
- **Salidas:** Cuenta reactivada.
- **Criterios de aceptacion:**
  - La cuenta recupera su estado operativo previo.

### RF-50: Actividad reciente de usuarios
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe mostrar la actividad reciente de los usuarios.
- **Entradas:** Solicitud de consulta de actividad.
- **Salidas:** Registro de actividad reciente.
- **Criterios de aceptacion:**
  - La actividad se presenta con informacion temporal verificable.

---

## 7. Modulo de Notificaciones y Sincronizacion Offline

### RF-51: Notificaciones internas de alertas climaticas
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe enviar notificaciones internas de alertas climaticas.
- **Entradas:** Evento de alerta climatica.
- **Salidas:** Notificacion interna emitida.
- **Criterios de aceptacion:**
  - La notificacion llega al usuario objetivo.

### RF-52: Notificaciones internas de recomendaciones
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe enviar notificaciones internas de nuevas recomendaciones.
- **Entradas:** Nueva recomendacion generada.
- **Salidas:** Notificacion interna emitida.
- **Criterios de aceptacion:**
  - La notificacion se registra en el centro de notificaciones.

### RF-53: Contador de no leidas
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe mostrar un contador de notificaciones no leidas.
- **Entradas:** Estado de lectura de notificaciones.
- **Salidas:** Indicador numerico de no leidas.
- **Criterios de aceptacion:**
  - El contador se actualiza al leer o recibir notificaciones.

### RF-54: Sincronizacion de notificaciones offline
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe sincronizar notificaciones generadas en modo offline.
- **Entradas:** Cola de notificaciones pendientes.
- **Salidas:** Notificaciones sincronizadas.
- **Criterios de aceptacion:**
  - Al recuperar conectividad se realiza sincronizacion automatica.

### RF-55: Historial de notificaciones
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe mostrar el historial de notificaciones.
- **Entradas:** Solicitud de consulta de historial.
- **Salidas:** Historial de notificaciones presentado.
- **Criterios de aceptacion:**
  - El historial conserva orden y trazabilidad de eventos.

### RF-56: Eliminacion de notificaciones
- **Prioridad:** Por definir
- **Descripcion:** El sistema debe permitir eliminar notificaciones.
- **Entradas:** Solicitud de eliminacion de notificacion.
- **Salidas:** Notificacion eliminada.
- **Criterios de aceptacion:**
  - La eliminacion actualiza el listado y contador correspondiente.

---

## 8. Matriz de Priorizacion de Requisitos (pendiente de definicion)

| ID | Requisito | Prioridad | MVP |
|----|-----------|-----------|-----|
| RF-01..RF-56 | Version final alineada de Entregable-3 | Por definir | Por definir |

**Total requisitos:** 56
**Fuente canonica:** Entregable-3, seccion "Listado de RF ya finales".
