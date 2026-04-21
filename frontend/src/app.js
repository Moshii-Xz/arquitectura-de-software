const { useEffect, useMemo, useState } = React;
const html = htm.bind(React.createElement);

const appData = {
  dashboardMetrics: [
    { label: 'Hectareas activas', value: '8 ha', hint: '2 cultivos en seguimiento', icon: 'agriculture', tone: 'green' },
    { label: 'Salud general', value: '67%', hint: 'Nivel medio para el ciclo actual', icon: 'monitor_heart', tone: 'green' },
    { label: 'Alertas pendientes', value: '2', hint: 'Una requiere atencion hoy', icon: 'notifications', tone: 'gold' },
    { label: 'Ultima sincronizacion', value: '15 min', hint: 'Conectividad estable', icon: 'sync', tone: 'red' },
  ],
  moduleCards: [
    { title: 'Cultivos', text: 'Gestion de ciclos, lotes y estado productivo por parcela.', icon: 'agriculture', route: 'cultivos' },
    { title: 'Insumos', text: 'Aplicaciones, costos, inventario y recomendaciones de uso.', icon: 'inventory_2', route: 'insumos' },
    { title: 'Recomendaciones', text: 'Sugerencias operativas basadas en clima y estado del cultivo.', icon: 'psychology', route: 'alertas' },
    { title: 'Reportes', text: 'Indicadores y exportaciones listos para revision.', icon: 'description', route: 'dashboard' },
    { title: 'Sincronizacion', text: 'Seguimiento offline y cola de cambios pendientes.', icon: 'sync', route: 'sincronizacion' },
    { title: 'Perfil', text: 'Datos del productor, seguridad y preferencias.', icon: 'badge', route: 'perfil' },
  ],
  activeCrops: [
    { lot: 'Lote 01', crop: 'Maiz', area: '2.5 ha', zone: 'Sector A', status: 'Activo', health: '67%' },
    { lot: 'Lote 02', crop: 'Yuca', area: '1.8 ha', zone: 'Sector B', status: 'Activo', health: '89%' },
    { lot: 'Lote 03', crop: 'Platano', area: '3.2 ha', zone: 'Sector C', status: 'Archivado', health: '-' },
  ],
  tasks: [
    { time: 'Hoy 4:30 PM', title: 'Aplicar fertilizante', detail: 'Lote 01 - apoyo nutricional', icon: 'event' },
    { time: 'Mañana 7:00 AM', title: 'Riego manual', detail: 'Lote 02 - humedad baja', icon: 'water_drop' },
    { time: 'Proxima semana', title: 'Inspeccion fitosanitaria', detail: 'Lote 03 - control preventivo', icon: 'visibility' },
  ],
  alerts: [
    { title: 'Alerta climatica', text: 'Vientos fuertes detectados para la tarde.', tone: 'warning', icon: 'storm' },
    { title: 'Recomendacion de riego', text: 'Ajustar volumen en Lote 02 por humedad baja.', tone: 'success', icon: 'water_drop' },
    { title: 'Modo offline activo', text: 'Los cambios se estan guardando localmente.', tone: 'neutral', icon: 'signal_wifi_off' },
  ],
  activities: [
    { date: '05-04-2026', time: '18:42', type: 'Fertilizacion', lot: 'Lote 01', status: 'Registrada' },
    { date: '05-04-2026', time: '12:10', type: 'Riego', lot: 'Lote 02', status: 'Pendiente de sincronizacion' },
    { date: '04-04-2026', time: '09:15', type: 'Control plagas', lot: 'Lote 03', status: 'Con conflicto' },
  ],
  inputs: [
    { name: 'Urea granulada', stock: '24 sacos', use: 'Fertilizacion', status: 'Disponible' },
    { name: 'Fungicida bio', stock: '8 litros', use: 'Control preventivo', status: 'Bajo' },
    { name: 'Semilla certificada', stock: '14 kg', use: 'Siembra', status: 'Disponible' },
  ],
  syncHistory: [
    { date: '05-04-2026', time: '18:42', records: '12 items', size: '42 KB', status: 'Exitoso' },
    { date: '05-04-2026', time: '12:10', records: '3 items', size: '8 KB', status: 'Exitoso' },
    { date: '04-04-2026', time: '09:15', records: '45 items', size: '156 KB', status: 'Fallido' },
  ],
};

