# Wireframe - Plataforma Digital de Agricultura Inteligente (Versión Web)

## 1. Visión General

**Objetivo:** Proporcionar una interfaz web minimalista, intuitiva y visualmente atractiva para que productores, asociaciones y administradores gestionen cultivos, registren actividades, consulten alertas y generen reportes desde escritorio.

**Principios de diseño:**
- Minimalismo: solo lo necesario, sin adornos.
- Claridad: información jerárquica y fácil de escanear.
- Accesibilidad: contraste alto, botones grandes, textos legibles.
- Consistencia: patrones visuales repetibles en todas las pantallas.

---

## 2. Estructura General de la Interfaz

### 2.1 Layout Base
```
┌─────────────────────────────────────────────┐
│  HEADER: Logo + Título + User Menu          │
├──────────────────────────────────────────────┤
│  │                                           │
│  │  SIDEBAR VERTICAL                │  MAIN CONTENT AREA
│  │  Nav Items                        │  (Cambia según sección)
│  │  - Dashboard                      │
│  │  - Cultivos                       │
│  │  - Actividades                    │
│  │  - Alertas                        │
│  │  - Reportes                       │
│  │  - Sincronización                 │
│  │  - Admin (si aplica)              │
│  │  - Perfil                         │
│  │  - Estado de conexión             │
```

### 2.2 Paleta de Colores
- **Verde principal:** #2f7d57 (botones, navegación activa, elementos positivos)
- **Ocre/Dorado:** #d98c2b (alertas, elementos secundarios)
- **Gris oscuro:** #173024 (texto principal, bordes)
- **Gris claro:** #e8f5ee (fondos, separadores)
- **Blanco:** #ffffff (fondos de tarjetas y contenido)
- **Rojo suave:** #b86b18 (estado crítico, pero ligero)
- **Verde oscuro:** #1f4531 (fondos oscuros, contraste)

### 2.3 Tipografía
- **Primaria:** Sans-serif (Segoe UI, Trebuchet MS, Helvetica Neue)
- **Tamaños:** 
  - H1: 32px (títulos de página)
  - H2: 24px (títulos de sección)
  - H3: 18px (subtítulos)
  - Body: 14px (contenido)
  - Small: 12px (ayuda, etiquetas)

### 2.4 Espaciado
- Margin base: 24px
- Padding interno: 16px-24px
- Gap entre componentes: 12-18px
- Ancho máximo: 1440px

### 2.5 Componentes Base

#### Botones
- **Primario (verde):** fondo #2f7d57, texto blanco, padding 12px 24px, border-radius 8px
- **Secundario (blanco):** fondo blanco, borde #d8e0d8, texto gris, mismo padding
- **Peligro (rojo):** fondo #b86b18, texto blanco
- **Estados:** normal, hover (más oscuro), activo (más saturado), deshabilitado (gris)

#### Tarjetas
- Fondo: blanco
- Borde: 1px sólido #d8e0d8
- Sombra: leve (0 2px 8px rgba(0,0,0,0.08))
- Border-radius: 12px
- Padding: 16px-24px

