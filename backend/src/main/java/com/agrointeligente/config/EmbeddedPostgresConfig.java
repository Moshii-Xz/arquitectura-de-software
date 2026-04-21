package com.agrointeligente.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import io.zonky.test.db.postgres.embedded.EmbeddedPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("embedded")
public class EmbeddedPostgresConfig {

    @Bean(destroyMethod = "close")
    public EmbeddedPostgres embeddedPostgres() throws IOException, SQLException {
        EmbeddedPostgres postgres = EmbeddedPostgres.builder().start();
        initializeDatabase(postgres);
        return postgres;
    }

    @Bean
    @Primary
    public DataSource dataSource(EmbeddedPostgres embeddedPostgres) throws SQLException {
        return embeddedPostgres.getDatabase("agro_user", "agro_inteligente");
    }

    private void initializeDatabase(EmbeddedPostgres embeddedPostgres) throws SQLException {
        try (Connection connection = embeddedPostgres.getPostgresDatabase().getConnection();
                Statement statement = connection.createStatement()) {

            if (!roleExists(statement, "agro_user")) {
                statement.execute("CREATE ROLE agro_user LOGIN PASSWORD 'agro_password'");
            }
            if (!databaseExists(statement, "agro_inteligente")) {
                statement.execute("CREATE DATABASE agro_inteligente OWNER agro_user");
            }
        }
    }

    private boolean roleExists(Statement statement, String roleName) throws SQLException {
        try (ResultSet rs = statement.executeQuery(
                "SELECT 1 FROM pg_roles WHERE rolname = '" + roleName.replace("'", "''") + "'")) {
            return rs.next();
        }
    }

    private boolean databaseExists(Statement statement, String dbName) throws SQLException {
        try (ResultSet rs = statement.executeQuery(
                "SELECT 1 FROM pg_database WHERE datname = '" + dbName.replace("'", "''") + "'")) {
            return rs.next();
        }
    }
}