const routeMap = {
  dashboard: { title: 'Dashboard Principal', description: 'Vista general de la finca con accesos rapidos, alertas y actividad reciente.' },
  cultivos: { title: 'Gestion de Cultivos', description: 'Listado, filtros y detalle de lotes productivos.' },
  actividades: { title: 'Gestion de Actividades', description: 'Registro y seguimiento de labores del campo.' },
  insumos: { title: 'Gestion de Insumos', description: 'Inventario, aplicaciones y control de uso.' },
  alertas: { title: 'Alertas del Sistema', description: 'Notificaciones, recomendaciones y prioridades.' },
  sincronizacion: { title: 'Sincronizacion y Offline', description: 'Estado local, progreso y historial de sincronizacion.' },
  perfil: { title: 'Gestion de Perfil', description: 'Datos personales, seguridad y preferencias.' },
  shell: { title: 'Shell Base', description: 'Layout reutilizable del frontend.' },
  login: { title: 'Iniciar Sesion', description: 'Acceso al sistema AgroInteligente.' },
  'login-v2': { title: 'Iniciar Sesion V2', description: 'Variacion visual alternativa del login.' },
  registro: { title: 'Registro Exitoso', description: 'Confirmacion y onboarding inicial.' },
};

const mainNav = [
  { id: 'dashboard', label: 'Dashboard', icon: 'dashboard' },
  { id: 'cultivos', label: 'Cultivos', icon: 'agriculture' },
  { id: 'actividades', label: 'Actividades', icon: 'event_note' },
  { id: 'alertas', label: 'Alertas', icon: 'notifications_active' },
  { id: 'sincronizacion', label: 'Sync', icon: 'sync' },
  { id: 'perfil', label: 'Perfil', icon: 'badge' },
];

