package com.botwy.LetsEat.config;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Configuration
@Slf4j
public class AppConfiguration {

//    private String DBNAME = "postgres";
//    private String USERNAME = "postgres";
//    private String PASSWORD = "";
//    private String DRIVER = "org.postgresql.Driver";
//    private String MIGRATIONS_DIR = "migrations";
//
//    @Bean(destroyMethod = "close")
//    EmbeddedPostgres embeddedPostgres() throws IOException {
//        killPostgresProcess();
//
//        return EmbeddedPostgres.builder()
//                .setPort(9999)
//                .start();
//    }
//
//    @Bean
//    public DataSource dataSource() throws IOException {
//        return createDataSource();
//    }
//
    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setContextPath("/letseat");
        return factory;
    }

//    private DataSource createDataSource() throws IOException {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(DRIVER);
//        dataSource.setUrl(embeddedPostgres().getJdbcUrl(USERNAME, DBNAME));
//        dataSource.setUsername(USERNAME);
//        dataSource.setPassword(PASSWORD);
//
//        ArrayList<Resource> resources = new ArrayList<>();
//        resources.add(new ClassPathResource("schema.sql"));
//        resources.add(new ClassPathResource("data.sql"));
//
//        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(
//                resources.toArray(new Resource[0])
//        );
//
//        databasePopulator.execute(dataSource);
//
//        return dataSource;
//    }
//
//    private void killPostgresProcess() {
//        Runtime rt = Runtime.getRuntime();
//        try {
//            if (System.getProperty("os.name").toLowerCase().contains("windows"))
//                rt.exec("taskkill postgres.exe");
//            else
//                rt.exec("killall  postgres");
//        } catch (IOException e) {
//            log.error("exception was generated when trying to stop postgres embedded process");
//        }
//    }
}
