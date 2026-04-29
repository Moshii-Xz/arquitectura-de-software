-- Completa el esquema de usuarios con el contador de intentos de login que espera la entidad User.

ALTER TABLE users
    ADD COLUMN IF NOT EXISTS login_attempts INTEGER;
