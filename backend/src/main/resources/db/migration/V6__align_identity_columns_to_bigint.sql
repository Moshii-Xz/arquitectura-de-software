-- Alinear el esquema existente con las entidades JPA que usan Long/BigInteger.
-- Esta migracion corrige el desajuste entre SERIAL/INT y BIGINT sin alterar el historial previo.

ALTER TABLE role_permissions
    DROP CONSTRAINT IF EXISTS role_permissions_role_id_fkey;

ALTER TABLE role_permissions
    DROP CONSTRAINT IF EXISTS role_permissions_permission_id_fkey;

ALTER TABLE users
    DROP CONSTRAINT IF EXISTS users_role_id_fkey;

ALTER TABLE login_attempts
    DROP CONSTRAINT IF EXISTS login_attempts_user_id_fkey;

ALTER TABLE tokens
    DROP CONSTRAINT IF EXISTS tokens_user_id_fkey;

ALTER TABLE password_resets
    DROP CONSTRAINT IF EXISTS password_resets_user_id_fkey;

ALTER TABLE user_profiles
    DROP CONSTRAINT IF EXISTS user_profiles_user_id_fkey;

ALTER TABLE user_locations
    DROP CONSTRAINT IF EXISTS user_locations_user_id_fkey;

ALTER TABLE notification_preferences
    DROP CONSTRAINT IF EXISTS notification_preferences_user_id_fkey;

ALTER TABLE crops
    DROP CONSTRAINT IF EXISTS fk_crops_user;

ALTER TABLE crop_observations
    DROP CONSTRAINT IF EXISTS fk_observations_usuario;

ALTER TABLE crop_status_history
    DROP CONSTRAINT IF EXISTS fk_history_usuario;

ALTER TABLE role_permissions
    DROP CONSTRAINT IF EXISTS role_permissions_pkey;

ALTER TABLE roles
    DROP CONSTRAINT IF EXISTS roles_pkey;

ALTER TABLE permissions
    DROP CONSTRAINT IF EXISTS permissions_pkey;

ALTER TABLE users
    DROP CONSTRAINT IF EXISTS users_pkey;

ALTER TABLE login_attempts
    DROP CONSTRAINT IF EXISTS login_attempts_pkey;

ALTER TABLE tokens
    DROP CONSTRAINT IF EXISTS tokens_pkey;

ALTER TABLE password_resets
    DROP CONSTRAINT IF EXISTS password_resets_pkey;

ALTER TABLE user_profiles
    DROP CONSTRAINT IF EXISTS user_profiles_pkey;

ALTER TABLE user_locations
    DROP CONSTRAINT IF EXISTS user_locations_pkey;

ALTER TABLE notification_preferences
    DROP CONSTRAINT IF EXISTS notification_preferences_pkey;

ALTER TABLE roles
    ALTER COLUMN id TYPE BIGINT USING id::BIGINT;

ALTER TABLE permissions
    ALTER COLUMN id TYPE BIGINT USING id::BIGINT;

ALTER TABLE users
    ALTER COLUMN id TYPE BIGINT USING id::BIGINT,
    ALTER COLUMN role_id TYPE BIGINT USING role_id::BIGINT;

ALTER TABLE login_attempts
    ALTER COLUMN id TYPE BIGINT USING id::BIGINT,
    ALTER COLUMN user_id TYPE BIGINT USING user_id::BIGINT;

ALTER TABLE tokens
    ALTER COLUMN id TYPE BIGINT USING id::BIGINT,
    ALTER COLUMN user_id TYPE BIGINT USING user_id::BIGINT;

ALTER TABLE password_resets
    ALTER COLUMN id TYPE BIGINT USING id::BIGINT,
    ALTER COLUMN user_id TYPE BIGINT USING user_id::BIGINT;

ALTER TABLE user_profiles
    ALTER COLUMN id TYPE BIGINT USING id::BIGINT,
    ALTER COLUMN user_id TYPE BIGINT USING user_id::BIGINT;

ALTER TABLE user_locations
    ALTER COLUMN id TYPE BIGINT USING id::BIGINT,
    ALTER COLUMN user_id TYPE BIGINT USING user_id::BIGINT;

ALTER TABLE notification_preferences
    ALTER COLUMN id TYPE BIGINT USING id::BIGINT,
    ALTER COLUMN user_id TYPE BIGINT USING user_id::BIGINT;

ALTER TABLE role_permissions
    ALTER COLUMN role_id TYPE BIGINT USING role_id::BIGINT,
    ALTER COLUMN permission_id TYPE BIGINT USING permission_id::BIGINT;

ALTER TABLE roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);

ALTER TABLE permissions
    ADD CONSTRAINT permissions_pkey PRIMARY KEY (id);

ALTER TABLE users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);

ALTER TABLE login_attempts
    ADD CONSTRAINT login_attempts_pkey PRIMARY KEY (id);

ALTER TABLE tokens
    ADD CONSTRAINT tokens_pkey PRIMARY KEY (id);

ALTER TABLE password_resets
    ADD CONSTRAINT password_resets_pkey PRIMARY KEY (id);

ALTER TABLE user_profiles
    ADD CONSTRAINT user_profiles_pkey PRIMARY KEY (id);

ALTER TABLE user_locations
    ADD CONSTRAINT user_locations_pkey PRIMARY KEY (id);

ALTER TABLE notification_preferences
    ADD CONSTRAINT notification_preferences_pkey PRIMARY KEY (id);

ALTER TABLE role_permissions
    ADD CONSTRAINT role_permissions_pkey PRIMARY KEY (role_id, permission_id);

ALTER TABLE users
    ADD CONSTRAINT users_role_id_fkey FOREIGN KEY (role_id) REFERENCES roles(id);

ALTER TABLE login_attempts
    ADD CONSTRAINT login_attempts_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL;

ALTER TABLE tokens
    ADD CONSTRAINT tokens_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE password_resets
    ADD CONSTRAINT password_resets_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE user_profiles
    ADD CONSTRAINT user_profiles_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE user_locations
    ADD CONSTRAINT user_locations_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE notification_preferences
    ADD CONSTRAINT notification_preferences_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE role_permissions
    ADD CONSTRAINT role_permissions_role_id_fkey FOREIGN KEY (role_id) REFERENCES roles(id);

ALTER TABLE role_permissions
    ADD CONSTRAINT role_permissions_permission_id_fkey FOREIGN KEY (permission_id) REFERENCES permissions(id);

ALTER TABLE crops
    ADD CONSTRAINT fk_crops_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE crop_observations
    ADD CONSTRAINT fk_observations_usuario FOREIGN KEY (usuario_id) REFERENCES users(id) ON DELETE SET NULL;

ALTER TABLE crop_status_history
    ADD CONSTRAINT fk_history_usuario FOREIGN KEY (usuario_id) REFERENCES users(id) ON DELETE SET NULL;