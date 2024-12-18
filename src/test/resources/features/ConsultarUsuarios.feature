Feature: Consultar usuarios
  Como usuario de la API
  Quiero verificar que puedo obtener una lista de usuarios
  Para asegurar que los datos sean correctos

  Scenario: Consultar lista de usuarios
    Given que la API está disponible
    When obtengo los usuarios de la página 2
    Then la respuesta debe tener un código de estado 200
    And la respuesta debe contener una lista de usuarios
    And cada usuario debe tener los campos "id", "email", "first_name" y "last_name"
    And la estructura de cada usuario debe coincidir con el esquema JSON esperado