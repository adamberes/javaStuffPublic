/*
package de.jpah2.controller;

import de.adamberes.controller.UserxController;
import de.adamberes.entities.Userx;
import de.adamberes.service.UserxService;
import org.h2.engine.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserxControllerTest {
    @InjectMocks
    private UserxController userxController;

    @Mock
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

        when(userxService.findByName("John Doe")).thenReturn(expectedUser);

        User actualUser = userxController.getUserByName("John Doe");

        assertEquals(expectedUser, actualUser);
        verify(userService).findByName("John Doe");
    }
}*/