function getRoute() {
  const raw = window.location.hash.replace(/^#\/?/, '');
  return raw || 'dashboard';
}

function go(route) {
  window.location.hash = `#/${route}`;
}

function joinClasses(...parts) {
  return parts.filter(Boolean).join(' ');
}

function Icon({ name, filled = false, className = '' }) {
  return html`<span className=${joinClasses('material-symbols-outlined', className)} style=${filled ? { fontVariationSettings: "'FILL' 1" } : undefined}>${name}</span>`;
}

function Badge({ tone = 'neutral', children }) {
  return html`<span className=${joinClasses('badge', `badge--${tone}`)}>${children}</span>`;
}

function Button({ tone = 'primary', onClick, children, type = 'button' }) {
  return html`<button type=${type} className=${joinClasses('button', `button--${tone}`)} onClick=${onClick}>${children}</button>`;
}

function Card({ title, subtitle, children, actions, className = '' }) {
  return html`
    <article className=${joinClasses('card', className)}>
      ${(title || subtitle || actions) && html`
        <div className="card__header">
          <div>
            ${title && html`<h3 className="card__title">${title}</h3>`}
            ${subtitle && html`<p className="card__subtitle">${subtitle}</p>`}
          </div>
          ${actions}
        </div>
      `}
      <div className="card__body">${children}</div>
    </article>
  `;
}

function SectionTitle({ eyebrow, title, description, actions }) {
  return html`
    <div className="card__header" style=${{ alignItems: 'end' }}>
      <div>
        ${eyebrow && html`<p className="section-kicker">${eyebrow}</p>`}
        <h2 className="section-title">${title}</h2>
        ${description && html`<p className="page__lead" style=${{ marginTop: '0', maxWidth: 'none' }}>${description}</p>`}
      </div>
      ${actions}
    </div>
  `;
}

function Table({ headers, rows, renderRow, empty }) {
  return html`
    <div className="table-wrap">
      <table>
        <thead>
          <tr>
            ${headers.map((header) => html`<th key=${header}>${header}</th>`)}
          </tr>
        </thead>
        <tbody>
          ${rows.length
            ? rows.map((row, index) => renderRow(row, index))
            : html`<tr><td colspan=${headers.length}>${empty || 'Sin datos'}</td></tr>`}
        </tbody>
      </table>
    </div>
  `;
}

function ShellLayout({ route, title, description, children }) {
  return html`
    <div className="app-frame">
      <div className="top-strip">
        <div>
          <p className="top-strip__title">Frontend React funcional</p>
          <p className="top-strip__subtitle">Materializacion de vistas AgroInteligente</p>
        </div>
        <div className="pill pill--success">
          <${Icon} name="signal_wifi_4_bar" />
          Online
        </div>
      </div>

      <div className="topbar">
        <div className="brand">
          <div className="brand__mark"><${Icon} name="eco" filled /></div>
          <div>
            <h1 className="brand__name">AgroInteligente</h1>
            <p className="brand__meta">${title}</p>
          </div>
        </div>

        <nav className="topnav" aria-label="Navegacion principal">
          ${mainNav.map((item) => html`
            <a
              key=${item.id}
              className=${joinClasses('topnav__link', route === item.id && 'topnav__link--active')}
              href=${`#/${item.id}`}
            >
              <${Icon} name=${item.icon} />
              ${item.label}
            </a>
          `)}
        </nav>

        <div className="topbar__actions">
          <button className="icon-btn" onClick=${() => go('sincronizacion')} aria-label="Sincronizar">
            <${Icon} name="sync" />
          </button>
          <button className="icon-btn" onClick=${() => go('perfil')} aria-label="Perfil">
            <${Icon} name="account_circle" />
          </button>
          <${Badge} tone="success">2 alertas</${Badge}>
        </div>
      </div>

      <div className="shell">
        <aside className="sidebar">
          <div className="sidebar__section">
            <p className="sidebar__title">Navegacion</p>
            <div className="sidebar__panel">
              <div className="sidebar__stats">
                <div className="compact-item">
                  <div>
                    <p className="compact-item__title">Cultivador digital</p>
                    <p className="compact-item__meta">Zona Norte - Parcela 4</p>
                  </div>
                  <${Badge} tone="success">Operativo</${Badge}>
                </div>
                ${mainNav.map((item) => html`
                  <a
                    key=${item.id}
                    className=${joinClasses('side-link', route === item.id && 'side-link--active')}
                    href=${`#/${item.id}`}
                  >
                    <${Icon} name=${item.icon} />
                    ${item.label}
                  </a>
                `)}
              </div>
            </div>
          </div>

          <div className="sidebar__section">
            <p className="sidebar__title">Estado</p>
            <div className="sidebar__panel stack">
              <div>
                <div className="compact-item" style=${{ marginBottom: '0.65rem' }}>
                  <div>
                    <p className="compact-item__title">Conectividad</p>
                    <p className="compact-item__meta">Offline con sincronizacion pendiente</p>
                  </div>
                  <${Badge} tone="warning">Offline</${Badge}>
                </div>
                <div className="progress"><div className="progress__bar" style=${{ width: '72%' }}></div></div>
              </div>
              <${Button} tone="primary" onClick=${() => go('dashboard')}>Ir al dashboard</${Button}>
              <${Button} tone="ghost" onClick=${() => go('login')}>Cerrar sesion</${Button}>
            </div>
          </div>
        </aside>

        <main className="main">
          <section className="page">
            <div className="page__hero">
              <div>
                <p className="page__eyebrow">${title}</p>
                <h2 className="page__title">${description}</h2>
              </div>
              <div className="topbar__actions">
                <${Badge} tone="success">React SPA</${Badge}>
                <${Button} tone="secondary" onClick=${() => go('registro')}>Onboarding</${Button}>
              </div>
            </div>

            ${children}
          </section>
        </main>
      </div>

      <nav className="mobile-nav" aria-label="Navegacion movil">
        ${mainNav.map((item) => html`
          <button
            key=${item.id}
            className=${joinClasses('mobile-nav__btn', route === item.id && 'mobile-nav__btn--active')}
            onClick=${() => go(item.id)}
            type="button"
          >
            <${Icon} name=${item.icon} />
          </button>
        `)}
      </nav>

      <div className="footer-note">AgroInteligente 2026 - frontend funcional para navegacion y maqueta operativa</div>
    </div>
  `;
}

function DashboardView() {
  return html`
    <${ShellLayout} route="dashboard" title=${routeMap.dashboard.title} description=${routeMap.dashboard.description}>
      <section className="grid grid--metrics">
        ${appData.dashboardMetrics.map((metric) => html`
          <${Card} key=${metric.label} className="card--metric">
            <div className="card__header" style=${{ marginBottom: '0.7rem' }}>
              <div className=${joinClasses('metric__icon', metric.tone === 'gold' ? 'metric__icon--gold' : metric.tone === 'red' ? 'metric__icon--red' : 'metric__icon--green')}>
                <${Icon} name=${metric.icon} />
              </div>
              <${Badge} tone=${metric.tone === 'red' ? 'danger' : metric.tone === 'gold' ? 'warning' : 'success'}>${metric.label}</${Badge}>
            </div>
            <p className="metric__value">${metric.value}</p>
            <p className="metric__hint">${metric.hint}</p>
          </${Card}>
        `)}
      </section>

      <section className="card card--solid" style=${{ padding: '1.2rem' }}>
        <${SectionTitle}
          eyebrow="Accesos rapidos"
          title="Mulos del sistema"
          description="Ruta directa hacia las vistas mas importantes del frontend."
          actions=${html`<${Badge} tone="neutral">11 vistas</${Badge}>`}
        />
        <div className="module-grid">
          ${appData.moduleCards.map((module) => html`
            <article key=${module.title} className="module-card">
              <div className="module-card__icon"><${Icon} name=${module.icon} /></div>
              <h3 className="module-card__title">${module.title}</h3>
              <p className="module-card__text">${module.text}</p>
              <${Button} tone="secondary" onClick=${() => go(module.route)}>Abrir</${Button}>
            </article>
          `)}
        </div>
      </section>

      <section className="grid grid--sidebar">
        <${Card} title="Cultivos activos" subtitle="Listado corto para seguimiento operativo">
          <${Table}
            headers=${['Lote', 'Cultivo', 'Area', 'Ubicacion', 'Estado', 'Salud']}
            rows=${appData.activeCrops}
            renderRow=${(crop) => html`
              <tr key=${crop.lot}>
                <td>${crop.lot}</td><td>${crop.crop}</td><td>${crop.area}</td><td>${crop.zone}</td><td><${Badge} tone=${crop.status === 'Activo' ? 'success' : 'neutral'}>${crop.status}</${Badge}></td><td>${crop.health}</td>
              </tr>
            `}
          />
        </${Card}>

        <div className="stack">
          <${Card} title="Alertas recientes" subtitle="Lo que requiere atencion inmediata">
            <div className="compact-list">
              ${appData.alerts.map((alert) => html`
                <div key=${alert.title} className="compact-item">
                  <div>
                    <p className="compact-item__title">${alert.title}</p>
                    <p className="compact-item__meta">${alert.text}</p>
                  </div>
                  <${Badge} tone=${alert.tone}>${alert.tone}</${Badge}>
                </div>
              `)}
            </div>
          </${Card}>

          <${Card} title="Prximas tareas" subtitle="Siguiente bloque de trabajo sugerido">
            <div className="compact-list">
              ${appData.tasks.map((task) => html`
                <div key=${task.title} className="compact-item">
                  <div>
                    <p className="compact-item__title">${task.time} - ${task.title}</p>
                    <p className="compact-item__meta">${task.detail}</p>
                  </div>
                  <${Icon} name=${task.icon} className="muted" />
                </div>
              `)}
            </div>
          </${Card}>
        </div>
      </section>
    </${ShellLayout}>
  `;
}

function CultivosView() {
  return html`
    <${ShellLayout} route="cultivos" title=${routeMap.cultivos.title} description=${routeMap.cultivos.description}>
      <section className="grid grid--three">
        <${Card} title="Filtros" subtitle="Estado, tipo y busqueda">
          <div className="stack">
            <div className="grid grid--two">
              <button className="button--secondary">Todos</button>
              <button className="button--ghost">Activos</button>
            </div>
            <input className="field__control" placeholder="Buscar por nombre de lote" />
          </div>
        </${Card}>
        <${Card} title="Nuevo cultivo" subtitle="Alta rapida con campos basicos">
          <div className="stack">
            <div className="form-grid">
              <input className="field__control" placeholder="Lote" />
              <input className="field__control" placeholder="Cultivo" />
            </div>
            <${Button} tone="primary">Registrar nuevo cultivo</${Button}>
          </div>
        </${Card}>
        <${Card} title="Detalle rapido" subtitle="Resumen de un lote seleccionado">
          <div className="stack">
            <div className="compact-item"><div><p className="compact-item__title">Lote 01</p><p className="compact-item__meta">Maiz - Sector A</p></div><${Badge} tone="success">67%</${Badge}></div>
            <div className="compact-item"><div><p className="compact-item__title">Ultima actividad</p><p className="compact-item__meta">Hace 2 horas</p></div><${Badge} tone="neutral">Hoy</${Badge}></div>
          </div>
        </${Card}>
      </section>

      <${Card} title="Tabla de cultivos" subtitle="Vista general de lotes activos y archivados">
        <${Table}
          headers=${['Lote', 'Cultivo', 'Area', 'Ubicacion', 'Estado', 'Salud', 'Ultima actividad']}
          rows=${appData.activeCrops}
          renderRow=${(crop) => html`
            <tr key=${crop.lot}>
              <td>${crop.lot}</td>
              <td>${crop.crop}</td>
              <td>${crop.area}</td>
              <td>${crop.zone}</td>
              <td><${Badge} tone=${crop.status === 'Activo' ? 'success' : 'neutral'}>${crop.status}</${Badge}></td>
              <td>${crop.health}</td>
              <td>Hoy 14:20</td>
            </tr>
          `}
        />
      </${Card}>
    </${ShellLayout}>
  `;
}

function ActividadesView() {
  return html`
    <${ShellLayout} route="actividades" title=${routeMap.actividades.title} description=${routeMap.actividades.description}>
      <section className="grid grid--sidebar">
        <${Card} title="Registrar actividad" subtitle="Formulario rapido de trabajo de campo">
          <div className="form-grid">
            <div className="field"><label className="field__label">Tipo</label><input className="field__control" placeholder="Fertilizacion" /></div>
            <div className="field"><label className="field__label">Lote</label><input className="field__control" placeholder="Lote 01" /></div>
            <div className="field"><label className="field__label">Fecha</label><input className="field__control" type="date" /></div>
            <div className="field"><label className="field__label">Hora</label><input className="field__control" type="time" /></div>
            <div className="field field--full"><label className="field__label">Descripcion</label><textarea className="field__control" rows="4" placeholder="Detalle de la tarea"></textarea></div>
          </div>
          <div className="spacer"></div>
          <${Button} tone="primary">Guardar actividad</${Button}>
        </${Card}>

        <${Card} title="Seguimiento" subtitle="Estados de sincronizacion y control">
          <div className="compact-list">
            ${appData.activities.map((activity) => html`
              <div key=${activity.time} className="compact-item">
                <div>
                  <p className="compact-item__title">${activity.date} ${activity.time}</p>
                  <p className="compact-item__meta">${activity.type} - ${activity.lot}</p>
                </div>
                <${Badge} tone=${activity.status.includes('Pendiente') ? 'warning' : activity.status.includes('conflicto') ? 'danger' : 'success'}>${activity.status}</${Badge}>
              </div>
            `)}
          </div>
        </${Card}>
      </section>

      <${Card} title="Historial reciente" subtitle="Ultimos registros cargados en el sistema">
        <${Table}
          headers=${['Fecha', 'Hora', 'Tipo', 'Lote', 'Estado']}
          rows=${appData.activities}
          renderRow=${(activity) => html`
            <tr key=${activity.time}>
              <td>${activity.date}</td>
              <td>${activity.time}</td>
              <td>${activity.type}</td>
              <td>${activity.lot}</td>
              <td><${Badge} tone=${activity.status.includes('Pendiente') ? 'warning' : activity.status.includes('conflicto') ? 'danger' : 'success'}>${activity.status}</${Badge}></td>
            </tr>
          `}
        />
      </${Card}>
    </${ShellLayout}>
  `;
}

function InsumosView() {
  return html`
    <${ShellLayout} route="insumos" title=${routeMap.insumos.title} description=${routeMap.insumos.description}>
      <section className="grid grid--metrics">
        <${Card} className="card--metric"><p className="metric__label">Inventario</p><p className="metric__value">42</p><p className="metric__hint">items vigentes en catalogo</p></${Card}>
        <${Card} className="card--metric"><p className="metric__label">Costo estimado</p><p className="metric__value">$1.8M</p><p className="metric__hint">consumo acumulado del ciclo</p></${Card}>
        <${Card} className="card--metric"><p className="metric__label">Alertas</p><p className="metric__value">3</p><p className="metric__hint">insumos de alto impacto</p></${Card}>
        <${Card} className="card--metric"><p className="metric__label">Recomendaciones</p><p className="metric__value">7</p><p className="metric__hint">sugerencias activas</p></${Card}>
      </section>

      <section className="grid grid--sidebar">
        <${Card} title="Aplicaciones recientes" subtitle="Control de uso y trazabilidad">
          <${Table}
            headers=${['Insumo', 'Stock', 'Uso', 'Estado']}
            rows=${appData.inputs}
            renderRow=${(item) => html`
              <tr key=${item.name}>
                <td>${item.name}</td><td>${item.stock}</td><td>${item.use}</td><td><${Badge} tone=${item.status === 'Bajo' ? 'warning' : 'success'}>${item.status}</${Badge}></td>
              </tr>
            `}
          />
        </${Card}>

        <${Card} title="Catalogo inteligente" subtitle="Atajos de gestion">
          <div className="compact-list">
            <div className="compact-item"><div><p className="compact-item__title">Fertilizantes</p><p className="compact-item__meta">Control de costo y frecuencia</p></div><${Icon} name="eco" /></div>
            <div className="compact-item"><div><p className="compact-item__title">Agroquimicos</p><p className="compact-item__meta">Verificacion de riesgo ambiental</p></div><${Icon} name="warning" /></div>
            <div className="compact-item"><div><p className="compact-item__title">Semillas</p><p className="compact-item__meta">Disponibilidad y lote de origen</p></div><${Icon} name="inventory_2" /></div>
          </div>
        </${Card}>
      </section>
    </${ShellLayout}>
  `;
}

function AlertasView() {
  return html`
    <${ShellLayout} route="alertas" title=${routeMap.alertas.title} description=${routeMap.alertas.description}>
      <section className="grid grid--two">
        <${Card} title="Prioridades" subtitle="Alertas mas relevantes en la parte superior">
          <div className="compact-list">
            ${appData.alerts.map((alert) => html`
              <div key=${alert.title} className="compact-item">
                <div>
                  <p className="compact-item__title">${alert.title}</p>
                  <p className="compact-item__meta">${alert.text}</p>
                </div>
                <${Badge} tone=${alert.tone}>${alert.tone}</${Badge}>
              </div>
            `)}
          </div>
        </${Card}>

        <${Card} title="Centros de notificacion" subtitle="Canales y estado de entrega">
          <div className="compact-list">
            <div className="compact-item"><div><p className="compact-item__title">Push</p><p className="compact-item__meta">Envios inmediatos al dispositivo</p></div><${Badge} tone="success">Activo</${Badge}></div>
            <div className="compact-item"><div><p className="compact-item__title">SMS</p><p className="compact-item__meta">Fallback para alertas criticas</p></div><${Badge} tone="warning">En cola</${Badge}></div>
            <div className="compact-item"><div><p className="compact-item__title">Correo</p><p className="compact-item__meta">Resumen diario y cambios relevantes</p></div><${Badge} tone="success">Activo</${Badge}></div>
          </div>
        </${Card}>
      </section>
    </${ShellLayout}>
  `;
}

function SyncOfflineView() {
  return html`
    <${ShellLayout} route="sincronizacion" title=${routeMap.sincronizacion.title} description=${routeMap.sincronizacion.description}>
      <section className="grid grid--metrics">
        <${Card} className="card--metric"><p className="metric__label">Estado actual</p><p className="metric__value">Offline</p><p className="metric__hint">datos guardados localmente</p></${Card}>
        <${Card} className="card--metric"><p className="metric__label">Pendientes</p><p className="metric__value">7</p><p className="metric__hint">registros sin enviar</p></${Card}>
        <${Card} className="card--metric"><p className="metric__label">Tamano lote</p><p className="metric__value">18.4 KB</p><p className="metric__hint">optimizado para envio</p></${Card}>
        <${Card} className="card--metric"><p className="metric__label">Ultima sync</p><p className="metric__value">09:15</p><p className="metric__hint">06-04-2026</p></${Card}>
      </section>

      <section className="grid grid--sidebar">
        <${Card} title="Estado de transferencia" subtitle="Progreso de envio manual">
          <div className="stack">
            <div className="compact-item"><div><p className="compact-item__title">Esperando red estable</p><p className="compact-item__meta">Sincronizacion programada cuando vuelva la conexion</p></div><${Badge} tone="warning">0%</${Badge}></div>
            <div className="progress"><div className="progress__bar" style=${{ width: '0%' }}></div></div>
            <div className="grid grid--two">
              <${Button} tone="primary">Sincronizar ahora</${Button}>
              <${Button} tone="ghost">Cancelar</${Button}>
            </div>
          </div>
        </${Card}>

        <${Card} title="Reglas tecnicas" subtitle="Comportamiento operativo del modo offline">
          <div className="compact-list">
            <div className="compact-item"><div><p className="compact-item__title">Almacenamiento local</p><p className="compact-item__meta">IndexedDB para cambios pendientes</p></div><${Icon} name="database" /></div>
            <div className="compact-item"><div><p className="compact-item__title">Reintento automatico</p><p className="compact-item__meta">Envio cuando la conexion sea estable</p></div><${Icon} name="refresh" /></div>
            <div className="compact-item"><div><p className="compact-item__title">Validacion de integridad</p><p className="compact-item__meta">Confirma coincidencia nube-local</p></div><${Icon} name="verified" /></div>
          </div>
        </${Card}>
      </section>

      <${Card} title="Historial de sincronizacion" subtitle="Eventos recientes del sistema">
        <${Table}
          headers=${['Fecha', 'Hora', 'Registros', 'Tamano', 'Estado']}
          rows=${appData.syncHistory}
          renderRow=${(item) => html`
            <tr key=${item.time}>
              <td>${item.date}</td><td>${item.time}</td><td>${item.records}</td><td>${item.size}</td><td><${Badge} tone=${item.status === 'Fallido' ? 'danger' : 'success'}>${item.status}</${Badge}></td>
            </tr>
          `}
        />
      </${Card}>
    </${ShellLayout}>
  `;
}

function PerfilView() {
  return html`
    <${ShellLayout} route="perfil" title=${routeMap.perfil.title} description=${routeMap.perfil.description}>
      <section className="profile-grid">
        <${Card} title="Resumen del usuario" subtitle="Identidad agricola y estado de perfil">
          <div className="profile-card stack">
            <div className="avatar">MR</div>
            <div>
              <p className="card__title" style=${{ marginBottom: '0.2rem' }}>Mateo Rodriguez</p>
              <p className="card__subtitle">Productor agricola - Valle del Cauca</p>
            </div>
            <div className="compact-list">
              <div className="compact-item"><div><p className="compact-item__title">Ubicacion</p><p className="compact-item__meta">Vereda El Porvenir, Salento</p></div><${Badge} tone="neutral">ACTUAL</${Badge}></div>
              <div className="compact-item"><div><p className="compact-item__title">Perfil</p><p className="compact-item__meta">85% completado</p></div><${Badge} tone="success">Listo</${Badge}></div>
            </div>
          </div>
        </${Card}>

        <${Card} title="Datos y seguridad" subtitle="Edicion basica de cuenta y preferencias">
          <div className="form-grid">
            <div className="field"><label className="field__label">Nombre completo</label><input className="field__control" defaultValue="Mateo Rodriguez" /></div>
            <div className="field"><label className="field__label">Telefono</label><input className="field__control" defaultValue="+57 300 123 4567" /></div>
            <div className="field field--full"><label className="field__label">Ubicacion de la finca</label><input className="field__control" placeholder="Km 4 Via Palmira, Hacienda La Esperanza" /></div>
            <div className="field"><label className="field__label">Contraseña actual</label><input className="field__control" type="password" defaultValue="********" /></div>
            <div className="field"><label className="field__label">Nueva contraseña</label><input className="field__control" type="password" placeholder="Minimo 8 caracteres" /></div>
            <div className="field"><label className="field__label">Idioma</label><select className="field__control"><option>Español (Colombia)</option><option>English</option></select></div>
            <div className="field"><label className="field__label">Notificaciones</label><select className="field__control"><option>Aplicacion + SMS</option><option>Solo aplicacion</option></select></div>
          </div>
          <div className="spacer"></div>
          <div className="grid grid--two">
            <${Button} tone="primary">Guardar cambios</${Button}>
            <${Button} tone="ghost">Cancelar</${Button}>
          </div>
        </${Card}>
      </section>
    </${ShellLayout}>
  `;
}

function ShellView() {
  return html`
    <${ShellLayout} route="shell" title=${routeMap.shell.title} description=${routeMap.shell.description}>
      <section className="grid grid--two">
        <${Card} title="Layout base" subtitle="Header, sidebar y contenido reutilizable">
          <div className="compact-list">
            <div className="compact-item"><div><p className="compact-item__title">TopBar</p><p className="compact-item__meta">Marca, estado y acciones rapidas</p></div><${Badge} tone="success">Listo</${Badge}></div>
            <div className="compact-item"><div><p className="compact-item__title">SideNav</p><p className="compact-item__meta">Navegacion persistente por modulo</p></div><${Badge} tone="success">Listo</${Badge}></div>
            <div className="compact-item"><div><p className="compact-item__title">Cards y tablas</p><p className="compact-item__meta">Componentes base para el resto de vistas</p></div><${Badge} tone="success">Listo</${Badge}></div>
          </div>
        </${Card}>
        <${Card} title="Accesos directos" subtitle="Prueba rapida de navegacion">
          <div className="grid grid--two">
            <${Button} tone="primary" onClick=${() => go('dashboard')}>Dashboard</${Button}>
            <${Button} tone="secondary" onClick=${() => go('cultivos')}>Cultivos</${Button}>
            <${Button} tone="secondary" onClick=${() => go('sincronizacion')}>Sync</${Button}>
            <${Button} tone="ghost" onClick=${() => go('perfil')}>Perfil</${Button}>
          </div>
        </${Card}>
      </section>
    </${ShellLayout}>
  `;
}

function LoginView() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  function submit(event) {
    event.preventDefault();
    if (email.trim() && password.trim()) {
      go('dashboard');
    }
  }

  return html`
    <div className="app-frame">
      <div className="top-strip">
        <div>
          <p className="top-strip__title">Acceso al sistema</p>
          <p className="top-strip__subtitle">Pantalla de inicio de sesion React</p>
        </div>
        <${Badge} tone="success">Online Status</${Badge}>
      </div>

      <div className="auth-layout">
        <section className="hero-slab">
          <div style=${{ position: 'relative', zIndex: 1 }}>
            <div className="brand" style=${{ marginBottom: '1.6rem' }}>
              <div className="brand__mark"><${Icon} name="eco" filled /></div>
              <div><h1 className="brand__name" style=${{ color: 'white' }}>AgroInteligente</h1><p className="brand__meta" style=${{ color: 'rgba(255,255,255,0.8)' }}>Frontend funcional</p></div>
            </div>
            <h2 className="hero-slab__title">Cultive el futuro con inteligencia digital.</h2>
            <p className="hero-slab__text">Acceda a cultivos, actividades, alertas y sincronizacion offline en una interfaz web construida en React.</p>
          </div>
        </section>

        <section className="auth-panel">
          <form className="auth-card stack" onSubmit=${submit}>
            <div>
              <h2 className="auth-card__title">Bienvenido</h2>
              <p className="auth-card__text">Ingrese sus credenciales para acceder al panel.</p>
            </div>

            <div className="form-grid">
              <div className="field field--full"><label className="field__label">Email o documento</label><input className="field__control" value=${email} onInput=${(event) => setEmail(event.target.value)} placeholder="ejemplo@agro.com" /></div>
              <div className="field field--full"><label className="field__label">Contrasena</label><input className="field__control" type="password" value=${password} onInput=${(event) => setPassword(event.target.value)} placeholder="********" /></div>
            </div>

            <div className="grid grid--two">
              <${Button} type="submit" tone="primary">Iniciar sesion</${Button}>
              <${Button} tone="ghost" onClick=${() => go('registro')}>Crear cuenta</${Button}>
            </div>

            <div className="compact-item"><div><p className="compact-item__title">Acceso rapido</p><p className="compact-item__meta">Usa la vista dashboard como entrada principal</p></div><${Button} tone="secondary" onClick=${() => go('dashboard')}>Entrar</${Button}></div>
          </form>
        </section>
      </div>
    </div>
  `;
}

