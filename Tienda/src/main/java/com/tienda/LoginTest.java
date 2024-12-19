package com.tienda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    public void testLoginConUsuarioValido() {
        // Usar WebDriverManager para configurar automáticamente el ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Crear una nueva instancia de ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navegar a la página de login
        driver.get("https://qalab.bensg.com/store");

        // Localizar los campos de usuario y contraseña
        WebElement usuario = driver.findElement(By.id("username"));
        WebElement contraseña = driver.findElement(By.id("password"));

        // Ingresar las credenciales válidas
        usuario.sendKeys("usuarioValido");
        contraseña.sendKeys("claveValida");

        // Enviar el formulario de login
        WebElement botonLogin = driver.findElement(By.id("login-button"));
        botonLogin.click();

        // Verificar que se ha iniciado sesión correctamente
        WebElement paginaPrincipal = driver.findElement(By.id("main-page"));
        Assertions.assertTrue(paginaPrincipal.isDisplayed());

        // Cerrar el navegador
        driver.quit();
    }

    @Test
    public void testLoginConUsuarioInvalido() {
        // Usar WebDriverManager para configurar automáticamente el ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Crear una nueva instancia de ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navegar a la página de login
        driver.get("https://qalab.bensg.com/store");

        // Localizar los campos de usuario y contraseña
        WebElement usuario = driver.findElement(By.id("username"));
        WebElement contraseña = driver.findElement(By.id("password"));

        // Ingresar las credenciales inválidas
        usuario.sendKeys("usuarioInvalido");
        contraseña.sendKeys("claveInvalida");

        // Enviar el formulario de login
        WebElement botonLogin = driver.findElement(By.id("login-button"));
        botonLogin.click();

        // Verificar que no se ha accedido correctamente
        WebElement mensajeError = driver.findElement(By.id("error-message"));
        Assertions.assertTrue(mensajeError.isDisplayed());

        // Cerrar el navegador
        driver.quit();
    }
}
