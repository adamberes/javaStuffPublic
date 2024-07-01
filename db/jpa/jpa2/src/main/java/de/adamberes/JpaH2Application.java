package de.adamberes;

import de.adamberes.controller.UserxController;
import de.adamberes.service.UserxService;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@SpringBootApplication
@EnableJpaRepositories("de.adamberes.repository")
public class JpaH2Application {

    @Autowired
    ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(JpaH2Application.class, args);
    }
    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            System.out.println("Load Datasource: " + applicationContext.getBean("dataSource", DataSource.class));
            System.out.println("Load EntityManagerFactory: " + applicationContext.getBean("entityManagerFactory", EntityManagerFactory.class));

        };
    }
}