function LoginV2View() {
  return html`
    <div className="app-frame">
      <div className="auth-layout">
        <section className="hero-slab" style=${{ borderRadius: '0' }}>
          <h2 className="hero-slab__title">Gestion agraria con una experiencia simple y rapida.</h2>
          <p className="hero-slab__text">Variante visual alternativa del inicio de sesion para comparar estilos sin perder el mismo flujo funcional.</p>
        </section>
        <section className="auth-panel">
          <div className="auth-card stack">
            <div>
              <h2 className="auth-card__title">Iniciar sesion V2</h2>
              <p className="auth-card__text">Mismo flujo, diferente tratamiento visual.</p>
            </div>
            <div className="form-grid">
              <div className="field field--full"><label className="field__label">Usuario</label><input className="field__control" placeholder="agricultor@correo.com" /></div>
              <div className="field field--full"><label className="field__label">Contrasena</label><input className="field__control" type="password" placeholder="********" /></div>
            </div>
            <${Button} tone="primary" onClick=${() => go('dashboard')}>Entrar al sistema</${Button}>
            <${Button} tone="ghost" onClick=${() => go('login')}>Volver a la version original</${Button}>
          </div>
        </section>
      </div>
    </div>
  `;
}

function RegistroExitosoView() {
  return html`
    <div className="app-frame">
      <div className="auth-panel" style=${{ minHeight: '100vh' }}>
        <div className="auth-card stack" style=${{ width: 'min(100%, 760px)' }}>
          <div className="hero-slab" style=${{ minHeight: 'auto', borderRadius: '28px' }}>
            <h2 className="hero-slab__title">Cuenta creada con exito.</h2>
            <p className="hero-slab__text">Hemos preparado el siguiente paso para activar la cuenta y empezar a trabajar con la plataforma.</p>
          </div>
          <div className="grid grid--two">
            <div className="compact-item"><div><p className="compact-item__title">Email</p><p className="compact-item__meta">Revisa tu bandeja y spam</p></div><${Badge} tone="success">Verificar</${Badge}></div>
            <div className="compact-item"><div><p className="compact-item__title">SMS</p><p className="compact-item__meta">Codigo de 6 digitos listo</p></div><${Badge} tone="warning">Pendiente</${Badge}></div>
          </div>
          <div className="grid grid--two">
            <${Button} tone="primary" onClick=${() => go('login')}>Ir al login</${Button}>
            <${Button} tone="ghost" onClick=${() => go('dashboard')}>Abrir dashboard</${Button}>
          </div>
        </div>
      </div>
    </div>
  `;
}

