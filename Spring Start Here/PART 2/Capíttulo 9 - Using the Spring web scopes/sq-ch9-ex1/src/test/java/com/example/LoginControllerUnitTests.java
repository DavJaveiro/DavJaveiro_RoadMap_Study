package com.example;

import com.example.controllers.LoginController;
import com.example.model.LoginProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class LoginControllerUnitTests {

    /*We define the mock objects and inject them into the instance whose behavior we test*/
    @Mock
    private Model model;

    @Mock
    private LoginProcessor loginProcessor;

    @Mock
    private LoginController loginController;

    @BeforeEach
    void setup() {
        loginController = new LoginController(loginProcessor); // Passe o mock de LoginProcessor
    }

    @Test
    public void loginPostLoginSucceedsTest() {
        /*We control the LoginProcessor mock instance, telling it to return true when its method login() is called*/
        given(loginProcessor.login()).willReturn(true);
        String result = loginController.loginPost("username", "password", model);

        assertEquals("login.html", result);
        verify(model).addAttribute("message", "You are now logged in.");
    }

    @Test
    public void loginPostLoginFailsTest() {

        // Simula o comportamento do LoginProcessor para retornar true quando login() for chamado
        given(loginProcessor.login()).willReturn(false);

        // Chama o méthod loginPost e captura o resultado;
        String result = loginController.loginPost("username", "password", model);

        // verifica se a página retornada é esperada
        assertEquals("login.html", result);

        // Confirma se a mensagem correta foi adicionada ao modelo
        verify(model).addAttribute("message", "Login failed!");
    }
}
