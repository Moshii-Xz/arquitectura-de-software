# AgroInteligente — Vistas HTML organizadas por módulo

> Documento de referencia para migración a React/JSX.
> Cada sección contiene: nombre del componente sugerido, descripción funcional y el HTML fuente completo.

---

## Índice de Vistas

1. [Sincronización y Operación Offline](#syncofflineview) — `SyncOfflineView`
2. [Gestión de Actividades](#actividadesview) — `ActividadesView`
3. [Alertas del Sistema](#alertasview) — `AlertasView`
4. [Gestión de Insumos](#insumosview) — `InsumosView`
5. [Gestión de Cultivos](#cultivosview) — `CultivosView`
6. [Shell / Layout Estándar](#shellview) — `ShellView`
7. [Gestión de Perfil](#perfilview) — `PerfilView`
8. [Inicio de Sesión (v1)](#loginv1view) — `LoginV1View`
9. [Inicio de Sesión (v2)](#loginv2view) — `LoginV2View`
10. [Registro Exitoso / Onboarding](#registroexitosoview) — `RegistroExitosoView`
11. [Dashboard Principal](#dashboardview) — `DashboardView`

---

## Sincronización y Operación Offline

**Componente React sugerido:** `SyncOfflineView`  
**Archivo:** `views/01-sincronizacion-offline.jsx`

### Descripción funcional
Muestra el estado de conectividad, datos pendientes, historial de sincronización y acción manual de sincronizar.

### Secciones identificadas
- `Context Frame (Top Anchor)`
- `TopNavBar`
- `SideNavBar`
- `Main Content Area`
- `Section 0: Case Use Coverage (Bento Style)`
- `Section A: System Status`
- `Section B: Sync Progress Placeholder`
- `Section C: Sync History Table`

### HTML Fuente

```html
<!DOCTYPE html>

<html class="light" lang="es"><head>
<meta charset="utf-8"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<title>AgroInteligente - Sincronización y Operación Offline</title>
<script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script>
<link href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@300;400;500;600;700;800&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<script id="tailwind-config">
      tailwind.config = {
        darkMode: "class",
        theme: {
          extend: {
            "colors": {
                    "outline-variant": "#bfc9c0",
                    "on-tertiary": "#ffffff",
                    "background": "#effcf5",
                    "surface-container-high": "#deebe4",
                    "on-surface": "#131e1a",
                    "surface-container-lowest": "#ffffff",
                    "inverse-on-surface": "#e7f4ed",
                    "tertiary-container": "#517861",
                    "primary-fixed": "#a4f3c5",
                    "on-background": "#131e1a",
                    "tertiary-fixed-dim": "#a6d0b5",
                    "surface": "#effcf5",
                    "primary-fixed-dim": "#89d7aa",
                    "surface-container-low": "#eaf7f0",
                    "error-container": "#ffdad6",
                    "primary-container": "#2f7d57",
                    "on-tertiary-fixed": "#002112",
                    "secondary-container": "#fdaa47",
                    "surface-dim": "#d0ddd6",
                    "secondary-fixed-dim": "#ffb86a",
                    "tertiary": "#395f49",
                    "on-primary-fixed-variant": "#005233",
                    "on-primary": "#ffffff",
                    "surface-tint": "#196b47",
                    "on-primary-fixed": "#002112",
                    "on-error-container": "#93000a",
                    "on-primary-container": "#d0ffe0",
                    "surface-bright": "#effcf5",
                    "secondary": "#895200",
                    "primary": "#0c6440",
                    "outline": "#6f7a72",
                    "on-secondary": "#ffffff",
                    "on-secondary-container": "#6e4100",
                    "on-tertiary-container": "#d3ffe2",
                    "inverse-primary": "#89d7aa",
                    "on-tertiary-fixed-variant": "#284e3a",
                    "on-error": "#ffffff",
                    "secondary-fixed": "#ffdcbc",
                    "tertiary-fixed": "#c2edd0",
                    "surface-variant": "#d9e5df",
                    "on-secondary-fixed": "#2c1700",
                    "inverse-surface": "#27332e",
                    "on-surface-variant": "#3f4942",
                    "on-secondary-fixed-variant": "#683d00",
                    "surface-container-highest": "#d9e5df",
                    "error": "#ba1a1a",
                    "surface-container": "#e4f1ea"
            },
            "borderRadius": {
                    "DEFAULT": "0.25rem",
                    "lg": "0.5rem",
                    "xl": "0.75rem",
                    "full": "9999px"
            },
            "fontFamily": {
                    "headline": ["Public Sans"],
                    "body": ["Public Sans"],
                    "label": ["Public Sans"]
            }
          },
        },
      }
    </script>
<style>
        .material-symbols-outlined {
            font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24;
        }
        body {
            font-family: 'Public Sans', sans-serif;
            background-color: #effcf5;
        }
        .soil-depth-gradient {
            background: linear-gradient(90deg, #895200 0%, #ffdcbc 100%);
        }
        .primary-tactile-gradient {
            background: linear-gradient(135deg, #0c6440 0%, #2f7d57 100%);
        }
        .glass-panel {
            background: rgba(255, 255, 255, 0.8);
            backdrop-filter: blur(24px);
        }
    </style>
</head>
<body class="text-on-surface">
<!-- Context Frame (Top Anchor) -->
<div class="w-full bg-surface-container-low px-8 py-3 flex justify-between items-center border-b border-outline-variant/10">
<div>
<h1 class="text-xs font-bold tracking-widest text-primary uppercase">Wireframe funcional - Módulo Sincronización y Operación Offline</h1>
<p class="text-[10px] text-on-surface-variant">Vista técnica para confirmar estado, datos pendientes y acción manual de sincronizar</p>
</div>
<div class="flex items-center gap-4">
<div class="flex items-center bg-secondary-container/20 px-3 py-1 rounded-full border border-secondary-container/30">
<span class="material-symbols-outlined text-secondary text-sm mr-2" style="font-variation-settings: 'FILL' 1;">signal_wifi_off</span>
<span class="text-[10px] font-bold text-on-secondary-container tracking-wider uppercase">Modo Offline Activo</span>
</div>
</div>
</div>
<!-- TopNavBar -->
<nav class="flex justify-between items-center w-full px-8 py-4 bg-[#effcf5] dark:bg-emerald-950/90 backdrop-blur-xl sticky top-0 z-50">
<div class="flex items-center gap-12">
<span class="text-2xl font-bold tracking-tight text-[#0c6440] dark:text-emerald-300">AgroInteligente</span>
<div class="hidden md:flex items-center space-x-8">
<a class="text-[#3f4942] hover:text-[#2f7d57] transition-colors font-medium" href="#">Dashboard</a>
<a class="text-[#3f4942] hover:text-[#2f7d57] transition-colors font-medium" href="#">Cultivos</a>
<a class="text-[#3f4942] hover:text-[#2f7d57] transition-colors font-medium" href="#">Actividades</a>
<a class="text-[#3f4942] hover:text-[#2f7d57] transition-colors font-medium" href="#">Alertas</a>
<a class="text-[#3f4942] hover:text-[#2f7d57] transition-colors font-medium" href="#">Reportes</a>
<a class="text-[#0c6440] dark:text-emerald-300 border-b-2 border-[#0c6440] font-semibold pb-1" href="#">Sincronización</a>
</div>
</div>
<div class="flex items-center gap-4">
<span class="material-symbols-outlined text-[#0c6440] cursor-pointer hover:rotate-180 transition-transform duration-500">sync</span>
<span class="material-symbols-outlined text-error">signal_wifi_off</span>
<div class="w-10 h-10 rounded-full bg-surface-container-highest flex items-center justify-center border-2 border-primary/10 overflow-hidden">
<img class="w-full h-full object-cover" data-alt="Portrait of a professional agronomist wearing a beige hat in a bright outdoor field setting" src="https://lh3.googleusercontent.com/aida-public/AB6AXuC_OwHUz7ewe75JOVhS9zn77gGEw8ayrZ-kS1L-Qef0WQKFAEs2JzPDPb1K31AEbbd-cocEG0pl-7uB5y60IK4D7OnfRI6twvpA1VI53e9nYpwVUh7WjYlnv6OmHQYw8Ivry4HF_7mZdBU_BFuVN_GHLMprpQ_lYf9K3C1LhyVLe4BiOa9bPgzvXSET6lIDHNNBZUi1nW1-6WjFRc4jPuSnsSgmgTFHlO7v3ok2NyAhImdi4jMXi9f2XTqwmpMPChXgpewUksqmfvo"/>
</div>
</div>
</nav>
<div class="flex min-h-screen">
<!-- SideNavBar -->
<aside class="flex flex-col h-screen w-64 bg-[#eaf7f0] dark:bg-emerald-900/30 p-6 space-y-8 sticky top-[72px]">
<div>
<h2 class="text-[#0c6440] font-bold text-sm tracking-widest uppercase mb-1">Monitoreo</h2>
<p class="text-xs text-[#3f4942]/70">Modo Offline Activo</p>
</div>
<nav class="flex-1 space-y-2">
<div class="flex items-center p-3 gap-3 text-[#3f4942] hover:bg-[#d9e5df]/50 rounded-xl transition-all cursor-pointer">
<span class="material-symbols-outlined text-xl">sensors</span>
<span class="text-sm font-medium">Estado actual</span>
</div>
<div class="flex items-center p-3 gap-3 text-[#3f4942] hover:bg-[#d9e5df]/50 rounded-xl transition-all cursor-pointer">
<span class="material-symbols-outlined text-xl">pending_actions</span>
<span class="text-sm font-medium">Datos pendientes</span>
</div>
<div class="flex items-center p-3 gap-3 text-[#3f4942] hover:bg-[#d9e5df]/50 rounded-xl transition-all cursor-pointer">
<span class="material-symbols-outlined text-xl text-primary">history</span>
<span class="text-sm font-medium">Historial</span>
</div>
<div class="flex items-center p-3 gap-3 bg-[#d9e5df] text-[#0c6440] font-bold rounded-xl shadow-sm">
<span class="material-symbols-outlined text-xl">settings_remote</span>
<span class="text-sm">Acción manual</span>
</div>
</nav>
<div class="p-4 bg-surface-container-highest rounded-2xl border border-outline-variant/10">
<div class="flex items-center gap-2 mb-2">
<span class="w-2 h-2 rounded-full bg-secondary animate-pulse"></span>
<span class="text-[10px] font-bold text-on-surface tracking-tighter uppercase">Estado Actual: OFFLINE</span>
</div>
<p class="text-[10px] text-on-surface-variant leading-tight mb-3">Los datos se guardan localmente hasta detectar conexión estable.</p>
<button class="w-full py-2 primary-tactile-gradient text-white rounded-xl text-[10px] font-bold tracking-widest uppercase shadow-lg shadow-primary/20">Sincronizar Ahora</button>
</div>
<div class="pt-4 border-t border-outline-variant/20">
<div class="flex items-center p-3 gap-3 text-[#3f4942] hover:bg-[#d9e5df]/50 rounded-xl transition-all cursor-pointer">
<span class="material-symbols-outlined text-xl">settings</span>
<span class="text-sm font-medium">Ajustes</span>
</div>
</div>
</aside>
<!-- Main Content Area -->
<main class="flex-1 p-12 bg-surface">
<!-- Section 0: Case Use Coverage (Bento Style) -->
<div class="mb-12">
<h3 class="text-2xl font-bold text-on-surface mb-6 tracking-tight">Cobertura de Casos de Uso</h3>
<div class="grid grid-cols-1 md:grid-cols-3 gap-6">
<div class="bg-surface-container-low p-6 rounded-3xl border border-outline-variant/5">
<div class="w-10 h-10 rounded-full bg-primary-fixed flex items-center justify-center mb-4">
<span class="material-symbols-outlined text-on-primary-fixed-variant">cloud_off</span>
</div>
<h4 class="text-sm font-bold text-on-surface mb-2">Registro Sin Señal</h4>
<p class="text-xs text-on-surface-variant leading-relaxed">Captura de datos técnica en zonas remotas sin interrupciones operativas.</p>
</div>
<div class="bg-surface-container-low p-6 rounded-3xl border border-outline-variant/5">
<div class="w-10 h-10 rounded-full bg-tertiary-fixed flex items-center justify-center mb-4">
<span class="material-symbols-outlined text-on-tertiary-fixed-variant">sync_problem</span>
</div>
<h4 class="text-sm font-bold text-on-surface mb-2">Resolución de Conflictos</h4>
<p class="text-xs text-on-surface-variant leading-relaxed">Algoritmo de 'Última Versión' aplicado para evitar sobreescritura de datos críticos.</p>
</div>
<div class="bg-surface-container-low p-6 rounded-3xl border border-outline-variant/5">
<div class="w-10 h-10 rounded-full bg-secondary-fixed flex items-center justify-center mb-4">
<span class="material-symbols-outlined text-on-secondary-fixed-variant">battery_saver</span>
</div>
<h4 class="text-sm font-bold text-on-surface mb-2">Optimización de Energía</h4>
<p class="text-xs text-on-surface-variant leading-relaxed">Sincronización por lotes (batch) para minimizar el consumo de batería y datos.</p>
</div>
</div>
</div>
<!-- Section A: System Status -->
<div class="grid grid-cols-1 lg:grid-cols-12 gap-8 mb-12">
<div class="lg:col-span-7 bg-surface-container p-8 rounded-[2rem] relative overflow-hidden group">
<div class="absolute -right-4 -top-4 w-40 h-40 bg-primary/5 rounded-full blur-3xl group-hover:bg-primary/10 transition-colors"></div>
<div class="relative z-10">
<div class="flex justify-between items-start mb-8">
<div>
<h3 class="text-primary text-xs font-bold uppercase tracking-[0.2em] mb-2">Estado del Sistema</h3>
<p class="text-3xl font-extrabold text-on-surface tracking-tighter">Operación Desconectada</p>
</div>
<span class="bg-secondary-container px-4 py-1.5 rounded-full text-xs font-bold text-on-secondary-container flex items-center gap-2">
<span class="material-symbols-outlined text-base">warning</span> NO SINCRONIZADO
                            </span>
</div>
<div class="grid grid-cols-2 gap-y-6 gap-x-12 mb-10">
<div>
<p class="text-[10px] text-on-surface-variant uppercase font-bold tracking-widest mb-1">Última Sincronización</p>
<p class="text-sm font-medium text-on-surface">06-04-2026 · 09:15 AM</p>
</div>
<div>
<p class="text-[10px] text-on-surface-variant uppercase font-bold tracking-widest mb-1">Conectividad</p>
<p class="text-sm font-medium text-error flex items-center gap-1">
                                    Offline <span class="text-[10px] text-on-surface-variant">(Sin señal detectada)</span>
</p>
</div>
<div>
<p class="text-[10px] text-on-surface-variant uppercase font-bold tracking-widest mb-1">Datos Pendientes</p>
<p class="text-sm font-medium text-on-surface">5 actividades / 2 cultivos</p>
</div>
<div>
<p class="text-[10px] text-on-surface-variant uppercase font-bold tracking-widest mb-1">Tamaño de Lote</p>
<p class="text-sm font-medium text-on-surface">18.4 KB <span class="text-[10px] text-on-surface-variant">(Optimizado)</span></p>
</div>
</div>
<div class="flex gap-4">
<button class="px-8 py-4 primary-tactile-gradient text-white rounded-2xl text-xs font-bold tracking-widest uppercase shadow-xl shadow-primary/20 hover:scale-[1.02] active:scale-95 transition-all">Sincronizar ahora</button>
<button class="px-8 py-4 bg-transparent border border-outline-variant/30 text-on-surface-variant rounded-2xl text-xs font-bold tracking-widest uppercase hover:bg-surface-container-high transition-colors">Cancelar</button>
</div>
</div>
</div>
<!-- Section B: Sync Progress Placeholder -->
<div class="lg:col-span-5 bg-surface-container-high p-8 rounded-[2rem] flex flex-col justify-center">
<h4 class="text-[10px] text-on-surface-variant uppercase font-extrabold tracking-widest mb-4">Progreso de Transferencia</h4>
<div class="mb-4 flex justify-between items-end">
<span class="text-4xl font-black text-primary">0%</span>
<span class="text-xs text-on-surface-variant font-medium">0 / 7 registros enviados</span>
</div>
<div class="w-full h-4 bg-surface-container-low rounded-full overflow-hidden">
<div class="h-full w-0 soil-depth-gradient"></div>
</div>
<p class="mt-4 text-[11px] text-on-surface-variant italic">Esperando señal de red estable para iniciar el volcado de datos...</p>
</div>
</div>
<!-- Section C: Sync History Table -->
<div class="mb-12">
<div class="flex justify-between items-center mb-6">
<h3 class="text-xl font-bold text-on-surface tracking-tight">Historial de Sincronización</h3>
<button class="text-primary text-[10px] font-bold tracking-widest uppercase flex items-center gap-2">
                        Ver reporte completo <span class="material-symbols-outlined text-sm">arrow_forward</span>
</button>
</div>
<div class="overflow-hidden bg-surface-container-lowest rounded-[2rem] border border-outline-variant/10 shadow-sm">
<table class="w-full text-left border-collapse">
<thead>
<tr class="bg-surface-container-low/50">
<th class="px-8 py-5 text-[10px] font-extrabold text-on-surface-variant uppercase tracking-widest">Fecha</th>
<th class="px-8 py-5 text-[10px] font-extrabold text-on-surface-variant uppercase tracking-widest">Hora</th>
<th class="px-8 py-5 text-[10px] font-extrabold text-on-surface-variant uppercase tracking-widest">Registros</th>
<th class="px-8 py-5 text-[10px] font-extrabold text-on-surface-variant uppercase tracking-widest">Tamaño</th>
<th class="px-8 py-5 text-[10px] font-extrabold text-on-surface-variant uppercase tracking-widest">Estado</th>
</tr>
</thead>
<tbody class="divide-y divide-outline-variant/10">
<tr class="hover:bg-surface-container-low transition-colors group">
<td class="px-8 py-5 text-sm font-medium">05-04-2026</td>
<td class="px-8 py-5 text-sm text-on-surface-variant">18:42</td>
<td class="px-8 py-5 text-sm text-on-surface-variant">12 items</td>
<td class="px-8 py-5 text-sm text-on-surface-variant">42 KB</td>
<td class="px-8 py-5">
<span class="px-3 py-1 bg-primary-fixed/30 text-on-primary-fixed-variant text-[10px] font-bold rounded-full">EXITOSO</span>
</td>
</tr>
<tr class="hover:bg-surface-container-low transition-colors">
<td class="px-8 py-5 text-sm font-medium">05-04-2026</td>
<td class="px-8 py-5 text-sm text-on-surface-variant">12:10</td>
<td class="px-8 py-5 text-sm text-on-surface-variant">3 items</td>
<td class="px-8 py-5 text-sm text-on-surface-variant">8 KB</td>
<td class="px-8 py-5">
<span class="px-3 py-1 bg-primary-fixed/30 text-on-primary-fixed-variant text-[10px] font-bold rounded-full">EXITOSO</span>
</td>
</tr>
<tr class="hover:bg-surface-container-low transition-colors">
<td class="px-8 py-5 text-sm font-medium">04-04-2026</td>
<td class="px-8 py-5 text-sm text-on-surface-variant">09:15</td>
<td class="px-8 py-5 text-sm text-on-surface-variant">45 items</td>
<td class="px-8 py-5 text-sm text-on-surface-variant">156 KB</td>
<td class="px-8 py-5">
<span class="px-3 py-1 bg-error-container text-on-error-container text-[10px] font-bold rounded-full">FALLIDO</span>
</td>
</tr>
</tbody>
</table>
</div>
</div>
<!-- Section D: Interaction Rules -->
<div class="bg-primary/5 p-8 rounded-[2rem] border-2 border-dashed border-primary/20">
<h4 class="text-xs font-bold text-primary uppercase tracking-[0.2em] mb-4">Reglas de Interacción Técnica</h4>
<div class="space-y-4">
<div class="flex items-start gap-4">
<span class="bg-primary text-white w-6 h-6 rounded-full flex items-center justify-center text-[10px] font-bold flex-shrink-0 mt-0.5">01</span>
<p class="text-sm text-on-surface-variant"><strong class="text-on-surface">Almacenamiento Local:</strong> Todos los cambios realizados sin conexión se guardan en la base de datos IndexedDB del navegador con cifrado de grado industrial.</p>
</div>
<div class="flex items-start gap-4">
<span class="bg-primary text-white w-6 h-6 rounded-full flex items-center justify-center text-[10px] font-bold flex-shrink-0 mt-0.5">02</span>
<p class="text-sm text-on-surface-variant"><strong class="text-on-surface">Activación de Sincronización:</strong> El sistema intentará sincronizar automáticamente al detectar 10 segundos de conexión estable, o puede ser forzado mediante el botón "Sincronizar ahora".</p>
</div>
<div class="flex items-start gap-4">
<span class="bg-primary text-white w-6 h-6 rounded-full flex items-center justify-center text-[10px] font-bold flex-shrink-0 mt-0.5">03</span>
<p class="text-sm text-on-surface-variant"><strong class="text-on-surface">Confirmación de Integridad:</strong> Al finalizar, el sistema emitirá un token de validación para asegurar que los datos en la nube coinciden exactamente con los generados en campo.</p>
</div>
</div>
</div>
</main>
</div>
<!-- Footer Note -->
<footer class="w-full py-6 px-12 bg-surface-container-lowest flex justify-center border-t border-outline-variant/10">
<p class="text-[11px] font-medium text-on-surface-variant/60 tracking-wider text-center uppercase">
            Contrato visual del módulo: define estructura de monitoreo, acción principal y retroalimentación de estado · <span class="text-primary">AgroInteligente 2026</span>
</p>
</footer>
<!-- FAB Suppression Logic: Not rendering FAB on this details/status screen per mandate -->
</body></html>
```

---

## Gestión de Actividades

**Componente React sugerido:** `ActividadesView`  
**Archivo:** `views/02-actividades.jsx`

### Descripción funcional
CRUD de actividades agrícolas: registro, listado, filtrado por lote/tipo y seguimiento de tareas pendientes.

### Secciones identificadas
- `TopNavBar`
- `SideNavBar`
- `Main Content Area`
- `Frame Title Section`
- `Case Use Coverage Table`
- `Grid (2x2) Report Categories`
- `Section A`
- `Section B`

### HTML Fuente

```html
<!DOCTYPE html><html lang="es"><head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script>
<link href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@300;400;500;600;700;800&amp;display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet">
<script id="tailwind-config">
      tailwind.config = {
        darkMode: "class",
        theme: {
          extend: {
            "colors": {
                    "surface-container-highest": "#d9e5df",
                    "on-secondary-fixed": "#2c1700",
                    "secondary-container": "#fdaa47",
                    "on-tertiary": "#ffffff",
                    "surface-container": "#e4f1ea",
                    "secondary-fixed": "#ffdcbc",
                    "on-primary-fixed": "#002112",
                    "surface-dim": "#d0ddd6",
                    "on-surface-variant": "#3f4942",
                    "surface-container-low": "#eaf7f0",
                    "tertiary-fixed": "#c2edd0",
                    "primary-fixed": "#a4f3c5",
                    "on-primary-container": "#d0ffe0",
                    "on-secondary": "#ffffff",
                    "inverse-surface": "#27332e",
                    "on-primary-fixed-variant": "#005233",
                    "surface-container-high": "#deebe4",
                    "inverse-primary": "#89d7aa",
                    "background": "#effcf5",
                    "on-background": "#131e1a",
                    "outline-variant": "#bfc9c0",
                    "on-tertiary-fixed-variant": "#284e3a",
                    "secondary": "#895200",
                    "on-tertiary-fixed": "#002112",
                    "on-error": "#ffffff",
                    "tertiary-fixed-dim": "#a6d0b5",
                    "surface-tint": "#196b47",
                    "on-tertiary-container": "#d3ffe2",
                    "secondary-fixed-dim": "#ffb86a",
                    "on-secondary-fixed-variant": "#683d00",
                    "inverse-on-surface": "#e7f4ed",
                    "on-primary": "#ffffff",
                    "error": "#ba1a1a",
                    "primary-fixed-dim": "#89d7aa",
                    "surface-variant": "#d9e5df",
                    "primary": "#0c6440",
                    "tertiary-container": "#517861",
                    "surface-bright": "#effcf5",
                    "primary-container": "#2f7d57",
                    "surface-container-lowest": "#ffffff",
                    "on-secondary-container": "#6e4100",
                    "on-error-container": "#93000a",
                    "tertiary": "#395f49",
                    "outline": "#6f7a72",
                    "error-container": "#ffdad6",
                    "surface": "#effcf5",
                    "on-surface": "#131e1a"
            },
            "borderRadius": {
                    "DEFAULT": "0.25rem",
                    "lg": "0.5rem",
                    "xl": "0.75rem",
                    "full": "9999px"
            },
            "fontFamily": {
                    "headline": ["Public Sans"],
                    "body": ["Public Sans"],
                    "label": ["Public Sans"]
            }
          },
        },
      }
    </script>
<style>
        .material-symbols-outlined {
            font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24;
        }
        body { font-family: 'Public Sans', sans-serif; }
    </style>
<style>*, ::before, ::after{--tw-border-spacing-x:0;--tw-border-spacing-y:0;--tw-translate-x:0;--tw-translate-y:0;--tw-rotate:0;--tw-skew-x:0;--tw-skew-y:0;--tw-scale-x:1;--tw-scale-y:1;--tw-pan-x: ;--tw-pan-y: ;--tw-pinch-zoom: ;--tw-scroll-snap-strictness:proximity;--tw-gradient-from-position: ;--tw-gradient-via-position: ;--tw-gradient-to-position: ;--tw-ordinal: ;--tw-slashed-zero: ;--tw-numeric-figure: ;--tw-numeric-spacing: ;--tw-numeric-fraction: ;--tw-ring-inset: ;--tw-ring-offset-width:0px;--tw-ring-offset-color:#fff;--tw-ring-color:rgb(59 130 246 / 0.5);--tw-ring-offset-shadow:0 0 #0000;--tw-ring-shadow:0 0 #0000;--tw-shadow:0 0 #0000;--tw-shadow-colored:0 0 #0000;--tw-blur: ;--tw-brightness: ;--tw-contrast: ;--tw-grayscale: ;--tw-hue-rotate: ;--tw-invert: ;--tw-saturate: ;--tw-sepia: ;--tw-drop-shadow: ;--tw-backdrop-blur: ;--tw-backdrop-brightness: ;--tw-backdrop-contrast: ;--tw-backdrop-grayscale: ;--tw-backdrop-hue-rotate: ;--tw-backdrop-invert: ;--tw-backdrop-opacity: ;--tw-backdrop-saturate: ;--tw-backdrop-sepia: ;--tw-contain-size: ;--tw-contain-layout: ;--tw-contain-paint: ;--tw-contain-style: }::backdrop{--tw-border-spacing-x:0;--tw-border-spacing-y:0;--tw-translate-x:0;--tw-translate-y:0;--tw-rotate:0;--tw-skew-x:0;--tw-skew-y:0;--tw-scale-x:1;--tw-scale-y:1;--tw-pan-x: ;--tw-pan-y: ;--tw-pinch-zoom: ;--tw-scroll-snap-strictness:proximity;--tw-gradient-from-position: ;--tw-gradient-via-position: ;--tw-gradient-to-position: ;--tw-ordinal: ;--tw-slashed-zero: ;--tw-numeric-figure: ;--tw-numeric-spacing: ;--tw-numeric-fraction: ;--tw-ring-inset: ;--tw-ring-offset-width:0px;--tw-ring-offset-color:#fff;--tw-ring-color:rgb(59 130 246 / 0.5);--tw-ring-offset-shadow:0 0 #0000;--tw-ring-shadow:0 0 #0000;--tw-shadow:0 0 #0000;--tw-shadow-colored:0 0 #0000;--tw-blur: ;--tw-brightness: ;--tw-contrast: ;--tw-grayscale: ;--tw-hue-rotate: ;--tw-invert: ;--tw-saturate: ;--tw-sepia: ;--tw-drop-shadow: ;--tw-backdrop-blur: ;--tw-backdrop-brightness: ;--tw-backdrop-contrast: ;--tw-backdrop-grayscale: ;--tw-backdrop-hue-rotate: ;--tw-backdrop-invert: ;--tw-backdrop-opacity: ;--tw-backdrop-saturate: ;--tw-backdrop-sepia: ;--tw-contain-size: ;--tw-contain-layout: ;--tw-contain-paint: ;--tw-contain-style: }/* ! tailwindcss v3.4.17 | MIT License | https://tailwindcss.com */*,::after,::before{box-sizing:border-box;border-width:0;border-style:solid;border-color:#e5e7eb}::after,::before{--tw-content:''}:host,html{line-height:1.5;-webkit-text-size-adjust:100%;-moz-tab-size:4;tab-size:4;font-family:ui-sans-serif, system-ui, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";font-feature-settings:normal;font-variation-settings:normal;-webkit-tap-highlight-color:transparent}body{margin:0;line-height:inherit}hr{height:0;color:inherit;border-top-width:1px}abbr:where([title]){-webkit-text-decoration:underline dotted;text-decoration:underline dotted}h1,h2,h3,h4,h5,h6{font-size:inherit;font-weight:inherit}a{color:inherit;text-decoration:inherit}b,strong{font-weight:bolder}code,kbd,pre,samp{font-family:ui-monospace, SFMono-Regular, Menlo, Monaco, Consolas, "Liberation Mono", "Courier New", monospace;font-feature-settings:normal;font-variation-settings:normal;font-size:1em}small{font-size:80%}sub,sup{font-size:75%;line-height:0;position:relative;vertical-align:baseline}sub{bottom:-.25em}sup{top:-.5em}table{text-indent:0;border-color:inherit;border-collapse:collapse}button,input,optgroup,select,textarea{font-family:inherit;font-feature-settings:inherit;font-variation-settings:inherit;font-size:100%;font-weight:inherit;line-height:inherit;letter-spacing:inherit;color:inherit;margin:0;padding:0}button,select{text-transform:none}button,input:where([type=button]),input:where([type=reset]),input:where([type=submit]){-webkit-appearance:button;background-color:transparent;background-image:none}:-moz-focusring{outline:auto}:-moz-ui-invalid{box-shadow:none}progress{vertical-align:baseline}::-webkit-inner-spin-button,::-webkit-outer-spin-button{height:auto}[type=search]{-webkit-appearance:textfield;outline-offset:-2px}::-webkit-search-decoration{-webkit-appearance:none}::-webkit-file-upload-button{-webkit-appearance:button;font:inherit}summary{display:list-item}blockquote,dd,dl,figure,h1,h2,h3,h4,h5,h6,hr,p,pre{margin:0}fieldset{margin:0;padding:0}legend{padding:0}menu,ol,ul{list-style:none;margin:0;padding:0}dialog{padding:0}textarea{resize:vertical}input::placeholder,textarea::placeholder{opacity:1;color:#9ca3af}[role=button],button{cursor:pointer}:disabled{cursor:default}audio,canvas,embed,iframe,img,object,svg,video{display:block;vertical-align:middle}img,video{max-width:100%;height:auto}[hidden]:where(:not([hidden=until-found])){display:none}[type='text'],input:where(:not([type])),[type='email'],[type='url'],[type='password'],[type='number'],[type='date'],[type='datetime-local'],[type='month'],[type='search'],[type='tel'],[type='time'],[type='week'],[multiple],textarea,select{-webkit-appearance:none;appearance:none;background-color:#fff;border-color:#6b7280;border-width:1px;border-radius:0px;padding-top:0.5rem;padding-right:0.75rem;padding-bottom:0.5rem;padding-left:0.75rem;font-size:1rem;line-height:1.5rem;--tw-shadow:0 0 #0000;}[type='text']:focus, input:where(:not([type])):focus, [type='email']:focus, [type='url']:focus, [type='password']:focus, [type='number']:focus, [type='date']:focus, [type='datetime-local']:focus, [type='month']:focus, [type='search']:focus, [type='tel']:focus, [type='time']:focus, [type='week']:focus, [multiple]:focus, textarea:focus, select:focus{outline:2px solid transparent;outline-offset:2px;--tw-ring-inset:var(--tw-empty,/*!*/ /*!*/);--tw-ring-offset-width:0px;--tw-ring-offset-color:#fff;--tw-ring-color:#2563eb;--tw-ring-offset-shadow:var(--tw-ring-inset) 0 0 0 var(--tw-ring-offset-width) var(--tw-ring-offset-color);--tw-ring-shadow:var(--tw-ring-inset) 0 0 0 calc(1px + var(--tw-ring-offset-width)) var(--tw-ring-color);box-shadow:var(--tw-ring-offset-shadow), var(--tw-ring-shadow), var(--tw-shadow);border-color:#2563eb}input::placeholder,textarea::placeholder{color:#6b7280;opacity:1}::-webkit-datetime-edit-fields-wrapper{padding:0}::-webkit-date-and-time-value{min-height:1.5em;text-align:inherit}::-webkit-datetime-edit{display:inline-flex}::-webkit-datetime-edit,::-webkit-datetime-edit-year-field,::-webkit-datetime-edit-month-field,::-webkit-datetime-edit-day-field,::-webkit-datetime-edit-hour-field,::-webkit-datetime-edit-minute-field,::-webkit-datetime-edit-second-field,::-webkit-datetime-edit-millisecond-field,::-webkit-datetime-edit-meridiem-field{padding-top:0;padding-bottom:0}select{background-image:url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' fill='none' viewBox='0 0 20 20'%3e%3cpath stroke='%236b7280' stroke-linecap='round' stroke-linejoin='round' stroke-width='1.5' d='M6 8l4 4 4-4'/%3e%3c/svg%3e");background-position:right 0.5rem center;background-repeat:no-repeat;background-size:1.5em 1.5em;padding-right:2.5rem;print-color-adjust:exact}[multiple],[size]:where(select:not([size="1"])){background-image:initial;background-position:initial;background-repeat:unset;background-size:initial;padding-right:0.75rem;print-color-adjust:unset}[type='checkbox'],[type='radio']{-webkit-appearance:none;appearance:none;padding:0;print-color-adjust:exact;display:inline-block;vertical-align:middle;background-origin:border-box;-webkit-user-select:none;user-select:none;flex-shrink:0;height:1rem;width:1rem;color:#2563eb;background-color:#fff;border-color:#6b7280;border-width:1px;--tw-shadow:0 0 #0000}[type='checkbox']{border-radius:0px}[type='radio']{border-radius:100%}[type='checkbox']:focus,[type='radio']:focus{outline:2px solid transparent;outline-offset:2px;--tw-ring-inset:var(--tw-empty,/*!*/ /*!*/);--tw-ring-offset-width:2px;--tw-ring-offset-color:#fff;--tw-ring-color:#2563eb;--tw-ring-offset-shadow:var(--tw-ring-inset) 0 0 0 var(--tw-ring-offset-width) var(--tw-ring-offset-color);--tw-ring-shadow:var(--tw-ring-inset) 0 0 0 calc(2px + var(--tw-ring-offset-width)) var(--tw-ring-color);box-shadow:var(--tw-ring-offset-shadow), var(--tw-ring-shadow), var(--tw-shadow)}[type='checkbox']:checked,[type='radio']:checked{border-color:transparent;background-color:currentColor;background-size:100% 100%;background-position:center;background-repeat:no-repeat}[type='checkbox']:checked{background-image:url("data:image/svg+xml,%3csvg viewBox='0 0 16 16' fill='white' xmlns='http://www.w3.org/2000/svg'%3e%3cpath d='M12.207 4.793a1 1 0 010 1.414l-5 5a1 1 0 01-1.414 0l-2-2a1 1 0 011.414-1.414L6.5 9.086l4.293-4.293a1 1 0 011.414 0z'/%3e%3c/svg%3e");}@media (forced-colors: active) {[type='checkbox']:checked{-webkit-appearance:auto;appearance:auto}}[type='radio']:checked{background-image:url("data:image/svg+xml,%3csvg viewBox='0 0 16 16' fill='white' xmlns='http://www.w3.org/2000/svg'%3e%3ccircle cx='8' cy='8' r='3'/%3e%3c/svg%3e");}@media (forced-colors: active) {[type='radio']:checked{-webkit-appearance:auto;appearance:auto}}[type='checkbox']:checked:hover,[type='checkbox']:checked:focus,[type='radio']:checked:hover,[type='radio']:checked:focus{border-color:transparent;background-color:currentColor}[type='checkbox']:indeterminate{background-image:url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' fill='none' viewBox='0 0 16 16'%3e%3cpath stroke='white' stroke-linecap='round' stroke-linejoin='round' stroke-width='2' d='M4 8h8'/%3e%3c/svg%3e");border-color:transparent;background-color:currentColor;background-size:100% 100%;background-position:center;background-repeat:no-repeat;}@media (forced-colors: active) {[type='checkbox']:indeterminate{-webkit-appearance:auto;appearance:auto}}[type='checkbox']:indeterminate:hover,[type='checkbox']:indeterminate:focus{border-color:transparent;background-color:currentColor}[type='file']{background:unset;border-color:inherit;border-width:0;border-radius:0;padding:0;font-size:unset;line-height:inherit}[type='file']:focus{outline:1px solid ButtonText;outline:1px auto -webkit-focus-ring-color}.fixed{position:fixed}.sticky{position:sticky}.bottom-8{bottom:2rem}.left-0{left:0px}.right-8{right:2rem}.top-0{top:0px}.z-50{z-index:50}.mx-auto{margin-left:auto;margin-right:auto}.mb-2{margin-bottom:0.5rem}.mb-6{margin-bottom:1.5rem}.mt-auto{margin-top:auto}.flex{display:flex}.inline-flex{display:inline-flex}.grid{display:grid}.hidden{display:none}.aspect-video{aspect-ratio:16 / 9}.h-10{height:2.5rem}.h-16{height:4rem}.h-\[1024px\]{height:1024px}.h-full{height:100%}.min-h-\[1024px\]{min-height:1024px}.w-10{width:2.5rem}.w-16{width:4rem}.w-72{width:18rem}.w-full{width:100%}.max-w-7xl{max-width:80rem}.max-w-\[1920px\]{max-width:1920px}.flex-1{flex:1 1 0%}.scale-125{--tw-scale-x:1.25;--tw-scale-y:1.25;transform:translate(var(--tw-translate-x), var(--tw-translate-y)) rotate(var(--tw-rotate)) skewX(var(--tw-skew-x)) skewY(var(--tw-skew-y)) scaleX(var(--tw-scale-x)) scaleY(var(--tw-scale-y))}.grid-cols-1{grid-template-columns:repeat(1, minmax(0, 1fr))}.flex-col{flex-direction:column}.flex-wrap{flex-wrap:wrap}.items-center{align-items:center}.justify-end{justify-content:flex-end}.justify-center{justify-content:center}.justify-between{justify-content:space-between}.gap-1{gap:0.25rem}.gap-2{gap:0.5rem}.gap-3{gap:0.75rem}.gap-4{gap:1rem}.gap-6{gap:1.5rem}.gap-8{gap:2rem}.space-x-2 > :not([hidden]) ~ :not([hidden]){--tw-space-x-reverse:0;margin-right:calc(0.5rem * var(--tw-space-x-reverse));margin-left:calc(0.5rem * calc(1 - var(--tw-space-x-reverse)))}.space-x-3 > :not([hidden]) ~ :not([hidden]){--tw-space-x-reverse:0;margin-right:calc(0.75rem * var(--tw-space-x-reverse));margin-left:calc(0.75rem * calc(1 - var(--tw-space-x-reverse)))}.space-x-4 > :not([hidden]) ~ :not([hidden]){--tw-space-x-reverse:0;margin-right:calc(1rem * var(--tw-space-x-reverse));margin-left:calc(1rem * calc(1 - var(--tw-space-x-reverse)))}.space-x-8 > :not([hidden]) ~ :not([hidden]){--tw-space-x-reverse:0;margin-right:calc(2rem * var(--tw-space-x-reverse));margin-left:calc(2rem * calc(1 - var(--tw-space-x-reverse)))}.space-y-12 > :not([hidden]) ~ :not([hidden]){--tw-space-y-reverse:0;margin-top:calc(3rem * calc(1 - var(--tw-space-y-reverse)));margin-bottom:calc(3rem * var(--tw-space-y-reverse))}.space-y-2 > :not([hidden]) ~ :not([hidden]){--tw-space-y-reverse:0;margin-top:calc(0.5rem * calc(1 - var(--tw-space-y-reverse)));margin-bottom:calc(0.5rem * var(--tw-space-y-reverse))}.space-y-3 > :not([hidden]) ~ :not([hidden]){--tw-space-y-reverse:0;margin-top:calc(0.75rem * calc(1 - var(--tw-space-y-reverse)));margin-bottom:calc(0.75rem * var(--tw-space-y-reverse))}.space-y-6 > :not([hidden]) ~ :not([hidden]){--tw-space-y-reverse:0;margin-top:calc(1.5rem * calc(1 - var(--tw-space-y-reverse)));margin-bottom:calc(1.5rem * var(--tw-space-y-reverse))}.space-y-8 > :not([hidden]) ~ :not([hidden]){--tw-space-y-reverse:0;margin-top:calc(2rem * calc(1 - var(--tw-space-y-reverse)));margin-bottom:calc(2rem * var(--tw-space-y-reverse))}.divide-y > :not([hidden]) ~ :not([hidden]){--tw-divide-y-reverse:0;border-top-width:calc(1px * calc(1 - var(--tw-divide-y-reverse)));border-bottom-width:calc(1px * var(--tw-divide-y-reverse))}.divide-outline-variant\/10 > :not([hidden]) ~ :not([hidden]){border-color:rgb(191 201 192 / 0.1)}.self-start{align-self:flex-start}.overflow-hidden{overflow:hidden}.overflow-x-auto{overflow-x:auto}.overflow-y-auto{overflow-y:auto}.rounded-2xl{border-radius:1rem}.rounded-3xl{border-radius:1.5rem}.rounded-\[40px\]{border-radius:40px}.rounded-\[calc\(1\.5rem-2px\)\]{border-radius:calc(1.5rem - 2px)}.rounded-full{border-radius:9999px}.rounded-lg{border-radius:0.5rem}.rounded-xl{border-radius:0.75rem}.rounded-r-3xl{border-top-right-radius:1.5rem;border-bottom-right-radius:1.5rem}.border{border-width:1px}.border-b{border-bottom-width:1px}.border-b-2{border-bottom-width:2px}.border-l-4{border-left-width:4px}.border-none{border-style:none}.border-\[\#0c6440\]{--tw-border-opacity:1;border-color:rgb(12 100 64 / var(--tw-border-opacity, 1))}.border-outline-variant\/10{border-color:rgb(191 201 192 / 0.1)}.border-outline-variant\/30{border-color:rgb(191 201 192 / 0.3)}.border-primary{--tw-border-opacity:1;border-color:rgb(12 100 64 / var(--tw-border-opacity, 1))}.bg-\[\#d9e5df\]{--tw-bg-opacity:1;background-color:rgb(217 229 223 / var(--tw-bg-opacity, 1))}.bg-\[\#eaf7f0\]{--tw-bg-opacity:1;background-color:rgb(234 247 240 / var(--tw-bg-opacity, 1))}.bg-\[\#effcf5\]{--tw-bg-opacity:1;background-color:rgb(239 252 245 / var(--tw-bg-opacity, 1))}.bg-background{--tw-bg-opacity:1;background-color:rgb(239 252 245 / var(--tw-bg-opacity, 1))}.bg-primary{--tw-bg-opacity:1;background-color:rgb(12 100 64 / var(--tw-bg-opacity, 1))}.bg-primary-fixed\/30{background-color:rgb(164 243 197 / 0.3)}.bg-secondary-fixed\/30{background-color:rgb(255 220 188 / 0.3)}.bg-surface-container{--tw-bg-opacity:1;background-color:rgb(228 241 234 / var(--tw-bg-opacity, 1))}.bg-surface-container-high{--tw-bg-opacity:1;background-color:rgb(222 235 228 / var(--tw-bg-opacity, 1))}.bg-surface-container-highest{--tw-bg-opacity:1;background-color:rgb(217 229 223 / var(--tw-bg-opacity, 1))}.bg-surface-container-low{--tw-bg-opacity:1;background-color:rgb(234 247 240 / var(--tw-bg-opacity, 1))}.bg-surface-container-lowest{--tw-bg-opacity:1;background-color:rgb(255 255 255 / var(--tw-bg-opacity, 1))}.bg-transparent{background-color:transparent}.bg-gradient-to-br{background-image:linear-gradient(to bottom right, var(--tw-gradient-stops))}.from-primary{--tw-gradient-from:#0c6440 var(--tw-gradient-from-position);--tw-gradient-to:rgb(12 100 64 / 0) var(--tw-gradient-to-position);--tw-gradient-stops:var(--tw-gradient-from), var(--tw-gradient-to)}.to-primary-container{--tw-gradient-to:#2f7d57 var(--tw-gradient-to-position)}.object-cover{object-fit:cover}.p-1{padding:0.25rem}.p-2{padding:0.5rem}.p-3{padding:0.75rem}.p-5{padding:1.25rem}.p-6{padding:1.5rem}.p-8{padding:2rem}.px-3{padding-left:0.75rem;padding-right:0.75rem}.px-4{padding-left:1rem;padding-right:1rem}.px-6{padding-left:1.5rem;padding-right:1.5rem}.px-8{padding-left:2rem;padding-right:2rem}.py-1{padding-top:0.25rem;padding-bottom:0.25rem}.py-10{padding-top:2.5rem;padding-bottom:2.5rem}.py-2{padding-top:0.5rem;padding-bottom:0.5rem}.py-3{padding-top:0.75rem;padding-bottom:0.75rem}.py-4{padding-top:1rem;padding-bottom:1rem}.py-6{padding-top:1.5rem;padding-bottom:1.5rem}.pb-1{padding-bottom:0.25rem}.pb-12{padding-bottom:3rem}.pb-4{padding-bottom:1rem}.pl-6{padding-left:1.5rem}.pt-4{padding-top:1rem}.pt-6{padding-top:1.5rem}.pt-8{padding-top:2rem}.text-left{text-align:left}.text-center{text-align:center}.text-right{text-align:right}.font-\[\'Public_Sans\'\]{font-family:'Public Sans'}.text-2xl{font-size:1.5rem;line-height:2rem}.text-3xl{font-size:1.875rem;line-height:2.25rem}.text-\[10px\]{font-size:10px}.text-lg{font-size:1.125rem;line-height:1.75rem}.text-sm{font-size:0.875rem;line-height:1.25rem}.text-xl{font-size:1.25rem;line-height:1.75rem}.text-xs{font-size:0.75rem;line-height:1rem}.font-bold{font-weight:700}.font-extrabold{font-weight:800}.font-medium{font-weight:500}.font-semibold{font-weight:600}.uppercase{text-transform:uppercase}.italic{font-style:italic}.leading-relaxed{line-height:1.625}.tracking-tight{letter-spacing:-0.025em}.tracking-tighter{letter-spacing:-0.05em}.tracking-wider{letter-spacing:0.05em}.tracking-widest{letter-spacing:0.1em}.text-\[\#0c6440\]{--tw-text-opacity:1;color:rgb(12 100 64 / var(--tw-text-opacity, 1))}.text-emerald-800\/70{color:rgb(6 95 70 / 0.7)}.text-emerald-900\/60{color:rgb(6 78 59 / 0.6)}.text-on-background{--tw-text-opacity:1;color:rgb(19 30 26 / var(--tw-text-opacity, 1))}.text-on-surface-variant{--tw-text-opacity:1;color:rgb(63 73 66 / var(--tw-text-opacity, 1))}.text-outline-variant{--tw-text-opacity:1;color:rgb(191 201 192 / var(--tw-text-opacity, 1))}.text-primary{--tw-text-opacity:1;color:rgb(12 100 64 / var(--tw-text-opacity, 1))}.text-secondary{--tw-text-opacity:1;color:rgb(137 82 0 / var(--tw-text-opacity, 1))}.text-white{--tw-text-opacity:1;color:rgb(255 255 255 / var(--tw-text-opacity, 1))}.antialiased{-webkit-font-smoothing:antialiased;-moz-osx-font-smoothing:grayscale}.opacity-60{opacity:0.6}.shadow-2xl{--tw-shadow:0 25px 50px -12px rgb(0 0 0 / 0.25);--tw-shadow-colored:0 25px 50px -12px var(--tw-shadow-color);box-shadow:var(--tw-ring-offset-shadow, 0 0 #0000), var(--tw-ring-shadow, 0 0 #0000), var(--tw-shadow)}.shadow-\[0px_20px_40px_rgba\(19\2c 30\2c 26\2c 0\.06\)\]{--tw-shadow:0px 20px 40px rgba(19,30,26,0.06);--tw-shadow-colored:0px 20px 40px var(--tw-shadow-color);box-shadow:var(--tw-ring-offset-shadow, 0 0 #0000), var(--tw-ring-shadow, 0 0 #0000), var(--tw-shadow)}.shadow-lg{--tw-shadow:0 10px 15px -3px rgb(0 0 0 / 0.1), 0 4px 6px -4px rgb(0 0 0 / 0.1);--tw-shadow-colored:0 10px 15px -3px var(--tw-shadow-color), 0 4px 6px -4px var(--tw-shadow-color);box-shadow:var(--tw-ring-offset-shadow, 0 0 #0000), var(--tw-ring-shadow, 0 0 #0000), var(--tw-shadow)}.shadow-sm{--tw-shadow:0 1px 2px 0 rgb(0 0 0 / 0.05);--tw-shadow-colored:0 1px 2px 0 var(--tw-shadow-color);box-shadow:var(--tw-ring-offset-shadow, 0 0 #0000), var(--tw-ring-shadow, 0 0 #0000), var(--tw-shadow)}.shadow-primary\/20{--tw-shadow-color:rgb(12 100 64 / 0.2);--tw-shadow:var(--tw-shadow-colored)}.transition-colors{transition-property:color, background-color, border-color, fill, stroke, -webkit-text-decoration-color;transition-property:color, background-color, border-color, text-decoration-color, fill, stroke;transition-property:color, background-color, border-color, text-decoration-color, fill, stroke, -webkit-text-decoration-color;transition-timing-function:cubic-bezier(0.4, 0, 0.2, 1);transition-duration:150ms}.transition-opacity{transition-property:opacity;transition-timing-function:cubic-bezier(0.4, 0, 0.2, 1);transition-duration:150ms}.transition-shadow{transition-property:box-shadow;transition-timing-function:cubic-bezier(0.4, 0, 0.2, 1);transition-duration:150ms}.transition-transform{transition-property:transform;transition-timing-function:cubic-bezier(0.4, 0, 0.2, 1);transition-duration:150ms}.duration-500{transition-duration:500ms}.hover\:scale-105:hover{--tw-scale-x:1.05;--tw-scale-y:1.05;transform:translate(var(--tw-translate-x), var(--tw-translate-y)) rotate(var(--tw-rotate)) skewX(var(--tw-skew-x)) skewY(var(--tw-skew-y)) scaleX(var(--tw-scale-x)) scaleY(var(--tw-scale-y))}.hover\:scale-\[1\.02\]:hover{--tw-scale-x:1.02;--tw-scale-y:1.02;transform:translate(var(--tw-translate-x), var(--tw-translate-y)) rotate(var(--tw-rotate)) skewX(var(--tw-skew-x)) skewY(var(--tw-skew-y)) scaleX(var(--tw-scale-x)) scaleY(var(--tw-scale-y))}.hover\:bg-emerald-100\/50:hover{background-color:rgb(209 250 229 / 0.5)}.hover\:bg-emerald-200\/40:hover{background-color:rgb(167 243 208 / 0.4)}.hover\:bg-primary-container:hover{--tw-bg-opacity:1;background-color:rgb(47 125 87 / var(--tw-bg-opacity, 1))}.hover\:bg-surface-container-highest:hover{--tw-bg-opacity:1;background-color:rgb(217 229 223 / var(--tw-bg-opacity, 1))}.hover\:bg-surface-container-low:hover{--tw-bg-opacity:1;background-color:rgb(234 247 240 / var(--tw-bg-opacity, 1))}.hover\:text-\[\#0c6440\]:hover{--tw-text-opacity:1;color:rgb(12 100 64 / var(--tw-text-opacity, 1))}.hover\:underline:hover{-webkit-text-decoration-line:underline;text-decoration-line:underline}.hover\:opacity-90:hover{opacity:0.9}.hover\:shadow-md:hover{--tw-shadow:0 4px 6px -1px rgb(0 0 0 / 0.1), 0 2px 4px -2px rgb(0 0 0 / 0.1);--tw-shadow-colored:0 4px 6px -1px var(--tw-shadow-color), 0 2px 4px -2px var(--tw-shadow-color);box-shadow:var(--tw-ring-offset-shadow, 0 0 #0000), var(--tw-ring-shadow, 0 0 #0000), var(--tw-shadow)}.focus\:ring-2:focus{--tw-ring-offset-shadow:var(--tw-ring-inset) 0 0 0 var(--tw-ring-offset-width) var(--tw-ring-offset-color);--tw-ring-shadow:var(--tw-ring-inset) 0 0 0 calc(2px + var(--tw-ring-offset-width)) var(--tw-ring-color);box-shadow:var(--tw-ring-offset-shadow), var(--tw-ring-shadow), var(--tw-shadow, 0 0 #0000)}.focus\:ring-surface-tint:focus{--tw-ring-opacity:1;--tw-ring-color:rgb(25 107 71 / var(--tw-ring-opacity, 1))}.focus\:ring-opacity-30:focus{--tw-ring-opacity:0.3}.group:hover .group-hover\:scale-105{--tw-scale-x:1.05;--tw-scale-y:1.05;transform:translate(var(--tw-translate-x), var(--tw-translate-y)) rotate(var(--tw-rotate)) skewX(var(--tw-skew-x)) skewY(var(--tw-skew-y)) scaleX(var(--tw-scale-x)) scaleY(var(--tw-scale-y))}.dark\:bg-emerald-800\/40:is(.dark *){background-color:rgb(6 95 70 / 0.4)}.dark\:bg-emerald-900\/10:is(.dark *){background-color:rgb(6 78 59 / 0.1)}.dark\:bg-emerald-900\/20:is(.dark *){background-color:rgb(6 78 59 / 0.2)}.dark\:bg-emerald-950\/20:is(.dark *){background-color:rgb(2 44 34 / 0.2)}.dark\:text-emerald-100\/50:is(.dark *){color:rgb(209 250 229 / 0.5)}.dark\:text-emerald-200:is(.dark *){--tw-text-opacity:1;color:rgb(167 243 208 / var(--tw-text-opacity, 1))}.dark\:text-emerald-200\/60:is(.dark *){color:rgb(167 243 208 / 0.6)}.dark\:text-emerald-300:is(.dark *){--tw-text-opacity:1;color:rgb(110 231 183 / var(--tw-text-opacity, 1))}.dark\:hover\:bg-emerald-800\/30:hover:is(.dark *){background-color:rgb(6 95 70 / 0.3)}@media (min-width: 640px){.sm\:grid-cols-2{grid-template-columns:repeat(2, minmax(0, 1fr))}}@media (min-width: 768px){.md\:flex{display:flex}.md\:grid-cols-2{grid-template-columns:repeat(2, minmax(0, 1fr))}}@media (min-width: 1024px){.lg\:block{display:block}.lg\:hidden{display:none}.lg\:grid-cols-4{grid-template-columns:repeat(4, minmax(0, 1fr))}}</style></head>
<body class="bg-background text-on-background antialiased" data-mode="connect">
<!-- TopNavBar -->
<header class="bg-[#effcf5] dark:bg-emerald-950/20 text-[#0c6440] font-['Public_Sans'] antialiased tracking-tight docked full-width top-0 bg-[#eaf7f0] dark:bg-emerald-900/10 flat no-line-rule tonal-separation sticky z-50">
<div class="flex justify-between items-center w-full px-8 py-4 max-w-[1920px] mx-auto">
<div class="text-2xl font-bold tracking-tighter text-[#0c6440] dark:text-emerald-300">
                AgroInteligente
            </div>
<nav class="hidden md:flex items-center space-x-8">
<a class="text-emerald-800/70 dark:text-emerald-200/60 hover:text-[#0c6440] hover:bg-emerald-100/50 dark:hover:bg-emerald-800/30 transition-colors" href="#">Dashboard</a>
<a class="text-emerald-800/70 dark:text-emerald-200/60 hover:text-[#0c6440] hover:bg-emerald-100/50 dark:hover:bg-emerald-800/30 transition-colors" href="#">Cultivos</a>
<a class="text-emerald-800/70 dark:text-emerald-200/60 hover:text-[#0c6440] hover:bg-emerald-100/50 dark:hover:bg-emerald-800/30 transition-colors" href="#">Insumos</a>
<a class="text-emerald-800/70 dark:text-emerald-200/60 hover:text-[#0c6440] hover:bg-emerald-100/50 dark:hover:bg-emerald-800/30 transition-colors" href="#">Recomendaciones</a>
<a class="text-emerald-800/70 dark:text-emerald-200/60 hover:text-[#0c6440] hover:bg-emerald-100/50 dark:hover:bg-emerald-800/30 transition-colors" href="#">Perfil</a>
<a class="text-[#0c6440] dark:text-emerald-300 border-b-2 border-[#0c6440] pb-1 font-semibold" href="#">Reportes</a>
</nav>
<div class="flex items-center space-x-4">
<button class="material-symbols-outlined p-2 rounded-full hover:bg-emerald-100/50 transition-colors" data-icon="notifications">notifications</button>
<button class="material-symbols-outlined p-2 rounded-full hover:bg-emerald-100/50 transition-colors" data-icon="settings">settings</button>
</div>
</div>
</header>
<div class="flex min-h-[1024px]" data-stitch-vh="min-h-[1024px]===min-h-screen">
<!-- SideNavBar -->
<aside class="bg-[#eaf7f0] dark:bg-emerald-900/20 text-[#0c6440] font-['Public_Sans'] leading-relaxed docked left-0 w-72 rounded-r-3xl shadow-[0px_20px_40px_rgba(19,30,26,0.06)] sticky top-0 h-[1024px] hidden lg:block overflow-y-auto" data-stitch-vh="h-[1024px]===h-screen">
<div class="flex flex-col h-full p-6 space-y-6">
<div class="py-4">
<h3 class="text-xs uppercase tracking-widest font-bold text-on-surface-variant opacity-60">Módulo Activo</h3>
<p class="text-lg font-bold">Gestián de Campo</p>
</div>
<nav class="space-y-2">
<a class="flex items-center space-x-3 p-3 text-emerald-900/60 dark:text-emerald-100/50 hover:bg-emerald-200/40 transition-transform hover:scale-[1.02] rounded-xl" href="#">
<span class="material-symbols-outlined" data-icon="analytics">analytics</span>
<span>Reporte estado cultivos</span>
</a>
<a class="flex items-center space-x-3 p-3 text-emerald-900/60 dark:text-emerald-100/50 hover:bg-emerald-200/40 transition-transform hover:scale-[1.02] rounded-xl" href="#">
<span class="material-symbols-outlined" data-icon="inventory">inventory</span>
<span>Reporte consumo insumos</span>
</a>
<a class="flex items-center space-x-3 p-3 text-emerald-900/60 dark:text-emerald-100/50 hover:bg-emerald-200/40 transition-transform hover:scale-[1.02] rounded-xl" href="#">
<span class="material-symbols-outlined" data-icon="warning">warning</span>
<span>Reporte alertas recibidas</span>
</a>
<a class="flex items-center space-x-3 p-3 text-emerald-900/60 dark:text-emerald-100/50 hover:bg-emerald-200/40 transition-transform hover:scale-[1.02] rounded-xl" href="#">
<span class="material-symbols-outlined" data-icon="compare_arrows">compare_arrows</span>
<span>Reporte comparativo</span>
</a>
<a class="flex items-center space-x-3 p-3 bg-[#d9e5df] dark:bg-emerald-800/40 text-[#0c6440] dark:text-emerald-200 font-bold rounded-xl shadow-sm" href="#">
<span class="material-symbols-outlined" data-icon="filter_list">filter_list</span>
<span>Filtros y exportación</span>
</a>
</nav>
<div class="mt-auto pt-6">
<div class="bg-surface-container p-5 rounded-2xl space-y-3">
<p class="text-xs font-bold text-primary uppercase">Caso de uso principal</p>
<p class="text-sm font-semibold">Gestionar Reportes</p>
<div class="flex items-center space-x-2 text-xs text-on-surface-variant">
<span class="material-symbols-outlined text-sm" data-icon="info">info</span>
<span>reportes claros, comparables y exportables</span>
</div>
<div class="bg-primary-fixed/30 p-2 rounded-lg text-[10px] font-medium flex justify-between">
<span>Estado</span>
<span class="text-primary font-bold">último reporte generado hoy</span>
</div>
</div>
</div>
</div>
</aside>
<!-- Main Content Area -->
<main class="flex-1 px-8 py-10 max-w-7xl mx-auto space-y-12">
<!-- Frame Title Section -->
<header class="space-y-2 border-l-4 border-primary pl-6">
<h1 class="text-3xl font-extrabold tracking-tight text-primary"><br></h1>
<p class="text-on-surface-variant font-medium text-lg">Estructura técnica para generar, filtrar y exportar reportes en PDF.</p>
</header>
<!-- Case Use Coverage Table -->
<section class="bg-surface-container-low p-1 rounded-3xl overflow-hidden shadow-sm">
<div class="bg-surface-container-lowest p-6 rounded-[calc(1.5rem-2px)]">
<h2 class="text-xl font-bold mb-6 flex items-center gap-2">
<span class="material-symbols-outlined text-primary" data-icon="table_chart">table_chart</span>
                        Cobertura del Caso de Uso
                    </h2>
<div class="overflow-x-auto">
<table class="w-full text-left">
<thead class="text-on-surface-variant text-sm uppercase tracking-wider">
<tr>
<th class="pb-4 px-4 font-bold">Use Case</th>
<th class="pb-4 px-4 font-bold">Evidence</th>
</tr>
</thead>
<tbody class="divide-y divide-outline-variant/10">
<tr>
<td class="py-4 px-4 font-medium">Generación de Reporte de Cultivos</td>
<td class="py-4 px-4 text-on-surface-variant">Módulo visual con filtros de fecha de corte</td>
</tr>
<tr>
<td class="py-4 px-4 font-medium">Análisis de Consumo de Insumos</td>
<td class="py-4 px-4 text-on-surface-variant">Desglose de costos y cantidades por tipo</td>
</tr>
<tr>
<td class="py-4 px-4 font-medium">Trazabilidad de Alertas</td>
<td class="py-4 px-4 text-on-surface-variant">Priorización de incidentes y estados de atención</td>
</tr>
</tbody>
</table>
</div>
</div>
</section>
<!-- Grid (2x2) Report Categories -->
<section class="grid grid-cols-1 md:grid-cols-2 gap-8">
<!-- Section A -->
<article class="bg-surface-container-lowest p-6 rounded-3xl shadow-sm hover:shadow-md transition-shadow flex flex-col group">
<div class="aspect-video w-full rounded-2xl bg-surface-container mb-6 overflow-hidden">
<img class="w-full h-full object-cover group-hover:scale-105 transition-transform duration-500" data-alt="data visualization dashboard showing crop health analytics with green topographic charts and agricultural data overlays" src="https://lh3.googleusercontent.com/aida-public/AB6AXuBL-vvN0UjXa-EmmD-uZCJAZZTQMio0dkKfHVJLvJf2RxYLgLAW5eL3A5QUpMTex9nsg8CArHhabjX2HZUYrRNwDpO4OKO6DItpWhO8AUN8uyWW4C66s465Vts-yIoJsgHcAxxCBg_h96BGHznR7wcw5Y5KmY00Z8AHVMmoMB7kQ4M83XO8zzMOnF8nbuUhTh_RkhUMguXuooOKS-HbU0ebg7MSpMP8g9Q-XoNi8gCcLVunLduSrebh05sOsGyG41-93_tALNKzdD4">
</div>
<h3 class="text-lg font-bold text-primary mb-2">Reporte de estado de cultivos</h3>
<p class="text-on-surface-variant text-sm mb-6 flex-1">estado general por lote y fecha de corte</p>
<button class="bg-gradient-to-br from-primary to-primary-container text-white py-3 px-6 rounded-xl font-bold text-sm flex items-center justify-center gap-2 self-start hover:opacity-90 transition-opacity">
<span class="material-symbols-outlined text-sm" data-icon="play_arrow">play_arrow</span>
                        Generar
                    </button>
</article>
<!-- Section B -->
<article class="bg-surface-container-lowest p-6 rounded-3xl shadow-sm hover:shadow-md transition-shadow flex flex-col group">
<div class="aspect-video w-full rounded-2xl bg-surface-container mb-6 overflow-hidden">
<img class="w-full h-full object-cover group-hover:scale-105 transition-transform duration-500" data-alt="professional inventory management screen displaying chemical supply levels and agricultural input cost tracking charts" src="https://lh3.googleusercontent.com/aida-public/AB6AXuB0bft88mlziNvwuNwMogC2fzsKsqjJqkrKAK02CAsDulU9uILG5ccXSRUF6lb6WMyHcCYBsizoEpzXIjXnMucCKTJk6HtAtOX__AjQahAnLW1brIoei4M1_4v0asVXHCnBCC_krKs47ijVkOTEWm3AtaLaVYKm7IDMXVAwDzDf2FgKb7JY5Bb0VTeANNvVxh4W8OV2728xPm1BhrAvbR8Fh2yUy0ediLugM3vmWj8WZnwosfVcWGkXyNOMtClSLVkUffpq436DUFM">
</div>
<h3 class="text-lg font-bold text-primary mb-2">Reporte de consumo de insumos</h3>
<p class="text-on-surface-variant text-sm mb-6 flex-1">costo total, cantidad y tipo de insumo por cultivo</p>
<button class="bg-gradient-to-br from-primary to-primary-container text-white py-3 px-6 rounded-xl font-bold text-sm flex items-center justify-center gap-2 self-start hover:opacity-90 transition-opacity">
<span class="material-symbols-outlined text-sm" data-icon="play_arrow">play_arrow</span>
                        Generar
                    </button>
</article>
<!-- Section C -->
<article class="bg-surface-container-lowest p-6 rounded-3xl shadow-sm hover:shadow-md transition-shadow flex flex-col group">
<div class="aspect-video w-full rounded-2xl bg-surface-container mb-6 overflow-hidden">
<img class="w-full h-full object-cover group-hover:scale-105 transition-transform duration-500" data-alt="digital alert monitoring system with warning icons and timeline of agricultural incident reports and priorities" src="https://lh3.googleusercontent.com/aida-public/AB6AXuADTyevD00_KVBRzDwFY3RRsj3PSZWDun-5d1gOiyoN2JHcNAegrn5x4ZfTV0oYpLBigLKP4qayxdWKrQN9zEsZaBazG1G-EJfXz-ixbp7SYbZHZJ4x70ERoqI85JiZTWiymrqSamKO4EAauluYfNclhZtJ-FVFA7aMqyIkOv95BYfk17GmcVD9p67aVaJ_XToxlDyg6dcQvIdK_E4WA8tyaK28hAgIp26ebDsLlybNDVq9wTs24C9mnqNwa3ci4A8lYN73p8YhCxY">
</div>
<h3 class="text-lg font-bold text-primary mb-2">Reporte de alertas recibidas</h3>
<p class="text-on-surface-variant text-sm mb-6 flex-1">alertas por prioridad, fecha y estado de atención</p>
<button class="bg-gradient-to-br from-primary to-primary-container text-white py-3 px-6 rounded-xl font-bold text-sm flex items-center justify-center gap-2 self-start hover:opacity-90 transition-opacity">
<span class="material-symbols-outlined text-sm" data-icon="play_arrow">play_arrow</span>
                        Generar
                    </button>
</article>
<!-- Section D -->
<article class="bg-surface-container-lowest p-6 rounded-3xl shadow-sm hover:shadow-md transition-shadow flex flex-col group">
<div class="aspect-video w-full rounded-2xl bg-surface-container mb-6 overflow-hidden">
<img class="w-full h-full object-cover group-hover:scale-105 transition-transform duration-500" data-alt="comparative data visualization using side-by-side bar charts showing growth metrics across different seasonal periods" src="https://lh3.googleusercontent.com/aida-public/AB6AXuDGuXpYB6GpsUOD1bVvm3ZhLIms3kw_9POxkSjH0A1iZh5iihZIRIq10VJlAKxPKPlKLyuZc7si66ktng2L27f-Exfhl9znALp4YRg9ILh3cG29t3YyEHCSfoARX_LZ-XwF2Gaor-W3m8VJ6LvW33SB5YOwvrUXMCdYXVeJQJzsiCPMdCsdf-73wnG3CxH7Da_JVGslAn7NkuIj6cvUHNyXPaXjr2fFbAOrCljGykrZyOE4Z98_1_Y7JBpZSO1YiIEn3MCwjNTe0l0">
</div>
<h3 class="text-lg font-bold text-primary mb-2">Reporte comparativo</h3>
<p class="text-on-surface-variant text-sm mb-6 flex-1">comparación entre cultivos o periodos</p>
<button class="bg-gradient-to-br from-primary to-primary-container text-white py-3 px-6 rounded-xl font-bold text-sm flex items-center justify-center gap-2 self-start hover:opacity-90 transition-opacity">
<span class="material-symbols-outlined text-sm" data-icon="play_arrow">play_arrow</span>
                        Generar
                    </button>
</article>
</section>
<!-- Section E: Filtros y Exportación -->
<section class="bg-surface-container p-8 rounded-[40px] space-y-8">
<div class="flex items-center gap-3">
<span class="material-symbols-outlined text-primary scale-125" data-icon="tune">tune</span>
<h2 class="text-2xl font-bold text-primary">Filtros y exportación</h2>
</div>
<div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-6">
<div class="space-y-2">
<label class="text-xs font-bold uppercase tracking-wider text-on-surface-variant">Desde</label>
<input class="w-full bg-surface-container-highest border-none rounded-xl py-3 px-4 focus:ring-2 focus:ring-surface-tint focus:ring-opacity-30" type="date">
</div>
<div class="space-y-2">
<label class="text-xs font-bold uppercase tracking-wider text-on-surface-variant">Hasta</label>
<input class="w-full bg-surface-container-highest border-none rounded-xl py-3 px-4 focus:ring-2 focus:ring-surface-tint focus:ring-opacity-30" type="date">
</div>
<div class="space-y-2">
<label class="text-xs font-bold uppercase tracking-wider text-on-surface-variant">Tipo de reporte</label>
<select class="w-full bg-surface-container-highest border-none rounded-xl py-3 px-4 focus:ring-2 focus:ring-surface-tint focus:ring-opacity-30">
<option>Estado de cultivos</option>
<option>Consumo de insumos</option>
<option>Alertas</option>
<option>Comparativo</option>
</select>
</div>
<div class="space-y-2">
<label class="text-xs font-bold uppercase tracking-wider text-on-surface-variant">Actor</label>
<select class="w-full bg-surface-container-highest border-none rounded-xl py-3 px-4 focus:ring-2 focus:ring-surface-tint focus:ring-opacity-30">
<option>Todos los actores</option>
<option>Ingeniero Agrónomo</option>
<option>Operario de campo</option>
</select>
</div>
</div>
<div class="flex flex-wrap gap-4 pt-4">
<button class="bg-primary text-white px-8 py-3 rounded-xl font-bold hover:bg-primary-container transition-colors shadow-lg shadow-primary/20">Aplicar filtros</button>
<button class="bg-transparent border border-outline-variant/30 text-primary px-8 py-3 rounded-xl font-bold hover:bg-surface-container-highest transition-colors flex items-center gap-2">
<span class="material-symbols-outlined" data-icon="picture_as_pdf">picture_as_pdf</span>
                        Exportar PDF
                    </button>
</div>
</section>
<!-- Results Table -->
<section class="bg-surface-container-lowest rounded-3xl overflow-hidden shadow-sm">
<div class="p-6 border-b border-outline-variant/10">
<h3 class="font-bold text-lg">Resultados Recientes</h3>
</div>
<div class="overflow-x-auto">
<table class="w-full text-left">
<thead class="bg-surface-container-low text-on-surface-variant text-xs uppercase font-bold tracking-widest">
<tr>
<th class="py-4 px-8">Reporte</th>
<th class="py-4 px-8">Periodo</th>
<th class="py-4 px-8">Registros</th>
<th class="py-4 px-8 text-right">Acción</th>
</tr>
</thead>
<tbody class="divide-y divide-outline-variant/10">
<tr class="hover:bg-surface-container-low transition-colors group">
<td class="py-6 px-8">
<div class="flex items-center gap-3">
<div class="w-10 h-10 rounded-full bg-primary-fixed/30 flex items-center justify-center text-primary">
<span class="material-symbols-outlined" data-icon="monitoring">monitoring</span>
</div>
<span class="font-semibold">Estado de cultivos</span>
</div>
</td>
<td class="py-6 px-8 text-on-surface-variant">01-04-2026 a 15-04-2026</td>
<td class="py-6 px-8"><span class="bg-surface-container-high px-3 py-1 rounded-full text-xs font-bold">12</span></td>
<td class="py-6 px-8 text-right">
<div class="flex justify-end gap-3">
<button class="text-primary hover:underline font-bold text-sm">Ver</button>
<span class="text-outline-variant">|</span>
<button class="text-primary hover:underline font-bold text-sm flex items-center gap-1">
<span class="material-symbols-outlined text-sm" data-icon="download">download</span>
                                            Exportar PDF
                                        </button>
</div>
</td>
</tr>
<tr class="hover:bg-surface-container-low transition-colors group">
<td class="py-6 px-8">
<div class="flex items-center gap-3">
<div class="w-10 h-10 rounded-full bg-secondary-fixed/30 flex items-center justify-center text-secondary">
<span class="material-symbols-outlined" data-icon="vaccines">vaccines</span>
</div>
<span class="font-semibold">Consumo de insumos</span>
</div>
</td>
<td class="py-6 px-8 text-on-surface-variant">15-03-2026 a 30-03-2026</td>
<td class="py-6 px-8"><span class="bg-surface-container-high px-3 py-1 rounded-full text-xs font-bold">45</span></td>
<td class="py-6 px-8 text-right">
<div class="flex justify-end gap-3">
<button class="text-primary hover:underline font-bold text-sm">Ver</button>
<span class="text-outline-variant">|</span>
<button class="text-primary hover:underline font-bold text-sm flex items-center gap-1">
<span class="material-symbols-outlined text-sm" data-icon="download">download</span>
                                            Exportar PDF
                                        </button>
</div>
</td>
</tr>
</tbody>
</table>
</div>
</section>
<!-- Footer Note -->
<footer class="pt-8 pb-12 text-center">
<div class="inline-flex items-center gap-2 bg-surface-container-high px-6 py-2 rounded-full text-sm font-medium text-on-surface-variant italic">
<span class="material-symbols-outlined text-sm" data-icon="draw">draw</span>
                    Contrato visual del caso de uso: generar cuatro tipos de reporte, filtrar por periodo y exportar a PDF.
                </div>
</footer>
</main>
</div>
<!-- Floating UI for Mobile/Context -->
<div class="fixed bottom-8 right-8 lg:hidden">
<button class="w-16 h-16 bg-primary text-white rounded-full shadow-2xl flex items-center justify-center hover:scale-105 transition-transform">
<span class="material-symbols-outlined" data-icon="add">add</span>
</button>
</div>
</body></html>
```

---

## Alertas del Sistema

**Componente React sugerido:** `AlertasView`  
**Archivo:** `views/03-alertas.jsx`

### Descripción funcional
Panel de alertas críticas y notificaciones con indicadores de severidad y estado de resolución.

### Secciones identificadas
- `Section 1: Wireframe Header`
- `Section 2: Header`
- `Section 3: TopNavBar (Shared Component)`
- `Section 4: SideNavBar (Shared Component)`
- `Priority State Card`
- `Main Content Area`
- `Sección 0: Tabla de Cobertura`
- `Sección A: Recomendaciones Activas (Bento Style)`

### HTML Fuente

```html
<!DOCTYPE html>

<html class="light" lang="es"><head>
<meta charset="utf-8"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script>
<link href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@300;400;500;600;700;800;900&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<script id="tailwind-config">
      tailwind.config = {
        darkMode: "class",
        theme: {
          extend: {
            "colors": {
                    "surface-container-low": "#eaf7f0",
                    "secondary-fixed-dim": "#ffb86a",
                    "secondary-fixed": "#ffdcbc",
                    "secondary": "#895200",
                    "primary-fixed": "#a4f3c5",
                    "inverse-primary": "#89d7aa",
                    "secondary-container": "#fdaa47",
                    "on-secondary": "#ffffff",
                    "surface-container-lowest": "#ffffff",
                    "on-secondary-fixed-variant": "#683d00",
                    "outline": "#6f7a72",
                    "on-error": "#ffffff",
                    "surface-bright": "#effcf5",
                    "surface-container-highest": "#d9e5df",
                    "error-container": "#ffdad6",
                    "error": "#ba1a1a",
                    "on-primary": "#ffffff",
                    "tertiary-fixed-dim": "#a6d0b5",
                    "on-tertiary-fixed": "#002112",
                    "tertiary": "#395f49",
                    "surface-container-high": "#deebe4",
                    "on-tertiary-fixed-variant": "#284e3a",
                    "on-tertiary": "#ffffff",
                    "primary-container": "#2f7d57",
                    "on-secondary-container": "#6e4100",
                    "on-primary-fixed": "#002112",
                    "surface-dim": "#d0ddd6",
                    "inverse-on-surface": "#e7f4ed",
                    "surface-tint": "#196b47",
                    "primary": "#0c6440",
                    "surface-container": "#e4f1ea",
                    "on-background": "#131e1a",
                    "outline-variant": "#bfc9c0",
                    "background": "#effcf5",
                    "on-error-container": "#93000a",
                    "tertiary-container": "#517861",
                    "on-tertiary-container": "#d3ffe2",
                    "on-primary-fixed-variant": "#005233",
                    "tertiary-fixed": "#c2edd0",
                    "surface": "#effcf5",
                    "on-secondary-fixed": "#2c1700",
                    "on-primary-container": "#d0ffe0",
                    "on-surface": "#131e1a",
                    "surface-variant": "#d9e5df",
                    "primary-fixed-dim": "#89d7aa",
                    "on-surface-variant": "#3f4942",
                    "inverse-surface": "#27332e"
            },
            "borderRadius": {
                    "DEFAULT": "0.25rem",
                    "lg": "0.5rem",
                    "xl": "0.75rem",
                    "full": "9999px"
            },
            "fontFamily": {
                    "headline": ["Public Sans"],
                    "body": ["Public Sans"],
                    "label": ["Public Sans"]
            }
          },
        },
      }
    </script>
<style>
        body { font-family: 'Public Sans', sans-serif; }
        .material-symbols-outlined { font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24; }
        .glass-panel { background: rgba(255, 255, 255, 0.8); backdrop-filter: blur(24px); }
    </style>
</head>
<body class="bg-background text-on-surface min-h-screen">
<!-- Section 1: Wireframe Header -->
<div class="w-full bg-primary text-white px-12 py-3 flex justify-between items-center text-xs tracking-widest font-mono">
<div>
<span class="font-bold uppercase">Wireframe funcional</span>
<span class="mx-2 opacity-50">|</span>
<span>Caso de uso nivel 1: Gestionar Recomendaciones</span>
</div>
<div class="opacity-75 uppercase">Estado: Prototipo de Alta Fidelidad</div>
</div>
<!-- Section 2: Header -->
<header class="w-full bg-surface-container-low px-12 py-4 flex justify-between items-center border-b border-outline-variant/10">
<div class="flex items-center gap-4">
<div class="w-10 h-10 bg-primary-container rounded-lg flex items-center justify-center text-white">
<span class="material-symbols-outlined" data-icon="potted_plant">potted_plant</span>
</div>
<h1 class="text-2xl font-black text-primary tracking-tight">AgroInteligente</h1>
</div>
<div class="absolute left-1/2 -translate-x-1/2">
<h2 class="text-on-surface-variant font-medium tracking-wide uppercase text-sm">Módulo Gestión de Recomendaciones</h2>
</div>
<div class="flex items-center gap-6">
<div class="relative">
<span class="material-symbols-outlined text-on-surface-variant cursor-pointer" data-icon="notifications">notifications</span>
<span class="absolute -top-1 -right-1 w-2 h-2 bg-error rounded-full"></span>
</div>
<div class="flex items-center gap-3 pl-6 border-l border-outline-variant/20">
<div class="text-right">
<p class="text-sm font-bold text-on-surface leading-none">Ing. Agrónomo</p>
<p class="text-xs text-on-surface-variant">Gestor Senior</p>
</div>
<img alt="Avatar" class="w-10 h-10 rounded-full border-2 border-primary-fixed" data-alt="Professional portrait of a male agronomist wearing a field hat and outdoor gear in soft natural light" src="https://lh3.googleusercontent.com/aida-public/AB6AXuBnfJVNws_lKa4nGMFr1OvR_cHVstD9SW30idBg6Ph0lMPPa6yD5Ums_pDOlGV_46Rz3RStEBpgZ2I1W7dp1qfSrRyGUpAsISTfh00TnlWToS9uShaOkE0ioHgn0I9VvlESHtgEl-akEgpqcWTZNvN8-cwXylDcXMIeeFTizLt8Y26D3P5kVPweubLQGmUFsYnjXACaDlexvhAWFqB21uxA5QIB469AgMMWYUoPCAAiIWGKxj5htsVpnMNnlyJtJ-A3LK27FBd7kPk"/>
</div>
</div>
</header>
<!-- Section 3: TopNavBar (Shared Component) -->
<nav class="bg-[#effcf5] dark:bg-emerald-950 font-['Public_Sans'] text-body-lg leading-relaxed flex justify-between items-center px-12 py-6 w-full max-w-[1920px] mx-auto z-50">
<div class="flex gap-10">
<a class="text-[#3f4942] dark:text-emerald-100/70 hover:text-[#0c6440] transition-all" href="#">Dashboard</a>
<a class="text-[#3f4942] dark:text-emerald-100/70 hover:text-[#0c6440] transition-all" href="#">Cultivos</a>
<a class="text-[#3f4942] dark:text-emerald-100/70 hover:text-[#0c6440] transition-all" href="#">Insumos</a>
<a class="text-[#0c6440] dark:text-emerald-300 font-bold border-b-2 border-[#0c6440] pb-1" href="#">Recomendaciones</a>
<a class="text-[#3f4942] dark:text-emerald-100/70 hover:text-[#0c6440] transition-all" href="#">Reportes</a>
</div>
<div class="flex items-center gap-4">
<div class="bg-surface-container-highest px-4 py-2 rounded-full flex items-center gap-3">
<span class="material-symbols-outlined text-outline" data-icon="search">search</span>
<input class="bg-transparent border-none focus:ring-0 text-sm w-48" placeholder="Buscar recomendación..." type="text"/>
</div>
<span class="material-symbols-outlined text-[#0c6440] cursor-pointer" data-icon="settings">settings</span>
</div>
</nav>
<div class="flex px-12 gap-8 pb-12">
<!-- Section 4: SideNavBar (Shared Component) -->
<aside class="h-screen w-72 left-0 top-0 sticky bg-[#eaf7f0] dark:bg-emerald-900/20 shadow-[20px_0_40px_rgba(19,30,26,0.03)] flex flex-col gap-2 pt-12 pr-4 font-['Public_Sans'] text-label-md">
<div class="px-8 mb-8">
<h3 class="text-[#0c6440] font-black text-lg">Gestión</h3>
<p class="text-on-surface-variant text-xs">Asistente Digital</p>
</div>
<div class="space-y-1">
<div class="bg-gradient-to-r from-[#0c6440] to-[#2f7d57] text-white rounded-r-full py-4 px-8 shadow-lg flex items-center gap-3 cursor-pointer">
<span class="material-symbols-outlined" data-icon="tips_and_updates">tips_and_updates</span>
<span>Recomendaciones activas</span>
</div>
<div class="text-[#3f4942] dark:text-emerald-100/60 py-4 px-8 hover:translate-x-1 transition-transform flex items-center gap-3 cursor-pointer">
<span class="material-symbols-outlined" data-icon="visibility">visibility</span>
<span>Ver detalle</span>
</div>
<div class="text-[#3f4942] dark:text-emerald-100/60 py-4 px-8 hover:translate-x-1 transition-transform flex items-center gap-3 cursor-pointer">
<span class="material-symbols-outlined" data-icon="check_circle">check_circle</span>
<span>Marcar atendida</span>
</div>
<div class="text-[#3f4942] dark:text-emerald-100/60 py-4 px-8 hover:translate-x-1 transition-transform flex items-center gap-3 cursor-pointer">
<span class="material-symbols-outlined" data-icon="cancel">cancel</span>
<span>Descartar</span>
</div>
<div class="text-[#3f4942] dark:text-emerald-100/60 py-4 px-8 hover:translate-x-1 transition-transform flex items-center gap-3 cursor-pointer">
<span class="material-symbols-outlined" data-icon="history">history</span>
<span>Historial</span>
</div>
</div>
<!-- Priority State Card -->
<div class="mt-auto mb-10 mx-4 p-5 bg-secondary-fixed rounded-xl border border-secondary-container/20">
<div class="flex items-center gap-2 mb-2 text-on-secondary-fixed">
<span class="material-symbols-outlined" data-icon="warning">warning</span>
<span class="text-sm font-bold">Estado Crítico</span>
</div>
<p class="text-xs text-on-secondary-fixed-variant leading-relaxed">
                    Hay <span class="font-black">2 recomendaciones prioritarias</span> pendientes de revisión técnica inmediata.
                </p>
</div>
</aside>
<!-- Main Content Area -->
<main class="flex-1 mt-12 space-y-10">
<!-- Sección 0: Tabla de Cobertura -->
<section class="bg-surface-container-low rounded-xl p-8">
<h4 class="text-on-surface font-bold mb-6 flex items-center gap-2">
<span class="material-symbols-outlined text-primary" data-icon="fact_check">fact_check</span>
                    Cobertura de Casos de Uso
                </h4>
<div class="grid grid-cols-4 gap-4">
<div class="bg-surface-container rounded-lg p-4 text-center">
<p class="text-xs text-on-surface-variant mb-1 uppercase tracking-tighter">Identificación</p>
<p class="text-lg font-black text-primary">100%</p>
</div>
<div class="bg-surface-container rounded-lg p-4 text-center border-b-2 border-primary">
<p class="text-xs text-on-surface-variant mb-1 uppercase tracking-tighter">Resolución</p>
<p class="text-lg font-black text-primary">85%</p>
</div>
<div class="bg-surface-container rounded-lg p-4 text-center">
<p class="text-xs text-on-surface-variant mb-1 uppercase tracking-tighter">Históricos</p>
<p class="text-lg font-black text-primary">92%</p>
</div>
<div class="bg-surface-container rounded-lg p-4 text-center">
<p class="text-xs text-on-surface-variant mb-1 uppercase tracking-tighter">Auditoría</p>
<p class="text-lg font-black text-primary">100%</p>
</div>
</div>
</section>
<!-- Sección A: Recomendaciones Activas (Bento Style) -->
<section>
<div class="flex justify-between items-end mb-6">
<div>
<h2 class="text-3xl font-black text-primary tracking-tighter">Recomendaciones Activas</h2>
<p class="text-on-surface-variant">Alertas agronómicas generadas por el sistema inteligente</p>
</div>
<button class="bg-surface-container-highest text-primary px-4 py-2 rounded-lg text-sm font-bold hover:bg-surface-container transition-colors">
                        Ver todas las alertas
                    </button>
</div>
<div class="grid grid-cols-3 gap-6">
<!-- High Priority Card -->
<div class="col-span-2 bg-surface-container-lowest p-6 rounded-2xl shadow-sm border-l-4 border-error">
<div class="flex justify-between mb-4">
<span class="px-3 py-1 bg-error-container text-on-error-container text-[10px] font-bold rounded-full uppercase">Alta Prioridad</span>
<span class="text-xs text-on-surface-variant">24 May 2024</span>
</div>
<h3 class="text-xl font-bold mb-2">Control Fitosanitario: Roya del Cafeto</h3>
<p class="text-on-surface-variant text-sm mb-6 leading-relaxed">Detección de condiciones climáticas favorables para la propagación en Lote Norte. Se requiere aplicación inmediata de fungicida sistémico.</p>
<div class="flex justify-between items-center">
<div class="flex gap-4">
<div class="flex items-center gap-1 text-xs font-medium text-on-surface">
<span class="material-symbols-outlined text-primary text-sm" data-icon="potted_plant">potted_plant</span>
                                    Café Arábica
                                </div>
<div class="flex items-center gap-1 text-xs font-medium text-on-surface">
<span class="material-symbols-outlined text-primary text-sm" data-icon="location_on">location_on</span>
                                    Lote Norte - 5Ha
                                </div>
</div>
<button class="bg-primary text-white px-6 py-2 rounded-xl text-sm font-bold shadow-lg shadow-primary/20 hover:scale-105 transition-transform">
                                Ver Detalle Técnico
                            </button>
</div>
</div>
<!-- Medium Priority Card -->
<div class="bg-surface-container-low p-6 rounded-2xl border-l-4 border-secondary">
<div class="flex justify-between mb-4">
<span class="px-3 py-1 bg-secondary-fixed text-on-secondary-fixed-variant text-[10px] font-bold rounded-full uppercase">Media</span>
<span class="text-xs text-on-surface-variant">23 May</span>
</div>
<h3 class="text-lg font-bold mb-2">Fertilización: Refuerzo Nitrogenado</h3>
<p class="text-on-surface-variant text-xs mb-6">Basado en análisis foliar reciente. Aplicación sugerida de Urea 46%.</p>
<div class="flex items-center gap-1 text-[10px] font-bold text-on-surface-variant uppercase mb-4">
<span class="material-symbols-outlined text-sm" data-icon="agriculture">agriculture</span>
                            Maíz Amarillo
                        </div>
<button class="text-primary text-sm font-black flex items-center gap-2 group">
                            Gestionar <span class="material-symbols-outlined group-hover:translate-x-1 transition-transform" data-icon="arrow_forward">arrow_forward</span>
</button>
</div>
</div>
</section>
<div class="grid grid-cols-5 gap-8">
<!-- Sección B: Panel de Detalle -->
<div class="col-span-3 bg-surface-container rounded-2xl p-8 overflow-hidden relative">
<div class="absolute -right-12 -top-12 opacity-10">
<span class="material-symbols-outlined text-[160px]" data-icon="analytics">analytics</span>
</div>
<h3 class="text-xl font-black text-primary mb-6">Justificación Técnica</h3>
<div class="space-y-6 relative z-10">
<div class="bg-white/40 rounded-xl p-4">
<h4 class="text-xs font-bold text-on-surface-variant uppercase mb-2">Variable de Control</h4>
<div class="flex items-end gap-2">
<span class="text-3xl font-light text-primary">82%</span>
<span class="text-sm text-on-surface-variant pb-1">Humedad Relativa Sostenida</span>
</div>
</div>
<div class="grid grid-cols-2 gap-4">
<div class="border border-outline-variant/30 rounded-xl p-4">
<p class="text-xs font-bold mb-1">Periodo Crítico</p>
<p class="text-sm text-on-surface-variant">Pre-floración avanzada</p>
</div>
<div class="border border-outline-variant/30 rounded-xl p-4">
<p class="text-xs font-bold mb-1">Umbral de Daño</p>
<p class="text-sm text-error font-bold">Excedido (+12%)</p>
</div>
</div>
<p class="text-sm leading-relaxed text-on-surface-variant">
                            El modelo predictivo sugiere un 88% de probabilidad de infección fúngica en las próximas 48 horas debido al patrón de lluvias persistentes y temperaturas entre 18°C y 24°C.
                        </p>
<div class="pt-4 border-t border-outline-variant/30">
<h4 class="text-xs font-bold text-on-surface mb-3">Producto Sugerido</h4>
<div class="flex items-center gap-3">
<div class="w-10 h-10 bg-primary-fixed rounded-full flex items-center justify-center text-primary">
<span class="material-symbols-outlined" data-icon="science">science</span>
</div>
<div>
<p class="text-sm font-bold">Fungicida X-300 Bio</p>
<p class="text-xs text-on-surface-variant">Dosis: 1.5 L/Ha</p>
</div>
</div>
</div>
</div>
</div>
<!-- Sección C: Formulario de Interacción -->
<div class="col-span-2 bg-surface-container-high rounded-2xl p-8">
<h3 class="text-xl font-black text-primary mb-6">Interacción Técnica</h3>
<form class="space-y-6">
<div>
<label class="block text-xs font-bold uppercase text-on-surface-variant mb-2">Cambiar Estado</label>
<select class="w-full bg-surface-container-highest border-none rounded-xl text-sm py-3 px-4 focus:ring-2 focus:ring-primary/20">
<option>Pendiente de ejecución</option>
<option>En proceso de aplicación</option>
<option>Programada</option>
</select>
</div>
<div>
<div class="flex justify-between mb-2">
<label class="text-xs font-bold uppercase text-on-surface-variant">Comentario Técnico</label>
<span class="text-[10px] text-on-surface-variant">0 / 120 chars</span>
</div>
<textarea class="w-full bg-surface-container-highest border-none rounded-xl text-sm py-3 px-4 h-32 focus:ring-2 focus:ring-primary/20 resize-none" maxlength="120" placeholder="Añadir nota sobre la aplicación..."></textarea>
</div>
<div class="space-y-3">
<button class="w-full bg-gradient-to-r from-primary to-primary-container text-white py-4 rounded-xl font-bold flex items-center justify-center gap-2 shadow-lg hover:shadow-primary/30 transition-all" type="button">
<span class="material-symbols-outlined" data-icon="check_circle">check_circle</span>
                                Marcar como Atendida
                            </button>
<button class="w-full border-2 border-error/20 text-error py-4 rounded-xl font-bold flex items-center justify-center gap-2 hover:bg-error/5 transition-all" type="button">
<span class="material-symbols-outlined" data-icon="delete">delete</span>
                                Descartar Recomendación
                            </button>
</div>
</form>
</div>
</div>
<!-- Sección D: Historial -->
<section class="bg-white rounded-2xl overflow-hidden shadow-sm">
<div class="p-8 border-b border-outline-variant/10 flex justify-between items-center">
<div>
<h3 class="text-xl font-black text-primary">Historial de Recomendaciones</h3>
<p class="text-sm text-on-surface-variant">Registro de acciones pasadas y resultados obtenidos</p>
</div>
<div class="flex gap-3">
<div class="flex items-center gap-2 bg-surface-container px-4 py-2 rounded-lg text-sm border border-outline-variant/20">
<span class="text-xs font-bold text-on-surface-variant">Tipo:</span>
<select class="bg-transparent border-none text-xs p-0 focus:ring-0">
<option>Todos</option>
<option>Fitosanitaria</option>
<option>Riego</option>
</select>
</div>
<div class="flex items-center gap-2 bg-surface-container px-4 py-2 rounded-lg text-sm border border-outline-variant/20">
<span class="material-symbols-outlined text-sm" data-icon="calendar_month">calendar_month</span>
<span class="text-xs font-bold text-on-surface-variant">Últimos 30 días</span>
</div>
</div>
</div>
<div class="overflow-x-auto">
<table class="w-full text-left">
<thead>
<tr class="bg-surface-container-low text-xs font-black text-on-surface-variant uppercase tracking-widest">
<th class="px-8 py-4">ID</th>
<th class="px-8 py-4">Fecha</th>
<th class="px-8 py-4">Tipo</th>
<th class="px-8 py-4">Cultivo</th>
<th class="px-8 py-4">Resultado</th>
<th class="px-8 py-4">Estado Final</th>
</tr>
</thead>
<tbody class="divide-y divide-outline-variant/10 text-sm">
<tr class="hover:bg-surface-container-low/50 transition-colors">
<td class="px-8 py-5 text-on-surface-variant font-mono">#REC-492</td>
<td class="px-8 py-5">15 May 2024</td>
<td class="px-8 py-5 font-bold">Riego</td>
<td class="px-8 py-5">Palma de Aceite</td>
<td class="px-8 py-5">
<div class="flex items-center gap-1 text-primary">
<span class="material-symbols-outlined text-sm" data-icon="trending_up">trending_up</span>
                                        +5% Estrés hídrico
                                    </div>
</td>
<td class="px-8 py-5">
<span class="px-3 py-1 bg-primary-fixed text-on-primary-fixed-variant rounded-full text-[10px] font-bold uppercase">Ejecutada</span>
</td>
</tr>
<tr class="hover:bg-surface-container-low/50 transition-colors">
<td class="px-8 py-5 text-on-surface-variant font-mono">#REC-488</td>
<td class="px-8 py-5">10 May 2024</td>
<td class="px-8 py-5 font-bold">Enmienda</td>
<td class="px-8 py-5">Suelo - Sector B</td>
<td class="px-8 py-5">
<div class="flex items-center gap-1 text-on-surface-variant">
<span class="material-symbols-outlined text-sm" data-icon="balance">balance</span>
                                        pH 6.5 Estable
                                    </div>
</td>
<td class="px-8 py-5">
<span class="px-3 py-1 bg-primary-fixed text-on-primary-fixed-variant rounded-full text-[10px] font-bold uppercase">Ejecutada</span>
</td>
</tr>
</tbody>
</table>
</div>
<div class="p-6 bg-surface-container-low/30 text-center">
<button class="text-primary text-xs font-bold hover:underline">Ver reporte histórico completo de la campaña 2024</button>
</div>
</section>
<!-- Nota final: Contrato visual -->
<footer class="pt-12 border-t border-outline-variant/20 flex justify-between items-start text-on-surface-variant pb-12">
<div class="max-w-md">
<h5 class="text-sm font-bold text-primary mb-2">Contrato Visual y Lógica de Negocio</h5>
<p class="text-xs leading-relaxed">
                        Este módulo implementa el protocolo de validación cruzada entre datos de sensores IoT y modelos agronómicos de AgroInteligente. Las recomendaciones aquí presentadas han sido auditadas por el motor de IA Ceres-Engine v2.1.
                    </p>
</div>
<div class="flex gap-4">
<div class="text-right">
<p class="text-[10px] uppercase font-bold opacity-50">Sincronización Cloud</p>
<p class="text-xs text-primary font-bold">En línea - Hace 2 min</p>
</div>
<div class="w-10 h-10 bg-primary/10 rounded-lg flex items-center justify-center text-primary">
<span class="material-symbols-outlined" data-icon="cloud_done">cloud_done</span>
</div>
</div>
</footer>
</main>
</div>
</body></html>
```

---

## Gestión de Insumos

**Componente React sugerido:** `InsumosView`  
**Archivo:** `views/04-gestion-insumos.jsx`

### Descripción funcional
Inventario de insumos agrícolas, movimientos de stock, entradas/salidas y niveles de alerta.

### Secciones identificadas
- `Wireframe Header Frame`
- `Top Navigation Shell`
- `Sidebar Shell`
- `Main Content Area`
- `Section 0: Case Use Coverage Table`
- `Section A: Filters & Actions`
- `Section B: Input Table`
- `Grid Layout for C and D`

### HTML Fuente

```html
<!DOCTYPE html>

<html lang="es"><head>
<meta charset="utf-8"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<title>Gestión de Insumos - AgroInteligente</title>
<script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script>
<link href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@300;400;500;600;700;800;900&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<script id="tailwind-config">
      tailwind.config = {
        darkMode: "class",
        theme: {
          extend: {
            "colors": {
                    "on-secondary-fixed-variant": "#683d00",
                    "primary": "#0c6440",
                    "on-tertiary-fixed": "#002112",
                    "surface-tint": "#196b47",
                    "on-tertiary-container": "#d3ffe2",
                    "surface-dim": "#d0ddd6",
                    "surface-container-low": "#eaf7f0",
                    "on-primary-fixed-variant": "#005233",
                    "surface-container": "#e4f1ea",
                    "error": "#ba1a1a",
                    "on-surface": "#131e1a",
                    "on-primary-fixed": "#002112",
                    "inverse-surface": "#27332e",
                    "on-background": "#131e1a",
                    "on-secondary-container": "#6e4100",
                    "tertiary": "#395f49",
                    "surface-container-highest": "#d9e5df",
                    "on-error-container": "#93000a",
                    "primary-fixed-dim": "#89d7aa",
                    "on-secondary-fixed": "#2c1700",
                    "tertiary-fixed-dim": "#a6d0b5",
                    "surface": "#effcf5",
                    "on-surface-variant": "#3f4942",
                    "inverse-on-surface": "#e7f4ed",
                    "inverse-primary": "#89d7aa",
                    "tertiary-fixed": "#c2edd0",
                    "surface-container-high": "#deebe4",
                    "secondary-fixed-dim": "#ffb86a",
                    "on-secondary": "#ffffff",
                    "secondary-fixed": "#ffdcbc",
                    "on-tertiary-fixed-variant": "#284e3a",
                    "on-error": "#ffffff",
                    "surface-variant": "#d9e5df",
                    "secondary": "#895200",
                    "error-container": "#ffdad6",
                    "surface-bright": "#effcf5",
                    "tertiary-container": "#517861",
                    "on-primary-container": "#d0ffe0",
                    "surface-container-lowest": "#ffffff",
                    "on-tertiary": "#ffffff",
                    "primary-fixed": "#a4f3c5",
                    "background": "#effcf5",
                    "outline": "#6f7a72",
                    "on-primary": "#ffffff",
                    "primary-container": "#2f7d57",
                    "secondary-container": "#fdaa47",
                    "outline-variant": "#bfc9c0"
            },
            "borderRadius": {
                    "DEFAULT": "0.25rem",
                    "lg": "0.5rem",
                    "xl": "0.75rem",
                    "full": "9999px"
            },
            "fontFamily": {
                    "headline": ["Public Sans"],
                    "body": ["Public Sans"],
                    "label": ["Public Sans"]
            }
          },
        },
      }
    </script>
<style>
        body { font-family: 'Public Sans', sans-serif; background-color: #effcf5; }
        .material-symbols-outlined { font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24; }
        .no-scrollbar::-webkit-scrollbar { display: none; }
    </style>
</head>
<body class="text-on-surface selection:bg-primary-fixed selection:text-on-primary-fixed">
<!-- Wireframe Header Frame -->
<div class="bg-primary text-on-primary px-12 py-3 flex justify-between items-center">
<div>
<h1 class="text-sm font-bold tracking-widest uppercase">Wireframe funcional - Caso de uso nivel 1: Gestionar Insumos Agrícolas</h1>
<p class="text-xs opacity-80">Estructura técnica para registrar, consultar, editar y eliminar insumos aplicados</p>
</div>
<div class="flex items-center gap-4 text-xs font-medium">
<span class="px-3 py-1 bg-on-primary/10 rounded-full">v1.0.4</span>
<span class="material-symbols-outlined text-sm">construction</span>
</div>
</div>
<!-- Top Navigation Shell -->
<header class="bg-[#effcf5] dark:bg-emerald-950 font-['Public_Sans'] text-lg font-medium tracking-tight shadow-[0px_20px_40px_rgba(19,30,26,0.04)] sticky top-0 z-50 flex justify-between items-center w-full px-12 py-4">
<div class="flex items-center gap-8">
<span class="text-2xl font-black text-[#0c6440] dark:text-emerald-300 italic">AgroInteligente</span>
<nav class="hidden md:flex gap-8">
<a class="text-[#3f4942] dark:text-emerald-500/70 hover:text-[#0c6440] transition-colors" href="#">Dashboard</a>
<a class="text-[#3f4942] dark:text-emerald-500/70 hover:text-[#0c6440] transition-colors" href="#">Cultivos</a>
<a class="text-[#0c6440] dark:text-emerald-300 font-bold border-b-2 border-[#0c6440] dark:border-emerald-400 pb-1" href="#">Insumos</a>
<a class="text-[#3f4942] dark:text-emerald-500/70 hover:text-[#0c6440] transition-colors" href="#">Recomendaciones</a>
<a class="text-[#3f4942] dark:text-emerald-500/70 hover:text-[#0c6440] transition-colors" href="#">Perfil</a>
<a class="text-[#3f4942] dark:text-emerald-500/70 hover:text-[#0c6440] transition-colors" href="#">Reportes</a>
</nav>
</div>
<div class="flex items-center gap-6">
<div class="relative">
<span class="material-symbols-outlined text-[#2f7d57] cursor-pointer">notifications</span>
<span class="absolute top-0 right-0 w-2 h-2 bg-secondary rounded-full"></span>
</div>
<span class="material-symbols-outlined text-[#2f7d57] cursor-pointer">settings</span>
<img alt="User profile" class="w-10 h-10 rounded-full object-cover ring-2 ring-primary-fixed" data-alt="Portrait of a middle-aged male farmer smiling with sun-kissed skin and professional agricultural background" src="https://lh3.googleusercontent.com/aida-public/AB6AXuBHiU6KcD8IDlbEJbYlOXPkk1tg_G0CWqZmmNTiHN-N0oBv4JHoyZj8pfLhRCtdIjis7aU3I9M9yITZMb6J9xqLqQok9J7CQ2NAjvjpv3wVSg9f_s5RHd-vgR5AyaBxM0R-haXH8fDNtjDocKJOke9RGVsbKWXCgkSET3rYANBUfUKYj3szGh9znC31w327VDruHEkFh9RRy5PT3yP9BUsC8mTSGBg8DbY0A0u4XkL5yW0oU6QEMCYd6IU10J-dkY1U8Dqxf-YnTGU"/>
</div>
</header>
<div class="flex">
<!-- Sidebar Shell -->
<aside class="h-screen w-64 fixed left-0 top-0 pt-20 bg-[#eaf7f0] dark:bg-emerald-900/20 flex flex-col gap-2 py-8 z-40">
<div class="px-6 mb-6">
<h2 class="font-['Public_Sans'] text-sm font-semibold uppercase tracking-wider text-[#2f7d57]">Navegación del módulo</h2>
<p class="text-[10px] text-on-surface-variant opacity-60">Temporada 2024</p>
</div>
<nav class="flex flex-col gap-1">
<a class="flex items-center gap-3 bg-[#d9e5df] dark:bg-emerald-800 text-[#0c6440] dark:text-emerald-100 rounded-r-full py-3 px-6 mr-4 transition-all duration-300 translate-x-1" href="#">
<span class="material-symbols-outlined text-sm">add_circle</span>
<span class="text-xs font-bold uppercase tracking-widest">Registrar insumo</span>
</a>
<a class="flex items-center gap-3 text-[#3f4942] dark:text-emerald-500/60 py-3 px-6 hover:bg-[#effcf5] transition-all" href="#">
<span class="material-symbols-outlined text-sm">inventory_2</span>
<span class="text-xs font-bold uppercase tracking-widest">Consultar catálogo</span>
</a>
<a class="flex items-center gap-3 text-[#3f4942] dark:text-emerald-500/60 py-3 px-6 hover:bg-[#effcf5] transition-all" href="#">
<span class="material-symbols-outlined text-sm">agriculture</span>
<span class="text-xs font-bold uppercase tracking-widest">Listar por cultivo</span>
</a>
<a class="flex items-center gap-3 text-[#3f4942] dark:text-emerald-500/60 py-3 px-6 hover:bg-[#effcf5] transition-all" href="#">
<span class="material-symbols-outlined text-sm">edit</span>
<span class="text-xs font-bold uppercase tracking-widest">Editar registro</span>
</a>
<a class="flex items-center gap-3 text-[#3f4942] dark:text-emerald-500/60 py-3 px-6 hover:bg-[#effcf5] transition-all text-error" href="#">
<span class="material-symbols-outlined text-sm">delete</span>
<span class="text-xs font-bold uppercase tracking-widest">Eliminar registro</span>
</a>
</nav>
<div class="mt-auto px-6 pb-24">
<div class="bg-surface-container-highest p-4 rounded-xl shadow-sm space-y-3">
<div class="flex items-center gap-2">
<span class="material-symbols-outlined text-primary">person</span>
<span class="text-xs font-bold text-primary">Productor Agrícola</span>
</div>
<div class="bg-secondary-container p-2 rounded-lg flex items-center gap-2">
<span class="material-symbols-outlined text-on-secondary-container text-xs">warning</span>
<span class="text-[10px] font-bold text-on-secondary-container leading-tight">Alerta de Alto Impacto Ambiental Detectada</span>
</div>
<div class="pt-2 border-t border-outline-variant/20">
<p class="text-[10px] text-on-surface-variant uppercase tracking-tighter">Costo Total Mensual</p>
<p class="text-lg font-black text-primary">$4,250.00</p>
</div>
</div>
</div>
</aside>
<!-- Main Content Area -->
<main class="ml-64 flex-1 p-12 space-y-12">
<!-- Section 0: Case Use Coverage Table -->
<section class="bg-surface-container-low rounded-2xl p-8 overflow-hidden">
<h3 class="headline-sm font-bold text-primary mb-6 flex items-center gap-2">
<span class="material-symbols-outlined">fact_check</span>
                    Cobertura de Casos de Uso
                </h3>
<div class="overflow-x-auto">
<table class="w-full text-left">
<thead>
<tr class="text-on-surface-variant text-xs uppercase tracking-widest">
<th class="pb-4 pr-4">Caso de Uso</th>
<th class="pb-4">Evidencia en Interfaz</th>
<th class="pb-4 text-right">Estado</th>
</tr>
</thead>
<tbody class="text-sm font-medium">
<tr class="border-t border-outline-variant/10">
<td class="py-4 pr-4">Registrar aplicación</td>
<td class="py-4 text-on-surface-variant italic">Formulario en Sección E</td>
<td class="py-4 text-right"><span class="bg-primary-fixed text-on-primary-fixed px-3 py-1 rounded-full text-[10px] font-bold">MAPPED</span></td>
</tr>
<tr class="border-t border-outline-variant/10">
<td class="py-4 pr-4">Consultar Catálogo</td>
<td class="py-4 text-on-surface-variant italic">Grilla de Insumos en Sección C</td>
<td class="py-4 text-right"><span class="bg-primary-fixed text-on-primary-fixed px-3 py-1 rounded-full text-[10px] font-bold">MAPPED</span></td>
</tr>
<tr class="border-t border-outline-variant/10">
<td class="py-4 pr-4">Alertar Alto Impacto</td>
<td class="py-4 text-on-surface-variant italic">Banners dinámicos en Sección F y SideBar</td>
<td class="py-4 text-right"><span class="bg-primary-fixed text-on-primary-fixed px-3 py-1 rounded-full text-[10px] font-bold">MAPPED</span></td>
</tr>
</tbody>
</table>
</div>
</section>
<!-- Section A: Filters & Actions -->
<section class="flex flex-wrap items-end gap-6">
<div class="flex-1 min-w-[200px]">
<label class="block text-xs font-bold text-on-surface-variant mb-2 uppercase tracking-tighter">Cultivo destino</label>
<select class="w-full bg-surface-container-highest border-none rounded-xl py-3 px-4 text-sm focus:ring-2 focus:ring-surface-tint/30 transition-all">
<option>Todos los cultivos</option>
<option>Maíz Amarillo</option>
<option>Yuca Blanca</option>
<option>Plátano Hartón</option>
</select>
</div>
<div class="flex-1 min-w-[200px]">
<label class="block text-xs font-bold text-on-surface-variant mb-2 uppercase tracking-tighter">Tipo de insumo</label>
<select class="w-full bg-surface-container-highest border-none rounded-xl py-3 px-4 text-sm focus:ring-2 focus:ring-surface-tint/30 transition-all">
<option>Fertilizante</option>
<option>Pesticida</option>
<option>Abono Orgánico</option>
</select>
</div>
<div class="flex-[2] min-w-[300px]">
<label class="block text-xs font-bold text-on-surface-variant mb-2 uppercase tracking-tighter">Buscar insumo</label>
<div class="relative">
<span class="material-symbols-outlined absolute left-4 top-1/2 -translate-y-1/2 text-on-surface-variant text-sm">search</span>
<input class="w-full bg-surface-container-highest border-none rounded-xl py-3 pl-12 pr-4 text-sm focus:ring-2 focus:ring-surface-tint/30 transition-all" placeholder="Escriba el nombre o código..." type="text"/>
</div>
</div>
<div class="flex gap-4">
<button class="bg-primary text-on-primary px-6 py-3 rounded-xl text-sm font-bold shadow-lg hover:shadow-primary/20 transition-all active:scale-95 flex items-center gap-2">
<span class="material-symbols-outlined text-sm">add</span>
                        Registrar Insumo
                    </button>
<button class="bg-surface-container-highest text-primary px-6 py-3 rounded-xl text-sm font-bold transition-all active:scale-95">
                        Limpiar
                    </button>
</div>
</section>
<!-- Section B: Input Table -->
<section class="bg-surface-container rounded-3xl p-1 overflow-hidden">
<table class="w-full text-left">
<thead class="bg-surface-container-high">
<tr class="text-xs font-black uppercase tracking-widest text-on-surface-variant">
<th class="px-8 py-5">Insumo</th>
<th class="px-8 py-5">Cultivo</th>
<th class="px-8 py-5">Fecha</th>
<th class="px-8 py-5">Costo</th>
<th class="px-8 py-5">Impacto</th>
<th class="px-8 py-5 text-center">Acciones</th>
</tr>
</thead>
<tbody class="divide-y divide-outline-variant/10">
<tr class="hover:bg-surface-container-lowest transition-colors group">
<td class="px-8 py-5 font-bold text-primary">NPK 20-20-20</td>
<td class="px-8 py-5">Maíz Amarillo</td>
<td class="px-8 py-5 text-on-surface-variant">12 Mar 2024</td>
<td class="px-8 py-5 font-medium">$450.00</td>
<td class="px-8 py-5">
<span class="bg-primary-fixed text-on-primary-fixed px-3 py-1 rounded-full text-[10px] font-bold">BAJO</span>
</td>
<td class="px-8 py-5 text-center">
<div class="flex justify-center gap-2">
<button class="p-2 hover:bg-surface-container rounded-lg text-primary"><span class="material-symbols-outlined text-sm">edit</span></button>
<button class="p-2 hover:bg-error-container rounded-lg text-error"><span class="material-symbols-outlined text-sm">delete</span></button>
</div>
</td>
</tr>
<tr class="hover:bg-surface-container-lowest transition-colors group">
<td class="px-8 py-5 font-bold text-primary">Control plagas X</td>
<td class="px-8 py-5">Yuca Blanca</td>
<td class="px-8 py-5 text-on-surface-variant">08 Mar 2024</td>
<td class="px-8 py-5 font-medium">$1,200.00</td>
<td class="px-8 py-5">
<span class="bg-error-container text-on-error-container px-3 py-1 rounded-full text-[10px] font-bold">ALTO IMPACTO</span>
</td>
<td class="px-8 py-5 text-center">
<div class="flex justify-center gap-2">
<button class="p-2 hover:bg-surface-container rounded-lg text-primary"><span class="material-symbols-outlined text-sm">edit</span></button>
<button class="p-2 hover:bg-error-container rounded-lg text-error"><span class="material-symbols-outlined text-sm">delete</span></button>
</div>
</td>
</tr>
<tr class="hover:bg-surface-container-lowest transition-colors group">
<td class="px-8 py-5 font-bold text-primary">Abono orgánico</td>
<td class="px-8 py-5">Plátano Hartón</td>
<td class="px-8 py-5 text-on-surface-variant">01 Mar 2024</td>
<td class="px-8 py-5 font-medium">$120.00</td>
<td class="px-8 py-5">
<span class="bg-primary-fixed text-on-primary-fixed px-3 py-1 rounded-full text-[10px] font-bold">BAJO</span>
</td>
<td class="px-8 py-5 text-center">
<div class="flex justify-center gap-2">
<button class="p-2 hover:bg-surface-container rounded-lg text-primary"><span class="material-symbols-outlined text-sm">edit</span></button>
<button class="p-2 hover:bg-error-container rounded-lg text-error"><span class="material-symbols-outlined text-sm">delete</span></button>
</div>
</td>
</tr>
</tbody>
</table>
</section>
<!-- Grid Layout for C and D -->
<div class="grid grid-cols-1 lg:grid-cols-2 gap-12">
<!-- Section C: Input Catalog -->
<section class="space-y-6">
<div class="flex justify-between items-center">
<h3 class="text-xl font-black text-primary tracking-tight">Catálogo de Insumos</h3>
<div class="flex gap-2">
<button class="p-2 bg-surface-container-highest rounded-xl text-primary hover:bg-primary hover:text-on-primary transition-all"><span class="material-symbols-outlined text-sm">grid_view</span></button>
<button class="p-2 bg-surface-container-highest rounded-xl text-primary"><span class="material-symbols-outlined text-sm">list</span></button>
</div>
</div>
<div class="grid grid-cols-1 md:grid-cols-2 gap-4">
<div class="bg-surface-container-lowest p-6 rounded-2xl shadow-sm border border-outline-variant/10 hover:shadow-md transition-all">
<div class="w-10 h-10 bg-tertiary-fixed rounded-full flex items-center justify-center mb-4 text-primary">
<span class="material-symbols-outlined">eco</span>
</div>
<p class="text-[10px] font-black text-on-surface-variant uppercase tracking-widest mb-1">Fertilizantes</p>
<h4 class="font-bold text-sm mb-2">Nitrogenados Complejos</h4>
<p class="text-xs text-on-surface-variant leading-relaxed mb-4">Mezcla granular para estimulación de follaje en cereales y gramíneas.</p>
<div class="flex items-center gap-2">
<span class="w-2 h-2 rounded-full bg-primary-fixed"></span>
<span class="text-[10px] font-bold text-on-surface-variant uppercase tracking-tighter">Impacto Ambiental: Mínimo</span>
</div>
</div>
<div class="bg-surface-container-lowest p-6 rounded-2xl shadow-sm border border-outline-variant/10 hover:shadow-md transition-all">
<div class="w-10 h-10 bg-secondary-fixed rounded-full flex items-center justify-center mb-4 text-secondary">
<span class="material-symbols-outlined">bug_report</span>
</div>
<p class="text-[10px] font-black text-on-surface-variant uppercase tracking-widest mb-1">Pesticidas</p>
<h4 class="font-bold text-sm mb-2">Control de Plagas X-Series</h4>
<p class="text-xs text-on-surface-variant leading-relaxed mb-4">Inhibidor biológico para coleópteros en cultivos de raíz y tubérculo.</p>
<div class="flex items-center gap-2">
<span class="w-2 h-2 rounded-full bg-error"></span>
<span class="text-[10px] font-bold text-on-surface-variant uppercase tracking-tighter">Impacto Ambiental: Crítico</span>
</div>
</div>
</div>
<div class="flex gap-4 pt-4">
<button class="flex-1 bg-surface-container-high text-primary py-3 rounded-xl text-sm font-bold hover:bg-primary hover:text-on-primary transition-all">Consultar catálogo</button>
<button class="flex-1 bg-surface-container-high text-primary py-3 rounded-xl text-sm font-bold hover:bg-primary hover:text-on-primary transition-all">Gestionar catálogo</button>
</div>
</section>
<!-- Section D: Delete Confirmation -->
<section class="bg-error-container/20 border-2 border-dashed border-error/20 rounded-3xl p-8 flex flex-col justify-center items-center text-center space-y-6">
<div class="w-16 h-16 bg-error rounded-full flex items-center justify-center text-on-error shadow-xl shadow-error/20">
<span class="material-symbols-outlined text-3xl">delete_forever</span>
</div>
<div>
<h4 class="text-xl font-black text-error mb-2 tracking-tight">¿Confirmar eliminación técnica?</h4>
<p class="text-sm text-on-surface-variant max-w-sm">Esta acción es irreversible y afectará los reportes de costos acumulados y huella ambiental de la temporada.</p>
</div>
<div class="w-full max-w-sm">
<input class="w-full bg-white border border-outline-variant/30 rounded-xl py-3 px-4 text-sm focus:ring-2 focus:ring-error/30 focus:border-error transition-all" placeholder="Motivo de la eliminación (opcional)..." type="text"/>
</div>
<div class="flex gap-4 w-full max-w-sm">
<button class="flex-1 bg-error text-on-error py-4 rounded-2xl text-sm font-black uppercase tracking-widest shadow-lg hover:shadow-error/30 active:scale-95 transition-all">Confirmar</button>
<button class="flex-1 bg-surface-container-highest text-on-surface-variant py-4 rounded-2xl text-sm font-black uppercase tracking-widest active:scale-95 transition-all">Cancelar</button>
</div>
</section>
</div>
<!-- Section E: Technical Registration Form -->
<section class="bg-surface-container-lowest rounded-[2rem] p-12 shadow-xl shadow-primary/5">
<div class="mb-10">
<h3 class="text-2xl font-black text-primary tracking-tighter mb-2">Formulario de Registro Técnico</h3>
<p class="text-on-surface-variant">Ingrese los datos técnicos de la aplicación para el cálculo de impacto y costos.</p>
</div>
<div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
<div class="space-y-2">
<label class="text-[10px] font-black text-on-surface-variant uppercase tracking-widest">Cultivo destino</label>
<select class="w-full bg-surface-container-low border-none rounded-xl py-4 px-5 text-sm focus:ring-2 focus:ring-surface-tint/30">
<option>Seleccione cultivo...</option>
<option>Maíz Amarillo Lote A</option>
</select>
</div>
<div class="space-y-2">
<label class="text-[10px] font-black text-on-surface-variant uppercase tracking-widest">Insumo aplicado</label>
<div class="relative">
<input class="w-full bg-surface-container-low border-none rounded-xl py-4 px-5 text-sm focus:ring-2 focus:ring-surface-tint/30" placeholder="Buscar en catálogo..." type="text"/>
<span class="text-[10px] text-primary font-bold absolute right-4 top-1/2 -translate-y-1/2">VERIFICADO</span>
</div>
</div>
<div class="space-y-2">
<label class="text-[10px] font-black text-on-surface-variant uppercase tracking-widest">Cantidad (unidades)</label>
<input class="w-full bg-surface-container-low border-none rounded-xl py-4 px-5 text-sm focus:ring-2 focus:ring-surface-tint/30" placeholder="0.00" type="number"/>
</div>
<div class="space-y-2">
<label class="text-[10px] font-black text-on-surface-variant uppercase tracking-widest">Costo total ($)</label>
<input class="w-full bg-surface-container-low border-none rounded-xl py-4 px-5 text-sm focus:ring-2 focus:ring-surface-tint/30" placeholder="Ingrese valor en USD" type="text"/>
<p class="text-[10px] text-secondary font-bold italic">* Campo requerido para reportes financieros</p>
</div>
<div class="space-y-2">
<label class="text-[10px] font-black text-on-surface-variant uppercase tracking-widest">Fecha de aplicación</label>
<input class="w-full bg-surface-container-low border-none rounded-xl py-4 px-5 text-sm focus:ring-2 focus:ring-surface-tint/30" type="date"/>
</div>
<div class="flex items-end gap-4">
<button class="flex-1 bg-primary text-on-primary h-[52px] rounded-xl text-sm font-black uppercase tracking-widest shadow-lg shadow-primary/20 hover:scale-[1.02] active:scale-95 transition-all">Guardar</button>
<button class="flex-1 bg-surface-container-high text-on-surface-variant h-[52px] rounded-xl text-sm font-black uppercase tracking-widest hover:bg-surface-container-highest transition-all">Cancelar</button>
</div>
</div>
</section>
<!-- Section F: High Impact Alerts -->
<section class="relative overflow-hidden bg-gradient-to-br from-on-secondary-container to-secondary-container rounded-3xl p-8 text-white">
<div class="flex flex-col md:flex-row items-center gap-8 relative z-10">
<div class="w-20 h-20 bg-white/20 backdrop-blur-md rounded-2xl flex items-center justify-center flex-shrink-0">
<span class="material-symbols-outlined text-4xl">warning</span>
</div>
<div class="space-y-2 flex-1">
<h4 class="text-xl font-black uppercase tracking-tighter">Protocolo de Aplicación Crítica</h4>
<p class="text-sm opacity-90 leading-relaxed">El sistema ha detectado el uso recurrente de insumos con Categoría Toxicológica II. Se recomienda alternar con bio-estimulantes para evitar la degradación del suelo en el lote 04.</p>
</div>
<button class="bg-white text-on-secondary-container px-8 py-4 rounded-2xl text-xs font-black uppercase tracking-widest shadow-xl hover:bg-opacity-90 active:scale-95 transition-all">Ver Recomendación</button>
</div>
<!-- Abstract organic shape for background -->
<div class="absolute -right-20 -top-20 w-64 h-64 bg-white/10 rounded-full blur-3xl"></div>
</section>
<!-- Section G: Technical Summary Table -->
<section class="space-y-6">
<h3 class="text-xl font-black text-primary tracking-tight">Resumen Técnico de Aplicación</h3>
<div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-4">
<div class="bg-surface-container-low p-6 rounded-2xl border-l-4 border-primary">
<p class="text-[10px] font-black text-on-surface-variant uppercase tracking-widest">Maíz Amarillo</p>
<div class="flex items-baseline gap-2 mt-2">
<span class="text-2xl font-black text-primary">12</span>
<span class="text-xs text-on-surface-variant">Insumos aplicados</span>
</div>
<p class="text-sm font-bold mt-2">$2,450.00 Acumulado</p>
</div>
<div class="bg-surface-container-low p-6 rounded-2xl border-l-4 border-tertiary">
<p class="text-[10px] font-black text-on-surface-variant uppercase tracking-widest">Yuca Blanca</p>
<div class="flex items-baseline gap-2 mt-2">
<span class="text-2xl font-black text-tertiary">05</span>
<span class="text-xs text-on-surface-variant">Insumos aplicados</span>
</div>
<p class="text-sm font-bold mt-2">$1,100.00 Acumulado</p>
</div>
<div class="bg-surface-container-low p-6 rounded-2xl border-l-4 border-secondary">
<p class="text-[10px] font-black text-on-surface-variant uppercase tracking-widest">Plátano Hartón</p>
<div class="flex items-baseline gap-2 mt-2">
<span class="text-2xl font-black text-secondary">08</span>
<span class="text-xs text-on-surface-variant">Insumos aplicados</span>
</div>
<p class="text-sm font-bold mt-2">$700.00 Acumulado</p>
</div>
<div class="bg-surface-container-high p-6 rounded-2xl flex flex-col justify-center items-center text-center">
<span class="material-symbols-outlined text-primary mb-1">history</span>
<p class="text-[10px] font-black text-on-surface-variant uppercase tracking-widest">Último registro</p>
<p class="text-xs font-bold text-primary mt-1">Hoy, 10:45 AM</p>
</div>
</div>
</section>
<!-- Footer Note -->
<footer class="pt-12 pb-8 border-t border-outline-variant/10">
<div class="flex flex-col md:flex-row justify-between items-center gap-6 text-on-surface-variant/60">
<p class="text-[10px] uppercase tracking-[0.2em] font-bold">Nota de Contrato Visual: AgroInteligente Ceres System v2.4</p>
<div class="flex gap-8 text-[10px] font-bold uppercase tracking-widest">
<a class="hover:text-primary transition-colors" href="#">Términos Técnicos</a>
<a class="hover:text-primary transition-colors" href="#">Políticas de Datos Agrícolas</a>
<a class="hover:text-primary transition-colors" href="#">Soporte Módulo</a>
</div>
</div>
</footer>
</main>
</div>
<!-- Floating Action Button (Contextual) -->
<button class="fixed bottom-10 right-10 w-16 h-16 bg-primary text-on-primary rounded-2xl shadow-2xl shadow-primary/40 flex items-center justify-center hover:scale-110 active:scale-95 transition-all z-50 group">
<span class="material-symbols-outlined text-3xl">add</span>
<span class="absolute right-full mr-4 bg-primary text-on-primary px-4 py-2 rounded-xl text-xs font-bold whitespace-nowrap opacity-0 group-hover:opacity-100 transition-opacity pointer-events-none">Nuevo Registro de Insumo</span>
</button>
</body></html>
```

---

## Gestión de Cultivos

**Componente React sugerido:** `CultivosView`  
**Archivo:** `views/05-gestion-cultivos.jsx`

### Descripción funcional
Registro y seguimiento de cultivos por parcela, etapa fenológica, área sembrada y rendimiento esperado.

### Secciones identificadas
- `Franja Superior (Contexto)`
- `TopAppBar`
- `SideNavBar`
- `Main Canvas`
- `Sección 0: Cobertura de Casos de Uso (Technical Table)`
- `Sección A: Filtros`
- `Sección B: Tabla Principal`
- `Row 1`

### HTML Fuente

```html
<!DOCTYPE html>

<html class="light" lang="es"><head>
<meta charset="utf-8"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<title>AgroInteligente - Gestión de Cultivos</title>
<script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script>
<link href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@300;400;500;600;700;800&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<script id="tailwind-config">
        tailwind.config = {
            darkMode: "class",
            theme: {
                extend: {
                    "colors": {
                        "surface-variant": "#d9e5df",
                        "error": "#ba1a1a",
                        "on-tertiary": "#ffffff",
                        "primary-fixed-dim": "#89d7aa",
                        "on-primary-fixed": "#002112",
                        "on-secondary-fixed": "#2c1700",
                        "on-error-container": "#93000a",
                        "secondary-fixed": "#ffdcbc",
                        "surface-container": "#e4f1ea",
                        "on-primary-fixed-variant": "#005233",
                        "surface-container-low": "#eaf7f0",
                        "on-surface": "#131e1a",
                        "tertiary": "#395f49",
                        "surface-dim": "#d0ddd6",
                        "tertiary-fixed": "#c2edd0",
                        "on-tertiary-fixed-variant": "#284e3a",
                        "primary-fixed": "#a4f3c5",
                        "outline-variant": "#bfc9c0",
                        "secondary-fixed-dim": "#ffb86a",
                        "inverse-surface": "#27332e",
                        "inverse-primary": "#89d7aa",
                        "primary": "#0c6440",
                        "on-background": "#131e1a",
                        "surface-container-lowest": "#ffffff",
                        "secondary": "#895200",
                        "on-primary-container": "#d0ffe0",
                        "on-secondary-fixed-variant": "#683d00",
                        "on-secondary": "#ffffff",
                        "on-tertiary-container": "#d3ffe2",
                        "inverse-on-surface": "#e7f4ed",
                        "surface-container-highest": "#d9e5df",
                        "on-tertiary-fixed": "#002112",
                        "surface-tint": "#196b47",
                        "surface-container-high": "#deebe4",
                        "error-container": "#ffdad6",
                        "secondary-container": "#fdaa47",
                        "tertiary-fixed-dim": "#a6d0b5",
                        "surface": "#effcf5",
                        "on-secondary-container": "#6e4100",
                        "surface-bright": "#effcf5",
                        "tertiary-container": "#517861",
                        "on-surface-variant": "#3f4942",
                        "on-primary": "#ffffff",
                        "outline": "#6f7a72",
                        "primary-container": "#2f7d57",
                        "on-error": "#ffffff",
                        "background": "#effcf5"
                    },
                    "borderRadius": {
                        "DEFAULT": "0.25rem",
                        "lg": "0.5rem",
                        "xl": "0.75rem",
                        "full": "9999px"
                    },
                    "fontFamily": {
                        "headline": ["Public Sans"],
                        "body": ["Public Sans"],
                        "label": ["Public Sans"]
                    }
                },
            },
        }
    </script>
<style>
        body { font-family: 'Public Sans', sans-serif; }
        .material-symbols-outlined { font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24; }
        .glass-panel { background: rgba(255, 255, 255, 0.8); backdrop-filter: blur(24px); }
    </style>
</head>
<body class="bg-background text-on-surface min-h-screen">
<!-- Franja Superior (Contexto) -->
<div class="w-full bg-primary-container text-on-primary-container px-8 py-2 text-xs font-medium tracking-wider uppercase">
        Wireframe funcional - Módulo Gestión de Cultivos | <span class="opacity-80">Interacción de Datos Agronómicos en Tiempo Real</span>
</div>
<!-- TopAppBar -->
<header class="bg-[#effcf5] dark:bg-emerald-950/20 backdrop-blur-xl flex justify-between items-center w-full px-8 py-4 max-w-[1920px] mx-auto">
<div class="flex items-center gap-8">
<h1 class="text-2xl font-bold tracking-tighter text-[#0c6440] dark:text-emerald-500 font-public-sans">AgroInteligente</h1>
<div class="hidden md:block h-8 w-px bg-outline-variant/30"></div>
<div class="hidden md:block text-sm font-semibold text-on-surface-variant uppercase tracking-widest">
                Módulo Gestión de Cultivos | Plataforma Agricultura Inteligente
            </div>
</div>
<nav class="hidden md:flex items-center gap-6">
<a class="text-[#3f4942] dark:text-emerald-200/70 hover:text-[#0c6440] transition-colors font-public-sans" href="#">Dashboard</a>
<a class="text-[#0c6440] font-bold border-b-2 border-[#0c6440] pb-1 font-public-sans" href="#">Cultivos</a>
<a class="text-[#3f4942] dark:text-emerald-200/70 hover:text-[#0c6440] transition-colors font-public-sans" href="#">Insumos</a>
<a class="text-[#3f4942] dark:text-emerald-200/70 hover:text-[#0c6440] transition-colors font-public-sans" href="#">Recomendaciones</a>
<a class="text-[#3f4942] dark:text-emerald-200/70 hover:text-[#0c6440] transition-colors font-public-sans" href="#">Perfil</a>
<a class="text-[#3f4942] dark:text-emerald-200/70 hover:text-[#0c6440] transition-colors font-public-sans" href="#">Reportes</a>
</nav>
<div class="flex items-center gap-4">
<button class="p-2 hover:bg-[#e4f1ea] rounded-full transition-colors active:scale-95 duration-150">
<span class="material-symbols-outlined text-[#0c6440]">notifications</span>
</button>
<button class="p-2 hover:bg-[#e4f1ea] rounded-full transition-colors active:scale-95 duration-150">
<span class="material-symbols-outlined text-[#0c6440]">settings</span>
</button>
<img alt="Foto de perfil del agricultor" class="w-10 h-10 rounded-full border-2 border-primary-fixed shadow-sm object-cover" data-alt="portrait of a professional senior agronomist with a friendly expression in a modern office setting, soft natural lighting" src="https://lh3.googleusercontent.com/aida-public/AB6AXuBBkMvsTQ_aktqyQtcfYhVND87llknrAaUqnkudblpO76QQjlDVFTTUWsVHX57cqknkVlTkCLLyG9JQDTazRAkPcOQNDQ_j_dTSfpCND0rE42rtCiPxA3tDBueMJKziZTBm4UWMuLfKEnNrbcam3cEBIoMEzUEDlTVLlDyKL-lkYzYMllexFxy0Y4p8wCy3iBhY-2WvKqhIPK_6JNTv61lio8yD5xdbChk_NZVl4h1liWPwsmX0PRyzJ54gvgf_CfYbn8kVaY66Uck"/>
</div>
</header>
<div class="flex min-h-[calc(100vh-100px)]">
<!-- SideNavBar -->
<aside class="bg-[#eaf7f0] dark:bg-emerald-950/40 h-screen w-72 flex flex-col sticky top-0 border-r border-outline-variant/10">
<div class="p-6">
<div class="mb-8">
<h3 class="text-xs font-bold text-primary uppercase tracking-[0.2em] mb-1">Módulo Actual</h3>
<p class="text-on-surface-variant text-sm font-medium">Zona Norte - Lote 12</p>
</div>
<nav class="flex flex-col gap-2">
<a class="flex items-center gap-3 bg-[#d9e5df] dark:bg-emerald-800/60 text-[#0c6440] dark:text-emerald-200 font-semibold rounded-lg px-4 py-3 duration-200" href="#">
<span class="material-symbols-outlined">agriculture</span>
<span>Listado</span>
</a>
<a class="flex items-center gap-3 text-[#3f4942] dark:text-emerald-100/60 hover:bg-[#e4f1ea] px-4 py-3 rounded-lg hover:translate-x-1 duration-200" href="#">
<span class="material-symbols-outlined">add_circle</span>
<span>Registrar</span>
</a>
<a class="flex items-center gap-3 text-[#3f4942] dark:text-emerald-100/60 hover:bg-[#e4f1ea] px-4 py-3 rounded-lg hover:translate-x-1 duration-200" href="#">
<span class="material-symbols-outlined">update</span>
<span>Actualizar</span>
</a>
<a class="flex items-center gap-3 text-[#3f4942] dark:text-emerald-100/60 hover:bg-[#e4f1ea] px-4 py-3 rounded-lg hover:translate-x-1 duration-200" href="#">
<span class="material-symbols-outlined">archive</span>
<span>Archivar</span>
</a>
</nav>
<div class="mt-auto pt-8">
<button class="w-full bg-primary text-on-primary py-4 rounded-xl font-bold flex items-center justify-center gap-2 shadow-lg shadow-primary/20 active:scale-95 duration-150">
<span class="material-symbols-outlined">add</span>
<span>Añadir Registro</span>
</button>
</div>
</div>
</aside>
<!-- Main Canvas -->
<main class="flex-1 p-8 overflow-y-auto">
<!-- Sección 0: Cobertura de Casos de Uso (Technical Table) -->
<section class="mb-12 bg-surface-container-low rounded-xl p-6">
<div class="flex items-center gap-2 mb-4">
<span class="material-symbols-outlined text-secondary">fact_check</span>
<h2 class="text-sm font-bold uppercase tracking-wider text-secondary">Cobertura de Casos de Uso - Documentación Técnica</h2>
</div>
<div class="overflow-x-auto">
<table class="w-full text-left text-sm border-separate border-spacing-y-2">
<thead class="text-on-surface-variant font-bold">
<tr>
<th class="pb-2 px-4">ID</th>
<th class="pb-2 px-4">Caso de Uso</th>
<th class="pb-2 px-4">Estado</th>
<th class="pb-2 px-4">Prioridad</th>
</tr>
</thead>
<tbody class="text-on-surface">
<tr class="bg-surface-container-lowest rounded-lg">
<td class="py-3 px-4 rounded-l-lg font-mono">CU-GC-01</td>
<td class="py-3 px-4">Registro de Lote con Geo-referenciación</td>
<td class="py-3 px-4"><span class="bg-primary-fixed text-on-primary-fixed px-2 py-1 rounded text-xs font-bold uppercase">Validado</span></td>
<td class="py-3 px-4 rounded-r-lg font-medium">Alta</td>
</tr>
<tr class="bg-surface-container-lowest rounded-lg">
<td class="py-3 px-4 rounded-l-lg font-mono">CU-GC-02</td>
<td class="py-3 px-4">Monitoreo Satelital de Salud Vegetal</td>
<td class="py-3 px-4"><span class="bg-secondary-container text-on-secondary-container px-2 py-1 rounded text-xs font-bold uppercase">En Pruebas</span></td>
<td class="py-3 px-4 rounded-r-lg font-medium">Media</td>
</tr>
</tbody>
</table>
</div>
</section>
<!-- Sección A: Filtros -->
<section class="grid grid-cols-1 md:grid-cols-4 gap-6 mb-8 items-end bg-surface-container p-6 rounded-2xl">
<div class="space-y-2">
<label class="text-xs font-bold uppercase text-on-surface-variant px-1">Buscar Lote</label>
<div class="relative">
<span class="material-symbols-outlined absolute left-3 top-1/2 -translate-y-1/2 text-on-surface-variant">search</span>
<input class="w-full pl-10 pr-4 py-3 bg-surface-container-highest border-none rounded-xl focus:ring-2 focus:ring-surface-tint/30 text-sm" placeholder="Ej: Lote 12..." type="text"/>
</div>
</div>
<div class="space-y-2">
<label class="text-xs font-bold uppercase text-on-surface-variant px-1">Estado</label>
<select class="w-full px-4 py-3 bg-surface-container-highest border-none rounded-xl focus:ring-2 focus:ring-surface-tint/30 text-sm appearance-none">
<option>Todos los estados</option>
<option>Activo</option>
<option>En Cosecha</option>
<option>Archivado</option>
</select>
</div>
<div class="space-y-2">
<label class="text-xs font-bold uppercase text-on-surface-variant px-1">Tipo Cultivo</label>
<select class="w-full px-4 py-3 bg-surface-container-highest border-none rounded-xl focus:ring-2 focus:ring-surface-tint/30 text-sm appearance-none">
<option>Seleccionar tipo</option>
<option>Maíz</option>
<option>Yuca</option>
<option>Plátano</option>
</select>
</div>
<div class="flex gap-2">
<button class="flex-1 bg-primary text-on-primary font-bold py-3 px-4 rounded-xl active:scale-95 duration-150">Registrar</button>
<button class="flex-1 border border-outline-variant/30 text-primary font-bold py-3 px-4 rounded-xl hover:bg-surface-container-highest transition-colors active:scale-95 duration-150">Limpiar</button>
</div>
</section>
<!-- Sección B: Tabla Principal -->
<section class="bg-surface-container-lowest rounded-3xl p-8 mb-12 shadow-sm">
<h2 class="text-2xl font-bold text-primary mb-6 tracking-tight">Inventario Global de Lotes</h2>
<div class="space-y-4">
<!-- Row 1 -->
<div class="flex items-center justify-between p-4 bg-surface-container-low rounded-2xl hover:bg-surface-container-high transition-colors">
<div class="flex items-center gap-4">
<div class="w-12 h-12 rounded-xl bg-primary-fixed flex items-center justify-center text-on-primary-fixed">
<span class="material-symbols-outlined">grass</span>
</div>
<div>
<h4 class="font-bold text-on-surface">Lote 01 - Maíz Híbrido</h4>
<p class="text-xs text-on-surface-variant uppercase font-medium">Hectáreas: 4.5 | Siembra: 12/03/2024</p>
</div>
</div>
<div class="flex items-center gap-8">
<span class="bg-primary-fixed text-on-primary-fixed px-3 py-1 rounded-full text-[10px] font-black uppercase tracking-wider">Activo</span>
<div class="flex gap-2">
<button class="p-2 text-on-surface-variant hover:text-primary transition-colors"><span class="material-symbols-outlined">edit</span></button>
<button class="p-2 text-on-surface-variant hover:text-error transition-colors"><span class="material-symbols-outlined">delete</span></button>
</div>
</div>
</div>
<!-- Row 2 -->
<div class="flex items-center justify-between p-4 bg-surface-container-low rounded-2xl hover:bg-surface-container-high transition-colors">
<div class="flex items-center gap-4">
<div class="w-12 h-12 rounded-xl bg-tertiary-fixed flex items-center justify-center text-on-tertiary-fixed">
<span class="material-symbols-outlined">potted_plant</span>
</div>
<div>
<h4 class="font-bold text-on-surface">Lote 12 - Yuca Regional</h4>
<p class="text-xs text-on-surface-variant uppercase font-medium">Hectáreas: 2.0 | Siembra: 05/01/2024</p>
</div>
</div>
<div class="flex items-center gap-8">
<span class="bg-secondary-container text-on-secondary-container px-3 py-1 rounded-full text-[10px] font-black uppercase tracking-wider">Cosechando</span>
<div class="flex gap-2">
<button class="p-2 text-on-surface-variant hover:text-primary transition-colors"><span class="material-symbols-outlined">edit</span></button>
<button class="p-2 text-on-surface-variant hover:text-error transition-colors"><span class="material-symbols-outlined">delete</span></button>
</div>
</div>
</div>
<!-- Row 3 (Archivado) -->
<div class="flex items-center justify-between p-4 bg-surface-dim/20 rounded-2xl opacity-70">
<div class="flex items-center gap-4">
<div class="w-12 h-12 rounded-xl bg-outline-variant flex items-center justify-center text-on-surface-variant">
<span class="material-symbols-outlined">park</span>
</div>
<div>
<h4 class="font-bold text-on-surface">Lote 05 - Plátano Hartón</h4>
<p class="text-xs text-on-surface-variant uppercase font-medium">Hectáreas: 1.5 | Cierre: 20/12/2023</p>
</div>
</div>
<div class="flex items-center gap-8">
<span class="bg-outline text-on-surface-variant bg-surface-variant px-3 py-1 rounded-full text-[10px] font-black uppercase tracking-wider">Archivado</span>
<div class="flex gap-2">
<button class="p-2 text-on-surface-variant hover:text-primary transition-colors"><span class="material-symbols-outlined">restore_from_trash</span></button>
</div>
</div>
</div>
</div>
</section>
<!-- Grid C-D: Panel de Detalle y Confirmación -->
<div class="grid grid-cols-1 lg:grid-cols-2 gap-8 mb-12">
<!-- Panel C: Detalle -->
<div class="bg-surface-container-low p-8 rounded-3xl flex flex-col gap-6">
<h3 class="text-lg font-bold text-[#0c6440] border-l-4 border-[#0c6440] pl-4 uppercase tracking-tighter">Detalle Técnico del Lote</h3>
<div class="grid grid-cols-2 gap-6">
<div class="space-y-1">
<p class="text-[10px] font-bold text-on-surface-variant uppercase tracking-widest">Ubicación Geo-referencial</p>
<p class="text-on-surface font-medium">Coordenadas: 4.5709° N, 74.2973° W</p>
</div>
<div class="space-y-1">
<p class="text-[10px] font-bold text-on-surface-variant uppercase tracking-widest">Estado Hidrológico</p>
<div class="flex items-center gap-2">
<div class="w-full bg-surface-variant rounded-full h-2">
<div class="bg-primary h-2 rounded-full" style="width: 75%"></div>
</div>
<span class="text-xs font-bold text-primary">75%</span>
</div>
</div>
</div>
<div class="space-y-2">
<p class="text-[10px] font-bold text-on-surface-variant uppercase tracking-widest">Observaciones del Agrónomo</p>
<div class="bg-surface-container-lowest p-4 rounded-xl italic text-sm text-on-surface-variant border-l-2 border-primary-fixed-dim">
                            "Se observa estrés hídrico moderado en el sector Noroeste. Programar riego suplementario para la próxima ventana de 24 horas."
                        </div>
</div>
</div>
<!-- Panel D: Confirmación de Eliminación -->
<div class="bg-error-container/30 border-2 border-dashed border-error/20 p-8 rounded-3xl flex flex-col justify-center items-center text-center">
<span class="material-symbols-outlined text-error text-4xl mb-4" style="font-variation-settings: 'FILL' 1;">warning</span>
<h3 class="text-xl font-bold text-on-error-container mb-2">¿Confirmar Eliminación Técnica?</h3>
<p class="text-sm text-on-error-container/80 max-w-sm mb-6">
                        Esta acción purgará los registros históricos de sensores y satélites asociados al Lote 12. Esta operación es irreversible en el ledger principal.
                    </p>
<div class="flex gap-4 w-full max-w-xs">
<button class="flex-1 bg-error text-on-error font-bold py-3 rounded-xl active:scale-95 duration-150">Confirmar</button>
<button class="flex-1 bg-surface-container-lowest text-on-surface font-bold py-3 rounded-xl active:scale-95 duration-150">Cancelar</button>
</div>
</div>
</div>
<!-- Grid E-F: Salud y Registro -->
<div class="grid grid-cols-1 lg:grid-cols-5 gap-8">
<!-- Panel E: Gráfico de Salud -->
<div class="lg:col-span-2 bg-surface-container-lowest p-8 rounded-3xl shadow-sm">
<h3 class="text-lg font-bold text-primary mb-6">Salud Vegetal Histórica (NDVI)</h3>
<div class="h-64 flex items-end gap-2 px-4 border-b border-l border-outline-variant/30">
<!-- Simulated Chart -->
<div class="flex-1 bg-primary-fixed-dim rounded-t-lg transition-all hover:bg-primary-container" style="height: 40%"></div>
<div class="flex-1 bg-primary-fixed-dim rounded-t-lg transition-all hover:bg-primary-container" style="height: 55%"></div>
<div class="flex-1 bg-primary-fixed-dim rounded-t-lg transition-all hover:bg-primary-container" style="height: 80%"></div>
<div class="flex-1 bg-primary-fixed-dim rounded-t-lg transition-all hover:bg-primary-container" style="height: 70%"></div>
<div class="flex-1 bg-primary-fixed-dim rounded-t-lg transition-all hover:bg-primary-container" style="height: 90%"></div>
<div class="flex-1 bg-primary-fixed-dim rounded-t-lg transition-all hover:bg-primary-container" style="height: 85%"></div>
</div>
<div class="flex justify-between mt-4 text-[10px] font-bold text-on-surface-variant uppercase tracking-widest">
<span>Ene</span><span>Feb</span><span>Mar</span><span>Abr</span><span>May</span><span>Jun</span>
</div>
</div>
<!-- Panel F: Formulario Técnico -->
<div class="lg:col-span-3 bg-surface-container-high p-8 rounded-3xl">
<h3 class="text-lg font-bold text-primary mb-8 flex items-center gap-2">
<span class="material-symbols-outlined">edit_document</span>
                        Registro de Nuevo Lote Operativo
                    </h3>
<form class="grid grid-cols-1 md:grid-cols-2 gap-6">
<div class="space-y-2">
<label class="text-xs font-bold uppercase text-on-surface-variant">Identificador del Lote</label>
<input class="w-full px-4 py-3 bg-surface-container-lowest border-none rounded-xl focus:ring-2 focus:ring-surface-tint/30" placeholder="Ej: LOTE-NORTH-101" type="text"/>
</div>
<div class="space-y-2">
<label class="text-xs font-bold uppercase text-on-surface-variant">Variedad de Cultivo</label>
<select class="w-full px-4 py-3 bg-surface-container-lowest border-none rounded-xl focus:ring-2 focus:ring-surface-tint/30">
<option>Maíz Amarillo</option>
<option>Yuca Blanca</option>
</select>
</div>
<div class="space-y-2">
<label class="text-xs font-bold uppercase text-on-surface-variant">Área Total (Ha)</label>
<input class="w-full px-4 py-3 bg-surface-container-lowest border-none rounded-xl focus:ring-2 focus:ring-surface-tint/30" step="0.1" type="number"/>
</div>
<div class="space-y-2">
<label class="text-xs font-bold uppercase text-on-surface-variant">Fecha de Siembra Proyectada</label>
<input class="w-full px-4 py-3 bg-surface-container-lowest border-none rounded-xl focus:ring-2 focus:ring-surface-tint/30" type="date"/>
</div>
<div class="md:col-span-2 space-y-2">
<label class="text-xs font-bold uppercase text-on-surface-variant">Adjuntos Técnicos (Planos/Suelo)</label>
<div class="border-2 border-dashed border-outline-variant/50 rounded-2xl p-8 flex flex-col items-center justify-center bg-surface-container-lowest cursor-pointer hover:bg-primary-fixed/10 transition-colors">
<span class="material-symbols-outlined text-primary-container text-3xl mb-2">cloud_upload</span>
<p class="text-sm text-on-surface-variant">Arrastre archivos o <span class="text-primary font-bold">explore su equipo</span></p>
<p class="text-[10px] text-on-surface-variant/60 uppercase mt-1">Soporta PDF, JPG, GeoJSON (Max 10MB)</p>
</div>
</div>
<div class="md:col-span-2 flex justify-end gap-4 mt-4">
<button class="px-8 py-3 rounded-xl font-bold border border-outline-variant/30 text-on-surface-variant active:scale-95 duration-150" type="button">Guardar Borrador</button>
<button class="px-12 py-3 rounded-xl font-bold bg-primary text-on-primary shadow-lg shadow-primary/20 active:scale-95 duration-150" type="submit">Confirmar Registro</button>
</div>
</form>
</div>
</div>
<!-- Nota Final: Contrato Visual -->
<footer class="mt-16 pt-8 border-t border-outline-variant/20 flex flex-col md:flex-row justify-between items-center gap-4">
<div class="flex items-center gap-2">
<span class="material-symbols-outlined text-primary text-sm">verified_user</span>
<p class="text-xs font-medium text-on-surface-variant">Contrato visual validado - Sistema Ceres 2024. Operaciones encriptadas bajo protocolo AgroNode.</p>
</div>
<div class="flex gap-4 text-[10px] font-bold text-on-surface-variant uppercase tracking-widest">
<a class="hover:text-primary transition-colors" href="#">Términos Legales</a>
<a class="hover:text-primary transition-colors" href="#">Soporte Técnico</a>
<a class="hover:text-primary transition-colors" href="#">API Agrónomo</a>
</div>
</footer>
</main>
</div>
</body></html>
```

---

## Shell / Layout Estándar

**Componente React sugerido:** `ShellView`  
**Archivo:** `views/06-shell-estandar.jsx`

### Descripción funcional
Wireframe base que define la estructura reutilizable: TopNavBar, SideNavBar, área de contenido y footer.

### HTML Fuente

```html
<!DOCTYPE html>

<html class="light" lang="es"><head>
<meta charset="utf-8"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<title>Wireframe funcional - Shell Estándar AgroInteligente</title>
<link href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@300;400;500;600;700;800&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script>
<script id="tailwind-config">
        tailwind.config = {
            darkMode: "class",
            theme: {
                extend: {
                    "colors": {
                        "secondary": "#895200",
                        "primary-container": "#2f7d57",
                        "inverse-on-surface": "#e7f4ed",
                        "on-tertiary-fixed": "#002112",
                        "primary-fixed": "#a4f3c5",
                        "surface": "#effcf5",
                        "on-secondary-container": "#6e4100",
                        "surface-container-lowest": "#ffffff",
                        "error": "#ba1a1a",
                        "error-container": "#ffdad6",
                        "on-error-container": "#93000a",
                        "inverse-surface": "#27332e",
                        "surface-container-low": "#eaf7f0",
                        "primary": "#0c6440",
                        "tertiary-fixed-dim": "#a6d0b5",
                        "on-primary-container": "#d0ffe0",
                        "secondary-fixed-dim": "#ffb86a",
                        "on-tertiary-fixed-variant": "#284e3a",
                        "surface-variant": "#d9e5df",
                        "surface-container-highest": "#d9e5df",
                        "on-background": "#131e1a",
                        "tertiary-container": "#517861",
                        "surface-bright": "#effcf5",
                        "tertiary-fixed": "#c2edd0",
                        "primary-fixed-dim": "#89d7aa",
                        "secondary-fixed": "#ffdcbc",
                        "surface-tint": "#196b47",
                        "on-tertiary-container": "#d3ffe2",
                        "outline-variant": "#bfc9c0",
                        "on-surface": "#131e1a",
                        "inverse-primary": "#89d7aa",
                        "surface-container": "#e4f1ea",
                        "on-primary-fixed-variant": "#005233",
                        "surface-container-high": "#deebe4",
                        "tertiary": "#395f49",
                        "on-secondary-fixed": "#2c1700",
                        "secondary-container": "#fdaa47",
                        "on-surface-variant": "#3f4942",
                        "on-primary-fixed": "#002112",
                        "background": "#effcf5",
                        "on-error": "#ffffff",
                        "on-tertiary": "#ffffff",
                        "on-secondary-fixed-variant": "#683d00",
                        "outline": "#6f7a72",
                        "on-primary": "#ffffff",
                        "on-secondary": "#ffffff",
                        "surface-dim": "#d0ddd6"
                    },
                    "borderRadius": {
                        "DEFAULT": "0.25rem",
                        "lg": "0.5rem",
                        "xl": "0.75rem",
                        "full": "9999px"
                    },
                    "fontFamily": {
                        "headline": ["Public Sans"],
                        "body": ["Public Sans"],
                        "label": ["Public Sans"]
                    }
                },
            },
        }
    </script>
<style>
        body { font-family: 'Public Sans', sans-serif; background-color: #effcf5; }
        .material-symbols-outlined { font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24; }
        .glass-panel { background: rgba(255, 255, 255, 0.8); backdrop-filter: blur(24px); }
    </style>
</head>
<body class="text-on-surface">
<div class="fixed top-0 left-0 w-full z-50 bg-[#effcf5] flex items-center justify-between px-8 py-2 border-b border-outline-variant/10">
<div>
<h1 class="text-xs font-bold text-primary tracking-widest uppercase">Wireframe funcional</h1>
<p class="text-xs text-on-surface-variant font-medium">Shell Estándar AgroInteligente - Estructura base</p>
</div>
<div class="flex gap-4">
<span class="text-[10px] bg-primary-fixed text-on-primary-fixed px-2 py-0.5 rounded-full font-bold">V 1.0</span>
</div>
</div>
<header class="fixed top-10 left-0 w-full z-40 shadow-[0px_20px_40px_rgba(19,30,26,0.06)] bg-[#effcf5] flex justify-between items-center px-8 py-4">
<div class="flex items-center gap-8">
<div class="text-xl font-bold tracking-tight text-[#0c6440]">AgroInteligente</div>
<div class="h-8 w-px bg-outline-variant/30"></div>
<div>
<div class="text-sm font-bold text-on-surface">Módulo: Gestión de Perfil</div>
<div class="text-[11px] text-on-surface-variant font-medium">Productor Agrícola</div>
</div>
</div>
<nav class="hidden md:flex gap-6 items-center">
<a class="text-[#3f4942] font-medium hover:text-[#0c6440] transition-colors text-sm" href="#">Dashboard</a>
<a class="text-[#3f4942] font-medium hover:text-[#0c6440] transition-colors text-sm" href="#">Cultivos</a>
<a class="text-[#3f4942] font-medium hover:text-[#0c6440] transition-colors text-sm" href="#">Insumos</a>
<a class="text-[#3f4942] font-medium hover:text-[#0c6440] transition-colors text-sm" href="#">Recomendaciones</a>
<a class="text-[#0c6440] border-b-2 border-[#0c6440] pb-1 font-bold text-sm" href="#">Perfil</a>
<a class="text-[#3f4942] font-medium hover:text-[#0c6440] transition-colors text-sm" href="#">Reportes</a>
</nav>
<div class="flex items-center gap-4">
<button class="p-2 rounded-full hover:bg-surface-container transition-colors text-on-surface-variant">
<span class="material-symbols-outlined" data-icon="notifications">notifications</span>
</button>
<button class="p-2 rounded-full hover:bg-surface-container transition-colors text-on-surface-variant">
<span class="material-symbols-outlined" data-icon="settings">settings</span>
</button>
<div class="w-10 h-10 rounded-full bg-primary-container overflow-hidden ring-2 ring-primary-fixed">
<img alt="User" class="w-full h-full object-cover" data-alt="portrait of a confident farmer in a green field wearing a denim shirt and smiling warm professional lighting" src="https://lh3.googleusercontent.com/aida-public/AB6AXuDySJ-QnRS90ZYqqItBZnub6FPun3n9alt4OjshTxROhbpAeT-33FWlvocZiEaaaytg7ZIh6NHXW30SED4QAUixcF61v2yXvbRCMmzcAN_urnPwYDZ4HlFuO84pJyShSgihs6JfOaXP7NRvjxZ25CBYIL4rMH46DyX2SQJk2K5CvLqje9W1Ol7KWZMb9_TlD8PJUIvkv7hb9vGMZJG6VTZnS9mzaWL1aPGaL-fk_LHxh8Mgrfpp2d-eb9swOdMOnTwlXHANVl4RkBg"/>
</div>
</div>
</header>
<div class="flex pt-32 min-h-screen">
<aside class="fixed left-0 top-32 h-[calc(100vh-128px)] w-64 p-6 flex flex-col gap-8 bg-[#eaf7f0] border-r border-outline-variant/10 overflow-y-auto">
<div>
<h3 class="text-xs font-bold uppercase tracking-widest text-on-surface-variant mb-4">Navegación del módulo</h3>
<div class="flex flex-col gap-1">
<a class="flex items-center gap-3 text-[#3f4942] px-4 py-3 hover:bg-[#d9e5df] rounded-lg transition-all text-sm font-medium" href="#">
<span class="material-symbols-outlined text-lg" data-icon="person_add">person_add</span>
                        Crear perfil
                    </a>
<a class="flex items-center gap-3 bg-[#d9e5df] text-[#0c6440] px-4 py-3 rounded-lg font-bold text-sm" href="#">
<span class="material-symbols-outlined text-lg" data-icon="account_circle" style="font-variation-settings: 'FILL' 1;">account_circle</span>
                        Consultar perfil
                    </a>
<a class="flex items-center gap-3 text-[#3f4942] px-4 py-3 hover:bg-[#d9e5df] rounded-lg transition-all text-sm font-medium" href="#">
<span class="material-symbols-outlined text-lg" data-icon="edit_square">edit_square</span>
                        Actualizar datos
                    </a>
<a class="flex items-center gap-3 text-[#3f4942] px-4 py-3 hover:bg-[#d9e5df] rounded-lg transition-all text-sm font-medium" href="#">
<span class="material-symbols-outlined text-lg" data-icon="lock">lock</span>
                        Cambiar contraseña
                    </a>
<a class="flex items-center gap-3 text-[#3f4942] px-4 py-3 hover:bg-[#d9e5df] rounded-lg transition-all text-sm font-medium" href="#">
<span class="material-symbols-outlined text-lg" data-icon="tune">tune</span>
                        Preferencias
                    </a>
</div>
</div>
<div class="mt-auto bg-surface-container-highest p-5 rounded-2xl">
<div class="flex items-center justify-between mb-2">
<span class="text-[10px] font-bold text-primary tracking-widest uppercase">Estatus</span>
<span class="text-xs font-bold text-primary">85%</span>
</div>
<div class="h-2 w-full bg-surface-container-low rounded-full overflow-hidden mb-3">
<div class="h-full bg-primary w-[85%] rounded-full"></div>
</div>
<p class="text-[11px] text-on-surface-variant leading-tight">Tu perfil de <strong>Gestionar Perfil</strong> está casi completo. Solo faltan las preferencias de riego.</p>
</div>
</aside>
<main class="ml-64 flex-1 p-8 pb-24">
<section class="max-w-6xl mx-auto space-y-12">
<div class="bg-surface-container-low rounded-3xl p-8 border border-outline-variant/10 shadow-sm">
<div class="flex items-center gap-4 mb-6">
<div class="p-3 bg-primary/10 rounded-xl">
<span class="material-symbols-outlined text-primary" data-icon="fact_check">fact_check</span>
</div>
<h2 class="text-xl font-bold">Cobertura de Casos de Uso (Sección 0)</h2>
</div>
<div class="overflow-x-auto">
<table class="w-full text-left border-separate border-spacing-y-2">
<thead>
<tr class="text-xs text-on-surface-variant font-bold uppercase tracking-wider">
<th class="px-4 py-2">Caso de Uso</th>
<th class="px-4 py-2">Evidencia / Componente</th>
<th class="px-4 py-2">Estado</th>
</tr>
</thead>
<tbody>
<tr class="bg-surface-container-lowest rounded-xl">
<td class="px-4 py-4 font-medium text-sm rounded-l-xl">Crear/Consultar Perfil</td>
<td class="px-4 py-4 text-sm text-on-surface-variant">Sección B: Resumen de perfil y Header</td>
<td class="px-4 py-4 rounded-r-xl"><span class="bg-primary-fixed text-on-primary-fixed text-[10px] px-2 py-1 rounded-full font-bold">VERIFICADO</span></td>
</tr>
<tr class="bg-surface-container-lowest rounded-xl">
<td class="px-4 py-4 font-medium text-sm rounded-l-xl">Actualizar Datos</td>
<td class="px-4 py-4 text-sm text-on-surface-variant">Sección A: Formulario de datos con validación</td>
<td class="px-4 py-4 rounded-r-xl"><span class="bg-primary-fixed text-on-primary-fixed text-[10px] px-2 py-1 rounded-full font-bold">VERIFICADO</span></td>
</tr>
<tr class="bg-surface-container-lowest rounded-xl">
<td class="px-4 py-4 font-medium text-sm rounded-l-xl">Cambiar Contraseña</td>
<td class="px-4 py-4 text-sm text-on-surface-variant">Sección C: Seguridad de cuenta</td>
<td class="px-4 py-4 rounded-r-xl"><span class="bg-primary-fixed text-on-primary-fixed text-[10px] px-2 py-1 rounded-full font-bold">VERIFICADO</span></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="grid grid-cols-1 lg:grid-cols-12 gap-8 items-start">
<div class="lg:col-span-4 space-y-8">
<div class="bg-surface-container-highest p-8 rounded-[2.5rem] relative overflow-hidden group">
<div class="absolute -top-12 -right-12 w-48 h-48 bg-primary/5 rounded-full blur-3xl group-hover:bg-primary/10 transition-all"></div>
<div class="relative z-10 flex flex-col items-center text-center">
<div class="w-24 h-24 rounded-3xl bg-surface-container-lowest shadow-xl p-1 mb-6 rotate-3">
<img alt="Profile" class="w-full h-full object-cover rounded-[1.25rem]" data-alt="close up professional headshot of a middle aged agricultural expert with sun-kissed skin and friendly expression" src="https://lh3.googleusercontent.com/aida-public/AB6AXuDSACf5ljMVZrWyZK1YeRYPtHn8FuK5GgoD8I22pKz7eHJai261aZI8md91TIOzRYnTFelcaXNqMaOEIetOOfeftyc3Qy0payjs5L8D3Ym9AtoZnUfaSarL5exl1BzK_pOke2BWmWrHKsDZLDZ8XdMdUuVwQni-9xsDA3BDgcfMPtn-nBt1iSownbKbbpVL4MG_9_QmvUpZaZUDbop63LJdOXTAOM-sbwFPCkWdRFGA28n-IxcQLl0DUeuHUztszA8SE7O2CHbJSyY"/>
</div>
<h3 class="text-xl font-extrabold text-primary mb-1">Mateo Rodríguez</h3>
<p class="text-sm text-on-surface-variant mb-6">ID Productor: #AG-99021</p>
<div class="w-full space-y-4">
<div class="flex justify-between items-center px-4 py-3 bg-surface-container-low rounded-2xl">
<span class="text-xs font-bold text-on-surface-variant">Ubicación</span>
<span class="text-xs font-medium">Valle del Cauca, COL</span>
</div>
<div class="flex justify-between items-center px-4 py-3 bg-surface-container-low rounded-2xl">
<span class="text-xs font-bold text-on-surface-variant">Último acceso</span>
<span class="text-xs font-medium">Hace 2 horas</span>
</div>
</div>
</div>
</div>
<div class="bg-surface-container p-8 rounded-[2.5rem]">
<h4 class="text-sm font-bold uppercase tracking-widest text-on-surface-variant mb-6">Preferencias (Sección D)</h4>
<div class="space-y-6">
<div class="flex items-center justify-between">
<div class="flex items-center gap-3">
<span class="material-symbols-outlined text-primary" data-icon="language">language</span>
<span class="text-sm font-medium">Idioma</span>
</div>
<span class="text-xs font-bold text-primary">Español</span>
</div>
<div class="h-px bg-outline-variant/20"></div>
<div class="flex items-center justify-between">
<div class="flex items-center gap-3">
<span class="material-symbols-outlined text-primary" data-icon="notifications_active">notifications_active</span>
<span class="text-sm font-medium">Notificaciones App</span>
</div>
<div class="w-10 h-6 bg-primary rounded-full flex items-center px-1">
<div class="w-4 h-4 bg-white rounded-full ml-auto"></div>
</div>
</div>
<div class="flex items-center justify-between">
<div class="flex items-center gap-3">
<span class="material-symbols-outlined text-primary" data-icon="mail">mail</span>
<span class="text-sm font-medium">Reportes Semanales</span>
</div>
<div class="w-10 h-6 bg-surface-variant rounded-full flex items-center px-1">
<div class="w-4 h-4 bg-white rounded-full"></div>
</div>
</div>
</div>
</div>
</div>
<div class="lg:col-span-8 space-y-8">
<div class="bg-surface-container-lowest p-10 rounded-[2.5rem] shadow-sm border border-outline-variant/10">
<div class="flex items-center justify-between mb-10">
<div>
<h2 class="text-2xl font-bold tracking-tight mb-1">Datos del Usuario (Sección A)</h2>
<p class="text-sm text-on-surface-variant">Actualiza la información básica de tu perfil agrícola.</p>
</div>
<span class="bg-primary/5 text-primary text-[10px] font-extrabold px-3 py-1 rounded-full uppercase tracking-tighter">Editando</span>
</div>
<form class="grid grid-cols-1 md:grid-cols-2 gap-x-8 gap-y-6">
<div class="flex flex-col gap-2">
<label class="text-xs font-bold text-on-surface-variant uppercase tracking-wider ml-1">Nombre Completo</label>
<input class="bg-surface-container-highest border-none rounded-xl px-4 py-3 focus:ring-2 focus:ring-surface-tint/30 text-sm font-medium" type="text" value="Mateo Rodríguez"/>
</div>
<div class="flex flex-col gap-2">
<label class="text-xs font-bold text-on-surface-variant uppercase tracking-wider ml-1">Teléfono de contacto</label>
<div class="relative">
<input class="w-full bg-surface-container-highest border-none rounded-xl px-4 py-3 focus:ring-2 focus:ring-surface-tint/30 text-sm font-medium" type="tel" value="+57 300 123 4567"/>
<span class="absolute right-4 top-1/2 -translate-y-1/2 material-symbols-outlined text-primary text-sm" data-icon="check_circle">check_circle</span>
</div>
</div>
<div class="flex flex-col gap-2 md:col-span-2">
<label class="text-xs font-bold text-on-surface-variant uppercase tracking-wider ml-1">Ubicación de la Finca</label>
<input class="bg-surface-container-highest border-none rounded-xl px-4 py-3 focus:ring-2 focus:ring-surface-tint/30 text-sm font-medium" placeholder="Ej. Km 4 Vía Palmira, Hacienda La Esperanza" type="text"/>
</div>
<div class="md:col-span-2 mt-4 p-6 border-2 border-dashed border-outline-variant rounded-2xl flex flex-col items-center justify-center gap-2 hover:bg-surface-container-low transition-colors cursor-pointer">
<span class="material-symbols-outlined text-primary-container text-3xl" data-icon="cloud_upload">cloud_upload</span>
<p class="text-xs font-bold text-on-surface">Subir nueva foto de perfil</p>
<p class="text-[10px] text-on-surface-variant">Formato JPG o PNG, máximo 5MB.</p>
</div>
<div class="md:col-span-2 flex justify-end mt-4">
<button class="bg-gradient-to-br from-primary to-primary-container text-white px-8 py-3.5 rounded-xl font-bold shadow-lg shadow-primary/20 active:scale-95 transition-transform flex items-center gap-2">
<span class="material-symbols-outlined text-sm" data-icon="save">save</span>
                                        Guardar cambios
                                    </button>
</div>
</form>
</div>
<div class="bg-surface-container-lowest p-10 rounded-[2.5rem] shadow-sm border border-outline-variant/10">
<div class="flex items-center gap-4 mb-8">
<div class="p-3 bg-secondary/10 rounded-xl">
<span class="material-symbols-outlined text-secondary" data-icon="security">security</span>
</div>
<div>
<h2 class="text-xl font-bold mb-0.5">Seguridad de la Cuenta (Sección C)</h2>
<p class="text-xs text-on-surface-variant">Protege tu acceso con una contraseña robusta.</p>
</div>
</div>
<div class="space-y-6">
<div class="grid grid-cols-1 md:grid-cols-2 gap-6">
<div class="flex flex-col gap-2">
<label class="text-xs font-bold text-on-surface-variant uppercase tracking-wider ml-1">Contraseña Actual</label>
<input class="bg-surface-container-highest border-none rounded-xl px-4 py-3 focus:ring-2 focus:ring-surface-tint/30 text-sm font-medium" type="password" value="********"/>
</div>
<div class="flex flex-col gap-2">
<label class="text-xs font-bold text-on-surface-variant uppercase tracking-wider ml-1">Nueva Contraseña</label>
<input class="bg-surface-container-highest border-none rounded-xl px-4 py-3 focus:ring-2 focus:ring-surface-tint/30 text-sm font-medium" placeholder="••••••••" type="password"/>
</div>
</div>
<div class="flex justify-between items-center p-4 bg-secondary-container/10 rounded-xl">
<div class="flex items-center gap-3">
<span class="material-symbols-outlined text-secondary" data-icon="info">info</span>
<span class="text-[11px] font-medium text-on-secondary-container">La contraseña debe tener al menos 8 caracteres y un número.</span>
</div>
<button class="text-xs font-bold text-secondary uppercase hover:underline">Actualizar clave</button>
</div>
</div>
</div>
</div>
</div>
</section>
</main>
</div>
<footer class="bg-surface-container-high px-8 py-10 mt-12 border-t border-outline-variant/20">
<div class="max-w-7xl mx-auto flex flex-col md:flex-row justify-between gap-8">
<div class="max-w-md">
<p class="text-xs font-bold text-primary tracking-widest uppercase mb-4">Contrato visual del caso de uso</p>
<p class="text-sm text-on-surface-variant leading-relaxed">
                    Este diseño unificado cubre las interacciones para crear/consultar perfil, actualizar datos, cambiar contraseña y gestionar preferencias bajo la identidad de AgroInteligente.
                </p>
</div>
<div class="bg-surface-container-highest p-6 rounded-2xl min-w-[300px]">
<p class="text-[10px] font-bold text-on-surface-variant uppercase tracking-widest mb-4">Mini Audit de cumplimiento</p>
<div class="space-y-3">
<div class="flex items-center justify-between text-[11px]">
<span class="font-medium text-on-surface">Shell base definido</span>
<span class="flex items-center gap-1 text-primary font-bold"><span class="material-symbols-outlined text-xs" data-icon="done">done</span> Sí</span>
</div>
<div class="flex items-center justify-between text-[11px]">
<span class="font-medium text-on-surface">Nombre AgroInteligente aplicado</span>
<span class="flex items-center gap-1 text-primary font-bold"><span class="material-symbols-outlined text-xs" data-icon="done">done</span> Sí</span>
</div>
<div class="flex items-center justify-between text-[11px]">
<span class="font-medium text-on-surface">Navegación superior reutilizable</span>
<span class="flex items-center gap-1 text-primary font-bold"><span class="material-symbols-outlined text-xs" data-icon="done">done</span> Sí</span>
</div>
<div class="flex items-center justify-between text-[11px]">
<span class="font-medium text-on-surface">Sidebar reutilizable</span>
<span class="flex items-center gap-1 text-primary font-bold"><span class="material-symbols-outlined text-xs" data-icon="done">done</span> Sí</span>
</div>
<div class="flex items-center justify-between text-[11px]">
<span class="font-medium text-on-surface">Solo contenido central variable</span>
<span class="flex items-center gap-1 text-primary font-bold"><span class="material-symbols-outlined text-xs" data-icon="done">done</span> Sí</span>
</div>
</div>
</div>
</div>
<div class="max-w-7xl mx-auto mt-8 pt-8 border-t border-outline-variant/20 flex justify-between items-center">
<span class="text-xs text-on-surface-variant">© 2024 AgroInteligente Platform. Todos los derechos reservados.</span>
<div class="flex gap-6">
<a class="text-xs text-on-surface-variant hover:text-primary transition-colors" href="#">Términos</a>
<a class="text-xs text-on-surface-variant hover:text-primary transition-colors" href="#">Privacidad</a>
</div>
</div>
</footer>
</body></html>
```

---

## Gestión de Perfil

**Componente React sugerido:** `PerfilView`  
**Archivo:** `views/07-gestion-perfil.jsx`

### Descripción funcional
Datos del usuario agrónomo, configuración de la finca, preferencias y seguridad de cuenta.

### Secciones identificadas
- `Frame Title Section`
- `Navigation Shell (JSON Derived)`
- `Sidebar Navigation (JSON Derived)`
- `Status Card in Sidebar`
- `Main Content Canvas`
- `Section 0: Case Study Coverage Table`
- `Grid 1: Form and Profile Summary`
- `Section A: Formulario`

### HTML Fuente

```html
<!DOCTYPE html>

<html class="light" lang="es"><head>
<meta charset="utf-8"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<title>Digital Cultivator - Gestión de Perfil</title>
<script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script>
<link href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@300;400;500;600;700;800;900&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<script id="tailwind-config">
        tailwind.config = {
          darkMode: "class",
          theme: {
            extend: {
              "colors": {
                      "secondary-container": "#fdaa47",
                      "primary-fixed": "#a4f3c5",
                      "surface-dim": "#d0ddd6",
                      "tertiary-fixed-dim": "#a6d0b5",
                      "surface-bright": "#effcf5",
                      "on-primary-container": "#d0ffe0",
                      "secondary-fixed-dim": "#ffb86a",
                      "on-tertiary-fixed-variant": "#284e3a",
                      "tertiary": "#395f49",
                      "primary-container": "#2f7d57",
                      "on-background": "#131e1a",
                      "on-error": "#ffffff",
                      "error": "#ba1a1a",
                      "surface-container-high": "#deebe4",
                      "primary": "#0c6440",
                      "on-tertiary-fixed": "#002112",
                      "inverse-surface": "#27332e",
                      "surface-container-lowest": "#ffffff",
                      "on-secondary-fixed-variant": "#683d00",
                      "primary-fixed-dim": "#89d7aa",
                      "outline": "#6f7a72",
                      "on-error-container": "#93000a",
                      "outline-variant": "#bfc9c0",
                      "error-container": "#ffdad6",
                      "tertiary-fixed": "#c2edd0",
                      "surface-container-low": "#eaf7f0",
                      "inverse-on-surface": "#e7f4ed",
                      "surface": "#effcf5",
                      "secondary": "#895200",
                      "surface-variant": "#d9e5df",
                      "secondary-fixed": "#ffdcbc",
                      "surface-container-highest": "#d9e5df",
                      "on-primary": "#ffffff",
                      "on-surface": "#131e1a",
                      "on-tertiary-container": "#d3ffe2",
                      "on-primary-fixed-variant": "#005233",
                      "on-tertiary": "#ffffff",
                      "on-secondary-container": "#6e4100",
                      "on-secondary": "#ffffff",
                      "on-secondary-fixed": "#2c1700",
                      "background": "#effcf5",
                      "on-surface-variant": "#3f4942",
                      "surface-container": "#e4f1ea",
                      "surface-tint": "#196b47",
                      "inverse-primary": "#89d7aa",
                      "tertiary-container": "#517861",
                      "on-primary-fixed": "#002112"
              },
              "borderRadius": {
                      "DEFAULT": "0.25rem",
                      "lg": "0.5rem",
                      "xl": "0.75rem",
                      "full": "9999px"
              },
              "fontFamily": {
                      "headline": ["Public Sans"],
                      "body": ["Public Sans"],
                      "label": ["Public Sans"]
              }
            },
          }
        }
    </script>
<style>
        body { font-family: 'Public Sans', sans-serif; }
        .material-symbols-outlined {
            font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24;
        }
        .editorial-shadow { box-shadow: 0px 20px 40px rgba(19, 30, 26, 0.06); }
        .no-scrollbar::-webkit-scrollbar { display: none; }
    </style>
</head>
<body class="bg-background text-on-surface">
<!-- Frame Title Section -->
<div class="w-full bg-primary text-on-primary px-8 py-4 flex flex-col md:flex-row justify-between items-start md:items-center gap-2">
<div>
<h1 class="text-label-md font-bold tracking-widest uppercase opacity-80">Wireframe funcional - Caso de uso nivel 1: Gestionar Perfil</h1>
<p class="text-body-sm font-light italic">Estructura técnica para crear, consultar y actualizar perfil del productor/operario</p>
</div>
<div class="bg-primary-container px-3 py-1 rounded-full text-xs font-medium">Technical Specification v1.0</div>
</div>
<!-- Navigation Shell (JSON Derived) -->
<header class="sticky top-0 z-50 bg-[#effcf5]/80 backdrop-blur-md shadow-[0px_20px_40px_rgba(19,30,26,0.06)] flex justify-between items-center w-full px-8 md:px-16 py-4">
<div class="flex items-center gap-8">
<div class="text-2xl font-bold tracking-tight text-[#0c6440] flex items-center gap-2">
<span class="material-symbols-outlined text-3xl" style="font-variation-settings: 'FILL' 1;">eco</span>
                AgroInteligente
            </div>
<nav class="hidden md:flex items-center gap-8 ml-8">
<a class="text-[#3f4942] hover:bg-[#d9e5df] transition-colors px-3 py-1 rounded" href="#">Dashboard</a>
<a class="text-[#3f4942] hover:bg-[#d9e5df] transition-colors px-3 py-1 rounded" href="#">Cultivos</a>
<a class="text-[#3f4942] hover:bg-[#d9e5df] transition-colors px-3 py-1 rounded" href="#">Insumos</a>
<a class="text-[#3f4942] hover:bg-[#d9e5df] transition-colors px-3 py-1 rounded" href="#">Recomendaciones</a>
<a class="text-[#0c6440] font-bold border-b-2 border-[#0c6440] px-3 py-1" href="#">Perfil</a>
</nav>
</div>
<div class="flex items-center gap-6">
<div class="hidden lg:flex flex-col text-right">
<span class="text-on-surface font-bold text-sm">Módulo Gestión de Perfil</span>
<span class="text-on-surface-variant text-xs">Productor Agrícola / Operario de Campo</span>
</div>
<div class="flex gap-4 items-center">
<button class="material-symbols-outlined text-on-surface-variant hover:bg-[#d9e5df] p-2 rounded-full transition-colors">notifications</button>
<button class="material-symbols-outlined text-on-surface-variant hover:bg-[#d9e5df] p-2 rounded-full transition-colors">settings</button>
<img alt="Farmer profile photo" class="w-10 h-10 rounded-full object-cover border-2 border-primary-fixed" data-alt="professional portrait of a confident middle-aged agricultural consultant wearing a neutral linen shirt against a soft blurred greenhouse background" src="https://lh3.googleusercontent.com/aida-public/AB6AXuCC0c0KlBUSL5byexzEh7dK6l5wHnQUOJP3pBG9Rt2-2t_eF1e-cBF-KvHUCtN_aP3uIjseDdPv43n4f3Pbz7S6t9vTTQQ2iHBLW8P-iZHOC_SyQbll7ENQar4PFJh9N44CVZ8ZxR890yDrZse_s99Tew8fayuweMiff6Jn3HDVar3jUgpqK0XYKAzbscXHnUmvfgUShDmmmbXNP-oI5tcOD0szjsp0HYRW0yfP7X07JvLpRbVctzKZCiEDroNn5motXf6kC6VPVmk"/>
</div>
</div>
</header>
<div class="flex flex-col md:flex-row min-h-screen">
<!-- Sidebar Navigation (JSON Derived) -->
<aside class="w-full md:w-72 bg-[#eaf7f0] flex flex-col h-auto md:h-screen sticky top-[72px] pt-8 pb-8 z-40">
<div class="px-6 mb-8">
<div class="text-xl font-black text-[#0c6440]">Cultivator Pro</div>
<div class="text-xs text-on-surface-variant opacity-70">Premium Farm Access</div>
</div>
<nav class="flex-grow">
<div class="text-[10px] uppercase tracking-widest font-bold text-on-surface-variant px-6 mb-4 opacity-50">Navegación del módulo</div>
<ul class="space-y-1">
<li><a class="flex items-center gap-3 text-[#0c6440] font-bold bg-[#d9e5df] rounded-r-full py-3 px-6 translate-x-1 transition-transform" href="#"><span class="material-symbols-outlined">person_add</span>Crear perfil</a></li>
<li><a class="flex items-center gap-3 text-[#3f4942] hover:bg-[#d9e5df]/50 py-3 px-6" href="#"><span class="material-symbols-outlined">visibility</span>Consultar perfil</a></li>
<li><a class="flex items-center gap-3 text-[#3f4942] hover:bg-[#d9e5df]/50 py-3 px-6" href="#"><span class="material-symbols-outlined">edit_square</span>Actualizar datos</a></li>
<li><a class="flex items-center gap-3 text-[#3f4942] hover:bg-[#d9e5df]/50 py-3 px-6" href="#"><span class="material-symbols-outlined">lock_reset</span>Cambiar contraseña</a></li>
<li><a class="flex items-center gap-3 text-[#3f4942] hover:bg-[#d9e5df]/50 py-3 px-6" href="#"><span class="material-symbols-outlined">tune</span>Preferencias</a></li>
</ul>
</nav>
<!-- Status Card in Sidebar -->
<div class="mx-4 mt-8 p-5 bg-surface-container-highest rounded-xl space-y-3">
<div class="flex items-center gap-2 text-primary font-bold text-xs uppercase tracking-tight">
<span class="material-symbols-outlined text-sm">info</span>
                    Caso de Uso Principal
                </div>
<p class="text-on-surface-variant text-xs leading-relaxed">Regla: datos claros, validación y seguridad.</p>
<div class="space-y-1">
<div class="flex justify-between text-[10px] font-bold">
<span>Perfil Completo</span>
<span>85%</span>
</div>
<div class="h-1.5 w-full bg-surface-dim rounded-full overflow-hidden">
<div class="h-full bg-secondary w-[85%] rounded-full"></div>
</div>
</div>
</div>
<div class="mt-auto px-6 space-y-4">
<a class="flex items-center gap-3 text-[#3f4942] hover:bg-[#d9e5df]/50 py-2" href="#"><span class="material-symbols-outlined text-xl">help_outline</span>Help Center</a>
<a class="flex items-center gap-3 text-error py-2" href="#"><span class="material-symbols-outlined text-xl">logout</span>Sign Out</a>
</div>
</aside>
<!-- Main Content Canvas -->
<main class="flex-grow p-6 md:p-12 space-y-12 max-w-7xl">
<!-- Section 0: Case Study Coverage Table -->
<section class="space-y-4">
<h2 class="text-headline-lg font-extrabold text-primary tracking-tight">Tabla de Cobertura de Casos de Uso</h2>
<div class="overflow-hidden rounded-xl bg-surface-container-low border-none">
<table class="w-full text-left border-collapse">
<thead class="bg-surface-container-high text-on-surface-variant text-xs uppercase tracking-widest font-bold">
<tr>
<th class="px-6 py-4">Caso de uso (Nivel 1)</th>
<th class="px-6 py-4">Evidencia Técnica / Funcionalidad</th>
</tr>
</thead>
<tbody class="divide-y divide-surface-variant">
<tr class="hover:bg-surface-container transition-colors">
<td class="px-6 py-4 font-bold text-primary">Crear Perfil</td>
<td class="px-6 py-4 text-on-surface-variant">Formulario de registro con captura de datos biométricos y localización georeferenciada.</td>
</tr>
<tr class="hover:bg-surface-container transition-colors">
<td class="px-6 py-4 font-bold text-primary">Consultar Perfil</td>
<td class="px-6 py-4 text-on-surface-variant">Dashboard de resumen con métricas de actividad y estado de validación de identidad.</td>
</tr>
<tr class="hover:bg-surface-container transition-colors">
<td class="px-6 py-4 font-bold text-primary">Actualizar Datos</td>
<td class="px-6 py-4 text-on-surface-variant">Módulo de edición de campos personales con validación asíncrona de teléfono y ubicación.</td>
</tr>
<tr class="hover:bg-surface-container transition-colors">
<td class="px-6 py-4 font-bold text-primary">Cambiar Contraseña</td>
<td class="px-6 py-4 text-on-surface-variant">Workflow de seguridad con requisitos de complejidad y confirmación dual.</td>
</tr>
</tbody>
</table>
</div>
</section>
<!-- Grid 1: Form and Profile Summary -->
<div class="grid grid-cols-1 lg:grid-cols-12 gap-8">
<!-- Section A: Formulario -->
<section class="lg:col-span-7 bg-surface-container-lowest editorial-shadow rounded-2xl p-8 space-y-8">
<div class="flex items-center justify-between border-b border-surface-variant pb-4">
<h3 class="text-xl font-bold flex items-center gap-2">
<span class="material-symbols-outlined text-primary">person_edit</span>
                            Datos Personales
                        </h3>
<span class="text-xs font-medium text-secondary bg-secondary-fixed px-2 py-0.5 rounded">Requerido</span>
</div>
<form class="space-y-6">
<div class="grid grid-cols-1 md:grid-cols-2 gap-6">
<div class="space-y-2">
<label class="text-xs font-bold uppercase tracking-wide text-on-surface-variant">Nombres y Apellidos</label>
<input class="w-full bg-surface-container-highest border-none rounded-lg focus:ring-2 focus:ring-primary/20 text-on-surface p-3" placeholder="Ej: Juan Pérez" type="text"/>
</div>
<div class="space-y-2">
<label class="text-xs font-bold uppercase tracking-wide text-on-surface-variant">Teléfono de contacto</label>
<input class="w-full bg-surface-container-highest border-none rounded-lg focus:ring-2 focus:ring-primary/20 text-on-surface p-3" placeholder="+57 300 000 0000" type="tel"/>
</div>
</div>
<div class="space-y-2">
<label class="text-xs font-bold uppercase tracking-wide text-on-surface-variant">Ubicación (Municipio / Vereda)</label>
<div class="relative">
<span class="material-symbols-outlined absolute left-3 top-1/2 -translate-y-1/2 text-on-surface-variant">location_on</span>
<input class="w-full bg-surface-container-highest border-none rounded-lg focus:ring-2 focus:ring-primary/20 text-on-surface p-3 pl-10" placeholder="Buscar municipio..." type="text"/>
</div>
</div>
<div class="space-y-2">
<label class="text-xs font-bold uppercase tracking-wide text-on-surface-variant">Foto de perfil</label>
<div class="border-2 border-dashed border-outline-variant/30 rounded-xl p-8 text-center bg-surface-container-low hover:bg-surface-container transition-colors cursor-pointer group">
<span class="material-symbols-outlined text-4xl text-outline mb-2 group-hover:text-primary transition-colors">cloud_upload</span>
<p class="text-sm text-on-surface-variant">Arrastra tu foto aquí o <span class="text-primary font-bold underline">selecciona un archivo</span></p>
<p class="text-[10px] text-outline mt-1">JPG, PNG hasta 5MB</p>
</div>
</div>
<div class="flex gap-4 pt-4">
<button class="bg-gradient-to-br from-primary to-primary-container text-on-primary px-8 py-3 rounded-xl font-bold editorial-shadow hover:scale-105 active:scale-95 transition-all flex items-center gap-2" type="submit">
<span class="material-symbols-outlined text-sm" style="font-variation-settings: 'FILL' 1;">save</span>
                                Guardar cambios
                            </button>
<button class="text-primary font-bold px-6 py-3 border border-outline-variant/20 rounded-xl hover:bg-surface-container-high transition-colors" type="button">Cancelar</button>
</div>
</form>
</section>
<!-- Section B: Consulta Summary -->
<section class="lg:col-span-5 flex flex-col gap-6">
<div class="bg-primary text-on-primary rounded-2xl p-8 flex flex-col justify-between h-full relative overflow-hidden">
<div class="relative z-10">
<h3 class="text-xs font-bold uppercase tracking-widest opacity-80 mb-6">Resumen de Perfil</h3>
<div class="flex items-center gap-4 mb-8">
<img alt="Farmer avatar" class="w-20 h-20 rounded-2xl object-cover ring-4 ring-on-primary/10" data-alt="vibrant close-up portrait of a cheerful young farmer in a straw hat with golden hour sunlight hitting his face" src="https://lh3.googleusercontent.com/aida-public/AB6AXuAKHVI-he7O0iavGAy6Dczjs4pOfjuqRRJ1ix7Zh9sNP8Huj0P0WtsTNE7vPwFnuxfCj7ndY2VsGVtVEzkbt6rRENnLbwvhI6hAq2zEeiyxrV3ZIuehKPm_bc8Ag86-SJnnExXmopymM7fTO_1oBZhwhrHOF6iqvKas6C0TU-mWN3tbBH_nT126_iwJ0I8bEnRRct9KDdr6wGJJ-B2ywoFeBLbCVmSqAYKBvwrsR38_Rv7Ih4KLlrv9pgZrIwGxeM_EFcMLGXPDP0g"/>
<div>
<h4 class="text-2xl font-black leading-tight">Juan David Pérez</h4>
<p class="text-primary-fixed text-sm">Operario de Campo Senior</p>
</div>
</div>
<div class="space-y-4">
<div class="flex items-center gap-3 bg-on-primary/10 p-3 rounded-xl backdrop-blur-sm">
<span class="material-symbols-outlined opacity-70">pin_drop</span>
<div class="text-sm">
<p class="opacity-60 text-[10px] uppercase font-bold">Ubicación</p>
<p class="font-medium">Vereda El Porvenir, Salento</p>
</div>
</div>
<div class="flex items-center gap-3 bg-on-primary/10 p-3 rounded-xl backdrop-blur-sm">
<span class="material-symbols-outlined opacity-70">history</span>
<div class="text-sm">
<p class="opacity-60 text-[10px] uppercase font-bold">Última actualización</p>
<p class="font-medium">14 de Octubre, 2023 - 09:15 AM</p>
</div>
</div>
</div>
</div>
<!-- Abstract Background Decoration -->
<div class="absolute -right-12 -bottom-12 w-48 h-48 bg-primary-container rounded-full opacity-30 blur-3xl"></div>
</div>
</section>
</div>
<!-- Grid 2: Security and Preferences -->
<div class="grid grid-cols-1 md:grid-cols-2 gap-8">
<!-- Section C: Seguridad -->
<section class="bg-surface-container-low rounded-2xl p-8 space-y-6">
<div class="flex items-center gap-3">
<div class="w-10 h-10 rounded-full bg-error-container flex items-center justify-center text-on-error-container">
<span class="material-symbols-outlined">security</span>
</div>
<h3 class="text-lg font-bold">Seguridad de la cuenta</h3>
</div>
<div class="space-y-4">
<div class="space-y-1">
<label class="text-[10px] font-bold uppercase text-on-surface-variant">Contraseña actual</label>
<input class="w-full bg-surface-container-highest border-none rounded-lg p-3" placeholder="••••••••" type="password"/>
</div>
<div class="space-y-1">
<label class="text-[10px] font-bold uppercase text-on-surface-variant">Nueva contraseña</label>
<input class="w-full bg-surface-container-highest border-none rounded-lg p-3 border-b-2 border-error" placeholder="Mínimo 8 caracteres" type="password"/>
<p class="text-[10px] text-error">La contraseña debe incluir un carácter especial.</p>
</div>
<div class="space-y-1">
<label class="text-[10px] font-bold uppercase text-on-surface-variant">Confirmar nueva contraseña</label>
<input class="w-full bg-surface-container-highest border-none rounded-lg p-3" placeholder="Reingresar contraseña" type="password"/>
</div>
</div>
<div class="flex gap-4 pt-2">
<button class="bg-primary text-on-primary px-6 py-2 rounded-lg font-bold text-sm shadow-md hover:brightness-110 transition-all">Confirmar cambio</button>
<button class="text-on-surface-variant font-bold text-sm px-4">Cancelar</button>
</div>
</section>
<!-- Section D: Preferencias -->
<section class="bg-surface-container-low rounded-2xl p-8 space-y-6">
<div class="flex items-center gap-3">
<div class="w-10 h-10 rounded-full bg-tertiary-fixed flex items-center justify-center text-on-tertiary-fixed">
<span class="material-symbols-outlined">settings_suggest</span>
</div>
<h3 class="text-lg font-bold">Preferencias e Idioma</h3>
</div>
<div class="space-y-5">
<div class="space-y-1">
<label class="text-[10px] font-bold uppercase text-on-surface-variant">Idioma de la interfaz</label>
<select class="w-full bg-surface-container-highest border-none rounded-lg p-3 appearance-none">
<option>Español (Colombia)</option>
<option>English (International)</option>
<option>Português (Brasil)</option>
</select>
</div>
<div class="flex items-center justify-between p-4 bg-surface-container-highest rounded-xl">
<div>
<p class="text-sm font-bold">Notificaciones Push</p>
<p class="text-[10px] text-on-surface-variant">Alertas de riego y clima en el móvil</p>
</div>
<div class="w-12 h-6 bg-primary rounded-full relative p-1 cursor-pointer">
<div class="w-4 h-4 bg-on-primary rounded-full absolute right-1 shadow-sm"></div>
</div>
</div>
<div class="space-y-1">
<label class="text-[10px] font-bold uppercase text-on-surface-variant">Alertas críticas</label>
<select class="w-full bg-surface-container-highest border-none rounded-lg p-3">
<option>Solo vía Aplicación</option>
<option>Aplicación + SMS</option>
<option>Aplicación + SMS + Llamada</option>
</select>
</div>
</div>
<button class="w-full bg-gradient-to-r from-tertiary to-tertiary-container text-on-tertiary px-6 py-3 rounded-xl font-bold text-sm shadow-md hover:scale-[1.02] transition-all">
                        Guardar preferencias
                    </button>
</section>
</div>
<!-- Footer Note -->
<footer class="pt-12 border-t border-surface-variant/30 text-center">
<p class="text-on-surface-variant text-sm font-medium italic opacity-60">
                    Contrato visual del caso de uso: crear/consultar perfil, actualizar datos, cambiar contraseña y gestionar preferencias.
                </p>
<div class="flex justify-center gap-8 mt-4">
<div class="flex items-center gap-2 text-[10px] font-bold uppercase text-on-surface-variant">
<span class="w-2 h-2 rounded-full bg-primary-fixed"></span> Validado por UX
                    </div>
<div class="flex items-center gap-2 text-[10px] font-bold uppercase text-on-surface-variant">
<span class="w-2 h-2 rounded-full bg-secondary-container"></span> Technical Specs Ready
                    </div>
</div>
</footer>
</main>
</div>
<!-- Floating Mobile NAV (Hidden on Desktop) -->
<nav class="md:hidden fixed bottom-6 left-1/2 -translate-x-1/2 w-[90%] bg-surface-container-lowest/80 backdrop-blur-xl border border-outline-variant/20 rounded-2xl editorial-shadow px-6 py-4 flex justify-between items-center z-50">
<button class="material-symbols-outlined text-on-surface-variant">home</button>
<button class="material-symbols-outlined text-on-surface-variant">agriculture</button>
<button class="material-symbols-outlined text-primary" style="font-variation-settings: 'FILL' 1;">account_circle</button>
<button class="material-symbols-outlined text-on-surface-variant">notifications</button>
<button class="material-symbols-outlined text-on-surface-variant">menu</button>
</nav>
</body></html>
```

---

## Inicio de Sesión (v1)

**Componente React sugerido:** `LoginV1View`  
**Archivo:** `views/08-login.jsx`

### Descripción funcional
Pantalla de login con email/contraseña, recuperación de contraseña y acceso social.

### Secciones identificadas
- `Brand/Hero Section (Organic Layering)`
- `Login Form Section`
- `Mobile Logo`
- `Status Indicator (Bottom Right)`

### HTML Fuente

```html
<!DOCTYPE html>

<html lang="es"><head>
<meta charset="utf-8"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<title>AgroInteligente - Iniciar Sesión</title>
<script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script>
<link href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@300;400;500;600;700;800;900&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<script id="tailwind-config">
        tailwind.config = {
          darkMode: "class",
          theme: {
            extend: {
              "colors": {
                      "on-tertiary-fixed": "#002112",
                      "secondary": "#895200",
                      "primary-container": "#2f7d57",
                      "inverse-on-surface": "#e7f4ed",
                      "surface": "#effcf5",
                      "on-secondary-container": "#6e4100",
                      "primary-fixed": "#a4f3c5",
                      "surface-container-lowest": "#ffffff",
                      "error": "#ba1a1a",
                      "error-container": "#ffdad6",
                      "surface-container-low": "#eaf7f0",
                      "on-error-container": "#93000a",
                      "inverse-surface": "#27332e",
                      "primary": "#0c6440",
                      "on-tertiary-fixed-variant": "#284e3a",
                      "secondary-fixed-dim": "#ffb86a",
                      "tertiary-fixed-dim": "#a6d0b5",
                      "on-primary-container": "#d0ffe0",
                      "tertiary-container": "#517861",
                      "on-background": "#131e1a",
                      "surface-container-highest": "#d9e5df",
                      "surface-variant": "#d9e5df",
                      "tertiary-fixed": "#c2edd0",
                      "primary-fixed-dim": "#89d7aa",
                      "surface-bright": "#effcf5",
                      "on-tertiary-container": "#d3ffe2",
                      "surface-tint": "#196b47",
                      "secondary-fixed": "#ffdcbc",
                      "surface-container": "#e4f1ea",
                      "on-primary-fixed-variant": "#005233",
                      "inverse-primary": "#89d7aa",
                      "outline-variant": "#bfc9c0",
                      "on-surface": "#131e1a",
                      "secondary-container": "#fdaa47",
                      "tertiary": "#395f49",
                      "on-secondary-fixed": "#2c1700",
                      "surface-container-high": "#deebe4",
                      "on-primary-fixed": "#002112",
                      "background": "#effcf5",
                      "on-surface-variant": "#3f4942",
                      "on-tertiary": "#ffffff",
                      "on-secondary-fixed-variant": "#683d00",
                      "on-error": "#ffffff",
                      "surface-dim": "#d0ddd6",
                      "on-secondary": "#ffffff",
                      "on-primary": "#ffffff",
                      "outline": "#6f7a72"
              },
              "borderRadius": {
                      "DEFAULT": "0.25rem",
                      "lg": "0.5rem",
                      "xl": "0.75rem",
                      "full": "9999px"
              },
              "fontFamily": {
                      "headline": ["Public Sans"],
                      "body": ["Public Sans"],
                      "label": ["Public Sans"]
              }
            },
          }
        }
      </script>
<style>
        body { font-family: 'Public Sans', sans-serif; }
        .material-symbols-outlined {
            font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24;
        }
        .organic-gradient {
            background: linear-gradient(135deg, #0c6440 0%, #2f7d57 100%);
        }
    </style>
</head>
<body class="bg-background text-on-surface overflow-hidden">
<main class="min-h-screen flex flex-col md:flex-row relative">
<!-- Brand/Hero Section (Organic Layering) -->
<section class="hidden md:flex md:w-1/2 lg:w-3/5 bg-surface-container-low p-16 flex-col justify-between relative overflow-hidden">
<div class="z-10">
<div class="flex items-center space-x-3 mb-12">
<span class="material-symbols-outlined text-4xl text-primary" data-icon="agriculture" style="font-variation-settings: 'FILL' 1;">agriculture</span>
<h1 class="text-3xl font-black tracking-tight text-primary">AgroInteligente</h1>
</div>
<div class="max-w-xl">
<h2 class="text-5xl font-extrabold text-on-surface leading-tight mb-6">
                        Cultive el futuro con <br/><span class="text-primary">inteligencia digital</span>.
                    </h2>
<p class="text-xl text-on-surface-variant leading-relaxed">
                        Acceda a sus herramientas de gestión agrícola, monitoreo de cultivos y análisis de suelo en una plataforma diseñada para la tierra.
                    </p>
</div>
</div>
<!-- Background Decorative Element (Asymmetric) -->
<div class="absolute -bottom-20 -right-20 w-96 h-96 bg-primary-fixed opacity-20 rounded-full blur-3xl"></div>
<div class="absolute top-1/2 left-1/4 w-64 h-64 bg-secondary-fixed-dim opacity-10 rounded-full blur-3xl"></div>
<div class="z-10 mt-auto">
<div class="bg-surface-container-lowest/80 backdrop-blur-xl p-8 rounded-xl shadow-[0px_20px_40px_rgba(19,30,26,0.06)] border border-outline-variant/10 max-w-md">
<p class="italic text-on-surface-variant mb-4">"La tecnología es la semilla, su conocimiento es el fruto. AgroInteligente une ambos mundos."</p>
<div class="flex items-center space-x-3">
<div class="w-10 h-10 rounded-full bg-surface-container-highest flex items-center justify-center">
<span class="material-symbols-outlined text-primary" data-icon="person">person</span>
</div>
<div>
<p class="font-bold text-on-surface">Digital Cultivator</p>
<p class="text-xs text-on-surface-variant">AgroInteligente Platform</p>
</div>
</div>
</div>
</div>
<img class="absolute inset-0 w-full h-full object-cover opacity-10 mix-blend-multiply pointer-events-none" data-alt="macro close-up of a tiny green seedling emerging from dark rich fertile soil with soft morning dew and golden lighting" src="https://lh3.googleusercontent.com/aida-public/AB6AXuDxwRYKWW38rFB1At2f9FnKS5I6qmd1QLHFmVC9ZVMA2bkxqqUzeeXrUbF-d8hCUeBlzX7q5sMYF-VkwIc7Uh_oV_YvxJ6DQ-8HN0kjTVhER13PymhbOYCOu88JEkHox3PMVe9kHp9btbtd_YACl06fTgyVjylmtcV8Jm_YPqG2v-_W5XlVpCfgoNfImgIber10HkDMt6mTE63uraTnVqsN8ALXZjtusNGMA5pMMwajmd26cTAElSUpIKxLMqI36g9is5YidzD77Wg"/>
</section>
<!-- Login Form Section -->
<section class="flex-1 flex flex-col items-center justify-center p-8 md:p-16 lg:p-24 bg-surface z-20">
<!-- Mobile Logo -->
<div class="md:hidden flex items-center space-x-3 mb-12">
<span class="material-symbols-outlined text-3xl text-primary" data-icon="agriculture" style="font-variation-settings: 'FILL' 1;">agriculture</span>
<span class="text-2xl font-black tracking-tight text-primary">AgroInteligente</span>
</div>
<div class="w-full max-w-md">
<header class="mb-10 text-center md:text-left">
<h2 class="text-3xl font-bold text-on-surface tracking-tight">Bienvenido</h2>
<p class="text-on-surface-variant mt-2">Ingrese sus credenciales para acceder a su panel.</p>
</header>
<form class="space-y-6">
<div class="space-y-2">
<label class="block text-sm font-semibold text-on-surface-variant ml-1" for="email">Email o Documento</label>
<div class="relative group">
<span class="material-symbols-outlined absolute left-4 top-1/2 -translate-y-1/2 text-outline group-focus-within:text-primary transition-colors" data-icon="person">person</span>
<input class="w-full pl-12 pr-4 py-4 bg-surface-container-highest border-none rounded-md focus:ring-2 focus:ring-surface-tint/30 text-on-surface placeholder:text-outline transition-all" id="email" name="email" placeholder="ejemplo@agro.com" required="" type="text"/>
</div>
</div>
<div class="space-y-2">
<div class="flex justify-between items-center px-1">
<label class="block text-sm font-semibold text-on-surface-variant" for="password">Contraseña</label>
<a class="text-sm font-bold text-primary hover:underline transition-all" href="#">¿Olvidó su contraseña?</a>
</div>
<div class="relative group">
<span class="material-symbols-outlined absolute left-4 top-1/2 -translate-y-1/2 text-outline group-focus-within:text-primary transition-colors" data-icon="lock">lock</span>
<input class="w-full pl-12 pr-4 py-4 bg-surface-container-highest border-none rounded-md focus:ring-2 focus:ring-surface-tint/30 text-on-surface placeholder:text-outline transition-all" id="password" name="password" placeholder="••••••••" required="" type="password"/>
</div>
</div>
<div class="flex items-center space-x-2 px-1">
<input class="w-5 h-5 rounded border-outline-variant text-primary focus:ring-primary bg-surface-container-highest" id="remember" type="checkbox"/>
<label class="text-sm text-on-surface-variant" for="remember">Recordar sesión en este dispositivo</label>
</div>
<button class="w-full organic-gradient text-white font-bold py-4 px-6 rounded-xl shadow-lg hover:shadow-xl active:scale-[0.98] transition-all flex items-center justify-center space-x-2" type="submit">
<span>Iniciar Sesión</span>
<span class="material-symbols-outlined text-xl" data-icon="login">login</span>
</button>
</form>
<footer class="mt-12 text-center">
<p class="text-on-surface-variant">
                        ¿No tiene una cuenta aún? 
                        <a class="font-bold text-primary hover:underline ml-1" href="#">Regístrese ahora</a>
</p>
<div class="mt-12 flex items-center justify-center space-x-6 text-outline">
<a class="hover:text-primary transition-colors" href="#">Privacidad</a>
<span class="w-1 h-1 bg-outline-variant rounded-full"></span>
<a class="hover:text-primary transition-colors" href="#">Términos</a>
<span class="w-1 h-1 bg-outline-variant rounded-full"></span>
<a class="hover:text-primary transition-colors" href="#">Soporte</a>
</div>
</footer>
</div>
</section>
<!-- Status Indicator (Bottom Right) -->
<div class="fixed bottom-6 right-6 z-50">
<div class="flex items-center bg-primary-fixed text-on-primary-fixed px-4 py-2 rounded-full shadow-lg border border-primary/10">
<div class="relative flex h-3 w-3 mr-3">
<span class="animate-ping absolute inline-flex h-full w-full rounded-full bg-primary opacity-75"></span>
<span class="relative inline-flex rounded-full h-3 w-3 bg-primary"></span>
</div>
<span class="text-xs font-bold uppercase tracking-wider">Online Status</span>
</div>
</div>
</main>
</body></html>
```

---

## Inicio de Sesión (v2)

**Componente React sugerido:** `LoginV2View`  
**Archivo:** `views/09-login-v2.jsx`

### Descripción funcional
Variante alternativa del login con distinto tratamiento visual del formulario.

### Secciones identificadas
- `Brand/Hero Section (Organic Layering)`
- `Login Form Section`
- `Mobile Logo`
- `Status Indicator (Bottom Right)`

### HTML Fuente

```html
<!DOCTYPE html>

<html lang="es"><head>
<meta charset="utf-8"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<title>AgroInteligente - Iniciar Sesión</title>
<script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script>
<link href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@300;400;500;600;700;800;900&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<script id="tailwind-config">
        tailwind.config = {
          darkMode: "class",
          theme: {
            extend: {
              "colors": {
                      "on-tertiary-fixed": "#002112",
                      "secondary": "#895200",
                      "primary-container": "#2f7d57",
                      "inverse-on-surface": "#e7f4ed",
                      "surface": "#effcf5",
                      "on-secondary-container": "#6e4100",
                      "primary-fixed": "#a4f3c5",
                      "surface-container-lowest": "#ffffff",
                      "error": "#ba1a1a",
                      "error-container": "#ffdad6",
                      "surface-container-low": "#eaf7f0",
                      "on-error-container": "#93000a",
                      "inverse-surface": "#27332e",
                      "primary": "#0c6440",
                      "on-tertiary-fixed-variant": "#284e3a",
                      "secondary-fixed-dim": "#ffb86a",
                      "tertiary-fixed-dim": "#a6d0b5",
                      "on-primary-container": "#d0ffe0",
                      "tertiary-container": "#517861",
                      "on-background": "#131e1a",
                      "surface-container-highest": "#d9e5df",
                      "surface-variant": "#d9e5df",
                      "tertiary-fixed": "#c2edd0",
                      "primary-fixed-dim": "#89d7aa",
                      "surface-bright": "#effcf5",
                      "on-tertiary-container": "#d3ffe2",
                      "surface-tint": "#196b47",
                      "secondary-fixed": "#ffdcbc",
                      "surface-container": "#e4f1ea",
                      "on-primary-fixed-variant": "#005233",
                      "inverse-primary": "#89d7aa",
                      "outline-variant": "#bfc9c0",
                      "on-surface": "#131e1a",
                      "secondary-container": "#fdaa47",
                      "tertiary": "#395f49",
                      "on-secondary-fixed": "#2c1700",
                      "surface-container-high": "#deebe4",
                      "on-primary-fixed": "#002112",
                      "background": "#effcf5",
                      "on-surface-variant": "#3f4942",
                      "on-tertiary": "#ffffff",
                      "on-secondary-fixed-variant": "#683d00",
                      "on-error": "#ffffff",
                      "surface-dim": "#d0ddd6",
                      "on-secondary": "#ffffff",
                      "on-primary": "#ffffff",
                      "outline": "#6f7a72"
              },
              "borderRadius": {
                      "DEFAULT": "0.25rem",
                      "lg": "0.5rem",
                      "xl": "0.75rem",
                      "full": "9999px"
              },
              "fontFamily": {
                      "headline": ["Public Sans"],
                      "body": ["Public Sans"],
                      "label": ["Public Sans"]
              }
            },
          }
        }
      </script>
<style>
        body { font-family: 'Public Sans', sans-serif; }
        .material-symbols-outlined {
            font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24;
        }
        .organic-gradient {
            background: linear-gradient(135deg, #0c6440 0%, #2f7d57 100%);
        }
    </style>
</head>
<body class="bg-background text-on-surface overflow-hidden">
<main class="min-h-screen flex flex-col md:flex-row relative">
<!-- Brand/Hero Section (Organic Layering) -->
<section class="hidden md:flex md:w-1/2 lg:w-3/5 bg-surface-container-low p-16 flex-col justify-between relative overflow-hidden">
<div class="z-10">
<div class="flex items-center space-x-3 mb-12">
<span class="material-symbols-outlined text-4xl text-primary" data-icon="agriculture" style="font-variation-settings: 'FILL' 1;">agriculture</span>
<h1 class="text-3xl font-black tracking-tight text-primary">AgroInteligente</h1>
</div>
<div class="max-w-xl">
<h2 class="text-5xl font-extrabold text-on-surface leading-tight mb-6">
                        Cultive el futuro con <br/><span class="text-primary">inteligencia digital</span>.
                    </h2>
<p class="text-xl text-on-surface-variant leading-relaxed">
                        Acceda a sus herramientas de gestión agrícola, monitoreo de cultivos y análisis de suelo en una plataforma diseñada para la tierra.
                    </p>
</div>
</div>
<!-- Background Decorative Element (Asymmetric) -->
<div class="absolute -bottom-20 -right-20 w-96 h-96 bg-primary-fixed opacity-20 rounded-full blur-3xl"></div>
<div class="absolute top-1/2 left-1/4 w-64 h-64 bg-secondary-fixed-dim opacity-10 rounded-full blur-3xl"></div>
<div class="z-10 mt-auto">
<div class="bg-surface-container-lowest/80 backdrop-blur-xl p-8 rounded-xl shadow-[0px_20px_40px_rgba(19,30,26,0.06)] border border-outline-variant/10 max-w-md">
<p class="italic text-on-surface-variant mb-4">"La tecnología es la semilla, su conocimiento es el fruto. AgroInteligente une ambos mundos."</p>
<div class="flex items-center space-x-3">
<div class="w-10 h-10 rounded-full bg-surface-container-highest flex items-center justify-center">
<span class="material-symbols-outlined text-primary" data-icon="person">person</span>
</div>
<div>
<p class="font-bold text-on-surface">Digital Cultivator</p>
<p class="text-xs text-on-surface-variant">AgroInteligente Platform</p>
</div>
</div>
</div>
</div>
<img class="absolute inset-0 w-full h-full object-cover opacity-10 mix-blend-multiply pointer-events-none" data-alt="macro close-up of a tiny green seedling emerging from dark rich fertile soil with soft morning dew and golden lighting" src="https://lh3.googleusercontent.com/aida-public/AB6AXuDxwRYKWW38rFB1At2f9FnKS5I6qmd1QLHFmVC9ZVMA2bkxqqUzeeXrUbF-d8hCUeBlzX7q5sMYF-VkwIc7Uh_oV_YvxJ6DQ-8HN0kjTVhER13PymhbOYCOu88JEkHox3PMVe9kHp9btbtd_YACl06fTgyVjylmtcV8Jm_YPqG2v-_W5XlVpCfgoNfImgIber10HkDMt6mTE63uraTnVqsN8ALXZjtusNGMA5pMMwajmd26cTAElSUpIKxLMqI36g9is5YidzD77Wg"/>
</section>
<!-- Login Form Section -->
<section class="flex-1 flex flex-col items-center justify-center p-8 md:p-16 lg:p-24 bg-surface z-20">
<!-- Mobile Logo -->
<div class="md:hidden flex items-center space-x-3 mb-12">
<span class="material-symbols-outlined text-3xl text-primary" data-icon="agriculture" style="font-variation-settings: 'FILL' 1;">agriculture</span>
<span class="text-2xl font-black tracking-tight text-primary">AgroInteligente</span>
</div>
<div class="w-full max-w-md">
<header class="mb-10 text-center md:text-left">
<h2 class="text-3xl font-bold text-on-surface tracking-tight">Bienvenido</h2>
<p class="text-on-surface-variant mt-2">Ingrese sus credenciales para acceder a su panel.</p>
</header>
<form class="space-y-6">
<div class="space-y-2">
<label class="block text-sm font-semibold text-on-surface-variant ml-1" for="email">Email o Documento</label>
<div class="relative group">
<span class="material-symbols-outlined absolute left-4 top-1/2 -translate-y-1/2 text-outline group-focus-within:text-primary transition-colors" data-icon="person">person</span>
<input class="w-full pl-12 pr-4 py-4 bg-surface-container-highest border-none rounded-md focus:ring-2 focus:ring-surface-tint/30 text-on-surface placeholder:text-outline transition-all" id="email" name="email" placeholder="ejemplo@agro.com" required="" type="text"/>
</div>
</div>
<div class="space-y-2">
<div class="flex justify-between items-center px-1">
<label class="block text-sm font-semibold text-on-surface-variant" for="password">Contraseña</label>
<a class="text-sm font-bold text-primary hover:underline transition-all" href="#">¿Olvidó su contraseña?</a>
</div>
<div class="relative group">
<span class="material-symbols-outlined absolute left-4 top-1/2 -translate-y-1/2 text-outline group-focus-within:text-primary transition-colors" data-icon="lock">lock</span>
<input class="w-full pl-12 pr-4 py-4 bg-surface-container-highest border-none rounded-md focus:ring-2 focus:ring-surface-tint/30 text-on-surface placeholder:text-outline transition-all" id="password" name="password" placeholder="••••••••" required="" type="password"/>
</div>
</div>
<div class="flex items-center space-x-2 px-1">
<input class="w-5 h-5 rounded border-outline-variant text-primary focus:ring-primary bg-surface-container-highest" id="remember" type="checkbox"/>
<label class="text-sm text-on-surface-variant" for="remember">Recordar sesión en este dispositivo</label>
</div>
<button class="w-full organic-gradient text-white font-bold py-4 px-6 rounded-xl shadow-lg hover:shadow-xl active:scale-[0.98] transition-all flex items-center justify-center space-x-2" type="submit">
<span>Iniciar Sesión</span>
<span class="material-symbols-outlined text-xl" data-icon="login">login</span>
</button>
</form>
<footer class="mt-12 text-center">
<p class="text-on-surface-variant">
                        ¿No tiene una cuenta aún? 
                        <a class="font-bold text-primary hover:underline ml-1" href="#">Regístrese ahora</a>
</p>
<div class="mt-12 flex items-center justify-center space-x-6 text-outline">
<a class="hover:text-primary transition-colors" href="#">Privacidad</a>
<span class="w-1 h-1 bg-outline-variant rounded-full"></span>
<a class="hover:text-primary transition-colors" href="#">Términos</a>
<span class="w-1 h-1 bg-outline-variant rounded-full"></span>
<a class="hover:text-primary transition-colors" href="#">Soporte</a>
</div>
</footer>
</div>
</section>
<!-- Status Indicator (Bottom Right) -->
<div class="fixed bottom-6 right-6 z-50">
<div class="flex items-center bg-primary-fixed text-on-primary-fixed px-4 py-2 rounded-full shadow-lg border border-primary/10">
<div class="relative flex h-3 w-3 mr-3">
<span class="animate-ping absolute inline-flex h-full w-full rounded-full bg-primary opacity-75"></span>
<span class="relative inline-flex rounded-full h-3 w-3 bg-primary"></span>
</div>
<span class="text-xs font-bold uppercase tracking-wider">Online Status</span>
</div>
</div>
</main>
</body></html>
```

---

## Registro Exitoso / Onboarding

**Componente React sugerido:** `RegistroExitosoView`  
**Archivo:** `views/10-registro-exitoso.jsx`

### Descripción funcional
Pantalla de confirmación post-registro con pasos de bienvenida y llamada a la acción inicial.

### HTML Fuente

```html
<!DOCTYPE html>

<html lang="es"><head>
<meta charset="utf-8"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script>
<link href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@300;400;500;600;700;800&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<script id="tailwind-config">
      tailwind.config = {
        darkMode: "class",
        theme: {
          extend: {
            "colors": {
                    "on-tertiary-fixed": "#002112",
                    "on-primary-fixed-variant": "#005233",
                    "outline-variant": "#bfc9c0",
                    "on-surface": "#131e1a",
                    "inverse-surface": "#27332e",
                    "on-surface-variant": "#3f4942",
                    "error-container": "#ffdad6",
                    "tertiary-fixed-dim": "#a6d0b5",
                    "secondary": "#895200",
                    "background": "#effcf5",
                    "surface-container-low": "#eaf7f0",
                    "tertiary-fixed": "#c2edd0",
                    "on-primary": "#ffffff",
                    "surface-variant": "#d9e5df",
                    "on-secondary-fixed": "#2c1700",
                    "primary-fixed": "#a4f3c5",
                    "on-background": "#131e1a",
                    "inverse-primary": "#89d7aa",
                    "on-secondary-fixed-variant": "#683d00",
                    "error": "#ba1a1a",
                    "on-primary-fixed": "#002112",
                    "tertiary": "#395f49",
                    "surface-bright": "#effcf5",
                    "primary-fixed-dim": "#89d7aa",
                    "tertiary-container": "#517861",
                    "on-tertiary": "#ffffff",
                    "surface-tint": "#196b47",
                    "on-error-container": "#93000a",
                    "surface-container": "#e4f1ea",
                    "on-error": "#ffffff",
                    "on-tertiary-container": "#d3ffe2",
                    "surface-dim": "#d0ddd6",
                    "surface-container-lowest": "#ffffff",
                    "primary": "#0c6440",
                    "on-tertiary-fixed-variant": "#284e3a",
                    "secondary-container": "#fdaa47",
                    "on-secondary-container": "#6e4100",
                    "outline": "#6f7a72",
                    "inverse-on-surface": "#e7f4ed",
                    "primary-container": "#2f7d57",
                    "on-primary-container": "#d0ffe0",
                    "surface": "#effcf5",
                    "secondary-fixed-dim": "#ffb86a",
                    "surface-container-high": "#deebe4",
                    "surface-container-highest": "#d9e5df",
                    "on-secondary": "#ffffff",
                    "secondary-fixed": "#ffdcbc"
            },
            "borderRadius": {
                    "DEFAULT": "0.25rem",
                    "lg": "0.5rem",
                    "xl": "0.75rem",
                    "full": "9999px"
            },
            "fontFamily": {
                    "headline": ["Public Sans"],
                    "body": ["Public Sans"],
                    "label": ["Public Sans"]
            }
          },
        },
      }
    </script>
<style>
        .material-symbols-outlined {
            font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 48;
        }
        .organic-bg {
            background-image: radial-gradient(circle at 10% 20%, rgba(164, 243, 197, 0.15) 0%, transparent 40%),
                              radial-gradient(circle at 90% 80%, rgba(12, 100, 64, 0.05) 0%, transparent 40%);
        }
    </style>
</head>
<body class="bg-background font-body text-on-background min-h-screen flex flex-col organic-bg">
<header class="w-full px-8 py-6 flex justify-between items-center bg-transparent">
<div class="text-2xl font-extrabold tracking-tight text-primary">AgroInteligente</div>
<div class="p-2 rounded-full bg-surface-container-low text-on-surface-variant cursor-pointer transition-all hover:bg-surface-container-highest">
<span class="material-symbols-outlined" data-icon="help_outline">help_outline</span>
</div>
</header>
<main class="flex-grow flex items-center justify-center px-6 py-12">
<div class="max-w-xl w-full grid grid-cols-1 gap-8">
<section class="relative bg-surface-container-lowest p-10 md:p-16 rounded-[40px] shadow-[0px_20px_40px_rgba(19,30,26,0.06)] overflow-hidden">
<div class="absolute top-0 right-0 w-32 h-32 bg-primary-fixed/30 rounded-bl-[100px] -mr-8 -mt-8"></div>
<div class="relative z-10 flex flex-col items-center text-center">
<div class="mb-8 relative">
<div class="w-24 h-24 rounded-full bg-primary-fixed flex items-center justify-center text-primary-container shadow-sm">
<span class="material-symbols-outlined !text-5xl" data-icon="check_circle" style="font-variation-settings: 'FILL' 1;">check_circle</span>
</div>
<div class="absolute -bottom-2 -right-2 w-10 h-10 rounded-full bg-secondary-container flex items-center justify-center text-on-secondary-container border-4 border-surface-container-lowest">
<span class="material-symbols-outlined !text-xl" data-icon="celebration">celebration</span>
</div>
</div>
<h1 class="text-headline-lg font-bold text-primary mb-4 leading-tight">¡Cuenta creada con éxito!</h1>
<div class="space-y-4 max-w-sm mx-auto">
<p class="text-on-surface-variant text-lg">
                            Hemos enviado un enlace de confirmación a tu correo electrónico y un código de verificación vía SMS.
                        </p>
<div class="bg-surface-container-low p-6 rounded-2xl text-on-surface-variant text-sm border-l-4 border-primary-container">
<p class="font-medium">
                                Por favor, verifica tu bandeja de entrada o mensajes para activar tu cuenta.
                            </p>
</div>
</div>
<div class="mt-12 w-full">
<a class="inline-flex items-center justify-center w-full md:w-auto min-w-[240px] px-8 py-4 bg-gradient-to-br from-primary to-primary-container text-on-primary font-semibold rounded-full shadow-lg transition-all duration-300 active:scale-95 hover:shadow-primary/20" href="#">
                            Ir al Inicio de Sesión
                            <span class="material-symbols-outlined ml-2" data-icon="arrow_forward">arrow_forward</span>
</a>
</div>
</div>
<div class="absolute bottom-0 left-0 w-16 h-16 bg-tertiary-fixed/40 rounded-tr-[50px] -ml-4 -mb-4"></div>
</section>
<section class="grid grid-cols-2 gap-4">
<div class="bg-surface-container p-6 rounded-3xl flex items-center gap-4">
<div class="p-3 bg-surface-container-highest rounded-xl text-primary">
<span class="material-symbols-outlined" data-icon="mark_email_unread">mark_email_unread</span>
</div>
<div>
<p class="text-xs font-semibold text-on-surface-variant uppercase tracking-wider">Email</p>
<p class="text-sm font-medium text-on-surface">Revisa tu Spam</p>
</div>
</div>
<div class="bg-surface-container p-6 rounded-3xl flex items-center gap-4">
<div class="p-3 bg-surface-container-highest rounded-xl text-primary">
<span class="material-symbols-outlined" data-icon="sms">sms</span>
</div>
<div>
<p class="text-xs font-semibold text-on-surface-variant uppercase tracking-wider">SMS</p>
<p class="text-sm font-medium text-on-surface">Código de 6 dígitos</p>
</div>
</div>
</section>
<div class="flex justify-center gap-6 mt-4">
<img class="w-16 h-16 rounded-2xl object-cover opacity-80 grayscale hover:grayscale-0 transition-all cursor-pointer" data-alt="close up of fertile dark soil with a small green sprout emerging and soft morning sunlight" src="https://lh3.googleusercontent.com/aida-public/AB6AXuD2ZOK4cRLZjox1CTmr9mARj3S3q_A0uXVysb1bJtygdAOuyuM4A_IEcWrwpZA0RpYlRCoFhhaYP4d-qhjCXVgOZ23-RaDJ3wwQY3xKk0WoFgeyGD9otWK09K4Q3P7rNt9qqDlW4ss3YhpBDCSWZzZT0Be164Hu74c7oGK4RC2pyKg5tixEIFbvSq15Sia0XEaw7QKGKEm_d6XOSnpWltwnEKBhb3JCgvM2GZ-SDzvzDHKAvVU7agTLbX4I8tw4ROCCPfx8OAj5mpo"/>
<img class="w-16 h-16 rounded-2xl object-cover opacity-80 grayscale hover:grayscale-0 transition-all cursor-pointer" data-alt="aerial view of a small sustainable farm with organized crop rows and vibrant green colors" src="https://lh3.googleusercontent.com/aida-public/AB6AXuDIqEXzx5bL4byUohWlYDqmAbNMymFFKWd81OJde8cNI1gpkxljCYu58m4J0g8GoiG2w0U9aFh1JRfFrfIexwsV21LAdqrfxW2dYZ8bcggjxqYw69rp544Egah57USWGZIlDMv5bnIStRby6OeBD5qYxtNhHwIjciQgDxcbY5VTY9mx0QZtiWOcoSdcVY4PuVox6tuVaKlX2vaQWhZM2AGUfsqcsxMqm_2oRe1Z19BDWr1PUItZFCysc2ZlDT9-nqmM0J-591abYUs"/>
<img class="w-16 h-16 rounded-2xl object-cover opacity-80 grayscale hover:grayscale-0 transition-all cursor-pointer" data-alt="macro shot of dew drops on a leaf with natural green patterns and soft blurred background" src="https://lh3.googleusercontent.com/aida-public/AB6AXuCvvXF5gxbdJjXzDWRbdfmVZIw05ZHgaoou4qUjUfpG219MR2528vhEm7YztX4ll0OoCg2gtZCZPVNlCAn80b2DDLXfOIqK9-TF_82-jh0lCnzFBxIhe7tbhbSuJvX3YBtvraeZH9k6Pab1mAM0GqQjmqDLwLKHMwtJNmkH_SFdctd0lO75VF4OKrmW34JndWgiOifZAczhNQ21ivj07vW8HHH3XfffBe_ZArnFXOFI2zg3EhbfqC30mlpmvnKab2eNKsapBn3nchc"/>
</div>
</div>
</main>
<footer class="w-full py-8 px-8 flex flex-col md:flex-row justify-between items-center text-on-surface-variant text-sm gap-4">
<p>© 2024 AgroInteligente. Todos los derechos reservados.</p>
<div class="flex gap-8">
<a class="hover:text-primary transition-colors" href="#">Términos de Servicio</a>
<a class="hover:text-primary transition-colors" href="#">Privacidad</a>
</div>
</footer>
</body></html>
```

---

## Dashboard Principal

**Componente React sugerido:** `DashboardView`  
**Archivo:** `views/11-dashboard.jsx`

### Descripción funcional
Vista general de la finca: métricas clave, estado de módulos, alertas, actividad reciente y atajos operativos.

### Secciones identificadas
- `Frame Title Section`
- `Header / TopAppBar`
- `Izquierda: Marca`
- `Centro: Módulo + Contexto`
- `Derecha: Estado`
- `Navigation Menu (Top Level)`
- `Sidebar Navigation`
- `Main Content Canvas`

### HTML Fuente

```html
<!DOCTYPE html>

<html class="light" lang="es"><head>
<meta charset="utf-8"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<title>AgroInteligente - Dashboard Principal</title>
<script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script>
<link href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@300;400;500;600;700;800&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<script id="tailwind-config">
      tailwind.config = {
        darkMode: "class",
        theme: {
          extend: {
            "colors": {
                "inverse-surface": "#27332e",
                "surface-container-low": "#eaf7f0",
                "secondary-fixed-dim": "#ffb86a",
                "secondary-container": "#fdaa47",
                "on-secondary": "#ffffff",
                "on-primary-fixed": "#002112",
                "on-error-container": "#93000a",
                "background": "#effcf5",
                "on-tertiary-fixed": "#002112",
                "surface-bright": "#effcf5",
                "on-surface-variant": "#3f4942",
                "outline": "#6f7a72",
                "on-primary-container": "#d0ffe0",
                "primary-fixed-dim": "#89d7aa",
                "on-primary": "#ffffff",
                "surface-container": "#e4f1ea",
                "tertiary-fixed-dim": "#a6d0b5",
                "surface": "#effcf5",
                "surface-container-high": "#deebe4",
                "inverse-on-surface": "#e7f4ed",
                "error": "#ba1a1a",
                "tertiary-fixed": "#c2edd0",
                "secondary-fixed": "#ffdcbc",
                "outline-variant": "#bfc9c0",
                "on-error": "#ffffff",
                "on-primary-fixed-variant": "#005233",
                "secondary": "#895200",
                "inverse-primary": "#89d7aa",
                "surface-container-lowest": "#ffffff",
                "tertiary": "#395f49",
                "surface-dim": "#d0ddd6",
                "on-background": "#131e1a",
                "error-container": "#ffdad6",
                "tertiary-container": "#517861",
                "primary-container": "#2f7d57",
                "surface-tint": "#196b47",
                "primary": "#0c6440",
                "on-tertiary-container": "#d3ffe2",
                "primary-fixed": "#a4f3c5",
                "surface-container-highest": "#d9e5df",
                "on-tertiary": "#ffffff",
                "on-secondary-container": "#6e4100",
                "surface-variant": "#d9e5df",
                "on-surface": "#131e1a",
                "on-secondary-fixed": "#2c1700",
                "on-tertiary-fixed-variant": "#284e3a",
                "on-secondary-fixed-variant": "#683d00"
            },
            "fontFamily": {
                "headline": ["Public Sans", "sans-serif"],
                "body": ["Public Sans", "sans-serif"],
                "label": ["Public Sans", "sans-serif"]
            }
          },
        }
      }
    </script>
<style>
        body { font-family: 'Public Sans', sans-serif; }
        .material-symbols-outlined {
            font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24;
        }
        .editorial-shadow { box-shadow: 0px 20px 40px rgba(19, 30, 26, 0.06); }
        .no-scrollbar::-webkit-scrollbar { display: none; }
    </style>
</head>
<body class="bg-background text-on-background min-h-screen flex flex-col">
<!-- Frame Title Section -->
<div class="bg-primary text-on-primary-container px-8 py-3 flex flex-col md:flex-row justify-between items-start md:items-center border-b border-primary-container/20">
<div>
<h1 class="text-label-md font-bold tracking-widest uppercase">Wireframe funcional - Dashboard Principal AgroInteligente</h1>
<p class="text-xs opacity-80">Centro de navegación para acceder a todos los módulos del sistema</p>
</div>
<div class="mt-2 md:mt-0 px-3 py-1 bg-primary-container text-on-primary-container rounded-full text-[10px] font-bold">V 2.4.0 - RELEASE</div>
</div>
<!-- Header / TopAppBar -->
<header class="bg-[#effcf5] dark:bg-emerald-950 shadow-[0px_20px_40px_rgba(19,30,26,0.06)] flex justify-between items-center w-full px-8 py-4 sticky top-0 z-50">
<!-- Izquierda: Marca -->
<div class="flex items-center gap-3">
<div class="w-10 h-10 bg-primary rounded-xl flex items-center justify-center text-on-primary">
<span class="material-symbols-outlined" style="font-variation-settings: 'FILL' 1;">eco</span>
</div>
<span class="text-2xl font-bold tracking-tight text-[#0c6440] dark:text-emerald-500">AgroInteligente</span>
</div>
<!-- Centro: Módulo + Contexto -->
<div class="hidden lg:flex flex-col items-center text-center">
<h2 class="text-primary font-bold text-lg leading-none">Dashboard Principal</h2>
<p class="text-on-surface-variant text-xs mt-1">Operación Agrícola - Ciclo Verano 2024</p>
</div>
<!-- Derecha: Estado -->
<div class="flex items-center gap-6">
<div class="flex items-center gap-2">
<div class="flex items-center gap-1.5 px-3 py-1.5 bg-primary-fixed text-on-primary-fixed-variant rounded-full text-xs font-bold">
<span class="w-2 h-2 bg-primary rounded-full animate-pulse"></span>
                    Conexión estable
                </div>
<div class="flex items-center gap-1.5 px-3 py-1.5 bg-error-container text-on-error-container rounded-full text-xs font-bold">
<span class="material-symbols-outlined text-sm">notifications</span>
                    2 Alertas
                </div>
</div>
<span class="material-symbols-outlined text-[#0c6440] cursor-pointer hover:opacity-70">account_circle</span>
</div>
</header>
<!-- Navigation Menu (Top Level) -->
<nav class="bg-[#eaf7f0] dark:bg-emerald-900/20 px-8 flex items-center gap-8 overflow-x-auto no-scrollbar">
<a class="text-[#0c6440] dark:text-emerald-400 font-bold border-b-2 border-[#0c6440] pb-3 pt-4 transition-all whitespace-nowrap" href="#">Dashboard</a>
<a class="text-[#3f4942] dark:text-emerald-200/60 font-medium hover:text-[#2f7d57] transition-all pb-3 pt-4 whitespace-nowrap" href="#">Cultivos</a>
<a class="text-[#3f4942] dark:text-emerald-200/60 font-medium hover:text-[#2f7d57] transition-all pb-3 pt-4 whitespace-nowrap" href="#">Insumos</a>
<a class="text-[#3f4942] dark:text-emerald-200/60 font-medium hover:text-[#2f7d57] transition-all pb-3 pt-4 whitespace-nowrap" href="#">Recomendaciones</a>
<a class="text-[#3f4942] dark:text-emerald-200/60 font-medium hover:text-[#2f7d57] transition-all pb-3 pt-4 whitespace-nowrap" href="#">Reportes</a>
<a class="text-[#3f4942] dark:text-emerald-200/60 font-medium hover:text-[#2f7d57] transition-all pb-3 pt-4 whitespace-nowrap" href="#">Sincronización</a>
<a class="text-[#3f4942] dark:text-emerald-200/60 font-medium hover:text-[#2f7d57] transition-all pb-3 pt-4 whitespace-nowrap" href="#">Perfil</a>
</nav>
<div class="flex flex-1 overflow-hidden">
<!-- Sidebar Navigation -->
<aside class="hidden md:flex h-full w-72 flex flex-col space-y-2 bg-[#eaf7f0] dark:bg-emerald-900/10 pt-8 pb-8 flex-shrink-0">
<div class="px-6 mb-6">
<h3 class="text-on-surface-variant text-[10px] font-bold uppercase tracking-widest mb-4">Navegación del sistema</h3>
<div class="flex items-center gap-3 p-4 bg-surface-container-highest rounded-2xl editorial-shadow">
<div class="w-10 h-10 rounded-full overflow-hidden bg-primary-fixed-dim">
<img class="w-full h-full object-cover" data-alt="close up of a professional farmer smiling in a sustainable greenhouse wearing an apron" src="https://lh3.googleusercontent.com/aida-public/AB6AXuD9ReX2p-rBECP9e-ttxXq9qUdluYfn2P4_kQP6fu-tysfI_Hq8HGhNk5b4lAE6FIyGsm-DEQ1me44Drluu29kTgB2ra3qCgbCvwjDXy9mBidCIC0eaeVUSlM_PFx4V8_6n_D6OIbIwSn79UUpnsdktFU1JI7qlOEtPR6tVT9BFkKF66p6mYaOAiF5z2lYrWu8QLFSa4TTYf1sIO446TY-_h8JF734t93zEirc1lXtL-X5arhZsp0UBBMUbFiOlgm_O1hIUcrbrw5A"/>
</div>
<div>
<p class="text-sm font-bold text-on-surface">Cultivador Digital</p>
<p class="text-[10px] text-on-surface-variant">Zona Norte - Parcela 4</p>
</div>
</div>
</div>
<nav class="flex flex-col space-y-1">
<div class="bg-[#d9e5df] dark:bg-emerald-800/40 text-[#0c6440] dark:text-emerald-300 font-semibold rounded-r-full py-3 px-6 flex items-center gap-4 cursor-pointer">
<span class="material-symbols-outlined">dashboard</span>
<span class="text-sm">Resumen general</span>
</div>
<div class="text-[#3f4942] dark:text-emerald-100/70 hover:bg-[#d9e5df]/50 py-3 px-6 flex items-center gap-4 cursor-pointer transition-transform duration-300 hover:translate-x-1">
<span class="material-symbols-outlined">bolt</span>
<span class="text-sm">Accesos rápidos</span>
</div>
<div class="text-[#3f4942] dark:text-emerald-100/70 hover:bg-[#d9e5df]/50 py-3 px-6 flex items-center gap-4 cursor-pointer transition-transform duration-300 hover:translate-x-1">
<span class="material-symbols-outlined">settings_input_component</span>
<span class="text-sm">Estado de módulos</span>
</div>
<div class="text-[#3f4942] dark:text-emerald-100/70 hover:bg-[#d9e5df]/50 py-3 px-6 flex items-center gap-4 cursor-pointer transition-transform duration-300 hover:translate-x-1">
<span class="material-symbols-outlined">history</span>
<span class="text-sm">Actividad reciente</span>
</div>
<div class="text-[#3f4942] dark:text-emerald-100/70 hover:bg-[#d9e5df]/50 py-3 px-6 flex items-center gap-4 cursor-pointer transition-transform duration-300 hover:translate-x-1">
<span class="material-symbols-outlined">help_outline</span>
<span class="text-sm">Ayuda</span>
</div>
</nav>
<div class="mt-auto px-6 space-y-4">
<div class="p-4 bg-surface-container rounded-2xl space-y-3">
<div class="flex items-center justify-between">
<span class="text-[10px] font-bold text-on-surface-variant uppercase">Estado</span>
<div class="px-2 py-0.5 bg-primary-fixed text-on-primary-fixed-variant rounded text-[9px] font-bold uppercase">Operativo</div>
</div>
<div class="flex items-center justify-between">
<span class="text-[10px] font-bold text-on-surface-variant uppercase">Conexión</span>
<div class="px-2 py-0.5 bg-secondary-fixed text-on-secondary-fixed-variant rounded text-[9px] font-bold uppercase">Variable</div>
</div>
</div>
<button class="w-full py-4 bg-gradient-to-br from-primary to-primary-container text-on-primary rounded-xl font-bold flex items-center justify-center gap-2 active:scale-95 duration-200 editorial-shadow">
<span class="material-symbols-outlined">add_circle</span>
                    Nueva Tarea
                </button>
</div>
</aside>
<!-- Main Content Canvas -->
<main class="flex-1 overflow-y-auto bg-surface p-8 lg:px-12">
<!-- Header Editorial Section -->
<div class="mb-12 flex flex-col lg:flex-row justify-between items-end gap-6">
<div class="max-w-2xl">
<span class="text-primary font-bold tracking-widest text-xs uppercase mb-2 block">Vista General de Operaciones</span>
<h1 class="text-4xl lg:text-5xl font-black text-on-surface leading-tight tracking-tighter">Tu campo, bajo control digital inteligente.</h1>
</div>
<div class="flex gap-3">
<button class="px-6 py-3 bg-surface-container-highest text-primary font-bold rounded-xl active:scale-95 transition-all text-sm border-b-2 border-primary/20">
                        Configurar Dashboard
                    </button>
</div>
</div>
<!-- Sección 0: Tabla de Cobertura -->
<section class="mb-12 bg-surface-container-low rounded-3xl p-8 editorial-shadow">
<h3 class="text-xl font-bold text-on-surface mb-6 flex items-center gap-2">
<span class="material-symbols-outlined text-primary">analytics</span>
                    Cobertura de casos de uso
                </h3>
<div class="overflow-x-auto">
<table class="w-full text-left border-separate border-spacing-y-2">
<thead>
<tr class="text-on-surface-variant text-xs font-bold uppercase tracking-wider">
<th class="px-4 pb-4">Módulos Integrados</th>
<th class="px-4 pb-4">Indicador de Evidencia</th>
<th class="px-4 pb-4">Estado de Auditoría</th>
</tr>
</thead>
<tbody>
<tr class="bg-surface-container-lowest rounded-xl">
<td class="px-4 py-4 font-bold text-on-surface">Gestión de Cultivos</td>
<td class="px-4 py-4 text-sm">Mapping de parcelas GPS activo</td>
<td class="px-4 py-4">
<span class="px-3 py-1 bg-primary-fixed text-on-primary-fixed-variant rounded-full text-[10px] font-extrabold uppercase tracking-tighter">Validado</span>
</td>
</tr>
<tr class="bg-surface-container-lowest rounded-xl">
<td class="px-4 py-4 font-bold text-on-surface">Control de Insumos</td>
<td class="px-4 py-4 text-sm">Inventario en tiempo real (QR)</td>
<td class="px-4 py-4">
<span class="px-3 py-1 bg-primary-fixed text-on-primary-fixed-variant rounded-full text-[10px] font-extrabold uppercase tracking-tighter">Validado</span>
</td>
</tr>
<tr class="bg-surface-container-lowest rounded-xl">
<td class="px-4 py-4 font-bold text-on-surface">Análisis Predictivo</td>
<td class="px-4 py-4 text-sm">Modelos de IA estacionales</td>
<td class="px-4 py-4">
<span class="px-3 py-1 bg-secondary-fixed text-on-secondary-fixed-variant rounded-full text-[10px] font-extrabold uppercase tracking-tighter">En Proceso</span>
</td>
</tr>
</tbody>
</table>
</div>
</section>
<!-- Sección A: Accesos Rápidos (Bento Grid) -->
<section class="mb-12">
<h3 class="text-xl font-bold text-on-surface mb-8">Módulos del Sistema</h3>
<div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
<!-- Cultivos -->
<div class="bg-surface-container-lowest p-6 rounded-[2rem] editorial-shadow group hover:bg-primary transition-colors duration-300">
<div class="w-12 h-12 bg-surface-container rounded-2xl flex items-center justify-center mb-6 text-primary group-hover:bg-primary-container group-hover:text-on-primary-container">
<span class="material-symbols-outlined">agriculture</span>
</div>
<h4 class="text-xl font-bold text-on-surface group-hover:text-on-primary mb-2">Cultivos</h4>
<p class="text-on-surface-variant group-hover:text-on-primary/80 text-sm mb-8 leading-relaxed">Gestión de ciclos fenológicos y salud vegetal por parcela.</p>
<button class="w-full py-3 bg-surface-container-high text-primary font-bold rounded-xl group-hover:bg-on-primary-container group-hover:text-primary active:scale-95 transition-all">Entrar</button>
</div>
<!-- Insumos -->
<div class="bg-surface-container-lowest p-6 rounded-[2rem] editorial-shadow group hover:bg-primary transition-colors duration-300">
<div class="w-12 h-12 bg-surface-container rounded-2xl flex items-center justify-center mb-6 text-primary group-hover:bg-primary-container group-hover:text-on-primary-container">
<span class="material-symbols-outlined">inventory_2</span>
</div>
<h4 class="text-xl font-bold text-on-surface group-hover:text-on-primary mb-2">Insumos</h4>
<p class="text-on-surface-variant group-hover:text-on-primary/80 text-sm mb-8 leading-relaxed">Stock crítico de fertilizantes, semillas y agroquímicos.</p>
<button class="w-full py-3 bg-surface-container-high text-primary font-bold rounded-xl group-hover:bg-on-primary-container group-hover:text-primary active:scale-95 transition-all">Entrar</button>
</div>
<!-- Recomendaciones -->
<div class="bg-surface-container-lowest p-6 rounded-[2rem] editorial-shadow group hover:bg-primary transition-colors duration-300">
<div class="w-12 h-12 bg-surface-container rounded-2xl flex items-center justify-center mb-6 text-primary group-hover:bg-primary-container group-hover:text-on-primary-container">
<span class="material-symbols-outlined">psychology</span>
</div>
<h4 class="text-xl font-bold text-on-surface group-hover:text-on-primary mb-2">Recomendaciones</h4>
<p class="text-on-surface-variant group-hover:text-on-primary/80 text-sm mb-8 leading-relaxed">Sugerencias inteligentes basadas en clima y suelo.</p>
<button class="w-full py-3 bg-surface-container-high text-primary font-bold rounded-xl group-hover:bg-on-primary-container group-hover:text-primary active:scale-95 transition-all">Entrar</button>
</div>
<!-- Reportes -->
<div class="bg-surface-container-lowest p-6 rounded-[2rem] editorial-shadow group hover:bg-primary transition-colors duration-300">
<div class="w-12 h-12 bg-surface-container rounded-2xl flex items-center justify-center mb-6 text-primary group-hover:bg-primary-container group-hover:text-on-primary-container">
<span class="material-symbols-outlined">description</span>
</div>
<h4 class="text-xl font-bold text-on-surface group-hover:text-on-primary mb-2">Reportes</h4>
<p class="text-on-surface-variant group-hover:text-on-primary/80 text-sm mb-8 leading-relaxed">Informes de rendimiento y costos operativos exportables.</p>
<button class="w-full py-3 bg-surface-container-high text-primary font-bold rounded-xl group-hover:bg-on-primary-container group-hover:text-primary active:scale-95 transition-all">Entrar</button>
</div>
<!-- Sincronización -->
<div class="bg-surface-container-lowest p-6 rounded-[2rem] editorial-shadow group hover:bg-primary transition-colors duration-300">
<div class="w-12 h-12 bg-surface-container rounded-2xl flex items-center justify-center mb-6 text-primary group-hover:bg-primary-container group-hover:text-on-primary-container">
<span class="material-symbols-outlined">sync</span>
</div>
<h4 class="text-xl font-bold text-on-surface group-hover:text-on-primary mb-2">Sincronización</h4>
<p class="text-on-surface-variant group-hover:text-on-primary/80 text-sm mb-8 leading-relaxed">Actualización de datos con la central en la nube.</p>
<button class="w-full py-3 bg-surface-container-high text-primary font-bold rounded-xl group-hover:bg-on-primary-container group-hover:text-primary active:scale-95 transition-all">Entrar</button>
</div>
<!-- Perfil -->
<div class="bg-surface-container-lowest p-6 rounded-[2rem] editorial-shadow group hover:bg-primary transition-colors duration-300">
<div class="w-12 h-12 bg-surface-container rounded-2xl flex items-center justify-center mb-6 text-primary group-hover:bg-primary-container group-hover:text-on-primary-container">
<span class="material-symbols-outlined">badge</span>
</div>
<h4 class="text-xl font-bold text-on-surface group-hover:text-on-primary mb-2">Perfil</h4>
<p class="text-on-surface-variant group-hover:text-on-primary/80 text-sm mb-8 leading-relaxed">Configuración de cuenta y niveles de acceso.</p>
<button class="w-full py-3 bg-surface-container-high text-primary font-bold rounded-xl group-hover:bg-on-primary-container group-hover:text-primary active:scale-95 transition-all">Entrar</button>
</div>
</div>
</section>
<!-- Grid Inferior (Secciones B, C, D) -->
<div class="grid grid-cols-1 lg:grid-cols-12 gap-8 mb-12">
<!-- Sección B: Estado de Módulos (Tabla) -->
<div class="lg:col-span-8 bg-surface-container rounded-[2.5rem] p-8">
<h3 class="text-xl font-bold text-on-surface mb-6">Estado de Módulos</h3>
<div class="space-y-4">
<div class="flex items-center justify-between p-4 bg-surface-container-lowest rounded-2xl">
<div class="flex items-center gap-4">
<div class="w-10 h-10 rounded-full bg-primary-fixed flex items-center justify-center text-on-primary-fixed-variant">
<span class="material-symbols-outlined text-sm">water_drop</span>
</div>
<div>
<p class="font-bold text-on-surface text-sm">Sensores de Humedad</p>
<p class="text-[10px] text-on-surface-variant">Lote A, B, C</p>
</div>
</div>
<div class="text-right">
<span class="px-3 py-1 bg-primary-fixed text-on-primary-fixed-variant rounded-full text-[10px] font-bold uppercase">Ok</span>
<p class="text-[10px] text-on-surface-variant mt-1">Hace 5 min</p>
</div>
</div>
<div class="flex items-center justify-between p-4 bg-surface-container-lowest rounded-2xl border-l-4 border-secondary">
<div class="flex items-center gap-4">
<div class="w-10 h-10 rounded-full bg-secondary-fixed flex items-center justify-center text-on-secondary-fixed-variant">
<span class="material-symbols-outlined text-sm">warning</span>
</div>
<div>
<p class="font-bold text-on-surface text-sm">Control de Plagas</p>
<p class="text-[10px] text-on-surface-variant">Lote D (Alerta de Oruga)</p>
</div>
</div>
<div class="text-right">
<span class="px-3 py-1 bg-secondary-container text-on-secondary-container rounded-full text-[10px] font-bold uppercase">Alerta</span>
<p class="text-[10px] text-on-surface-variant mt-1">Hace 1 h</p>
</div>
</div>
<div class="flex items-center justify-between p-4 bg-surface-container-lowest rounded-2xl">
<div class="flex items-center gap-4">
<div class="w-10 h-10 rounded-full bg-primary-fixed flex items-center justify-center text-on-primary-fixed-variant">
<span class="material-symbols-outlined text-sm">solar_power</span>
</div>
<div>
<p class="font-bold text-on-surface text-sm">Estación Meteorológica</p>
<p class="text-[10px] text-on-surface-variant">Activa 24/7</p>
</div>
</div>
<div class="text-right">
<span class="px-3 py-1 bg-primary-fixed text-on-primary-fixed-variant rounded-full text-[10px] font-bold uppercase">Ok</span>
<p class="text-[10px] text-on-surface-variant mt-1">En línea</p>
</div>
</div>
</div>
</div>
<!-- Sección C: Alertas y Pendientes -->
<div class="lg:col-span-4 flex flex-col gap-6">
<div class="bg-error-container text-on-error-container p-6 rounded-[2rem] flex flex-col justify-between">
<div>
<span class="material-symbols-outlined mb-4" style="font-variation-settings: 'FILL' 1;">priority_high</span>
<h4 class="font-bold text-lg leading-tight mb-2">Alertas Críticas</h4>
<p class="text-sm opacity-80 mb-4">Recomendaciones sin atender desde ayer.</p>
</div>
<button class="w-full py-3 bg-on-error-container text-surface-container-lowest font-bold rounded-xl text-sm">Ver Detalles</button>
</div>
<div class="bg-secondary-container text-on-secondary-container p-6 rounded-[2rem]">
<h4 class="font-bold text-lg mb-2">Datos Pendientes</h4>
<p class="text-sm opacity-80 mb-4">Sincronización requerida para 12 registros.</p>
<div class="w-full bg-on-secondary-container/20 h-1.5 rounded-full overflow-hidden">
<div class="bg-on-secondary-container h-full w-[65%]"></div>
</div>
</div>
</div>
</div>
<!-- Sección D & E -->
<div class="grid grid-cols-1 lg:grid-cols-12 gap-8 pb-12">
<!-- Sección D: Actividad Reciente -->
<div class="lg:col-span-7 bg-surface-container-low rounded-[2.5rem] p-8 border border-outline-variant/10">
<h3 class="text-xl font-bold text-on-surface mb-8">Actividad Reciente</h3>
<div class="space-y-8 relative">
<div class="absolute left-4 top-0 bottom-0 w-0.5 bg-outline-variant/30"></div>
<div class="relative flex gap-6 pl-10">
<div class="absolute left-2.5 top-1.5 w-3 h-3 rounded-full bg-primary border-4 border-surface-container-low"></div>
<div>
<p class="text-xs text-on-surface-variant font-medium">Hace 2 horas</p>
<p class="text-sm font-bold text-on-surface">Actualización de Cultivo - Parcela 2</p>
<p class="text-xs text-on-surface-variant">Se registró un avance en la etapa de floración del maíz.</p>
</div>
</div>
<div class="relative flex gap-6 pl-10">
<div class="absolute left-2.5 top-1.5 w-3 h-3 rounded-full bg-secondary border-4 border-surface-container-low"></div>
<div>
<p class="text-xs text-on-surface-variant font-medium">Hace 5 horas</p>
<p class="text-sm font-bold text-on-surface">Carga de Insumo - Fertilizante Nitrogenado</p>
<p class="text-xs text-on-surface-variant">Ingreso de 500kg al Almacén Central.</p>
</div>
</div>
<div class="relative flex gap-6 pl-10">
<div class="absolute left-2.5 top-1.5 w-3 h-3 rounded-full bg-outline border-4 border-surface-container-low"></div>
<div>
<p class="text-xs text-on-surface-variant font-medium">Ayer</p>
<p class="text-sm font-bold text-on-surface">Reporte Semanal Generado</p>
<p class="text-xs text-on-surface-variant">El sistema generó automáticamente el resumen de costos.</p>
</div>
</div>
</div>
</div>
<!-- Sección E: Atajos Operativos -->
<div class="lg:col-span-5 flex flex-col justify-center gap-4 bg-surface-container-highest/40 p-8 rounded-[2.5rem]">
<h3 class="text-sm font-bold text-on-surface-variant uppercase tracking-widest mb-4">Atajos Operativos</h3>
<button class="flex items-center justify-between p-5 bg-surface-container-lowest hover:bg-surface-container transition-colors rounded-2xl group">
<div class="flex items-center gap-4">
<span class="material-symbols-outlined text-primary group-hover:scale-110 transition-transform">add_task</span>
<span class="font-bold text-on-surface">Registrar cultivo</span>
</div>
<span class="material-symbols-outlined text-outline-variant">chevron_right</span>
</button>
<button class="flex items-center justify-between p-5 bg-surface-container-lowest hover:bg-surface-container transition-colors rounded-2xl group">
<div class="flex items-center gap-4">
<span class="material-symbols-outlined text-primary group-hover:scale-110 transition-transform">post_add</span>
<span class="font-bold text-on-surface">Registrar insumo</span>
</div>
<span class="material-symbols-outlined text-outline-variant">chevron_right</span>
</button>
<button class="flex items-center justify-between p-5 bg-primary-container text-on-primary-container rounded-2xl group shadow-lg shadow-primary/10">
<div class="flex items-center gap-4">
<span class="material-symbols-outlined group-hover:rotate-180 transition-transform duration-500">sync</span>
<span class="font-bold">Sincronizar ahora</span>
</div>
<span class="material-symbols-outlined">bolt</span>
</button>
</div>
</div>
<!-- Nota final: Auditoría -->
<footer class="mt-8 border-t border-outline-variant/20 pt-8 flex flex-col md:flex-row justify-between items-center text-[10px] text-on-surface-variant uppercase tracking-widest gap-4">
<div class="flex gap-4">
<span>Shell conservado: <span class="text-primary font-bold">Sí</span></span>
<span>Menú consistente: <span class="text-primary font-bold">Sí</span></span>
<span>Sidebar consistente: <span class="text-primary font-bold">Sí</span></span>
</div>
<div class="flex gap-4">
<span>Identidad AgroInteligente: <span class="text-primary font-bold">Sí</span></span>
<span>Dashboard completo: <span class="text-primary font-bold">Sí</span></span>
</div>
<div class="opacity-50">© 2024 AGROINTELIGENTE DIGITAL</div>
</footer>
</main>
</div>
</body></html>
```

---