function App() {
  const [route, setRoute] = useState(getRoute());

  useEffect(() => {
    const syncRoute = () => setRoute(getRoute());
    if (!window.location.hash) {
      window.location.hash = '#/dashboard';
    }
    window.addEventListener('hashchange', syncRoute);
    return () => window.removeEventListener('hashchange', syncRoute);
  }, []);

  const normalizedRoute = useMemo(() => {
    if (route in routeMap) {
      return route;
    }
    return 'dashboard';
  }, [route]);

  if (normalizedRoute === 'login') {
    return html`<${LoginView} />`;
  }

  if (normalizedRoute === 'login-v2') {
    return html`<${LoginV2View} />`;
  }

  if (normalizedRoute === 'registro') {
    return html`<${RegistroExitosoView} />`;
  }

  if (normalizedRoute === 'shell') {
    return html`<${ShellView} />`;
  }

  switch (normalizedRoute) {
    case 'cultivos':
      return html`<${CultivosView} />`;
    case 'actividades':
      return html`<${ActividadesView} />`;
    case 'insumos':
      return html`<${InsumosView} />`;
    case 'alertas':
      return html`<${AlertasView} />`;
    case 'sincronizacion':
      return html`<${SyncOfflineView} />`;
    case 'perfil':
      return html`<${PerfilView} />`;
    case 'dashboard':
    default:
      return html`<${DashboardView} />`;
  }
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(html`<${App} />`);