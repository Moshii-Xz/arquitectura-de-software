-- Completa el esquema de usuarios con el campo que espera la entidad User.

ALTER TABLE users
    ADD COLUMN IF NOT EXISTS last_login_at TIMESTAMP;
