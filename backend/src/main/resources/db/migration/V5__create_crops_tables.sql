-- V5__create_crops_tables.sql
-- Tablas para el módulo de gestión de cultivos (Fase 3)

-- Tabla de cultivos
CREATE TABLE crops (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    tipo VARCHAR(100) NOT NULL,
    hectareas DECIMAL(10, 2) NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'PLANTADO',
    ubicacion_lat DECIMAL(10, 8),
    ubicacion_lng DECIMAL(11, 8),
    fecha_plantacion DATE NOT NULL,
    fecha_inicio_cosecha DATE,
    fecha_fin_cosecha DATE,
    descripcion TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,
    CONSTRAINT fk_crops_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT chk_hectareas_positive CHECK (hectareas > 0)
);

CREATE INDEX idx_crops_user_id ON crops(user_id);
CREATE INDEX idx_crops_status ON crops(status);
CREATE INDEX idx_crops_deleted_at ON crops(deleted_at);
CREATE INDEX idx_crops_fecha_plantacion ON crops(fecha_plantacion);

-- Tabla de observaciones de cultivos
CREATE TABLE crop_observations (
    id BIGSERIAL PRIMARY KEY,
    crop_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    texto TEXT NOT NULL,
    tipo_observacion VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_observations_crop FOREIGN KEY (crop_id) REFERENCES crops(id) ON DELETE CASCADE,
    CONSTRAINT fk_observations_usuario FOREIGN KEY (usuario_id) REFERENCES users(id) ON DELETE SET NULL
);

CREATE INDEX idx_observations_crop_id ON crop_observations(crop_id);
CREATE INDEX idx_observations_usuario_id ON crop_observations(usuario_id);
CREATE INDEX idx_observations_created_at ON crop_observations(created_at);

-- Tabla de fotos de cultivos
CREATE TABLE crop_photos (
    id BIGSERIAL PRIMARY KEY,
    crop_id BIGINT NOT NULL,
    path VARCHAR(500) NOT NULL,
    nombre_original VARCHAR(255),
    tamanio_bytes BIGINT,
    tipo_contenido VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_photos_crop FOREIGN KEY (crop_id) REFERENCES crops(id) ON DELETE CASCADE
);

CREATE INDEX idx_photos_crop_id ON crop_photos(crop_id);
CREATE INDEX idx_photos_created_at ON crop_photos(created_at);

-- Tabla de historial de cambios de estado (auditoria)
CREATE TABLE crop_status_history (
    id BIGSERIAL PRIMARY KEY,
    crop_id BIGINT NOT NULL,
    estado_anterior VARCHAR(50),
    estado_nuevo VARCHAR(50) NOT NULL,
    usuario_id BIGINT,
    fecha_cambio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    descripcion_cambio TEXT,
    CONSTRAINT fk_history_crop FOREIGN KEY (crop_id) REFERENCES crops(id) ON DELETE CASCADE,
    CONSTRAINT fk_history_usuario FOREIGN KEY (usuario_id) REFERENCES users(id) ON DELETE SET NULL
);

CREATE INDEX idx_status_history_crop_id ON crop_status_history(crop_id);
CREATE INDEX idx_status_history_fecha_cambio ON crop_status_history(fecha_cambio);
