CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    documento VARCHAR(20) NOT NULL UNIQUE,
    nombres VARCHAR(120) NOT NULL,
    apellidos VARCHAR(120),
    telefono VARCHAR(20) NOT NULL,
    email VARCHAR(150),
    password_hash VARCHAR(255) NOT NULL,
    rol VARCHAR(50) NOT NULL DEFAULT 'PRODUCTOR',
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE cultivos (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    usuario_id UUID NOT NULL REFERENCES users(id),
    tipo_cultivo VARCHAR(80) NOT NULL,
    nombre_lote VARCHAR(150),
    area_hectareas NUMERIC(10,2) NOT NULL,
    variedad VARCHAR(120),
    fecha_siembra DATE NOT NULL,
    fecha_cosecha_estimada DATE,
    fecha_cosecha_real DATE,
    municipio VARCHAR(120),
    vereda VARCHAR(120),
    estado VARCHAR(20) NOT NULL DEFAULT 'ACTIVO',
    deleted_at TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE cultivo_observaciones (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    cultivo_id UUID NOT NULL REFERENCES cultivos(id),
    texto TEXT NOT NULL,
    tipo VARCHAR(60),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE cultivo_fotografias (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    cultivo_id UUID NOT NULL REFERENCES cultivos(id),
    url_local VARCHAR(500),
    url_remota VARCHAR(500),
    descripcion TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE cultivo_historial (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    cultivo_id UUID NOT NULL REFERENCES cultivos(id),
    campo_modificado VARCHAR(100),
    valor_anterior TEXT,
    valor_nuevo TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    creado_por UUID REFERENCES users(id)
);

CREATE INDEX idx_cultivos_usuario_estado ON cultivos(usuario_id, estado);
CREATE INDEX idx_cultivos_fecha_siembra ON cultivos(fecha_siembra);
CREATE INDEX idx_observaciones_cultivo_id ON cultivo_observaciones(cultivo_id);
CREATE INDEX idx_fotografias_cultivo_id ON cultivo_fotografias(cultivo_id);
CREATE INDEX idx_historial_cultivo_id ON cultivo_historial(cultivo_id);
