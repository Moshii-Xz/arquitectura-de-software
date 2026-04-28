-- Tabla de roles
CREATE TABLE roles (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL UNIQUE,
  description TEXT
);

-- Tabla de permisos
CREATE TABLE permissions (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL UNIQUE,
  description TEXT
);

-- Tabla de relacion muchos a muchos entre roles y permisos
CREATE TABLE role_permissions (
  role_id INT NOT NULL,
  permission_id INT NOT NULL,
  PRIMARY KEY (role_id, permission_id),
  FOREIGN KEY (role_id) REFERENCES roles(id),
  FOREIGN KEY (permission_id) REFERENCES permissions(id)
);

-- Insertar roles iniciales
INSERT INTO roles (name, description) VALUES ('ROLE_ADMIN', 'Administrador del sistema');
INSERT INTO roles (name, description) VALUES ('ROLE_USER', 'Usuario estandar');
INSERT INTO roles (name, description) VALUES ('ROLE_FARMER', 'Agricultor');
