Feature: Product - Store

  @validarPrecio
  Scenario: Validación del precio de un producto
    Given estoy en la página de la tienda
    And me logueo con mi usuario "XXX" y clave "YYY"
    When navego a la categoria "Clothes" y subcategoria "Men"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el cálculo de precios en el carrito

  @loginInvalido
  Scenario: Login con credenciales inválidas
    Given estoy en la página de la tienda
    When me logueo con mi usuario "usuarioInvalido" y clave "claveInvalida"
    Then espero ver un mensaje de error indicando que las credenciales son incorrectas

  @categoriaInexistente
  Scenario: Navegar a una categoría inexistente
    Given estoy en la página de la tienda
    And me logueo con mi usuario "XXX" y clave "YYY"
    When navego a la categoría "Autos"
    Then espero ver un mensaje de error indicando que la categoría no existe
