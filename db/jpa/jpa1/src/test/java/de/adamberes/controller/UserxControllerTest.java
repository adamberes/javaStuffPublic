package de.jpah2.controller;

import de.adamberes.JpaH2Application;
import de.adamberes.controller.UserxController;
import de.adamberes.entities.Userx;
import de.adamberes.repository.UserxRepositoryJpa;
import de.adamberes.service.UserxService;
import jakarta.activation.DataSource;
import jakarta.persistence.EntityManager;
import org.h2.engine.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = JpaH2Application.class)
@Configuration
@EnableJpaRepositories(basePackages = "de.adamberes.repository")
@EntityScan(basePackages = "de.adamberes.entities")
@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserxControllerTest {

    //@Autowired private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private EntityManager entityManager;
    @Autowired private UserxRepositoryJpa userxRepositoryJpa;


    @Autowired
    private UserxService userxService;

    @BeforeEach
    public void setUp() {
        // initialize mock objects
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnExpectedUser() {

        Userx expectedUser = new Userx();
        expectedUser.setName("John Doe");

        Userx userx = userxService.getUsers().get(0);
        OngoingStubbing<Userx> userxOngoingStubbing = when(userxService.saveUserx(expectedUser)).thenReturn(expectedUser);

        //when(userxService.findByName("John Doe")).thenReturn(expectedUser);

        //User actualUser = userxController.getUserByName("John Doe");

        //assertEquals(expectedUser, actualUser);
        //verify(userService).findByName("John Doe");
    }
}
