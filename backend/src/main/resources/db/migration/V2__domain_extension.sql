ALTER TABLE users
    ADD COLUMN IF NOT EXISTS ultimo_acceso TIMESTAMP,
    ADD COLUMN IF NOT EXISTS intentos_fallidos INT NOT NULL DEFAULT 0,
    ADD COLUMN IF NOT EXISTS bloqueado_hasta TIMESTAMP;

CREATE TABLE IF NOT EXISTS perfil (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    usuario_id UUID NOT NULL UNIQUE REFERENCES users(id),
    municipio VARCHAR(120),
    vereda VARCHAR(120),
    finca VARCHAR(120),
    telefono VARCHAR(20),
    idioma VARCHAR(20) DEFAULT 'es',
    foto_url VARCHAR(500),
    latitud DOUBLE PRECISION,
    longitud DOUBLE PRECISION,
    notificacion_push BOOLEAN NOT NULL DEFAULT TRUE,
    notificacion_email BOOLEAN NOT NULL DEFAULT TRUE,
    notificacion_sms BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS insumos (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nombre VARCHAR(120) NOT NULL,
    tipo VARCHAR(80) NOT NULL,
    unidad VARCHAR(60),
    impacto_ambiental BOOLEAN NOT NULL DEFAULT FALSE,
    costo_referencia NUMERIC(12,2),
    descripcion VARCHAR(500),
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    deleted_at TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS aplicaciones_insumo (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    cultivo_id UUID NOT NULL REFERENCES cultivos(id),
    insumo_id UUID NOT NULL REFERENCES insumos(id),
    cantidad NUMERIC(12,2) NOT NULL,
    unidad VARCHAR(60),
    costo NUMERIC(12,2),
    fecha_aplicacion TIMESTAMP NOT NULL,
    observaciones VARCHAR(500),
    editable_hasta TIMESTAMP,
    deleted_at TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS recomendaciones (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    cultivo_id UUID NOT NULL REFERENCES cultivos(id),
    usuario_id UUID NOT NULL REFERENCES users(id),
    tipo VARCHAR(80) NOT NULL,
    prioridad VARCHAR(20) NOT NULL,
    titulo VARCHAR(150),
    justificacion VARCHAR(2000) NOT NULL,
    estado VARCHAR(20) NOT NULL DEFAULT 'PENDIENTE',
    fecha_generacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_atencion TIMESTAMP,
    deleted_at TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS reportes (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    usuario_id UUID NOT NULL REFERENCES users(id),
    tipo VARCHAR(80) NOT NULL,
    periodo_inicio DATE,
    periodo_fin DATE,
    formato VARCHAR(20) NOT NULL DEFAULT 'JSON',
    estado VARCHAR(20) NOT NULL DEFAULT 'LISTO',
    url_archivo VARCHAR(500),
    resumen VARCHAR(2000),
    deleted_at TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS notificaciones (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    usuario_id UUID NOT NULL REFERENCES users(id),
    tipo VARCHAR(80) NOT NULL,
    mensaje VARCHAR(2000) NOT NULL,
    leida BOOLEAN NOT NULL DEFAULT FALSE,
    fecha TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP
);

CREATE INDEX IF NOT EXISTS idx_perfil_usuario_id ON perfil(usuario_id);
CREATE INDEX IF NOT EXISTS idx_insumos_activo ON insumos(activo);
CREATE INDEX IF NOT EXISTS idx_aplicaciones_cultivo_id ON aplicaciones_insumo(cultivo_id);
CREATE INDEX IF NOT EXISTS idx_recomendaciones_cultivo_estado ON recomendaciones(cultivo_id, estado);
CREATE INDEX IF NOT EXISTS idx_reportes_usuario_id ON reportes(usuario_id);
CREATE INDEX IF NOT EXISTS idx_notificaciones_usuario_id ON notificaciones(usuario_id);