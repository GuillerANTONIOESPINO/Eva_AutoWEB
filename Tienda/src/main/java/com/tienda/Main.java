package com.tienda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Main {
    public static void main(String[] args) {
        // Usar WebDriverManager para configurar el WebDriver
        WebDriverManager.chromedriver().setup();

        // Crear una nueva instancia de ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navegar a la página de la tienda
        driver.get("https://qalab.bensg.com/store");

        // Realizar las acciones de prueba
        System.out.println("Página cargada: " + driver.getTitle());

        // Cerrar el navegador
        driver.quit();
    }
}