#### Tablas
- Encabezado: fondo #e8f5ee, texto gris oscuro, bold
- Filas: alternadas (blanco y #f8faf7)
- Bordes: solo líneas horizontales sutiles
- Acciones: alineadas a la derecha (editar, eliminar, ver)

#### Formularios
- Etiqueta: arriba del campo, bold, color gris oscuro
- Input: borde 1px #d8e0d8, padding 10px 12px, border-radius 6px
- Focus: borde verde #2f7d57
- Validación: rojo suave para errores
- Ayuda: texto gris pequeño bajo el campo

#### Indicadores
- **Online:** punto verde + "En línea"
- **Offline:** punto gris + "Sin conexión"
- **Alerta:** punto ocre + "Revisar"
- **Crítico:** punto rojo + "Acción urgente"

---

## 3. Flujos Principales

### 3.1 Flujo de Productor
```
Inicio de sesión
    ↓
Dashboard (Resumen)
    ↓
Opciones: [Ver Cultivos] [Registrar Actividad] [Ver Alertas] [Descargar Reporte] [Sincronizar]
    ↓
Según elección → Cultivos → Actividades → Alertas → Reportes → Sincronización
```

### 3.2 Flujo de Administrador
```
Inicio de sesión
    ↓
Dashboard (Resumen de usuarios y datos)
    ↓
Opciones: [Gestionar Usuarios] [Catálogos] [Monitoreo] [Reportes Consolidados]
    ↓
Según elección → Usuario CRUD → Parámetros CRUD → Estado del sistema → Exportar reportes
```

### 3.3 Flujo de Registro de Actividad (Productor)
```
En Dashboard o sección Actividades → Botón "Registrar Actividad"
    ↓
Modal o nueva vista: Formulario con campos:
  - Tipo de actividad (dropdown)
  - Lote asociado (dropdown)
  - Fecha (input date, default hoy)
  - Hora (input time)
  - Descripción (textarea)
  - Observaciones (textarea opcional)
    ↓
Botón "Guardar"
    ↓
Confirmación exitosa → Vuelve a lista de actividades
```

---

## 4. Pantallas Específicas

### 4.1 PANTALLA: Dashboard (Inicio)

**Ubicación:** Primera pantalla después de login.

**Componentes:**

#### A. Header Superior
- Logo y nombre: "AgroInteligente"
- Títere: "Bienvenido, [Nombre]"
- Menú de usuario (ícono de perfil) → Perfil, Configuración, Cerrar sesión
- Indicador de sincronización (última fecha, estado)

#### B. Resumen Rápido (4 tarjetas en fila)
```
┌─────────────────┐ ┌─────────────────┐ ┌─────────────────┐ ┌─────────────────┐
│ 8 ha            │ │ 67%             │ │ 2 alertas       │ │ 15 min          │
│ Total cultivadas│ │ Salud general   │ │ por revisar     │ │ última sync      │
└─────────────────┘ └─────────────────┘ └─────────────────┘ └─────────────────┘
```

#### C. Sección: Cultivos Activos (mitad izquierda)
- Título: "Cultivos activos"
- Tabla pequeña o tarjetas:
  - Lote | Cultivo | Área | Estado | %Salud | Acciones
  - Ejemplo: "Lote 01 | Maíz | 2.5 ha | Activo | 67% | Ver detalles"
- Botón destacado: "+ Registrar cultivo"

#### D. Sección: Últimas Alertas (mitad derecha)
- Título: "Alertas recientes"
- Tarjetas con prioridad visual (color de fondo):
  - Alerta climática (ocre)
  - Recomendación riego (verde)
  - Estado offline (gris)
- Botón: "Ver todas las alertas"

#### E. Sección: Próximas Tareas (full width)
- Título: "Próximas actividades recomendadas"
- Timeline visual o lista:
  - Hoy 4:30 PM: Aplicar fertilizante
  - Mañana 7:00 AM: Riego manual
  - Próx. semana: Inspección fitosanitaria
- Botón: "Registrar actividad"

#### F. Footer
- Estado de sincronización: "Última sincronización: hoy 14:30"
- Botón de sincronización manual
- Conectividad: indicador con punto (verde online, gris offline)

---

### 4.2 PANTALLA: Gestión de Cultivos

**Ubicación:** Sección Cultivos en sidebar.

**Vista General:**
- Encabezado: "Gestión de cultivos"
- Filtros (horizontal):
  - Filtrar por estado: [Todos] [Activos] [Archivados]
  - Filtrar por tipo: [Todos] [Maíz] [Yuca] [Plátano] (según datos)
  - Búsqueda: "Buscar por nombre de lote..."
- Botón primario: "+ Registrar nuevo cultivo"

**Tabla de cultivos:**
```
Lote      │ Cultivo  │ Área  │ Ubicación   │ Estado  │ %Salud │ Última actividad │ Acciones
────────────────────────────────────────────────────────────────────────────────────────────
Lote 01   │ Maíz     │ 2.5   │ Sector A    │ Activo  │ 67%    │ Hoy 14:20       │ Ver | Editar
Lote 02   │ Yuca     │ 1.8   │ Sector B    │ Activo  │ 89%    │ Ayer 10:15      │ Ver | Editar
Lote 03   │ Plátano  │ 3.2   │ Sector C    │ Archiv. │ -      │ Hace 2 meses    │ Ver | Editar
```

**Detalle de Cultivo (Modal o nueva vista al hacer click):**
- Encabezado: Nombre cultivo, área, ubicación
- Tabs o secciones:
  - General: fecha de siembra, variedad, esperado de cosecha
  - Actividades: historial de actividades en este lote
  - Alertas: alertas vinculadas a este cultivo
  - Recomendaciones: sugerencias activas para este lote
- Botones: Editar, Registrar actividad, Descargar reporte

---

### 4.3 PANTALLA: Registro de Actividades

**Ubicación:** Sección Actividades en sidebar.

**Vista General:**
- Encabezado: "Registro de actividades"
- Filtros:
  - Filtrar por tipo: [Todos] [Riego] [Fertilización] [Fitosanitaria] [Otro]
  - Filtrar por lote: [Todos] [Lote 01] [Lote 02] [Lote 03]
  - Rango de fechas: "De [date] a [date]"
- Botón primario: "+ Registrar actividad"

**Tabla de actividades:**
```
Tipo              │ Lote      │ Fecha      │ Hora  │ Descripción              │ Estado     │ Acciones
────────────────────────────────────────────────────────────────────────────────────────────────────
Riego             │ Lote 01   │ 05-04-2026 │ 6:30  │ Riego manual matutino    │ Guardado   │ Ver | Editar
Fertilización     │ Lote 02   │ 05-04-2026 │ 14:00 │ Aplicación de NPK        │ Sincron.   │ Ver | Editar
Inspección        │ Lote 03   │ 04-04-2026 │ 10:45 │ Chequeo de plagas        │ Sincron.   │ Ver | Editar
Otro              │ Lote 01   │ 04-04-2026 │ 8:15  │ Verificación de cercos   │ Guardado   │ Ver | Editar
```

**Formulario: Registrar Actividad (Modal)**
```
┌──────────────────────────────────────────┐
│ Registrar activ…│ [X]                    │
├──────────────────────────────────────────┤
│ Tipo de actividad *                      │
│ [Seleccionar: Riego / Fertilización ...] │
│                                          │
│ Lote asociado *                          │
│ [Seleccionar: Lote 01 / Lote 02 ...]    │
│                                          │
│ Fecha *                                  │
│ [05/04/2026]                             │
│                                          │
│ Hora                                     │
│ [14:30]                                  │
│                                          │
│ Descripción *                            │
│ [Aplicar fertilizante NPK...]            │
│ (Máx. 200 caracteres)                   │
│                                          │
│ Observaciones                            │
│ [Lluvia esperada, riego ligero...]       │
│                                          │
│              [Cancelar] [Guardar]        │
└──────────────────────────────────────────┘
```

---

### 4.4 PANTALLA: Alertas y Recomendaciones

**Ubicación:** Sección Alertas en sidebar.

**Vista General:**
- Encabezado: "Alertas y recomendaciones"
- Tabs o radiobuttons:
  - [Todas] [Activas] [Resueltas]
- Filtro por tipo:
  - [Todas] [Climáticas] [Riego] [Fertilización] [Fitosanitaria]
- Ordenar por: [Prioridad] [Fecha]

**Alertas Activas (Tarjetas o lista):**

#### Alerta 1 (Crítica)
```
┌────────────────────────────────────────┐
│ 🔴 URGENTE                             │
│ Alerta climática                       │
├────────────────────────────────────────┤
│ Lluvia esperada en la tarde. Posponer  │
│ fertilización para evitar pérdida de   │
│ insumo. Recomendación: esperar hasta   │
│ mañana.                                │
│                                        │
│ Lote afectado: Lote 01 - Maíz         │
│ Fecha: 05-04-2026 @ 12:15            │
│                                        │
│            [Marcar como leída]         │
│            [Acción sugerida]           │
└────────────────────────────────────────┘
```

#### Alerta 2 (Acción)
```
┌────────────────────────────────────────┐
│ 🟠 ACCIÓN                              │
│ Recomendación de riego                 │
├────────────────────────────────────────┤
│ Aplicar riego ligero antes de las 7 AM │
│ en el lote 01 por aumento de temperat. │
│ Duración estimada: 30 minutos.         │
│                                        │
│ Lote: Lote 01 - Maíz                  │
│ Prioridad: Alta                        │
│                                        │
│       [Marcar como resuelta]           │
└────────────────────────────────────────┘
```

#### Alerta 3 (Sugerida)
```
┌────────────────────────────────────────┐
│ 🟡 SUGERIDA                            │
│ Recomendación fitosanitaria            │
├────────────────────────────────────────┤
│ Inspeccionar hojas jóvenes por signos  │
│ tempranos de plaga. Revisar parte      │
│ inferior de la hoja.                   │
│                                        │
│ Lote: Lote 02 - Yuca                  │
│ Prioridad: Media                       │
│                                        │
│        [Marcar como leída]             │
└────────────────────────────────────────┘
```

---

### 4.5 PANTALLA: Reportes de Producción

**Ubicación:** Sección Reportes en sidebar.

**Vista General:**
- Encabezado: "Reportes de producción"
- Filtros:
  - Período: [Este mes] [Trimestre] [Año] [Personalizado]
  - Lote: [Todos] [Lote 01] [Lote 02] [Lote 03]
- Botones:
  - Descargar PDF
  - Descargar CSV
  - Imprimir

**Secciones del reporte:**

#### Resumen General
```
Total de áreas cultivadas: 7.5 ha
Cultivos activos: 3
Actividades completadas este mes: 18
Alertas enfrentadas: 4
Alertas resueltas: 4
```

#### Gráfico 1: Evolución del cultivo (línea)
- Eje X: Semanas
- Eje Y: % Salud
- Línea verde con puntos para cada lote

#### Tabla: Actividades por tipo
```
Tipo          │ Cantidad│ Últim actividad
───────────────────────────────────────
Riego         │ 6      │ 05-04-2026
Fertilización │ 5      │ 04-04-2026
Fitosanitaria │ 3      │ 03-04-2026
Otro          │ 4      │ 05-04-2026
```

#### Tabla: Alertas y acciones
```
Alerta                    │ Lote   │ Fecha      │ Estado    │ Acción tomada
──────────────────────────────────────────────────────────────────────────
Lluvia esperada           │ L01    │ 05-04-2026 │ Resuelta  │ Posposición
Riego recomendado         │ L01    │ 05-04-2026 │ Resuelta  │ Completado
Inspección fitosanitaria  │ L02    │ 04-04-2026 │ Resuelta  │ Registro OK
Humedad crítica           │ L03    │ 03-04-2026 │ Resuelta  │ Riego urgente
```

#### Gráfico 2: Comparativa por lote
- Barras con % salud de cada lote
- Colores diferenciados

---

### 4.6 PANTALLA: Sincronización

**Ubicación:** Sección Sincronización en sidebar o parte del header.

**Estado General:**
```
┌────────────────────────────────────────┐
│ Estado de sincronización               │
├────────────────────────────────────────┤
│ Conectividad: 🟢 En línea              │
│ Última sincronización: Hoy 15:45       │
│                                        │
│ Datos pendientes por sincronizar:      │
│  - 0 registros de actividades          │
│  - 0 cambios en cultivos               │
│                                        │
│ Tamaño pendiente: 0 KB                 │
│                                        │
│            [Sincronizar ahora]         │
└────────────────────────────────────────┘
```

**Historial de Sincronizaciones:**
```
Fecha              │ Hora   │ Registros │ Tamaño │ Estado
─────────────────────────────────────────────────────────
05-04-2026         │ 15:45  │ 3        │ 12 KB  │ ✓ Exitosa
05-04-2026         │ 14:20  │ 2        │ 8 KB   │ ✓ Exitosa
04-04-2026         │ 10:30  │ 5        │ 18 KB  │ ✓ Exitosa
03-04-2026         │ 09:15  │ 4        │ 14 KB  │ ✓ Exitosa
```

**Modal: Sincronización en progreso**
```
┌──────────────────────────────────────┐
│ Sincronizando datos...               │
├──────────────────────────────────────┤
│                                      │
│ [████████░░░░] 60%                  │
│                                      │
│ Registros enviados: 3 / 5            │
│ Tiempo estimado: 45 segundos         │
│                                      │
│          [Cancelar]                  │
└──────────────────────────────────────┘
```

---

### 4.7 PANTALLA: Perfil del Productor

**Ubicación:** Menú de usuario en header o sección Perfil.

**Información Personal:**
- Foto de perfil (circular, pequeña)
- Nombre
- Correo
- Teléfono
- Botón Editar

**Datos de la Finca:**
- Nombre de la finca
- Localización (municipio, vereda)
- Área total
- Cultivos principales
- Botón Editar

**Preferencias de Notificación:**
- ☐ Recibir notificaciones por correo
- ☐ Recibir notificaciones por SMS
- ☐ Alertas críticas solamente
- Botón Guardar

**Seguridad:**
- Cambiar contraseña (botón)
- Modal: Ingresa contraseña actual y nueva

**Descargas útiles:**
- Manual de usuario (PDF)
- Guía de recomendaciones agrícolas (PDF)
- Glosario de términos (PDF)

---

### 4.8 PANTALLA: Administración (Admin only)

#### 4.8.1 Gestión de Usuarios
- Tabla completa:
  - Usuario | Rol | Estado | Última actividad | Acciones
- Botón: "+ Agregar usuario"
- Acciones: Editar, Desactivar, Ver historial

**Modal: Agregar usuario**
```
Correo: [input]
Nombre: [input]
Rol: [dropdown: Productor / Admin / Asociación]
Finca: [dropdown]
Estado: [Activo / Inactivo]
```

#### 4.8.2 Catálogos y Parámetros
- Tabs:
  - Tipos de cultivo
  - Tipos de actividad
  - Tipos de recomendación
  - Parámetros del sistema
- Tabla para cada uno con CRUD (Crear, Leer, Actualizar, Eliminar)

#### 4.8.3 Monitoreo del Sistema
- Resumen:
  - Usuarios activos hoy
  - Últimas sincronizaciones
  - Errores o inconsistencias
- Gráficos: actividad por hora, por usuario, por tipo

#### 4.8.4 Reportes Consolidados
- Por asociación
- Por región
- Por período
- Exportar a PDF/CSV

---

## 5. Estados Especiales

### 5.1 Estado Offline
- Indicador rojo en header: "Sin conexión"
- Datos permitidos: lectura local de cultivos anteriores
- Acciones permitidas: registrar actividades nuevas (guardadas localmente)
- Aviso visual: "Los cambios se guardarán localmente y se sincronizarán cuando la conexión regrese"
- Botón "Sincronizar cuando regrese la conexión" deshabilitado con tooltip

### 5.2 Estado de Sincronización en Progreso
- Barra de progreso en header
- Botón deshabilitado durante la operación
- Animación suave de carga

### 5.3 Estados de Validación
- Campo requerido no completo: borde rojo, mensaje "Este campo es requerido"
- Entrada inválida: borde rojo, mensaje descriptivo
- Entrada válida: borde verde suave (opcional)
- Confirmación de guardado: toast verde "Datos guardados correctamente"
- Error: toast rojo "Error al guardar. Por favor, intenta de nuevo"

### 5.4 Vistas Vacías
- Si no hay cultivos: "Aún no tienes cultivos registrados. [+ Registrar cultivo]"
- Si no hay actividades: "No hay actividades registradas en este período. [+ Registrar actividad]"
- Iconografía simple y texto claro

---

## 6. Navegación

### 6.1 Sidebar Principal (Izquierda)
```
Logo / Marca (comprimible)
────────────────
Dashboard    [icono home]
Cultivos     [icono leaf]
Actividades  [icono check]
Alertas      [icono bell]
Reportes     [icono chart]
Sincronización [icono sync]
────────────────
Admin        [icono settings]  (si es admin)
────────────────
Perfil       [icono user]
Cerrar sesion [icono logout]
────────────────
Estado: En línea / Sin conexión
Última sync: [fecha y hora]
```

### 6.2 Header Superior
- Logo + Nombre plataforma (izquierda)
- Búsqueda global (opcional, centro)
- Menú de usuario + Notificaciones (derecha)

---

## 7. Flujos de Validación

### Flujo: Registrar cultivo
1. Usuario hace click en "+ Registrar cultivo"
2. Se abre formulario modal o nueva vista
3. Campos requeridos: Nombre, Tipo, Área, Ubicación, Fecha de siembra
4. Validación en tiempo real
5. Al guardar: confirmación visual, vuelve a listado

### Flujo: Sincronizar
1. Usuario hace click en "Sincronizar"
2. Se valida conectividad
3. Si hay conexión: inicia barra de progreso, envía datos, confirma
4. Si no hay conexión: muestra aviso "Sin conexión" con opción para reintentar

---

## 8. Accesibilidad

- Contraste mínimo WCAG AA (4.5:1 para texto)
- Botones grandes (mínimo 44x44px)
- Textos alternativos en todas las imágenes e iconos
- Navegación por teclado funcional
- Estados focus visibles
- No usar color solo como indicador de estado (combinar con iconografía)

---

## 9. Responsive Design

- **Desktop (1440px+):** Layout 3 columnas (sidebar + main + panel lateral)
- **Tablet (768px-1439px):** Layout 2 columnas (sidebar comprimido + main)
- **Mobile (< 768px):** Layout 1 columna con sidebar colapsible (no incluir en este mockup inicial, pero considerar en desarrollo)

---

## 10. Animaciones y Microinteracciones (Sutiles)

- Hover en botones: cambio de color ligero + sombra
- Click en alerta: transición suave hacia detalle
- Carga de tabla: fade-in gradual
- Sincronización: progreso suave sin saltos
- Toast notifications: fade-in/fade-out en esquina inferior derecha

---

## 11. Consideraciones Técnicas para Figma

- Usar componentes reutilizables (Button, Card, Input, Table, Alert)
- Nombres de capas consistentes y organizados
- Paleta de colores definida como swatches
- Tipografía escalable con estilos de texto
- Grillas de referencia (24px) para alineación
- Crear variantes para estados (hover, active, disabled)
- Documentar especificaciones de espaciado y dimensiones
