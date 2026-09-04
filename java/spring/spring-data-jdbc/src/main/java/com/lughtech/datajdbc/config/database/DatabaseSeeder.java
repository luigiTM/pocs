package com.lughtech.datajdbc.config.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseSeeder(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) {
        insertData();
    }

    public void insertData() {
        jdbcTemplate.execute("""
            INSERT INTO "product" ("name", "description", "price", "active")
            VALUES ('Notebook', 'Notebook Dell', 3500.00, TRUE)
        """);

        jdbcTemplate.execute("""
            INSERT INTO "product" ("name", "description", "price", "active")
            VALUES ('Mouse', 'Mouse sem fio', 120.00, TRUE)
        """);

        jdbcTemplate.execute("""
            INSERT INTO "product" ("name", "description", "price", "active")
            VALUES ('Monitor', 'Monitor 27"', 950.00, TRUE)
        """);

        jdbcTemplate.execute("""
            INSERT INTO "product" ("name", "description", "price", "active")
            VALUES ('Teclado', 'Teclado mecânico', 450.00, FALSE)
        """);
    }
}
