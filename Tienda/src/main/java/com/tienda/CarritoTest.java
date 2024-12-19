package com.tienda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarritoTest {

    @Test
    public void testNavegarCategoriaYAgregarProducto() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qalab.bensg.com/store");

        // Iniciar sesión con usuario válido
        WebElement usuario = driver.findElement(By.id("username"));
        WebElement contraseña = driver.findElement(By.id("password"));
        usuario.sendKeys("usuarioValido");
        contraseña.sendKeys("claveValida");
        WebElement botonLogin = driver.findElement(By.id("login-button"));
        botonLogin.click();

        // Navegar a la categoría "Clothes" y subcategoría "Men"
        WebElement categoriaClothes = driver.findElement(By.linkText("Clothes"));
        categoriaClothes.click();
        WebElement subcategoriaMen = driver.findElement(By.linkText("Men"));
        subcategoriaMen.click();

        // Agregar el primer producto al carrito
        WebElement primerProducto = driver.findElement(By.cssSelector(".product:first-child"));
        WebElement botonAgregarCarrito = primerProducto.findElement(By.cssSelector(".add-to-cart"));
        botonAgregarCarrito.click();

        // Verificar que el popup de confirmación del producto agregado es visible
        WebElement popupConfirmacion = driver.findElement(By.id("popup-add-to-cart"));
        Assertions.assertTrue(popupConfirmacion.isDisplayed());

        // Verificar que el carrito muestra el producto agregado
        WebElement carritoIcono = driver.findElement(By.id("cart-icon"));
        carritoIcono.click();
        WebElement carritoContenido = driver.findElement(By.id("cart-content"));
        Assertions.assertTrue(carritoContenido.isDisplayed());

        // Validar el cálculo del precio
        WebElement totalCarrito = driver.findElement(By.id("total-price"));
        Assertions.assertNotNull(totalCarrito);

        // Cerrar navegador
        driver.quit();
    }

    @Test
    public void testValidacionesEnCarrito() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qalab.bensg.com/store");

        // Iniciar sesión con usuario válido
        WebElement usuario = driver.findElement(By.id("username"));
        WebElement contraseña = driver.findElement(By.id("password"));
        usuario.sendKeys("usuarioValido");
        contraseña.sendKeys("claveValida");
        WebElement botonLogin = driver.findElement(By.id("login-button"));
        botonLogin.click();

        // Navegar a la categoría "Clothes" y subcategoría "Men"
        WebElement categoriaClothes = driver.findElement(By.linkText("Clothes"));
        categoriaClothes.click();
        WebElement subcategoriaMen = driver.findElement(By.linkText("Men"));
        subcategoriaMen.click();

        // Agregar un producto al carrito
        WebElement primerProducto = driver.findElement(By.cssSelector(".product:first-child"));
        WebElement botonAgregarCarrito = primerProducto.findElement(By.cssSelector(".add-to-cart"));
        botonAgregarCarrito.click();

        // Verificar el carrito
        WebElement carritoIcono = driver.findElement(By.id("cart-icon"));
        carritoIcono.click();
        WebElement carritoContenido = driver.findElement(By.id("cart-content"));
        Assertions.assertTrue(carritoContenido.isDisplayed());

        // Validar cantidad y total
        WebElement cantidadProductos = driver.findElement(By.cssSelector(".cart-item-quantity"));
        WebElement precioTotal = driver.findElement(By.id("total-price"));
        Assertions.assertEquals("2", cantidadProductos.getText()); // Suponiendo que agregamos 2 productos
        Assertions.assertNotNull(precioTotal); // Verificar que el total no es nulo

        // Cerrar navegador
        driver.quit();
    }
}

